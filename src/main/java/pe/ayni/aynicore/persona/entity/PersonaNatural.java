package pe.ayni.aynicore.persona.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import pe.ayni.aynicore.persona.constraint.PersonaNatural.Sexo;
import pe.ayni.aynicore.utils.LocalDateDeserializer;
import pe.ayni.aynicore.utils.LocalDateSerializer;

@Entity
@Table(name="PersonaNatural")
@PrimaryKeyJoinColumn(name = "id")
public class PersonaNatural extends Persona{
	
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

	@Column(name="fechaNacimiento", nullable=false)
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class) 
	private LocalDate fechaNacimiento;
	
	@Column(name="email", nullable=true, length=45)
	private String email;
	
	public PersonaNatural() {
		
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNombre() {
		super.setNombre(apellidoPaterno + " " + apellidoMaterno + " " + primerNombre + " " + segundoNombre );
	}
	
	
}