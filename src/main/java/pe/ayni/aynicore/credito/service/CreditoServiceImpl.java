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
import pe.ayni.aynicore.credito.dto.SimulacionCreditoDto;
import pe.ayni.aynicore.credito.dto.CuotaCreditoDto;
import pe.ayni.aynicore.credito.entity.CuentaCredito;
import pe.ayni.aynicore.credito.entity.DetalleCredito;
import pe.ayni.aynicore.cuenta.entity.CuentaContable;
import pe.ayni.aynicore.seguridad.entity.Usuario;

@Service
public class CreditoServiceImpl implements CreditoService {
	
	@Autowired
	CreditoDao creditoDao;
	
	@Autowired
	DetalleCreditoService detalleCreditoService;
	
	@Override
	@Transactional
	public void createCredito(CreditoDto creditoDto) {
		
		creditoDto.setNroCondicion(0);
		
		List<DetalleCredito> detallesCredito = buildDetallesCredito(creditoDto);
		
		CuentaCredito credito = buildEntityFrom(creditoDto);
		credito.setMontoCuota(getMontoCuota(detallesCredito));
		credito.setDetallesCredito(detallesCredito);

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
		return credito.getDetallesCredito()
				.stream()
				.filter(e -> ( e.getNroCuota().intValue() > 0 && e.getNroConcepto().intValue() == 0))
				.map(e -> e.getMontoProgramado().subtract(e.getMontoPagado()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal getMontoCuota(List<DetalleCredito> detallesCredito) {
		
		BigDecimal montoCuota = detallesCredito.stream().filter(e -> (e.getNroCuota().intValue() == 1))
			.map(e -> e.getMontoProgramado()).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return montoCuota;
	}
	
	private List<DetalleCredito> buildDetallesCredito(CreditoDto credito) {
		
		List<DetalleCredito> detallesCredito = new ArrayList<>();
		
		List<CuotaCreditoDto> cuotasCredito = calculateCuotas(credito);
		
		int nroConceptoCapital = 0;
		int nroConceptoInteres = 1;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (int nroCuota=0; nroCuota < cuotasCredito.size(); nroCuota++) {
			// {nroCuota : 0}, representa al desembolso
			if (nroCuota == 0) {
				DetalleCredito detalleDesembolso = new DetalleCredito(
						credito.getNroCondicion(), nroCuota, nroConceptoCapital, new CuentaContable("14110206"), // TODO 
						LocalDate.parse(cuotasCredito.get(nroCuota).getFechaVencimiento(), formatter),
						cuotasCredito.get(nroCuota).getCapitalCredito(),
						new BigDecimal(0), new BigDecimal(0));
				detallesCredito.add(detalleDesembolso);
				
			} else {
				DetalleCredito detalleCreditoCapital = new DetalleCredito(
						credito.getNroCondicion(), nroCuota, nroConceptoCapital, new CuentaContable("14110206"), // TODO 
						LocalDate.parse(cuotasCredito.get(nroCuota).getFechaVencimiento(), formatter),
						cuotasCredito.get(nroCuota).getCapitalCredito(), cuotasCredito.get(nroCuota).getCapitalProgramado(),
						new BigDecimal(0));
				detallesCredito.add(detalleCreditoCapital);
				
				DetalleCredito detalleCreditoInteres = new DetalleCredito(
						credito.getNroCondicion(), nroCuota, nroConceptoInteres, new CuentaContable("5114010206"), // TODO 
						LocalDate.parse(cuotasCredito.get(nroCuota).getFechaVencimiento(), formatter),
						cuotasCredito.get(nroCuota).getCapitalCredito(), cuotasCredito.get(nroCuota).getInteresProgramado(),
						new BigDecimal(0) );			
				detallesCredito.add(detalleCreditoInteres);
			}
		}
		return detallesCredito;
	}

	
	private CuentaCredito buildEntityFrom(CreditoDto creditoDto) {
		CuentaCredito credito = new CuentaCredito();
		
		
		credito.setCapitalInicial(creditoDto.getMontoDesembolso());
		credito.setCliente(new Cliente(creditoDto.getCliente().getId()));
		credito.setCuentaContable(new CuentaContable("14110206"));
		credito.setEstado(EstadoCredito.ACTIVO);
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
	public List<CuotaCreditoDto> calculateCuotas(SimulacionCreditoDto simulacionCredito) {
		CreditoDto creditoDto = new CreditoDto(simulacionCredito.getMontoDesembolso(), 
				simulacionCredito.getFrecuencia(), simulacionCredito.getTem(), 
				simulacionCredito.getNroCuotas(), simulacionCredito.getFechaDesembolso(), 
				simulacionCredito.getFechaPrimeraCuota());
		
		return calculateCuotas(creditoDto);
	}
	
	@Override
	public List<CuotaCreditoDto> calculateCuotas(CreditoDto credito) {
		
		LocalDate[] fechasVencimiento = getFechasVencimiento(LocalDate.parse(credito.getFechaPrimeraCuota()), 
				FrecuenciaCredito.valueOf(credito.getFrecuencia()), credito.getNroCuotas().intValue());
		
		int[] diferenciaEnDias = getDiferenciaEnDias(LocalDate.parse(credito.getFechaDesembolso()), fechasVencimiento);
		
		double ted = getTEDFromTEM(credito.getTem().doubleValue() / 100);
		
		BigDecimal montoCuota = calculateMontoCuota(credito.getMontoDesembolso(), diferenciaEnDias, ted);
		
		List<CuotaCreditoDto> cuotasCalculadas = new ArrayList<>();
		
		// 1era Cuota es Desembolso
		CuotaCreditoDto cuotaDesembolso = new CuotaCreditoDto(0, credito.getFechaDesembolso(),
				credito.getMontoDesembolso(), new BigDecimal(0), new BigDecimal(0), montoCuota);
		cuotasCalculadas.add(cuotaDesembolso);
		
		for (int i = 0; i < credito.getNroCuotas().intValue(); i++) {
			
			CuotaCreditoDto cuotaCredito = new CuotaCreditoDto();
			int nroCuota = i + 1;
			cuotaCredito.setNroCuota(nroCuota);
			cuotaCredito.setFechaVencimiento(fechasVencimiento[i].toString());
			cuotaCredito.setCapitalCredito(cuotasCalculadas.get(i).getCapitalCredito().subtract(cuotasCalculadas.get(i).getCapitalProgramado()));
			cuotaCredito.setMontoCuota(montoCuota);

			cuotaCredito.setInteresProgramado(calculateInteres(ted, diferenciaEnDias[i], cuotaCredito.getCapitalCredito()));
			cuotaCredito.setCapitalProgramado(cuotaCredito.getMontoCuota().subtract(cuotaCredito.getInteresProgramado()));
			
			// ultima cuota
			if (nroCuota == credito.getNroCuotas().intValue() ) {
				cuotaCredito.setCapitalProgramado(cuotaCredito.getCapitalCredito());
				cuotaCredito.setMontoCuota(cuotaCredito.getCapitalProgramado().add(cuotaCredito.getInteresProgramado()));
			}
			
			cuotasCalculadas.add(cuotaCredito);
		}
		return cuotasCalculadas;
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
	public List<CuotaCreditoDto> findCuotasByIdCuentaAndEstado(Integer idCuenta, String estado) {
		CuentaCredito credito = creditoDao.findById(idCuenta);
		return detalleCreditoService.findCuotasByIdCuentaAndEstado(idCuenta, credito.getNroCondicion(), estado);
	}

	@Override
	@Transactional
	public Integer getNroCondicionCredito(Integer idCuenta) {
		return creditoDao.findById(idCuenta).getNroCondicion();
	}

	@Override
	@Transactional
	public void amortizarCredito(Integer idCuenta, BigDecimal monto) {
		Integer nroCondicion = getNroCondicionCredito(idCuenta);
		detalleCreditoService.amortizarDetallesCredito(idCuenta, nroCondicion, monto);
	}

}
