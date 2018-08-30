package pe.ayni.aynicore.credito.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;

@Repository
public class DetalleCronogramaCreditoDaoImpl implements DetalleCronogramaCreditoDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public DetalleCronogramaCredito findIsDesembolso(Integer idCuenta) {
		Session session = sessionFactory.getCurrentSession();
		
		String query = "SELECT a FROM DetalleCronogramaCredito a JOIN FETCH a.cuentaCredito JOIN FETCH a.ctaContable"
				+ " WHERE a.cuentaCredito.idCuenta = :idCuenta"
				+ " AND a.nroCondicion = 0 AND a.nroCuota = 0 AND a.nroConcepto = 0";
		
		return session.createQuery( query,DetalleCronogramaCredito.class)
				.setParameter("idCuenta", idCuenta)
				.getSingleResult();
	}

	@Override
	public List<DetalleCronogramaCredito> findByIdCuentaInCuotasPendientes(Integer idCuenta, Integer nroCondicion) {
		Session session = sessionFactory.getCurrentSession();
		
		String query = "SELECT a FROM DetalleCronogramaCredito a " + 
						" WHERE a.cuentaCredito.idCuenta = :idCuenta " + 
						" AND a.nroCondicion = :nroCondicion " + 
						" AND a.nroCuota in (" + 
						"		SELECT DISTINCT b.nroCuota FROM DetalleCronogramaCredito b" + 
						"		 WHERE 	b.cuentaCredito.idCuenta = :idCuenta" + 
						"		 AND 	b.nroCondicion = :nroCondicion " + 
						"		 AND 	b.montoProgramado - b.montoPagado > 0 " + 
						" )" + 
						" ORDER BY a.nroCuota ASC, a.nroConcepto ASC ";
		return session.createQuery(query, DetalleCronogramaCredito.class)
				.setParameter("idCuenta", idCuenta)
				.setParameter("nroCondicion", nroCondicion)
				.getResultList();
	}

	@Override
	public List<DetalleCronogramaCredito> findWithSaldo(Integer idCuenta, Integer nroCondicion) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT a FROM DetalleCronogramaCredito a " + 
						" WHERE a.cuentaCredito.idCuenta = :idCuenta " + 
						" AND a.nroCondicion = :nroCondicion " + 
						" AND a.montoProgramado - a.montoPagado > 0 " + 
						" ORDER BY a.nroCuota ASC, a.nroConcepto DESC "; // Why DSC: Higher concepts get amortization first

		return session.createQuery(query, DetalleCronogramaCredito.class)
				.setParameter("idCuenta", idCuenta)
				.setParameter("nroCondicion", nroCondicion)
				.getResultList();	
	}

	@Override
	public int updateMontoPagado(Integer id, BigDecimal montoPagado) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE DetalleCronogramaCredito a "
				+ " SET a.montoPagado = :montoPagado "
				+ " WHERE a.id = :id ");
		query.setParameter("montoPagado", montoPagado);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	@Override
	public DetalleCronogramaCredito findById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(DetalleCronogramaCredito.class, id);
	}
	
	
	
}
