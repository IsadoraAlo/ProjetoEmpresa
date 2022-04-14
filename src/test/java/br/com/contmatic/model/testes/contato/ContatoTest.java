package br.com.contmatic.model.testes.contato;

import static br.com.contmatic.model.constantes.contato.CelularTestConstantes.DDD_DEFAULT;
import static br.com.contmatic.model.constantes.contato.CelularTestConstantes.DDI_DEFAULT;
import static br.com.contmatic.model.constantes.contato.CelularTestConstantes.NUMERO_DEFAULT;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.ENDERECO_DEFAULT;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.TIPO_DEFAULT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Celular;
import br.com.contmatic.model.contato.Contato;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatoTest {
    
    Contato contato;

    Contato contatoTestes;

    List<Email> emails;

    List<Email> emailsTeste;

    List<Celular> celulares;

    List<Telefone> telefones;
    
    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        this.emails = new ArrayList<Email>();
        emails.add(new Email(ENDERECO_DEFAULT, TIPO_DEFAULT));

        this.emailsTeste = new ArrayList<Email>();
        emailsTeste.add(new Email("isadora@gmail.com.br"));

        this.celulares = new ArrayList<Celular>();
        celulares.add(new Celular(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));

        this.telefones = new ArrayList<Telefone>();
        telefones.add(new Telefone(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));

        this.contato = new Contato(emails, telefones, celulares);
        this.contatoTestes = new Contato(emailsTeste);
    }

    @After
    public void limpar_variavel() {
        this.contato = null;
        this.contatoTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }
    
    // E-MAIL
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_lista_email_nulo() {
        this.contato.setEmails(null);
    }
    
    @Test
    public void teste_02_deve_validar_lista_email_com_sucesso() {
        assertEquals(this.emails, this.contato.getEmails());
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_03_lista_email_maior_que_permitido() {
        emails.add(1, new Email(ENDERECO_DEFAULT));
        emails.add(2, new Email(ENDERECO_DEFAULT));
        emails.add(3, new Email(ENDERECO_DEFAULT));
        emails.add(4, new Email(ENDERECO_DEFAULT));
        contato.setEmails(emails);
    }
    
    // TELEFONE
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_04_nao_deve_aceitar_lista_telefone_nulo() {
        this.contato.setTelefones(null);
    }
    
    @Test
    public void teste_05_deve_validar_lista_telefone_com_sucesso() {
        assertEquals(this.telefones, this.contato.getTelefones());
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_06_lista_telefone_maior_que_permitido() {
        telefones.add(1, new Telefone(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        telefones.add(2, new Telefone(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        telefones.add(3, new Telefone(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        telefones.add(4, new Telefone(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        contato.setTelefones(telefones);
    }
    
    // CELULAR
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_lista_celular_nulo() {
        this.contato.setCelulares(null);
    }
    
    @Test
    public void teste_08_deve_validar_lista_celular_com_sucesso() {
        assertEquals(this.celulares, this.contato.getCelulares());
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_09_lista_celular_maior_que_permitido() {
        celulares.add(1, new Celular(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        celulares.add(2, new Celular(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        celulares.add(3, new Celular(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        celulares.add(4, new Celular(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        contato.setCelulares(celulares);
    }
    
    // TO STRING
    
    @Test
    public void teste_10_deve_validar_to_string() {
        assertTrue(contato.toString().contains(NUMERO_DEFAULT));
        assertTrue(contato.toString().contains(DDD_DEFAULT));
        assertTrue(contato.toString().contains(DDI_DEFAULT));
        assertTrue(contato.toString().contains(ENDERECO_DEFAULT));
        assertTrue(contato.toString().contains(TIPO_DEFAULT));
    }
    
    // HASH CODE
    
    @Test
    public void teste_11_deve_validar_hash_code_equivalentes() {
        assertEquals(this.contato.hashCode(), this.contato.hashCode());
    }
    
    @Test
    public void teste_12_deve_validar_hash_code_divergentes() {
        assertFalse(this.contato.hashCode() == this.contatoTestes.hashCode());
    }
    
    // EQUALS
    
    @Test
    public void teste_13_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.contato.equals(this.contato));
    }

    @Test
    public void teste_14_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.contato.equals(this.contatoTestes));
    }

    @Test
    public void teste_15_nao_deve_validar_equals_nulo() {
        assertFalse(this.contato.equals(null));
    }

    @Test
    public void teste_16_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.contato.equals(new Object()));
    }

}
