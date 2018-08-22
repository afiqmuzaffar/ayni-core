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
import javax.persistence.Table;

import pe.ayni.aynicore.seguridad.entity.Usuario;

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
	private CuentaContable cuentaContable;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarioResponsable", nullable=false)
	private Usuario responsable;
	
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

	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}
	
	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", moneda=" + moneda + ", cuentaContable=" + cuentaContable + ", responsable="
				+ responsable + "]";
	}
	
}
