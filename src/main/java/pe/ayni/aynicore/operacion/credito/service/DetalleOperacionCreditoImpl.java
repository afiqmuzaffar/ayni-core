package pe.ayni.aynicore.operacion.credito.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionDetalleDto;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;
import pe.ayni.aynicore.operacion.service.DetalleOperacionService;

@Service
public class DetalleOperacionCreditoImpl implements DetalleOperacionCredito {
	@Autowired
	DetalleOperacionService detalleOperacionService;
	
	@Override
	@Transactional
	public List<DetalleOperacionDto> buildDetallesAmortizacion(AmortizacionCreditoDto amortizacionCredito,
			List<AmortizacionDetalleDto> amortizacionDetalles) {
		
		List<DetalleOperacionDto> detallesOperacion = new ArrayList<>();
		// Detalle de la Operacion de Recaudo
		Integer nroDetalle = 0;
		DetalleOperacionDto detalleOperacionRecaudo = detalleOperacionService.buildDetalleOperacion(amortizacionCredito.getIdCuentaRecaudo(),
				nroDetalle, DebitoCredito.DEBITO, amortizacionCredito.getMontoAmortizacion(), null, amortizacionCredito.getDetalleBanco().getId());
		detallesOperacion.add(detalleOperacionRecaudo);
		
		for (AmortizacionDetalleDto detalle: amortizacionDetalles) {
			nroDetalle++;
			DetalleOperacionDto detalleOperacion = detalleOperacionService.buildDetalleOperacion(detalle.getIdCuenta(),
					nroDetalle, DebitoCredito.CREDITO, detalle.getMontoAmortizacion(), detalle.getId(), null);
			detallesOperacion.add(detalleOperacion);
		}
		return detallesOperacion;
	}

}
