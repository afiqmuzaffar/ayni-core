package pe.ayni.aynicore.credito.constraint;

import java.math.BigDecimal;

import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;

public class DetalleCronogramaCreditoConstraint {
	
	public enum ConceptoDetalleCronograma {
		CAPITAL(0){
			public void setMontoProgramado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setCapitalProgramado(monto);
			}
			public void setMontoPagado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setCapitalPagado(monto);
			}
		}, 
		INTERES(1) {
			public void setMontoProgramado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setInteresProgramado(monto);
			}
			public void setMontoPagado(CuotaCronogramaCreditoDto cuota, BigDecimal monto) {
				cuota.setInteresPagado(monto);
			}
		};
		public abstract void setMontoProgramado(CuotaCronogramaCreditoDto cuota, BigDecimal monto);
		public abstract void setMontoPagado(CuotaCronogramaCreditoDto cuota, BigDecimal monto);
		
		Integer nroConcepto;
		
		private ConceptoDetalleCronograma(Integer nroConcepto) {
			this.nroConcepto = nroConcepto;
		}
		
		public static ConceptoDetalleCronograma getConceptoDetalleCronograma(Integer nroConcepto) {
			for (ConceptoDetalleCronograma conceptoDetalleCronograma: values()) {
				if (nroConcepto.equals(conceptoDetalleCronograma.nroConcepto)) {
					return conceptoDetalleCronograma;
				}
			}
			return null;
		}
	}
}
