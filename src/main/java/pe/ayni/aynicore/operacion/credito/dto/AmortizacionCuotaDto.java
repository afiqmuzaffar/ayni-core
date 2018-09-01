package pe.ayni.aynicore.operacion.credito.dto;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;

public class AmortizacionCuotaDto extends CuotaCreditoDto {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal amortizacionCapital;
	
	private BigDecimal amortizacionInteres;

	public AmortizacionCuotaDto(CuotaCreditoDto cuotaCredito) {
		super(cuotaCredito);
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
