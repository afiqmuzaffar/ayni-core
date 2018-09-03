package pe.ayni.aynicore.banco.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.banco.dao.DetalleBancoDao;
import pe.ayni.aynicore.banco.dto.DetalleBancoDto;
import pe.ayni.aynicore.banco.entity.CuentaBanco;
import pe.ayni.aynicore.banco.entity.DetalleBanco;

@Service
public class DetalleBancoServiceImpl implements DetalleBancoService{
	
	@Autowired
	DetalleBancoDao detalleBancoDao;
	
	@Override
	@Transactional
	public DetalleBancoDto createDeposito(DetalleBancoDto detalleBancoDto) {
		DetalleBanco detalleBanco = buildEntityFrom(detalleBancoDto);
		detalleBancoDao.save(detalleBanco);
		detalleBancoDto = buildDtoFrom(detalleBanco);
		return detalleBancoDto;
	}

	private DetalleBancoDto buildDtoFrom(DetalleBanco detalleBanco) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleBancoDto detalleBancoDto = modelMapper.map(detalleBanco, DetalleBancoDto.class);
		return detalleBancoDto;
	}

	private DetalleBanco buildEntityFrom(DetalleBancoDto detalleBancoDto) {
		DetalleBanco detalleBanco = new DetalleBanco();
		detalleBanco.setCuentaBanco(new CuentaBanco(detalleBancoDto.getIdCuenta()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		detalleBanco.setFechaOperacion(LocalDate.parse(detalleBancoDto.getFechaOperacion(), formatter));
		detalleBanco.setMontoOperacion(detalleBancoDto.getMontoOperacion());
		detalleBanco.setNroOperacion(detalleBancoDto.getNroOperacion());
		return detalleBanco;
	}

}
