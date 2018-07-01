package pe.ayni.aynicore.cliente.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="departamento")
	private String departamento;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="distrito")
	private String distrito;
	
	@Column(name="idUbigeo")
	private Integer idUbigeo;
	
	@Column(name="tipoVia")
	private String tipoVia;
	
	@Column(name="numeroVia")
	private String numeroVia;
	
	@Column(name="tipoLocalidad")
	private String tipoLocalidad;
	
	@Column(name="nombreLocalidad")
	private String nombreLocalidad;
	
	@Column(name="manzana")
	private String manzana;
	
	@Column(name="lote")
	private String lote;
	
	@Column(name="interior")
	private String interior;
	
	@Column(name="referencia")
	private String referencia;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fechaHoraInsercion")
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion")
	private LocalDateTime fechaHoraModificacion;
	
	public Direccion() {
		
	}

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", tipo=" + tipo + ", departamento=" + departamento + ", provincia=" + provincia
				+ ", distrito=" + distrito + ", idUbigeo=" + idUbigeo + ", tipoVia=" + tipoVia + ", numeroVia="
				+ numeroVia + ", tipoLocalidad=" + tipoLocalidad + ", nombreLocalidad=" + nombreLocalidad + ", manzana="
				+ manzana + ", lote=" + lote + ", interior=" + interior + ", referencia=" + referencia + ", estado="
				+ estado + ", fechaHoraInsercion=" + fechaHoraInsercion + ", fechaHoraModificacion="
				+ fechaHoraModificacion + ", getId()=" + getId() + ", getTipo()=" + getTipo() + ", getDepartamento()="
				+ getDepartamento() + ", getProvincia()=" + getProvincia() + ", getDistrito()=" + getDistrito()
				+ ", getIdUbigeo()=" + getIdUbigeo() + ", getTipoVia()=" + getTipoVia() + ", getNumeroVia()="
				+ getNumeroVia() + ", getTipoLocalidad()=" + getTipoLocalidad() + ", getNombreLocalidad()="
				+ getNombreLocalidad() + ", getManzana()=" + getManzana() + ", getLote()=" + getLote()
				+ ", getInterior()=" + getInterior() + ", getReferencia()=" + getReferencia() + ", getEstado()="
				+ getEstado() + ", getFechaHoraInsercion()=" + getFechaHoraInsercion() + ", getFechaHoraModificacion()="
				+ getFechaHoraModificacion() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
		
}
