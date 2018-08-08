package pe.ayni.aynicore.credito.service;

import java.util.List;

import pe.ayni.aynicore.credito.dto.DatosCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;

public interface CreditoService {

	public List<DetalleCronogramaCreditoDto> getSimulacionCronograma(DatosCreditoDto datosCreditoDto); 

}
