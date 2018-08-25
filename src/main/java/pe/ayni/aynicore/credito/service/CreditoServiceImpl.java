package pe.ayni.aynicore.credito.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.ayni.aynicore.cliente.entity.Cliente;
import pe.ayni.aynicore.credito.constraint.CreditoConstraint.EstadoCredito;
import pe.ayni.aynicore.credito.constraint.CreditoConstraint.FrecuenciaCredito;
import pe.ayni.aynicore.credito.dao.CreditoDao;
import pe.ayni.aynicore.credito.dto.CreditoDto;
import pe.ayni.aynicore.credito.dto.DatosSimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCronogramaCreditoDto;
import pe.ayni.aynicore.credito.entity.CuentaCredito;
import pe.ayni.aynicore.credito.entity.DetalleCronogramaCredito;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.seguridad.entity.Usuario;

@Service
public class CreditoServiceImpl implements CreditoService {
	
	@Autowired
	CreditoDao creditoDao;
	
	@Autowired
	DetalleCronogramaCreditoService detalleCronogramaCreditoService;
	
	@Override
	@Transactional
	public void createCredito(CreditoDto creditoDto) {
		
		creditoDto.setNroCondicion(0);
		
		List<DetalleCronogramaCredito> detallesCronogramaCredito = buildDetallesCronogramaCredito(creditoDto);
		
		CuentaCredito credito = buildEntityFrom(creditoDto);
		credito.setMontoCuota(getMontoCuota(detallesCronogramaCredito));
		credito.setDetallesCronogramaCredito(detallesCronogramaCredito);

		creditoDao.create(credito);
		creditoDto.setIdCuenta(credito.getIdCuenta());
	}
	
	@Override
	@Transactional
	public CreditoDto findCreditoById(Integer idCuenta) {
		CuentaCredito credito = creditoDao.findById(idCuenta);
		CreditoDto creditoDto = buildDtoFrom(credito);
		return creditoDto;
	}

	private CreditoDto buildDtoFrom(CuentaCredito credito) {
		CreditoDto creditoDto = null;
		if (credito != null) {
			ModelMapper modelMapper = new ModelMapper();
			creditoDto = modelMapper.map(credito, CreditoDto.class);
			creditoDto.getCliente().setNombre(credito.getCliente().getPersonaNatural().getNombre());
			creditoDto.getCliente().setTipoIdentificacion(credito.getCliente().getPersonaNatural().getTipoIdentificacion().toString());
			creditoDto.getCliente().setNroIdentificacion(credito.getCliente().getPersonaNatural().getNroIdentificacion());
			creditoDto.setSaldoCapital(getSaldoCapital(credito));
		}
		return creditoDto;
	}
	
