package pe.ayni.aynicore.persona.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.entity.Telefono;

@Repository
public class TelefonoDaoImpl implements TelefonoDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void create(Telefono telefono) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(telefono);
	}

}
