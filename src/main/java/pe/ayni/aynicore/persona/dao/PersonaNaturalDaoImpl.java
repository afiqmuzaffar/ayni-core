package pe.ayni.aynicore.persona.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.entity.PersonaNatural;

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
		List<PersonaNatural> personasNaturales = session.createQuery("SELECT a FROM PersonaNatural a", PersonaNatural.class).getResultList();
		return personasNaturales;
	}

	@Override
	public List<PersonaNatural> findFirstNumberOf(int max) {
		Session session = sessionFactory.getCurrentSession();
		List<PersonaNatural> personasNaturales = session.createQuery("SELECT a FROM PersonaNatural a", PersonaNatural.class).setMaxResults(max).getResultList();
		return personasNaturales;
	}

	@Override
	public List<PersonaNatural> findBy(String by, String input) {
		Session session = sessionFactory.getCurrentSession();
		String stringQuery = "SELECT a FROM PersonaNatural a ";
		if (by.toUpperCase().equals("DNI")) {
			stringQuery += "WHERE a.tipoIdentificacion = 'DNI' and a.nroIdentificacion =:input";
		} else if (by.toUpperCase().equals("NOMBRE")) {
			input = input.toUpperCase() + "%";
			stringQuery += "WHERE a.nombre LIKE :input";
		}
		
		List<PersonaNatural> personasNaturales = session.createQuery(stringQuery, PersonaNatural.class)
				.setMaxResults(100)
				.setParameter("input", input)
				.getResultList();

		return personasNaturales;
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
