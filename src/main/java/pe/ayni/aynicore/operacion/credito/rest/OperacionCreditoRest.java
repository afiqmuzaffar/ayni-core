package pe.ayni.aynicore.operacion.credito.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

@RestController
@RequestMapping("/api/operaciones/creditos")
public class OperacionCreditoRest {
	
	@CrossOrigin
	@PostMapping("/desembolsos")
	public DesembolsoCreditoDto createCredito(@RequestBody DesembolsoCreditoDto desembolsoCreditoDto) {
		System.out.println(desembolsoCreditoDto);
		return desembolsoCreditoDto;
	}

}
