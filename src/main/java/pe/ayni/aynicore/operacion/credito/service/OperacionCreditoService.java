package pe.ayni.aynicore.operacion.credito.service;

import java.io.OutputStream;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCuotaDto;
import pe.ayni.aynicore.operacion.credito.dto.SimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

public interface OperacionCreditoService {

	void createDesembolso(DesembolsoCreditoDto desembolsoCredito);

	void buildReporteSolicitud(DesembolsoCreditoDto desembolsoCreditoDto, OutputStream outStream) throws JRException;

	List<AmortizacionCuotaDto> calculateAmortizacion(SimulacionAmortizacionDto simulacionAmortizacion);

	AmortizacionCreditoDto createAmortizacion(AmortizacionCreditoDto amortizacionCredito);
	
	
	
}
