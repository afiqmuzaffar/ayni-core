package pe.ayni.aynicore.operacion.credito.service;

import java.io.OutputStream;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import pe.ayni.aynicore.operacion.credito.dto.CuotaSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DatosSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

public interface OperacionCreditoService {

	void createDesembolso(DesembolsoCreditoDto desembolsoCreditoDto);

	void buildReporteSolicitud(DesembolsoCreditoDto desembolsoCreditoDto, OutputStream outStream) throws JRException;

	List<CuotaSimulacionAmortizacionDto> calculateAmortizacion(DatosSimulacionAmortizacionDto datosSimulacionAmortizacionDto);
	
	
	
}
