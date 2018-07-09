package pe.ayni.aynicore.persona.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.log.Log;

import pe.ayni.aynicore.persona.constraint.Persona.TipoIdentificacion;
import pe.ayni.aynicore.persona.constraint.Persona.TipoPersona;
import pe.ayni.aynicore.persona.constraint.PersonaNatural.EstadoCivil;
import pe.ayni.aynicore.persona.constraint.PersonaNatural.Sexo;
import pe.ayni.aynicore.persona.dao.PersonaNaturalDao;
import pe.ayni.aynicore.persona.dto.PersonaNaturalDTO;
import pe.ayni.aynicore.persona.entity.PersonaNatural;

@Service
public class PersonaNaturalServiceImpl implements PersonaNaturalService {

	@Autowired
	PersonaNaturalDao personaNaturalDao;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	@Transactional
	public void create(PersonaNaturalDTO personaNaturalDTO) {
		
		
		PersonaNatural personaNatural = new PersonaNatural();
		
		personaNatural.setApellidoPaterno(personaNaturalDTO.getApellidoPaterno().toUpperCase());
		personaNatural.setApellidoMaterno(personaNaturalDTO.getApellidoMaterno().toUpperCase());
		personaNatural.setPrimerNombre(personaNaturalDTO.getPrimerNombre().toUpperCase());
		personaNatural.setSegundoNombre(personaNaturalDTO.getSegundoNombre().toUpperCase());
		String nombre = personaNaturalDTO.getApellidoPaterno() + " " + personaNaturalDTO.getApellidoMaterno() + " " + personaNaturalDTO.getPrimerNombre() + " " + personaNaturalDTO.getSegundoNombre(); 
		personaNatural.setNombre(nombre.toUpperCase());
		personaNatural.setSexo(Sexo.valueOf(personaNaturalDTO.getSexo()));
		personaNatural.setEstadoCivil(EstadoCivil.valueOf(personaNaturalDTO.getEstadoCivil()));
		
		logger.info(personaNaturalDTO.getFechaNacimiento());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNacimiento = LocalDate.parse(personaNaturalDTO.getFechaNacimiento(), formatter);
		personaNatural.setFechaNacimiento(fechaNacimiento);
		personaNatural.setTipoIdentificacion(TipoIdentificacion.valueOf(personaNaturalDTO.getTipoIdentificacion()));
		personaNatural.setNroIdentificacion(personaNaturalDTO.getNroIdentificacion());
		personaNatural.setTipoPersona(TipoPersona.PPNN);
		personaNatural.setId(null);
		personaNatural.setFechaRegistro(LocalDate.now());
		personaNatural.setFechaHoraInsercion(LocalDateTime.now());
		personaNaturalDao.create(personaNatural);
		
		personaNaturalDTO.setId(personaNatural.getId());
	}

	@Override
	@Transactional
	public void update(PersonaNatural personaNatural) {
		personaNatural.setFechaHoraInsercion(LocalDateTime.now()); //TODO
		personaNatural.setFechaHoraModificacion(LocalDateTime.now());
		personaNaturalDao.update(personaNatural);
	}
	
	@Transactional
	@Override
	public PersonaNatural findById(Integer id) {
		return personaNaturalDao.findById(id);
	}

}
