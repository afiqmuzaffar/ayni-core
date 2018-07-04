package pe.ayni.aynicore.cliente.service;

import pe.ayni.aynicore.cliente.entity.PersonaNatural;

public interface PersonaNaturalService {
	
	void create(PersonaNatural personaNatural);
	void update(PersonaNatural personaNatural);
	PersonaNatural findById(Integer id);

}
