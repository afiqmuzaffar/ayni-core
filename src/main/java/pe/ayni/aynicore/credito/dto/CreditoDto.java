package pe.ayni.aynicore.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CreditoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal montoDesembolso;
	private String frecuencia;
	private Double tem;
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
	public Double getTem() {
		return tem;
	}
	public void setTem(Double tem) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DatosCreditoDTO [montoDesembolso=" + montoDesembolso + ", frecuencia=" + frecuencia + ", tem=" + tem
				+ ", nroCuotas=" + nroCuotas + ", fechaDesembolso=" + fechaDesembolso + ", fechaPrimeraCuota="
				+ fechaPrimeraCuota + ", getMontoDesembolso()=" + getMontoDesembolso() + ", getFrecuencia()="
				+ getFrecuencia() + ", getTem()=" + getTem() + ", getNroCuotas()=" + getNroCuotas()
				+ ", getFechaDesembolso()=" + getFechaDesembolso() + ", getFechaPrimeraCuota()="
				+ getFechaPrimeraCuota() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