	private BigDecimal getSaldoCapital(CuentaCredito credito) {
		return credito.getDetallesCronogramaCredito()
				.stream()
				.filter(e -> ( e.getNroCuota().intValue() > 0 && e.getNroConcepto().intValue() == 0))
				.map(e -> e.getMontoProgramado().subtract(e.getMontoPagado()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal getMontoCuota(List<DetalleCronogramaCredito> detallesCronogramaCredito) {
		
		BigDecimal montoCuota = detallesCronogramaCredito.stream().filter(e -> (e.getNroCuota().intValue() == 1))
			.map(e -> e.getMontoProgramado()).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return montoCuota;
	}
	
	private List<DetalleCronogramaCredito> buildDetallesCronogramaCredito(CreditoDto creditoDto) {
		
		List<DetalleCronogramaCredito> detallesCronogramaCredito = new ArrayList<>();
		
		List<CuotaCronogramaCreditoDto> cuotasCronogramaCreditoDto = calculateCronograma(creditoDto);
		
		int nroConceptoCapital = 0;
		int nroConceptoInteres = 1;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (int nroCuota=0; nroCuota < cuotasCronogramaCreditoDto.size(); nroCuota++) {
			// {nroCuota : 0}, representa al desembolso
			if (nroCuota == 0) {
				DetalleCronogramaCredito detalleCronogramaCreditoDesembolso = new DetalleCronogramaCredito(
						creditoDto.getNroCondicion(), nroCuota, nroConceptoCapital, new CuentaContable("14110206"), // TODO 
						LocalDate.parse(cuotasCronogramaCreditoDto.get(nroCuota).getFechaVencimiento(), formatter),
						cuotasCronogramaCreditoDto.get(nroCuota).getCapitalCredito(),
						new BigDecimal(0),
						new BigDecimal(0)
						);
				detallesCronogramaCredito.add(detalleCronogramaCreditoDesembolso);
			} else {
				DetalleCronogramaCredito detalleCronogramaCreditoCapital = new DetalleCronogramaCredito(
						creditoDto.getNroCondicion(), nroCuota, nroConceptoCapital, new CuentaContable("14110206"), // TODO 
						LocalDate.parse(cuotasCronogramaCreditoDto.get(nroCuota).getFechaVencimiento(), formatter),
						cuotasCronogramaCreditoDto.get(nroCuota).getCapitalCredito(),
						cuotasCronogramaCreditoDto.get(nroCuota).getCapitalProgramado(),
						new BigDecimal(0)
						);
				detallesCronogramaCredito.add(detalleCronogramaCreditoCapital);
				
				DetalleCronogramaCredito detalleCronogramaCreditoInteres = new DetalleCronogramaCredito(
						creditoDto.getNroCondicion(), nroCuota, nroConceptoInteres, new CuentaContable("5114010206"), // TODO 
						LocalDate.parse(cuotasCronogramaCreditoDto.get(nroCuota).getFechaVencimiento(), formatter),
						cuotasCronogramaCreditoDto.get(nroCuota).getCapitalCredito(),
						cuotasCronogramaCreditoDto.get(nroCuota).getInteresProgramado(),
						new BigDecimal(0)
						);			
				detallesCronogramaCredito.add(detalleCronogramaCreditoInteres);
			}
		}
		return detallesCronogramaCredito;
	}

	
	private CuentaCredito buildEntityFrom(CreditoDto creditoDto) {
		CuentaCredito credito = new CuentaCredito();
		
		
		credito.setCapitalInicial(creditoDto.getMontoDesembolso());
		credito.setCliente(new Cliente(creditoDto.getCliente().getId()));
		credito.setCuentaContable(new CuentaContable("14110206"));
		credito.setEstado(EstadoCredito.ACTIVO);
		//credito.setDetallesCronogramaCredito(detallesCronogramaCredito);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaDesembolso = LocalDate.parse(creditoDto.getFechaDesembolso(), formatter);
		credito.setFechaDesembolso(fechaDesembolso);
		LocalDate fechaPrimeraCuota = LocalDate.parse(creditoDto.getFechaPrimeraCuota(), formatter);
		credito.setFechaPrimeraCuota(fechaPrimeraCuota);
		credito.setFrecuencia(FrecuenciaCredito.valueOf(creditoDto.getFrecuencia()));
		credito.setMoneda(creditoDto.getMoneda());
		//credito.setMontoCuota(montoCuota);
		credito.setMontoDesembolso(creditoDto.getMontoDesembolso());
		credito.setNroCondicion(creditoDto.getNroCondicion());
		credito.setNroCuotas(creditoDto.getNroCuotas());
		credito.setUsuarioResponsable(new Usuario(creditoDto.getUsuarioResponsable()));
		credito.setTem(creditoDto.getTem());
		credito.setUsuarioAprobador(new Usuario(creditoDto.getUsuarioAprobador()));
		
		return credito;
	}
	
	@Override
	public List<CuotaCronogramaCreditoDto> calculateCronograma(
			DatosSimulacionCreditoDto datosSimulacionCreditoDto) {
		CreditoDto creditoDto = new CreditoDto(datosSimulacionCreditoDto.getMontoDesembolso(), 
				datosSimulacionCreditoDto.getFrecuencia(), datosSimulacionCreditoDto.getTem(), 
				datosSimulacionCreditoDto.getNroCuotas(), datosSimulacionCreditoDto.getFechaDesembolso(), 
				datosSimulacionCreditoDto.getFechaPrimeraCuota());
		
		return calculateCronograma(creditoDto);
	}
	
	@Override
	public List<CuotaCronogramaCreditoDto> calculateCronograma(CreditoDto creditoDto) {
		
		LocalDate[] fechasVencimiento = getFechasVencimiento(LocalDate.parse(creditoDto.getFechaPrimeraCuota()), 
				FrecuenciaCredito.valueOf(creditoDto.getFrecuencia()), creditoDto.getNroCuotas().intValue());
		
		int[] diferenciaEnDias = getDiferenciaEnDias(LocalDate.parse(creditoDto.getFechaDesembolso()), fechasVencimiento);
		
		double ted = getTEDFromTEM(creditoDto.getTem().doubleValue() / 100);
		
		BigDecimal montoCuota = calculateMontoCuota(creditoDto.getMontoDesembolso(), diferenciaEnDias, ted);
		
		List<CuotaCronogramaCreditoDto> cuotasCronogramaCalculado = new ArrayList<>();
		
		// 1era Cuota es Desembolso
		CuotaCronogramaCreditoDto firstCuotaCronograma = new CuotaCronogramaCreditoDto(0, creditoDto.getFechaDesembolso(),
				creditoDto.getMontoDesembolso(), new BigDecimal(0), new BigDecimal(0), montoCuota);
		cuotasCronogramaCalculado.add(firstCuotaCronograma);
		
		for (int i = 0; i < creditoDto.getNroCuotas().intValue(); i++) {
			
			CuotaCronogramaCreditoDto cuotaCronograma = new CuotaCronogramaCreditoDto();
			int nroCuota = i + 1;
			cuotaCronograma.setNroCuota(nroCuota);
			cuotaCronograma.setFechaVencimiento(fechasVencimiento[i].toString());
			cuotaCronograma.setCapitalCredito(cuotasCronogramaCalculado.get(i).getCapitalCredito().subtract(cuotasCronogramaCalculado.get(i).getCapitalProgramado()));
			cuotaCronograma.setMontoCuota(montoCuota);

			cuotaCronograma.setInteresProgramado(calculateInteres(ted, diferenciaEnDias[i], cuotaCronograma.getCapitalCredito()));
			cuotaCronograma.setCapitalProgramado(cuotaCronograma.getMontoCuota().subtract(cuotaCronograma.getInteresProgramado()));
			
			// ultima cuota
			if (nroCuota == creditoDto.getNroCuotas().intValue() ) {
				cuotaCronograma.setCapitalProgramado(cuotaCronograma.getCapitalCredito());
				cuotaCronograma.setMontoCuota(cuotaCronograma.getCapitalProgramado().add(cuotaCronograma.getInteresProgramado()));
			}
			
			cuotasCronogramaCalculado.add(cuotaCronograma);
		}
		return cuotasCronogramaCalculado;
	}

	private BigDecimal calculateInteres(double ted, int nroDias, BigDecimal saldoCapital) {

		return BigDecimal.valueOf((Math.pow(1 + ted, nroDias) - 1) * saldoCapital.doubleValue()).setScale(2, BigDecimal.ROUND_UP);
	}

	private double getTEDFromTEM(double tem) {
	
		return Math.pow(1 + tem, 1.0 / 30) - 1;
	}

	private BigDecimal calculateMontoCuota(BigDecimal montoDesembolso, int[] diferenciaEnDias, double ted) {

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

	@Override
	@Transactional
	public List<CuotaCronogramaCreditoDto> findCuotasCronogramaByIdCuentaAndEstado(Integer idCuenta, String estado) {
		CuentaCredito credito = creditoDao.findById(idCuenta);
		return detalleCronogramaCreditoService.findCuotasCronogramaByIdCuentaAndEstado(idCuenta, credito.getNroCondicion(), estado);
	}

	@Override
	@Transactional
	public Integer getNroCondicionCredito(Integer idCuenta) {
		return creditoDao.findById(idCuenta).getNroCondicion();
	}

}
