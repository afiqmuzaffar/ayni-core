package pe.ayni.aynicore.credito.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.credito.dto.DatosCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.credito.service.CreditoService;

@RestController
@RequestMapping("/api/creditos")
public class CreditoRest {
	
	@Autowired
	CreditoService creditoService;
	
	@CrossOrigin
	@GetMapping("/simulacionCronograma")
	public List<DetalleCronogramaCreditoDto> getSimulacionCronograma(DatosCreditoDto datosCreditoDto) {
		System.out.println(datosCreditoDto.toString());
//		List<DetalleCronogramaCreditoDto> cronogramaCreditoDto = new ArrayList<>();
//		int[] cuotas = {1,2,3,4,5};
//		for(int i: cuotas) {
//			DetalleCronogramaCreditoDto detalle = new DetalleCronogramaCreditoDto();
//			detalle.setNroCuota(i);
//			detalle.setFechaVencimiento("2018-02-01");
//			detalle.setSaldoCapital(new BigDecimal(1000));
//			detalle.setCapital(new BigDecimal(100));
//			detalle.setInteres(new BigDecimal(50));
//			detalle.setMontoCuota(new BigDecimal(150));
//			cronogramaCreditoDto.add(detalle);
//		} 
//		
		
		return creditoService.getSimulacionCronograma(datosCreditoDto);
	}
}
