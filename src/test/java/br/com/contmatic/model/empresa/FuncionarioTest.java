package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.DATA_HORA_100_ANOS_FUTURO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.DATA_HORA_100_ANOS_PASSADO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.DATA_HORA_INICIO_ANO;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.HORA_ATUAL;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.IP_ALTERACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.IP_CRIACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.USUARIO_ALTERACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.auditoria.AuditoriaTestConstantes.USUARIO_CRIACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.DATA_100_ANOS_FUTURO;
import static br.com.contmatic.model.utils.constantes.comuns.ConstantesComuns.DATA_100_ANOS_PASSADO;
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
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.CPF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.CPF_TESTES;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.DATA_APOSENTADORIA_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.DATA_CONTRATACAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.DATA_DEMISSAO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.DATA_NASCIMENTO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.ESCOLARIDADE_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.ESTADO_CIVIL_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.NOME_COMPLETO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.NOME_SOCIAL_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.NUMERO_ENDERECO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.RG_DEFAULT;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioTestConstantes.SEXO_FEMININO;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.BAIRRO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CEP_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CODIGO_IBGE_MUNICIPIO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.CODIGO_IBGE_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.COMPLEMENTO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.LOGRADOURO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.NOME_MUNICIPIO_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.NOME_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.SIGLA_UF_DEFAULT;
import static br.com.contmatic.model.utils.constantes.endereco.EnderecoTestConstantes.TIPO_LOGRADOURO_DEFAULT;
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
import br.com.contmatic.model.endereco.Municipio;
import br.com.contmatic.model.endereco.UF;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioTest {

    Funcionario funcionario;

    Funcionario funcionarioTestes;

    Endereco endereco;

    Contato contato;

    Empresa empresa;

    @BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        List<Celular> celulares = new ArrayList<Celular>();
        celulares.add(new Celular(NUMERO_DEFAULT, DDD_DEFAULT, DDI_DEFAULT));

        this.contato = new Contato(celulares);

        UF uf = new UF(CODIGO_IBGE_UF_DEFAULT, NOME_UF_DEFAULT, SIGLA_UF_DEFAULT);

        Municipio municipio = new Municipio(CODIGO_IBGE_MUNICIPIO_DEFAULT, NOME_MUNICIPIO_DEFAULT, uf);

        this.empresa = new Empresa(CNPJ_DEFAULT);

        this.endereco = new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT, BAIRRO_DEFAULT, municipio, TIPO_LOGRADOURO_DEFAULT, LOGRADOURO_DEFAULT, COMPLEMENTO_DEFAULT);

        this.funcionario = new Funcionario(CPF_DEFAULT, empresa, NOME_COMPLETO_DEFAULT, DATA_NASCIMENTO_DEFAULT, SEXO_FEMININO);
        this.funcionarioTestes = new Funcionario(CPF_TESTES, empresa);
    }

    @After
    public void limpar_variavel() {
        this.funcionario = null;
        this.funcionarioTestes = null;
    }

    @AfterClass
    public static void finalizar_classe() {
        System.out.println("Finalizando testes");
    }

    // NOME COMPLETO

    @Test(expected = IllegalArgumentException.class)
    public void teste_01_nao_deve_aceitar_nome_completo_nulo() {
        this.funcionario.setNomeCompleto(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_nome_completo_em_branco() {
        this.funcionario.setNomeCompleto(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_ultrapassar_qntd_caractere_max_nome_completo() {
        this.funcionario.setNomeCompleto(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_limiar_qntd_caractere_min_nome_completo() {
        this.funcionario.setNomeCompleto(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_caracteres_invalidos_nome_completo() {
        this.funcionario.setNomeCompleto(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_06_nao_deve_aceitar_nome_completo_com_espaco_comeco() {
        this.funcionario.setNomeCompleto(" Julia huhu");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_07_nao_deve_aceitar_nome_completo_com_espaco_final() {
        this.funcionario.setNomeCompleto("Julia huhu ");
    }

    @Test
    public void teste_08_deve_validar_nome_completo_com_sucesso() {
        assertEquals(NOME_COMPLETO_DEFAULT, this.funcionario.getNomeCompleto());
    }

    // NOME SOCIAL

    @Test(expected = IllegalArgumentException.class)
    public void teste_09_nao_deve_aceitar_nome_social_nulo() {
        this.funcionario.setNomeSocial(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_aceitar_nome_social_em_branco() {
        this.funcionario.setNomeSocial(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_ultrapassar_qntd_caractere_max_nome_social() {
        this.funcionario.setNomeSocial(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_12_nao_deve_limiar_qntd_caractere_min_nome_social() {
        this.funcionario.setNomeSocial(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_13_nao_deve_aceitar_caracteres_invalidos_nome_social() {
        this.funcionario.setNomeSocial(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_14_deve_validar_nome_social_com_sucesso() {
        this.funcionario.setNomeSocial(NOME_SOCIAL_DEFAULT);
        assertEquals(NOME_SOCIAL_DEFAULT, this.funcionario.getNomeSocial());
    }

    // ESTADO CIVIL

    @Test(expected = IllegalArgumentException.class)
    public void teste_15_nao_deve_aceitar_estado_civil_nulo() {
        this.funcionario.setEstadoCivil(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_16_nao_deve_aceitar_estado_civil_em_branco() {
        this.funcionario.setEstadoCivil(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_17_nao_deve_ultrapassar_qntd_caractere_max_estado_civil() {
        this.funcionario.setEstadoCivil(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_18_nao_deve_limiar_qntd_caractere_min_estado_civil() {
        this.funcionario.setEstadoCivil(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_19_nao_deve_aceitar_caracteres_invalidos_estado_civil() {
        this.funcionario.setEstadoCivil(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_20_deve_validar_estado_civil_com_sucesso() {
        this.funcionario.setEstadoCivil(ESTADO_CIVIL_DEFAULT);
        assertEquals(ESTADO_CIVIL_DEFAULT, this.funcionario.getEstadoCivil());
    }

    // ESCOLARIDADE

    @Test(expected = IllegalArgumentException.class)
    public void teste_21_nao_deve_aceitar_escolaridade_nulo() {
        this.funcionario.setEscolaridade(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_22_nao_deve_aceitar_escolaridade_em_branco() {
        this.funcionario.setEscolaridade(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_23_nao_deve_ultrapassar_qntd_caractere_max_escolaridade() {
        this.funcionario.setEscolaridade(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_24_nao_deve_limiar_qntd_caractere_min_escolaridade() {
        this.funcionario.setEscolaridade(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_25_nao_deve_aceitar_caracteres_invalidos_escolaridade() {
        this.funcionario.setEscolaridade(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_26_deve_validar_escolaridade_com_sucesso() {
        this.funcionario.setEscolaridade(ESCOLARIDADE_DEFAULT);
        assertEquals(ESCOLARIDADE_DEFAULT, this.funcionario.getEscolaridade());
    }

    // RG

    @Test(expected = IllegalArgumentException.class)
    public void teste_27_nao_deve_aceitar_rg_nulo() {
        this.funcionario.setRg(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_28_nao_deve_aceitar_rg_em_branco() {
        this.funcionario.setRg(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_29_nao_deve_ultrapassar_qntd_caractere_max_rg() {
        this.funcionario.setRg(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_30_nao_deve_limiar_qntd_caractere_min_rg() {
        this.funcionario.setRg(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_31_nao_deve_aceitar_caracteres_invalidos_rg() {
        this.funcionario.setRg("!!!!!!!!!!!");
    }

    @Test
    public void teste_32_deve_validar_rg_com_sucesso() {
        this.funcionario.setRg(RG_DEFAULT);
        assertEquals(RG_DEFAULT, this.funcionario.getRg());
    }

    // SEXO

    @Test(expected = IllegalArgumentException.class)
    public void teste_33_nao_deve_aceitar_sexo_nulo() {
        this.funcionario.setSexo(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_34_nao_deve_aceitar_sexo_em_branco() {
        this.funcionario.setSexo(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_35_nao_deve_ultrapassar_qntd_caractere_max_sexo() {
        this.funcionario.setSexo(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_36_nao_deve_limiar_qntd_caractere_min_sexo() {
        this.funcionario.setSexo("");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_37_nao_deve_aceitar_caracteres_invalidos_sexo() {
        this.funcionario.setSexo(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_38_deve_validar_sexo_com_sucesso() {
        assertEquals(SEXO_FEMININO, this.funcionario.getSexo());
    }

    // ENDEREÇO

    @Test(expected = IllegalArgumentException.class)
    public void teste_39_nao_deve_aceitar_endereco_nulo() {
        this.funcionario.setEndereco(null);
    }

    @Test
    public void teste_40_deve_validar_endereco_com_sucesso() {
        this.funcionario.setEndereco(this.endereco);
        assertEquals(this.endereco, this.funcionario.getEndereco());
    }

    // CONTATO

    @Test(expected = IllegalArgumentException.class)
    public void teste_41_nao_deve_aceitar_contato_nulo() {
        this.funcionario.setContato(null);
    }

    @Test
    public void teste_42_deve_validar_contato_com_sucesso() {
        this.funcionario.setContato(this.contato);
        assertEquals(this.contato, this.funcionario.getContato());
    }

    // CONTATO

    @Test(expected = IllegalArgumentException.class)
    public void teste_43_nao_deve_aceitar_empresa_nulo() {
        this.funcionario.setEmpresa(null);
    }

    @Test
    public void teste_44_deve_validar_empresa_com_sucesso() {
        assertEquals(this.empresa, this.funcionario.getEmpresa());
    }

    // DATA NASCIMENTO

    @Test(expected = IllegalArgumentException.class)
    public void teste_45_nao_deve_aceitar_data_nascimento_nulo() {
        this.funcionario.setDataNascimento(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_46_nao_deve_aceitar_data_nascimento_muito_futura() {
        this.funcionario.setDataNascimento(DATA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_47_nao_deve_aceitar_data_nascimento_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_100_ANOS_PASSADO);
    }

    @Test
    public void teste_48_deve_validar_data_nascimento_com_sucesso() {
        assertEquals(DATA_NASCIMENTO_DEFAULT, this.funcionario.getDataNascimento());
    }

    // DATA CONTRATAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_49_nao_deve_aceitar_data_contratacao_nulo() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_50_nao_deve_aceitar_data_contratacao_muito_futura() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_51_nao_deve_aceitar_data_contratacao_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_100_ANOS_PASSADO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_52_nao_deve_validar_data_contratacao_menor_data_nascimento() {
        this.funcionario.setDataNascimento(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_NASCIMENTO_DEFAULT);
    }

    @Test
    public void teste_53_deve_validar_data_contratacao_com_sucesso() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        assertEquals(DATA_CONTRATACAO_DEFAULT, this.funcionario.getDataContratacao());
    }

    // DATA DEMISSÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_54_nao_deve_aceitar_data_demissao_nulo() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_55_nao_deve_aceitar_data_demissao_muito_futura() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_56_nao_deve_aceitar_data_demissao_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_100_ANOS_PASSADO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_57_nao_deve_validar_data_demissao_menor_data_contratacao() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_DEMISSAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_CONTRATACAO_DEFAULT);
    }

    @Test
    public void teste_58_deve_validar_data_demissao_com_sucesso() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_DEMISSAO_DEFAULT);
        assertEquals(DATA_DEMISSAO_DEFAULT, this.funcionario.getDataDemissao());
    }

    // DATA APOSENTADORIA

    @Test(expected = IllegalArgumentException.class)
    public void teste_59_nao_deve_aceitar_data_aposentadoria_nulo() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_DEMISSAO_DEFAULT);
        this.funcionario.setDataAposentadoria(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_60_nao_deve_aceitar_data_aposentadoria_muito_futura() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_61_nao_deve_aceitar_data_aposentadoria_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_100_ANOS_PASSADO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_62_nao_deve_validar_data_aposentadoria_menor_data_contratacao() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_APOSENTADORIA_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_CONTRATACAO_DEFAULT);
    }

    @Test
    public void teste_63_deve_validar_data_aposentadoria_com_sucesso() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_APOSENTADORIA_DEFAULT);
        assertEquals(DATA_APOSENTADORIA_DEFAULT, this.funcionario.getDataAposentadoria());
    }

    // CPF

    @Test(expected = IllegalArgumentException.class)
    public void teste_64_nao_deve_aceitar_cpf_nulo() {
        this.funcionario.setCpf(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_65_nao_deve_aceitar_cpf_em_branco() {
        this.funcionario.setCpf(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_66_nao_deve_ultrapassar_qntd_caractere_max_cpf() {
        this.funcionario.setCpf(STRING_NUMERICA_20);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_67_nao_deve_limiar_qntd_caractere_min_cpf() {
        this.funcionario.setCpf(STRING_NUMERICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_68_nao_deve_aceitar_caracteres_invalidos_cpf() {
        this.funcionario.setCpf(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_69_nao_deve_aceitar_repeticoes_0_cpf() {
        this.funcionario.setCpf("00000000000");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_70_nao_deve_aceitar_repeticoes_1_cpf() {
        this.funcionario.setCpf("11111111111");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_71_nao_deve_aceitar_repeticoes_2_cpf() {
        this.funcionario.setCpf("22222222222");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_72_nao_deve_aceitar_repeticoes_3_cpf() {
        this.funcionario.setCpf("33333333333");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_73_nao_deve_aceitar_repeticoes_4_cpf() {
        this.funcionario.setCpf("44444444444");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_74_nao_deve_aceitar_repeticoes_5_cpf() {
        this.funcionario.setCpf("55555555555");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_75_nao_deve_aceitar_repeticoes_6_cpf() {
        this.funcionario.setCpf("66666666666");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_76_nao_deve_aceitar_repeticoes_7_cpf() {
        this.funcionario.setCpf("77777777777");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_77_nao_deve_aceitar_repeticoes_8_cpf() {
        this.funcionario.setCpf("88888888888");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_78_nao_deve_aceitar_repeticoes_9_cpf() {
        this.funcionario.setCpf("99999999999");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_79_nao_deve_aceitar_cpf_segundo_dig_invalido() {
        this.funcionario.setCpf("92929499011");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_80_nao_deve_aceitar_cpf_primeiro_dig_invalido() {
        this.funcionario.setCpf("74070649055");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_81_nao_deve_validar_cpf_com_resto_0() {
        this.funcionario.setCpf("52704603000");
    }

    @Test
    public void teste_82_deve_validar_cpf_com_sucesso() {
        this.funcionario.setCpf("70582518008");
        assertEquals("70582518008", this.funcionario.getCpf());
    }

    // USUÁRIO CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_83_nao_deve_aceitar_usuario_criacao_nulo() {
        this.funcionario.setUsuarioCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_84_nao_deve_aceitar_usuario_criacao_em_branco() {
        this.funcionario.setUsuarioCriacao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_85_nao_deve_ultrapassar_qntd_caractere_max_usuario_criacao() {
        this.funcionario.setUsuarioCriacao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_86_nao_deve_limiar_qntd_caractere_min_usuario_criacao() {
        this.funcionario.setUsuarioCriacao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_87_nao_deve_aceitar_caracteres_usuario_criacao() {
        this.funcionario.setUsuarioCriacao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_88_deve_validar_usuario_criacao_com_sucesso() {
        this.funcionario.setUsuarioCriacao(USUARIO_CRIACAO_DEFAULT);
        assertEquals(USUARIO_CRIACAO_DEFAULT, this.funcionario.getUsuarioCriacao());
    }

    // USUÁRIO ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_89_nao_deve_aceitar_usuario_alteracao_nulo() {
        this.funcionario.setUsuarioAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_90_nao_deve_aceitar_usuario_alteracao_em_branco() {
        this.funcionario.setUsuarioAlteracao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_91_nao_deve_ultrapassar_qntd_caractere_max_usuario_alteracao() {
        this.funcionario.setUsuarioAlteracao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_92_nao_deve_limiar_qntd_caractere_min_usuario_alteracao() {
        this.funcionario.setUsuarioAlteracao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_93_nao_deve_aceitar_caracteres_usuario_alteracao() {
        this.funcionario.setUsuarioAlteracao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_94_deve_validar_usuario_alteracao_com_sucesso() {
        this.funcionario.setUsuarioAlteracao(USUARIO_ALTERACAO_DEFAULT);
        assertEquals(USUARIO_ALTERACAO_DEFAULT, this.funcionario.getUsuarioAlteracao());
    }

    // IP CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_95_nao_deve_aceitar_ip_criacao_nulo() {
        this.funcionario.setIpCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_96_nao_deve_aceitar_ip_criacao_em_branco() {
        this.funcionario.setIpCriacao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_97_nao_deve_ultrapassar_qntd_caractere_max_ip_criacao() {
        this.funcionario.setIpCriacao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_98_nao_deve_limiar_qntd_caractere_min_ip_criacao() {
        this.funcionario.setIpCriacao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_99_nao_deve_aceitar_caracteres_ip_criacao() {
        this.funcionario.setIpCriacao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_100_deve_validar_ip_criacao_com_sucesso() {
        this.funcionario.setIpCriacao(IP_CRIACAO_DEFAULT);
        assertEquals(IP_CRIACAO_DEFAULT, this.funcionario.getIpCriacao());
    }

    // IP ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_101_nao_deve_aceitar_ip_alteracao_nulo() {
        this.funcionario.setIpAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_102_nao_deve_aceitar_ip_alteracao_em_branco() {
        this.funcionario.setIpAlteracao(ESPACO_BRANCO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_103_nao_deve_ultrapassar_qntd_caractere_max_ip_alteracao() {
        this.funcionario.setIpAlteracao(STRING_ALFABETICA_75);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_104_nao_deve_limiar_qntd_caractere_min_ip_alteracao() {
        this.funcionario.setIpAlteracao(STRING_ALFABETICA_1);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_105_nao_deve_aceitar_caracteres_ip_alteracao() {
        this.funcionario.setIpAlteracao(STRING_CARACTERES_ESPECIAIS_10);
    }

    @Test
    public void teste_106_deve_validar_ip_alteracao_com_sucesso() {
        this.funcionario.setIpAlteracao(IP_ALTERACAO_DEFAULT);
        assertEquals(IP_ALTERACAO_DEFAULT, this.funcionario.getIpAlteracao());
    }

    // DATA CRIAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_107_nao_deve_aceitar_data_criacao_nulo() {
        this.funcionario.setDataCriacao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_108_nao_deve_aceitar_data_criacao_muito_futura() {
        this.funcionario.setDataCriacao(DATA_HORA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_109_nao_deve_aceitar_data_criacao_ultrapassada() {
        this.funcionario.setDataCriacao(DATA_HORA_100_ANOS_PASSADO);
    }

    @Test
    public void teste_110_deve_validar_data_criacao_com_sucesso() {
        this.funcionario.setDataCriacao(HORA_ATUAL);
        assertEquals(HORA_ATUAL, this.funcionario.getDataCriacao());
    }

    // DATA ALTERAÇÃO

    @Test(expected = IllegalArgumentException.class)
    public void teste_111_nao_deve_aceitar_data_alteracao_nulo() {
        this.funcionario.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.funcionario.setDataAlteracao(null);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_112_nao_deve_aceitar_data_alteracao_muito_futura() {
        this.funcionario.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.funcionario.setDataAlteracao(DATA_HORA_100_ANOS_FUTURO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_113_nao_deve_aceitar_data_alteracao_ultrapassada() {
        this.funcionario.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.funcionario.setDataAlteracao(DATA_HORA_100_ANOS_PASSADO);
    }

    @Test(expected = IllegalStateException.class)
    public void teste_114_nao_deve_validar_data_alteracao_menor_data_criacao() {
        this.funcionario.setDataCriacao(HORA_ATUAL);
        this.funcionario.setDataAlteracao(DATA_HORA_INICIO_ANO);
    }

    @Test
    public void teste_115_deve_validar_data_alteracao_com_sucesso() {
        this.funcionario.setDataCriacao(DATA_HORA_INICIO_ANO);
        this.funcionario.setDataAlteracao(HORA_ATUAL);
        assertEquals(HORA_ATUAL, this.funcionario.getDataAlteracao());
    }

    // TO STRING

    @Test
    public void teste_116_deve_validar_to_string() {
        this.funcionario.setEndereco(this.endereco);
        assertTrue(funcionario.toString().contains(CPF_DEFAULT));
        assertTrue(funcionario.toString().contains(NOME_COMPLETO_DEFAULT));
        assertTrue(funcionario.toString().contains(SEXO_FEMININO));
        assertTrue(funcionario.toString().contains(CEP_DEFAULT));
        assertTrue(funcionario.toString().contains(BAIRRO_DEFAULT));
        assertTrue(funcionario.toString().contains(LOGRADOURO_DEFAULT));
        assertTrue(funcionario.toString().contains(COMPLEMENTO_DEFAULT));
        assertTrue(funcionario.toString().contains(CODIGO_IBGE_MUNICIPIO_DEFAULT));
        assertTrue(funcionario.toString().contains(NOME_MUNICIPIO_DEFAULT));
        assertTrue(funcionario.toString().contains(CODIGO_IBGE_UF_DEFAULT));
        assertTrue(funcionario.toString().contains(NOME_UF_DEFAULT));
        assertTrue(funcionario.toString().contains(SIGLA_UF_DEFAULT));
        this.funcionario.setIpAlteracao(IP_ALTERACAO_DEFAULT);
        this.funcionario.setIpCriacao(IP_CRIACAO_DEFAULT);
        this.funcionario.setUsuarioAlteracao(USUARIO_ALTERACAO_DEFAULT);
        this.funcionario.setUsuarioCriacao(USUARIO_CRIACAO_DEFAULT);
        assertTrue(funcionario.getUsuarioCriacao().toString().contains(USUARIO_CRIACAO_DEFAULT));
        assertTrue(funcionario.getUsuarioAlteracao().toString().contains(USUARIO_ALTERACAO_DEFAULT));
        assertTrue(funcionario.getIpCriacao().toString().contains(IP_CRIACAO_DEFAULT));
        assertTrue(funcionario.getIpAlteracao().toString().contains(IP_ALTERACAO_DEFAULT));
    }

    // HASH CODE

    @Test
    public void teste_117_deve_validar_hash_code_equivalentes() {
        assertEquals(this.funcionario.hashCode(), this.funcionario.hashCode());
    }

    @Test
    public void teste_118_deve_validar_hash_code_divergentes() {
        assertFalse(this.funcionario.hashCode() == this.funcionarioTestes.hashCode());
    }

    // EQUALS

    @Test
    public void teste_119_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.funcionario.equals(this.funcionario));
    }

    @Test
    public void teste_120_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.funcionario.equals(this.funcionarioTestes));
    }

    @Test
    public void teste_121_nao_deve_validar_equals_nulo() {
        assertFalse(this.funcionario.equals(null));
    }

    @Test
    public void teste_122_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.funcionario.equals(new Object()));
    }

    @Test
    public void teste_123_nao_deve_validar_equals_objetos_divergentes_cpf_divergente() {
        Funcionario f = new Funcionario("73128837023", empresa);
        assertFalse(this.funcionario.equals(f));
    }

    @Test
    public void teste_124_nao_deve_validar_equals_objetos_divergentes_empresa_divergente() {
        Funcionario f = new Funcionario(CPF_DEFAULT, new Empresa("46123716000187"));
        assertFalse(this.funcionario.equals(f));
    }

    @Test
    public void teste_125_deve_validar_equals_objetos_divergentes_campos_iguais() {
        Funcionario f = new Funcionario(CPF_DEFAULT, empresa);
        assertTrue(this.funcionario.equals(f));
    }

}
