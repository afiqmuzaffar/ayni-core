package pe.ayni.aynicore.persona.service;

import java.util.List;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDto;
import pe.ayni.aynicore.persona.entity.PersonaNatural;

public interface PersonaNaturalService {
	
	void createPersonaNatural(PersonaNaturalDto personaNaturalDto);
	
	PersonaNaturalDto findPersonaNaturalById(Integer id);
	
	void updatePersonaNatural(PersonaNaturalDto personaNaturalDto);
	
	List<PersonaNaturalDto> findFirstNumberOfPersonasNaturales(int max);
	
	List<PersonaNaturalDto> findPersonasNaturalesBy(String by, String input);
	
	PersonaNatural findPersonaNaturalEntityById(Integer id);

	List<PersonaNaturalDto> findFirstNumberOfExtensionPersonasNaturales(int max);

	List<PersonaNaturalDto> findExtensionPersonasNaturalesBy(String by, String input);
	
	PersonaNaturalDto convertToDto (PersonaNatural personaNatural);

}
