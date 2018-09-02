package pe.ayni.aynicore.operacion.credito.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.ayni.aynicore.cliente.dto.ClienteDto;
import pe.ayni.aynicore.cliente.service.ClienteService;
import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.CreditoDto.Cliente;
import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCreditoDto;
import pe.ayni.aynicore.credito.service.CreditoService;
import pe.ayni.aynicore.credito.service.DetalleCreditoService;
import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.constraint.OperacionConstraint.TipoOperacion;
import pe.ayni.aynicore.operacion.credito.constraint.DesembolsoConstraint.TipoCuentaDesembolso;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCuotaDto;
import pe.ayni.aynicore.operacion.credito.dto.SimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionDetalleDto;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;
import pe.ayni.aynicore.operacion.dto.OperacionDto;
import pe.ayni.aynicore.operacion.service.DetalleOperacionService;
import pe.ayni.aynicore.operacion.service.OperacionService;

@Service
public class OperacionCreditoServiceImpl implements OperacionCreditoService {
	
	@Autowired
	CreditoService creditoService;
	
	@Autowired
	DetalleCreditoService detalleCreditoService;
	
	@Autowired
	OperacionService operacionService;
	
	@Autowired
	DetalleOperacionService detalleOperacionService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	DetalleOperacionCredito detalleOperacionCredito;
	
	@Override
	@Transactional
	public void createDesembolso(DesembolsoCreditoDto desembolsoCredito) {
		
		
		CreditoDto creditoDto = new CreditoDto(desembolsoCredito.getMontoDesembolso(), desembolsoCredito.getMoneda(),
				desembolsoCredito.getFrecuencia(), desembolsoCredito.getTem(), desembolsoCredito.getNroCuotas(),
				desembolsoCredito.getFechaDesembolso(), desembolsoCredito.getFechaPrimeraCuota(),
				desembolsoCredito.getUsuarioAprobador(), new Cliente(desembolsoCredito.getCliente().getId()),
				desembolsoCredito.getResponsableCuenta());
		creditoService.createCredito(creditoDto);

		Integer idOperacionRelacionada = null;
		OperacionDto operacionDto = new OperacionDto(desembolsoCredito.getMontoDesembolso(), desembolsoCredito.getMoneda(),
				desembolsoCredito.getUsuarioOperacion(), TipoOperacion.DESEMBOLSO_CRED.toString(),
				TipoOperacion.DESEMBOLSO_CRED.toString(), idOperacionRelacionada);
		
		List<DetalleOperacionDto> detallesOperacionDto = new ArrayList<>();
		
		// Detalle de la Operacion del Desembolso
		int nroDetalleDesembolso = 0;
		DetalleCreditoDto detalleDesembolsoDto = detalleCreditoService.findDetalleDesembolso(creditoDto.getIdCuenta());
		DetalleOperacionDto detalleOperacionDesembolsoDto = detalleOperacionService.buildDetalleOperacionDesembolso(detalleDesembolsoDto);
		detalleOperacionDesembolsoDto.setNroDetalle(nroDetalleDesembolso);
		detalleOperacionDesembolsoDto.setDebito(desembolsoCredito.getMontoDesembolso());
		detallesOperacionDto.add(detalleOperacionDesembolsoDto);
		
		// Detalle de la Operacion de la Contraparte
		int nroDetalleContraparte = 1;
		if (desembolsoCredito.getTipoCuentaDesembolso().equals(TipoCuentaDesembolso.CAJA.toString())) {
			DetalleOperacionDto detalleOperacionDto = detalleOperacionService.buildDetalleOperacion2(desembolsoCredito.getIdCuentaDesembolso(),
					nroDetalleContraparte, DebitoCredito.CREDITO);
			detalleOperacionDto.setCredito(desembolsoCredito.getMontoDesembolso());
			detallesOperacionDto.add(detalleOperacionDto);
		}
		operacionDto.setDetallesOperacion(detallesOperacionDto);
		operacionService.createOperacion(operacionDto);
		
	}

