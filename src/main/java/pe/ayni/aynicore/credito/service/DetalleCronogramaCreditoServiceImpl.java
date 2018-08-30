package pe.ayni.aynicore.credito.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.credito.constraint.CuotaCronogramaCreditoConstraint.EstadoCuota;
import pe.ayni.aynicore.credito.constraint.DetalleCronogramaCreditoConstraint.ConceptoCronograma;
import pe.ayni.aynicore.credito.dao.DetalleCronogramaCreditoDao;
import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;
import pe.ayni.aynicore.operacion.credito.dto.DetalleCronogramaSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.service.OperacionDetalleCronogramaService;

@Service
public class DetalleCronogramaCreditoServiceImpl implements DetalleCronogramaCreditoService {

	@Autowired
	DetalleCronogramaCreditoDao detalleCronogramaCreditoDao;
	
	@Autowired
	OperacionDetalleCronogramaService operacionDetalleCronogramaService; 
	
	@Override
	@Transactional
	public DetalleCronogramaCreditoDto findDetalleDesembolsoCronogramaCredito(Integer idCuenta) {

		DetalleCronogramaCredito detalleCronogramaCredito = detalleCronogramaCreditoDao.findIsDesembolso(idCuenta);
		return buildDtoFrom(detalleCronogramaCredito);
	}

	private DetalleCronogramaCreditoDto buildDtoFrom(DetalleCronogramaCredito detalleCronogramaCredito) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleCronogramaCreditoDto  detalleCronogramaCreditoDto = modelMapper.map(detalleCronogramaCredito, DetalleCronogramaCreditoDto.class);
		return detalleCronogramaCreditoDto;
	}

	@Override
	@Transactional
	public List<CuotaCronogramaCreditoDto> findCuotasCronogramaByIdCuentaAndEstado(Integer idCuenta, Integer nroCondicion, String estado) {
		
		if (!EstadoCuota.PENDIENTE.toString().equals(estado))
			return null;
		
		List<CuotaCronogramaCreditoDto> cuotasCrogramaCreditoDto = new ArrayList<>();
		List<DetalleCronogramaCredito> detallesCronogramaCredito = 
				detalleCronogramaCreditoDao.findByIdCuentaInCuotasPendientes(idCuenta, nroCondicion);
		
		Integer nroCuota = 0;
		CuotaCronogramaCreditoDto cuotaDto = null;
		for (DetalleCronogramaCredito detalleCronogramaCredito: detallesCronogramaCredito) {
			
			if (!detalleCronogramaCredito.getNroCuota().equals(nroCuota)) {
				CuotaCronogramaCreditoDto cuotaCronogramaCreditoDto = new CuotaCronogramaCreditoDto(idCuenta, detalleCronogramaCredito.getNroCuota(),
						detalleCronogramaCredito.getFechaVencimiento().toString(), detalleCronogramaCredito.getCapitalCredito());
				
				cuotaCronogramaCreditoDto.setMontoCuota(BigDecimal.ZERO);
				
				cuotasCrogramaCreditoDto.add(cuotaCronogramaCreditoDto);
				
				cuotaDto =  cuotaCronogramaCreditoDto;
			} 			
			
			ConceptoCronograma.getConceptoCronograma(detalleCronogramaCredito.getNroConcepto()).setMontoProgramado(cuotaDto,
					detalleCronogramaCredito.getMontoProgramado());
			
			ConceptoCronograma.getConceptoCronograma(detalleCronogramaCredito.getNroConcepto()).setMontoPagado(cuotaDto,
					detalleCronogramaCredito.getMontoPagado());
			
			cuotaDto.setMontoCuota(cuotaDto.getMontoCuota().add(detalleCronogramaCredito.getMontoProgramado()));
			
			nroCuota = detalleCronogramaCredito.getNroCuota();
		}
		
		return cuotasCrogramaCreditoDto;
	}

	@Override
	@Transactional
	public List<DetalleCronogramaCreditoDto> findDetallesCronogramaWithSaldo(Integer idCuenta, Integer nroCondicion) {
		
		List<DetalleCronogramaCreditoDto> detallesWithSaldoDto = new ArrayList<>();
		List<DetalleCronogramaCredito> detallesWithSaldo = detalleCronogramaCreditoDao.findWithSaldo(idCuenta, nroCondicion);
		
		for (DetalleCronogramaCredito detalleWithSaldo: detallesWithSaldo) {
			DetalleCronogramaCreditoDto detalleWithSaldoDto = buildDtoFrom(detalleWithSaldo);
			detallesWithSaldoDto.add(detalleWithSaldoDto);
		}
		 
		return detallesWithSaldoDto;
	}

	@Override
	@Transactional
	public void amortizarDetallesCronograma(Integer idCuenta, Integer nroCondicion, BigDecimal monto) {
		List<DetalleCronogramaSimulacionAmortizacionDto> detallesAmortizacion = operacionDetalleCronogramaService
				.calculateAmortizacionDetalleCronograma(idCuenta, nroCondicion, monto);
		for (DetalleCronogramaSimulacionAmortizacionDto detalle: detallesAmortizacion) {
			detalleCronogramaCreditoDao.updateMontoPagado(detalle.getId(), detalle.getMontoPagado().add(detalle.getMontoAmortizacion()));
		}
	}


}
