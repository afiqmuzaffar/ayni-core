package pe.ayni.aynicore.cuenta.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.cuenta.entity.CuentaContable;

@Repository
public class CuentaContableDaoImpl implements CuentaContableDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public CuentaContable findByCta(String ctaContable) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(CuentaContable.class, ctaContable);
	}

}
