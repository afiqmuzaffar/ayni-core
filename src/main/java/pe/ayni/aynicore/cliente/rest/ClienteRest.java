package pe.ayni.aynicore.cliente.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@CrossOrigin
	@GetMapping(path="", params= {"by", "input"})
	public List<ClienteDto> findClientesBy(@RequestParam("by") String by, @RequestParam("input") String input) {
		return clienteService.findClientesBy(by, input);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ClienteDto findClienteById(@PathVariable Integer id) {
		return clienteService.getClienteById(id);
	}
	
}