	@Override
	@Transactional
	public void buildReporteSolicitud(DesembolsoCreditoDto desembolsoCredito, OutputStream outStream) throws JRException {
		
		CreditoDto creditoDto = new CreditoDto(desembolsoCredito.getMontoDesembolso(),desembolsoCredito.getFrecuencia(),
				desembolsoCredito.getTem(), desembolsoCredito.getNroCuotas(),
				desembolsoCredito.getFechaDesembolso(), desembolsoCredito.getFechaPrimeraCuota());
		
		List<CuotaCreditoDto> cuotasCredito = creditoService.calculateCuotas(creditoDto)
																	.stream()
																	.filter(e -> (e.getNroCuota().intValue() > 0))
																	.collect(Collectors.toList()); 
		
		InputStream reportStream = this.getClass().getClassLoader().getResourceAsStream("Solicitud_Credito.jasper");
		
		Map<String,Object> params = new HashMap<>();
	    ClienteDto clienteDto = clienteService.findClienteById(desembolsoCredito.getCliente().getId());
		params.put("nroIdentificacion", clienteDto.getPersonaNatural().getNroIdentificacion());
	    params.put("nombre", clienteDto.getPersonaNatural().getNombre());
	    params.put("montoDesembolso", desembolsoCredito.getMontoDesembolso());
	    params.put("frecuencia", desembolsoCredito.getFrecuencia());
	    params.put("tem", desembolsoCredito.getTem());
	    params.put("nroCuotas", desembolsoCredito.getNroCuotas());
	    params.put("fechaDesembolso", desembolsoCredito.getFechaDesembolso());
		
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanArrayDataSource(cuotasCredito.toArray()));
	    
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    
	}

	@Override
	@Transactional
	public List<AmortizacionCuotaDto> calculateAmortizacion(SimulacionAmortizacionDto simulacionAmortizacion) {
		
		Integer nroCondicion = creditoService.getNroCondicionCredito(simulacionAmortizacion.getIdCuenta());
		return detalleCreditoService.calculateAmortizacionCuotas(simulacionAmortizacion.getIdCuenta(),
				nroCondicion, simulacionAmortizacion.getMontoAmortizacion());
		
	}

	@Override
	@Transactional
	public AmortizacionCreditoDto createAmortizacion(AmortizacionCreditoDto amortizacionCredito) {
		
		Integer nroCondicion = creditoService.getNroCondicionCredito(amortizacionCredito.getIdCuenta());
		List<AmortizacionDetalleDto> detalles = detalleCreditoService.calculateAmortizacionDetalleCredito(
				amortizacionCredito.getIdCuenta(), nroCondicion, amortizacionCredito.getMontoAmortizacion());
		
		creditoService.amortizarCredito(amortizacionCredito.getIdCuenta(), amortizacionCredito.getMontoAmortizacion());
		
		Integer idOperacionRelacionada = null;
		OperacionDto operacionDto = new OperacionDto(amortizacionCredito.getMontoAmortizacion(), amortizacionCredito.getMoneda(),
				amortizacionCredito.getUsuarioOperacion(), TipoOperacion.AMORTIZACION_CRED.toString(), 
				TipoOperacion.AMORTIZACION_CRED.toString(), idOperacionRelacionada);

		List<DetalleOperacionDto> detallesOperacion = detalleOperacionCredito.buildDetallesAmortizacion(amortizacionCredito, detalles);
		operacionDto.setDetallesOperacion(detallesOperacion);
		
		OperacionDto operacion = operacionService.createOperacion(operacionDto);
		
		AmortizacionCreditoDto amortizacion = buildAmortizacionCredito(operacion);
		return amortizacion;
	}

	private AmortizacionCreditoDto buildAmortizacionCredito(OperacionDto operacion) {
		AmortizacionCreditoDto amortizacion = new AmortizacionCreditoDto(operacion);
		return amortizacion;
	}
	

}
