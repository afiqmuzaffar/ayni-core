package pe.ayni.aynicore.persona.dto;

import java.io.Serializable;

public class DireccionDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String tipo;
	
	private String departamento;
	
	private String provincia;
	
	private String distrito;
	
	private Integer idUbigeo;
	
	private String tipoVia;
	
	private String nombreVia;
	
	private String numeroVia;
	
	private String tipoLocalidad;
	
	private String nombreLocalidad;
	
	private String manzana;
	
	private String lote;
	
	private String interior;
	
	private String referencia;
	
	private Integer idPersona;
	
	private Integer idUbigeoDpto;
	
	private Integer idUbigeoProvincia;
	
	private Integer idUbigeoDistrito;
	
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Integer getIdUbigeo() {
		return idUbigeo;
	}

	public void setIdUbigeo(Integer idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(String numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getTipoLocalidad() {
		return tipoLocalidad;
	}

	public void setTipoLocalidad(String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public String getManzana() {
		return manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdUbigeoDpto() {
		return idUbigeoDpto;
	}

	public void setIdUbigeoDpto(Integer idUbigeoDpto) {
		this.idUbigeoDpto = idUbigeoDpto;
	}

	public Integer getIdUbigeoProvincia() {
		return idUbigeoProvincia;
	}

	public void setIdUbigeoProvincia(Integer idUbigeoProvincia) {
		this.idUbigeoProvincia = idUbigeoProvincia;
	}

	public Integer getIdUbigeoDistrito() {
		return idUbigeoDistrito;
	}

	public void setIdUbigeoDistrito(Integer idUbigeoDistrito) {
		this.idUbigeoDistrito = idUbigeoDistrito;
	}

}
