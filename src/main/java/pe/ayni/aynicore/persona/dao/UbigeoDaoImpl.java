package pe.ayni.aynicore.persona.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Departamento;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Distrito;
import pe.ayni.aynicore.persona.dto.ConfiguracionUbigeoDto.Provincia;

@Repository
public class UbigeoDaoImpl implements UbigeoDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Departamento> findAllDepartamentos() {
		List<Departamento> departamentos = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT  "
				+ " id, codDpto, nombre FROM Ubigeo WHERE codProvincia = '00' AND codDistrito = '00'");
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		for (Object[] line: list ) {
			departamentos.add(new Departamento((Integer)line[0], (String)line[1], (String)line[2]));
		}
		return departamentos;
	}

	@Override
	public List<Provincia> findAllProvinciasByCodDpto(String codDpto) {
		List<Provincia> provincias = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT  "
				+ " id, codProvincia, nombre FROM Ubigeo WHERE codDpto = :codDpto AND codDistrito = '00' and codProvincia <> '00'");
		query.setParameter("codDpto", codDpto);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		for (Object[] line: list ) {
			provincias.add(new Provincia((Integer)line[0], (String)line[1], (String)line[2]));
		}
		return provincias;
	}

	@Override
	public List<Distrito> findAllDistritosByCodDptoAndCodProvincia(String codDpto, String codProvincia) {
		List<Distrito> distritos = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT  "
				+ " id, nombre FROM Ubigeo WHERE codDpto = :codDpto AND codProvincia = :codProvincia AND codDistrito <> '00'");
		query.setParameter("codDpto", codDpto);
		query.setParameter("codProvincia", codProvincia);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		for (Object[] line: list ) {
			distritos.add(new Distrito((Integer)line[0], (String)line[1]));
		}
		return distritos;
	}

}
