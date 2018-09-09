package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

public class CreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCuenta;
	
	private BigDecimal montoDesembolso;
	
	private String moneda; // "0", "1": Soles, "2": Dolares
	
	private String frecuencia;
	
	private BigDecimal tem;
	
	private Integer nroCuotas;
	
	private String fechaDesembolso;
	
	private String fechaPrimeraCuota;
	
	private String usuarioAprobador;
	
	private Integer nroCondicion;
	
	private String usuarioResponsable;
	
	private Cliente cliente; 
	
	private BigDecimal saldoCapital;
	
	public static class Cliente {
		
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

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombre=" + nombre + ", tipoIdentificacion=" + tipoIdentificacion
					+ ", nroIdentificacion=" + nroIdentificacion + "]";
		}
		
		
		
	}
	
	public CreditoDto() {
		
	}

	public CreditoDto(BigDecimal montoDesembolso, String frecuencia, BigDecimal tem, Integer nroCuotas,
			String fechaDesembolso, String fechaPrimeraCuota) {
		this.montoDesembolso = montoDesembolso;
		this.frecuencia = frecuencia;
		this.tem = tem;
		this.nroCuotas = nroCuotas;
		this.fechaDesembolso = fechaDesembolso;
		this.fechaPrimeraCuota = fechaPrimeraCuota;
	}

	public CreditoDto(DesembolsoCreditoDto desembolsoCredito) {
		this.montoDesembolso = desembolsoCredito.getCredito().getMontoDesembolso();
		this.moneda = desembolsoCredito.getCredito().getMoneda();
		this.frecuencia = desembolsoCredito.getCredito().getFrecuencia();
		this.tem = desembolsoCredito.getCredito().getTem();
		this.nroCuotas = desembolsoCredito.getCredito().getNroCuotas();
		this.fechaDesembolso = desembolsoCredito.getCredito().getFechaDesembolso();
		this.fechaPrimeraCuota = desembolsoCredito.getCredito().getFechaPrimeraCuota();
		this.usuarioAprobador = desembolsoCredito.getCredito().getUsuarioAprobador();
		this.usuarioResponsable = desembolsoCredito.getCredito().getUsuarioResponsable();
		this.cliente = new Cliente(desembolsoCredito.getCliente().getId());
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

	public Integer getNroCondicion() {
		return nroCondicion;
	}

	public void setNroCondicion(Integer nroCondicion) {
		this.nroCondicion = nroCondicion;
	}

	public String getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(String usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public BigDecimal getSaldoCapital() {
		return saldoCapital;
	}

	public void setSaldoCapital(BigDecimal saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	@Override
	public String toString() {
		return "CreditoDto [idCuenta=" + idCuenta + ", montoDesembolso=" + montoDesembolso + ", moneda=" + moneda
				+ ", frecuencia=" + frecuencia + ", tem=" + tem + ", nroCuotas=" + nroCuotas + ", fechaDesembolso="
				+ fechaDesembolso + ", fechaPrimeraCuota=" + fechaPrimeraCuota + ", usuarioAprobador="
				+ usuarioAprobador + ", nroCondicion=" + nroCondicion + ", usuarioResponsable=" + usuarioResponsable
				+ ", cliente=" + cliente + ", saldoCapital=" + saldoCapital + "]";
	}

}
