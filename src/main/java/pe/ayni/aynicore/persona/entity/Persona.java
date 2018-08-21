package pe.ayni.aynicore.persona.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import pe.ayni.aynicore.persona.constraint.PersonaConstraint.TipoIdentificacion;
import pe.ayni.aynicore.persona.constraint.PersonaConstraint.TipoPersona;

@Entity
@Table(name="Persona")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre", nullable=false, length=100, unique=true)
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoPersona", nullable=false, length=10)
	private TipoPersona tipoPersona;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoIdentificacion", nullable=false, length=10)
	private TipoIdentificacion tipoIdentificacion;
	
	@Column(name="nroIdentificacion", nullable=false, length=15, unique=true)
	private String nroIdentificacion;
	
	@Column(name="fechaRegistro", nullable=false)
	private LocalDate fechaRegistro;
	
	@Column(name="fechaHoraInsercion", nullable=false)
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion", nullable=true)
	private LocalDateTime fechaHoraModificacion;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY)
	private List<Direccion> direcciones;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY)
	private List<Telefono> telefonos;
	
	
	public Persona() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}


	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}


	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	public String getNroIdentificacion() {
		return nroIdentificacion;
	}


	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}


	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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


	public List<Direccion> getDirecciones() {
		return direcciones;
	}


	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}


	public List<Telefono> getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	
}
