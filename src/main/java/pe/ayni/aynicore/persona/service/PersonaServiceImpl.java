package pe.ayni.aynicore.persona.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.persona.dao.PersonaDao;
import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	DireccionService direccionService;
	
	@Autowired
	PersonaDao personaDao;
	
	@Transactional
	@Override
	public void addDireccion(Integer idPersona, DireccionDto direccionDto) {

		direccionService.createDireccion(idPersona, direccionDto);
	}
	
	@Transactional
	@Override
	public Persona findPersonaById(Integer id) {
		return personaDao.findById(id) ;
	}

}
