package pe.ayni.aynicore.persona.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.entity.Persona;

@Repository
public class PersonaDaoImpl implements PersonaDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Persona findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Persona.class, id);
	}
}
