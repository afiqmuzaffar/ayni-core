package pe.ayni.aynicore.persona.service;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDto;

public interface PersonaNaturalService {
	
	void createPersonaNatural(PersonaNaturalDto personaNaturalDto);
	PersonaNaturalDto findPersonaNaturalById(Integer id);
	void updatePersonaNatural(PersonaNaturalDto personaNaturalDto);

}
