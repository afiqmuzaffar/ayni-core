package pe.ayni.aynicore.persona.dto;

import java.io.Serializable;

public class PersonaNaturalDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nombre;
	
	private String tipoPersona;
	
	private String tipoIdentificacion;
	
	private String nroIdentificacion;
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String sexo;

	private String fechaNacimiento;
	
	private String email;
	
	private String estadoCivil;
	
	private Boolean esCliente;
	
	private Integer idCliente; 
	
	public PersonaNaturalDto(){
		
	}
	
	public PersonaNaturalDto(Integer id, String nombre, String tipoPersona, String tipoIdentificacion,
			String nroIdentificacion, String primerNombre, String segundoNombre, String apellidoPaterno,
			String apellidoMaterno, String sexo, String fechaNacimiento, String email, String estadoCivil,
			Boolean esCliente, Integer idCliente) {
		this.id = id;
		this.nombre = nombre;
		this.tipoPersona = tipoPersona;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nroIdentificacion = nroIdentificacion;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.esCliente = esCliente;
		this.idCliente = idCliente;
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

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNroIdentificacion() {
		return nroIdentificacion;
	}

	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Boolean getEsCliente() {
		return esCliente;
	}

	public void setEsCliente(Boolean esCliente) {
		this.esCliente = esCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "PersonaNaturalDto [id=" + id + ", nombre=" + nombre + ", tipoPersona=" + tipoPersona
				+ ", tipoIdentificacion=" + tipoIdentificacion + ", nroIdentificacion=" + nroIdentificacion
				+ ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo + ", fechaNacimiento="
				+ fechaNacimiento + ", email=" + email + ", estadoCivil=" + estadoCivil + ", esCliente=" + esCliente
				+ ", idCliente=" + idCliente + "]";
	}
	
	
	
}
