package pe.ayni.aynicore.operacion.credito.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Array;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;
import pe.ayni.aynicore.operacion.credito.service.OperacionCreditoService;

@RestController
@RequestMapping("/api/operaciones/creditos")
public class OperacionCreditoRest {
	
	@Autowired
	OperacionCreditoService operacionCreditoService;
	
	@CrossOrigin
	@PostMapping("/desembolsos")
	public DesembolsoCreditoDto createCredito(@RequestBody DesembolsoCreditoDto desembolsoCreditoDto) {
		System.out.println(desembolsoCreditoDto);
		desembolsoCreditoDto.setUsuarioOperacion("oajon"); // TODO
		
		operacionCreditoService.createDesembolso(desembolsoCreditoDto);
		return desembolsoCreditoDto;
	}
	
	@CrossOrigin
	@PostMapping("/desembolsos/createReporteSolicitudCredito1")
	@ResponseBody
	public void getReport(@RequestBody DesembolsoCreditoDto desembolsoCreditoDto, HttpServletResponse response) throws JRException, IOException {

		System.out.println(desembolsoCreditoDto);

		InputStream reportStream = this.getClass().getClassLoader().getResourceAsStream("Solicitud_Credito.jasper");
		System.out.println(getClass().getClassLoader().getResource("Solicitud_Credito.jasper"));
		
		DetalleCronogramaCreditoDto det1 = new DetalleCronogramaCreditoDto(1, "2018-08-27", BigDecimal.valueOf(1111),
				BigDecimal.valueOf(77.35), BigDecimal.valueOf(35.67), BigDecimal.valueOf(113.02));
		DetalleCronogramaCreditoDto det2 = new DetalleCronogramaCreditoDto(2, "2018-09-03", BigDecimal.valueOf(1033.65),
				BigDecimal.valueOf(79.84), BigDecimal.valueOf(33.18), BigDecimal.valueOf(113.02));
		List<DetalleCronogramaCreditoDto> detalles = new ArrayList<>();
		detalles.add(det1); detalles.add(det2);
		
		Map<String,Object> params = new HashMap<>();
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
	    //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
	    params.put("nroIdentificacion", "10681340");
	    params.put("nombre", "CARRILLO CAMONEZ TERESA LUISA");
	    params.put("montoDesembolso", BigDecimal.valueOf(1200.00));
	    params.put("frecuencia", "SEMANAL");
	    params.put("tem", BigDecimal.valueOf(9.35));
	    params.put("nroCuotas", 6);
	    params.put("fechaDesembolso", "08/20/2018");
	    
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanArrayDataSource(detalles.toArray()));
	    
	    
	    response.setContentType("application/pdf");
	    
	    response.setHeader("Content-disposition", "inline; filename=Solicitud_Credito.pdf");
	    
	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}
	
}
