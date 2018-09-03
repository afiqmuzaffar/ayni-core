package pe.ayni.aynicore.banco.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.banco.dto.DetalleBancoDto;

@Service
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	DetalleBancoService detalleBancoService;
	
	@Override
	@Transactional
	public DetalleBancoDto createDeposito(DetalleBancoDto detalleBanco) {
		return detalleBancoService.createDeposito(detalleBanco);
	}

}
