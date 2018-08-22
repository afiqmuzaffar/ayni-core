package pe.ayni.aynicore.operacion.service;

import java.util.List;

import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;
import pe.ayni.aynicore.operacion.entity.Operacion;

public interface DetalleOperacionService {

	DetalleOperacionDto buildDetalleOperacionDesembolso(DetalleCronogramaCreditoDto detalleDesembolsoCronogramaCredito);

	DetalleOperacionDto buildDetalleOperacion(Integer idCuenta, int nroDetalle, DebitoCredito debitoCredito);

	void setDetalleOperacion(Operacion operacion, List<DetalleOperacionDto> detallesOperacionDto);

}
