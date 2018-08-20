package pe.ayni.aynicore.operacion.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.operacion.entity.Operacion;

@Repository
public class OperacionDaoImpl implements OperacionDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(Operacion operacion) {
		Session session = sessionFactory.getCurrentSession();
		session.save(operacion);
	}

}
