package pe.ayni.aynicore.credito.service;

import java.util.List;

import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

public interface CreditoService {

	public List<DetalleCronogramaCreditoDto> getSimulacionCronograma(DesembolsoCreditoDto desembolsoCreditoDto); 

}
