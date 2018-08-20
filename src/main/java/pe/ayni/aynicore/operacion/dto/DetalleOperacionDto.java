package pe.ayni.aynicore.operacion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleOperacionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer nroDetalle;
	
	private Integer idCuenta;
	
	private String ctaContable;
	
	private BigDecimal debito;
	
	private BigDecimal credito;
	
	private Integer idDetalleCronogramaCredito;
	
	private Integer idDetalleOperacionBanco;
	
	public DetalleOperacionDto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNroDetalle() {
		return nroDetalle;
	}

	public void setNroDetalle(Integer nroDetalle) {
		this.nroDetalle = nroDetalle;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getCtaContable() {
		return ctaContable;
	}

	public void setCtaContable(String ctaContable) {
		this.ctaContable = ctaContable;
	}

	public BigDecimal getDebito() {
		return debito;
	}

	public void setDebito(BigDecimal debito) {
		this.debito = debito;
	}

	public BigDecimal getCredito() {
		return credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public Integer getIdDetalleCronogramaCredito() {
		return idDetalleCronogramaCredito;
	}

	public void setIdDetalleCronogramaCredito(Integer idDetalleCronogramaCredito) {
		this.idDetalleCronogramaCredito = idDetalleCronogramaCredito;
	}

	public Integer getIdDetalleOperacionBanco() {
		return idDetalleOperacionBanco;
	}

	public void setIdDetalleOperacionBanco(Integer idDetalleOperacionBanco) {
		this.idDetalleOperacionBanco = idDetalleOperacionBanco;
	}
	
	
}
