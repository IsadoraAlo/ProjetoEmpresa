package br.com.contmatic.model.utils.constantes.empresa;

public final class EmpresaConstantes {

    // RAZÃO SOCIAL

    public static final String MSG_RAZAO_SOCIAL_NULO = "Razão Social é obrigatório!";

    public static final String MSG_RAZAO_SOCIAL_BRANCO = "Razão Social não pode estar em branco.";

    public static final String MSG_RAZAO_SOCIAL_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Razão Social.";

    public static final String MSG_RAZAO_SOCIAL_CARACTERES_INVALIDO = "Razão Social possuí caracteres inválidos";

    public static final Integer TAMANHO_RAZAO_SOCIAL_MAX = 70;

    public static final Integer TAMANHO_RAZAO_SOCIAL_MIN = 6;

    // NOME FANTASIA

    public static final String MSG_NOME_FANTASIA_NULO = "Nome Fantasia é obrigatório!";

    public static final String MSG_NOME_FANTASIA_BRANCO = "Nome Fantasia não pode estar em branco.";

    public static final String MSG_NOME_FANTASIA_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Nome Fantasia.";

    public static final String MSG_NOME_FANTASIA_CARACTERES_INVALIDO = "Nome Fantasia possuí caracteres inválidos";

    public static final Integer TAMANHO_NOME_FANTASIA_MAX = 70;

    public static final Integer TAMANHO_NOME_FANTASIA_MIN = 10;

    // CNPJ

    public static final String MSG_CNPJ_NULO = "CNPJ é obrigatório!";

    public static final String MSG_CNPJ_BRANCO = "CNPJ não pode estar em branco.";

    // ENDEREÇO

    public static final String MSG_ENDERECO_NULO = "Endereço é obrigatório!";

    public static final String MSG_ENDERECO_LISTA_EXCEDIDA = "A Quantidade de Endereços maxíma foi excedida!";

    public static final Integer TAMANHO_ENDERECO_LISTA_MAX = 2;

    public static final Integer TAMANHO_ENDERECO_LISTA_MIN = 1;

    // CONTATO

    public static final String MSG_CONTATO_NULO = "Contato é obrigatório!";

    // FUNCIONÁRIO

    public static final String MSG_FUNCIONARIO_NULO = "Funcionário é obrigatório!";

    public static final String MSG_FUNCIONARIO_LISTA_EXCEDIDA = "A Quantidade de Funcionários maxíma foi excedida!";

    public static final Integer TAMANHO_FUNCIONARIO_LISTA_MAX = 2;

    public static final Integer TAMANHO_FUNCIONARIO_LISTA_MIN = 1;

    // PRODUTO

    public static final String MSG_PRODUTO_NULO = "Produto é obrigatório!";

    public static final String MSG_PRODUTO_LISTA_EXCEDIDA = "A Variedade de Produtos maxíma foi excedida!";

    public static final Integer TAMANHO_PRODUTO_LISTA_MAX = 2;

    public static final Integer TAMANHO_PRODUTO_LISTA_MIN = 1;
    
    // ATIVA
    
    public static final String MSG_ATIVA_NULO = "Ativar a empresa é obrigatório!";

    private EmpresaConstantes() {
    }

}
