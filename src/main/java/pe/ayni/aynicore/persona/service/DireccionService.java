package pe.ayni.aynicore.persona.service;

import pe.ayni.aynicore.persona.dto.DireccionDto;

public interface DireccionService {
	void createDireccion(Integer idPersona, DireccionDto direccionDto);

}
