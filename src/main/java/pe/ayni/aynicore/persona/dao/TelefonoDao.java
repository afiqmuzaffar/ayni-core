package pe.ayni.aynicore.persona.dao;

import java.util.List;

import pe.ayni.aynicore.persona.constraint.TelefonoConstraint.EstadoTelefono;
import pe.ayni.aynicore.persona.entity.Telefono;

public interface TelefonoDao {
	
	void create(Telefono telefono);

	void update(Telefono telefono);

	List<Telefono> findAllTelefonosByStatusAndIdPersona(EstadoTelefono estado, Integer idPersona);

	Telefono findById(Integer id);
}
