package pe.ayni.aynicore.credito.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pe.ayni.aynicore.cliente.entity.Cliente;
import pe.ayni.aynicore.credito.constraint.CreditoConstraint.EstadoCredito;
import pe.ayni.aynicore.credito.constraint.CreditoConstraint.FrecuenciaCredito;
import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.seguridad.entity.Usuario;

@Entity
@Table(name="CuentaCredito")
@PrimaryKeyJoinColumn(name = "idCuenta")
public class CuentaCredito extends Cuenta {
	
	@Column(name="nroCondicion", nullable=false)
	private Integer nroCondicion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	@Column(name="montoDesembolso", nullable=false)
	private BigDecimal montoDesembolso;
	
	@Column(name="fechaDesembolso", nullable=false)
	private LocalDate fechaDesembolso;
	
	@ManyToOne(fetch = FetchType.LAZY) // default EAGER
	@JoinColumn(name="usuarioAprobador", nullable=false)
	private Usuario usuarioAprobador;
	
	@Column(name="capitalInicial", nullable=false)
	private BigDecimal capitalInicial;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length=10)
	private EstadoCredito estado;
	
	@Column(name="tem", nullable=false)
	private BigDecimal tem;
	
	@Enumerated(EnumType.STRING)
	@Column(name="frecuencia", nullable=false, length=10)
	private FrecuenciaCredito frecuencia;
	
	@Column(name="nroCuotas", nullable=false)
	private Integer nroCuotas;
	
	@Column(name="montoCuota", nullable=false)
	private BigDecimal montoCuota;
	
	@Column(name="fechaPrimeraCuota", nullable=false)
	private LocalDate fechaPrimeraCuota;
	
	@OneToMany(mappedBy="cuentaCredito", fetch = FetchType.LAZY, cascade=CascadeType.ALL) // default LAZY
	private List<DetalleCredito> detallesCredito;
	
	public CuentaCredito() {
		
	}

	public Integer getNroCondicion() {
		return nroCondicion;
	}

	public void setNroCondicion(Integer nroCondicion) {
		this.nroCondicion = nroCondicion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getMontoDesembolso() {
		return montoDesembolso;
	}

	public void setMontoDesembolso(BigDecimal montoDesembolso) {
		this.montoDesembolso = montoDesembolso;
	}

	public LocalDate getFechaDesembolso() {
		return fechaDesembolso;
	}

	public void setFechaDesembolso(LocalDate fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	public Usuario getUsuarioAprobador() {
		return usuarioAprobador;
	}

	public void setUsuarioAprobador(Usuario usuarioAprobador) {
		this.usuarioAprobador = usuarioAprobador;
	}

	public BigDecimal getCapitalInicial() {
		return capitalInicial;
	}

	public void setCapitalInicial(BigDecimal capitalInicial) {
		this.capitalInicial = capitalInicial;
	}

	public EstadoCredito getEstado() {
		return estado;
	}

	public void setEstado(EstadoCredito estado) {
		this.estado = estado;
	}

	public BigDecimal getTem() {
		return tem;
	}

	public void setTem(BigDecimal tem) {
		this.tem = tem;
	}

	public FrecuenciaCredito getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(FrecuenciaCredito frecuencia) {
		this.frecuencia = frecuencia;
	}

	public Integer getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(Integer nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public BigDecimal getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(BigDecimal montoCuota) {
		this.montoCuota = montoCuota;
	}

	public LocalDate getFechaPrimeraCuota() {
		return fechaPrimeraCuota;
	}

	public void setFechaPrimeraCuota(LocalDate fechaPrimeraCuota) {
		this.fechaPrimeraCuota = fechaPrimeraCuota;
	}

	public List<DetalleCredito> getDetallesCredito() {
		return detallesCredito;
	}

	public void setDetallesCredito(List<DetalleCredito> detallesCredito) {
		for(DetalleCredito detalleCredito: detallesCredito) {
			detalleCredito.setCuentaCredito(this);
		}
		this.detallesCredito = detallesCredito;
	}

		
}
