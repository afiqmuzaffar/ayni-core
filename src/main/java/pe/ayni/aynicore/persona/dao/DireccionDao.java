package pe.ayni.aynicore.persona.dao;

import java.util.List;

import pe.ayni.aynicore.persona.constraint.DireccionConstraint.EstadoDireccion;
import pe.ayni.aynicore.persona.entity.Direccion;

public interface DireccionDao {
	
	void create(Direccion direccion);

	Direccion findById(Integer id);

	void update(Direccion direccion);

	List<Direccion> findAllByEstadoAndIdPersona(EstadoDireccion estado, Integer idPersona);

}
