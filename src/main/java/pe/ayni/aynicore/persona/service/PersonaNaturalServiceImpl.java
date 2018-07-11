package pe.ayni.aynicore.persona.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

	@Override
	@Transactional
	public void createPersonaNatural(PersonaNaturalDTO personaNaturalDTO) {
		PersonaNatural personaNatural = new PersonaNatural(); 
		personaNatural = mapDTOToEntity(personaNaturalDTO, personaNatural);	
		personaNatural.setTipoPersona(TipoPersona.PPNN);
		personaNatural.setId(null);
		personaNatural.setFechaRegistro(LocalDate.now());
		personaNatural.setFechaHoraInsercion(LocalDateTime.now());

		personaNaturalDao.create(personaNatural);
		
		personaNaturalDTO.setId(personaNatural.getId());
	}
	
	@Transactional
	@Override
	public PersonaNaturalDTO findPersonaNaturalById(Integer id) {
		PersonaNatural personaNatural = personaNaturalDao.findById(id);
		PersonaNaturalDTO personaNaturalDTO = convertToDTO(personaNatural);
		return personaNaturalDTO;
	}

	@Override
	@Transactional
	public void updatePersonaNatural(PersonaNaturalDTO personaNaturalDTO) {
		
		PersonaNatural personaNatural = personaNaturalDao.findById(personaNaturalDTO.getId());
		personaNatural = mapDTOToEntity(personaNaturalDTO, personaNatural);	
		personaNatural.setFechaHoraModificacion(LocalDateTime.now());
		personaNaturalDao.update(personaNatural);
	}
	

	
	private PersonaNatural mapDTOToEntity(PersonaNaturalDTO personaNaturalDTO, PersonaNatural personaNatural) {
		/*
		Converter<String, String> toUppercase = new AbstractConverter<String, String>() {
		    protected String convert(String source) {
		        return source == null ? null : source.toUpperCase();
		    }
		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(toUppercase);
		modelMapper.addMappings(new PropertyMap<PersonaNaturalDTO, PersonaNatural>() {

			@Override
			protected void configure() {
				map().setNombre(source.getApellidoPaterno()+ " " + source.getApellidoMaterno() + " " + personaNaturalDTO.getPrimerNombre() + " " + personaNaturalDTO.getSegundoNombre() );
			}
		});
		PersonaNatural personaNatural = modelMapper.map(personaNaturalDTO, PersonaNatural.class);
		*/
		
		personaNatural.setApellidoPaterno(personaNaturalDTO.getApellidoPaterno().toUpperCase());
		personaNatural.setApellidoMaterno(personaNaturalDTO.getApellidoMaterno().toUpperCase());
		personaNatural.setPrimerNombre(personaNaturalDTO.getPrimerNombre().toUpperCase());
		personaNatural.setSegundoNombre(personaNaturalDTO.getSegundoNombre().toUpperCase());
		String nombre = personaNaturalDTO.getApellidoPaterno() + " " + personaNaturalDTO.getApellidoMaterno() + " " + personaNaturalDTO.getPrimerNombre() + " " + personaNaturalDTO.getSegundoNombre(); 
		personaNatural.setNombre(nombre.toUpperCase());
		personaNatural.setSexo(Sexo.valueOf(personaNaturalDTO.getSexo()));
		personaNatural.setEstadoCivil(EstadoCivil.valueOf(personaNaturalDTO.getEstadoCivil()));
		personaNatural.setEmail(personaNaturalDTO.getEmail().toUpperCase());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNacimiento = personaNaturalDTO.getFechaNacimiento() == null ? null : LocalDate.parse(personaNaturalDTO.getFechaNacimiento(), formatter);
		personaNatural.setFechaNacimiento(fechaNacimiento);
		personaNatural.setTipoIdentificacion(TipoIdentificacion.valueOf(personaNaturalDTO.getTipoIdentificacion()));
		personaNatural.setNroIdentificacion(personaNaturalDTO.getNroIdentificacion());
		
		return personaNatural;
		
	}
	
	private PersonaNaturalDTO convertToDTO (PersonaNatural personaNatural) {
		
		ModelMapper modelMapper = new ModelMapper();
		PersonaNaturalDTO  personaNaturalDTO = modelMapper.map(personaNatural, PersonaNaturalDTO.class);
		return personaNaturalDTO;
	}
}
