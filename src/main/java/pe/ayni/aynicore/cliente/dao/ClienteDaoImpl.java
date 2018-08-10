package pe.ayni.aynicore.cliente.dao;

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

}
