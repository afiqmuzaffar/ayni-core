package pe.ayni.aynicore.persona.dto;

import java.io.Serializable;
import java.util.List;

public class ConfiguracionUbigeoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static ConfiguracionUbigeoDto instance;
	
	public static class Departamento{
		private Integer id;
		private String codDpto;
		private String nombre;
		private List<Provincia> provincias;
		
		public Departamento(Integer id, String codDpto, String nombre) {
			this.id = id;
			this.codDpto = codDpto;
			this.nombre = nombre;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getCodDpto() {
			return codDpto;
		}

		public void setCodDpto(String codDpto) {
			this.codDpto = codDpto;
		}

		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public List<Provincia> getProvincias() {
			return provincias;
		}
		public void setProvincias(List<Provincia> provincias) {
			this.provincias = provincias;
		}
		

	}
	public static class Provincia {
		private Integer id;
		private String codProvincia;
		private String nombre;
		private List<Distrito> distritos;
		
		public Provincia(Integer id, String codProvincia, String nombre) {
			this.id = id;
			this.codProvincia = codProvincia;
			this.nombre = nombre;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getCodProvincia() {
			return codProvincia;
		}

		public void setCodProvincia(String codProvincia) {
			this.codProvincia = codProvincia;
		}

		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public List<Distrito> getDistritos() {
			return distritos;
		}
		public void setDistritos(List<Distrito> distritos) {
			this.distritos = distritos;
		}
		
	}
	
	public static class Distrito {

		private Integer id;
		private String nombre;
		
		public Distrito(Integer id, String nombre) {
			this.id = id;
			this.nombre = nombre;
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

	}
	
	private List<Departamento> departamentos;

	private ConfiguracionUbigeoDto () {
		
	}
	
	public static ConfiguracionUbigeoDto getInstance() {
		if (instance == null) {
			instance = new ConfiguracionUbigeoDto();
		}
		return instance;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
