package pe.ayni.aynicore.persona.service;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDTO;
import pe.ayni.aynicore.persona.entity.PersonaNatural;

public interface PersonaNaturalService {
	
	void create(PersonaNaturalDTO personaNatural);
	void update(PersonaNatural personaNatural);
	PersonaNatural findById(Integer id);

}
