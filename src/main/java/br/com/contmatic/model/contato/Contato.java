package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_CELULAR_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_CELULAR_NULO;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_EMAIL_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_EMAIL_NULO;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_TELEFONE_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_TELEFONE_NULO;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Contato {

    @NotNull(message = MSG_TELEFONE_NULO)
    @Size(message = MSG_TELEFONE_LISTA_EXCEDIDA, min = 2, max = 2)
    private List<Telefone> telefones;

    @NotNull(message = MSG_EMAIL_NULO)
    @Size(message = MSG_EMAIL_LISTA_EXCEDIDA, min = 1, max = 2)
    private List<Email> emails;

    @NotNull(message = MSG_CELULAR_NULO)
    @Size(message = MSG_CELULAR_LISTA_EXCEDIDA, min = 1, max = 2)
    private List<Celular> celulares;

    public Contato(List<Celular> celulares) {
        setCelulares(celulares);
    }

    public Contato(List<Email> emails, List<Telefone> telefones, List<Celular> celulares) {
        setEmails(emails);
        setTelefones(telefones);
        setCelulares(celulares);
    }

    public List<Telefone> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Email> getEmails() {
        return this.emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Celular> getCelulares() {
        return this.celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(celulares).toHashCode();
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
        Contato other = (Contato) obj;
        return new EqualsBuilder().append(this.celulares, other.celulares).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
