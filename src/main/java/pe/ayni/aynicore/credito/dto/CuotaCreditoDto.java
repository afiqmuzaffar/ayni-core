package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CuotaCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCuenta;
	
	private Integer nroCuota;
	
	private String fechaVencimiento;
	
	private BigDecimal capitalCredito;
	
	private BigDecimal capitalProgramado;
	
	private BigDecimal interesProgramado;
	
	private BigDecimal capitalPagado;
	
	private BigDecimal interesPagado;
	
	private BigDecimal montoCuota;
	
	public CuotaCreditoDto() {
		
	}
	
	public CuotaCreditoDto(Integer nroCuota, String fechaVencimiento, BigDecimal capitalCredito,
			BigDecimal capitalProgramado, BigDecimal interesProgramado, BigDecimal montoCuota) {
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.capitalCredito = capitalCredito;
		this.capitalProgramado = capitalProgramado;
		this.interesProgramado = interesProgramado;
		this.montoCuota = montoCuota;
	}
	
	
	public CuotaCreditoDto(Integer idCuenta, Integer nroCuota, String fechaVencimiento,
			BigDecimal capitalCredito) {
		this.idCuenta = idCuenta;
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.capitalCredito = capitalCredito;
	}
	
	public CuotaCreditoDto(Integer idCuenta, Integer nroCuota, String fechaVencimiento,
			BigDecimal capitalCredito, BigDecimal capitalProgramado, BigDecimal interesProgramado,
			BigDecimal capitalPagado, BigDecimal interesPagado, BigDecimal montoCuota) {
		this.idCuenta = idCuenta;
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.capitalCredito = capitalCredito;
		this.capitalProgramado = capitalProgramado;
		this.interesProgramado = interesProgramado;
		this.capitalPagado = capitalPagado;
		this.interesPagado = interesPagado;
		this.montoCuota = montoCuota;
	}

	public CuotaCreditoDto(CuotaCreditoDto cuotaCredito) {
		this(cuotaCredito.getIdCuenta(), cuotaCredito.getNroCuota(), cuotaCredito.getFechaVencimiento(),
				cuotaCredito.getCapitalCredito(), cuotaCredito.getCapitalProgramado(), cuotaCredito.getInteresProgramado(),
				cuotaCredito.getCapitalPagado(), cuotaCredito.getInteresPagado(), cuotaCredito.getMontoCuota());
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
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

	public BigDecimal getCapitalCredito() {
		return capitalCredito;
	}

	public void setCapitalCredito(BigDecimal capitalCredito) {
		this.capitalCredito = capitalCredito;
	}

	public BigDecimal getCapitalProgramado() {
		return capitalProgramado;
	}

	public void setCapitalProgramado(BigDecimal capitalProgramado) {
		this.capitalProgramado = capitalProgramado;
	}

	public BigDecimal getInteresProgramado() {
		return interesProgramado;
	}

	public void setInteresProgramado(BigDecimal interesProgramado) {
		this.interesProgramado = interesProgramado;
	}

	public BigDecimal getCapitalPagado() {
		return capitalPagado;
	}

	public void setCapitalPagado(BigDecimal capitalPagado) {
		this.capitalPagado = capitalPagado;
	}

	public BigDecimal getInteresPagado() {
		return interesPagado;
	}

	public void setInteresPagado(BigDecimal interesPagado) {
		this.interesPagado = interesPagado;
	}

	public BigDecimal getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(BigDecimal montoCuota) {
		this.montoCuota = montoCuota;
	}


}
