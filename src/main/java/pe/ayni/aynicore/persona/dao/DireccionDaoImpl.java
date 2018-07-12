package pe.ayni.aynicore.persona.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.entity.Direccion;

@Repository
public class DireccionDaoImpl implements DireccionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Direccion direccion) {
		Session session = sessionFactory.getCurrentSession();
		session.save(direccion);
	}

}
