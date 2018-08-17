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
	
	private Integer idCliente;
	
	private String viaDesembolso;
	
	private Integer idCuentaDesembolso;
	
	private String usuarioAprobador;
	
	private Integer idResponsableCuenta;
	
	private String usuarioOperacion;

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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	
	public Integer getIdResponsableCuenta() {
		return idResponsableCuenta;
	}

	public void setIdResponsableCuenta(Integer idResponsableCuenta) {
		this.idResponsableCuenta = idResponsableCuenta;
	}
	
	public String getUsuarioOperacion() {
		return usuarioOperacion;
	}

	public void setUsuarioOperacion(String usuarioOperacion) {
		this.usuarioOperacion = usuarioOperacion;
	}

	public DesembolsoCreditoDto(BigDecimal montoDesembolso, String moneda, String frecuencia, BigDecimal tem,
			Integer nroCuotas, String fechaDesembolso, String fechaPrimeraCuota, Integer idCliente,
			String viaDesembolso, Integer idCuentaDesembolso, String usuarioAprobador, Integer idResponsableCuenta,
			String usuarioOperacion) {
		this.montoDesembolso = montoDesembolso;
		this.moneda = moneda;
		this.frecuencia = frecuencia;
		this.tem = tem;
		this.nroCuotas = nroCuotas;
		this.fechaDesembolso = fechaDesembolso;
		this.fechaPrimeraCuota = fechaPrimeraCuota;
		this.idCliente = idCliente;
		this.viaDesembolso = viaDesembolso;
		this.idCuentaDesembolso = idCuentaDesembolso;
		this.usuarioAprobador = usuarioAprobador;
		this.idResponsableCuenta = idResponsableCuenta;
		this.usuarioOperacion = usuarioOperacion;
	}
	
}
