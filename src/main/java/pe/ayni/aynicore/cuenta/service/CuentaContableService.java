package pe.ayni.aynicore.cuenta.service;

import pe.ayni.aynicore.cuenta.entity.CuentaContable;

public interface CuentaContableService {
	
	CuentaContable findCuentaContableByCta(String ctaContable);
}
