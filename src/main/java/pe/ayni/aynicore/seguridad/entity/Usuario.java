package pe.ayni.aynicore.seguridad.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.empleado.entity.Empleado;
import pe.ayni.aynicore.seguridad.constraint.UsuarioConstraint.EstadoUsuario;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="usuario", length=45)
	private String usuario;
	
	@Column(name="clave", nullable=false, length=68)
	private String clave;
	
	@Column(name="fechaAlta", nullable=false)
	private LocalDate fechaAlta;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="estado", nullable=false, length=10)
	private EstadoUsuario estado;
	
	@Column(name="fechaBaja", nullable=true)
	private LocalDate fechaBaja;
	
	@Column(name="fechaHoraInsercion", nullable=false)
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion", nullable=true)
	private LocalDateTime fechaHoraModificacion;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEmpleado", nullable=false, unique=true)
	private Empleado empleado;
	
	public Usuario() {
		
	}

	public Usuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public EstadoUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
