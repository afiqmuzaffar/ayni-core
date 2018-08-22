package pe.ayni.aynicore.credito.dao;

import pe.ayni.aynicore.credito.entity.CuentaCredito;

public interface CreditoDao {

	void create(CuentaCredito credito);

	CuentaCredito findById(Integer idCuenta);

}
