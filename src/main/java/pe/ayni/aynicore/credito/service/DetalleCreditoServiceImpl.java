package pe.ayni.aynicore.credito.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.credito.constraint.CuotaCreditoConstraint.EstadoCuota;
import pe.ayni.aynicore.credito.constraint.DetalleCreditoConstraint.ConceptoCuota;
import pe.ayni.aynicore.credito.dao.DetalleCreditoDao;
import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCreditoDto;
import pe.ayni.aynicore.credito.entity.DetalleCredito;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCuotaDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionDetalleDto;

@Service
public class DetalleCreditoServiceImpl implements DetalleCreditoService {

	@Autowired
	DetalleCreditoDao detalleCreditoDao;
	
	@Override
	@Transactional
	public DetalleCreditoDto findDetalleDesembolso(Integer idCuenta) {

		DetalleCredito detalleCredito = detalleCreditoDao.findDesembolso(idCuenta);
		return buildDtoFrom(detalleCredito);
	}

	private DetalleCreditoDto buildDtoFrom(DetalleCredito detalleCredito) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleCreditoDto  detalleCreditoDto = modelMapper.map(detalleCredito, DetalleCreditoDto.class);
		return detalleCreditoDto;
	}

	@Override
	@Transactional
	public List<CuotaCreditoDto> findCuotasByIdCuentaAndEstado(Integer idCuenta, Integer nroCondicion, String estado) {
		
		if (!EstadoCuota.PENDIENTE.toString().equals(estado))
			return null;
		
		List<CuotaCreditoDto> cuotasCredito = new ArrayList<>();
		List<DetalleCredito> detallesCredito = detalleCreditoDao.findByIdCuentaInCuotasPendientes(idCuenta, nroCondicion);
		
		Integer nroCuota = 0;
		CuotaCreditoDto cuota = null;
		for (DetalleCredito detalleCredito: detallesCredito) {
			
			if (!detalleCredito.getNroCuota().equals(nroCuota)) {
				CuotaCreditoDto cuotaCredito = new CuotaCreditoDto(idCuenta, detalleCredito.getNroCuota(),
						detalleCredito.getFechaVencimiento().toString(), detalleCredito.getCapitalCredito());
				
				cuotaCredito.setMontoCuota(BigDecimal.ZERO);
				
				cuotasCredito.add(cuotaCredito);
				
				cuota =  cuotaCredito;
			} 			
			
			ConceptoCuota.getConcepto(detalleCredito.getNroConcepto()).setMontoProgramado(cuota,detalleCredito.getMontoProgramado());
			
			ConceptoCuota.getConcepto(detalleCredito.getNroConcepto()).setMontoPagado(cuota,detalleCredito.getMontoPagado());
			
			cuota.setMontoCuota(cuota.getMontoCuota().add(detalleCredito.getMontoProgramado()));
			
			nroCuota = detalleCredito.getNroCuota();
		}
		
		return cuotasCredito;
	}

	@Override
	@Transactional
	public List<DetalleCreditoDto> findDetallesCreditoWithSaldo(Integer idCuenta, Integer nroCondicion) {
		
		List<DetalleCreditoDto> detallesWithSaldoDto = new ArrayList<>();
		List<DetalleCredito> detallesWithSaldo = detalleCreditoDao.findWithSaldo(idCuenta, nroCondicion);
		
		for (DetalleCredito detalleWithSaldo: detallesWithSaldo) {
			DetalleCreditoDto detalleWithSaldoDto = buildDtoFrom(detalleWithSaldo);
			detallesWithSaldoDto.add(detalleWithSaldoDto);
		}
		 
		return detallesWithSaldoDto;
	}

	@Override
	@Transactional
	public void amortizarDetallesCredito(Integer idCuenta, Integer nroCondicion, BigDecimal monto) {
		List<AmortizacionDetalleDto> detalles = calculateAmortizacionDetalleCredito(idCuenta, nroCondicion, monto);
		for (AmortizacionDetalleDto detalle: detalles) {
			detalleCreditoDao.updateMontoPagado(detalle.getId(), detalle.getMontoPagado().add(detalle.getMontoAmortizacion()));
		}
	}

	@Override
	@Transactional
	public DetalleCreditoDto findDetalleCreditoById(Integer id) {
		DetalleCredito detalleCredito = detalleCreditoDao.findById(id);
		return buildDtoFrom(detalleCredito);
	}
	
	@Override
	@Transactional
	public List<AmortizacionCuotaDto> calculateAmortizacionCuotas(Integer idCuenta,Integer nroCondicion, BigDecimal monto) {
		
		List<AmortizacionCuotaDto> amortizacionesCuotas = new ArrayList<>();
		
		List<CuotaCreditoDto> cuotasPendientes = findCuotasByIdCuentaAndEstado(idCuenta, nroCondicion, EstadoCuota.PENDIENTE.toString());
		
		List<AmortizacionDetalleDto> detalles = calculateAmortizacionDetalleCredito(idCuenta, nroCondicion, monto);
		
		Integer ultimoNroCuotaAmortizada = detalles.get(detalles.size() - 1).getNroCuota();
		
		for (CuotaCreditoDto cuotaPendiente: cuotasPendientes) {
			AmortizacionCuotaDto amortizacionCuota = new AmortizacionCuotaDto(cuotaPendiente);
			
			detalles
				.stream()
				.filter(e -> e.getNroCuota().equals(cuotaPendiente.getNroCuota()))
				.forEach(e -> ConceptoCuota.getConcepto(e.getNroConcepto())
								.setMontoAmortizacion(amortizacionCuota, e.getMontoAmortizacion()));

			amortizacionesCuotas.add(amortizacionCuota);
			if (cuotaPendiente.getNroCuota().equals(ultimoNroCuotaAmortizada))
				break;
		}
		
		return amortizacionesCuotas;
	}

	@Override
	@Transactional
	public List<AmortizacionDetalleDto> calculateAmortizacionDetalleCredito(Integer idCuenta, Integer nroCondicion, BigDecimal monto) {
		
		List<AmortizacionDetalleDto> detalles = new ArrayList<>();
		
		List<DetalleCreditoDto> detallesCreditoPendientes = findDetallesCreditoWithSaldo(idCuenta, nroCondicion);
		
		for (DetalleCreditoDto detallePendiente: detallesCreditoPendientes) {
			AmortizacionDetalleDto detalle = new AmortizacionDetalleDto(detallePendiente);
			BigDecimal saldoDetalle = detallePendiente.getMontoProgramado().subtract(detallePendiente.getMontoPagado());
			BigDecimal montoAmortizacion;
			if (monto.compareTo(saldoDetalle) > 0) {
				montoAmortizacion = saldoDetalle;
			}else {
				montoAmortizacion = monto;
			}
			monto = monto.subtract(montoAmortizacion);
			detalle.setMontoAmortizacion(montoAmortizacion);
			detalles.add(detalle);
			if (monto.compareTo(BigDecimal.ZERO) == 0) 
				break;
		}
		
		return detalles;
	}
}
