package pe.ayni.aynicore.credito.service;

import java.math.BigDecimal;
import java.util.List;

import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;

public interface DetalleCronogramaCreditoService {

	DetalleCronogramaCreditoDto findDetalleDesembolsoCronogramaCredito(Integer idCuenta);

	List<CuotaCronogramaCreditoDto> findCuotasCronogramaByIdCuentaAndEstado(Integer idCuenta, Integer nroCondicion, String estado);

	List<DetalleCronogramaCreditoDto> findDetallesCronogramaWithSaldo(Integer idCuenta, Integer nroCondicion);

	void amortizarDetallesCronograma(Integer idCuenta, Integer nroCondicion, BigDecimal montoAmortizacion);

}
