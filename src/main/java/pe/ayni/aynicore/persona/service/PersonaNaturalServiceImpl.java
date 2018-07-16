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
		PersonaNatural personaNatural = new PersonaNatural(); 
		mapDtoToEntity(personaNaturalDto, personaNatural);	
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
		PersonaNaturalDto personaNaturalDto = convertToDto(personaNatural);
		return personaNaturalDto;
	}

	@Override
	@Transactional
	public void updatePersonaNatural(PersonaNaturalDto personaNaturalDto) {
		
		PersonaNatural personaNatural = personaNaturalDao.findById(personaNaturalDto.getId());
		mapDtoToEntity(personaNaturalDto, personaNatural);	
		personaNatural.setFechaHoraModificacion(LocalDateTime.now());
		personaNaturalDao.update(personaNatural);
	}
	
	@Transactional
	@Override
	public List<PersonaNaturalDto> findFirstNumberPersonasNaturales(int max) {
		List<PersonaNatural> personasNaturales = personaNaturalDao.findFirstNumberPersonasNaturales(max);
		List<PersonaNaturalDto> personasNaturalesDto = new ArrayList<>();
		for(PersonaNatural personaNatural:personasNaturales) {
			personasNaturalesDto.add(convertToDto(personaNatural));
		}
		return personasNaturalesDto;
	}
	
	private void mapDtoToEntity(PersonaNaturalDto personaNaturalDto, PersonaNatural personaNatural) {
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
	
	private PersonaNaturalDto convertToDto (PersonaNatural personaNatural) {
		
		ModelMapper modelMapper = new ModelMapper();
		PersonaNaturalDto  personaNaturalDTO = modelMapper.map(personaNatural, PersonaNaturalDto.class);
		return personaNaturalDTO;
	}


}
