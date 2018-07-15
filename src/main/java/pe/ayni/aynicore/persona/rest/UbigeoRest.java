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
public class UbigeoRest {
	
	@Autowired
	UbigeoService ubigeoService;
	
	@CrossOrigin
	@GetMapping("/configuracion/ubigeo")
	public ConfiguracionUbigeoDto getConfiguracionUbigeo() {
		
		return ubigeoService.getConfiguracionUbigeoDto();
		
	}
}
