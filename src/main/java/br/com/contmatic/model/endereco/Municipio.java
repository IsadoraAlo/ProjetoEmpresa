package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_COD_IBGE_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_COD_IBGE_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_COD_IBGE_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_COD_IBGE_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_NOME_BRANCO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_NOME_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_NOME_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_NOME_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.MSG_UF_NULO;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.TAMANHO_COD_IBGE_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.TAMANHO_COD_IBGE_MIN;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.TAMANHO_NOME_MAX;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioConstantes.TAMANHO_NOME_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;

import java.util.Objects;

public class Municipio {

    private String nome;

    private String codigoIbge;

    private UF uf;

    public Municipio(String codigoIbge) {
        setCodigoIbge(codigoIbge);
    }

    public Municipio(String codigoIbge, String nome, UF uf) {
        this(codigoIbge);
        setUf(uf);
        setNome(nome);
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

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        validarNulo(codigoIbge, MSG_COD_IBGE_NULO);
        validarEspacos(codigoIbge, MSG_COD_IBGE_BRANCO);
        validarQuantidadeCaracteresString(codigoIbge, TAMANHO_COD_IBGE_MAX, TAMANHO_COD_IBGE_MIN, MSG_COD_IBGE_QTDE_CARACTERES);
        validarApenasNumericos(codigoIbge, MSG_COD_IBGE_CARACTERES_INVALIDO);
        this.codigoIbge = codigoIbge;
    }

    public UF getUf() {
        return this.uf;
    }

    public void setUf(UF uf) {
        validarNulo(uf, MSG_UF_NULO);
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIbge);
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
        Municipio other = (Municipio) obj;
        return Objects.equals(codigoIbge, other.codigoIbge);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Municipio [nome=").append(nome)
                .append(", codigoIbge=").append(codigoIbge)
                .append(", uf=").append(uf)
                .append("]")
                .toString();
    }

}
