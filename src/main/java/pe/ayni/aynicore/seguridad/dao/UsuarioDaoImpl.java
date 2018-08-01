package pe.ayni.aynicore.seguridad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.seguridad.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}

	@Override
	public Usuario findById(String usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Usuario.class, usuario);
	}

}
