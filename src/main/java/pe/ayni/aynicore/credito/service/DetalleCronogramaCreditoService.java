package pe.ayni.aynicore.credito.service;

import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;

public interface DetalleCronogramaCreditoService {

	DetalleCronogramaCreditoDto findDetalleDesembolsoCronogramaCredito(Integer idCuenta);

}
