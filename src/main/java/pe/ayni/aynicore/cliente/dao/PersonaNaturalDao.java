package pe.ayni.aynicore.cliente.dao;

import java.util.List;

import pe.ayni.aynicore.cliente.entity.PersonaNatural;

public interface PersonaNaturalDao {
	
	void create(PersonaNatural personaNatural);
	
	void update(PersonaNatural personaNatural);

	PersonaNatural findById(Integer id);
	
	List<PersonaNatural> findAll();
	
	PersonaNatural findByNroDocumento(String nroDocumento);
	
	List<PersonaNatural> findByNameLike(String name);
}
