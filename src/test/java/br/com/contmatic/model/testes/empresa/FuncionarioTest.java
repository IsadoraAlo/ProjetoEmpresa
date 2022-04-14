package br.com.contmatic.model.testes.empresa;

import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.DATA_100_ANOS_PASSADO;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.DATA_300_ANOS_FUTURO;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_NUMERICA_1;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_NUMERICA_20;
import static br.com.contmatic.model.constantes.contato.CelularTestConstantes.DDD_DEFAULT;
import static br.com.contmatic.model.constantes.contato.CelularTestConstantes.DDI_DEFAULT;
import static br.com.contmatic.model.constantes.contato.CelularTestConstantes.NUMERO_DEFAULT;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.ENDERECO_DEFAULT;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.TIPO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.CPF_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.CPF_TESTES;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.DATA_APOSENTADORIA_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.DATA_CONTRATACAO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.DATA_DEMISSAO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.DATA_NASCIMENTO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.ESCOLARIDADE_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.ESTADO_CIVIL_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.NOME_COMPLETO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.NOME_SOCIAL_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.NUMERO_ENDERECO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.RG_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.SEXO_FEMININO;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.BAIRRO_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.CEP_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.CODIGO_IBGE_MUNICIPIO_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.CODIGO_IBGE_UF_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.COMPLEMENTO_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.LOGRADOURO_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.NOME_MUNICIPIO_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.NOME_UF_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.SIGLA_UF_DEFAULT;
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
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.endereco.Municipio;
import br.com.contmatic.model.endereco.UF;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioTest {

	Funcionario funcionario;
	
	Funcionario funcionarioTestes;
	
	Endereco endereco;
	
	Contato contato;
	
	@BeforeClass
    public static void iniciar_classe() {
        System.out.println("Iniciando testes");
    }

    @Before
    public void iniciar_testes() {
        List<Email> emails = new ArrayList<Email>();
        emails.add(new Email(ENDERECO_DEFAULT, TIPO_DEFAULT));

        List<Celular> celulares = new ArrayList<Celular>();
        celulares.add(new Celular(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));

        List<Telefone> telefones = new ArrayList<Telefone>();
        telefones.add(new Telefone(NUMERO_DEFAULT,DDD_DEFAULT,DDI_DEFAULT));
        
        this.contato = new Contato(emails, telefones, celulares);
        
        UF uf = new UF(CODIGO_IBGE_UF_DEFAULT, NOME_UF_DEFAULT, SIGLA_UF_DEFAULT);
        
        Municipio municipio = new Municipio(CODIGO_IBGE_MUNICIPIO_DEFAULT, NOME_MUNICIPIO_DEFAULT, uf);
        
        this.endereco = new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT, BAIRRO_DEFAULT, municipio, LOGRADOURO_DEFAULT, COMPLEMENTO_DEFAULT);
        
        this.funcionario = new Funcionario(CPF_DEFAULT, NOME_COMPLETO_DEFAULT, DATA_NASCIMENTO_DEFAULT, SEXO_FEMININO);
        this.funcionarioTestes = new Funcionario(CPF_TESTES);
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
    
    @Test
    public void teste_06_deve_validar_nome_completo_com_sucesso() {
        assertEquals(NOME_COMPLETO_DEFAULT, this.funcionario.getNomeCompleto());
    }
    
    // NOME SOCIAL

    @Test(expected = IllegalArgumentException.class)
    public void teste_07_nao_deve_aceitar_nome_social_nulo() {
        this.funcionario.setNomeSocial(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_nome_social_em_branco() {
        this.funcionario.setNomeSocial(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_ultrapassar_qntd_caractere_max_nome_social() {
        this.funcionario.setNomeSocial(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_limiar_qntd_caractere_min_nome_social() {
        this.funcionario.setNomeSocial(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_caracteres_invalidos_nome_social() {
        this.funcionario.setNomeSocial(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_12_deve_validar_nome_social_com_sucesso() {
        this.funcionario.setNomeSocial(NOME_SOCIAL_DEFAULT);
        assertEquals(NOME_SOCIAL_DEFAULT, this.funcionario.getNomeSocial());
    }
    
    // ESTADO CIVIL

    @Test(expected = IllegalArgumentException.class)
    public void teste_13_nao_deve_aceitar_estado_civil_nulo() {
        this.funcionario.setEstadoCivil(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_14_nao_deve_aceitar_estado_civil_em_branco() {
        this.funcionario.setEstadoCivil(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_15_nao_deve_ultrapassar_qntd_caractere_max_estado_civil() {
        this.funcionario.setEstadoCivil(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_16_nao_deve_limiar_qntd_caractere_min_estado_civil() {
        this.funcionario.setEstadoCivil(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_17_nao_deve_aceitar_caracteres_invalidos_estado_civil() {
        this.funcionario.setEstadoCivil(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_18_deve_validar_estado_civil_com_sucesso() {
        this.funcionario.setEstadoCivil(ESTADO_CIVIL_DEFAULT);
        assertEquals(ESTADO_CIVIL_DEFAULT, this.funcionario.getEstadoCivil());
    }
    
    // ESCOLARIDADE

    @Test(expected = IllegalArgumentException.class)
    public void teste_19_nao_deve_aceitar_escolaridade_nulo() {
        this.funcionario.setEscolaridade(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_20_nao_deve_aceitar_escolaridade_em_branco() {
        this.funcionario.setEscolaridade(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_21_nao_deve_ultrapassar_qntd_caractere_max_escolaridade() {
        this.funcionario.setEscolaridade(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_22_nao_deve_limiar_qntd_caractere_min_escolaridade() {
        this.funcionario.setEscolaridade(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_23_nao_deve_aceitar_caracteres_invalidos_escolaridade() {
        this.funcionario.setEscolaridade(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_24_deve_validar_escolaridade_com_sucesso() {
        this.funcionario.setEscolaridade(ESCOLARIDADE_DEFAULT);
        assertEquals(ESCOLARIDADE_DEFAULT, this.funcionario.getEscolaridade());
    }
    
    // RG

    @Test(expected = IllegalArgumentException.class)
    public void teste_25_nao_deve_aceitar_rg_nulo() {
        this.funcionario.setRg(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_26_nao_deve_aceitar_rg_em_branco() {
        this.funcionario.setRg(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_27_nao_deve_ultrapassar_qntd_caractere_max_rg() {
        this.funcionario.setRg(STRING_NUMERICA_20);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_28_nao_deve_limiar_qntd_caractere_min_rg() {
        this.funcionario.setRg(STRING_NUMERICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_29_nao_deve_aceitar_caracteres_invalidos_rg() {
        this.funcionario.setRg(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_30_deve_validar_rg_com_sucesso() {
        this.funcionario.setRg(RG_DEFAULT);
        assertEquals(RG_DEFAULT, this.funcionario.getRg());
    }
    
    // SEXO

    @Test(expected = IllegalArgumentException.class)
    public void teste_31_nao_deve_aceitar_sexo_nulo() {
        this.funcionario.setSexo(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_32_nao_deve_aceitar_sexo_em_branco() {
        this.funcionario.setSexo(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_33_nao_deve_ultrapassar_qntd_caractere_max_sexo() {
        this.funcionario.setSexo(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_34_nao_deve_limiar_qntd_caractere_min_sexo() {
        this.funcionario.setSexo("");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_35_nao_deve_aceitar_caracteres_invalidos_sexo() {
        this.funcionario.setSexo(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_36_deve_validar_sexo_com_sucesso() {
        assertEquals(SEXO_FEMININO, this.funcionario.getSexo());
    }
    
    // ENDEREÇO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_37_nao_deve_aceitar_endereco_nulo() {
        this.funcionario.setEndereco(null);
    }

    @Test
    public void teste_38_deve_validar_endereco_com_sucesso() {
        this.funcionario.setEndereco(this.endereco);
        assertEquals(this.endereco, this.funcionario.getEndereco());
    }
    
    // CONTATO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_39_nao_deve_aceitar_contato_nulo() {
        this.funcionario.setContato(null);
    }

    @Test
    public void teste_40_deve_validar_contato_com_sucesso() {
        this.funcionario.setContato(this.contato);
        assertEquals(this.contato, this.funcionario.getContato());
    }
    
    // DATA NASCIMENTO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_41_nao_deve_aceitar_data_nascimento_nulo() {
        this.funcionario.setDataNascimento(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_42_nao_deve_aceitar_data_nascimento_muito_futura() {
        this.funcionario.setDataNascimento(DATA_300_ANOS_FUTURO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_43_nao_deve_aceitar_data_nascimento_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_100_ANOS_PASSADO);
    }
    
    @Test
    public void teste_44_deve_validar_data_nascimento_com_sucesso() {
        assertEquals(DATA_NASCIMENTO_DEFAULT, this.funcionario.getDataNascimento());
    }
    
    // DATA CONTRATAÇÃO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_45_nao_deve_aceitar_data_contratacao_nulo() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_46_nao_deve_aceitar_data_contratacao_muito_futura() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_300_ANOS_FUTURO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_47_nao_deve_aceitar_data_contratacao_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_100_ANOS_PASSADO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_48_nao_deve_validar_data_contratacao_menor_data_nascimento() {
        this.funcionario.setDataNascimento(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_NASCIMENTO_DEFAULT);
    }
    
    @Test
    public void teste_49_deve_validar_data_contratacao_com_sucesso() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        assertEquals(DATA_CONTRATACAO_DEFAULT, this.funcionario.getDataContratacao());
    }

    // DATA DEMISSÃO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_50_nao_deve_aceitar_data_demissao_nulo() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_51_nao_deve_aceitar_data_demissao_muito_futura() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_300_ANOS_FUTURO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_52_nao_deve_aceitar_data_demissao_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_100_ANOS_PASSADO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_53_nao_deve_validar_data_demissao_menor_data_contratacao() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_DEMISSAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_CONTRATACAO_DEFAULT);
    }
    
    @Test
    public void teste_54_deve_validar_data_demissao_com_sucesso() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_DEMISSAO_DEFAULT);
        assertEquals(DATA_DEMISSAO_DEFAULT, this.funcionario.getDataDemissao());
    }
    
    // DATA APOSENTADORIA
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_50_nao_deve_aceitar_data_aposentadoria_nulo() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataDemissao(DATA_DEMISSAO_DEFAULT);
        this.funcionario.setDataAposentadoria(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_51_nao_deve_aceitar_data_aposentadoria_muito_futura() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_300_ANOS_FUTURO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_52_nao_deve_aceitar_data_aposentadoria_ultrapassada() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_100_ANOS_PASSADO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_53_nao_deve_validar_data_aposentadoria_menor_data_contratacao() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_APOSENTADORIA_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_CONTRATACAO_DEFAULT);
    }
    
    @Test
    public void teste_54_deve_validar_data_aposentadoria_com_sucesso() {
        this.funcionario.setDataNascimento(DATA_NASCIMENTO_DEFAULT);
        this.funcionario.setDataContratacao(DATA_CONTRATACAO_DEFAULT);
        this.funcionario.setDataAposentadoria(DATA_APOSENTADORIA_DEFAULT);
        assertEquals(DATA_APOSENTADORIA_DEFAULT, this.funcionario.getDataAposentadoria());
    }
    
    // CPF

    @Test(expected = IllegalArgumentException.class)
    public void teste_55_nao_deve_aceitar_cpf_nulo() {
        this.funcionario.setCpf(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_56_nao_deve_aceitar_cpf_em_branco() {
        this.funcionario.setCpf(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_57_nao_deve_ultrapassar_qntd_caractere_max_cpf() {
        this.funcionario.setCpf(STRING_NUMERICA_20);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_58_nao_deve_limiar_qntd_caractere_min_cpf() {
        this.funcionario.setCpf(STRING_NUMERICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_59_nao_deve_aceitar_caracteres_invalidos_cpf() {
        this.funcionario.setCpf(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_60_nao_deve_aceitar_repeticoes_0_cpf() {
        this.funcionario.setCpf("00000000000");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_61_nao_deve_aceitar_repeticoes_1_cpf() {
        this.funcionario.setCpf("11111111111");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_62_nao_deve_aceitar_repeticoes_2_cpf() {
        this.funcionario.setCpf("22222222222");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_63_nao_deve_aceitar_repeticoes_3_cpf() {
        this.funcionario.setCpf("33333333333");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_64_nao_deve_aceitar_repeticoes_4_cpf() {
        this.funcionario.setCpf("44444444444");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_65_nao_deve_aceitar_repeticoes_5_cpf() {
        this.funcionario.setCpf("55555555555");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_66_nao_deve_aceitar_repeticoes_6_cpf() {
        this.funcionario.setCpf("66666666666");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_67_nao_deve_aceitar_repeticoes_7_cpf() {
        this.funcionario.setCpf("77777777777");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_68_nao_deve_aceitar_repeticoes_8_cpf() {
        this.funcionario.setCpf("88888888888");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_69_nao_deve_aceitar_repeticoes_9_cpf() {
        this.funcionario.setCpf("99999999999");
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_70_nao_deve_aceitar_cpf_invalido() {
        this.funcionario.setCpf("92929499011");
    }
    
    @Test
    public void teste_71_deve_validar_cpf_com_sucesso() {
        assertEquals(CPF_DEFAULT, this.funcionario.getCpf());
    }
    
// TO STRING
    
    @Test
    public void teste_54_deve_validar_to_string() {
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
    }
    
    // HASH CODE
    
    @Test
    public void teste_55_deve_validar_hash_code_equivalentes() {
        assertEquals(this.funcionario.hashCode(), this.funcionario.hashCode());
    }
    
    @Test
    public void teste_56_deve_validar_hash_code_divergentes() {
        assertFalse(this.funcionario.hashCode() == this.funcionarioTestes.hashCode());
    }
    
    // EQUALS
    
    @Test
    public void teste_57_deve_validar_equals_com_campos_equivalentes() {
        assertTrue(this.funcionario.equals(this.funcionario));
    }

    @Test
    public void teste_58_nao_deve_validar_equals_com_campos_divergentes() {
        assertFalse(this.funcionario.equals(this.funcionarioTestes));
    }

    @Test
    public void teste_59_nao_deve_validar_equals_nulo() {
        assertFalse(this.funcionario.equals(null));
    }

    @Test
    public void teste_60_nao_deve_validar_equals_com_classes_divergentes() {
        assertFalse(this.funcionario.equals(new Object()));
    }
    
}
