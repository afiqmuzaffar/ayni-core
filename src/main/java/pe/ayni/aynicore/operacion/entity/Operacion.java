package pe.ayni.aynicore.operacion.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.operacion.constraint.OperacionConstraint.TipoOperacion;
import pe.ayni.aynicore.seguridad.entity.Usuario;

@Entity
@Table(name="Operacion")
public class Operacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="monto", nullable=false)
	private BigDecimal monto;
	
	@Column(name="moneda", nullable=false, length=1)
	private String moneda;
	
	@Column(name="fechaOperacion", nullable=false)
	private LocalDate fechaOperacion;
	
	@Column(name="horaOperacion", nullable=false)
	private LocalTime horaOperacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario", nullable=false)
	private Usuario usuario;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="tipoOperacion", nullable=false, length=20)
	private TipoOperacion tipoOperacion;
	
	@Column(name="nota", nullable=false, length=200)
	private String nota;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idOperacionRelacionada", nullable=true, unique=true)
	private Operacion operacionRelacionada;
	
	@OneToMany(mappedBy="operacion", fetch = FetchType.LAZY, cascade=CascadeType.ALL) // default LAZY
	private List<DetalleOperacion> detallesOperacion;
	
	
	public Operacion() {
		
	}

	public Operacion(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public LocalDate getFechaOperacion() {
		return fechaOperacion;
	}


	public void setFechaOperacion(LocalDate fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}


	public LocalTime getHoraOperacion() {
		return horaOperacion;
	}


	public void setHoraOperacion(LocalTime horaOperacion) {
		this.horaOperacion = horaOperacion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}


	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}


	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public Operacion getOperacionRelacionada() {
		return operacionRelacionada;
	}


	public void setOperacionRelacionada(Operacion operacionRelacionada) {
		this.operacionRelacionada = operacionRelacionada;
	}


	public List<DetalleOperacion> getDetallesOperacion() {
		return detallesOperacion;
	}


	public void setDetallesOperacion(List<DetalleOperacion> detallesOperacion) {
		for (DetalleOperacion detalleOperacion: detallesOperacion) {
			detalleOperacion.setOperacion(this);
		}
		this.detallesOperacion = detallesOperacion;
	}

	
}
