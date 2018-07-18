package pe.ayni.aynicore.persona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.dto.TelefonoDto;
import pe.ayni.aynicore.persona.dto.TelefonoFormDto;
import pe.ayni.aynicore.persona.service.PersonaService;
import pe.ayni.aynicore.persona.service.TelefonoService;

@RestController
@RequestMapping("/api")
public class PersonaRest {
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	TelefonoService telefonoService;
	
	@CrossOrigin
	@PostMapping("/persona/{idPersona}/direcciones")
	public DireccionDto addDireccion(@PathVariable Integer idPersona, @RequestBody DireccionDto direccionDto) {
		personaService.addDireccion(idPersona, direccionDto);
		return direccionDto;
	}
	
	@CrossOrigin
	@RequestMapping("/persona/{idPersona}/direcciones")
	public List<DireccionDto> findAllDireccionesByIdPersona (@PathVariable Integer idPersona) {
		List<DireccionDto> direccionesDto;
		direccionesDto = personaService.findAllDireccionesByIdPersona(idPersona);
		return direccionesDto;
	}
	
	@CrossOrigin
	@PostMapping("/persona/{idPersona}/telefonos")
	public TelefonoDto addTelefono(@PathVariable Integer idPersona, @RequestBody TelefonoDto telefonoDto) {
		personaService.addTelefono(idPersona, telefonoDto);
		return telefonoDto;
	}
	
	@CrossOrigin
	@DeleteMapping("/persona/{idPersona}/telefonos/{idTelefono}")
	public void deleteTelefono(@PathVariable Integer idPersona, @PathVariable Integer idTelefono) {
		personaService.deleteTelefono(idPersona, idTelefono);
		//return "Telefono con id: " + idTelefono + " fue dado de baja";
	}
	
	@CrossOrigin
	@RequestMapping("/persona/{idPersona}/telefonos")
	public List<TelefonoDto> findAllTelefonosByIdPersona (@PathVariable Integer idPersona) {
		List<TelefonoDto> telefonosDto;
		telefonosDto = personaService.findAllTelefonosByIdPersona(idPersona);
		return telefonosDto;
	}
	
	@CrossOrigin
	@RequestMapping("/persona/{idPersona}/telefonos/form")
	public TelefonoFormDto getTelefonoForm(@PathVariable Integer idPersona) {
		return telefonoService.getTelefonoForm();
	}
}
