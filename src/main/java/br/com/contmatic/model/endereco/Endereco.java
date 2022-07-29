package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_BAIRRO_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_BAIRRO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_BAIRRO_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_BAIRRO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_CEP_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_CEP_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_CEP_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_CEP_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_COMPLEMENTO_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_COMPLEMENTO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_COMPLEMENTO_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_COMPLEMENTO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_LOGRADOURO_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_LOGRADOURO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_LOGRADOURO_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_LOGRADOURO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_MUNICIPIO_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_NUMERO_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_NUMERO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_TIPO_LOGRADOURO_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_TIPO_LOGRADOURO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_TIPO_LOGRADOURO_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.MSG_TIPO_LOGRADOURO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_BAIRRO_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_BAIRRO_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_CEP_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_CEP_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_COMPLEMENTO_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_COMPLEMENTO_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_LOGRADOURO_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_LOGRADOURO_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_NUMERO_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_NUMERO_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_TIPO_LOGRADOURO_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoConstantes.TAMANHO_TIPO_LOGRADOURO_MIN;
import static br.com.contmatic.model.utils.validacao.Util.limitarQuantidadeNumericaMaximaMinima;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Endereco {

    private String cep;

    private String bairro;

    private Municipio municipio;

    private String tipoLogradouro;
    
    private String logradouro;

    private Integer numero;

    private String complemento;

    public Endereco(String cep, Integer numero) {
        setCep(cep);
        setNumero(numero);
    }

    public Endereco(String cep, Integer numero, String bairro, Municipio municipio, String tipoLogradouro, String logradouro, String complemento) {
        setCep(cep);
        setNumero(numero);
        setBairro(bairro);
        setMunicipio(municipio);
        setTipoLogradouro(tipoLogradouro);
        setLogradouro(logradouro);
        setComplemento(complemento);
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        validarNulo(cep, MSG_CEP_NULO);
        validarEspacos(cep, MSG_CEP_BRANCO);
        validarQuantidadeCaracteresString(cep, TAMANHO_CEP_MAX, TAMANHO_CEP_MIN, MSG_CEP_QTDE_CARACTERES);
        validarApenasNumericos(cep, MSG_CEP_CARACTERES_INVALIDO);
        this.cep = cep;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        validarNulo(numero, MSG_NUMERO_NULO);
        limitarQuantidadeNumericaMaximaMinima(numero, TAMANHO_NUMERO_MAX, TAMANHO_NUMERO_MIN, MSG_NUMERO_QTDE_CARACTERES);
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        validarNulo(bairro, MSG_BAIRRO_NULO);
        validarEspacos(bairro, MSG_BAIRRO_BRANCO);
        validarQuantidadeCaracteresString(bairro, TAMANHO_BAIRRO_MAX, TAMANHO_BAIRRO_MIN, MSG_BAIRRO_QTDE_CARACTERES);
        validarTexto(bairro, MSG_BAIRRO_CARACTERES_INVALIDO);
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(Municipio municipio) {
        validarNulo(municipio, MSG_MUNICIPIO_NULO);
        this.municipio = municipio;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        validarNulo(tipoLogradouro, MSG_TIPO_LOGRADOURO_NULO);
        validarEspacos(tipoLogradouro, MSG_TIPO_LOGRADOURO_BRANCO);
        validarQuantidadeCaracteresString(tipoLogradouro, TAMANHO_TIPO_LOGRADOURO_MAX, TAMANHO_TIPO_LOGRADOURO_MIN, MSG_TIPO_LOGRADOURO_QTDE_CARACTERES);
        validarTexto(tipoLogradouro, MSG_TIPO_LOGRADOURO_CARACTERES_INVALIDO);
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        validarNulo(logradouro, MSG_LOGRADOURO_NULO);
        validarEspacos(logradouro, MSG_LOGRADOURO_BRANCO);
        validarQuantidadeCaracteresString(logradouro, TAMANHO_LOGRADOURO_MAX, TAMANHO_LOGRADOURO_MIN, MSG_LOGRADOURO_QTDE_CARACTERES);
        validarTexto(logradouro, MSG_LOGRADOURO_CARACTERES_INVALIDO);
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        validarNulo(complemento, MSG_COMPLEMENTO_NULO);
        validarEspacos(complemento, MSG_COMPLEMENTO_BRANCO);
        validarQuantidadeCaracteresString(complemento, TAMANHO_COMPLEMENTO_MAX, TAMANHO_COMPLEMENTO_MIN, MSG_COMPLEMENTO_QTDE_CARACTERES);
        validarTexto(complemento, MSG_COMPLEMENTO_CARACTERES_INVALIDO);
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cep).append(numero).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Endereco other = (Endereco) obj;
        return new EqualsBuilder().append(this.cep, other.cep).append(this.numero, other.numero).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
