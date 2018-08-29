package pe.ayni.aynicore.operacion.credito.dto;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;

public class DetalleCronogramaSimulacionAmortizacionDto extends DetalleCronogramaCreditoDto {
	

	private static final long serialVersionUID = 1L;
	
	private BigDecimal montoAmortizacion;

	public DetalleCronogramaSimulacionAmortizacionDto(DetalleCronogramaCreditoDto detalleCronogramaCreditoDto) {
		super(detalleCronogramaCreditoDto);
		this.montoAmortizacion = BigDecimal.ZERO;
	}

	public BigDecimal getMontoAmortizacion() {
		return montoAmortizacion;
	}

	public void setMontoAmortizacion(BigDecimal montoAmortizacion) {
		this.montoAmortizacion = montoAmortizacion;
	}
	
	
}
