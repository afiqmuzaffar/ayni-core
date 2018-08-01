package pe.ayni.aynicore.empleado.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pe.ayni.aynicore.empleado.constraint.EmpleadoConstraint.EstadoEmpleado;
import pe.ayni.aynicore.persona.entity.PersonaNatural;

@Entity
@Table(name="Empleado")
@PrimaryKeyJoinColumn(name = "id")
public class Empleado extends PersonaNatural{
	
	@Column(name="fechaIngreso", nullable = false)
	private LocalDate fechaIngreso;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length=10)
	private EstadoEmpleado estado;
	
	@Column(name="fechaCese", nullable=true)
	private LocalDate fechaCese;
	
	@Column(name="fechaHoraInsercion", nullable=false)
	private LocalDateTime fechaHoraInsercion;
	
	@Column(name="fechaHoraModificacion", nullable=true)
	private LocalDateTime fechaHoraModificacion;
	
	public Empleado() {

	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public EstadoEmpleado getEstado() {
		return estado;
	}

	public void setEstado(EstadoEmpleado estado) {
		this.estado = estado;
	}

	public LocalDate getFechaCese() {
		return fechaCese;
	}

	public void setFechaCese(LocalDate fechaCese) {
		this.fechaCese = fechaCese;
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
	
	
	

}
