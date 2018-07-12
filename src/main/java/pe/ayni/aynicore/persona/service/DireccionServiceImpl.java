package pe.ayni.aynicore.persona.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.persona.constraint.Direccion.EstadoDireccion;
import pe.ayni.aynicore.persona.constraint.Direccion.TipoDireccion;
import pe.ayni.aynicore.persona.constraint.Direccion.TipoLocalidad;
import pe.ayni.aynicore.persona.constraint.Direccion.TipoVia;
import pe.ayni.aynicore.persona.dao.DireccionDao;
import pe.ayni.aynicore.persona.dto.DireccionDto;
import pe.ayni.aynicore.persona.entity.Direccion;
import pe.ayni.aynicore.persona.entity.Persona;
import pe.ayni.aynicore.persona.entity.Ubigeo;

@Service
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	DireccionDao direccionDao;
	
	@Autowired
	PersonaService personaService;
	
	@Transactional
	@Override
	public void createDireccion(Integer idPersona, DireccionDto direccionDto) {

		Direccion direccion = new Direccion();
		Persona persona = personaService.findPersonaById(idPersona);
		Ubigeo ubigeo = new Ubigeo();
		ubigeo.setId(1405);
		direccion.setUbigeo(ubigeo);
		direccion.setPersona(persona);
		mapDtotoEntity(direccionDto, direccion);
		direccion.setFechaHoraInsercion(LocalDateTime.now());
		direccion.setEstado(EstadoDireccion.ACTIVO);
		direccion.setId(null);
		direccionDao.create(direccion);
		direccionDto.setId(direccion.getId());
		
	}

	private void mapDtotoEntity(DireccionDto direccionDto, Direccion direccion) {
		direccion.setTipo(TipoDireccion.valueOf(direccionDto.getTipo()));
		direccion.setDepartamento(direccionDto.getDepartamento().toUpperCase());
		direccion.setProvincia(direccionDto.getProvincia().toUpperCase());
		direccion.setDistrito(direccionDto.getDistrito());
		direccion.setTipoVia(direccionDto.getTipoVia()==null? null: TipoVia.valueOf(direccionDto.getTipoVia()));
		direccion.setNombreVia(direccionDto.getNombreVia().toUpperCase());
		direccion.setNumeroVia(direccionDto.getNumeroVia().toUpperCase());
		direccion.setTipoLocalidad(direccionDto.getTipoLocalidad()==null? null : TipoLocalidad.valueOf(direccionDto.getTipoLocalidad()));
		direccion.setNombreLocalidad(direccionDto.getTipoLocalidad());
		direccion.setManzana(direccionDto.getManzana().toUpperCase());
		direccion.setLote(direccionDto.getLote().toUpperCase());
		direccion.setInterior(direccionDto.getInterior().toUpperCase());
		direccion.setReferencia(direccionDto.getReferencia().toUpperCase());
	}

}
