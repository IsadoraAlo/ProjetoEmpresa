package br.com.contmatic.model.utils.validacao;

import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_ALFABETICA;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_ALFA_NUMERICA;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_EMAIL;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_NUMERICA;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_RG;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_TEXTO;

import java.math.BigDecimal;
import java.util.List;

public final class Util {

    private Util() {
    }

    public static void validarNulo(Object campo, String mensagem) {
        if (campo == null) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void validarQuantidadeCaracteresString(String campo, Integer caracteresMax, Integer caracteresMin, String mensagem) {
        if (campo.length() > caracteresMax || campo.length() < caracteresMin) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarEspacos(String campo, String mensagem) {
        if (campo.trim().isEmpty()) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarQuantidadeElementoLista(List<?> campo, Integer tamanhoMax, Integer tamanhoMin, String mensagem) {
        if (campo.size() > tamanhoMax || campo.size() < tamanhoMin) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void limitarQuantidadeNumericaMaximaMinima(BigDecimal campo, BigDecimal valorMax, BigDecimal valorMin, String mensagem) {
        if (campo.compareTo(valorMax) >= 0 || campo.compareTo(valorMin) <= 0 ) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void limitarQuantidadeNumericaMaximaMinima(Integer campo, Integer valorMax, Integer valorMin, String mensagem) {
        if (campo > valorMax || campo < valorMin) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarApenasNumericos(String campo, String mensagem) {
        if (!campo.matches(VALIDACAO_NUMERICA)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarApenasAlfabeticos(String campo, String mensagem) {
        if (!campo.matches(VALIDACAO_ALFABETICA)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarApenasAlfanumericos(String campo, String mensagem) {
        if (!campo.matches(VALIDACAO_ALFA_NUMERICA)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarTexto(String campo, String mensagem) {
        if (!campo.matches(VALIDACAO_TEXTO)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarRg(String campo, String mensagem) {
        if (!campo.matches(VALIDACAO_RG)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static void validarEmail(String campo, String mensagem) {
        if (!campo.matches(VALIDACAO_EMAIL)) {
            throw new IllegalStateException(mensagem);
        }
    }
}
