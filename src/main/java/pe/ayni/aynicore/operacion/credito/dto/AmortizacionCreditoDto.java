package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.ayni.aynicore.banco.dto.DetalleBancoDto;
import pe.ayni.aynicore.cliente.dto.ClienteDto;
import pe.ayni.aynicore.operacion.dto.OperacionDto;

public class AmortizacionCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCuenta;
	
	private Cliente cliente;
	
	private Operacion operacion;
	
	private DetalleBanco detalleBanco;

	public AmortizacionCreditoDto() {
		
	}

	public AmortizacionCreditoDto(DetalleBancoDto detalleBanco, OperacionDto operacion, ClienteDto cliente) {
		this.idCuenta = operacion.getDetallesOperacion().stream().filter(e -> (e.getCredito().compareTo(BigDecimal.ZERO) > 0)).findFirst().get().getIdCuenta();
		this.cliente = new Cliente(cliente.getId(), cliente.getNombre(), cliente.getTipoIdentificacion(), cliente.getNroIdentificacion());
		this.operacion = new Operacion(operacion);
		this.detalleBanco = detalleBanco == null? null: new DetalleBanco(detalleBanco);

	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public DetalleBanco getDetalleBanco() {
		return detalleBanco;
	}

	public void setDetalleBanco(DetalleBanco detalleBanco) {
		this.detalleBanco = detalleBanco;
	}
	
	@Override
	public String toString() {
		return "AmortizacionCreditoDto [idCuenta=" + idCuenta + ", cliente=" + cliente + ", operacion=" + operacion
				+ ", detalleBanco=" + detalleBanco + "]";
	}

	public static class DetalleBanco {
		
		private Integer id;
		
		private String nroOperacion;
		
		private String fechaOperacion;
		
		private BigDecimal montoOperacion;
		
		public DetalleBanco() {
			
		}
		
		public DetalleBanco(DetalleBancoDto detalleBanco) {
			this.id = detalleBanco.getId();
			this.nroOperacion = detalleBanco.getNroOperacion();
			this.fechaOperacion = detalleBanco.getFechaOperacion();
			this.montoOperacion = detalleBanco.getMontoOperacion();
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
	

	
	
	public class Cliente {
		private Integer id;
		
		private String nombre;
		
		private String tipoIdentificacion;
		
		private String nroIdentificacion;
		
		public Cliente() {
		}
		
		public Cliente(Integer id, String nombre, String tipoIdentificacion, String nroIdentificacion) {
			this.id = id;
			this.nombre = nombre;
			this.tipoIdentificacion = tipoIdentificacion;
			this.nroIdentificacion = nroIdentificacion;
		}



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTipoIdentificacion() {
			return tipoIdentificacion;
		}

		public void setTipoIdentificacion(String tipoIdentificacion) {
			this.tipoIdentificacion = tipoIdentificacion;
		}

		public String getNroIdentificacion() {
			return nroIdentificacion;
		}

		public void setNroIdentificacion(String nroIdentificacion) {
			this.nroIdentificacion = nroIdentificacion;
		}

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombre=" + nombre + ", tipoIdentificacion=" + tipoIdentificacion
					+ ", nroIdentificacion=" + nroIdentificacion + "]";
		}
		
	}
	
	
	public class Operacion {
		
		private Integer id;
		
		private BigDecimal monto;
		
		private String moneda; // "0", "1": Soles, "2": Dolares
		
		private String fechaOperacion;
		
		private String horaOperacion;

		private String usuario;
		
		private String tipoOperacion;
		
		private String tipoCuentaRecaudo;
		
		private Integer idCuentaRecaudo;
		
		public Operacion() {
		}

		public Operacion(OperacionDto operacion) {
			this.id = operacion.getId();
			this.monto = operacion.getMonto();
			this.moneda = operacion.getMoneda();
			this.fechaOperacion = operacion.getFechaOperacion();
			this.horaOperacion = operacion.getHoraOperacion();
			this.usuario = operacion.getUsuario();
			this.tipoOperacion = operacion.getTipoOperacion();
			this.tipoCuentaRecaudo = operacion.getDetallesOperacion().stream().findFirst().get().getTipoCuenta();
			this.idCuentaRecaudo = operacion.getDetallesOperacion().stream().findFirst().get().getIdCuenta();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public BigDecimal getMonto() {
			return monto;
		}

		public void setMonto(BigDecimal monto) {
			this.monto = monto;
		}

		public String getMoneda() {
			return moneda;
		}

		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}

		public String getFechaOperacion() {
			return fechaOperacion;
		}

		public void setFechaOperacion(String fechaOperacion) {
			this.fechaOperacion = fechaOperacion;
		}

		public String getHoraOperacion() {
			return horaOperacion;
		}

		public void setHoraOperacion(String horaOperacion) {
			this.horaOperacion = horaOperacion;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getTipoOperacion() {
			return tipoOperacion;
		}

		public void setTipoOperacion(String tipoOperacion) {
			this.tipoOperacion = tipoOperacion;
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

		@Override
		public String toString() {
			return "Operacion [id=" + id + ", monto=" + monto + ", moneda=" + moneda + ", fechaOperacion="
					+ fechaOperacion + ", horaOperacion=" + horaOperacion + ", usuario=" + usuario + ", tipoOperacion="
					+ tipoOperacion + ", tipoCuentaRecaudo=" + tipoCuentaRecaudo + ", idCuentaRecaudo="
					+ idCuentaRecaudo + "]";
		}
		
	}
		
	
}
