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
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;
import pe.ayni.aynicore.credito.service.CreditoService;
import pe.ayni.aynicore.credito.service.DetalleCronogramaCreditoService;
import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.constraint.OperacionConstraint.TipoOperacion;
import pe.ayni.aynicore.operacion.credito.constraint.DesembolsoConstraint.ViaDesembolso;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;
import pe.ayni.aynicore.operacion.dto.OperacionDto;
import pe.ayni.aynicore.operacion.service.DetalleOperacionService;
import pe.ayni.aynicore.operacion.service.OperacionService;

@Service
public class OperacionCreditoServiceImpl implements OperacionCreditoService {
	
	@Autowired
	CreditoService creditoService;
	
	@Autowired
	DetalleCronogramaCreditoService detalleCronogramaCreditoService;
	
	@Autowired
	OperacionService operacionService;
	
	@Autowired
	DetalleOperacionService detalleOperacionService;
	
	@Autowired
	ClienteService clienteService;
	
	@Override
	@Transactional
	public void createDesembolso(DesembolsoCreditoDto desembolsoCreditoDto) {
		
		
		CreditoDto creditoDto = new CreditoDto(desembolsoCreditoDto.getMontoDesembolso(), desembolsoCreditoDto.getMoneda(),
				desembolsoCreditoDto.getFrecuencia(), desembolsoCreditoDto.getTem(), desembolsoCreditoDto.getNroCuotas(),
				desembolsoCreditoDto.getFechaDesembolso(), desembolsoCreditoDto.getFechaPrimeraCuota(),
				desembolsoCreditoDto.getUsuarioAprobador(), desembolsoCreditoDto.getIdCliente(),
				desembolsoCreditoDto.getIdResponsableCuenta());
		creditoService.createCredito(creditoDto);

		Integer idOperacionRelacionada = null;
		OperacionDto operacionDto = new OperacionDto(desembolsoCreditoDto.getMontoDesembolso(), desembolsoCreditoDto.getMoneda(),
				desembolsoCreditoDto.getUsuarioOperacion(), TipoOperacion.DESEMBOLSO_CRED.toString(),
				"DESEMBOLSO DE CREDITO", idOperacionRelacionada);
		
		List<DetalleOperacionDto> detallesOperacionDto = new ArrayList<>();
		
		// Detalle de la Operacion del Desembolso
		int nroDetalleDesembolso = 0;
		DetalleCronogramaCredito detalleDesembolsoCronogramaCredito = 
				detalleCronogramaCreditoService.findDetalleDesembolsoCronogramaCredito(creditoDto.getIdCuenta());
		DetalleOperacionDto detalleOperacionDesembolsoDto = 
				detalleOperacionService.getDetalleOperacionDesembolsoDto(detalleDesembolsoCronogramaCredito);
		detalleOperacionDesembolsoDto.setNroDetalle(nroDetalleDesembolso);
		detalleOperacionDesembolsoDto.setDebito(desembolsoCreditoDto.getMontoDesembolso());
		detallesOperacionDto.add(detalleOperacionDesembolsoDto);
		
		// Detalle de la Operacion de la Contraparte
		int nroDetalleContraparte = 1;
		if (desembolsoCreditoDto.getViaDesembolso().equals(ViaDesembolso.CAJA.toString())) {
			DetalleOperacionDto detalleOperacionDto = detalleOperacionService.getDetalleOperacionDto(desembolsoCreditoDto.getIdCuentaDesembolso(),
					nroDetalleContraparte, DebitoCredito.CREDITO);
			detalleOperacionDto.setCredito(desembolsoCreditoDto.getMontoDesembolso());
			detallesOperacionDto.add(detalleOperacionDto);
		}
		operacionDto.setDetallesOperacion(detallesOperacionDto);
		operacionService.createOperacion(operacionDto);
		
	}

	@Override
	@Transactional
	public void buildReporteSolicitud(DesembolsoCreditoDto desembolsoCreditoDto, OutputStream outStream) throws JRException {
		
		CreditoDto creditoDto = new CreditoDto(desembolsoCreditoDto.getMontoDesembolso(), desembolsoCreditoDto.getMoneda(),
				desembolsoCreditoDto.getFrecuencia(), desembolsoCreditoDto.getTem(), desembolsoCreditoDto.getNroCuotas(),
				desembolsoCreditoDto.getFechaDesembolso(), desembolsoCreditoDto.getFechaPrimeraCuota(),
				desembolsoCreditoDto.getUsuarioAprobador(), desembolsoCreditoDto.getIdCliente(),
				desembolsoCreditoDto.getIdResponsableCuenta());
		
		List<DetalleCronogramaCreditoDto> detallesCronograma = creditoService.getCalculoDetalleCronograma(creditoDto)
																	.stream()
																	.filter(e -> (e.getNroCuota().intValue() > 0))
																	.collect(Collectors.toList()); 
		
		InputStream reportStream = this.getClass().getClassLoader().getResourceAsStream("Solicitud_Credito.jasper");
		
		Map<String,Object> params = new HashMap<>();
	    ClienteDto clienteDto = clienteService.findClienteById(desembolsoCreditoDto.getIdCliente());
		params.put("nroIdentificacion", clienteDto.getPersonaNatural().getNroIdentificacion());
	    params.put("nombre", clienteDto.getPersonaNatural().getNombre());
	    params.put("montoDesembolso", desembolsoCreditoDto.getMontoDesembolso());
	    params.put("frecuencia", desembolsoCreditoDto.getFrecuencia());
	    params.put("tem", desembolsoCreditoDto.getTem());
	    params.put("nroCuotas", desembolsoCreditoDto.getNroCuotas());
	    params.put("fechaDesembolso", desembolsoCreditoDto.getFechaDesembolso());
		
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanArrayDataSource(detallesCronograma.toArray()));
	    
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    
	}
	
	
	
	/*
	 * public void createDesembolso(...) {
	 * 
	 * 		CreditoService::createCredito
	 * 			DetalleCronogramaCreditoService::createDetalleCronograma
	 * 
	 * 		OperacionService::createOperacion
	 * 			DetalleOperacionService::createDetalleOperacion
	 * 
	 * 			SaldoService::aplicarMovimiento
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public void createAmortizacion(...) {
	 * 
	 * 		CreditoService::amortizarCredito
	 * 			DetalleCronogramaCreditoService::amortizarDetalleCronograma
	 * 		
	 * 		OperacionService::createOperacion
	 * 			DetalleOperacionService::createDetalleOperacion
	 * 
	 * 			SaldoService::aplicarMovimiento
	 * }
	 * 
	 * public createExtornoAmortizacion(...) {
	 * 
	 * 		CreditoService::extornarAmortizacion
	 * 			DetalleCronogramaCreditoService::extornarAmortizacionDetalleCronograma
	 * 		
	 * 		OperacionService::createOperacion
	 * 			DetalleOperacionService::createDetalleOperacion
	 * 
	 * 			SaldoService::aplicarMovimiento
	 * 
	 * }
	 * 
	 * 
	 */
}
