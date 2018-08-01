package pe.ayni.aynicore.seguridad.dao;

import pe.ayni.aynicore.seguridad.entity.Usuario;

public interface UsuarioDao {
	
	void create(Usuario usuario);

	Usuario findById(String usuario);
}
