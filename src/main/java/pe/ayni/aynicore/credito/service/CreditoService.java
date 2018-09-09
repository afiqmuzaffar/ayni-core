package pe.ayni.aynicore.credito.service;

import java.math.BigDecimal;
import java.util.List;

import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.SimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;

public interface CreditoService {

	CreditoDto createCredito(CreditoDto credito);
	
	List<CuotaCreditoDto> calculateCuotas(CreditoDto credito);

	List<CuotaCreditoDto> calculateCuotas(SimulacionCreditoDto simulacionCredito);

	CreditoDto findCreditoById(Integer idCuenta);

	List<CuotaCreditoDto> findCuotasByIdCuentaAndEstado(Integer idCuenta, String estado); 
	
	Integer getNroCondicionCredito(Integer idCuenta);

	void amortizarCredito(Integer idCuenta, BigDecimal monto);

}
