package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.INT_99999999;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.INT_NEGATIVA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_20;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.BAIRRO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CEP_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CEP_TESTES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CODIGO_IBGE_MUNICIPIO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CODIGO_IBGE_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.COMPLEMENTO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.LOGRADOURO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.NOME_MUNICIPIO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.NOME_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.NUMERO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.NUMERO_TESTES;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.SIGLA_UF_DEFAULT;
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
public class EnderecoTest {

    Endereco endereco;

    Endereco enderecoTestes;

    Municipio municipio;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        UF uf = new UF(CODIGO_IBGE_UF_DEFAULT, NOME_UF_DEFAULT, SIGLA_UF_DEFAULT);
        this.municipio = new Municipio(CODIGO_IBGE_MUNICIPIO_DEFAULT, NOME_MUNICIPIO_DEFAULT, uf);
        this.endereco = new Endereco(CEP_DEFAULT, NUMERO_DEFAULT, BAIRRO_DEFAULT, municipio, LOGRADOURO_DEFAULT, COMPLEMENTO_DEFAULT);
        this.enderecoTestes = new Endereco(CEP_TESTES, NUMERO_TESTES);
    }

    @After
    public void limpar_variavel() {
        this.endereco = null;
        this.enderecoTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // CEP

    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_cep_nulo() {
        this.endereco.setCep(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_cep_em_branco() {
        this.endereco.setCep(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_cep() {
        this.endereco.setCep(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_cep() {
        this.endereco.setCep(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_invalidos_cep() {
        this.endereco.setCep("!*#&*!&@");
    }

    @Test
    public void teste_06_deve_validar_cep_com_sucesso() {
        assertEquals(CEP_DEFAULT, this.endereco.getCep());
    }

    // NÚMERO

    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_numero_nulo() {
        this.endereco.setNumero(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_ultrapassar_tamanho_max_numero() {
        this.endereco.setNumero(INT_99999999);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_limiar_tamanho_min_numero() {
        this.endereco.setNumero(INT_NEGATIVA_1);
    }

    @Test
    public void teste_10_deve_validar_numero_com_sucesso() {
        assertEquals(NUMERO_DEFAULT, this.endereco.getNumero());
    }

    // BAIRRO

    @Test(expected = IllegalArgumentException.class)
    public void teste_11_nao_deve_aceitar_bairro_nulo() {
        this.endereco.setBairro(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_12_nao_deve_aceitar_bairro_em_branco() {
        this.endereco.setBairro(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_13_nao_deve_ultrapassar_qntd_caractere_max_bairro() {
        this.endereco.setBairro(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_14_nao_deve_limiar_qntd_caractere_min_bairro() {
        this.endereco.setBairro(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_15_nao_deve_aceitar_caracteres_invalidos_bairro() {
        this.endereco.setBairro(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_16_deve_validar_bairro_com_sucesso() {
        assertEquals(BAIRRO_DEFAULT, this.endereco.getBairro());
    }

    // MUNICÍPIO

    @Test(expected = IllegalArgumentException.class)
    public void teste_17_nao_deve_aceitar_municipio_nulo() {
        this.endereco.setMunicipio(null);
    }

    @Test
    public void teste_18_deve_validar_municipio_com_sucesso() {
        assertEquals(this.municipio, this.endereco.getMunicipio());
    }

    // LOGRADOURO

    @Test(expected = IllegalArgumentException.class)
    public void teste_19_nao_deve_aceitar_logradouro_nulo() {
        this.endereco.setLogradouro(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_21_nao_deve_aceitar_logradouro_em_branco() {
        this.endereco.setLogradouro(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_21_nao_deve_ultrapassar_qntd_caractere_max_logradouro() {
        this.endereco.setLogradouro(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_22_nao_deve_limiar_qntd_caractere_min_logradouro() {
        this.endereco.setLogradouro(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_23_nao_deve_aceitar_caracteres_invalidos_logradouro() {
        this.endereco.setLogradouro(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_24_deve_validar_logradouro_com_sucesso() {
        assertEquals(LOGRADOURO_DEFAULT, this.endereco.getLogradouro());
    }

    // COMPLEMENTO

    @Test(expected = IllegalArgumentException.class)
    public void teste_25_nao_deve_aceitar_complemento_nulo() {
        this.endereco.setComplemento(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_26_nao_deve_aceitar_complemento_em_branco() {
        this.endereco.setComplemento(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_27_nao_deve_ultrapassar_qntd_caractere_max_complemento() {
        this.endereco.setComplemento(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_28_nao_deve_limiar_qntd_caractere_min_complemento() {
        this.endereco.setComplemento(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_29_nao_deve_aceitar_caracteres_invalidos_complemento() {
        this.endereco.setComplemento(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_30_deve_validar_complemento_com_sucesso() {
        assertEquals(COMPLEMENTO_DEFAULT, this.endereco.getComplemento());
    }

    // TO STRING

    @Test
    public void teste_31_deve_validar_to_string() {
        assertTrue(endereco.toString().contains(CEP_DEFAULT));
        assertTrue(endereco.toString().contains(BAIRRO_DEFAULT));
        assertTrue(endereco.toString().contains(CODIGO_IBGE_MUNICIPIO_DEFAULT));
        assertTrue(endereco.toString().contains(NOME_MUNICIPIO_DEFAULT));
        assertTrue(endereco.toString().contains(SIGLA_UF_DEFAULT));
        assertTrue(endereco.toString().contains(CODIGO_IBGE_UF_DEFAULT));
        assertTrue(endereco.toString().contains(NOME_UF_DEFAULT));
        assertTrue(endereco.toString().contains(SIGLA_UF_DEFAULT));
        assertTrue(endereco.toString().contains(LOGRADOURO_DEFAULT));
        assertTrue(endereco.toString().contains(COMPLEMENTO_DEFAULT));
    }

    // HASH CODE

    @Test
    public void teste_32_deve_validar_hash_code_equivalentes() {
        assertEquals(this.endereco.hashCode(), this.endereco.hashCode());
    }

    @Test
    public void teste_33_deve_validar_hash_code_divergentes() {
        assertFalse(this.endereco.hashCode() == this.enderecoTestes.hashCode());
    }

    // EQUALS

    @Test
    public void teste_34_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.endereco.equals(this.endereco));
    }

    @Test
    public void teste_35_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.endereco.equals(this.enderecoTestes));
    }

    @Test
    public void teste_36_nao_deve_validar_equals_nulo() {
        assertFalse(this.endereco.equals(null));
    }

    @Test
    public void teste_37_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.endereco.equals(new Object()));
    }
    
    @Test
    public void teste_38_nao_deve_validar_equals_objetos_divergentes_numero_divergente() {
        Endereco e = new Endereco(CEP_DEFAULT, NUMERO_TESTES);
        assertFalse(this.endereco.equals(e));
    }
    
    @Test
    public void teste_39_nao_deve_validar_equals_objetos_divergentes_cep_divergente() {
        Endereco e = new Endereco(CEP_TESTES, NUMERO_DEFAULT);
        assertFalse(this.endereco.equals(e));
    }
    
    @Test
    public void teste_40_deve_validar_equals_objetos_divergentes_campos_iguais() {
        Endereco e = new Endereco(CEP_DEFAULT, NUMERO_DEFAULT);
        assertTrue(this.endereco.equals(e));
    }

}
