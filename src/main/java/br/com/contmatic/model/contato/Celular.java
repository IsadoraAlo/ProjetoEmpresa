package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDD_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDD_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDD_NULO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDD_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDI_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDI_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDI_NULO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_DDI_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_NUMERO_BRANCO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_NUMERO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_NUMERO_NULO;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.MSG_NUMERO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Celular {

    @NotNull(message = MSG_NUMERO_NULO)
    @NotBlank(message = MSG_NUMERO_BRANCO)
    @Size(message = MSG_NUMERO_QTDE_CARACTERES, min = 8, max = 9)
    private String numero;

    @NotNull(message = MSG_DDD_NULO)
    @NotBlank(message = MSG_DDD_BRANCO)
    @Size(message = MSG_DDD_QTDE_CARACTERES, min = 2, max = 2)
    private String ddd;

    @NotNull(message = MSG_DDI_NULO)
    @NotBlank(message = MSG_DDI_BRANCO)
    @Size(message = MSG_DDI_QTDE_CARACTERES, min = 2, max = 3)
    private String ddi;

    public Celular(String numero, String ddd, String ddi) {
        setNumero(numero);
        setDdd(ddd);
        setDdi(ddi);
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        validarApenasNumericos(numero, MSG_NUMERO_CARACTERES_INVALIDO);
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        validarApenasNumericos(ddd, MSG_DDD_CARACTERES_INVALIDO);
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        validarApenasNumericos(ddi, MSG_DDI_CARACTERES_INVALIDO);
        this.ddi = ddi;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ddd).append(ddi).append(numero).toHashCode();
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
        Celular other = (Celular) obj;
        return new EqualsBuilder().append(this.ddd, other.ddd).append(this.ddi, other.ddi).append(this.numero, other.numero).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
