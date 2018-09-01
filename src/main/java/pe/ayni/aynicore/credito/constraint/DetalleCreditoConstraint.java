package pe.ayni.aynicore.credito.constraint;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;
import pe.ayni.aynicore.operacion.credito.dto.AmortizacionCuotaDto;

public class DetalleCreditoConstraint {
	
	public enum ConceptoCuota {
		CAPITAL(0){
			public void setMontoProgramado(CuotaCreditoDto cuota, BigDecimal monto) {
				cuota.setCapitalProgramado(monto);
			}
			public void setMontoPagado(CuotaCreditoDto cuota, BigDecimal monto) {
				cuota.setCapitalPagado(monto);
			}
			public void setMontoAmortizacion(AmortizacionCuotaDto cuota, BigDecimal monto) {
				cuota.setAmortizacionCapital(monto);				
			}
		}, 
		INTERES(1) {
			public void setMontoProgramado(CuotaCreditoDto cuota, BigDecimal monto) {
				cuota.setInteresProgramado(monto);
			}
			public void setMontoPagado(CuotaCreditoDto cuota, BigDecimal monto) {
				cuota.setInteresPagado(monto);
			}
			public void setMontoAmortizacion(AmortizacionCuotaDto cuota, BigDecimal monto) {
				cuota.setAmortizacionInteres(monto);
			}
		};
		public abstract void setMontoProgramado(CuotaCreditoDto cuota, BigDecimal monto);
		public abstract void setMontoPagado(CuotaCreditoDto cuota, BigDecimal monto);
		public abstract void setMontoAmortizacion(AmortizacionCuotaDto cuota, BigDecimal monto);
		
		Integer nroConcepto;
		
		private ConceptoCuota(Integer nroConcepto) {
			this.nroConcepto = nroConcepto;
		}
		
		public static ConceptoCuota getConcepto(Integer nroConcepto) {
			for (ConceptoCuota concepto: values()) {
				if (nroConcepto.equals(concepto.nroConcepto)) {
					return concepto;
				}
			}
			return null;
		}

	}
}
