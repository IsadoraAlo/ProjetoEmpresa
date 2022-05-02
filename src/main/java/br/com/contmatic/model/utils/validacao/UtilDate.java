package br.com.contmatic.model.utils.validacao;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public final class UtilDate {

    private UtilDate() {
    }

    public static void validarIntervaloMaxAnos(LocalDate dataDesejada, Long anoMax, String mensagem) {
        LocalDate hoje = LocalDate.now();
        Long diferencaAnos = ChronoUnit.YEARS.between(dataDesejada, hoje);
        if (diferencaAnos > anoMax) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarIntervaloMinAnos(LocalDate dataDesejada, Long anoMin, String mensagem) {
        LocalDate hoje = LocalDate.now();
        Long diferencaAnos = ChronoUnit.YEARS.between(dataDesejada, hoje);
        if (diferencaAnos < anoMin) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataFinalMenorInicial(LocalDate dataFinal, LocalDate dataInicial, String mensagem) {
        if (dataFinal.isBefore(dataInicial)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarIntervaloDiasEntreDatas(LocalDate dataInicial, LocalDate dataFinal, long intervaloMax, String mensagem) {
        long dias = DAYS.between(dataInicial, dataFinal);
        if (dias > intervaloMax) {
            throw new IllegalStateException(mensagem);
        }
    }
    
    public static void validarIntervaloMaxAnos(LocalDateTime dataDesejada, Long anoMax, String mensagem) {
        LocalDateTime hoje = LocalDateTime.now();
        Long diferencaAnos = ChronoUnit.YEARS.between(dataDesejada, hoje);
        if (diferencaAnos > anoMax) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarIntervaloMinAnos(LocalDateTime dataDesejada, Long anoMin, String mensagem) {
        LocalDateTime hoje = LocalDateTime.now();
        Long diferencaAnos = ChronoUnit.YEARS.between(dataDesejada, hoje);
        if (diferencaAnos < anoMin) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarDataFinalMenorInicial(LocalDateTime dataFinal, LocalDateTime dataInicial, String mensagem) {
        if (dataFinal.isBefore(dataInicial)) {
            throw new IllegalStateException(mensagem);
        }
    }

}
