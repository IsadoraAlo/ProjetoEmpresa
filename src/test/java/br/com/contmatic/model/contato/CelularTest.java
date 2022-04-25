package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_2;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_8;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_20;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.DDD_DEFAULT;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.DDD_TESTES;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.DDI_DEFAULT;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.DDI_TESTES;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.NUMERO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.NUMERO_TESTES;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CelularTest {

    Celular celular;

    Celular celularTestes;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        this.celular = new Celular(NUMERO_DEFAULT, DDD_DEFAULT, DDI_DEFAULT);
        this.celularTestes = new Celular(NUMERO_TESTES, DDD_TESTES, DDI_TESTES);
    }

    @After
    public void limpar_variavel() {
        this.celular = null;
        this.celularTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // NÚMERO

    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_numero_nulo() {
        this.celular.setNumero(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_numero_em_branco() {
        this.celular.setNumero(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_numero() {
        this.celular.setNumero(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_numero() {
        this.celular.setNumero(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_nao_permitidos_numero() {
        this.celular.setNumero(STRING_CARACTERES_ESPECIAIS_8);
    }

    @Test
    public void teste_06_deve_validar_numero_com_sucesso() {
        assertEquals(NUMERO_DEFAULT, this.celular.getNumero());
    }

    // DDD

    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_ddd_nulo() {
        this.celular.setDdd(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_ddd_em_branco() {
        this.celular.setDdd(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_ultrapassar_qntd_caractere_max_ddd() {
        this.celular.setDdd(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_limiar_qntd_caractere_min_ddd() {
        this.celular.setDdd(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_caracteres_nao_permitidos_ddd() {
        this.celular.setDdd(STRING_CARACTERES_ESPECIAIS_2);
    }

    @Test
    public void teste_12_deve_validar_ddd_com_sucesso() {
        assertEquals(DDD_DEFAULT, this.celular.getDdd());
    }

    // DDI

    @Test(expected = IllegalArgumentException.class)
    public void teste_13_nao_deve_aceitar_ddi_nulo() {
        this.celular.setDdi(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_14_nao_deve_aceitar_ddi_em_branco() {
        this.celular.setDdi(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_15_nao_deve_ultrapassar_qntd_caractere_max_ddi() {
        this.celular.setDdi(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_16_nao_deve_limiar_qntd_caractere_min_ddi() {
        this.celular.setDdi(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_17_nao_deve_aceitar_caracteres_nao_permitidos_ddi() {
        this.celular.setDdi(STRING_CARACTERES_ESPECIAIS_2);
    }

    @Test
    public void teste_18_deve_validar_ddi_com_sucesso() {
        assertEquals(DDI_DEFAULT, this.celular.getDdi());
    }

    // TO STRING

    @Test
    public void teste_19_deve_validar_to_string() {
        assertTrue(celular.toString().contains(NUMERO_DEFAULT));
        assertTrue(celular.toString().contains(DDD_DEFAULT));
        assertTrue(celular.toString().contains(DDI_DEFAULT));
    }

    // HASH CODE

    @Test
    public void teste_20_deve_validar_hash_code_equivalentes() {
        assertEquals(this.celular.hashCode(), this.celular.hashCode());
    }

    @Test
    public void teste_21_deve_validar_hash_code_divergentes() {
        assertFalse(this.celular.hashCode() == this.celularTestes.hashCode());
    }

    // EQUALS

    @Test
    public void teste_22_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.celular.equals(this.celular));
    }

    @Test
    public void teste_23_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.celular.equals(this.celularTestes));
    }

    @Test
    public void teste_24_nao_deve_validar_equals_nulo() {
        assertFalse(this.celular.equals(null));
    }

    @Test
    public void teste_25_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.celular.equals(new Object()));
    }

    @Test
    public void teste_26_nao_deve_validar_equals_objetos_divergentes_ddi_divergente() {
        Celular c = new Celular(NUMERO_DEFAULT, DDD_DEFAULT, DDI_TESTES);
        assertFalse(this.celular.equals(c));
    }

    @Test
    public void teste_27_nao_deve_validar_equals_objetos_divergentes_numero_divergente() {
        Celular c = new Celular(NUMERO_TESTES, DDD_DEFAULT, DDI_DEFAULT);
        assertFalse(this.celular.equals(c));
    }
    
    @Test
    public void teste_28_deve_validar_equals_objetos_divergentes_campos_iguais() {
        Celular c = new Celular(NUMERO_DEFAULT, DDD_DEFAULT, DDI_DEFAULT);
        assertTrue(this.celular.equals(c));
    }
    
    @Test(timeout = 1000)
    public void teste_29_deve_validar_string_campo() {
        assertThat("11",is(celular.getDdd()));
    }
    
    @Test
    @Ignore("Obrigatório ter um ignore")
    public void teste_30_deve_ignorar_o_teste() {
        Celular c = new Celular(NUMERO_DEFAULT, DDD_DEFAULT, DDI_DEFAULT);
        assertTrue(this.celular.equals(c));
    }
    
}
