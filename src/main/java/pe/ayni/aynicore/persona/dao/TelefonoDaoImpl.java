package pe.ayni.aynicore.persona.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.constraint.TelefonoConstraint.EstadoTelefono;
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


	@Override
	public void update(Telefono telefono) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(telefono);
	}


	@Override
	public List<Telefono> findAllTelefonosByStatusAndIdPersona(EstadoTelefono estado, Integer idPersona) {

		Session session = sessionFactory.getCurrentSession();
		List<Telefono> telefonos = session.createQuery("SELECT a FROM Telefono a WHERE estado= :estado AND idPersona = :idPersona", Telefono.class)
										.setParameter("estado", estado)
										.setParameter("idPersona", idPersona)
										.getResultList();
		return telefonos;
		
	}


	@Override
	public Telefono findById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(Telefono.class, id);
	}
	
	
}
