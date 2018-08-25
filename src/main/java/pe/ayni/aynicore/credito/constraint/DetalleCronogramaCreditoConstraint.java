package pe.ayni.aynicore.credito.constraint;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.CuotaSimulacionAmortizacionDto;

public class DetalleCronogramaCreditoConstraint {
	
	public enum ConceptoCronograma {
		CAPITAL(0){
			public void setMontoProgramado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setCapitalProgramado(monto);
			}
			public void setMontoPagado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setCapitalPagado(monto);
			}
			public void setMontoAmortizacion(CuotaSimulacionAmortizacionDto cuota, BigDecimal monto) {
				cuota.setAmortizacionCapital(monto);				
			}
		}, 
		INTERES(1) {
			public void setMontoProgramado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setInteresProgramado(monto);
			}
			public void setMontoPagado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setInteresPagado(monto);
			}
			public void setMontoAmortizacion(CuotaSimulacionAmortizacionDto cuota, BigDecimal monto) {
				cuota.setAmortizacionInteres(monto);
			}
		};
		public abstract void setMontoProgramado(CuotaCronogramaCreditoDto cuota, BigDecimal monto);
		public abstract void setMontoPagado(CuotaCronogramaCreditoDto cuota, BigDecimal monto);
		public abstract void setMontoAmortizacion(CuotaSimulacionAmortizacionDto cuotaSimulacionAmortizacion, BigDecimal monto);
		
		Integer nroConcepto;
		
		private ConceptoCronograma(Integer nroConcepto) {
			this.nroConcepto = nroConcepto;
		}
		
		public static ConceptoCronograma getConceptoCronograma(Integer nroConcepto) {
			for (ConceptoCronograma conceptoCronograma: values()) {
				if (nroConcepto.equals(conceptoCronograma.nroConcepto)) {
					return conceptoCronograma;
				}
			}
			return null;
		}

	}
}
