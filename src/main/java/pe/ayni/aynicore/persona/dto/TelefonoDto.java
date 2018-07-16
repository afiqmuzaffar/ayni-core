package pe.ayni.aynicore.persona.dto;

import java.io.Serializable;

public class TelefonoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;
	private String codTelefonicoDpto;
	private String numero;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodTelefonicoDpto() {
		return codTelefonicoDpto;
	}
	public void setCodTelefonicoDpto(String codTelefonicoDpto) {
		this.codTelefonicoDpto = codTelefonicoDpto;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
