package pe.ayni.aynicore.persona.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.persona.constraint.DireccionConstraint.EstadoDireccion;
import pe.ayni.aynicore.persona.constraint.DireccionConstraint.TipoDireccion;
import pe.ayni.aynicore.persona.constraint.DireccionConstraint.TipoLocalidad;
import pe.ayni.aynicore.persona.constraint.DireccionConstraint.TipoVia;
import pe.ayni.aynicore.persona.dao.DireccionDao;
import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Departamento;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Distrito;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Provincia;
import pe.ayni.aynicore.persona.entity.Direccion;
import pe.ayni.aynicore.persona.entity.Persona;
import pe.ayni.aynicore.persona.entity.Ubigeo;

@Service
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	DireccionDao direccionDao;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	UbigeoService ubigeoService;
	
	@Transactional
	@Override
	public void createDireccion(Integer idPersona, DireccionDto direccionDto) {

		Direccion direccion = buildEntityFrom(direccionDto);
		
		Departamento departamento =  ubigeoService.findDptoByIdUbigeo(direccionDto.getIdUbigeoDpto());
		Provincia provincia = ubigeoService.findProvinciaByIdUbigeo(departamento, direccionDto.getIdUbigeoProvincia());
		Distrito distrito = ubigeoService.findDistritoByIdUbigeo(provincia, direccionDto.getIdUbigeoDistrito());
		
		if (direccionDto.getIdUbigeo() != distrito.getId()) {
			//do something
		}
		direccion.setDistrito(distrito.getNombre());
		direccion.setProvincia(provincia.getNombre());
		direccion.setDepartamento(departamento.getNombre());

		Ubigeo ubigeo = new Ubigeo(); 
		ubigeo.setId(direccionDto.getIdUbigeo());
		direccion.setUbigeo(ubigeo);

		Persona persona = personaService.findPersonaById(idPersona);
		direccion.setPersona(persona);
		
		direccion.setFechaHoraInsercion(LocalDateTime.now());
		direccion.setEstado(EstadoDireccion.ACTIVO);
		direccion.setId(null);
		direccionDao.create(direccion);
		direccionDto.setId(direccion.getId());
		
	}
	
	@Transactional
	@Override
	public void deleteDireccion(Persona persona, Integer idDireccion) {
		Direccion direccion = direccionDao.findById(idDireccion);
		if (!direccion.getPersona().equals(persona)) {
			// TODO: do something
		}
		direccion.setEstado(EstadoDireccion.INACTIVO);
		direccion.setFechaHoraModificacion(LocalDateTime.now());
		direccionDao.update(direccion);
	}
	

	@Override
	public List<DireccionDto> findAllDireccionesByEstadoAndIdPersona(EstadoDireccion estado, Integer idPersona) {
		List<Direccion> direcciones = direccionDao.findAllByEstadoAndIdPersona(estado, idPersona);
		List<DireccionDto> direccionesDto = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		for (Direccion direccion:direcciones) {
			DireccionDto direccionDto = modelMapper.map(direccion, DireccionDto.class);
			direccionesDto.add(direccionDto);
		}
	    return direccionesDto;

	}

	private Direccion buildEntityFrom(DireccionDto direccionDto) {
		Direccion direccion = new Direccion();
		direccion.setTipo(TipoDireccion.valueOf(direccionDto.getTipo()));
		direccion.setTipoVia(direccionDto.getTipoVia()==null? null: TipoVia.valueOf(direccionDto.getTipoVia()));
		direccion.setNombreVia(direccionDto.getNombreVia()==null? null: direccionDto.getNombreVia().toUpperCase());
		direccion.setNumeroVia(direccionDto.getNumeroVia()==null? null: direccionDto.getNumeroVia().toUpperCase());
		direccion.setTipoLocalidad(direccionDto.getTipoLocalidad()==null? null : TipoLocalidad.valueOf(direccionDto.getTipoLocalidad()));
		direccion.setNombreLocalidad(direccionDto.getNombreLocalidad()==null? null : direccionDto.getNombreLocalidad().toUpperCase());
		direccion.setManzana(direccionDto.getManzana()==null? null: direccionDto.getManzana().toUpperCase());
		direccion.setLote(direccionDto.getLote()==null? null: direccionDto.getLote().toUpperCase());
		direccion.setInterior(direccionDto.getInterior()==null? null: direccionDto.getInterior().toUpperCase());
		direccion.setReferencia(direccionDto.getReferencia().toUpperCase());
		return direccion;
	}


}
