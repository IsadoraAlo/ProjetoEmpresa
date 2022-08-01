package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_NULO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_ENDERECO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_NULO;
import static br.com.contmatic.model.utils.constantes.contato.EmailConstantes.MSG_TIPO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasAlfabeticos;
import static br.com.contmatic.model.utils.validacao.Util.validarEmail;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Email {

    @NotNull(message = MSG_ENDERECO_NULO)
    @NotBlank(message = MSG_ENDERECO_BRANCO)
    @Size(message = MSG_ENDERECO_QTDE_CARACTERES, min = 5, max = 70)
    private String endereco;

    @NotNull(message = MSG_TIPO_NULO)
    @NotBlank(message = MSG_TIPO_BRANCO)
    @Size(message = MSG_TIPO_QTDE_CARACTERES, min = 9, max = 12)
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
        validarEmail(endereco, MSG_ENDERECO_CARACTERES_INVALIDO);
        this.endereco = endereco;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        validarApenasAlfabeticos(tipo, MSG_TIPO_CARACTERES_INVALIDO);
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(endereco).toHashCode();
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
        Email other = (Email) obj;
        return new EqualsBuilder().append(this.endereco, other.endereco).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
