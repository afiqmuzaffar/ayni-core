package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmortizacionCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idOperacion;
	
	private Integer idCuenta;
	
	private String moneda; // "0", "1": Soles, "2": Dolares
	
	private BigDecimal montoAmortizacion;
	
	private String viaRecaudo;
	
	private Integer idCuentaRecaudo;
	
	private String usuarioOperacion;

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
	
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
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
	
	public String getUsuarioOperacion() {
		return usuarioOperacion;
	}

	public void setUsuarioOperacion(String usuarioOperacion) {
		this.usuarioOperacion = usuarioOperacion;
	}

	@Override
	public String toString() {
		return "AmortizacionCreditoDto [idOperacion=" + idOperacion + ", idCuenta=" + idCuenta + ", moneda=" + moneda
				+ ", montoAmortizacion=" + montoAmortizacion + ", viaRecaudo=" + viaRecaudo + ", idCuentaRecaudo="
				+ idCuentaRecaudo + ", usuarioOperacion=" + usuarioOperacion + "]";
	}
}
