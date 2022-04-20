package br.com.contmatic.model.utils.validacao;

public final class UtilCpf {

    private static final int POSICAO_0_TABELA_ASCII = 48;
    private static final int TAMANHO_MAX_CPF = 11;
    private static final int DIGITO_VERIFICADOR_10 = 10;
    private static final int DIGITO_VERIFICADOR_11 = 11;
    private static final int POSICAO_DIGITO_09 = 9;
    private static final int POSICAO_DIGITO_10 = 10;
    private static final int PESO_SEGUNDO_DIGITO = 11;
    private static final int PESO_PRIMEIRO_DIGITO = 10;

    private UtilCpf() {
    }

    public static void validarCPF(String cpf) {
        validarDigitosIguais(cpf);
        validarDigito(cpf);
    }

    private static void validarDigito(String cpf) {
        int dig10 = calculoPrimeiroDigito(cpf);
        int dig11 = calculoSegundoDigito(cpf);
        if ((dig10 != cpf.charAt(POSICAO_DIGITO_09)) && (dig11 != cpf.charAt(POSICAO_DIGITO_10))) {
            throw new IllegalStateException("CPF inválido!");
        }
    }

    private static char calculoSegundoDigito(String cpf) {
        char dig11;
        int sm = 0;
        int r;
        int peso = PESO_SEGUNDO_DIGITO;
        sm = conversaoSegundoDigito(cpf, sm, peso);
        r = DIGITO_VERIFICADOR_11 - (sm % DIGITO_VERIFICADOR_11);
        if ((r == DIGITO_VERIFICADOR_10) || (r == DIGITO_VERIFICADOR_11))
            dig11 = '0';
        else
            dig11 = (char) (r + POSICAO_0_TABELA_ASCII);
        return dig11;
    }

    private static int conversaoSegundoDigito(String cpf, int sm, int peso) {
        int i;
        int num;
        for(i = 0 ; i < POSICAO_DIGITO_10 ; i++) {
            num = (int) (cpf.charAt(i) - POSICAO_0_TABELA_ASCII);
            sm = sm + (num * peso);
            peso--;
        }
        return sm;
    }

    private static char calculoPrimeiroDigito(String cpf) {
        char dig10;
        int sm = 0;
        int r;
        int peso = PESO_PRIMEIRO_DIGITO;
        sm = conversaoPrimeiroDigito(cpf, sm, peso);
        r = DIGITO_VERIFICADOR_11 - (sm % DIGITO_VERIFICADOR_11);
        if ((r == DIGITO_VERIFICADOR_10) || (r == DIGITO_VERIFICADOR_11))
            dig10 = '0';
        else
            dig10 = (char) (r + POSICAO_0_TABELA_ASCII);
        return dig10;
    }

    private static int conversaoPrimeiroDigito(String cpf, int sm, int peso) {
        int i;
        int num;
        for(i = 0 ; i < POSICAO_DIGITO_09 ; i++) {
            num = (int) (cpf.charAt(i) - POSICAO_0_TABELA_ASCII);
            sm = sm + (num * peso);
            peso--;
        }
        return sm;
    }

    private static void validarDigitosIguais(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != TAMANHO_MAX_CPF))
            throw new IllegalStateException("CPF inválido!");
    }
}
