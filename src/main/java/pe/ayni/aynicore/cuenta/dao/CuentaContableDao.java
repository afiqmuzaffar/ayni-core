package pe.ayni.aynicore.cuenta.dao;

import pe.ayni.aynicore.cuenta.entity.CuentaContable;

public interface CuentaContableDao {

	CuentaContable findByCta(String ctaContable);

}
