package pe.ayni.aynicore.empleado.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.empleado.entity.Empleado;

@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(Empleado empleado) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empleado);
		/*
		session.createNativeQuery("INSERT INTO Empleado (id, fechaIngreso, estado, fechaHoraInsercion) VALUES(?, ?, ?, ?)")
			.setParameter(1, empleado.getId())
			.setParameter(2, empleado.getFechaIngreso())
			.setParameter(3, empleado.getEstado().toString())
			.setParameter(4, empleado.getFechaHoraInsercion())
			.executeUpdate();
		*/
	}

}
