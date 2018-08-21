package pe.ayni.aynicore.operacion.credito.service;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

public interface OperacionCreditoService {

	void createDesembolso(DesembolsoCreditoDto desembolsoCreditoDto);

	void buildReporteSolicitud(DesembolsoCreditoDto desembolsoCreditoDto, OutputStream outStream) throws JRException;
	
	
	
}
