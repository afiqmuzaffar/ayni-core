package pe.ayni.aynicore.cliente.service;

import java.util.List;

import pe.ayni.aynicore.cliente.dto.ClienteDto;

public interface ClienteService {
	
	void createCliente(ClienteDto cliente);

	List<ClienteDto> findClientesBy(String by, String input);

	ClienteDto findClienteById(Integer id);

	ClienteDto updateCliente(ClienteDto cliente);
}
