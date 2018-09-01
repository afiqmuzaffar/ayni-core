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
import pe.ayni.aynicore.credito.dto.SimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;
import pe.ayni.aynicore.credito.service.CreditoService;

@RestController
@RequestMapping("/api/creditos")
public class CreditoRest {
	
	@Autowired
	CreditoService creditoService;
	
	
	@CrossOrigin
	@GetMapping("/simular-cuotas")
	public List<CuotaCreditoDto> calculateCuotas(SimulacionCreditoDto simulacionCredito) {
		System.out.println(simulacionCredito.toString());
		return creditoService.calculateCuotas(simulacionCredito);
	}
	
	@CrossOrigin
	@GetMapping("/{idCuenta}")
	public CreditoDto findCreditoById(@PathVariable Integer idCuenta) {
		System.out.println(idCuenta);
		return creditoService.findCreditoById(idCuenta);
	}
	
	@CrossOrigin
	@GetMapping(path="/{idCuenta}/cuotas-credito", params="estado")
	public List<CuotaCreditoDto> findCuotasByIdCuentaAndEstado(@PathVariable Integer idCuenta, 
			@RequestParam("estado") String estado) {
		System.out.println(idCuenta);
		System.out.println(estado);
		return creditoService.findCuotasByIdCuentaAndEstado(idCuenta, estado);
	}
	
}
