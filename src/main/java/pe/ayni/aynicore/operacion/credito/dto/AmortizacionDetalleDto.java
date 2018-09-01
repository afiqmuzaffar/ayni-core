package pe.ayni.aynicore.operacion.credito.dto;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.DetalleCreditoDto;

public class AmortizacionDetalleDto extends DetalleCreditoDto {
	

	private static final long serialVersionUID = 1L;
	
	private BigDecimal montoAmortizacion;

	public AmortizacionDetalleDto(DetalleCreditoDto detalleCredito) {
		super(detalleCredito);
		this.montoAmortizacion = BigDecimal.ZERO;
	}

	public BigDecimal getMontoAmortizacion() {
		return montoAmortizacion;
	}

	public void setMontoAmortizacion(BigDecimal montoAmortizacion) {
		this.montoAmortizacion = montoAmortizacion;
	}
	
	
}
