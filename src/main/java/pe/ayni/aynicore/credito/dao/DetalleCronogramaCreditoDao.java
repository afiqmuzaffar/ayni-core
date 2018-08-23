package pe.ayni.aynicore.credito.dao;

import java.util.List;

import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;

public interface DetalleCronogramaCreditoDao {

	DetalleCronogramaCredito findDesembolso(Integer idCuenta);

	List<DetalleCronogramaCredito> findByIdCuentaInCuotasPendientes(Integer idCuenta, Integer nroCondicion);

}
