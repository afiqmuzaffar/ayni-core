package pe.ayni.aynicore.cliente.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.cliente.dao.ClienteDao;
import pe.ayni.aynicore.cliente.dto.ClienteDto;
import pe.ayni.aynicore.cliente.entity.Cliente;
import pe.ayni.aynicore.persona.entity.PersonaNatural;
import pe.ayni.aynicore.persona.service.PersonaNaturalService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteDao clienteDao;
	
	@Autowired
	PersonaNaturalService personaNaturalService;
	
	@Override
	@Transactional
	public void createCliente(ClienteDto clienteDto) {
		
		personaNaturalService.createPersonaNatural(clienteDto.getPersonaNatural());
		
		PersonaNatural personaNatural = new PersonaNatural();
		personaNatural.setId(clienteDto.getPersonaNatural().getId());
		Cliente cliente = new Cliente();
		cliente.setPersonaNatural(personaNatural);
		cliente.setFechaRegistro(LocalDate.now());
		clienteDao.create(cliente);
		clienteDto.setId(cliente.getId());
	}

}
