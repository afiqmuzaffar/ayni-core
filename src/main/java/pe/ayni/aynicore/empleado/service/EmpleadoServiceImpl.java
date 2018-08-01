package pe.ayni.aynicore.empleado.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.empleado.dao.EmpleadoDao;
import pe.ayni.aynicore.empleado.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	EmpleadoDao empleadoDao;
	
	@Override
	@Transactional
	public void createEmpleado(Empleado empleado) {
		empleadoDao.create(empleado);
	}

}
