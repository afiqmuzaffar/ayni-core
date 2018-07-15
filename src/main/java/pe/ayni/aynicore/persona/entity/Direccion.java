package pe.ayni.aynicore.persona.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.persona.constraint.Direccion.EstadoDireccion;
import pe.ayni.aynicore.persona.constraint.Direccion.TipoDireccion;
import pe.ayni.aynicore.persona.constraint.Direccion.TipoLocalidad;
import pe.ayni.aynicore.persona.constraint.Direccion.TipoVia;

@Entity
@Table(name="Direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable=false, length=10)
	private TipoDireccion tipo;
	
	@Column(name="departamento", nullable=false, length=45)
	private String departamento;
	
	@Column(name="provincia", nullable=false, length=45)
	private String provincia;
	
	@Column(name="distrito", nullable=false, length=45)
	private String distrito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUbigeo", nullable=false)
	private Ubigeo ubigeo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoVia", nullable=true, length=10)
	private TipoVia tipoVia;
	
	@Column(name="nombreVia", nullable=true, length=45)
	private String nombreVia;
	
	@Column(name="numeroVia", nullable=true, length=10)
	private String numeroVia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoLocalidad", nullable=true, length=15)
	private TipoLocalidad tipoLocalidad;
	
	@Column(name="nombreLocalidad", nullable=true, length=45)
	private String nombreLocalidad;
	
	@Column(name="manzana", nullable=true, length=10)
	private String manzana;
	
	@Column(name="lote", nullable=true, length=10)
	private String lote;
	
	@Column(name="interior", nullable=true, length=10)
	private String interior;
	
	@Column(name="referencia", nullable=false, length=200)
	private String referencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length=10)
	private EstadoDireccion estado;
	
	@Column(name="fechaHoraInsercion", nullable=false)
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion", nullable=true)
	private LocalDateTime fechaHoraModificacion;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona persona;
	
	
	public Direccion() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDireccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDireccion tipo) {
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

	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	public TipoVia getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(TipoVia tipoVia) {
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

	public TipoLocalidad getTipoLocalidad() {
		return tipoLocalidad;
	}

	public void setTipoLocalidad(TipoLocalidad tipoLocalidad) {
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

	public EstadoDireccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoDireccion estado) {
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
	
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", tipo=" + tipo + ", departamento=" + departamento + ", provincia=" + provincia
				+ ", distrito=" + distrito + ", ubigeo=" + ubigeo + ", tipoVia=" + tipoVia + ", nombreVia=" + nombreVia
				+ ", numeroVia=" + numeroVia + ", tipoLocalidad=" + tipoLocalidad + ", nombreLocalidad="
				+ nombreLocalidad + ", manzana=" + manzana + ", lote=" + lote + ", interior=" + interior
				+ ", referencia=" + referencia + ", estado=" + estado + ", fechaHoraInsercion=" + fechaHoraInsercion
				+ ", fechaHoraModificacion=" + fechaHoraModificacion + "]";
	}
	
}
