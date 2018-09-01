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
@Table(name="DetalleCredito")
public class DetalleCredito {
	
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
	
	@Column(name="capitalCredito", nullable=false)
	private BigDecimal capitalCredito;
	
	@Column(name="montoProgramado", nullable=false)
	private BigDecimal montoProgramado;
	
	@Column(name="montoPagado", nullable=false)
	private BigDecimal montoPagado;
	
	@OneToMany(mappedBy="detalleCredito", fetch=FetchType.LAZY)
	private List<DetalleOperacion> detallesOperacion; 
	
	public DetalleCredito() {
		
	}
	
	public DetalleCredito(Integer nroCondicion, Integer nroCuota, Integer nroConcepto,
			CuentaContable ctaContable, LocalDate fechaVencimiento, BigDecimal capitalCredito, BigDecimal montoProgramado,
			BigDecimal montoPagado) {
		this.nroCondicion = nroCondicion;
		this.nroCuota = nroCuota;
		this.nroConcepto = nroConcepto;
		this.ctaContable = ctaContable;
		this.fechaVencimiento = fechaVencimiento;
		this.capitalCredito = capitalCredito;
		this.montoProgramado = montoProgramado;
		this.montoPagado = montoPagado;
	}

	public DetalleCredito(Integer id) {
		this.id = id;
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

	public List<DetalleOperacion> getDetallesOperacion() {
		return detallesOperacion;
	}

	public void setDetallesOperacion(List<DetalleOperacion> detallesOperacion) {
		this.detallesOperacion = detallesOperacion;
	}

		
}
