package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class DesembolsoCreditoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal montoDesembolso;
	
	private String moneda; // "0", "1": Soles, "2": Dolares
	
	private String frecuencia;
	
	private BigDecimal tem;
	
	private Integer nroCuotas;
	
	private String fechaDesembolso;
	
	private String fechaPrimeraCuota;
	
	private Cliente cliente;
	
	private String viaDesembolso;
	
	private Integer idCuentaDesembolso;
	
	private String usuarioAprobador;
	
	private String responsableCuenta;
	
	private String usuarioOperacion;
	
	public DesembolsoCreditoDto() {
		
	}
	public DesembolsoCreditoDto(BigDecimal montoDesembolso, String moneda, String frecuencia, BigDecimal tem,
			Integer nroCuotas, String fechaDesembolso, String fechaPrimeraCuota, Cliente cliente,
			String viaDesembolso, Integer idCuentaDesembolso, String usuarioAprobador, String responsableCuenta,
			String usuarioOperacion) {
		this.montoDesembolso = montoDesembolso;
		this.moneda = moneda;
		this.frecuencia = frecuencia;
		this.tem = tem;
		this.nroCuotas = nroCuotas;
		this.fechaDesembolso = fechaDesembolso;
		this.fechaPrimeraCuota = fechaPrimeraCuota;
		this.cliente = cliente;
		this.viaDesembolso = viaDesembolso;
		this.idCuentaDesembolso = idCuentaDesembolso;
		this.usuarioAprobador = usuarioAprobador;
		this.responsableCuenta = responsableCuenta;
		this.usuarioOperacion = usuarioOperacion;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getViaDesembolso() {
		return viaDesembolso;
	}

	public void setViaDesembolso(String viaDesembolso) {
		this.viaDesembolso = viaDesembolso;
	}

	public Integer getIdCuentaDesembolso() {
		return idCuentaDesembolso;
	}

	public void setIdCuentaDesembolso(Integer idCuentaDesembolso) {
		this.idCuentaDesembolso = idCuentaDesembolso;
	}

	public String getUsuarioAprobador() {
		return usuarioAprobador;
	}

	public void setUsuarioAprobador(String usuarioAprobador) {
		this.usuarioAprobador = usuarioAprobador;
	}
	
	public String getResponsableCuenta() {
		return responsableCuenta;
	}

	public void setResponsableCuenta(String responsableCuenta) {
		this.responsableCuenta = responsableCuenta;
	}
	
	public String getUsuarioOperacion() {
		return usuarioOperacion;
	}

	public void setUsuarioOperacion(String usuarioOperacion) {
		this.usuarioOperacion = usuarioOperacion;
	}

	@Override
	public String toString() {
		return "DesembolsoCreditoDto [montoDesembolso=" + montoDesembolso + ", moneda=" + moneda + ", frecuencia="
				+ frecuencia + ", tem=" + tem + ", nroCuotas=" + nroCuotas + ", fechaDesembolso=" + fechaDesembolso
				+ ", fechaPrimeraCuota=" + fechaPrimeraCuota + ", cliente=" + cliente + ", viaDesembolso="
				+ viaDesembolso + ", idCuentaDesembolso=" + idCuentaDesembolso + ", usuarioAprobador="
				+ usuarioAprobador + ", responsableCuenta=" + responsableCuenta + ", usuarioOperacion="
				+ usuarioOperacion + "]";
	}
	
	
	
}
