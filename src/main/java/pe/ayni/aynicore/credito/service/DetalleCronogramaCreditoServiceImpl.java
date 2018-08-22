package pe.ayni.aynicore.credito.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.credito.dao.DetalleCronogramaCreditoDao;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;

@Service
public class DetalleCronogramaCreditoServiceImpl implements DetalleCronogramaCreditoService {

	@Autowired
	DetalleCronogramaCreditoDao detalleCronogramaCreditoDao;
	
	@Override
	@Transactional
	public DetalleCronogramaCreditoDto findDetalleDesembolsoCronogramaCredito(Integer idCuenta) {

		DetalleCronogramaCredito detalleCronogramaCredito = detalleCronogramaCreditoDao.findDesembolso(idCuenta);
		return buildDtoFrom(detalleCronogramaCredito);
	}

	private DetalleCronogramaCreditoDto buildDtoFrom(DetalleCronogramaCredito detalleCronogramaCredito) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleCronogramaCreditoDto  detalleCronogramaCreditoDto = modelMapper.map(detalleCronogramaCredito, DetalleCronogramaCreditoDto.class);
		return detalleCronogramaCreditoDto;
	}


}
