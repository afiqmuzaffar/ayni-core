package pe.ayni.aynicore.credito.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pe.ayni.aynicore.credito.constraint.CreditoConstraint.FrecuenciaCredito;
import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.DetalleCronogramaCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.DesembolsoCreditoDto;

@Service
public class CreditoServiceImpl implements CreditoService {
	
	
	@Transactional
	public List<DetalleCronogramaCreditoDto> getSimulacionCronograma(DesembolsoCreditoDto desembolsoCreditoDto) {
		
		LocalDate[] fechasVencimiento = getFechasVencimiento(LocalDate.parse(desembolsoCreditoDto.getFechaPrimeraCuota()), 
				FrecuenciaCredito.valueOf(desembolsoCreditoDto.getFrecuencia()), desembolsoCreditoDto.getNroCuotas().intValue());
		
		int[] diferenciaEnDias = getDiferenciaEnDias(LocalDate.parse(desembolsoCreditoDto.getFechaDesembolso()), fechasVencimiento);
		
		double ted = getTEDFromTEM(desembolsoCreditoDto.getTem().doubleValue() / 100);
		
		BigDecimal montoCuota = getMontoCuota(desembolsoCreditoDto.getMontoDesembolso(), diferenciaEnDias, ted);
		
		List<DetalleCronogramaCreditoDto> simulacionCronogramaDto = new ArrayList<>();
		
		// 1era Linea es Detalle Desembolso
		DetalleCronogramaCreditoDto firstDetalleCronograma = new DetalleCronogramaCreditoDto(0, desembolsoCreditoDto.getFechaDesembolso(),
				desembolsoCreditoDto.getMontoDesembolso(), new BigDecimal(0), new BigDecimal(0), montoCuota);
		simulacionCronogramaDto.add(firstDetalleCronograma);
		
		for (int i = 0; i < desembolsoCreditoDto.getNroCuotas().intValue(); i++) {
			
			DetalleCronogramaCreditoDto detalleCronograma = new DetalleCronogramaCreditoDto();
			int nroCuota = i + 1;
			detalleCronograma.setNroCuota(nroCuota);
			detalleCronograma.setFechaVencimiento(fechasVencimiento[i].toString());
			detalleCronograma.setSaldoCapital(simulacionCronogramaDto.get(i).getSaldoCapital().subtract(simulacionCronogramaDto.get(i).getCapital()));
			detalleCronograma.setMontoCuota(montoCuota);

			detalleCronograma.setInteres(getCalculoInteres(ted, diferenciaEnDias[i], detalleCronograma.getSaldoCapital()));
			detalleCronograma.setCapital(detalleCronograma.getMontoCuota().subtract(detalleCronograma.getInteres()));
			
			// ultima cuota
			if (nroCuota == desembolsoCreditoDto.getNroCuotas().intValue() ) {
				detalleCronograma.setCapital(detalleCronograma.getSaldoCapital());
				detalleCronograma.setMontoCuota(detalleCronograma.getCapital().add(detalleCronograma.getInteres()));
			}
			
			simulacionCronogramaDto.add(detalleCronograma);
		}
		return simulacionCronogramaDto;
	}

	private BigDecimal getCalculoInteres(double ted, int nroDias, BigDecimal saldoCapital) {

		return BigDecimal.valueOf((Math.pow(1 + ted, nroDias) - 1) * saldoCapital.doubleValue()).setScale(2, BigDecimal.ROUND_UP);
	}

	private double getTEDFromTEM(double tem) {
	
		return Math.pow(1 + tem, 1.0 / 30) - 1;
	}

	private BigDecimal getMontoCuota(BigDecimal montoDesembolso, int[] diferenciaEnDias, double ted) {

		double sumaFactores = 0.0;
		int diasAcumulados = 0;
		for (int i = 0; i < diferenciaEnDias.length; i++) {
			diasAcumulados += diferenciaEnDias[i];
			sumaFactores += 1 / Math.pow(1 + ted, diasAcumulados); 
		}
		return BigDecimal.valueOf(montoDesembolso.doubleValue()/sumaFactores).setScale(2, BigDecimal.ROUND_UP);
	}

	private int[] getDiferenciaEnDias(LocalDate fechaDesembolso, LocalDate[] fechasVencimiento) {
		
		int[] diferenciasEnDias = new int[fechasVencimiento.length];
		diferenciasEnDias[0] = (int)Math.abs(ChronoUnit.DAYS.between(fechaDesembolso, fechasVencimiento[0]));
		for (int i = 1; i < diferenciasEnDias.length; i++) {
			diferenciasEnDias[i] = (int)Math.abs(ChronoUnit.DAYS.between(fechasVencimiento[i - 1], fechasVencimiento[i]));
		}
		return diferenciasEnDias;
	}

	private LocalDate[] getFechasVencimiento(LocalDate fechaPrimerVencimiento, FrecuenciaCredito frecuencia, int nroCuotas) {
		
		LocalDate[] fechasVencimiento = new LocalDate[nroCuotas];
		fechasVencimiento[0] = fechaPrimerVencimiento;
		for (int i = 1; i < fechasVencimiento.length; i++) {
			switch (frecuencia.toString()) {
				case "DIARIA": {
					fechasVencimiento[i] = fechasVencimiento[i - 1].plusDays(1);
					break;
				}
				case "SEMANAL": {
					fechasVencimiento[i] = fechasVencimiento[i - 1].plusDays(7);
					break;
				}
				case "MENSUAL": {
					fechasVencimiento[i] = fechasVencimiento[i - 1].plusMonths(1);
					break;
				}
				default: {
					break;
				}
			}
			
		}
		return fechasVencimiento;
	}

}
