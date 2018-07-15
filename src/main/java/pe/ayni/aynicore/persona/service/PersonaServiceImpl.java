package pe.ayni.aynicore.persona.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.ayni.aynicore.persona.dao.PersonaDao;
import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.entity.Direccion;
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
	
	@Transactional
	@Override
	public List<DireccionDto> findAllDireccionesByIdPersona(Integer idPersona) {
		Persona persona = findPersonaById(idPersona);
		List<Direccion> direcciones = persona.getDirecciones();
		List<DireccionDto> direccionesDto = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		for (Direccion direccion:direcciones) {
			DireccionDto direccionDto = modelMapper.map(direccion, DireccionDto.class);
			direccionesDto.add(direccionDto);
		}
	    return direccionesDto;
	}
	

}
