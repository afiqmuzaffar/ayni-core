package pe.ayni.aynicore.cliente.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PersonaNatual")
public class PersonaNatural {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="primerNombre")
	private String primerNombre;
	
	@Column(name="segundoNombre")
	private String segundoNombre;
	
	@Column(name="apellidoPaterno")
	private String apellidoPaterno;
	
	@Column(name="apellidoMaterno")
	private String apellidoMaterno;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="tipoDocumento")
	private String tipoDocumento;
	
	@Column(name="nroDocumento")
	private String nroDocumento;
	
	@Column(name="fechaNacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name="fechaRegistro")
	private LocalDate fechaRegistro;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idPersonaNatual")
	private List<Direccion> direcciones;
	
	@Column(name="fechaHoraInsercion")
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion")
	private LocalDateTime fechaHoraModificacion;
	
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
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

	@Override
	public String toString() {
		return "PersonaNatural [id=" + id + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo
				+ ", name=" + name + ", tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", email=" + email
				+ ", fechaHoraInsercion=" + fechaHoraInsercion + ", fechaHoraModificacion=" + fechaHoraModificacion
				+ "]";
	}
	
	
	
	
	
	

}
