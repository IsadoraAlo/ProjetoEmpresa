package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_ATIVA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_CNPJ_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_CNPJ_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_CONTATO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_ENDERECO_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_ENDERECO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_FUNCIONARIO_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_FUNCIONARIO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_NOME_FANTASIA_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_PRODUTO_LISTA_EXCEDIDA;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_PRODUTO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.EmpresaConstantes.MSG_RAZAO_SOCIAL_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static br.com.contmatic.model.utils.validacao.UtilCnpj.validarCNPJ;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Contato;
import br.com.contmatic.model.endereco.Endereco;

public class Empresa extends Auditoria {
    
    @NotNull(message = MSG_CNPJ_NULO)
    @NotBlank(message = MSG_CNPJ_BRANCO)
    private String cnpj;

    @NotNull(message = MSG_NOME_FANTASIA_NULO)
    @NotBlank(message = MSG_NOME_FANTASIA_BRANCO)
    @Size(message = MSG_NOME_FANTASIA_QTDE_CARACTERES, min = 6, max = 70)
    private String nomeFantasia;

    @NotNull(message = MSG_RAZAO_SOCIAL_NULO)
    @NotBlank(message = MSG_RAZAO_SOCIAL_BRANCO)
    @Size(message = MSG_RAZAO_SOCIAL_QTDE_CARACTERES, min = 10, max = 70)
    private String razaoSocial;

    @NotNull(message = MSG_ATIVA_NULO)
    private Boolean ativa = true;

    @NotNull(message = MSG_CONTATO_NULO)
    private Contato contato;

    @NotNull(message = MSG_ENDERECO_NULO)
    @Size(message = MSG_ENDERECO_LISTA_EXCEDIDA, min = 1, max = 2)
    private List<Endereco> enderecos;

    @NotNull(message = MSG_FUNCIONARIO_NULO)
    @Size(message = MSG_FUNCIONARIO_LISTA_EXCEDIDA, min = 1, max = 2)
    private List<Funcionario> funcionarios;

    @NotNull(message = MSG_PRODUTO_NULO)
    @Size(message = MSG_PRODUTO_LISTA_EXCEDIDA, min = 1, max = 2) 
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
        validarCNPJ(cnpj);
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        validarTexto(nomeFantasia, MSG_NOME_FANTASIA_CARACTERES_INVALIDO);
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        validarTexto(razaoSocial, MSG_RAZAO_SOCIAL_CARACTERES_INVALIDO);
        this.razaoSocial = razaoSocial;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Endereco> getEndereco() {
        return this.enderecos;
    }

    public void setEndereco(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Funcionario> getFuncionario() {
        return this.funcionarios;
    }

    public void setFuncionario(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Produto> getProduto() {
        return this.produtos;
    }

    public void setProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cnpj).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Empresa other = (Empresa) obj;
        return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
