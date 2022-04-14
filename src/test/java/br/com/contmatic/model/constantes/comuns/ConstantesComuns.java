package br.com.contmatic.model.constantes.comuns;

import java.time.LocalDate;

public class ConstantesComuns {

    public static final String ESPACO_BRANCO = "    ";
    
    public static final String STRING_NUMERICA_20 = "12345678911234567891";
    
    public static final String STRING_NUMERICA_1 = "9";
    
    public static final String STRING_CARACTERES_ESPECIAIS_10 = "{}!@#$%¨&%";
    
    public static final String STRING_CARACTERES_ESPECIAIS_8 = "!@#$%¨&*";
    
    public static final String STRING_CARACTERES_ESPECIAIS_2 = "{}";
    
    public static final String STRING_ALFABETICA_75 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
     
    public static final String STRING_ALFABETICA_1 = "a";
    
    public static final Integer INT_99999999 = 99999999;
    
    public static final Integer INT_NEGATIVA_1 = -1;
    
    public static final Float FLOAT_99999999 = 99999999.0f;
    
    public static final Float FLOAT_NEGATIVA_1 = -1.0f;
    
    public static final LocalDate DATA_300_ANOS_FUTURO = LocalDate.of(2122, 01, 01);
    
    public static final LocalDate DATA_100_ANOS_PASSADO = LocalDate.of(1922, 01, 01);
    
    public static final LocalDate DATA_INICIO_ANO = LocalDate.of(2022,01,01);
    
    public static final LocalDate DATA_ATUAL = LocalDate.now();
    
    private ConstantesComuns() {
    }
    
}
