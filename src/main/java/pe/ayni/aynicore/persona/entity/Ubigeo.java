package pe.ayni.aynicore.persona.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ubigeo")
public class Ubigeo {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="codDpto", nullable=false, length=2)
	private String codDpto;
	
	@Column(name="codProvincia", nullable=false, length=2)
	private String codProvincia;
	
	@Column(name="codDistrito", nullable=false, length=2)
	private String codDistrito;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	public Ubigeo() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodDpto() {
		return codDpto;
	}

	public void setCodDpto(String codDpto) {
		this.codDpto = codDpto;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ubigeo [id=" + id + ", codDpto=" + codDpto + ", codProvincia=" + codProvincia + ", codDistrito="
				+ codDistrito + ", nombre=" + nombre + ", getId()=" + getId() + ", getCodDpto()=" + getCodDpto()
				+ ", getCodProvincia()=" + getCodProvincia() + ", getCodDistrito()=" + getCodDistrito()
				+ ", getNombre()=" + getNombre() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
