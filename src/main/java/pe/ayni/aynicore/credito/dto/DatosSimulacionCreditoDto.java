package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DatosSimulacionCreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal montoDesembolso;
	
	private String frecuencia;
	
	private BigDecimal tem;
	
	private Integer nroCuotas;
	
	private String fechaDesembolso;
	
	private String fechaPrimeraCuota;

	public BigDecimal getMontoDesembolso() {
		return montoDesembolso;
	}

	public void setMontoDesembolso(BigDecimal montoDesembolso) {
		this.montoDesembolso = montoDesembolso;
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

	@Override
	public String toString() {
		return "DatosSimulacionCreditoDto [montoDesembolso=" + montoDesembolso + ", frecuencia=" + frecuencia + ", tem="
				+ tem + ", nroCuotas=" + nroCuotas + ", fechaDesembolso=" + fechaDesembolso + ", fechaPrimeraCuota="
				+ fechaPrimeraCuota + "]";
	}
	
	
}
