package pe.ayni.aynicore.persona.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.persona.constraint.PersonaConstraint.TipoIdentificacion;
import pe.ayni.aynicore.persona.constraint.PersonaConstraint.TipoPersona;
import pe.ayni.aynicore.persona.constraint.PersonaNaturalConstraint.EstadoCivil;
import pe.ayni.aynicore.persona.constraint.PersonaNaturalConstraint.Sexo;
import pe.ayni.aynicore.persona.dao.PersonaNaturalDao;
import pe.ayni.aynicore.persona.dto.PersonaNaturalDto;
import pe.ayni.aynicore.persona.entity.PersonaNatural;

@Service
public class PersonaNaturalServiceImpl implements PersonaNaturalService {

	@Autowired
	PersonaNaturalDao personaNaturalDao;
	
	@Override
	@Transactional
	public void createPersonaNatural(PersonaNaturalDto personaNaturalDto) {
		PersonaNatural personaNatural = buildEntityFrom(personaNaturalDto);	
		personaNatural.setTipoPersona(TipoPersona.PPNN);
		personaNatural.setId(null);
		personaNatural.setFechaRegistro(LocalDate.now());
		personaNatural.setFechaHoraInsercion(LocalDateTime.now());

		personaNaturalDao.create(personaNatural);
		
		personaNaturalDto.setId(personaNatural.getId());
	}
	
	@Transactional
	@Override
	public PersonaNaturalDto findPersonaNaturalById(Integer id) {
		PersonaNatural personaNatural = personaNaturalDao.findById(id);
		PersonaNaturalDto personaNaturalDto = buildDtoFrom(personaNatural);
		return personaNaturalDto;
	}

	@Override
	@Transactional
	public void updatePersonaNatural(PersonaNaturalDto personaNaturalDto) {
		
		PersonaNatural personaNatural = personaNaturalDao.findById(personaNaturalDto.getId());
		setEntityDetails(personaNatural, personaNaturalDto);	
		personaNatural.setFechaHoraModificacion(LocalDateTime.now());
		personaNaturalDao.update(personaNatural);
	}
	
	@Transactional
	@Override
	public List<PersonaNaturalDto> findFirstNumberOfPersonasNaturales(int max) {
		List<PersonaNatural> personasNaturales = personaNaturalDao.findFirstNumberOf(max);
		List<PersonaNaturalDto> personasNaturalesDto = new ArrayList<>();
		for(PersonaNatural personaNatural:personasNaturales) {
			personasNaturalesDto.add(buildDtoFrom(personaNatural));
		}
		return personasNaturalesDto;
	}
	
	@Transactional
	@Override
	public List<PersonaNaturalDto> findPersonasNaturalesBy(String by, String input) {
		List<PersonaNatural> personasNaturales = personaNaturalDao.findBy(by, input);
		List<PersonaNaturalDto> personasNaturalesDto = new ArrayList<>();
		for(PersonaNatural personaNatural:personasNaturales) {
			personasNaturalesDto.add(buildDtoFrom(personaNatural));
		}
		return personasNaturalesDto;
	}

	@Override
	@Transactional
	public List<PersonaNaturalDto> findFirstNumberOfExtensionPersonasNaturales(int max) {
		List<PersonaNaturalDto> personasNaturalesDto = personaNaturalDao.findFirstNumberOfExtension(max);
		return personasNaturalesDto;
	}

	@Override
	@Transactional
	public List<PersonaNaturalDto> findExtensionPersonasNaturalesBy(String by, String input) {
		List<PersonaNaturalDto> personasNaturalesDto = personaNaturalDao.findExtensionBy(by, input);
		return personasNaturalesDto;
	}


	public PersonaNaturalDto buildDtoFrom (PersonaNatural personaNatural) {
		ModelMapper modelMapper = new ModelMapper();
		PersonaNaturalDto  personaNaturalDTO = modelMapper.map(personaNatural, PersonaNaturalDto.class);
		return personaNaturalDTO;
	}

	private PersonaNatural buildEntityFrom(PersonaNaturalDto personaNaturalDto) {
		
		PersonaNatural personaNatural = new PersonaNatural();
		setEntityDetails(personaNatural, personaNaturalDto);
		return personaNatural;
	}
	
	private void setEntityDetails(PersonaNatural personaNatural, PersonaNaturalDto personaNaturalDto) {
		personaNatural.setApellidoPaterno(personaNaturalDto.getApellidoPaterno().toUpperCase());
		personaNatural.setApellidoMaterno(personaNaturalDto.getApellidoMaterno().toUpperCase());
		personaNatural.setPrimerNombre(personaNaturalDto.getPrimerNombre().toUpperCase());
		personaNatural.setSegundoNombre(personaNaturalDto.getSegundoNombre().toUpperCase());
		String nombre = personaNaturalDto.getApellidoPaterno() + " " + personaNaturalDto.getApellidoMaterno() + " " + personaNaturalDto.getPrimerNombre() + " " + personaNaturalDto.getSegundoNombre(); 
		personaNatural.setNombre(nombre.toUpperCase());
		personaNatural.setSexo(Sexo.valueOf(personaNaturalDto.getSexo()));
		personaNatural.setEstadoCivil(EstadoCivil.valueOf(personaNaturalDto.getEstadoCivil()));
		personaNatural.setEmail(personaNaturalDto.getEmail().toUpperCase());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNacimiento = personaNaturalDto.getFechaNacimiento() == null ? null : LocalDate.parse(personaNaturalDto.getFechaNacimiento(), formatter);
		personaNatural.setFechaNacimiento(fechaNacimiento);
		personaNatural.setTipoIdentificacion(TipoIdentificacion.valueOf(personaNaturalDto.getTipoIdentificacion()));
		personaNatural.setNroIdentificacion(personaNaturalDto.getNroIdentificacion());
	}

}
