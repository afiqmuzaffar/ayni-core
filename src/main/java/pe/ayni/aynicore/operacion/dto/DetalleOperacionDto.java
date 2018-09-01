package pe.ayni.aynicore.operacion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleOperacionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer nroDetalle;
	
	private Integer idCuenta;
	
	private String ctaContable;
	
	private String tipoCuenta;
	
	private BigDecimal debito;
	
	private BigDecimal credito;
	
	private Integer idDetalleCredito;
	
	private Integer idDetalleBanco;
	
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
	
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
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

	public Integer getIdDetalleCredito() {
		return idDetalleCredito;
	}

	public void setIdDetalleCredito(Integer idDetalleCredito) {
		this.idDetalleCredito = idDetalleCredito;
	}

	public Integer getIdDetalleBanco() {
		return idDetalleBanco;
	}

	public void setIdDetalleBanco(Integer idDetalleBanco) {
		this.idDetalleBanco = idDetalleBanco;
	}
	
	
}
