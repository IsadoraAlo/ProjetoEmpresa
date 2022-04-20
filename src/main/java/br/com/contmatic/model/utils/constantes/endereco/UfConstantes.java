package br.com.contmatic.model.utils.constantes.endereco;

public class UfConstantes {

    // NOME DO UF

    public static final String MSG_NOME_NULO = "Nome do UF é obrigatório!";

    public static final String MSG_NOME_BRANCO = "Nome do UF não pode estar em branco.";

    public static final String MSG_NOME_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Nome do UF.";

    public static final String MSG_NOME_CARACTERES_INVALIDO = "Nome do UF possuí caracteres inválidos.";

    public static final Integer TAMANHO_NOME_MAX = 70;

    public static final Integer TAMANHO_NOME_MIN = 6;

    // SIGLA DO UF

    public static final String MSG_SIGLA_NULO = "Sigla do UF é obrigatório!";

    public static final String MSG_SIGLA_BRANCO = "Sigla do UF não pode estar em branco.";

    public static final String MSG_SIGLA_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Sigla do UF.";

    public static final String MSG_SIGLA_CARACTERES_INVALIDO = "Sigla do UF possuí caracteres inválidos.";

    public static final Integer TAMANHO_SIGLA_MAX = 2;

    public static final Integer TAMANHO_SIGLA_MIN = 2;

    // CÓDIGO IBGE

    public static final String MSG_COD_IBGE_NULO = "Código Ibge é obrigatório!";

    public static final String MSG_COD_IBGE_BRANCO = "Código Ibge não pode estar em branco.";

    public static final String MSG_COD_IBGE_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Código Ibge.";

    public static final String MSG_COD_IBGE_CARACTERES_INVALIDO = "Código Ibge apenas aceita caracteres numéricos.";

    public static final Integer TAMANHO_COD_IBGE_MAX = 2;

    public static final Integer TAMANHO_COD_IBGE_MIN = 2;

    private UfConstantes() {
    }

}
