package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.operacion.dto.OperacionDto;


public class DesembolsoCreditoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Credito credito;
	
	private Cliente cliente;
	
	private Operacion operacion;
	
	public DesembolsoCreditoDto() {
		
	}
	
	public DesembolsoCreditoDto(CreditoDto credito, OperacionDto operacion) {
		this.credito = new Credito(credito);
		this.cliente = new Cliente(credito.getCliente().getId(), credito.getCliente().getNombre(), credito.getCliente().getTipoIdentificacion(), credito.getCliente().getNroIdentificacion());
		this.operacion = new Operacion(operacion);
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
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
	
	@Override
	public String toString() {
		return "DesembolsoCreditoDto [credito=" + credito + ", cliente=" + cliente + ", operacion=" + operacion + "]";
	}



	public class Operacion {
		private Integer id;
		
		private BigDecimal monto;
		
		private String moneda; // "0", "1": Soles, "2": Dolares
		
		private String fechaOperacion;
		
		private String horaOperacion;

		private String usuario;
		
		private String tipoOperacion;
		
		private String tipoCuentaDesembolso;
		
		private Integer idCuentaDesembolso;

		public Operacion() {
		}

		public Operacion(OperacionDto operacion) {
			this.id = operacion.getId();
			this.moneda = operacion.getMoneda();
			this.monto = operacion.getMonto();
			this.tipoOperacion = operacion.getTipoOperacion();
			this.fechaOperacion = operacion.getFechaOperacion();
			this.horaOperacion = operacion.getHoraOperacion();
			this.usuario = operacion.getUsuario();
			this.tipoCuentaDesembolso = operacion.getDetallesOperacion().stream().filter(e -> e.getNroDetalle().equals(1)).findFirst().get().getTipoCuenta();
			this.idCuentaDesembolso = operacion.getDetallesOperacion().stream().filter(e -> e.getNroDetalle().equals(1)).findFirst().get().getIdCuenta();
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

		public String getTipoCuentaDesembolso() {
			return tipoCuentaDesembolso;
		}

		public void setTipoCuentaDesembolso(String tipoCuentaDesembolso) {
			this.tipoCuentaDesembolso = tipoCuentaDesembolso;
		}

		public Integer getIdCuentaDesembolso() {
			return idCuentaDesembolso;
		}

		public void setIdCuentaDesembolso(Integer idCuentaDesembolso) {
			this.idCuentaDesembolso = idCuentaDesembolso;
		}

		@Override
		public String toString() {
			return "Operacion [id=" + id + ", monto=" + monto + ", moneda=" + moneda + ", fechaOperacion="
					+ fechaOperacion + ", horaOperacion=" + horaOperacion + ", usuario=" + usuario + ", tipoOperacion="
					+ tipoOperacion + ", tipoCuentaDesembolso=" + tipoCuentaDesembolso + ", idCuentaDesembolso="
					+ idCuentaDesembolso + ", getId()=" + getId() + ", getMonto()=" + getMonto() + ", getMoneda()="
					+ getMoneda() + ", getFechaOperacion()=" + getFechaOperacion() + ", getHoraOperacion()="
					+ getHoraOperacion() + ", getUsuario()=" + getUsuario() + ", getTipoOperacion()="
					+ getTipoOperacion() + ", getTipoCuentaDesembolso()=" + getTipoCuentaDesembolso()
					+ ", getIdCuentaDesembolso()=" + getIdCuentaDesembolso() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		
	}
	
	public class Credito {
		private Integer idCuenta;
		
		private BigDecimal montoDesembolso;
		
		private String moneda; 
		
		private String frecuencia;
		
		private BigDecimal tem;
		
		private Integer nroCuotas;
		
		private String fechaDesembolso;
		
		private String fechaPrimeraCuota;
		
		private String usuarioAprobador;
		
		private String usuarioResponsable;
		
		public Credito() {
			
		}
		
		public Credito(CreditoDto credito) {
			this.idCuenta = credito.getIdCuenta();
			this.montoDesembolso = credito.getMontoDesembolso();
			this.moneda = credito.getMoneda();
			this.frecuencia = credito.getFrecuencia();
			this.tem = credito.getTem();
			this.nroCuotas = credito.getNroCuotas();
			this.fechaDesembolso = credito.getFechaDesembolso();
			this.fechaPrimeraCuota = credito.getFechaPrimeraCuota();
			this.usuarioAprobador = credito.getUsuarioAprobador();
			this.usuarioResponsable = credito.getUsuarioResponsable();
		}

		public Integer getIdCuenta() {
			return idCuenta;
		}

		public void setIdCuenta(Integer idCuenta) {
			this.idCuenta = idCuenta;
		}

		public BigDecimal getMontoDesembolso() {
			return montoDesembolso;
		}

		public void setMontoDesembolso(BigDecimal montoDesembolso) {
			this.montoDesembolso = montoDesembolso;
		}

		public String getMoneda() {
			return moneda;
		}

		public void setMoneda(String moneda) {
			this.moneda = moneda;
		}

		public String getFrecuencia() {
			return frecuencia;
		}

		public void setFrecuencia(String frecuencia) {
			this.frecuencia = frecuencia;
		}

		public BigDecimal getTem() {
			return tem;
		}

		public void setTem(BigDecimal tem) {
			this.tem = tem;
		}

		public Integer getNroCuotas() {
			return nroCuotas;
		}

		public void setNroCuotas(Integer nroCuotas) {
			this.nroCuotas = nroCuotas;
		}

		public String getFechaDesembolso() {
			return fechaDesembolso;
		}

		public void setFechaDesembolso(String fechaDesembolso) {
			this.fechaDesembolso = fechaDesembolso;
		}

		public String getFechaPrimeraCuota() {
			return fechaPrimeraCuota;
		}

		public void setFechaPrimeraCuota(String fechaPrimeraCuota) {
			this.fechaPrimeraCuota = fechaPrimeraCuota;
		}

		public String getUsuarioAprobador() {
			return usuarioAprobador;
		}

		public void setUsuarioAprobador(String usuarioAprobador) {
			this.usuarioAprobador = usuarioAprobador;
		}

		public String getUsuarioResponsable() {
			return usuarioResponsable;
		}

		public void setUsuarioResponsable(String usuarioResponsable) {
			this.usuarioResponsable = usuarioResponsable;
		}

		@Override
		public String toString() {
			return "Credito [idCuenta=" + idCuenta + ", montoDesembolso=" + montoDesembolso + ", moneda=" + moneda
					+ ", frecuencia=" + frecuencia + ", tem=" + tem + ", nroCuotas=" + nroCuotas + ", fechaDesembolso="
					+ fechaDesembolso + ", fechaPrimeraCuota=" + fechaPrimeraCuota + ", usuarioAprobador="
					+ usuarioAprobador + ", usuarioResponsable=" + usuarioResponsable + "]";
		}
		
	}
	
	public class Cliente {
		
		private Integer id;
		
		private String nombre;
		
		private String tipoIdentificacion;
		
		private String nroIdentificacion;
		
		public Cliente() {
			
		}
		
		public Cliente (Integer id) {
			this.id = id;
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

	
}
