package pe.ayni.aynicore.credito.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.DatosSimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;
import pe.ayni.aynicore.credito.service.CreditoService;

@RestController
@RequestMapping("/api/creditos")
public class CreditoRest {
	
	@Autowired
	CreditoService creditoService;
	
	
	@CrossOrigin
	@GetMapping("/simular-cronograma")
	public List<CuotaCronogramaCreditoDto> calculateCronograma(DatosSimulacionCreditoDto datosSimulacionCreditoDto) {
		System.out.println(datosSimulacionCreditoDto.toString());
		return creditoService.calculateCronograma(datosSimulacionCreditoDto);
	}
	
	@CrossOrigin
	@GetMapping("/{idCuenta}")
	public CreditoDto findCreditoById(@PathVariable Integer idCuenta) {
		System.out.println(idCuenta);
		return creditoService.findCreditoById(idCuenta);
	}
	
	@CrossOrigin
	@GetMapping(path="/{idCuenta}/cuotas-cronograma", params="estado")
	public List<CuotaCronogramaCreditoDto> findCuotasCronogramaByIdCuentaAndEstado(@PathVariable Integer idCuenta, 
			@RequestParam("estado") String estado) {
		System.out.println(idCuenta);
		System.out.println(estado);
		return creditoService.findCuotasCronogramaByIdCuentaAndEstado(idCuenta, estado);
	}
	
}
