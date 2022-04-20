package br.com.contmatic.model.utils.constantes.regex;

public final class RegexConstantes {

    public static final String VALIDACAO_EMAIL = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";

    public static final String VALIDACAO_RG = ":?([Xx0-9]+)";

    public static final String VALIDACAO_TEXTO = "^[a-zA-ZÀ-ú]:?([a-zA-Z0-9À-ú, .]+)[a-zA-ZÀ-ú]$";

    public static final String VALIDACAO_ALFA_NUMERICA = "[A-Za-z0-9]+";

    public static final String VALIDACAO_ALFABETICA = "[a-zA-Z]+";

    public static final String VALIDACAO_NUMERICA = "[0-9]+";

    private RegexConstantes() {
    }

}
