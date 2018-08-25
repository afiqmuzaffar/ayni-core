package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleCronogramaCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer idCuenta;
	
	private Integer nroCondicion;

	private Integer nroCuota;
	
	private Integer nroConcepto;
	
	private String ctaContable;
	
	private String fechaVencimiento;
	
	private BigDecimal capitalCredito;
	
	private BigDecimal montoProgramado;
	
	private BigDecimal montoPagado;
	
	public DetalleCronogramaCreditoDto() {
		
	}
	
	

	public DetalleCronogramaCreditoDto(Integer id, Integer idCuenta, Integer nroCondicion, Integer nroCuota,
			Integer nroConcepto, String ctaContable, String fechaVencimiento, BigDecimal capitalCredito,
			BigDecimal montoProgramado, BigDecimal montoPagado) {
		this.id = id;
		this.idCuenta = idCuenta;
		this.nroCondicion = nroCondicion;
		this.nroCuota = nroCuota;
		this.nroConcepto = nroConcepto;
		this.ctaContable = ctaContable;
		this.fechaVencimiento = fechaVencimiento;
		this.capitalCredito = capitalCredito;
		this.montoProgramado = montoProgramado;
		this.montoPagado = montoPagado;
	}

	public DetalleCronogramaCreditoDto(DetalleCronogramaCreditoDto detalleCronogramaCreditoDto) {
		
		this(detalleCronogramaCreditoDto.getId(), detalleCronogramaCreditoDto.getIdCuenta(), detalleCronogramaCreditoDto.getNroConcepto(),
				detalleCronogramaCreditoDto.getNroCuota(), detalleCronogramaCreditoDto.getNroConcepto(), detalleCronogramaCreditoDto.getCtaContable(),
				detalleCronogramaCreditoDto.getFechaVencimiento(), detalleCronogramaCreditoDto.getCapitalCredito(),
				detalleCronogramaCreditoDto.getMontoProgramado(), detalleCronogramaCreditoDto.getMontoPagado());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Integer getNroCondicion() {
		return nroCondicion;
	}

	public void setNroCondicion(Integer nroCondicion) {
		this.nroCondicion = nroCondicion;
	}

	public Integer getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}

	public Integer getNroConcepto() {
		return nroConcepto;
	}

	public void setNroConcepto(Integer nroConcepto) {
		this.nroConcepto = nroConcepto;
	}

	public String getCtaContable() {
		return ctaContable;
	}

	public void setCtaContable(String ctaContable) {
		this.ctaContable = ctaContable;
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

	public BigDecimal getMontoProgramado() {
		return montoProgramado;
	}

	public void setMontoProgramado(BigDecimal montoProgramado) {
		this.montoProgramado = montoProgramado;
	}

	public BigDecimal getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(BigDecimal montoPagado) {
		this.montoPagado = montoPagado;
	}

}
