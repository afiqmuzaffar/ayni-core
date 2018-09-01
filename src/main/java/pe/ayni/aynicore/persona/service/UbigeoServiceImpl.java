package pe.ayni.aynicore.persona.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.persona.dao.UbigeoDao;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Departamento;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Distrito;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Provincia;

@Service
public class UbigeoServiceImpl implements UbigeoService{
	
	@Autowired
	UbigeoDao ubigeoDao;
	
	@Transactional
	@Override
	public ConfiguracionUbigeoDto getConfiguracionUbigeo() {
		ConfiguracionUbigeoDto ubigeo = ConfiguracionUbigeoDto.getInstance();
		if (ubigeo.getDepartamentos() == null) {
			List<Departamento> departamentos = ubigeoDao.findAllDepartamentos();
			for (Departamento dpto:departamentos) {
				List<Provincia> provincias = ubigeoDao.findAllProvinciasByCodDpto(dpto.getCodDpto());
				for (Provincia provincia:provincias) {
					List<Distrito> distritos = ubigeoDao.findAllDistritosByCodDptoAndCodProvincia(dpto.getCodDpto(), provincia.getCodProvincia());
					provincia.setDistritos(distritos);
				}
				dpto.setProvincias(provincias);
			}
			ubigeo.setDepartamentos(departamentos);
		}
		return ubigeo;
	}
	
	@Transactional
	@Override
	public Departamento findDptoByIdUbigeo(Integer idUbigeoDpto) {
		ConfiguracionUbigeoDto ubigeoDto = getConfiguracionUbigeo();
		Departamento departamento = ubigeoDto.getDepartamentos()
			.stream()
			.filter(dpto -> dpto.getId().equals(idUbigeoDpto))
			.findFirst()
			.get();
		
		return departamento;
	}
	
	@Transactional
	@Override
	public Provincia findProvinciaByIdUbigeo(Departamento departamento, Integer idUbigeoProvincia) {
		Provincia provincia = departamento.getProvincias()
				.stream()
				.filter(prov -> prov.getId().equals(idUbigeoProvincia))
				.findFirst()
				.get();

		return provincia;
	}
	
	@Transactional
	@Override
	public Distrito findDistritoByIdUbigeo(Provincia provincia, Integer idUbigeoDistrito) {
		Distrito distrito = provincia.getDistritos()
				.stream()
				.filter(dist -> dist.getId().equals(idUbigeoDistrito))
				.findFirst()
				.get();
		return distrito;
	}


}
