package pe.ayni.aynicore.operacion.credito.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import net.sf.jasperreports.engine.JRException;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.CuotaSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DatosSimulacionAmortizacionDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;
import pe.ayni.aynicore.operacion.credito.service.OperacionCreditoService;

@RestController
@RequestMapping("/api/operaciones/creditos")
public class OperacionCreditoRest {
	
	@Autowired
	OperacionCreditoService operacionCreditoService;
	
	@CrossOrigin
	@PostMapping("/desembolsos")
	public DesembolsoCreditoDto createDesembolso(@RequestBody DesembolsoCreditoDto desembolsoCreditoDto) {
		System.out.println(desembolsoCreditoDto);
		desembolsoCreditoDto.setUsuarioOperacion("oajon"); // TODO
		
		operacionCreditoService.createDesembolso(desembolsoCreditoDto);
		return desembolsoCreditoDto;
	}
	
	@CrossOrigin
	@PostMapping("/desembolsos/build-reporte-solicitud")
	@ResponseBody
	public void buildReporteSolicitud(@RequestBody DesembolsoCreditoDto desembolsoCreditoDto, HttpServletResponse response) throws JRException, IOException{

		System.out.println(desembolsoCreditoDto);

	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "inline; filename=Solicitud_Credito.pdf");

		final OutputStream outStream = response.getOutputStream();

		operacionCreditoService.buildReporteSolicitud(desembolsoCreditoDto, outStream);
		
	}
	
	@CrossOrigin
	@GetMapping("/amortizaciones/simular-amortizacion")
	public List<CuotaSimulacionAmortizacionDto> calculateAmortizacion(DatosSimulacionAmortizacionDto datosSimulacionAmortizacionDto) {
		return operacionCreditoService.calculateAmortizacion(datosSimulacionAmortizacionDto);
	}
	
	@CrossOrigin
	@PostMapping("/amortizaciones")
	public AmortizacionCreditoDto createAmortizacion(@RequestBody AmortizacionCreditoDto amortizacionCreditoDto) {
		System.out.println(amortizacionCreditoDto);
		amortizacionCreditoDto.setIdOperacion(123456);
		return amortizacionCreditoDto;
	}
}
