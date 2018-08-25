package pe.ayni.aynicore.operacion.credito.service;

import java.math.BigDecimal;
import java.util.List;

import pe.ayni.aynicore.operacion.credito.dto.CuotaSimulacionAmortizacionDto;

public interface OperacionDetalleCronogramaService {

	List<CuotaSimulacionAmortizacionDto> calculateAmortizacionCuotas(Integer idCuenta, Integer nroCondicion,
			BigDecimal monto);

}
