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
	
	private DetalleBanco detalleBanco;
	
	
	public static class DetalleBanco {
		
		private Integer id;
		
		private String nroOperacion;
		
		private String fechaOperacion;
		
		private BigDecimal montoOperacion;
		
		public DetalleBanco() {
			
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNroOperacion() {
			return nroOperacion;
		}

		public void setNroOperacion(String nroOperacion) {
			this.nroOperacion = nroOperacion;
		}

		public String getFechaOperacion() {
			return fechaOperacion;
		}

		public void setFechaOperacion(String fechaOperacion) {
			this.fechaOperacion = fechaOperacion;
		}

		public BigDecimal getMontoOperacion() {
			return montoOperacion;
		}

		public void setMontoOperacion(BigDecimal montoOperacion) {
			this.montoOperacion = montoOperacion;
		}

		@Override
		public String toString() {
			return "DetalleBanco [id=" + id + ", nroOperacion=" + nroOperacion + ", fechaOperacion=" + fechaOperacion
					+ ", montoOperacion=" + montoOperacion + "]";
		}
		
		
	}
	
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
	
	public DetalleBanco getDetalleBanco() {
		return detalleBanco;
	}

	public void setDetalleBanco(DetalleBanco detalleBanco) {
		this.detalleBanco = detalleBanco;
	}

	@Override
	public String toString() {
		return "AmortizacionCreditoDto [idOperacion=" + idOperacion + ", idCuenta=" + idCuenta + ", moneda=" + moneda
				+ ", montoAmortizacion=" + montoAmortizacion + ", tipoCuentaRecaudo=" + tipoCuentaRecaudo
				+ ", idCuentaRecaudo=" + idCuentaRecaudo + ", usuarioOperacion=" + usuarioOperacion + ", detalleBanco="
				+ detalleBanco + "]";
	}

	
}
