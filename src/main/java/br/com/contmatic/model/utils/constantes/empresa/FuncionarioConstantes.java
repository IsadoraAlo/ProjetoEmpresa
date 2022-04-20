package br.com.contmatic.model.utils.constantes.empresa;

public final class FuncionarioConstantes {

    // NOME COMPLETO

    public static final String MSG_NOME_COMPLETO_NULO = "Nome Completo é obrigatório!";

    public static final String MSG_NOME_COMPLETO_BRANCO = "Nome Completo não pode estar em branco.";

    public static final String MSG_NOME_COMPLETO_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Nome Completo.";

    public static final String MSG_NOME_COMPLETO_CARACTERES_INVALIDO = "Nome Completo possuí caracteres inválidos";

    public static final Integer TAMANHO_NOME_COMPLETO_MAX = 70;

    public static final Integer TAMANHO_NOME_COMPLETO_MIN = 10;

    // NOME SOCIAL

    public static final String MSG_NOME_SOCIAL_NULO = "Nome Social é obrigatório!";

    public static final String MSG_NOME_SOCIAL_BRANCO = "Nome Social não pode estar em branco.";

    public static final String MSG_NOME_SOCIAL_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Nome Social.";

    public static final String MSG_NOME_SOCIAL_CARACTERES_INVALIDO = "Nome Social possuí caracteres inválidos";

    public static final Integer TAMANHO_NOME_SOCIAL_MAX = 70;

    public static final Integer TAMANHO_NOME_SOCIAL_MIN = 10;

    // DATA NASCIMENTO

    public static final String MSG_DATA_NASCIMENTO_NULO = "Data de Nascimento é obrigatória!";

    public static final long TAMANHO_DATA_NASCIMENTO_MAX = 80;

    public static final long TAMANHO_DATA_NASCIMENTO_MIN = 16;

    public static final String MSG_DATA_NASCIMENTO_INTERVALO_ULTRAPASSADO = "Data de Aposentadoria tem mais de 80 anos!";

    public static final String MSG_DATA_NASCIMENTO_INTERVALO_LIMIAR = "Data de Aposentadoria tem menos de 16 anos!";

    // SEXO

    public static final String MSG_SEXO_NULO = "Sexo é obrigatório!";

    public static final String MSG_SEXO_BRANCO = "Sexo não pode estar em branco.";

    public static final String MSG_SEXO_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Sexo.";

    public static final String MSG_SEXO_CARACTERES_INVALIDO = "Sexo possuí caracteres inválidos";

    public static final Integer TAMANHO_SEXO_MAX = 1;

    public static final Integer TAMANHO_SEXO_MIN = 1;

    // ESTADO CIVIL

    public static final String MSG_ESTADO_CIVIL_NULO = "Estado Civil é obrigatório!";

    public static final String MSG_ESTADO_CIVIL_BRANCO = "Estado Civil não pode estar em branco.";

    public static final String MSG_ESTADO_CIVIL_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Estado Civil.";

    public static final String MSG_ESTADO_CIVIL_CARACTERES_INVALIDO = "Estado Civil possuí caracteres inválidos";

    public static final Integer TAMANHO_ESTADO_CIVIL_MAX = 70;

    public static final Integer TAMANHO_ESTADO_CIVIL_MIN = 5;

    // ESCOLARIDADE

    public static final String MSG_ESCOLARIDADE_NULO = "Escolaridade é obrigatória!";

    public static final String MSG_ESCOLARIDADE_BRANCO = "Escolaridade não pode estar em branco.";

    public static final String MSG_ESCOLARIDADE_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Escolaridade.";

    public static final String MSG_ESCOLARIDADE_CARACTERES_INVALIDO = "Escolaridade possuí caracteres inválidos";

    public static final Integer TAMANHO_ESCOLARIDADE_MAX = 70;

    public static final Integer TAMANHO_ESCOLARIDADE_MIN = 10;

    // CPF

    public static final String MSG_CPF_NULO = "CPF é obrigatório!";

    public static final String MSG_CPF_BRANCO = "CPF não pode estar em branco.";

    // RG

    public static final String MSG_RG_NULO = "RG é obrigatório!";

    public static final String MSG_RG_BRANCO = "RG não pode estar em branco.";

    public static final String MSG_RG_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em RG.";

    public static final String MSG_RG_INVALIDO = "O RG é inválido!";

    public static final Integer TAMANHO_RG_MAX = 11;

    public static final Integer TAMANHO_RG_MIN = 11;

    // CONTATO

    public static final String MSG_CONTATO_NULO = "Contato é obrigatório!";

    // ENDERECO

    public static final String MSG_ENDERECO_NULO = "Endereço é obrigatório!";
    
    // EMPRESA

    public static final String MSG_EMPRESA_NULO = "Empresa é obrigatório!";

    // DATA CONTRATAÇÃO

    public static final String MSG_DATA_CONTRACAO_NULO = "Data de contratação é obrigatória!";

    public static final String MSG_DATA_NASCIMENTO_DATA_CONTRATACAO_NULO = "É obrigatório o preenchimento da data nascimento, para definir data contratação.";

    public static final String MSG_DATA_CONTRATACAO_MENOR_NASCIMENTO = "Data de contratação menor que a de nascimento!";

    public static final String MSG_DATA_CONTRATACAO_FUTURA_MAIOR_PERMITIDO = "A data contratação não pode ultrapassar 60 dias a partir de hoje!";

    public static final Integer TAMANHO_DATA_CONTRATACAO_FUTURA_MAX = 60;

    // DATA DEMISSAO

    public static final String MSG_DATA_DEMISSAO_NULO = "Data de demissão é obrigatória!";

    public static final String MSG_DATA_CONTRATACAO_DATA_DEMISSAO_NULO = "É obrigatório o preenchimento da data contratação, para definir data demissão.";

    public static final String MSG_DATA_DEMISSAO_MENOR_CONTRATACAO = "Data de Demissão menor que a de Contratação!";

    public static final long TAMANHO_DATA_DEMISSAO_MIN = 0;

    public static final long TAMANHO_DATA_DEMISSAO_MAX = 20;

    public static final String MSG_DATA_DEMISSAO_INTERVALO_ULTRAPASSADO = "Data de Demissão tem mais de 20 anos!";

    public static final String MSG_DATA_DEMISSAO_INTERVALO_LIMIAR = "Data de Demissão tem menos de 0 anos!";

    // DATA APOSENTADORIA

    public static final String MSG_APOSENTADORIA_NULO = "Aposentadoria é obrigatória!";

    public static final String MSG_DATA_CONTRATACAO_DATA_APOSENTADORIA_NULO = "É obrigatório o preenchimento da data contratação, para definir data aposentadoria.";

    public static final String MSG_DATA_APOSENTADORIA_MENOR_CONTRATACAO = "Data de Aposentadoria menor que a de Contratação!";

    public static final long TAMANHO_DATA_APOSENTADORIA_MIN = 0;

    public static final long TAMANHO_DATA_APOSENTADORIA_MAX = 20;

    public static final String MSG_DATA_APOSENTADORIA_INTERVALO_ULTRAPASSADO = "Data de Aposentadoria tem mais de 20 anos!";

    public static final String MSG_DATA_APOSENTADORIA_INTERVALO_LIMIAR = "Data de Aposentadoria tem menos de 0 anos!";

    private FuncionarioConstantes() {
    }

}
