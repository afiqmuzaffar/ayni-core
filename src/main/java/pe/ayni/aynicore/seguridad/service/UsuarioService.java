package pe.ayni.aynicore.seguridad.service;

import pe.ayni.aynicore.seguridad.entity.Usuario;

public interface UsuarioService {
	
	void createUsuario(Usuario usuario);  // TODO replace it to DTO

	Usuario findUsuarioById(String usuario);
	
}
