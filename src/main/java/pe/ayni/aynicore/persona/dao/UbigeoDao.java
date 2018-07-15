package pe.ayni.aynicore.persona.dao;

import java.util.List;

import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Departamento;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Distrito;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Provincia;

public interface UbigeoDao {
	
	List<Departamento> findAllDepartamentos();
	List<Provincia> findAllProvinciasByCodDpto(String codDpto);
	List<Distrito> findAllDistritosByCodDptoAndCodProvincia(String codDpto, String codProvincia);
}
