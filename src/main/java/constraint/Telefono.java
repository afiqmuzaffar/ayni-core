package constraint;

import java.util.HashMap;
import java.util.Map;

public class Telefono {
	
	public enum TipoTelefono { FIJO, CELULAR }
	
	public enum EstadoTelefono {ACTIVO, INACTIVO}
	
	public static final Map<Integer, String> CODIGOS_TELEFONICO_DPTO;
	static {
		CODIGOS_TELEFONICO_DPTO = new HashMap<Integer,String>();
		CODIGOS_TELEFONICO_DPTO.put(1, "Lima");
		CODIGOS_TELEFONICO_DPTO.put(41, "Amazonas");
		CODIGOS_TELEFONICO_DPTO.put(43, "Anchash");
	}
	
}
