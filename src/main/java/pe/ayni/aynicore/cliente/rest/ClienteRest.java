package pe.ayni.aynicore.cliente.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.cliente.dto.ClienteDto;
import pe.ayni.aynicore.cliente.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRest {
	
	@Autowired
	ClienteService clienteService;
	
	@CrossOrigin
	@PostMapping("")
	public ClienteDto createCliente(@RequestBody ClienteDto clienteDto) {
		
		clienteService.createCliente(clienteDto);
		return clienteDto;
	}
	
}
