package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_CNPJ_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_CNPJ_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_CONTATO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_ENDERECO_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_ENDERECO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_FUNCIONARIO_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_FUNCIONARIO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_ATIVA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_PRODUTO_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_PRODUTO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_ENDERECO_LISTA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_ENDERECO_LISTA_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_FUNCIONARIO_LISTA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_FUNCIONARIO_LISTA_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_NOME_FANTASIA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_NOME_FANTASIA_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_PRODUTO_LISTA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_PRODUTO_LISTA_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_RAZAO_SOCIAL_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.TAMANHO_RAZAO_SOCIAL_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeElementoLista;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static br.com.contmatic.model.utils.validacao.UtilCnpj.validarCNPJ;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Contato;
import br.com.contmatic.model.endereco.Endereco;

public class Empresa extends Auditoria {

    private String cnpj;

    private String nomeFantasia;

    private String razaoSocial;
    
    private Boolean ativa = true;

    private Contato contato;

    private List<Endereco> enderecos;

    private List<Funcionario> funcionarios;

    private List<Produto> produtos;
    
    public Empresa(String cnpj) {
        setCnpj(cnpj);
    }

    public Empresa(String cnpj, String nomeFantasia, String razaoSocial) {
        setCnpj(cnpj);
        setNomeFantasia(nomeFantasia);
        setRazaoSocial(razaoSocial);
    }

    public Empresa(String cnpj, String nomeFantasia, String razaoSocial, Contato contato, List<Endereco> enderecos, List<Funcionario> funcionarios, List<Produto> produtos) {
        setCnpj(cnpj);
        setNomeFantasia(nomeFantasia);
        setRazaoSocial(razaoSocial);
        setContato(contato);
        setEndereco(enderecos);
        setFuncionario(funcionarios);
        setProduto(produtos);
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        validarNulo(cnpj, MSG_CNPJ_NULO);
        validarEspacos(cnpj, MSG_CNPJ_BRANCO);
        validarCNPJ(cnpj);
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        validarNulo(nomeFantasia, MSG_NOME_FANTASIA_NULO);
        validarEspacos(nomeFantasia, MSG_NOME_FANTASIA_BRANCO);
        validarQuantidadeCaracteresString(nomeFantasia, TAMANHO_NOME_FANTASIA_MAX, TAMANHO_NOME_FANTASIA_MIN, MSG_NOME_FANTASIA_QTDE_CARACTERES);
        validarTexto(nomeFantasia, MSG_NOME_FANTASIA_CARACTERES_INVALIDO);
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        validarNulo(razaoSocial, MSG_RAZAO_SOCIAL_NULO);
        validarEspacos(razaoSocial, MSG_RAZAO_SOCIAL_BRANCO);
        validarQuantidadeCaracteresString(razaoSocial, TAMANHO_RAZAO_SOCIAL_MAX, TAMANHO_RAZAO_SOCIAL_MIN, MSG_RAZAO_SOCIAL_QTDE_CARACTERES);
        validarTexto(razaoSocial, MSG_RAZAO_SOCIAL_CARACTERES_INVALIDO);
        this.razaoSocial = razaoSocial;
    }
    
    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        validarNulo(ativa, MSG_ATIVA_NULO);
        this.ativa = ativa;
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(Contato contato) {
        validarNulo(contato, MSG_CONTATO_NULO);
        this.contato = contato;
    }

    public List<Endereco> getEndereco() {
        return this.enderecos;
    }

    public void setEndereco(List<Endereco> enderecos) {
        validarNulo(enderecos, MSG_ENDERECO_NULO);
        validarQuantidadeElementoLista(enderecos, TAMANHO_ENDERECO_LISTA_MAX, TAMANHO_ENDERECO_LISTA_MIN, MSG_ENDERECO_LISTA_EXCEDIDA);
        this.enderecos = enderecos;
    }

    public List<Funcionario> getFuncionario() {
        return this.funcionarios;
    }

    public void setFuncionario(List<Funcionario> funcionarios) {
        validarNulo(funcionarios, MSG_FUNCIONARIO_NULO);
        validarQuantidadeElementoLista(funcionarios, TAMANHO_FUNCIONARIO_LISTA_MAX, TAMANHO_FUNCIONARIO_LISTA_MIN, MSG_FUNCIONARIO_LISTA_EXCEDIDA);
        this.funcionarios = funcionarios;
    }

    public List<Produto> getProduto() {
        return this.produtos;
    }

    public void setProduto(List<Produto> produtos) {
        validarNulo(produtos, MSG_PRODUTO_NULO);
        validarQuantidadeElementoLista(produtos, TAMANHO_PRODUTO_LISTA_MAX, TAMANHO_PRODUTO_LISTA_MIN, MSG_PRODUTO_LISTA_EXCEDIDA);
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        return Objects.equals(cnpj, other.cnpj);
    }

    //TODO AUDITORIA
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Empresa [razaoSocial=").append(razaoSocial)
                .append(", nomeFantasia=").append(nomeFantasia)
                .append(", cnpj=").append(cnpj)
                .append(", ativa=").append(ativa)
                .append(", contato=").append(contato)
                .append(", endereco=").append(enderecos)
                .append(", funcionario=").append(funcionarios)
                .append(", produto=").append(produtos)
                .append("]")
                .toString();
    }

}
