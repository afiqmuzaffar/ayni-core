package pe.ayni.aynicore.cuenta.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.cuenta.entity.Cuenta;

@Repository
public class CuentaDaoImpl implements CuentaDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Cuenta findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Cuenta.class, id);
	}
}
