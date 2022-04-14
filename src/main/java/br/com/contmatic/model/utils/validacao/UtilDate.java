package br.com.contmatic.model.utils.validacao;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

public final class UtilDate {
	
	private UtilDate() {		
	}
	
	private static boolean menorDataMax(LocalDate nascimento, int dataMax) {
		LocalDate hoje = LocalDate.now();
		int diferencaAnos = hoje.getYear() - nascimento.getYear();
		
		boolean menorCompletos = diferencaAnos < dataMax || (diferencaAnos == dataMax && nascimento.getMonthValue() > hoje.getMonthValue());
		boolean fezEsteMes = diferencaAnos == dataMax
				&& nascimento.getMonthValue() == hoje.getMonthValue() 
				&& nascimento.getDayOfMonth() <= hoje.getDayOfMonth();
		
		return menorCompletos || fezEsteMes;
	}
	
	public static void validarDataMax(LocalDate nascimento, int dataMax) {
		if (!menorDataMax(nascimento, dataMax)) {
			throw new IllegalStateException("Maior de " + dataMax + " anos!");
		}
	}
	
	private static boolean maiorDataMin(LocalDate nascimento, int dataMin) {
		LocalDate hoje = LocalDate.now();
		int diferencaAnos = hoje.getYear() - nascimento.getYear();
		
		boolean maiorCompletos = diferencaAnos > dataMin || (diferencaAnos == dataMin && nascimento.getMonthValue() < hoje.getMonthValue());
		boolean fezEsteMes = diferencaAnos == dataMin
				&& nascimento.getMonthValue() == hoje.getMonthValue() 
				&& nascimento.getDayOfMonth() <= hoje.getDayOfMonth();
		
		return maiorCompletos || fezEsteMes;
	}
	
	public static void validarDataMin(LocalDate nascimento, int dataMin) {
		if (!maiorDataMin(nascimento, dataMin)) {
			throw new IllegalStateException("Menor de " + dataMin + " anos!");
		}
	}
	
	public static void validarDataFinalMenorInicial(LocalDate dataFinal, LocalDate dataInicial, String mensagem) {
		if (dataFinal.isBefore(dataInicial)){
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarIntervaloDiasEntreDatas(LocalDate dataInicial, LocalDate dataFinal, long intervaloMax, String mensagem) {
		long dias = DAYS.between(dataInicial, dataFinal);
		if (dias > intervaloMax) {
			throw new IllegalStateException(mensagem);
		}
	}
	
}
