package br.com.contmatic.model.testes.empresa;

import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.ESPACO_BRANCO;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_1;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_ALFABETICA_75;
import static br.com.contmatic.model.constantes.comuns.ConstantesComuns.STRING_CARACTERES_ESPECIAIS_10;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.ENDERECO_DEFAULT;
import static br.com.contmatic.model.constantes.contato.EmailTestConstantes.TIPO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.EmpresaTestConstantes.CNPJ_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.EmpresaTestConstantes.CNPJ_TESTES;
import static br.com.contmatic.model.constantes.empresa.EmpresaTestConstantes.NOME_FANTASIA_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.EmpresaTestConstantes.RAZAO_SOCIAL_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.CPF_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.FuncionarioTestConstantes.NUMERO_ENDERECO_DEFAULT;
import static br.com.contmatic.model.constantes.empresa.ProdutoTestConstantes.CODIGO_BARRA_DEFAULT;
import static br.com.contmatic.model.constantes.endereco.EnderecoTestConstantes.CEP_DEFAULT;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Contato;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.empresa.Produto;
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

        List<Email> emails = new ArrayList<Email>();
        emails.add(new Email(ENDERECO_DEFAULT, TIPO_DEFAULT));

        this.contato = new Contato(emails);

        this.enderecos = new ArrayList<Endereco>();
        this.enderecos.add(new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));

        this.funcionarios = new ArrayList<Funcionario>();
        this.funcionarios.add(new Funcionario(CPF_DEFAULT));

        this.produtos = new ArrayList<Produto>();
        this.produtos.add(new Produto(CODIGO_BARRA_DEFAULT));

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

    @Test(expected = IllegalStateException.class)
    public void teste_01_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("00000000000000");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_02_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("11111111111111");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_03_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("22222222222222");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_04_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("33333333333333");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_05_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("44444444444444");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_06_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("55555555555555");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_07_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("66666666666666");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_08_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("77777777777777");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_09_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("88888888888888");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_10_nao_deve_aceitar_repeticoes_9_cnpj() {
        this.empresa.setCnpj("99999999999999");
    }

    @Test(expected = IllegalStateException.class)
    public void teste_11_nao_deve_aceitar_cnpj_invalido() {
        this.empresa.setCnpj("18811495000100");
    }

    @Test
    public void teste_12_deve_validar_cnpj_com_sucesso() {
        assertEquals(CNPJ_DEFAULT, this.empresa.getCnpj());
    }
    
    // ENDEREÇOS
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_13_nao_deve_aceitar_lista_endereco_nulo() {
        this.empresa.setEndereco(null);
    }
    
    @Test
    public void teste_14_deve_validar_lista_endereco_com_sucesso() {
        assertEquals(this.enderecos, this.empresa.getEndereco());
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_15_lista_endereco_maior_que_permitido() {
        enderecos.add(1, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        enderecos.add(2, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        enderecos.add(3, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        enderecos.add(4, new Endereco(CEP_DEFAULT, NUMERO_ENDERECO_DEFAULT));
        empresa.setEndereco(enderecos);
    }
    
    // FUNCIONÁRIO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_16_nao_deve_aceitar_lista_funcionario_nulo() {
        this.empresa.setFuncionario(null);
    }
    
    @Test
    public void teste_17_deve_validar_lista_funcionario_com_sucesso() {
        assertEquals(this.funcionarios, this.empresa.getFuncionario());
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_18_lista_funcionario_maior_que_permitido() {
        funcionarios.add(1, new Funcionario(CPF_DEFAULT));
        funcionarios.add(2, new Funcionario(CPF_DEFAULT));
        funcionarios.add(3, new Funcionario(CPF_DEFAULT));
        funcionarios.add(4, new Funcionario(CPF_DEFAULT));
        empresa.setFuncionario(funcionarios);
    }
    
    // PRODUTO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_19_nao_deve_aceitar_lista_produto_nulo() {
        this.empresa.setProduto(null);
    }
    
    @Test
    public void teste_20_deve_validar_lista_produto_com_sucesso() {
        assertEquals(this.produtos, this.empresa.getProduto());
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_21_lista_produto_maior_que_permitido() {
        produtos.add(1, new Produto(CODIGO_BARRA_DEFAULT));
        produtos.add(2, new Produto(CODIGO_BARRA_DEFAULT));
        produtos.add(3, new Produto(CODIGO_BARRA_DEFAULT));
        produtos.add(4, new Produto(CODIGO_BARRA_DEFAULT));
        empresa.setProduto(produtos);
    }
    
    // CONTATO
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_22_nao_deve_aceitar_uf_nulo() {
        this.empresa.setContato(null);
    }

    @Test
    public void teste_23_deve_validar_uf_com_sucesso() {
        assertEquals(this.contato, this.empresa.getContato());
    }
    
    // RAZÃO SOCIAL

    @Test(expected = IllegalArgumentException.class)
    public void teste_24_nao_deve_aceitar_razao_social_nulo() {
        this.empresa.setRazaoSocial(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_25_nao_deve_aceitar_razao_social_em_branco() {
        this.empresa.setRazaoSocial(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_26_nao_deve_ultrapassar_qntd_caractere_max_razao_social() {
        this.empresa.setRazaoSocial(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_27_nao_deve_limiar_qntd_caractere_min_razao_social() {
        this.empresa.setRazaoSocial(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_28_nao_deve_aceitar_caracteres_invalidos_razao_social() {
        this.empresa.setRazaoSocial(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_29_deve_validar_razao_social_com_sucesso() {
        assertEquals(RAZAO_SOCIAL_DEFAULT, this.empresa.getRazaoSocial());
    }
    
    // NOME FANTASIA
    
    @Test(expected = IllegalArgumentException.class)
    public void teste_30_nao_deve_aceitar_nome_fantasia_nulo() {
        this.empresa.setNomeFantasia(null);
    }
  
    @Test(expected = IllegalStateException.class)
    public void teste_31_nao_deve_aceitar_nome_fantasia_em_branco() {
        this.empresa.setNomeFantasia(ESPACO_BRANCO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_32_nao_deve_ultrapassar_qntd_caractere_max_nome_fantasia() {
        this.empresa.setNomeFantasia(STRING_ALFABETICA_75);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_33_nao_deve_limiar_qntd_caractere_min_nome_fantasia() {
        this.empresa.setNomeFantasia(STRING_ALFABETICA_1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void teste_34_nao_deve_aceitar_caracteres_invalidos_nome_fantasia() {
        this.empresa.setNomeFantasia(STRING_CARACTERES_ESPECIAIS_10);
    }
    
    @Test
    public void teste_35_deve_validar_nome_fantasia_com_sucesso() {
        assertEquals(NOME_FANTASIA_DEFAULT, this.empresa.getNomeFantasia());
    }
}
