package pe.ayni.aynicore.persona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto;
import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.dto.TelefonoDto;
import pe.ayni.aynicore.persona.dto.TelefonoFormDto;
import pe.ayni.aynicore.persona.service.PersonaService;
import pe.ayni.aynicore.persona.service.TelefonoService;
import pe.ayni.aynicore.persona.service.UbigeoService;

@RestController
@RequestMapping("/api/personas")
public class PersonaRest {
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	TelefonoService telefonoService;
	
	@Autowired
	UbigeoService ubigeoService;
	
	@CrossOrigin
	@PostMapping("/{idPersona}/direcciones")
	public DireccionDto addDireccion(@PathVariable Integer idPersona, @RequestBody DireccionDto direccion) {
		personaService.addDireccion(idPersona, direccion);
		return direccion;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/{idPersona}/direcciones/{idDireccion}")
	public void deleteDireccion(@PathVariable Integer idPersona, @PathVariable Integer idDireccion) {
		personaService.deleteDireccion(idPersona, idDireccion);
	}
	
	@CrossOrigin
	@RequestMapping("/{idPersona}/direcciones")
	public List<DireccionDto> findAllDireccionesByIdPersona(@PathVariable Integer idPersona) {
		List<DireccionDto> direcciones;
		direcciones = personaService.findAllDireccionesByIdPersona(idPersona);
		return direcciones;
	}
	
	@CrossOrigin
	@PostMapping("/{idPersona}/telefonos")
	public TelefonoDto addTelefono(@PathVariable Integer idPersona, @RequestBody TelefonoDto telefono) {
		personaService.addTelefono(idPersona, telefono);
		return telefono;
	}
	
	@CrossOrigin
	@DeleteMapping("/{idPersona}/telefonos/{idTelefono}")
	public void deleteTelefono(@PathVariable Integer idPersona, @PathVariable Integer idTelefono) {
		personaService.deleteTelefono(idPersona, idTelefono);
		//return "Telefono con id: " + idTelefono + " fue dado de baja";
	}
	
	@CrossOrigin
	@RequestMapping("/{idPersona}/telefonos")
	public List<TelefonoDto> findAllTelefonosByIdPersona (@PathVariable Integer idPersona) {
		List<TelefonoDto> telefonos;
		telefonos = personaService.findAllTelefonosByIdPersona(idPersona);
		return telefonos;
	}
	
	@CrossOrigin
	@RequestMapping("/{idPersona}/telefonos/form")
	public TelefonoFormDto getTelefonoForm(@PathVariable Integer idPersona) {
		return telefonoService.getTelefonoForm();
	}
	
	@CrossOrigin
	@GetMapping("/configuracion-ubigeo")
	public ConfiguracionUbigeoDto getConfiguracionUbigeo() {
		return ubigeoService.getConfiguracionUbigeo();
		
	}
}
