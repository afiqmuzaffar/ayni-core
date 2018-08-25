package pe.ayni.aynicore.operacion.credito.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.credito.constraint.CuotaCronogramaCreditoConstraint.EstadoCuota;
import pe.ayni.aynicore.credito.constraint.DetalleCronogramaCreditoConstraint.ConceptoCronograma;
import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.credito.service.DetalleCronogramaCreditoService;
import pe.ayni.aynicore.operacion.credito.dto.CuotaSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DetalleCronogramaSimulacionAmortizacionDto;

@Service
public class OperacionDetalleCronogramaServiceImpl implements OperacionDetalleCronogramaService {
	
	@Autowired
	DetalleCronogramaCreditoService detalleCronogramaCreditoService;
	
	@Override
	@Transactional
	public List<CuotaSimulacionAmortizacionDto> calculateAmortizacionCuotas(Integer idCuenta,
			Integer nroCondicion, BigDecimal monto) {
		List<CuotaSimulacionAmortizacionDto> cuotasSimulacionAmortizacion = new ArrayList<>();
		
		List<CuotaCronogramaCreditoDto> cuotasPendientes = 
				detalleCronogramaCreditoService.findCuotasCronogramaByIdCuentaAndEstado(idCuenta, nroCondicion, EstadoCuota.PENDIENTE.toString());
		
		List<DetalleCronogramaSimulacionAmortizacionDto> detallesAmortizacion = calculateAmortizacionDetalleCronograma(idCuenta, nroCondicion, monto);
		
		Integer ultimoNroCuotaAmortizada = detallesAmortizacion.get(detallesAmortizacion.size() - 1).getNroCuota();
		
		for (CuotaCronogramaCreditoDto cuotaPendiente: cuotasPendientes) {
			CuotaSimulacionAmortizacionDto cuotaSimulacionAmortizacion = new CuotaSimulacionAmortizacionDto(cuotaPendiente);
			
			detallesAmortizacion
				.stream()
				.filter(e -> e.getNroCuota().equals(cuotaPendiente.getNroCuota()))
				.forEach(e -> ConceptoCronograma.getConceptoCronograma(e.getNroConcepto())
					.setMontoAmortizacion(cuotaSimulacionAmortizacion, e.getMontoAmortizacion()));

			cuotasSimulacionAmortizacion.add(cuotaSimulacionAmortizacion);
			if (cuotaPendiente.getNroCuota().equals(ultimoNroCuotaAmortizada))
				break;
		}
		
		return cuotasSimulacionAmortizacion;
	}
	
	@Transactional
	private List<DetalleCronogramaSimulacionAmortizacionDto> calculateAmortizacionDetalleCronograma(Integer idCuenta,
			Integer nroCondicion, BigDecimal monto) {
		List<DetalleCronogramaSimulacionAmortizacionDto> detallesCronogramaSimulacionAmortizacionDto = new ArrayList<>();
		List<DetalleCronogramaCreditoDto> detallesCronogramaPendientes = detalleCronogramaCreditoService.findDetallesCronogramaWithSaldo(idCuenta, nroCondicion);
		
		for (DetalleCronogramaCreditoDto detalleCronoPendiente: detallesCronogramaPendientes) {
			DetalleCronogramaSimulacionAmortizacionDto detalleCronoSimulacion = 
					new DetalleCronogramaSimulacionAmortizacionDto(detalleCronoPendiente);
			BigDecimal saldoDetalle = detalleCronoPendiente.getMontoProgramado().subtract(detalleCronoPendiente.getMontoPagado());
			BigDecimal montoAmortizacion;
			if (monto.compareTo(saldoDetalle) > 0) {
				montoAmortizacion = saldoDetalle;
			}else {
				montoAmortizacion = monto;
			}
			monto = monto.subtract(montoAmortizacion);
			detalleCronoSimulacion.setMontoAmortizacion(montoAmortizacion);
			detallesCronogramaSimulacionAmortizacionDto.add(detalleCronoSimulacion);
			if (monto.compareTo(BigDecimal.ZERO) == 0) 
				break;
		}
		
		return detallesCronogramaSimulacionAmortizacionDto;
	}

}
