package pe.ayni.aynicore.persona.service;

import java.util.List;

import pe.ayni.aynicore.persona.constraint.TelefonoConstraint.EstadoTelefono;
import pe.ayni.aynicore.persona.dto.TelefonoDto;
import pe.ayni.aynicore.persona.dto.TelefonoFormDto;
import pe.ayni.aynicore.persona.entity.Persona;
import pe.ayni.aynicore.persona.entity.Telefono;

public interface TelefonoService {
	TelefonoFormDto getTelefonoForm();

	void createTelefono(Integer idPersona, TelefonoDto telefonoDto);

	void deleteTelefono(Persona persona, Integer idTelefono);

	List<Telefono> findAllTelefonosByEstadoAndIdPersona(EstadoTelefono estado, Integer idPersona);

}
