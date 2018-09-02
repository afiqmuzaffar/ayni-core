package pe.ayni.aynicore.operacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.ayni.aynicore.cuenta.entity.Cuenta;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;

@Entity
@Table(name="Saldo")
public class Saldo {
	
	@EmbeddedId
	private SaldoPk saldoPk;
	
	@Column(name="saldo", nullable=false)
	private BigDecimal saldo;
	
	@Embeddable
	public static class SaldoPk implements Serializable { 
		
		private static final long serialVersionUID = 1L;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="ctaContable", nullable=false)
		private CuentaContable cuentaContable;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="idCuenta", nullable=false)
		private Cuenta cuenta;
		
		public SaldoPk(CuentaContable cuentaContable, Cuenta cuenta) {
			this.cuentaContable = cuentaContable;
			this.cuenta = cuenta;
		}
		
		public SaldoPk() {
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
			result = prime * result + ((cuentaContable == null) ? 0 : cuentaContable.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SaldoPk other = (SaldoPk) obj;
			if (cuenta == null) {
				if (other.cuenta != null)
					return false;
			} else if (!cuenta.equals(other.cuenta))
				return false;
			if (cuentaContable == null) {
				if (other.cuentaContable != null)
					return false;
			} else if (!cuentaContable.equals(other.cuentaContable))
				return false;
			return true;
		}
		
		
		
	}
	
	public Saldo() {
			
	}
	public Saldo(CuentaContable cuentaContable, Cuenta cuenta, BigDecimal saldo) {
		this.saldoPk = new SaldoPk(cuentaContable, cuenta);
		this.saldo = saldo;
	}

	public SaldoPk getSaldoPk() {
		return saldoPk;
	}

	public void setSaldoPk(SaldoPk saldoPk) {
		this.saldoPk = saldoPk;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
}
