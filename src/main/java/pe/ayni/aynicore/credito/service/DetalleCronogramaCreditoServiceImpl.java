package pe.ayni.aynicore.credito.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.credito.dao.DetalleCronogramaCreditoDao;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;

@Service
public class DetalleCronogramaCreditoServiceImpl implements DetalleCronogramaCreditoService {

	@Autowired
	DetalleCronogramaCreditoDao detalleCronogramaCreditoDao;
	
	@Override
	@Transactional
	public DetalleCronogramaCredito findDetalleDesembolsoCronogramaCredito(Integer idCuenta) {

		return detalleCronogramaCreditoDao.findDesembolso(idCuenta);
	}

}
