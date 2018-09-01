package pe.ayni.aynicore.persona.service;

import java.util.List;

import pe.ayni.aynicore.persona.constraint.DireccionConstraint.EstadoDireccion;
import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.entity.Persona;

public interface DireccionService {
	void createDireccion(Integer idPersona, DireccionDto direccion);

	void deleteDireccion(Persona persona, Integer idDireccion);

	List<DireccionDto> findAllDireccionesByEstadoAndIdPersona(EstadoDireccion estado, Integer idPersona);


}
