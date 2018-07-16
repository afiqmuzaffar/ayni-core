package pe.ayni.aynicore.persona.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.persona.constraint.Telefono.EstadoTelefono;
import pe.ayni.aynicore.persona.constraint.Telefono.TipoTelefono;


@Entity
@Table(name="Telefono")
public class Telefono {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable=false, length=10)
	private TipoTelefono tipo;
	
	@Column(name="numero", nullable=false, length=10)
	private String numero;
	
	@Column(name="codTelefonicoDpto", nullable=true)
	private Integer codTelefonicoDpto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length=10)
	private EstadoTelefono estado;
	
	@Column(name="fechaHoraInsercion", nullable=false)
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion", nullable=true)
	private LocalDateTime fechaHoraModificacion;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona persona;
	
	
	public Telefono() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoTelefono getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefono tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCodTelefonicoDpto() {
		return codTelefonicoDpto;
	}

	public void setCodTelefonicoDpto(Integer codTelefonicoDpto) {
		this.codTelefonicoDpto = codTelefonicoDpto;
	}

	public EstadoTelefono getEstado() {
		return estado;
	}

	public void setEstado(EstadoTelefono estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaHoraInsercion() {
		return fechaHoraInsercion;
	}

	public void setFechaHoraInsercion(LocalDateTime fechaHoraInsercion) {
		this.fechaHoraInsercion = fechaHoraInsercion;
	}

	public LocalDateTime getFechaHoraModificacion() {
		return fechaHoraModificacion;
	}

	public void setFechaHoraModificacion(LocalDateTime fechaHoraModificacion) {
		this.fechaHoraModificacion = fechaHoraModificacion;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", tipo=" + tipo + ", numero=" + numero + ", codTelefonicoDpto="
				+ codTelefonicoDpto + ", estado=" + estado + ", fechaHoraInsercion=" + fechaHoraInsercion
				+ ", fechaHoraModificacion=" + fechaHoraModificacion + "]";
	}
	
}
