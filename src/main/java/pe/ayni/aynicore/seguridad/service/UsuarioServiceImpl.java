package pe.ayni.aynicore.seguridad.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.seguridad.dao.UsuarioDao;
import pe.ayni.aynicore.seguridad.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	@Transactional
	public void createUsuario(Usuario usuario) {
		usuarioDao.create(usuario);
	}

	@Override
	@Transactional
	public Usuario findUsuarioById(String usuario) {
		return usuarioDao.findById(usuario);
	}

}
