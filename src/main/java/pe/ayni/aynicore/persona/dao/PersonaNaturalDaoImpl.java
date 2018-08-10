package pe.ayni.aynicore.persona.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDto;
import pe.ayni.aynicore.cliente.entity.Cliente;
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
	public List<PersonaNaturalDto> findFirstNumberOfExtension(int max) {
		List<PersonaNaturalDto> personasNaturalesDto = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT p, (SELECT c FROM Cliente c WHERE c.personaNatural.id = p.id) FROM PersonaNatural p");
		query.setMaxResults(max);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		for (Object[] line:list) {
			PersonaNatural ppnn = (PersonaNatural) line[0];
			Cliente cliente = (Cliente) line[1];
			PersonaNaturalDto personaNaturalDto = convertToDto(ppnn);
			if (cliente !=null) {
				personaNaturalDto.setIdCliente(cliente.getId());
				personaNaturalDto.setEsCliente(true);
			} else {
				personaNaturalDto.setIdCliente(null);
				personaNaturalDto.setEsCliente(false);
			}
			personasNaturalesDto.add(personaNaturalDto);
		}
		return personasNaturalesDto;
	}

	@Override
	public List<PersonaNaturalDto> findExtensionBy(String by, String input) {
		List<PersonaNaturalDto> personasNaturalesDto = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		String stringQuery = "SELECT p, (SELECT c FROM Cliente c WHERE c.personaNatural.id = p.id) FROM PersonaNatural p ";
		if (by.toUpperCase().equals("DNI")) {
			stringQuery += "WHERE p.tipoIdentificacion = 'DNI' and p.nroIdentificacion =:input";
		} else if (by.toUpperCase().equals("NOMBRE")) {
			input = input.toUpperCase() + "%";
			stringQuery += "WHERE p.nombre LIKE :input";
		}
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = session.createQuery(stringQuery)
				.setMaxResults(100)
				.setParameter("input", input)
				.getResultList();
		
		for (Object[] line:list) {
			PersonaNatural ppnn = (PersonaNatural) line[0];
			Cliente cliente = (Cliente) line[1];
			PersonaNaturalDto personaNaturalDto = convertToDto(ppnn);
			if (cliente !=null) {
				personaNaturalDto.setIdCliente(cliente.getId());
				personaNaturalDto.setEsCliente(true);
			} else {
				personaNaturalDto.setIdCliente(null);
				personaNaturalDto.setEsCliente(false);
			}
			personasNaturalesDto.add(personaNaturalDto);
		}
		return personasNaturalesDto;
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
	
	// TODO Refactor this method and its location
	private PersonaNaturalDto convertToDto(PersonaNatural personaNatural) {
		
		ModelMapper modelMapper = new ModelMapper();
		PersonaNaturalDto  personaNaturalDTO = modelMapper.map(personaNatural, PersonaNaturalDto.class);
		return personaNaturalDTO;
	}



}
