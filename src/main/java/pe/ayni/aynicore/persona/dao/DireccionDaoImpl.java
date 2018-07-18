package pe.ayni.aynicore.persona.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.constraint.DireccionConstraint.EstadoDireccion;
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

	@Override
	public Direccion findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Direccion.class, id);
	}

	@Override
	public void update(Direccion direccion) {
		Session session = sessionFactory.getCurrentSession();
		session.update(direccion);
	}

	@Override
	public List<Direccion> findAllByEstadoAndIdPersona(EstadoDireccion estado, Integer idPersona) {
		
		Session session = sessionFactory.getCurrentSession();
		List<Direccion> direcciones = session.createQuery("SELECT a FROM Direccion a WHERE estado= :estado AND idPersona = :idPersona", Direccion.class)
										.setParameter("estado", estado)
										.setParameter("idPersona", idPersona)
										.getResultList();
		return direcciones;
	}

}
