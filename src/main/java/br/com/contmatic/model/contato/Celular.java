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
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.TAMANHO_DDD_MAX;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.TAMANHO_DDD_MIN;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.TAMANHO_DDI_MAX;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.TAMANHO_DDI_MIN;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.TAMANHO_NUMERO_MAX;
import static br.com.contmatic.model.utils.constantes.contato.CelularConstantes.TAMANHO_NUMERO_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasNumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;

import java.util.Objects;

public class Celular {

    private String numero;

    private String ddd;

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
        validarNulo(numero, MSG_NUMERO_NULO);
        validarEspacos(numero, MSG_NUMERO_BRANCO);
        validarQuantidadeCaracteresString(numero, TAMANHO_NUMERO_MAX, TAMANHO_NUMERO_MIN, MSG_NUMERO_QTDE_CARACTERES);
        validarApenasNumericos(numero, MSG_NUMERO_CARACTERES_INVALIDO);
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        validarNulo(ddd, MSG_DDD_NULO);
        validarEspacos(ddd, MSG_DDD_BRANCO);
        validarQuantidadeCaracteresString(ddd, TAMANHO_DDD_MAX, TAMANHO_DDD_MIN, MSG_DDD_QTDE_CARACTERES);
        validarApenasNumericos(ddd, MSG_DDD_CARACTERES_INVALIDO);
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        validarNulo(ddi, MSG_DDI_NULO);
        validarEspacos(ddi, MSG_DDI_BRANCO);
        validarQuantidadeCaracteresString(ddi, TAMANHO_DDI_MAX, TAMANHO_DDI_MIN, MSG_DDI_QTDE_CARACTERES);
        validarApenasNumericos(ddi, MSG_DDI_CARACTERES_INVALIDO);
        this.ddi = ddi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, ddi, numero);
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
        return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(numero, other.numero);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Celular [numero=").append(numero)
                .append(", ddd=").append(ddd)
                .append(", ddi=").append(ddi)
                .append("]")
                .toString();
    }

}
