package pe.ayni.aynicore.cliente.dto;

import java.io.Serializable;

import pe.ayni.aynicore.persona.dto.PersonaNaturalDto;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String fechaRegistro;
	
	private String fechaAfiliacion;
	
	private PersonaNaturalDto personaNatural;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public PersonaNaturalDto getPersonaNatural() {
		return personaNatural;
	}

	public void setPersonaNaturalDto(PersonaNaturalDto personaNatural) {
		this.personaNatural = personaNatural;
	}
	
	

}