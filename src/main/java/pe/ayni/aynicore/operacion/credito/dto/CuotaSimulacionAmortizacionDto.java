package pe.ayni.aynicore.operacion.credito.dto;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;

public class CuotaSimulacionAmortizacionDto extends CuotaCronogramaCreditoDto {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal amortizacionCapital;
	
	private BigDecimal amortizacionInteres;

	public CuotaSimulacionAmortizacionDto(CuotaCronogramaCreditoDto cuotaCronogramaCreditoDto) {
		super(cuotaCronogramaCreditoDto);
		this.amortizacionCapital = BigDecimal.ZERO;
		this.amortizacionInteres = BigDecimal.ZERO;
	}

	public BigDecimal getAmortizacionCapital() {
		return amortizacionCapital;
	}

	public void setAmortizacionCapital(BigDecimal amortizacionCapital) {
		this.amortizacionCapital = amortizacionCapital;
	}

	public BigDecimal getAmortizacionInteres() {
		return amortizacionInteres;
	}

	public void setAmortizacionInteres(BigDecimal amortizacionInteres) {
		this.amortizacionInteres = amortizacionInteres;
	}
	
	

}
