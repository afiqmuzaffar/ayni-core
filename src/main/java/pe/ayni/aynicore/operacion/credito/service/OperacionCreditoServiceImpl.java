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
import pe.ayni.aynicore.banco.dto.DetalleBancoDto;
import pe.ayni.aynicore.banco.service.BancoService;
import pe.ayni.aynicore.cliente.dto.ClienteDto;
import pe.ayni.aynicore.cliente.service.ClienteService;
import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCreditoDto;
import pe.ayni.aynicore.credito.service.CreditoService;
import pe.ayni.aynicore.credito.service.DetalleCreditoService;
import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.constraint.OperacionConstraint.TipoOperacion;
import pe.ayni.aynicore.operacion.credito.constraint.AmortizacionConstraint.TipoCuentaAmortizacion;
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
	
	@Autowired
	BancoService bancoService;
	
	
	@Override
	@Transactional
	public DesembolsoCreditoDto createDesembolso(DesembolsoCreditoDto desembolsoCredito) {
		
		CreditoDto credito = new CreditoDto(desembolsoCredito);
		credito = creditoService.createCredito(credito);

		Integer idOperacionRelacionada = null;
		OperacionDto operacionDto = new OperacionDto(credito.getMontoDesembolso(), credito.getMoneda(),
				desembolsoCredito.getOperacion().getUsuario(), TipoOperacion.DESEMBOLSO_CRED.toString(),
				TipoOperacion.DESEMBOLSO_CRED.toString(), idOperacionRelacionada);
		
		List<DetalleOperacionDto> detallesOperacionDto = new ArrayList<>();
		
		// Detalle de la Operacion del Desembolso
		int nroDetalleDesembolso = 0;
		DetalleCreditoDto detalleDesembolsoDto = detalleCreditoService.findDetalleDesembolso(credito.getIdCuenta());
		DetalleOperacionDto detalleOperacionDesembolsoDto = detalleOperacionService.buildDetalleOperacionDesembolso(detalleDesembolsoDto);
		detalleOperacionDesembolsoDto.setNroDetalle(nroDetalleDesembolso);
		detalleOperacionDesembolsoDto.setDebito(credito.getMontoDesembolso());
		detallesOperacionDto.add(detalleOperacionDesembolsoDto);
		
		// Detalle de la Operacion de la Contraparte
		int nroDetalleContraparte = 1;
		if (desembolsoCredito.getOperacion().getTipoCuentaDesembolso().equals(TipoCuentaDesembolso.CAJA.toString())) {
			DetalleOperacionDto detalleOperacionDto = detalleOperacionService.buildDetalleOperacion2(desembolsoCredito.getOperacion().getIdCuentaDesembolso(),
					nroDetalleContraparte, DebitoCredito.CREDITO);
			detalleOperacionDto.setCredito(credito.getMontoDesembolso());
			detallesOperacionDto.add(detalleOperacionDto);
		}
		operacionDto.setDetallesOperacion(detallesOperacionDto);
		OperacionDto operacion = operacionService.createOperacion(operacionDto);
		DesembolsoCreditoDto desembolso = buildDesembolsoCredito(credito, operacion);
		return desembolso;
		
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
	public AmortizacionCreditoDto createAmortizacion(AmortizacionCreditoDto amortizacion) {
		
		DetalleBancoDto detalleBanco = null;
		if (amortizacion.getOperacion().getTipoCuentaRecaudo().equals(TipoCuentaAmortizacion.BANCOS.toString())) {
			detalleBanco = bancoService.createDeposito(new DetalleBancoDto(amortizacion.getOperacion().getIdCuentaRecaudo(), 
					amortizacion.getDetalleBanco().getFechaOperacion(), amortizacion.getDetalleBanco().getNroOperacion(), 
					amortizacion.getDetalleBanco().getMontoOperacion()));
			amortizacion.getDetalleBanco().setId(detalleBanco.getId());
		}
		
		Integer nroCondicion = creditoService.getNroCondicionCredito(amortizacion.getIdCuenta());
		List<AmortizacionDetalleDto> detalles = detalleCreditoService.calculateAmortizacionDetalleCredito(
				amortizacion.getIdCuenta(), nroCondicion, amortizacion.getOperacion().getMonto());
		
		creditoService.amortizarCredito(amortizacion.getIdCuenta(), amortizacion.getOperacion().getMonto());
		
		Integer idOperacionRelacionada = null;
		OperacionDto operacionDto = new OperacionDto(amortizacion.getOperacion().getMonto(), amortizacion.getOperacion().getMoneda(),
				amortizacion.getOperacion().getUsuario(), TipoOperacion.AMORTIZACION_CRED.toString(), 
				TipoOperacion.AMORTIZACION_CRED.toString(), idOperacionRelacionada);

		List<DetalleOperacionDto> detallesOperacion = detalleOperacionCredito.buildDetallesAmortizacion(amortizacion, detalles);
		operacionDto.setDetallesOperacion(detallesOperacion);
		
		OperacionDto operacion = operacionService.createOperacion(operacionDto);
		ClienteDto cliente = clienteService.findClienteByIdCuentaCredito(amortizacion.getIdCuenta());
		
		AmortizacionCreditoDto amortizacionCredito = buildAmortizacionCredito(detalleBanco, operacion, cliente);
		return amortizacionCredito;
	}

	private AmortizacionCreditoDto buildAmortizacionCredito(DetalleBancoDto detalleBanco, OperacionDto operacion, ClienteDto cliente) {
		AmortizacionCreditoDto amortizacion = new AmortizacionCreditoDto(detalleBanco, operacion, cliente);
		return amortizacion;
	}
	
	private DesembolsoCreditoDto buildDesembolsoCredito(CreditoDto credito, OperacionDto operacion) {
		DesembolsoCreditoDto desembolso = new DesembolsoCreditoDto(credito, operacion);
		return desembolso;
	}
	
	@Override
	@Transactional
	public void buildReporteSolicitud(DesembolsoCreditoDto desembolsoCredito, OutputStream outStream) throws JRException {
		
		CreditoDto creditoDto = new CreditoDto(desembolsoCredito.getCredito().getMontoDesembolso(),desembolsoCredito.getCredito().getFrecuencia(),
				desembolsoCredito.getCredito().getTem(), desembolsoCredito.getCredito().getNroCuotas(),
				desembolsoCredito.getCredito().getFechaDesembolso(), desembolsoCredito.getCredito().getFechaPrimeraCuota());
		
		List<CuotaCreditoDto> cuotasCredito = creditoService.calculateCuotas(creditoDto)
																	.stream()
																	.filter(e -> (e.getNroCuota().intValue() > 0))
																	.collect(Collectors.toList()); 
		
		InputStream reportStream = this.getClass().getClassLoader().getResourceAsStream("Solicitud_Credito.jasper");
		
		Map<String,Object> params = new HashMap<>();
	    ClienteDto clienteDto = clienteService.findClienteById(desembolsoCredito.getCliente().getId());
		params.put("nroIdentificacion", clienteDto.getPersonaNatural().getNroIdentificacion());
	    params.put("nombre", clienteDto.getPersonaNatural().getNombre());
	    params.put("montoDesembolso", desembolsoCredito.getCredito().getMontoDesembolso());
	    params.put("frecuencia", desembolsoCredito.getCredito().getFrecuencia());
	    params.put("tem", desembolsoCredito.getCredito().getTem());
	    params.put("nroCuotas", desembolsoCredito.getCredito().getNroCuotas());
	    params.put("fechaDesembolso", desembolsoCredito.getCredito().getFechaDesembolso());
		
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanArrayDataSource(cuotasCredito.toArray()));
	    
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    
	}



	@Override
	@Transactional
	public DesembolsoCreditoDto findDesembolsoById(Integer id) {
		OperacionDto operacion = operacionService.findOperacionById(id);
		CreditoDto credito = creditoService.findCreditoById(operacion.getDetallesOperacion().stream().findFirst().get().getIdCuenta());
		return buildDesembolsoCredito(credito, operacion);
	}

}
