package pe.ayni.aynicore.cuenta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.empleado.entity.Empleado;

@Entity
@Table(name="Cuenta")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cuenta {
	
	@Id
	@Column(name="idCuenta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCuenta;
	
	@Column(name="moneda", nullable=false, length=1)
	private String moneda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ctaContable", nullable=false)
	private CuentaContable ctaContable;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEmpleado", nullable=false, unique=true)
	private Empleado responsable;
	
	public Cuenta() {
		
	}
	
	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	public Empleado getResponsable() {
		return responsable;
	}

	public CuentaContable getCtaContable() {
		return ctaContable;
	}

	public void setCtaContable(CuentaContable ctaContable) {
		this.ctaContable = ctaContable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", moneda=" + moneda + ", ctaContable=" + ctaContable + ", responsable="
				+ responsable + "]";
	}
	
}
