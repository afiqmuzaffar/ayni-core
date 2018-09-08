package pe.ayni.aynicore.cliente.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.cliente.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void create(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cliente); 
	}
	
	@Override
	public List<Cliente> findBy(String by, String input) {
		Session session = sessionFactory.getCurrentSession();
		String stringQuery = "SELECT a FROM Cliente a JOIN FETCH a.personaNatural ";
		
		if (by.toUpperCase().equals("DNI")) {
			stringQuery += "WHERE a.personaNatural.tipoIdentificacion = 'DNI' and a.personaNatural.nroIdentificacion =:input";
		} else if (by.toUpperCase().equals("NOMBRE")) {
			input = input.toUpperCase() + "%";
			stringQuery += "WHERE a.personaNatural.nombre LIKE :input";
		}
		
		List<Cliente> clientes = session.createQuery(stringQuery, Cliente.class)
				.setMaxResults(100)
				.setParameter("input", input)
				.getResultList();

		return clientes;
	}

	@Override
	public Cliente findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Cliente.class, id);
	}

	@Override
	public void update(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cliente);
	}
	
}
