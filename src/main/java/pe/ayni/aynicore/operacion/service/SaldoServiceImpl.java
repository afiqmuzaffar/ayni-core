package pe.ayni.aynicore.operacion.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.cuenta.constraint.CuentaContableConstraint.Naturaleza;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.cuenta.service.CuentaContableService;
import pe.ayni.aynicore.operacion.dao.SaldoDao;
import pe.ayni.aynicore.operacion.entity.DetalleOperacion;
import pe.ayni.aynicore.operacion.entity.Operacion;
import pe.ayni.aynicore.operacion.entity.Saldo;

@Service
public class SaldoServiceImpl implements SaldoService {
	
	@Autowired
	SaldoDao saldoDao;
	
	@Autowired
	CuentaContableService cuentaContableService;
	
	@Override
	@Transactional
	public void updateSaldo(Operacion operacion) {
		
		for(DetalleOperacion detalle: operacion.getDetallesOperacion()) {
			
			Saldo saldo = saldoDao.findByCuentaContableAndCuenta(detalle.getCuentaContable(), detalle.getCuenta());
			if (saldo == null) {
				saldo = new Saldo(detalle.getCuentaContable(), detalle.getCuenta(), BigDecimal.ZERO);
				saldoDao.save(saldo);
			}
			CuentaContable cuentaContable = cuentaContableService.findCuentaContableByCta(detalle.getCuentaContable().getCtaContable());
			if (cuentaContable.getNaturaleza().equals(Naturaleza.DEUDORA)) {
				saldo.setSaldo(saldo.getSaldo().add(detalle.getDebito()).subtract(detalle.getCredito()));
			} else if (cuentaContable.getNaturaleza().equals(Naturaleza.ACREEDORA)) {
				saldo.setSaldo(saldo.getSaldo().add(detalle.getCredito()).subtract(detalle.getDebito()));
			}
			saldoDao.save(saldo);
		}
		
	}

}
