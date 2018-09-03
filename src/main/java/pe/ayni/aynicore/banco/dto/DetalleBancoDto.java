package pe.ayni.aynicore.banco.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleBancoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer idCuenta;
	
	private String fechaOperacion;
	
	private String nroOperacion;
	
	private BigDecimal montoOperacion;

	public DetalleBancoDto() {
	
	}

	public DetalleBancoDto(Integer idCuenta, String fechaOperacion, String nroOperacion, BigDecimal montoOperacion) {
		this.idCuenta = idCuenta;
		this.fechaOperacion = fechaOperacion;
		this.nroOperacion = nroOperacion;
		this.montoOperacion = montoOperacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(String fechaOperacion) {
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

	@Override
	public String toString() {
		return "DetalleBancoDto [id=" + id + ", idCuenta=" + idCuenta + ", fechaOperacion=" + fechaOperacion
				+ ", nroOperacion=" + nroOperacion + ", montoOperacion=" + montoOperacion + "]";
	}

}
