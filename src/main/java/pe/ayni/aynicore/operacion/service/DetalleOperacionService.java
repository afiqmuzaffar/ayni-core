package pe.ayni.aynicore.operacion.service;

import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;
import pe.ayni.aynicore.operacion.constraint.DetalleOperacionConstraint.DebitoCredito;
import pe.ayni.aynicore.operacion.dto.DetalleOperacionDto;
import pe.ayni.aynicore.operacion.entity.DetalleOperacion;

public interface DetalleOperacionService {

	DetalleOperacion createEntityFrom(DetalleOperacionDto detalleOperacionDto);

	DetalleOperacionDto getDetalleOperacionDesembolsoDto(DetalleCronogramaCredito detalleDesembolsoCronogramaCredito);

	DetalleOperacionDto getDetalleOperacionDto(Integer idCuenta, int nroDetalle, DebitoCredito debitoCredito);

}
