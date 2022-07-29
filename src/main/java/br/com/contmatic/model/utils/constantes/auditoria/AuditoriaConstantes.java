package br.com.contmatic.model.utils.constantes.auditoria;

public class AuditoriaConstantes {

    // USUÁRIO CRIAÇÃO

    public static final String MSG_USUARIO_CRIACAO_NULO = "Usuário de Criação é obrigatório!";

    public static final String MSG_USUARIO_CRIACAO_BRANCO = "Usuário de Criação não pode estar em branco.";

    public static final String MSG_USUARIO_CRIACAO_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Usuário de Criação.";

    public static final String MSG_USUARIO_CRIACAO_CARACTERES_INVALIDO = "Usuário de Criação possuí caracteres inválidos.";

    // IP CRIAÇÃO

    public static final String MSG_IP_CRIACAO_NULO = "IP da Criação é obrigatório!";

    public static final String MSG_IP_CRIACAO_BRANCO = "IP da Criação não pode estar em branco.";

    public static final String MSG_IP_CRIACAO_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em IP da Criação.";

    public static final String MSG_IP_CRIACAO_CARACTERES_INVALIDO = "IP da Criação apenas aceita caracteres numéricos.";

    // DATA CRIAÇÃO

    public static final String MSG_DATA_CRIACAO_NULO = "Data de Criação é obrigatória!";

    public static final long TAMANHO_DATA_CRIACAO_MAX = 2;

    public static final long TAMANHO_DATA_CRIACAO_MIN = 0;

    public static final String MSG_DATA_CRIACAO_INTERVALO_ULTRAPASSADO = "Data de Criação tem mais de 2 anos!";

    public static final String MSG_DATA_CRIACAO_INTERVALO_LIMIAR = "Data de Criação tem menos de 0 anos!";

    // USUÁRIO ALTERAÇÃO

    public static final String MSG_USUARIO_ALTERACAO_NULO = "Usuário de Criação é obrigatório!";

    public static final String MSG_USUARIO_ALTERACAO_BRANCO = "Usuário de Criação não pode estar em branco.";

    public static final String MSG_USUARIO_ALTERACAO_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Usuário de Criação.";

    public static final String MSG_USUARIO_ALTERACAO_CARACTERES_INVALIDO = "Usuário de Criação possuí caracteres inválidos.";

    // IP ALTERAÇÃO

    public static final String MSG_IP_ALTERACAO_NULO = "IP da Alteração é obrigatório!";

    public static final String MSG_IP_ALTERACAO_BRANCO = "IP da Alteração não pode estar em branco.";

    public static final String MSG_IP_ALTERACAO_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em IP da Alteração.";

    public static final String MSG_IP_ALTERACAO_CARACTERES_INVALIDO = "IP da Alteração apenas aceita caracteres numéricos.";

    // DATA ALTERAÇÃO

    public static final String MSG_DATA_ALTERACAO_NULO = "Data de Alteração é obrigatória!";

    public static final String MSG_DATA_ALTERACAO_DATA_CRIACAO_NULO = "É obrigatório o preenchimento da data de criação, para definir data de alteração.";

    public static final long TAMANHO_DATA_ALTERACAO_MAX = 2;

    public static final long TAMANHO_DATA_ALTERACAO_MIN = 0;

    public static final String MSG_DATA_ALTERACAO_INTERVALO_ULTRAPASSADO = "Data de Alteração tem mais de 2 anos!";

    public static final String MSG_DATA_ALTERACAO_INTERVALO_LIMIAR = "Data de Alteração tem menos de 0 anos!";

    public static final String MSG_DATA_ALTERACAO_MENOR_CRIACAO = "Data de alteração menor que a de criação!";

    private AuditoriaConstantes() {
    }

}
