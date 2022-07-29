package br.com.contmatic.model.auditoria;

import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_DATA_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_INTERVALO_LIMIAR;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_INTERVALO_ULTRAPASSADO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_MENOR_CRIACAO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_CRIACAO_INTERVALO_LIMIAR;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_CRIACAO_INTERVALO_ULTRAPASSADO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_ALTERACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_ALTERACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_CRIACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_CRIACAO_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarDataFinalMenorInicial;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarIntervaloMaxAnos;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarIntervaloMinAnos;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class Auditoria {

    @NotNull(message = MSG_USUARIO_CRIACAO_NULO)
    @NotBlank(message = MSG_USUARIO_CRIACAO_BRANCO)
    @Size(message = MSG_USUARIO_CRIACAO_QTDE_CARACTERES, min = 10, max = 40)
    String usuarioCriacao;

    @NotNull(message = MSG_IP_CRIACAO_NULO)
    @NotBlank(message = MSG_IP_CRIACAO_BRANCO)   
    @Size(message = MSG_IP_CRIACAO_QTDE_CARACTERES, min = 4, max = 12)
    String ipCriacao;

    @NotNull(message = MSG_DATA_CRIACAO_NULO)
    LocalDateTime dataCriacao;

    @NotNull(message = MSG_USUARIO_ALTERACAO_NULO)
    @NotBlank(message = MSG_USUARIO_ALTERACAO_BRANCO)
    @Size(message = MSG_USUARIO_ALTERACAO_QTDE_CARACTERES, min = 10, max = 40)
    String usuarioAlteracao;

    @NotNull(message = MSG_IP_ALTERACAO_NULO)
    @NotBlank(message = MSG_IP_ALTERACAO_BRANCO)
    @Size(message = MSG_IP_ALTERACAO_QTDE_CARACTERES, min = 4, max = 12)
    String ipAlteracao;

    @NotNull(message = MSG_DATA_ALTERACAO_NULO)
    LocalDateTime dataAlteracao;

    public String getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao) {
        validarTexto(usuarioCriacao, MSG_USUARIO_CRIACAO_CARACTERES_INVALIDO);
        this.usuarioCriacao = usuarioCriacao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        validarApenasNumericos(ipCriacao, MSG_IP_CRIACAO_CARACTERES_INVALIDO);
        this.ipCriacao = ipCriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        validarIntervaloMinAnos(dataCriacao, TAMANHO_DATA_CRIACAO_MIN, MSG_DATA_CRIACAO_INTERVALO_LIMIAR);
        validarIntervaloMaxAnos(dataCriacao, TAMANHO_DATA_CRIACAO_MAX, MSG_DATA_CRIACAO_INTERVALO_ULTRAPASSADO);
        this.dataCriacao = dataCriacao;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        validarTexto(usuarioAlteracao, MSG_USUARIO_ALTERACAO_CARACTERES_INVALIDO);
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        validarApenasNumericos(ipAlteracao, MSG_IP_ALTERACAO_CARACTERES_INVALIDO);
        this.ipAlteracao = ipAlteracao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        validarNulo(this.dataCriacao, MSG_DATA_ALTERACAO_DATA_CRIACAO_NULO);
        validarIntervaloMinAnos(dataAlteracao, TAMANHO_DATA_ALTERACAO_MIN, MSG_DATA_ALTERACAO_INTERVALO_LIMIAR);
        validarIntervaloMaxAnos(dataAlteracao, TAMANHO_DATA_ALTERACAO_MAX, MSG_DATA_ALTERACAO_INTERVALO_ULTRAPASSADO);
        validarDataFinalMenorInicial(dataAlteracao, this.dataCriacao, MSG_DATA_ALTERACAO_MENOR_CRIACAO);
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
    
}
