package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_NULO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_NULO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.TAMANHO_ENDERECO_MAX;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.TAMANHO_ENDERECO_MIN;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.TAMANHO_TIPO_MAX;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.TAMANHO_TIPO_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasAlfabeticos;
import static br.com.contmatic.model.utils.validacao.Util.validarEmail;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;

import java.util.Objects;

public class Email {

    private String endereco;

    private String tipo;

    public Email(String endereco) {
        setEndereco(endereco);
    }

    public Email(String endereco, String tipo) {
        setEndereco(endereco);
        setTipo(tipo);
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        validarNulo(endereco, MSG_ENDERECO_NULO);
        validarEspacos(endereco, MSG_ENDERECO_BRANCO);
        validarQuantidadeCaracteresString(endereco, TAMANHO_ENDERECO_MAX, TAMANHO_ENDERECO_MIN, MSG_ENDERECO_QTDE_CARACTERES);
        validarEmail(endereco, MSG_ENDERECO_CARACTERES_INVALIDO);
        this.endereco = endereco;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        validarNulo(tipo, MSG_TIPO_NULO);
        validarEspacos(tipo, MSG_TIPO_BRANCO);
        validarQuantidadeCaracteresString(tipo, TAMANHO_TIPO_MAX, TAMANHO_TIPO_MIN, MSG_TIPO_QTDE_CARACTERES);
        validarApenasAlfabeticos(tipo, MSG_TIPO_CARACTERES_INVALIDO);
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Email other = (Email) obj;
        return Objects.equals(endereco, other.endereco);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Email [endereco=").append(endereco)
                .append(", tipo=").append(tipo)
                .append("]")
                .toString();
    }

}
