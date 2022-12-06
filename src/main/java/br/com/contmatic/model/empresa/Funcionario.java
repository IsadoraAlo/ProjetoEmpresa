package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_APOSENTADORIA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_CONTATO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_CPF_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_CPF_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_APOSENTADORIA_INTERVALO_LIMIAR;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_APOSENTADORIA_INTERVALO_ULTRAPASSADO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_APOSENTADORIA_MENOR_CONTRATACAO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_CONTRACAO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_CONTRATACAO_DATA_DEMISSAO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_CONTRATACAO_FUTURA_MAIOR_PERMITIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_CONTRATACAO_MENOR_NASCIMENTO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_DEMISSAO_INTERVALO_LIMIAR;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_DEMISSAO_INTERVALO_ULTRAPASSADO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_DEMISSAO_MENOR_CONTRATACAO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_DEMISSAO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_NASCIMENTO_DATA_CONTRATACAO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_NASCIMENTO_INTERVALO_LIMIAR;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_NASCIMENTO_INTERVALO_ULTRAPASSADO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_DATA_NASCIMENTO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_EMPRESA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ENDERECO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESCOLARIDADE_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESCOLARIDADE_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESCOLARIDADE_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESCOLARIDADE_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESTADO_CIVIL_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESTADO_CIVIL_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESTADO_CIVIL_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_ESTADO_CIVIL_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_COMPLETO_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_COMPLETO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_COMPLETO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_COMPLETO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_SOCIAL_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_SOCIAL_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_SOCIAL_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_NOME_SOCIAL_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_RG_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_RG_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_RG_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_SEXO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_APOSENTADORIA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_APOSENTADORIA_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_CONTRATACAO_FUTURA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_DEMISSAO_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_DEMISSAO_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_NASCIMENTO_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_DATA_NASCIMENTO_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_ESCOLARIDADE_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_ESCOLARIDADE_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_ESTADO_CIVIL_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_ESTADO_CIVIL_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;
import static br.com.contmatic.model.utils.validacao.Util.validarRg;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;
import static br.com.contmatic.model.utils.validacao.UtilCpf.validarCPF;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarDataFinalMenorInicial;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarIntervaloDiasEntreDatas;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarIntervaloMaxAnos;
import static br.com.contmatic.model.utils.validacao.UtilDate.validarIntervaloMinAnos;
import static java.time.LocalDate.now;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Contato;
import br.com.contmatic.model.endereco.Endereco;

public class Funcionario extends Auditoria {

    @NotNull(message = MSG_NOME_COMPLETO_NULO)
    @NotBlank(message = MSG_NOME_COMPLETO_BRANCO)
    @Size(message = MSG_NOME_COMPLETO_QTDE_CARACTERES, min = 10, max = 70)
    String nomeCompleto;

    @NotNull(message = MSG_NOME_SOCIAL_NULO)
    @NotBlank(message = MSG_NOME_SOCIAL_BRANCO)
    @Size(message = MSG_NOME_SOCIAL_QTDE_CARACTERES, min = 10, max = 70)
    String nomeSocial;

    @NotNull(message = MSG_SEXO_NULO)
    public enum sexoType{
  
        FEMININO("Feminino"),
        MASCULINO("Masculino"),
        INDEFINIDO("Indefinido");
        
        @NotNull(message = "A descrição do sexo é obrigátorio!")
        private String descricao;
        
        private sexoType(String descricao) {
            this.descricao = descricao;
        }
    }

    String estadoCivil;

    String escolaridade;

    String cpf;

    String rg;

    Contato contato;

    Endereco endereco;
    
    Empresa empresa;

    LocalDate dataNascimento;

    LocalDate dataContratacao;

    LocalDate dataDemissao;

    LocalDate dataAposentadoria;
    


    public Funcionario(String cpf, Empresa empresa) {
        setCpf(cpf);
        setEmpresa(empresa);
    }

