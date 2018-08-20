package pe.ayni.aynicore.operacion.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.banco.entity.DetalleOperacionBanco;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;
import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.cuenta.service.CuentaService;
import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;
import pe.ayni.aynicore.operacion.entity.DetalleOperacion;

@Service
public class DetalleOperacionServiceImpl implements DetalleOperacionService {
	
	public static final String DEBITO = "DEBITO";
	public static final String CREDITO = "CREDITO";
	
	@Autowired
	CuentaService cuentaService;
	
	@Override
	@Transactional
	public DetalleOperacion createEntityFrom(DetalleOperacionDto detalleOperacionDto) {
		
		DetalleOperacion detalleOperacion = new DetalleOperacion();
		
		detalleOperacion.setNroDetalle(detalleOperacionDto.getNroDetalle());
		
		Cuenta cuenta = cuentaService.findCuentaById(detalleOperacionDto.getIdCuenta());
		detalleOperacion.setCuenta(cuenta);
		
		detalleOperacion.setCuentaContable(new CuentaContable(detalleOperacionDto.getCtaContable()));
		detalleOperacion.setDebito(detalleOperacionDto.getDebito());
		detalleOperacion.setCredito(detalleOperacionDto.getCredito());
		
		if (detalleOperacionDto.getIdDetalleCronogramaCredito() != null)
			detalleOperacion.setDetalleCronogramaCredito(new DetalleCronogramaCredito(detalleOperacionDto.getIdDetalleCronogramaCredito()));
		
		if (detalleOperacionDto.getIdDetalleOperacionBanco() != null) 
			detalleOperacion.setDetalleOperacionBanco(new DetalleOperacionBanco(detalleOperacionDto.getIdDetalleOperacionBanco()));
		
		return detalleOperacion;
	}

	@Override
	public DetalleOperacionDto getDetalleOperacionDesembolsoDto(
			DetalleCronogramaCredito detalleDesembolsoCronogramaCredito) {
		DetalleOperacionDto detalleOperacionDto = new DetalleOperacionDto();
		detalleOperacionDto.setIdCuenta(detalleDesembolsoCronogramaCredito.getCuentaCredito().getIdCuenta());
		detalleOperacionDto.setCredito(BigDecimal.ZERO);
		detalleOperacionDto.setCtaContable(detalleDesembolsoCronogramaCredito.getCtaContable().getCtaContable());
		detalleOperacionDto.setIdDetalleCronogramaCredito(detalleDesembolsoCronogramaCredito.getId());
		return detalleOperacionDto;
	}

	@Override
	@Transactional
	public DetalleOperacionDto getDetalleOperacionDto(Integer idCuenta, int nroDetalle, DebitoCredito debitoCredito) {
		Cuenta cuenta = cuentaService.findCuentaById(idCuenta);
		
		DetalleOperacionDto detalleOperacionDto = new DetalleOperacionDto();
		
		detalleOperacionDto.setIdCuenta(idCuenta);
		detalleOperacionDto.setCtaContable(cuenta.getCuentaContable().getCtaContable());
		detalleOperacionDto.setNroDetalle(nroDetalle);
		
		if (debitoCredito.equals(DebitoCredito.DEBITO)) {
			detalleOperacionDto.setCredito(BigDecimal.ZERO);
		} else if (debitoCredito.equals(DebitoCredito.CREDITO)) {
			detalleOperacionDto.setDebito(BigDecimal.ZERO);
		}
		
		return detalleOperacionDto;
	}

}
