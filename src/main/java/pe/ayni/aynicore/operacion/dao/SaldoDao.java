package pe.ayni.aynicore.operacion.dao;

import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.operacion.entity.Saldo;
import pe.ayni.aynicore.operacion.entity.Saldo.SaldoPk;

public interface SaldoDao {

	Saldo findByCuentaContableAndCuenta(CuentaContable cuentaContable, Cuenta cuenta);

	SaldoPk save(Saldo saldo);

}
