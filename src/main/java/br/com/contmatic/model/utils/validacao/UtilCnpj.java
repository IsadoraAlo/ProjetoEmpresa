package br.com.contmatic.model.utils.validacao;

public final class UtilCnpj {
    private static final int POSICAO_0_TABELA_ASCII = 48;
    private static final int TAMANHO_MAX_CNPJ = 14;
    private static final int DIGITO_VERIFICADOR_0 = 0;
    private static final int DIGITO_VERIFICADOR_1 = 1;
    private static final int MODULO_DIVISAO = 11;
    private static final int POSICAO_DIGITO_13 = 13;
    private static final int POSICAO_DIGITO_12 = 12;
    private static final int POSICAO_DIGITO_11 = 11;
    private static final int POSICAO_DIGITO_10 = 10;
    private static final int PESO_INICIAL = 2;

    private UtilCnpj() {
    }

    public static void validarCNPJ(String cnpj) {
        validarDigitosIguais(cnpj);
        validarDigito(cnpj);
    }

    private static void validarDigito(String cnpj) {
        char dig13;
        char dig14;
        dig13 = calculoPrimeiroDigito(cnpj);
        dig14 = calculoSegundoDigito(cnpj);
        if ((dig13 != cnpj.charAt(POSICAO_DIGITO_12)) || (dig14 != cnpj.charAt(POSICAO_DIGITO_13))) {
            throw new IllegalStateException("CNPJ inválido!");
        }
    }

    private static char calculoSegundoDigito(String cnpj) {
        char dig14;
        int sm = 0;
        int r;
        int peso = PESO_INICIAL;
        sm = conversaoSegundoDigito(cnpj, sm, peso);
        r = sm % MODULO_DIVISAO;
        if ((r == DIGITO_VERIFICADOR_0) || (r == DIGITO_VERIFICADOR_1))
            dig14 = '0';
        else
            dig14 = (char) ((MODULO_DIVISAO - r) + POSICAO_0_TABELA_ASCII);
        return dig14;
    }

    private static int conversaoSegundoDigito(String cnpj, int sm, int peso) {
        int i;
        int num;
        for(i = POSICAO_DIGITO_12 ; i >= 0 ; i--) {
            num = (int) (cnpj.charAt(i) - POSICAO_0_TABELA_ASCII);
            sm = sm + (num * peso);
            peso++;
            if (peso == POSICAO_DIGITO_10)
                peso = PESO_INICIAL;
        }
        return sm;
    }

    private static char calculoPrimeiroDigito(String cnpj) {
        char dig13;
        int sm = 0;
        int r;
        int peso = PESO_INICIAL;
        sm = conversaoPrimeiroDigito(cnpj, sm, peso);
        r = sm % MODULO_DIVISAO;
        if ((r == DIGITO_VERIFICADOR_0) || (r == DIGITO_VERIFICADOR_1))
            dig13 = '0';
        else
            dig13 = (char) ((MODULO_DIVISAO - r) + POSICAO_0_TABELA_ASCII);
        return dig13;
    }

    private static int conversaoPrimeiroDigito(String cnpj, int sm, int peso) {
        int i;
        int num;
        for(i = POSICAO_DIGITO_11 ; i >= 0 ; i--) {
            num = (int) (cnpj.charAt(i) - POSICAO_0_TABELA_ASCII);
            sm = sm + (num * peso);
            peso++;
            if (peso == POSICAO_DIGITO_10)
                peso = PESO_INICIAL;
        }
        return sm;
    }

    private static void validarDigitosIguais(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") ||
            cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
            (cnpj.length() != TAMANHO_MAX_CNPJ))
            throw new IllegalStateException("CNPJ inválido!");
    }
}
