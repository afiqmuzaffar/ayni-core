package pe.ayni.aynicore.persona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto;
import pe.ayni.aynicore.persona.service.UbigeoService;

@RestController
@RequestMapping("/api")
public class DemoRest {
	
	@Autowired
	UbigeoService ubigeoService;
	
	@GetMapping("/demo")
	public ConfiguracionUbigeoDto demo() {
		return ubigeoService.getConfiguracionUbigeoDto();
		
	}
	
	@CrossOrigin
	@GetMapping("/login")
	public Usuario getUsuario() {
		return new Usuario("SuperUsuario");
		
	}
	
	public class Usuario {
		private String usuario;
		
		public Usuario(String usuario) {
			this.usuario = usuario;
		}
		
		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		
	}
}
