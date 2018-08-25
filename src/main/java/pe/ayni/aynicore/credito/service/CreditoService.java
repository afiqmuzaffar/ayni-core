package pe.ayni.aynicore.credito.service;

import java.util.List;

import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.DatosSimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;

public interface CreditoService {

	void createCredito(CreditoDto creditoDto);
	
	List<CuotaCronogramaCreditoDto> calculateCronograma(CreditoDto creditoDto);

	List<CuotaCronogramaCreditoDto> calculateCronograma(DatosSimulacionCreditoDto datosSimulacionCreditoDto);

	CreditoDto findCreditoById(Integer idCuenta);

	List<CuotaCronogramaCreditoDto> findCuotasCronogramaByIdCuentaAndEstado(Integer idCuenta, String estado); 
	
	Integer getNroCondicionCredito(Integer idCuenta);

}
