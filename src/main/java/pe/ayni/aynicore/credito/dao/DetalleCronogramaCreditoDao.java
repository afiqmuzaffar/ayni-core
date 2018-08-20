package pe.ayni.aynicore.credito.dao;

import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;

public interface DetalleCronogramaCreditoDao {

	DetalleCronogramaCredito findDesembolso(Integer idCuenta);

}
