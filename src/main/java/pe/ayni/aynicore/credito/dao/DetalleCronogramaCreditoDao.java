package pe.ayni.aynicore.credito.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;

public interface DetalleCronogramaCreditoDao {

	DetalleCronogramaCredito findIsDesembolso(Integer idCuenta);

	List<DetalleCronogramaCredito> findByIdCuentaInCuotasPendientes(Integer idCuenta, Integer nroCondicion);

	List<DetalleCronogramaCredito> findWithSaldo(Integer idCuenta, Integer nroCondicion);

	int updateMontoPagado(Integer id, BigDecimal montoAmortizacion);

}
