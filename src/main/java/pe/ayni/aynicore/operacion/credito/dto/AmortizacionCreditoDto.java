package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.ayni.aynicore.operacion.dto.OperacionDto;

public class AmortizacionCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idOperacion;
	
	private Integer idCuenta;
	
	private String moneda; // "0", "1": Soles, "2": Dolares
	
	private BigDecimal montoAmortizacion;
	
	private String tipoCuentaRecaudo;
	
	private Integer idCuentaRecaudo;
	
	private String usuarioOperacion;
	
	public AmortizacionCreditoDto() {
		
	}

	public AmortizacionCreditoDto(OperacionDto operacion) {
		this.idOperacion = operacion.getId();
		this.idCuenta = operacion.getDetallesOperacion().stream().filter(e -> (e.getCredito().compareTo(BigDecimal.ZERO) > 0)).findFirst().get().getIdCuenta();
		this.moneda = operacion.getMoneda();
		this.montoAmortizacion = operacion.getMonto();
		this.tipoCuentaRecaudo = operacion.getDetallesOperacion().stream().findFirst().get().getTipoCuenta();
		this.idCuentaRecaudo = operacion.getDetallesOperacion().stream().findFirst().get().getIdCuenta();
		this.usuarioOperacion = operacion.getUsuario();
	}

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

	public String getTipoCuentaRecaudo() {
		return tipoCuentaRecaudo;
	}

	public void setTipoCuentaRecaudo(String tipoCuentaRecaudo) {
		this.tipoCuentaRecaudo = tipoCuentaRecaudo;
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
				+ ", montoAmortizacion=" + montoAmortizacion + ", tipoCuentaRecaudo=" + tipoCuentaRecaudo
				+ ", idCuentaRecaudo=" + idCuentaRecaudo + ", usuarioOperacion=" + usuarioOperacion + "]";
	}

}
