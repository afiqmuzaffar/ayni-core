package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmortizacionCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idOperacion;
	
	private Integer idCuenta;
	
	private BigDecimal montoAmortizacion;
	
	private String viaRecaudo;
	
	private Integer idCuentaRecaudo;

	public Integer getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}

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

	public String getViaRecaudo() {
		return viaRecaudo;
	}

	public void setViaRecaudo(String viaRecaudo) {
		this.viaRecaudo = viaRecaudo;
	}

	public Integer getIdCuentaRecaudo() {
		return idCuentaRecaudo;
	}

	public void setIdCuentaRecaudo(Integer idCuentaRecaudo) {
		this.idCuentaRecaudo = idCuentaRecaudo;
	}

	@Override
	public String toString() {
		return "AmortizacionCreditoDto [idOperacion=" + idOperacion + ", idCuenta=" + idCuenta + ", montoAmortizacion="
				+ montoAmortizacion + ", viaRecaudo=" + viaRecaudo + ", idCuentaRecaudo=" + idCuentaRecaudo + "]";
	}
	
}
