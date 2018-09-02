package pe.ayni.aynicore.operacion.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.operacion.entity.Saldo;
import pe.ayni.aynicore.operacion.entity.Saldo.SaldoPk;

@Repository
public class SaldoDaoImpl implements SaldoDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Saldo findByCuentaContableAndCuenta(CuentaContable cuentaContable, Cuenta cuenta) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(Saldo.class, new SaldoPk(cuentaContable, cuenta));
	}

	@Override
	public SaldoPk save(Saldo saldo) {
		Session session = sessionFactory.getCurrentSession();
		return  (SaldoPk)session.save(saldo);
	}

}
