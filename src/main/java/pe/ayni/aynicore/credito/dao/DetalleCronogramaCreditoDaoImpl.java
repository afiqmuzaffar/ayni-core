package pe.ayni.aynicore.credito.dao;

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
	public DetalleCronogramaCredito findDesembolso(Integer idCuenta) {
		Session session = sessionFactory.getCurrentSession();
		
		String query = "SELECT a FROM DetalleCronogramaCredito a JOIN FETCH a.cuentaCredito JOIN FETCH a.ctaContable"
				+ " WHERE a.cuentaCredito.idCuenta = :idCuenta"
				+ " AND a.nroCondicion = 0 AND a.nroCuota = 0 AND a.nroConcepto = 0";
		
		return session.createQuery( query,DetalleCronogramaCredito.class)
				.setParameter("idCuenta", idCuenta)
				.getSingleResult();
	}
	
	
	
}
