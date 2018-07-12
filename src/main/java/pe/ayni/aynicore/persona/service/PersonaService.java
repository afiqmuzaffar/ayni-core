package pe.ayni.aynicore.persona.service;

import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.entity.Persona;

public interface PersonaService {
	
	void addDireccion(Integer idPersona, DireccionDto direccionDTO);
	Persona findPersonaById(Integer id);
	
}
