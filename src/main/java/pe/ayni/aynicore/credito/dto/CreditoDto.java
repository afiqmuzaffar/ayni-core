package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

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
	
	private Integer idCliente;
	
	private Integer nroCondicion;
	
	private Integer idResponsableCuenta;
	
	public CreditoDto() {
		
	}
	
	public CreditoDto(BigDecimal montoDesembolso, String moneda, String frecuencia, BigDecimal tem, Integer nroCuotas,
			String fechaDesembolso, String fechaPrimeraCuota, String usuarioAprobador, Integer idCliente,
			Integer idResponsableCuenta) {
		this.montoDesembolso = montoDesembolso;
		this.moneda = moneda;
		this.frecuencia = frecuencia;
		this.tem = tem;
		this.nroCuotas = nroCuotas;
		this.fechaDesembolso = fechaDesembolso;
		this.fechaPrimeraCuota = fechaPrimeraCuota;
		this.usuarioAprobador = usuarioAprobador;
		this.idCliente = idCliente;
		this.idResponsableCuenta = idResponsableCuenta;
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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getNroCondicion() {
		return nroCondicion;
	}

	public void setNroCondicion(Integer nroCondicion) {
		this.nroCondicion = nroCondicion;
	}

	public Integer getIdResponsableCuenta() {
		return idResponsableCuenta;
	}

	public void setIdResponsableCuenta(Integer idResponsableCuenta) {
		this.idResponsableCuenta = idResponsableCuenta;
	}

	@Override
	public String toString() {
		return "CreditoDto [idCuenta=" + idCuenta + ", montoDesembolso=" + montoDesembolso + ", moneda=" + moneda
				+ ", frecuencia=" + frecuencia + ", tem=" + tem + ", nroCuotas=" + nroCuotas + ", fechaDesembolso="
				+ fechaDesembolso + ", fechaPrimeraCuota=" + fechaPrimeraCuota + ", usuarioAprobador="
				+ usuarioAprobador + ", idCliente=" + idCliente + ", nroCondicion=" + nroCondicion
				+ ", idResponsableCuenta=" + idResponsableCuenta + "]";
	}
	
	
}
