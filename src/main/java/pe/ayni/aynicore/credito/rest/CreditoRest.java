package pe.ayni.aynicore.credito.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.credito.dto.DatosSimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.credito.service.CreditoService;

@RestController
@RequestMapping("/api/creditos")
public class CreditoRest {
	
	@Autowired
	CreditoService creditoService;
	
	@CrossOrigin
	@GetMapping("/simular-cronograma")
	public List<DetalleCronogramaCreditoDto> getSimulacionCronograma(DatosSimulacionCreditoDto datosSimulacionCreditoDto) {
		System.out.println(datosSimulacionCreditoDto.toString());
		return creditoService.getSimulacionCronograma(datosSimulacionCreditoDto);
	}
	
}
