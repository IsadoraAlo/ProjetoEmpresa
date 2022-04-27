package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.IP_ALTERACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.IP_CRIACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.USUARIO_ALTERACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.USUARIO_CRIACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.DATA_100_ANOS_PASSADO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.DATA_300_ANOS_FUTURO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.DATA_ATUAL;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.DATA_INICIO_ANO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.BIG_DECIMAL_99999999;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.BIG_DECIMAL_NEGATIVA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.INT_99999999;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.INT_NEGATIVA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoTestConstantes.CODIGO_BARRA_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoTestConstantes.CODIGO_BARRA_TESTES;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoTestConstantes.DESCRICAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoTestConstantes.PRECO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoTestConstantes.QUANTIDADE_DEFAULT;
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

public class ProdutoTest {

    Produto produto;

    Produto produtoTestes;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        this.produto = new Produto(CODIGO_BARRA_DEFAULT, PRECO_DEFAULT, QUANTIDADE_DEFAULT, DESCRICAO_DEFAULT);
        this.produtoTestes = new Produto(CODIGO_BARRA_TESTES);
    }

    @After
    public void limpar_variavel() {
        this.produto = null;
        this.produtoTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // CÓDIGO DE BARRAS

    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_codigo_barra_nulo() {
        this.produto.setCodigoBarra(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_codigo_barra_em_branco() {
        this.produto.setCodigoBarra(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_codigo_barra() {
        this.produto.setCodigoBarra(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_codigo_barra() {
        this.produto.setCodigoBarra(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_invalidos_codigo_barra() {
        this.produto.setCodigoBarra(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_06_deve_validar_codigo_barra_com_sucesso() {
        assertEquals(CODIGO_BARRA_DEFAULT, this.produto.getCodigoBarra());
    }

    // PREÇO

    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_preco_nulo() {
        this.produto.setPreco(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_ultrapassar_tamanho_max_preco() {
        this.produto.setPreco(BIG_DECIMAL_99999999);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_limiar_tamanho_min_preco() {
        this.produto.setPreco(BIG_DECIMAL_NEGATIVA_1);
    }

    @Test
    public void teste_10_deve_validar_preco_com_sucesso() {
        assertEquals(PRECO_DEFAULT, this.produto.getPreco());
    }

    // QUANTIDADE

    @Test(expected = IllegalArgumentException.class)
    public void teste_11_nao_deve_aceitar_quantidade_nulo() {
        this.produto.setQuantidade(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_12_nao_deve_ultrapassar_tamanho_max_quantidade() {
        this.produto.setQuantidade(INT_99999999);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_13_nao_deve_limiar_tamanho_min_quantidade() {
        this.produto.setQuantidade(INT_NEGATIVA_1);
    }

    @Test
    public void teste_14_deve_validar_quantidade_com_sucesso() {
        assertEquals(QUANTIDADE_DEFAULT, this.produto.getQuantidade());
    }

    // DESCRIÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_15_nao_deve_aceitar_descricao_nulo() {
        this.produto.setDescricao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_16_nao_deve_aceitar_descricao_em_branco() {
        this.produto.setDescricao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_17_nao_deve_ultrapassar_qntd_caractere_max_descricao() {
        this.produto.setDescricao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_18_nao_deve_limiar_qntd_caractere_min_descricao() {
        this.produto.setDescricao(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_19_nao_deve_aceitar_caracteres_invalidos_descricao() {
        this.produto.setDescricao(STRING_ALFABETICA_1);
    }

    @Test
    public void teste_20_deve_validar_descricao_com_sucesso() {
        assertEquals(DESCRICAO_DEFAULT, this.produto.getDescricao());
    }

    // USUÁRIO CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_21_nao_deve_aceitar_usuario_criacao_nulo() {
        this.produto.setUsuarioCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_22_nao_deve_aceitar_usuario_criacao_em_branco() {
        this.produto.setUsuarioCriacao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_23_nao_deve_ultrapassar_qntd_caractere_max_usuario_criacao() {
        this.produto.setUsuarioCriacao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_24_nao_deve_limiar_qntd_caractere_min_usuario_criacao() {
        this.produto.setUsuarioCriacao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_25_nao_deve_aceitar_caracteres_usuario_criacao() {
        this.produto.setUsuarioCriacao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_26_deve_validar_usuario_criacao_com_sucesso() {
        this.produto.setUsuarioCriacao(USUARIO_CRIACAO_DEFAULT);
        assertEquals(USUARIO_CRIACAO_DEFAULT, this.produto.getUsuarioCriacao());
    }

    // USUÁRIO ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_27_nao_deve_aceitar_usuario_alteracao_nulo() {
        this.produto.setUsuarioAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_28_nao_deve_aceitar_usuario_alteracao_em_branco() {
        this.produto.setUsuarioAlteracao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_29_nao_deve_ultrapassar_qntd_caractere_max_usuario_alteracao() {
        this.produto.setUsuarioAlteracao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_30_nao_deve_limiar_qntd_caractere_min_usuario_alteracao() {
        this.produto.setUsuarioAlteracao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_31_nao_deve_aceitar_caracteres_usuario_alteracao() {
        this.produto.setUsuarioAlteracao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_32_deve_validar_usuario_alteracao_com_sucesso() {
        this.produto.setUsuarioAlteracao(USUARIO_ALTERACAO_DEFAULT);
        assertEquals(USUARIO_ALTERACAO_DEFAULT, this.produto.getUsuarioAlteracao());
    }

    // IP CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_33_nao_deve_aceitar_ip_criacao_nulo() {
        this.produto.setIpCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_34_nao_deve_aceitar_ip_criacao_em_branco() {
        this.produto.setIpCriacao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_35_nao_deve_ultrapassar_qntd_caractere_max_ip_criacao() {
        this.produto.setIpCriacao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_36_nao_deve_limiar_qntd_caractere_min_ip_criacao() {
        this.produto.setIpCriacao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_37_nao_deve_aceitar_caracteres_ip_criacao() {
        this.produto.setIpCriacao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_38_deve_validar_ip_criacao_com_sucesso() {
        this.produto.setIpCriacao(IP_CRIACAO_DEFAULT);
        assertEquals(IP_CRIACAO_DEFAULT, this.produto.getIpCriacao());
    }

    // IP ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_39_nao_deve_aceitar_ip_alteracao_nulo() {
        this.produto.setIpAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_40_nao_deve_aceitar_ip_alteracao_em_branco() {
        this.produto.setIpAlteracao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_41_nao_deve_ultrapassar_qntd_caractere_max_ip_alteracao() {
        this.produto.setIpAlteracao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_42_nao_deve_limiar_qntd_caractere_min_ip_alteracao() {
        this.produto.setIpAlteracao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_43_nao_deve_aceitar_caracteres_ip_alteracao() {
        this.produto.setIpAlteracao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_44_deve_validar_ip_alteracao_com_sucesso() {
        this.produto.setIpAlteracao(IP_ALTERACAO_DEFAULT);
        assertEquals(IP_ALTERACAO_DEFAULT, this.produto.getIpAlteracao());
    }

    // DATA CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_45_nao_deve_aceitar_data_criacao_nulo() {
        this.produto.setDataCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_46_nao_deve_aceitar_data_criacao_muito_futura() {
        this.produto.setDataCriacao(DATA_300_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_47_nao_deve_aceitar_data_criacao_ultrapassada() {
        this.produto.setDataCriacao(DATA_100_ANOS_PASSADO);
    }

    @Test
    public void teste_48_deve_validar_data_criacao_com_sucesso() {
        this.produto.setDataCriacao(DATA_ATUAL);
        assertEquals(DATA_ATUAL, this.produto.getDataCriacao());
    }

    // DATA ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_49_nao_deve_aceitar_data_alteracao_nulo() {
        this.produto.setDataCriacao(DATA_INICIO_ANO);
        this.produto.setDataAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_50_nao_deve_aceitar_data_alteracao_muito_futura() {
        this.produto.setDataCriacao(DATA_INICIO_ANO);
        this.produto.setDataAlteracao(DATA_300_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_51_nao_deve_aceitar_data_alteracao_ultrapassada() {
        this.produto.setDataCriacao(DATA_INICIO_ANO);
        this.produto.setDataAlteracao(DATA_100_ANOS_PASSADO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_52_nao_deve_validar_data_alteracao_menor_data_criacao() {
        this.produto.setDataCriacao(DATA_ATUAL);
        this.produto.setDataAlteracao(DATA_INICIO_ANO);
    }

    @Test
    public void teste_53_deve_validar_data_alteracao_com_sucesso() {
        this.produto.setDataCriacao(DATA_INICIO_ANO);
        this.produto.setDataAlteracao(DATA_ATUAL);
        assertEquals(DATA_ATUAL, this.produto.getDataAlteracao());
    }

    // TO STRING

    @Test
    public void teste_54_deve_validar_to_string() {
        assertTrue(produto.toString().contains(CODIGO_BARRA_DEFAULT));
        assertTrue(produto.toString().contains(DESCRICAO_DEFAULT));
        this.produto.setIpAlteracao(IP_ALTERACAO_DEFAULT);
        this.produto.setIpCriacao(IP_CRIACAO_DEFAULT);
        this.produto.setUsuarioAlteracao(USUARIO_ALTERACAO_DEFAULT);
        this.produto.setUsuarioCriacao(USUARIO_CRIACAO_DEFAULT);
        assertTrue(produto.getUsuarioCriacao().toString().contains(USUARIO_CRIACAO_DEFAULT));
        assertTrue(produto.getUsuarioAlteracao().toString().contains(USUARIO_ALTERACAO_DEFAULT));
        assertTrue(produto.getIpCriacao().toString().contains(IP_CRIACAO_DEFAULT ));
        assertTrue(produto.getIpAlteracao().toString().contains(IP_ALTERACAO_DEFAULT));
    }

    // HASH CODE

    @Test
    public void teste_55_deve_validar_hash_code_equivalentes() {
        assertEquals(this.produto.hashCode(), this.produto.hashCode());
    }

    @Test
    public void teste_56_deve_validar_hash_code_divergentes() {
        assertFalse(this.produto.hashCode() == this.produtoTestes.hashCode());
    }

    // EQUALS

    @Test
    public void teste_57_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.produto.equals(this.produto));
    }

    @Test
    public void teste_58_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.produto.equals(this.produtoTestes));
    }

    @Test
    public void teste_59_nao_deve_validar_equals_nulo() {
        assertFalse(this.produto.equals(null));
    }

    @Test
    public void teste_60_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.produto.equals(new Object()));
    }

}
