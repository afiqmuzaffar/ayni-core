package pe.ayni.aynicore.persona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.service.PersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRest {
	
	@Autowired
	PersonaService personaService;
	
	@CrossOrigin
	@PostMapping("/persona/{idPersona}/direcciones")
	public DireccionDto addDireccion(@PathVariable Integer idPersona, @RequestBody DireccionDto direccionDto) {
		personaService.addDireccion(idPersona, direccionDto);
		return direccionDto;
	}
}
