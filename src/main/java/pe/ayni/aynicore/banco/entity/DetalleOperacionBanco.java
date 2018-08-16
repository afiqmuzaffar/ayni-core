package pe.ayni.aynicore.banco.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.ayni.aynicore.operacion.entity.DetalleOperacion;

@Entity
@Table(name="DetalleOperacionBanco")
public class DetalleOperacionBanco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idCuenta", nullable=false)
	private CuentaBanco cuentaBanco;
	
	@Column(name="fechaOperacion", nullable=false)
	private LocalDate fechaOperacion;
	
	@Column(name="nroOperacion", nullable=false, length=15)
	private String nroOperacion;
	
	@Column(name="montoOperacion", nullable=false)
	private BigDecimal montoOperacion;
	
	@OneToMany(mappedBy="detalleOperacionBanco", fetch=FetchType.LAZY)
	private List<DetalleOperacion> detallesOperacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CuentaBanco getCuentaBanco() {
		return cuentaBanco;
	}

	public void setCuentaBanco(CuentaBanco cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	public LocalDate getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(LocalDate fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public String getNroOperacion() {
		return nroOperacion;
	}

	public void setNroOperacion(String nroOperacion) {
		this.nroOperacion = nroOperacion;
	}

	public BigDecimal getMontoOperacion() {
		return montoOperacion;
	}

	public void setMontoOperacion(BigDecimal montoOperacion) {
		this.montoOperacion = montoOperacion;
	}

	public List<DetalleOperacion> getDetallesOperacion() {
		return detallesOperacion;
	}

	public void setDetallesOperacion(List<DetalleOperacion> detallesOperacion) {
		this.detallesOperacion = detallesOperacion;
	} 
	
}
