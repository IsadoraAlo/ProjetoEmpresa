package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_CELULAR_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_CELULAR_NULO;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_EMAIL_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_EMAIL_NULO;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_TELEFONE_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.MSG_TELEFONE_NULO;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.TAMANHO_CELULAR_LISTA_MAX;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.TAMANHO_CELULAR_LISTA_MIN;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.TAMANHO_EMAIL_LISTA_MAX;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.TAMANHO_EMAIL_LISTA_MIN;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.TAMANHO_TELEFONE_LISTA_MAX;
import static br.com.contmatic.model.utils.constantes.contato.ContatoConstantes.TAMANHO_TELEFONE_LISTA_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeElementoLista;

import java.util.List;
import java.util.Objects;

public class Contato {

    private List<Telefone> telefones;

    private List<Email> emails;

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
        validarNulo(telefones, MSG_TELEFONE_NULO);
        validarQuantidadeElementoLista(telefones, TAMANHO_TELEFONE_LISTA_MAX, TAMANHO_TELEFONE_LISTA_MIN, MSG_TELEFONE_LISTA_EXCEDIDA);
        this.telefones = telefones;
    }

    public List<Email> getEmails() {
        return this.emails;
    }

    public void setEmails(List<Email> emails) {
        validarNulo(emails, MSG_EMAIL_NULO);
        validarQuantidadeElementoLista(emails, TAMANHO_EMAIL_LISTA_MAX, TAMANHO_EMAIL_LISTA_MIN, MSG_EMAIL_LISTA_EXCEDIDA);
        this.emails = emails;
    }

    public List<Celular> getCelulares() {
        return this.celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        validarNulo(celulares, MSG_CELULAR_NULO);
        validarQuantidadeElementoLista(celulares, TAMANHO_CELULAR_LISTA_MAX, TAMANHO_CELULAR_LISTA_MIN, MSG_CELULAR_LISTA_EXCEDIDA);
        this.celulares = celulares;
    }

    @Override
    public int hashCode() {
        return Objects.hash(celulares);
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
        return Objects.equals(celulares, other.celulares);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Contato [telefones=").append(telefones)
                .append(", emails=").append(emails)
                .append(", celulares=").append(celulares)
                .append("]")
                .toString();
    }

}
