package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_COD_IBGE_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_COD_IBGE_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_COD_IBGE_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_COD_IBGE_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_NOME_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_NOME_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_NOME_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_NOME_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_SIGLA_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_SIGLA_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_SIGLA_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.MSG_SIGLA_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.TAMANHO_COD_IBGE_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.TAMANHO_COD_IBGE_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.TAMANHO_NOME_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.TAMANHO_NOME_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.TAMANHO_SIGLA_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.UfConstantes.TAMANHO_SIGLA_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasAlfabeticos;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;

import java.util.Objects;

public class UF {

    private String nome;

    private String sigla;

    private String codigoIbge;

    public UF(String codigoIbge) {
        setCodigoIbge(codigoIbge);
    }

    public UF(String codigoIbge, String nome, String sigla) {
        setCodigoIbge(codigoIbge);
        setNome(nome);
        setSigla(sigla);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNulo(nome, MSG_NOME_NULO);
        validarEspacos(nome, MSG_NOME_BRANCO);
        validarQuantidadeCaracteresString(nome, TAMANHO_NOME_MAX, TAMANHO_NOME_MIN, MSG_NOME_QTDE_CARACTERES);
        validarTexto(nome, MSG_NOME_CARACTERES_INVALIDO);
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        validarNulo(sigla, MSG_SIGLA_NULO);
        validarEspacos(sigla, MSG_SIGLA_BRANCO);
        validarQuantidadeCaracteresString(sigla, TAMANHO_SIGLA_MAX, TAMANHO_SIGLA_MIN, MSG_SIGLA_QTDE_CARACTERES);
        validarApenasAlfabeticos(sigla, MSG_SIGLA_CARACTERES_INVALIDO);
        this.sigla = sigla;
    }

    public String getCodigoIbge() {
        return this.codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        validarNulo(codigoIbge, MSG_COD_IBGE_NULO);
        validarEspacos(codigoIbge, MSG_COD_IBGE_BRANCO);
        validarQuantidadeCaracteresString(codigoIbge, TAMANHO_COD_IBGE_MAX, TAMANHO_COD_IBGE_MIN, MSG_COD_IBGE_QTDE_CARACTERES);
        validarApenasNumericos(codigoIbge, MSG_COD_IBGE_CARACTERES_INVALIDO);
        this.codigoIbge = codigoIbge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIbge);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UF other = (UF) obj;
        return Objects.equals(codigoIbge, other.codigoIbge);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("UF [nome=").append(nome)
                .append(", sigla=").append(sigla)
                .append(", codigoIbge=").append(codigoIbge)
                .append("]")
                .toString();
    }

}
