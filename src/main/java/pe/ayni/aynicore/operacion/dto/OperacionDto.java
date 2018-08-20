package pe.ayni.aynicore.operacion.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OperacionDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private BigDecimal monto;
	
	private String moneda;
	
	private String fechaOperacion;
	
	private String horaOperacion;
	
	private String usuario;
	
	private String tipoOperacion;
	
	private String nota;
	
	private Integer idOperacionRelacionada;
	
	private List<DetalleOperacionDto> detallesOperacion;
	
	public OperacionDto() {
		
	}
	
	public OperacionDto(BigDecimal monto, String moneda, String usuario, String tipoOperacion, String nota,
			Integer idOperacionRelacionada) {
		this.monto = monto;
		this.moneda = moneda;
		this.usuario = usuario;
		this.tipoOperacion = tipoOperacion;
		this.nota = nota;
		this.idOperacionRelacionada = idOperacionRelacionada;
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

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Integer getIdOperacionRelacionada() {
		return idOperacionRelacionada;
	}

	public void setIdOperacionRelacionada(Integer idOperacionRelacionada) {
		this.idOperacionRelacionada = idOperacionRelacionada;
	}

	public List<DetalleOperacionDto> getDetallesOperacion() {
		return detallesOperacion;
	}

	public void setDetallesOperacion(List<DetalleOperacionDto> detallesOperacion) {
		this.detallesOperacion = detallesOperacion;
	}
}
