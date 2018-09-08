package pe.ayni.aynicore.cliente.dao;

import java.util.List;

import pe.ayni.aynicore.cliente.entity.Cliente;

public interface ClienteDao {
	
	void create(Cliente cliente);

	List<Cliente> findBy(String by, String input);

	Cliente findById(Integer id);

	void update(Cliente cliente);
}
