package pe.ayni.aynicore.credito.service;

import java.util.List;

import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.DatosSimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;

public interface CreditoService {

	void createCredito(CreditoDto creditoDto);
	
	public List<DetalleCronogramaCreditoDto> getCalculoDetalleCronograma(CreditoDto creditoDto);

	List<DetalleCronogramaCreditoDto> getSimulacionCronograma(DatosSimulacionCreditoDto datosSimulacionCreditoDto);

	CreditoDto findCreditoById(Integer idCuenta); 
	
	

}
