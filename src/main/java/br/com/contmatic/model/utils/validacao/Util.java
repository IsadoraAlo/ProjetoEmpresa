package br.com.contmatic.model.utils.validacao;

import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_ALFABETICA;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_ALFA_NUMERICA;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_EMAIL;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_NUMERICA;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_RG;
import static br.com.contmatic.model.utils.constantes.regex.RegexConstantes.VALIDACAO_TEXTO;

import java.util.List;

public final class Util {

	private Util() {
	}

	public static void validarNulo(Object campo, String mensagem) {
		if (campo == null) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarQuantidadeCaracteresString(String campo, int caracteresMax, int caracteresMin, String mensagem) {
		if (campo.length() > caracteresMax || campo.length() < caracteresMin) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarEspacos(String campo, String mensagem) {
		if (campo.trim().isEmpty()) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarQuantidadeElementoLista(List<?> campo, int tamanhoMax, int tamanhoMin, String mensagem) {
		if (campo.size() > tamanhoMax || campo.size() < tamanhoMin) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarQuantidadeValorFloat(Float campo, Float valorMax, Float valorMin, String mensagem) {
		if (campo > valorMax || campo < valorMin) {
			throw new IllegalStateException(mensagem);
		}
	}

	public static void validarQuantidadeValorInt(int campo, int valorMax, int valorMin, String mensagem) {
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
