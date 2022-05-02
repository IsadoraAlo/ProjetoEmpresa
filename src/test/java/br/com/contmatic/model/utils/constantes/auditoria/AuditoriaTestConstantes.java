package br.com.contmatic.model.utils.constantes.auditoria;

import java.time.LocalDateTime;

public class AuditoriaTestConstantes {

    public static String USUARIO_CRIACAO_DEFAULT = "isadoraalves";

    public static String USUARIO_ALTERACAO_DEFAULT = "tatianapereira";

    public static String IP_CRIACAO_DEFAULT = "192168586";

    public static String IP_ALTERACAO_DEFAULT = "192168556";
    
    public static final LocalDateTime HORA_ATUAL = LocalDateTime.now();
    
    public static final LocalDateTime DATA_HORA_100_ANOS_FUTURO = LocalDateTime.of(2122, 01, 01, 0, 0);
    
    public static final LocalDateTime DATA_HORA_100_ANOS_PASSADO = LocalDateTime.of(1922, 01, 01, 0, 0);
    
    public static final LocalDateTime DATA_HORA_INICIO_ANO = LocalDateTime.of(2022, 01, 01, 0, 0);

    private AuditoriaTestConstantes() {
    }
}
