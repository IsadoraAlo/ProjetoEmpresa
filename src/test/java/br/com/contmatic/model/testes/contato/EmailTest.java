package br.com.contmatic.model.testes.contato;

import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.ENDERECO_DEFAULT;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.ENDERECO_TESTES;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.TIPO_DEFAULT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailTest {

    Email email;

    Email emailTestes;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        this.email = new Email(ENDERECO_DEFAULT, TIPO_DEFAULT);
        this.emailTestes = new Email(ENDERECO_TESTES);
    }

    @After
    public void limpar_variavel() {
        this.email = null;
        this.emailTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }
    
    // ENDEREÇO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_endereco_nulo() {
        this.email.setEndereco(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_endereco_em_branco() {
        this.email.setEndereco(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_endereco() {
        this.email.setEndereco(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_endereco() {
        this.email.setEndereco(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_nao_permitidos_endereco() {
        this.email.setEndereco(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_06_deve_validar_endereco_com_sucesso() {
        assertEquals(ENDERECO_DEFAULT, this.email.getEndereco());
    }
    
    // TIPO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_tipo_nulo() {
        this.email.setTipo(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_tipo_em_branco() {
        this.email.setTipo(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_ultrapassar_qntd_caractere_max_tipo() {
        this.email.setTipo(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_limiar_qntd_caractere_min_tipo() {
        this.email.setTipo(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_caracteres_nao_permitidos_tipo() {
        this.email.setTipo(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_12_deve_validar_tipo_com_sucesso() {
        assertEquals(TIPO_DEFAULT, this.email.getTipo());
    }
    
    // TO STRING
    
    @Test
    public void teste_13_deve_validar_to_string() {
        assertTrue(email.toString().contains(ENDERECO_DEFAULT));
        assertTrue(email.toString().contains(TIPO_DEFAULT));
    }
    
    // HASH CODE
    
    @Test
    public void teste_14_deve_validar_hash_code_equivalentes() {
        assertEquals(this.email.hashCode(), this.email.hashCode());
    }
    
    @Test
    public void teste_15_deve_validar_hash_code_divergentes() {
        assertFalse(this.email.hashCode() == this.emailTestes.hashCode());
    }
    
    // EQUALS
    
    @Test
    public void teste_16_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.email.equals(this.email));
    }

    @Test
    public void teste_17_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.email.equals(this.emailTestes));
    }

    @Test
    public void teste_18_nao_deve_validar_equals_nulo() {
        assertFalse(this.email.equals(null));
    }

    @Test
    public void teste_19_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.email.equals(new Object()));
    }
    
}
