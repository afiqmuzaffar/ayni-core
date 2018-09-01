package pe.ayni.aynicore.persona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDto;
import pe.ayni.aynicore.persona.service.PersonaNaturalService;

@RestController
@RequestMapping("/api/personas-naturales")
public class PersonaNaturalRest {
	
	@Autowired
	PersonaNaturalService personaNaturalService;
	
	@CrossOrigin
	@PostMapping("")
	public PersonaNaturalDto createPersonaNatural(@RequestBody PersonaNaturalDto personaNatural) {
		personaNaturalService.createPersonaNatural(personaNatural);
		return personaNatural;
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public PersonaNaturalDto findPersonaNaturalById(@PathVariable Integer id) {
		return personaNaturalService.findPersonaNaturalById(id);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public PersonaNaturalDto updatePersonaNatural(@RequestBody PersonaNaturalDto personaNatural) {
		personaNaturalService.updatePersonaNatural(personaNatural);
		return personaNatural;
	}

	@CrossOrigin
	@GetMapping(path = "", params = "max")
	public List<PersonaNaturalDto> findFirstNumberOfPersonasNaturales(@RequestParam("max") int max ){
		return personaNaturalService.findFirstNumberOfPersonasNaturales(max);
	}
	
	@CrossOrigin
	@GetMapping(path = "", params = {"by", "input"})
	public List<PersonaNaturalDto> findPersonasNaturalesBy(@RequestParam("by") String by,@RequestParam("input") String input ){
		return personaNaturalService.findPersonasNaturalesBy(by, input);
	}
	
	@CrossOrigin
	@GetMapping(path = "/extension", params = "max")
	public List<PersonaNaturalDto> findFirstNumberOfExtensionPersonasNaturales(@RequestParam("max") int max) {
		return personaNaturalService.findFirstNumberOfExtensionPersonasNaturales(max);
	}
	
	@CrossOrigin
	@GetMapping(path = "/extension", params = {"by", "input"})
	public List<PersonaNaturalDto> findExtensionPersonasNaturalesBy(@RequestParam("by") String by,@RequestParam("input") String input ){
		return personaNaturalService.findExtensionPersonasNaturalesBy(by, input);
	}

}
