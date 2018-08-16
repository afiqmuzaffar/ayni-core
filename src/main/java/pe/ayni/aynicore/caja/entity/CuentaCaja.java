package pe.ayni.aynicore.caja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pe.ayni.aynicore.caja.constraint.CajaConstraint.EstadoCaja;
import pe.ayni.aynicore.cuenta.entity.Cuenta;

@Entity
@Table(name="CuentaCaja")
@PrimaryKeyJoinColumn(name="idCuenta")
public class CuentaCaja extends Cuenta {
	
	@Column(name="nombre", nullable=false, unique=true, length=45)
	private String nombre;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="estado", nullable=false, length=10)
	private EstadoCaja estado;
	
	public CuentaCaja() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoCaja getEstado() {
		return estado;
	}

	public void setEstado(EstadoCaja estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CuentaCaja [nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
