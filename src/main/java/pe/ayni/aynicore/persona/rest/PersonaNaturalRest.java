package pe.ayni.aynicore.persona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDTO;
import pe.ayni.aynicore.persona.service.PersonaNaturalService;

@RestController
@RequestMapping("/api")
public class PersonaNaturalRest {
	
	@Autowired
	PersonaNaturalService personaNaturalService;
	
	@CrossOrigin
	@PostMapping("/personas-naturales")
	public PersonaNaturalDTO createPersonaNatural(@RequestBody PersonaNaturalDTO personaNaturalDTO) {
		personaNaturalService.createPersonaNatural(personaNaturalDTO);
		return personaNaturalDTO;
	}

	@CrossOrigin
	@GetMapping("/personas-naturales/{id}")
	public PersonaNaturalDTO findPersonaNaturalById(@PathVariable Integer id) {
		return personaNaturalService.findPersonaNaturalById(id);
	}
	
	@CrossOrigin
	@PutMapping("/personas-naturales/{id}")
	public PersonaNaturalDTO updatePersonaNatural(@RequestBody PersonaNaturalDTO personaNaturalDTO) {
		personaNaturalService.updatePersonaNatural(personaNaturalDTO);
		return personaNaturalDTO;
	}
	


}
