package pe.ayni.aynicore.persona.constraint;

import java.util.HashMap;
import java.util.Map;

public class TelefonoConstraint {
	
	public enum TipoTelefono { FIJO, CELULAR }
	
	public enum EstadoTelefono {ACTIVO, INACTIVO}
	
	public static final Map<String, String> CODIGOS_TELEFONICO_DPTO;
	static {
		CODIGOS_TELEFONICO_DPTO = new HashMap<String,String>();
		CODIGOS_TELEFONICO_DPTO.put("1", "Lima y Callao");
		CODIGOS_TELEFONICO_DPTO.put("41", "Amazonas");
		CODIGOS_TELEFONICO_DPTO.put("43", "Ancash");
		CODIGOS_TELEFONICO_DPTO.put("83", "Apurimac");
		CODIGOS_TELEFONICO_DPTO.put("54", "Arequipa");
		CODIGOS_TELEFONICO_DPTO.put("66", "Ayacucho");
		CODIGOS_TELEFONICO_DPTO.put("76", "Cajamarca");
		CODIGOS_TELEFONICO_DPTO.put("67", "Huancavelica");
		CODIGOS_TELEFONICO_DPTO.put("62", "Huanuco");
		CODIGOS_TELEFONICO_DPTO.put("56", "Ica");
		CODIGOS_TELEFONICO_DPTO.put("64", "Junin");
		CODIGOS_TELEFONICO_DPTO.put("44", "La Libertad");
		CODIGOS_TELEFONICO_DPTO.put("74", "Lambayeque");
		CODIGOS_TELEFONICO_DPTO.put("65", "Loreto");
		CODIGOS_TELEFONICO_DPTO.put("82", "Madre de Dios");
		CODIGOS_TELEFONICO_DPTO.put("53", "Moquegua");
		CODIGOS_TELEFONICO_DPTO.put("63", "Pasco");
		CODIGOS_TELEFONICO_DPTO.put("73", "Piura");
		CODIGOS_TELEFONICO_DPTO.put("51", "Puno");
		CODIGOS_TELEFONICO_DPTO.put("42", "San Martin");
		CODIGOS_TELEFONICO_DPTO.put("52", "Tacna");
		CODIGOS_TELEFONICO_DPTO.put("72", "Tumbes");
		CODIGOS_TELEFONICO_DPTO.put("61", "Ucayali");
		
	}
	
}
