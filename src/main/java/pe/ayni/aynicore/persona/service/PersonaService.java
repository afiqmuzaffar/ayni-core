package pe.ayni.aynicore.persona.service;

import java.util.List;

import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.dto.TelefonoDto;
import pe.ayni.aynicore.persona.entity.Persona;

public interface PersonaService {
	
	void addDireccion(Integer idPersona, DireccionDto direccionDTO);
	Persona findPersonaById(Integer id);
	List<DireccionDto> findAllDireccionesByIdPersona(Integer idPersona);
	List<TelefonoDto> findAllTelefonosByIdPersona(Integer idPersona);
	
}
