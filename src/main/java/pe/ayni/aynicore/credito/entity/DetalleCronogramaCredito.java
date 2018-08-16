package pe.ayni.aynicore.credito.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.operacion.entity.DetalleOperacion;

@Entity
@Table(name="DetalleCronogramaCredito")
public class DetalleCronogramaCredito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCuenta", nullable=false)
	private CuentaCredito cuentaCredito;
	
	@Column(name="nroCondicion", nullable=false)
	private Integer nroCondicion;

	@Column(name="nroCuota", nullable=false)
	private Integer nroCuota;
	
	@Column(name="nroConcepto", nullable=false)
	private Integer nroConcepto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ctaContable", nullable=false)
	private CuentaContable ctaContable;
	
	@Column(name="fechaVencimiento", nullable=false)
	private LocalDate fechaVencimiento;
	
	@Column(name="saldoCapital", nullable=false)
	private BigDecimal saldoCapital;
	
	@Column(name="montoCobrar", nullable=false)
	private BigDecimal montoCobrar;
	
	@Column(name="montoPagado", nullable=false)
	private BigDecimal montoPagado;
	
	@OneToMany(mappedBy="detalleCronogramaCredito", fetch=FetchType.LAZY)
	private List<DetalleOperacion> detallesOperacion; 
	
	public DetalleCronogramaCredito() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CuentaCredito getCuentaCredito() {
		return cuentaCredito;
	}

	public void setCuentaCredito(CuentaCredito cuentaCredito) {
		this.cuentaCredito = cuentaCredito;
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

	public CuentaContable getCtaContable() {
		return ctaContable;
	}

	public void setCtaContable(CuentaContable ctaContable) {
		this.ctaContable = ctaContable;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getSaldoCapital() {
		return saldoCapital;
	}

	public void setSaldoCapital(BigDecimal saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	public BigDecimal getMontoCobrar() {
		return montoCobrar;
	}

	public void setMontoCobrar(BigDecimal montoCobrar) {
		this.montoCobrar = montoCobrar;
	}

	public BigDecimal getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(BigDecimal montoPagado) {
		this.montoPagado = montoPagado;
	}

	public List<DetalleOperacion> getDetallesOperacion() {
		return detallesOperacion;
	}

	public void setDetallesOperacion(List<DetalleOperacion> detallesOperacion) {
		this.detallesOperacion = detallesOperacion;
	}

		
}
