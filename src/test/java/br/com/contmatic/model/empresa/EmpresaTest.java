package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.DATA_HORA_100_ANOS_FUTURO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.DATA_HORA_100_ANOS_PASSADO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.DATA_HORA_INICIO_ANO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.HORA_ATUAL;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.IP_ALTERACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.IP_CRIACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.USUARIO_ALTERACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.USUARIO_CRIACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.STRING_NUMERICA_20;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.DDD_DEFAULT;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.DDI_DEFAULT;
import static br.com.contmatic.model.utils.constantes.contato.CelularTestConstantes.NUMERO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaTestConstantes.CNPJ_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaTestConstantes.CNPJ_TESTES;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaTestConstantes.NOME_FANTASIA_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaTestConstantes.RAZAO_SOCIAL_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.CPF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.NUMERO_ENDERECO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoTestConstantes.CODIGO_BARRA_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CEP_DEFAULT;
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
import br.com.contmatic.model.endereco.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

    Empresa empresa;

    Empresa empresaTestes;

    Contato contato;

    List<Endereco> enderecos;

    List<Funcionario> funcionarios;

    List<Produto> produtos;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {

        List<Celular> celulares = new ArrayList<Celular>();
        celulares.add(new Celular(NUMERO_DEFAULT, DDD_DEFAULT, DDI_DEFAULT));

        this.contato = new Contato(celulares);

        this.enderecos = new ArrayList<Endereco>();
        this.enderecos.add(new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));

        this.produtos = new ArrayList<Produto>();
        this.produtos.add(new Produto(CODIGO_BARRA_DEFAULT));
        
        this.funcionarios = new ArrayList<Funcionario>();
        this.funcionarios.add(new Funcionario(CPF_DEFAULT, new Empresa(CNPJ_DEFAULT)));

        this.empresa = new Empresa(CNPJ_DEFAULT, NOME_FANTASIA_DEFAULT, RAZAO_SOCIAL_DEFAULT, contato, enderecos, funcionarios, produtos);
        this.empresaTestes = new Empresa(CNPJ_TESTES);

    }

    @After
    public void limpar_variavel() {
        this.empresa = null;
        this.empresaTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // CNPJ
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_cnpj_nulo() {
        this.empresa.setCnpj(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_cnpj_em_branco() {
        this.empresa.setCnpj(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_cnpj() {
        this.empresa.setCnpj(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_cnpj() {
        this.empresa.setCnpj(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_repeticoes_0_cnpj() {
        this.empresa.setCnpj("00000000000000");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_06_nao_deve_aceitar_repeticoes_1_cnpj() {
        this.empresa.setCnpj("11111111111111");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_07_nao_deve_aceitar_repeticoes_2_cnpj() {
        this.empresa.setCnpj("22222222222222");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_repeticoes_3_cnpj() {
        this.empresa.setCnpj("33333333333333");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_aceitar_repeticoes_4_cnpj() {
        this.empresa.setCnpj("44444444444444");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_aceitar_repeticoes_5_cnpj() {
        this.empresa.setCnpj("55555555555555");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_repeticoes_6_cnpj() {
        this.empresa.setCnpj("66666666666666");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_12_nao_deve_aceitar_repeticoes_7_cnpj() {
        this.empresa.setCnpj("77777777777777");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_13_nao_deve_aceitar_repeticoes_8_cnpj() {
        this.empresa.setCnpj("88888888888888");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_14_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("99999999999999");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_15_nao_deve_aceitar_cnpj_segundo_dig_invalido() {
        this.empresa.setCnpj("57354386000199");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_16_nao_deve_aceitar_cnpj_primeiro_dig_invalido() {
        this.empresa.setCnpj("34565785000181");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_17_nao_deve_aceitar_cnpj_com_resto_0() {
        this.empresa.setCnpj("18811495000100");
    }

    @Test
    public void teste_18_deve_validar_cnpj_com_sucesso() {
        this.empresa.setCnpj("39859862000100");
        assertEquals("39859862000100", this.empresa.getCnpj());
    }
    
    // ENDEREÇOS

    @Test(expected = IllegalArgumentException.class)
    public void teste_19_nao_deve_aceitar_lista_endereco_nulo() {
        this.empresa.setEndereco(null);
    }

    @Test
    public void teste_20_deve_validar_lista_endereco_com_sucesso() {
        assertEquals(this.enderecos, this.empresa.getEndereco());
    }

    @Test(expected = IllegalStateException.class)
    public void teste_21_lista_endereco_maior_que_permitido() {
        enderecos.add(1, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        enderecos.add(2, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        enderecos.add(3, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        enderecos.add(4, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        empresa.setEndereco(enderecos);
    }

    // FUNCIONÁRIO

    @Test(expected = IllegalArgumentException.class)
    public void teste_22_nao_deve_aceitar_lista_funcionario_nulo() {
        this.empresa.setFuncionario(null);
    }

    @Test
    public void teste_23_deve_validar_lista_funcionario_com_sucesso() {
        assertEquals(this.funcionarios, this.empresa.getFuncionario());
    }

    @Test(expected = IllegalStateException.class)
    public void teste_24_lista_funcionario_maior_que_permitido() {
        funcionarios.add(1, new Funcionario(CPF_DEFAULT,empresa));
        funcionarios.add(2, new Funcionario(CPF_DEFAULT,empresa));
        funcionarios.add(3, new Funcionario(CPF_DEFAULT,empresa));
        funcionarios.add(4, new Funcionario(CPF_DEFAULT,empresa));
        empresa.setFuncionario(funcionarios);
    }

    // PRODUTO

    @Test(expected = IllegalArgumentException.class)
    public void teste_25_nao_deve_aceitar_lista_produto_nulo() {
        this.empresa.setProduto(null);
    }

    @Test
    public void teste_26_deve_validar_lista_produto_com_sucesso() {
        assertEquals(this.produtos, this.empresa.getProduto());
    }

    @Test(expected = IllegalStateException.class)
    public void teste_27_lista_produto_maior_que_permitido() {
        produtos.add(1, new Produto(CODIGO_BARRA_DEFAULT));
        produtos.add(2, new Produto(CODIGO_BARRA_DEFAULT));
        produtos.add(3, new Produto(CODIGO_BARRA_DEFAULT));
        produtos.add(4, new Produto(CODIGO_BARRA_DEFAULT));
        empresa.setProduto(produtos);
    }

    // CONTATO

    @Test(expected = IllegalArgumentException.class)
    public void teste_28_nao_deve_aceitar_uf_nulo() {
        this.empresa.setContato(null);
    }

    @Test
    public void teste_29_deve_validar_uf_com_sucesso() {
        assertEquals(this.contato, this.empresa.getContato());
    }
    
    // ATIVA

    @Test(expected = IllegalArgumentException.class)
    public void teste_30_nao_deve_aceitar_ativa_nulo() {
        this.empresa.setAtiva(null);
    }
    
    @Test
    public void teste_31_deve_aceitar_ativa_false() {
        this.empresa.setAtiva(false);
        assertFalse(this.empresa.getAtiva());
    }

    @Test
    public void teste_32_deve_validar_ativa_com_sucesso() {
        assertTrue(this.empresa.getAtiva());
    }

    // RAZÃO SOCIAL

    @Test(expected = IllegalArgumentException.class)
    public void teste_33_nao_deve_aceitar_razao_social_nulo() {
        this.empresa.setRazaoSocial(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_34_nao_deve_aceitar_razao_social_em_branco() {
        this.empresa.setRazaoSocial(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_35_nao_deve_ultrapassar_qntd_caractere_max_razao_social() {
        this.empresa.setRazaoSocial(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_36_nao_deve_limiar_qntd_caractere_min_razao_social() {
        this.empresa.setRazaoSocial(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_37_nao_deve_aceitar_caracteres_invalidos_razao_social() {
        this.empresa.setRazaoSocial(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_38_deve_validar_razao_social_com_sucesso() {
        assertEquals(RAZAO_SOCIAL_DEFAULT, this.empresa.getRazaoSocial());
    }

    // NOME FANTASIA

    @Test(expected = IllegalArgumentException.class)
    public void teste_39_nao_deve_aceitar_nome_fantasia_nulo() {
        this.empresa.setNomeFantasia(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_40_nao_deve_aceitar_nome_fantasia_em_branco() {
        this.empresa.setNomeFantasia(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_41_nao_deve_ultrapassar_qntd_caractere_max_nome_fantasia() {
        this.empresa.setNomeFantasia(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_42_nao_deve_limiar_qntd_caractere_min_nome_fantasia() {
        this.empresa.setNomeFantasia(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_43_nao_deve_aceitar_caracteres_invalidos_nome_fantasia() {
        this.empresa.setNomeFantasia(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_44_deve_validar_nome_fantasia_com_sucesso() {
        assertEquals(NOME_FANTASIA_DEFAULT, this.empresa.getNomeFantasia());
    }

    // USUÁRIO CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_45_nao_deve_aceitar_usuario_criacao_nulo() {
        this.empresa.setUsuarioCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_46_nao_deve_aceitar_usuario_criacao_em_branco() {
        this.empresa.setUsuarioCriacao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_47_nao_deve_ultrapassar_qntd_caractere_max_usuario_criacao() {
        this.empresa.setUsuarioCriacao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_48_nao_deve_limiar_qntd_caractere_min_usuario_criacao() {
        this.empresa.setUsuarioCriacao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_49_nao_deve_aceitar_caracteres_usuario_criacao() {
        this.empresa.setUsuarioCriacao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_50_deve_validar_usuario_criacao_com_sucesso() {
        this.empresa.setUsuarioCriacao(USUARIO_CRIACAO_DEFAULT);
        assertEquals(USUARIO_CRIACAO_DEFAULT, this.empresa.getUsuarioCriacao());
    }

    // USUÁRIO ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_51_nao_deve_aceitar_usuario_alteracao_nulo() {
        this.empresa.setUsuarioAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_52_nao_deve_aceitar_usuario_alteracao_em_branco() {
        this.empresa.setUsuarioAlteracao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_53_nao_deve_ultrapassar_qntd_caractere_max_usuario_alteracao() {
        this.empresa.setUsuarioAlteracao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_54_nao_deve_limiar_qntd_caractere_min_usuario_alteracao() {
        this.empresa.setUsuarioAlteracao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_55_nao_deve_aceitar_caracteres_usuario_alteracao() {
        this.empresa.setUsuarioAlteracao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_56_deve_validar_usuario_alteracao_com_sucesso() {
        this.empresa.setUsuarioAlteracao(USUARIO_ALTERACAO_DEFAULT);
        assertEquals(USUARIO_ALTERACAO_DEFAULT, this.empresa.getUsuarioAlteracao());
    }

    // IP CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_57_nao_deve_aceitar_ip_criacao_nulo() {
        this.empresa.setIpCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_58_nao_deve_aceitar_ip_criacao_em_branco() {
        this.empresa.setIpCriacao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_59_nao_deve_ultrapassar_qntd_caractere_max_ip_criacao() {
        this.empresa.setIpCriacao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_60_nao_deve_limiar_qntd_caractere_min_ip_criacao() {
        this.empresa.setIpCriacao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_61_nao_deve_aceitar_caracteres_ip_criacao() {
        this.empresa.setIpCriacao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_62_deve_validar_ip_criacao_com_sucesso() {
        this.empresa.setIpCriacao(IP_CRIACAO_DEFAULT);
        assertEquals(IP_CRIACAO_DEFAULT, this.empresa.getIpCriacao());
    }

    // IP ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_63_nao_deve_aceitar_ip_alteracao_nulo() {
        this.empresa.setIpAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_64_nao_deve_aceitar_ip_alteracao_em_branco() {
        this.empresa.setIpAlteracao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_65_nao_deve_ultrapassar_qntd_caractere_max_ip_alteracao() {
        this.empresa.setIpAlteracao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_66_nao_deve_limiar_qntd_caractere_min_ip_alteracao() {
        this.empresa.setIpAlteracao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_67_nao_deve_aceitar_caracteres_ip_alteracao() {
        this.empresa.setIpAlteracao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_68_deve_validar_ip_alteracao_com_sucesso() {
        this.empresa.setIpAlteracao(IP_ALTERACAO_DEFAULT);
        assertEquals(IP_ALTERACAO_DEFAULT, this.empresa.getIpAlteracao());
    }

    // DATA CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_69_nao_deve_aceitar_data_criacao_nulo() {
        this.empresa.setDataCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_70_nao_deve_aceitar_data_criacao_muito_futura() {
        this.empresa.setDataCriacao(DATA_HORA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_71_nao_deve_aceitar_data_criacao_ultrapassada() {
        this.empresa.setDataCriacao(DATA_HORA_100_ANOS_PASSADO);
    }

    @Test
    public void teste_72_deve_validar_data_criacao_com_sucesso() {
        this.empresa.setDataCriacao(HORA_ATUAL);
        assertEquals(HORA_ATUAL, this.empresa.getDataCriacao());
    }

    // DATA ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_73_nao_deve_aceitar_data_alteracao_nulo() {
        this.empresa.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.empresa.setDataAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_74_nao_deve_aceitar_data_alteracao_muito_futura() {
        this.empresa.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.empresa.setDataAlteracao(DATA_HORA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_75_nao_deve_aceitar_data_alteracao_ultrapassada() {
        this.empresa.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.empresa.setDataAlteracao(DATA_HORA_100_ANOS_PASSADO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_76_nao_deve_validar_data_alteracao_menor_data_criacao() {
        this.empresa.setDataCriacao(HORA_ATUAL);
        this.empresa.setDataAlteracao(DATA_HORA_INICIO_ANO);
    }

    @Test
    public void teste_77_deve_validar_data_alteracao_com_sucesso() {
        this.empresa.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.empresa.setDataAlteracao(HORA_ATUAL);
        assertEquals(HORA_ATUAL, this.empresa.getDataAlteracao());
    }

    // TO STRING

    @Test
    public void teste_78_deve_validar_to_string() {
        Empresa enterprise = new Empresa(CNPJ_DEFAULT, NOME_FANTASIA_DEFAULT, RAZAO_SOCIAL_DEFAULT);
        assertTrue(enterprise.toString().contains(CNPJ_DEFAULT));
        assertTrue(enterprise.toString().contains(NOME_FANTASIA_DEFAULT));
        assertTrue(enterprise.toString().contains(RAZAO_SOCIAL_DEFAULT));
        this.empresa.setIpAlteracao(IP_ALTERACAO_DEFAULT);
        this.empresa.setIpCriacao(IP_CRIACAO_DEFAULT);
        this.empresa.setUsuarioAlteracao(USUARIO_ALTERACAO_DEFAULT);
        this.empresa.setUsuarioCriacao(USUARIO_CRIACAO_DEFAULT);
        assertTrue(empresa.getUsuarioCriacao().toString().contains(USUARIO_CRIACAO_DEFAULT));
        assertTrue(empresa.getUsuarioAlteracao().toString().contains(USUARIO_ALTERACAO_DEFAULT));
        assertTrue(empresa.getIpCriacao().toString().contains(IP_CRIACAO_DEFAULT ));
        assertTrue(empresa.getIpAlteracao().toString().contains(IP_ALTERACAO_DEFAULT));
    }

    // HASH CODE

    @Test
    public void teste_79_deve_validar_hash_code_equivalentes() {
        assertEquals(this.empresa.hashCode(), this.empresa.hashCode());
    }

    @Test
    public void teste_80_deve_validar_hash_code_divergentes() {
        assertFalse(this.empresa.hashCode() == this.empresaTestes.hashCode());
    }

    // EQUALS

    @Test
    public void teste_81_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.empresa.equals(this.empresa));
    }

    @Test
    public void teste_82_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.empresa.equals(this.empresaTestes));
    }

    @Test
    public void teste_83_nao_deve_validar_equals_nulo() {
        assertFalse(this.empresa.equals(null));
    }

    @Test
    public void teste_84_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.empresa.equals(new Object()));
    }

}
