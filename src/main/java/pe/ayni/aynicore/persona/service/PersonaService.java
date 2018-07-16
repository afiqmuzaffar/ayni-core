package pe.ayni.aynicore.persona.service;

import java.util.List;

import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.dto.TelefonoDto;
import pe.ayni.aynicore.persona.entity.Persona;

public interface PersonaService {
	
	Persona findPersonaById(Integer id);

	void addDireccion(Integer idPersona, DireccionDto direccionDTO);

	List<DireccionDto> findAllDireccionesByIdPersona(Integer idPersona);
	
	void addTelefono(Integer idPersona, TelefonoDto telefonoDto);
	
	List<TelefonoDto> findAllTelefonosByIdPersona(Integer idPersona);
	
}