    public Funcionario(String cpf, Empresa empresa, String nomeCompleto, LocalDate dataNascimento) {
        setCpf(cpf);
        setEmpresa(empresa);
        setNomeCompleto(nomeCompleto);
        setDataNascimento(dataNascimento);
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        validarTexto(nomeCompleto, MSG_NOME_COMPLETO_CARACTERES_INVALIDO);
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return this.nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        validarTexto(nomeSocial, MSG_NOME_SOCIAL_CARACTERES_INVALIDO);
        this.nomeSocial = nomeSocial;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        validarNulo(estadoCivil, MSG_ESTADO_CIVIL_NULO);
        validarEspacos(estadoCivil, MSG_ESTADO_CIVIL_BRANCO);
        validarQuantidadeCaracteresString(estadoCivil, TAMANHO_ESTADO_CIVIL_MAX, TAMANHO_ESTADO_CIVIL_MIN, MSG_ESTADO_CIVIL_QTDE_CARACTERES);
        validarTexto(estadoCivil, MSG_ESTADO_CIVIL_CARACTERES_INVALIDO);
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return this.escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        validarNulo(escolaridade, MSG_ESCOLARIDADE_NULO);
        validarEspacos(escolaridade, MSG_ESCOLARIDADE_BRANCO);
        validarQuantidadeCaracteresString(escolaridade, TAMANHO_ESCOLARIDADE_MAX, TAMANHO_ESCOLARIDADE_MIN, MSG_ESCOLARIDADE_QTDE_CARACTERES);
        validarTexto(escolaridade, MSG_ESCOLARIDADE_CARACTERES_INVALIDO);
        this.escolaridade = escolaridade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        validarNulo(cpf, MSG_CPF_NULO);
        validarEspacos(cpf, MSG_CPF_BRANCO);
        validarCPF(cpf);
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        validarNulo(rg, MSG_RG_NULO);
        validarEspacos(rg, MSG_RG_BRANCO);
        validarRg(rg, MSG_RG_INVALIDO);
        this.rg = rg;
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(Contato contato) {
        validarNulo(contato, MSG_CONTATO_NULO);
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        validarNulo(endereco, MSG_ENDERECO_NULO);
        this.endereco = endereco;
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        validarNulo(empresa, MSG_EMPRESA_NULO);
        this.empresa = empresa;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        validarNulo(dataNascimento, MSG_DATA_NASCIMENTO_NULO);
        validarIntervaloMinAnos(dataNascimento, TAMANHO_DATA_NASCIMENTO_MIN, MSG_DATA_NASCIMENTO_INTERVALO_LIMIAR);
        validarIntervaloMaxAnos(dataNascimento, TAMANHO_DATA_NASCIMENTO_MAX, MSG_DATA_NASCIMENTO_INTERVALO_ULTRAPASSADO);
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        validarNulo(dataContratacao, MSG_DATA_CONTRACAO_NULO);
        validarNulo(this.dataNascimento, MSG_DATA_NASCIMENTO_DATA_CONTRATACAO_NULO);
        validarDataFinalMenorInicial(dataContratacao, this.dataNascimento, MSG_DATA_CONTRATACAO_MENOR_NASCIMENTO);
        validarIntervaloDiasEntreDatas(now(), dataContratacao, TAMANHO_DATA_CONTRATACAO_FUTURA_MAX, MSG_DATA_CONTRATACAO_FUTURA_MAIOR_PERMITIDO);
        this.dataContratacao = dataContratacao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        validarNulo(dataDemissao, MSG_DATA_DEMISSAO_NULO);
        validarNulo(this.dataContratacao, MSG_DATA_CONTRATACAO_DATA_DEMISSAO_NULO);
        validarIntervaloMinAnos(dataDemissao, TAMANHO_DATA_DEMISSAO_MIN, MSG_DATA_DEMISSAO_INTERVALO_LIMIAR);
        validarIntervaloMaxAnos(dataDemissao, TAMANHO_DATA_DEMISSAO_MAX, MSG_DATA_DEMISSAO_INTERVALO_ULTRAPASSADO);
        validarDataFinalMenorInicial(dataDemissao, this.dataContratacao, MSG_DATA_DEMISSAO_MENOR_CONTRATACAO);
        this.dataDemissao = dataDemissao;
    }

    public LocalDate getDataAposentadoria() {
        return dataAposentadoria;
    }

    public void setDataAposentadoria(LocalDate dataAposentadoria) {
        validarNulo(dataAposentadoria, MSG_APOSENTADORIA_NULO);
        validarNulo(this.dataContratacao, MSG_DATA_CONTRATACAO_DATA_DEMISSAO_NULO);
        validarIntervaloMinAnos(dataAposentadoria, TAMANHO_DATA_APOSENTADORIA_MIN, MSG_DATA_APOSENTADORIA_INTERVALO_LIMIAR);
        validarIntervaloMaxAnos(dataAposentadoria, TAMANHO_DATA_APOSENTADORIA_MAX, MSG_DATA_APOSENTADORIA_INTERVALO_ULTRAPASSADO);
        validarDataFinalMenorInicial(dataAposentadoria, this.dataContratacao, MSG_DATA_APOSENTADORIA_MENOR_CONTRATACAO);
        this.dataAposentadoria = dataAposentadoria;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cpf).append(empresa).toHashCode();
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
        Funcionario other = (Funcionario) obj;
        return new EqualsBuilder().append(this.cpf, other.cpf).append(this.empresa, other.empresa).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
