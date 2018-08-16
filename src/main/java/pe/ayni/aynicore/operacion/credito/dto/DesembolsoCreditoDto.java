package pe.ayni.aynicore.operacion.credito.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.ayni.aynicore.cliente.dto.ClienteDto;

public class DesembolsoCreditoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal montoDesembolso;
	
	private String moneda; // "0", "1": Soles, "2": Dolares
	
	private String frecuencia;
	
	private Double tem;
	
	private Integer nroCuotas;
	
	private String fechaDesembolso;
	
	private String fechaPrimeraCuota;
	
	private ClienteDto cliente;

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

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DesembolsoCreditoDto [montoDesembolso=" + montoDesembolso + ", moneda=" + moneda + ", frecuencia="
				+ frecuencia + ", tem=" + tem + ", nroCuotas=" + nroCuotas + ", fechaDesembolso=" + fechaDesembolso
				+ ", fechaPrimeraCuota=" + fechaPrimeraCuota + ", cliente=" + cliente + "]";
	}
	
}
