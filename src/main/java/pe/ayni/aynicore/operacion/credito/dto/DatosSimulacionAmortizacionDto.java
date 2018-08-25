package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DatosSimulacionAmortizacionDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idCuenta;
	
	private BigDecimal montoAmortizacion;

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public BigDecimal getMontoAmortizacion() {
		return montoAmortizacion;
	}

	public void setMontoAmortizacion(BigDecimal montoAmortizacion) {
		this.montoAmortizacion = montoAmortizacion;
	}
	
	

}
