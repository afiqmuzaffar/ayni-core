package pe.ayni.aynicore.cliente.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.cliente.entity.PersonaNatural;

@Repository
public class PersonaNaturalDaoImpl implements PersonaNaturalDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(PersonaNatural personaNatural) {
		Session session = sessionFactory.getCurrentSession();
		session.save(personaNatural);
	}
	
	@Override
	public void update(PersonaNatural personaNatural) {
		Session session = sessionFactory.getCurrentSession();
		session.update(personaNatural);
	}

	@Override
	public PersonaNatural findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(PersonaNatural.class, id);
	}

	@Override
	public List<PersonaNatural> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<PersonaNatural> personas = session.createQuery("SELECT a FROM PersonaNatural", PersonaNatural.class).getResultList();
		return personas;
	}

	@Override
	public PersonaNatural findByNroDocumento(String nroDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaNatural> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
