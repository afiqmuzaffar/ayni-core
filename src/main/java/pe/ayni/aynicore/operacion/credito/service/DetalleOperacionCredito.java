package pe.ayni.aynicore.operacion.credito.service;

import java.util.List;

import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionDetalleDto;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;

public interface DetalleOperacionCredito {
	
	List<DetalleOperacionDto> buildDetallesAmortizacion(AmortizacionCreditoDto amortizacionCredito,
			List<AmortizacionDetalleDto> amortizacionDetalles);

}
