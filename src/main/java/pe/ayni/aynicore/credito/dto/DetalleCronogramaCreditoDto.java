package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleCronogramaCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer nroCuota;
	private String fechaVencimiento;
	private BigDecimal saldoCapital;
	private BigDecimal capital;
	private BigDecimal interes;
	private BigDecimal montoCuota;
	
	public DetalleCronogramaCreditoDto() {
		
	}
	
	public DetalleCronogramaCreditoDto(Integer nroCuota, String fechaVencimiento, BigDecimal saldoCapital,
			BigDecimal capital, BigDecimal interes, BigDecimal montoCuota) {
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.saldoCapital = saldoCapital;
		this.capital = capital;
		this.interes = interes;
		this.montoCuota = montoCuota;
	}
	
	public Integer getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public BigDecimal getSaldoCapital() {
		return saldoCapital;
	}
	public void setSaldoCapital(BigDecimal saldoCapital) {
		this.saldoCapital = saldoCapital;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	public BigDecimal getInteres() {
		return interes;
	}
	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}
	public BigDecimal getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(BigDecimal montoCuota) {
		this.montoCuota = montoCuota;
	}
	

}
