package pe.ayni.aynicore.operacion.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pe.ayni.aynicore.banco.entity.DetalleOperacionBanco;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;
import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;

public class DetalleOperacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idOperacion", nullable=false)
	private Operacion operacion;
	
	@Column(name="nroDetalle", nullable=false)
	private Integer nroDetalle;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCuenta", nullable=false)
	private Cuenta cuenta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ctaContable", nullable=false)
	private CuentaContable cuentaContable;
	
	@Column(name="debito", nullable=false)
	private BigDecimal debito;
	
	@Column(name="credito", nullable=false)
	private BigDecimal credito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetalleCronogramaCredito", nullable=true)
	private DetalleCronogramaCredito detalleCronogramaCredito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetalleOperacionBanco", nullable=true)
	private DetalleOperacionBanco detalleOperacionBanco;
	
	public DetalleOperacion() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public Integer getNroDetalle() {
		return nroDetalle;
	}

	public void setNroDetalle(Integer nroDetalle) {
		this.nroDetalle = nroDetalle;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
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

	public DetalleCronogramaCredito getDetalleCronogramaCredito() {
		return detalleCronogramaCredito;
	}

	public void setDetalleCronogramaCredito(DetalleCronogramaCredito detalleCronogramaCredito) {
		this.detalleCronogramaCredito = detalleCronogramaCredito;
	}

	public DetalleOperacionBanco getDetalleOperacionBanco() {
		return detalleOperacionBanco;
	}

	public void setDetalleOperacionBanco(DetalleOperacionBanco detalleOperacionBanco) {
		this.detalleOperacionBanco = detalleOperacionBanco;
	}
	
	
}
