package pe.ayni.aynicore.persona.service;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDTO;

public interface PersonaNaturalService {
	
	void createPersonaNatural(PersonaNaturalDTO personaNaturalDTO);
	PersonaNaturalDTO findPersonaNaturalById(Integer id);
	void updatePersonaNatural(PersonaNaturalDTO personaNaturalDTO);

}
