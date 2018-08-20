package pe.ayni.aynicore.cuenta.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.cuenta.dao.CuentaDao;
import pe.ayni.aynicore.cuenta.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	CuentaDao cuentaDao;
	
	@Override
	@Transactional
	public Cuenta findCuentaById(Integer id) {
		return cuentaDao.findById(id);
	}

}
