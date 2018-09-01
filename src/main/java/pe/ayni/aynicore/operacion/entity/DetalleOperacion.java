package pe.ayni.aynicore.operacion.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.banco.entity.DetalleBanco;
import pe.ayni.aynicore.credito.entity.DetalleCredito;
import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;

@Entity
@Table(name="DetalleOperacion")
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
	@JoinColumn(name="idDetalleCredito", nullable=true)
	private DetalleCredito detalleCredito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetalleBanco", nullable=true)
	private DetalleBanco detalleBanco;
	
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

	public DetalleCredito getDetalleCredito() {
		return detalleCredito;
	}

	public void setDetalleCredito(DetalleCredito detalleCredito) {
		this.detalleCredito = detalleCredito;
	}

	public DetalleBanco getDetalleBanco() {
		return detalleBanco;
	}

	public void setDetalleBanco(DetalleBanco detalleBanco) {
		this.detalleBanco = detalleBanco;
	}
	
	
}
