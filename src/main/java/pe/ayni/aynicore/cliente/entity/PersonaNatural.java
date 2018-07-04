package pe.ayni.aynicore.cliente.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import pe.ayni.aynicore.cliente.constraint.PersonaNatural.Sexo;
import pe.ayni.aynicore.cliente.constraint.PersonaNatural.TipoDocumento;
import pe.ayni.aynicore.utils.LocalDateDeserializer;
import pe.ayni.aynicore.utils.LocalDateSerializer;

@Entity
@Table(name="PersonaNatural")
public class PersonaNatural {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="primerNombre", nullable=false, length=45)
	private String primerNombre;
	
	@Column(name="segundoNombre", nullable=true, length=45)
	private String segundoNombre;
	
	@Column(name="apellidoPaterno", nullable=false, length=45)
	private String apellidoPaterno;
	
	@Column(name="apellidoMaterno", nullable=true, length=45)
	private String apellidoMaterno;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sexo", nullable=false, length=10)
	private Sexo sexo;
	
	@Column(name="nombre", nullable=false, length=100, unique=true)
	private String nombre;

	@Enumerated(EnumType.STRING)
	@Column(name="tipoDocumento", nullable=false, length=10)
	private TipoDocumento tipoDocumento;
	
	@Column(name="nroDocumento", nullable=false, length=10, unique=true)
	private String nroDocumento;
	
	@Column(name="fechaNacimiento", nullable=false)
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class) 
	private LocalDate fechaNacimiento;
	
	@Column(name="fechaRegistro", nullable=false)
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class) 
	private LocalDate fechaRegistro;
	
	@Column(name="email", nullable=true, length=45)
	private String email;
	
	@Column(name="fechaHoraInsercion", nullable=false)
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion", nullable=true)
	private LocalDateTime fechaHoraModificacion;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idPersonaNatural", nullable=false)
	private Set<Direccion> direcciones;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idPersonaNatural", nullable=false)
	private Set<Telefono> telefonos;
	
	public PersonaNatural() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "PersonaNatural [id=" + id + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo
				+ ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", email=" + email
				+ ", fechaHoraInsercion=" + fechaHoraInsercion + ", fechaHoraModificacion=" + fechaHoraModificacion
				+ ", direcciones=" + direcciones + ", telefonos=" + telefonos + "]";
	}
	
}
