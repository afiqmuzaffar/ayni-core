package pe.ayni.aynicore.persona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.entity.PersonaNatural;
import pe.ayni.aynicore.persona.service.PersonaNaturalService;

@RestController
@RequestMapping("/api")
public class PersonaNaturalRest {
	
	@Autowired
	PersonaNaturalService personaNaturalService;
	
	@PostMapping("/personas")
	public PersonaNatural create(@RequestBody PersonaNatural personaNatural) {
		personaNaturalService.create(personaNatural);
		return personaNatural;
	}
	
	@PutMapping("/personas")
	public PersonaNatural update(@RequestBody PersonaNatural personaNatural) {
		personaNaturalService.update(personaNatural);
		return personaNatural;
	}
	
	@GetMapping("/personas/{id}")
	public PersonaNatural findById(@PathVariable Integer id) {
		return personaNaturalService.findById(id);
	}

}
