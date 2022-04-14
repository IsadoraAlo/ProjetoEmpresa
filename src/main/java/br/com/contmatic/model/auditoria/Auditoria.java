package br.com.contmatic.model.auditoria;

import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_MENOR_CRIACAO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_ALTERACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_IP_CRIACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_ALTERACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_ALTERACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_CRIACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_DATA_CRIACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_IP_ALTERACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_IP_ALTERACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_IP_CRIACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_IP_CRIACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_DATA_ALTERACAO_DATA_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_USUARIO_CRIACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_USUARIO_CRIACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_CRIACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_NULO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_USUARIO_ALTERACAO_MAX;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.TAMANHO_USUARIO_ALTERACAO_MIN;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaConstantes.MSG_USUARIO_ALTERACAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarDataFinalMenorInicial;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarDataMax;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarDataMin;

import java.time.LocalDate;

public abstract class Auditoria {
	
	String usuarioCriacao;
	
	String ipCriacao;
	
	LocalDate dataCriacao;
	
	String usuarioAlteracao;
	
	String	ipAlteracao;
	
	LocalDate dataAlteracao;

	public String getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(String usuarioCriacao) {
		validarNulo(usuarioCriacao, MSG_USUARIO_CRIACAO_NULO);
		validarEspacos(usuarioCriacao, MSG_USUARIO_CRIACAO_BRANCO);
		validarQuantidadeCaracteresString(usuarioCriacao, TAMANHO_USUARIO_CRIACAO_MAX, TAMANHO_USUARIO_CRIACAO_MIN, MSG_USUARIO_CRIACAO_QTDE_CARACTERES);
		validarTexto(usuarioCriacao, MSG_USUARIO_CRIACAO_CARACTERES_INVALIDO);
		this.usuarioCriacao = usuarioCriacao;
	}

	public String getIpCriacao() {
		return ipCriacao;
	}

	public void setIpCriacao(String ipCriacao) {
		validarNulo(ipCriacao, MSG_IP_CRIACAO_NULO);
		validarEspacos(ipCriacao, MSG_IP_CRIACAO_BRANCO);
		validarQuantidadeCaracteresString(ipCriacao, TAMANHO_IP_CRIACAO_MAX, TAMANHO_IP_CRIACAO_MIN, MSG_IP_CRIACAO_QTDE_CARACTERES);
		validarApenasNumericos(ipCriacao, MSG_IP_CRIACAO_CARACTERES_INVALIDO);
		this.ipCriacao = ipCriacao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		validarNulo(dataCriacao, MSG_DATA_CRIACAO_NULO);
		validarDataMin(dataCriacao, TAMANHO_DATA_CRIACAO_MIN);
		validarDataMax(dataCriacao, TAMANHO_DATA_CRIACAO_MAX);
		this.dataCriacao = dataCriacao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		validarNulo(usuarioAlteracao, MSG_USUARIO_ALTERACAO_NULO);
		validarEspacos(usuarioAlteracao, MSG_USUARIO_ALTERACAO_BRANCO);
		validarQuantidadeCaracteresString(usuarioAlteracao, TAMANHO_USUARIO_ALTERACAO_MAX, TAMANHO_USUARIO_ALTERACAO_MIN, MSG_USUARIO_ALTERACAO_QTDE_CARACTERES);
		validarTexto(usuarioAlteracao, MSG_USUARIO_ALTERACAO_CARACTERES_INVALIDO);
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
		validarNulo(ipAlteracao, MSG_IP_ALTERACAO_NULO);
		validarEspacos(ipAlteracao, MSG_IP_ALTERACAO_BRANCO);
		validarQuantidadeCaracteresString(ipAlteracao, TAMANHO_IP_ALTERACAO_MAX, TAMANHO_IP_ALTERACAO_MIN, MSG_IP_ALTERACAO_QTDE_CARACTERES);
		validarApenasNumericos(ipAlteracao, MSG_IP_ALTERACAO_CARACTERES_INVALIDO);
		this.ipAlteracao = ipAlteracao;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		validarNulo(dataAlteracao, MSG_DATA_ALTERACAO_NULO);
		validarNulo(this.dataCriacao, MSG_DATA_ALTERACAO_DATA_CRIACAO_NULO);
		validarDataMin(dataAlteracao, TAMANHO_DATA_ALTERACAO_MIN);
		validarDataMax(dataAlteracao, TAMANHO_DATA_ALTERACAO_MAX);
		validarDataFinalMenorInicial(dataAlteracao, this.dataCriacao, MSG_DATA_ALTERACAO_MENOR_CRIACAO);
		this.dataAlteracao = dataAlteracao;
	}
	
}
