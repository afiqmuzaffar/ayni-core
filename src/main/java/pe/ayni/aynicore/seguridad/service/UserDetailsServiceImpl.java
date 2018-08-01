package pe.ayni.aynicore.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import pe.ayni.aynicore.seguridad.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findUsuarioById(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		UserBuilder builder = null;
		builder = User.withUsername(usuario.getUsuario());
		builder.password(usuario.getClave()).roles("GENERICO");
		return builder.build();
		
	}
}
