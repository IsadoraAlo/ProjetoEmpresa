package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_2;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_20;
import static br.com.contmatic.model.utils.constantes.endereco.UFTestConstantes.CODIGO_IBGE_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.UFTestConstantes.CODIGO_IBGE_TESTES;
import static br.com.contmatic.model.utils.constantes.endereco.UFTestConstantes.NOME_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.UFTestConstantes.SIGLA_DEFAULT;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UFTest {
    
    UF uf;

    UF ufTestes;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        this.uf = new UF(CODIGO_IBGE_DEFAULT, NOME_DEFAULT, SIGLA_DEFAULT);
        this.ufTestes = new UF(CODIGO_IBGE_TESTES);
    }

    @After
    public void limpar_variavel() {
        this.uf = null;
        this.ufTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // CÓDIGO IBGE
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_codigo_ibge_nulo() {
        this.uf.setCodigoIbge(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_codigo_ibge_em_branco() {
        this.uf.setCodigoIbge(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_codigo_ibge() {
        this.uf.setCodigoIbge(STRING_NUMERICA_20);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_codigo_ibge() {
        this.uf.setCodigoIbge(STRING_NUMERICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_invalidos_codigo_ibge() {
        this.uf.setCodigoIbge(STRING_CARACTERES_ESPECIAIS_2);
    }
    
    @Test
    public void teste_06_deve_validar_codigo_ibge_com_sucesso() {
        assertEquals(CODIGO_IBGE_DEFAULT, this.uf.getCodigoIbge());
    }
    
    // NOME
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_nome_nulo() {
        this.uf.setNome(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_nome_em_branco() {
        this.uf.setNome(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_ultrapassar_qntd_caractere_max_nome() {
        this.uf.setNome(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_limiar_qntd_caractere_min_nome() {
        this.uf.setNome(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_caracteres_invalidos_nome() {
        this.uf.setNome(STRING_NUMERICA_1);
    }
    
    @Test
    public void teste_12_deve_validar_nome_com_sucesso() {
        assertEquals(NOME_DEFAULT, this.uf.getNome());
    }
    
    // SIGLA
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_13_nao_deve_aceitar_sigla_nulo() {
        this.uf.setSigla(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_14_nao_deve_aceitar_sigla_em_branco() {
        this.uf.setSigla(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_15_nao_deve_ultrapassar_qntd_caractere_max_sigla() {
        this.uf.setSigla(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_16_nao_deve_limiar_qntd_caractere_min_sigla() {
        this.uf.setSigla(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_17_nao_deve_aceitar_caracteres_invalidos_sigla() {
        this.uf.setSigla("@!");
    }
    
    @Test
    public void teste_18_deve_validar_sigla_com_sucesso() {
        assertEquals(SIGLA_DEFAULT, this.uf.getSigla());
    }
    
    //TO STRING
    
    @Test
    public void teste_19_deve_validar_to_string() {
        assertTrue(uf.toString().contains(CODIGO_IBGE_DEFAULT));
        assertTrue(uf.toString().contains(NOME_DEFAULT));
        assertTrue(uf.toString().contains(SIGLA_DEFAULT));
    }
    
    // HASH CODE
    
    @Test
    public void teste_20_deve_validar_hash_code_equivalentes() {
        assertEquals(this.uf.hashCode(), this.uf.hashCode());
    }
    
    @Test
    public void teste_21_deve_validar_hash_code_divergentes() {
        assertFalse(this.uf.hashCode() == this.ufTestes.hashCode());
    }
    
    // EQUALS
    
    @Test
    public void teste_22_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.uf.equals(this.uf));
    }

    @Test
    public void teste_23_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.uf.equals(this.ufTestes));
    }

    @Test
    public void teste_24_nao_deve_validar_equals_nulo() {
        assertFalse(this.uf.equals(null));
    }

    @Test
    public void teste_25_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.uf.equals(new Object()));
    }
    
}
