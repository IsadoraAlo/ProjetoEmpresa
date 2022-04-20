package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_20;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioTestConstantes.CODIGO_IBGE_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioTestConstantes.CODIGO_IBGE_TESTES;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioTestConstantes.CODIGO_IBGE_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioTestConstantes.NOME_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioTestConstantes.NOME_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.MunicipioTestConstantes.SIGLA_UF_DEFAULT;
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
public class MunicipioTest {

    Municipio municipio;

    Municipio municipioTestes;

    UF uf;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        this.uf = new UF(CODIGO_IBGE_UF_DEFAULT, NOME_UF_DEFAULT, SIGLA_UF_DEFAULT);
        this.municipio = new Municipio(CODIGO_IBGE_DEFAULT, NOME_DEFAULT, uf);
        this.municipioTestes = new Municipio(CODIGO_IBGE_TESTES);
    }

    @After
    public void limpar_variavel() {
        this.municipio = null;
        this.municipioTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // CÓDIGO IBGE

    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_codigo_ibge_nulo() {
        this.municipio.setCodigoIbge(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_codigo_ibge_em_branco() {
        this.municipio.setCodigoIbge(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_codigo_ibge() {
        this.municipio.setCodigoIbge(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_codigo_ibge() {
        this.municipio.setCodigoIbge(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_invalidos_codigo_ibge() {
        this.municipio.setCodigoIbge("!@#$%¨&");
    }

    @Test
    public void teste_06_deve_validar_codigo_ibge_com_sucesso() {
        assertEquals(CODIGO_IBGE_DEFAULT, this.municipio.getCodigoIbge());
    }

    // NOME

    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_nome_nulo() {
        this.municipio.setNome(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_nome_em_branco() {
        this.municipio.setNome(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_ultrapassar_qntd_caractere_max_nome() {
        this.municipio.setNome(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_limiar_qntd_caractere_min_nome() {
        this.municipio.setNome(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_caracteres_invalidos_nome() {
        this.municipio.setNome(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_12_deve_validar_nome_com_sucesso() {
        assertEquals(NOME_DEFAULT, this.municipio.getNome());
    }

    // UF

    @Test(expected = IllegalArgumentException.class)
    public void teste_13_nao_deve_aceitar_uf_nulo() {
        this.municipio.setUf(null);
    }

    @Test
    public void teste_14_deve_validar_uf_com_sucesso() {
        assertEquals(this.uf, this.municipio.getUf());
    }

    // TO STRING

    @Test
    public void teste_15_deve_validar_to_string() {
        assertTrue(municipio.toString().contains(CODIGO_IBGE_DEFAULT));
        assertTrue(municipio.toString().contains(NOME_DEFAULT));
        assertTrue(municipio.toString().contains(SIGLA_UF_DEFAULT));
    }

    // HASH CODE

    @Test
    public void teste_16_deve_validar_hash_code_equivalentes() {
        assertEquals(this.municipio.hashCode(), this.municipio.hashCode());
    }

    @Test
    public void teste_17_deve_validar_hash_code_divergentes() {
        assertFalse(this.municipio.hashCode() == this.municipioTestes.hashCode());
    }

    // EQUALS

    @Test
    public void teste_18_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.municipio.equals(this.municipio));
    }

    @Test
    public void teste_19_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.municipio.equals(this.municipioTestes));
    }

    @Test
    public void teste_20_nao_deve_validar_equals_nulo() {
        assertFalse(this.municipio.equals(null));
    }

    @Test
    public void teste_21_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.municipio.equals(new Object()));
    }

}
