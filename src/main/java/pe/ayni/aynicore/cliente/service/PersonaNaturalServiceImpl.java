package pe.ayni.aynicore.cliente.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.cliente.dao.PersonaNaturalDao;
import pe.ayni.aynicore.cliente.entity.PersonaNatural;

@Service
public class PersonaNaturalServiceImpl implements PersonaNaturalService {

	@Autowired
	PersonaNaturalDao personaNaturalDao;
	
	@Override
	@Transactional
	public void create(PersonaNatural personaNatural) {
		personaNatural.setId(null);
		personaNatural.setFechaHoraInsercion(LocalDateTime.now());
		personaNaturalDao.create(personaNatural);
	}

	@Override
	@Transactional
	public void update(PersonaNatural personaNatural) {
		personaNatural.setFechaHoraInsercion(LocalDateTime.now()); //TODO
		personaNatural.setFechaHoraModificacion(LocalDateTime.now());
		personaNaturalDao.update(personaNatural);
	}
	
	@Transactional
	@Override
	public PersonaNatural findById(Integer id) {
		return personaNaturalDao.findById(id);
	}

}
