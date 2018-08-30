package pe.ayni.aynicore.operacion.credito.service;

import java.math.BigDecimal;
import java.util.List;

import pe.ayni.aynicore.operacion.credito.dto.CuotaSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DetalleCronogramaSimulacionAmortizacionDto;

public interface OperacionDetalleCronogramaService {

	List<CuotaSimulacionAmortizacionDto> calculateAmortizacionCuotas(Integer idCuenta, Integer nroCondicion,
			BigDecimal monto);
	
	List<DetalleCronogramaSimulacionAmortizacionDto> calculateAmortizacionDetalleCronograma(Integer idCuenta,
			Integer nroCondicion, BigDecimal monto);

}
