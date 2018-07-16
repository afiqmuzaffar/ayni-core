package pe.ayni.aynicore.persona.dto;

import java.io.Serializable;
import java.util.List;


public class TelefonoFormDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public class Option {
		private String value;
		private String viewValue;
		public Option(String value, String viewValue) {
			this.value = value;
			this.viewValue = viewValue;
		}
		public String getValue() {
			return value;
		}

		public String getViewValue() {
			return viewValue;
		}
		
	}
	
	private List<Option> optionsTipoTelefono;
	private List<Option> optionsCodTelefonicoDpto;

	public List<Option> getOptionsTipoTelefono() {
		return optionsTipoTelefono;
	}

	public void setOptionsTipoTelefono(List<Option> optionsTipoTelefono) {
		this.optionsTipoTelefono = optionsTipoTelefono;
	}

	public List<Option> getOptionsCodTelefonicoDpto() {
		return optionsCodTelefonicoDpto;
	}

	public void setOptionsCodTelefonicoDpto(List<Option> optionsCodTelefonicoDpto) {
		this.optionsCodTelefonicoDpto = optionsCodTelefonicoDpto;
	}
	
	
	
	
}
