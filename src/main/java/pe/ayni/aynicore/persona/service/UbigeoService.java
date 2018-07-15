package pe.ayni.aynicore.persona.service;


import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Departamento;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Distrito;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Provincia;


public interface UbigeoService {
	
	ConfiguracionUbigeoDto getConfiguracionUbigeoDto();

	Departamento findDptoByIdUbigeo(Integer idUbigeoDpto);

	Provincia findProvinciaByIdUbigeo(Departamento departamento, Integer idUbigeoProvincia);

	Distrito findDistritoByIdUbigeo(Provincia provincia, Integer idUbigeoDistrito);
	
}
