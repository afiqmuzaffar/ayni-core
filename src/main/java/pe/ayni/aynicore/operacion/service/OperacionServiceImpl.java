package pe.ayni.aynicore.operacion.service;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.operacion.constraint.OperacionConstraint.TipoOperacion;
import pe.ayni.aynicore.operacion.dao.OperacionDao;
import pe.ayni.aynicore.operacion.dto.OperacionDto;
import pe.ayni.aynicore.operacion.entity.Operacion;
import pe.ayni.aynicore.seguridad.entity.Usuario;

@Service
public class OperacionServiceImpl implements OperacionService {
	
	@Autowired
	DetalleOperacionService detalleOperacionService;
	
	@Autowired
	OperacionDao operacionDao;

	@Override
	@Transactional
	public Integer createOperacion(OperacionDto operacionDto) {
		
		Operacion operacion = buildEntityFrom(operacionDto);
		return operacionDao.create(operacion);
	}
	
	@Transactional
	private Operacion buildEntityFrom(OperacionDto operacionDto) {
		Operacion operacion = new Operacion();

		operacion.setMonto(operacionDto.getMonto());
		operacion.setMoneda(operacionDto.getMoneda());
		operacion.setFechaOperacion(LocalDate.now());
		operacion.setHoraOperacion(LocalTime.now());
		operacion.setUsuario(new Usuario(operacionDto.getUsuario()));
		operacion.setTipoOperacion(TipoOperacion.valueOf(operacionDto.getTipoOperacion()));
		operacion.setNota(operacionDto.getNota());
		if (operacionDto.getIdOperacionRelacionada() != null)
			operacion.setOperacionRelacionada(new Operacion(operacionDto.getIdOperacionRelacionada()));	
		
		detalleOperacionService.setDetallesOperacion(operacion, operacionDto.getDetallesOperacion());

		return operacion;
	}

}
