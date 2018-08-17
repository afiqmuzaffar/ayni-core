package pe.ayni.aynicore.credito.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.credito.entity.CuentaCredito;

@Repository
public class CreditoDaoImpl implements CreditoDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(CuentaCredito credito) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(credito);
	}

}
