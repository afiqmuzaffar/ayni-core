package pe.ayni.aynicore.persona.service;

import pe.ayni.aynicore.persona.dto.TelefonoDto;
import pe.ayni.aynicore.persona.dto.TelefonoFormDto;

public interface TelefonoService {
	TelefonoFormDto getTelefonoForm();

	void createTelefono(Integer idPersona, TelefonoDto telefonoDto);

}
