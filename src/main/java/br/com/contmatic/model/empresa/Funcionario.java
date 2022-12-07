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
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_SEXO_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_SEXO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_SEXO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.MSG_SEXO_QTDE_CARACTERES;
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
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_NOME_COMPLETO_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_NOME_COMPLETO_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_NOME_SOCIAL_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_NOME_SOCIAL_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_SEXO_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.FuncionarioConstantes.TAMANHO_SEXO_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasAlfabeticos;
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

import java.time.LocalDate;
import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Contato;
import br.com.contmatic.model.endereco.Endereco;

public class Funcionario extends Auditoria {

    String nomeCompleto;

    String nomeSocial;

    String sexo;

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

    public Funcionario(String cpf, Empresa empresa, String nomeCompleto, LocalDate dataNascimento, String sexo) {
        this(cpf, empresa);
        setNomeCompleto(nomeCompleto);
        setDataNascimento(dataNascimento);
        setSexo(sexo);
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        validarNulo(nomeCompleto, MSG_NOME_COMPLETO_NULO);
        validarEspacos(nomeCompleto, MSG_NOME_COMPLETO_BRANCO);
        validarQuantidadeCaracteresString(nomeCompleto, TAMANHO_NOME_COMPLETO_MAX, TAMANHO_NOME_COMPLETO_MIN, MSG_NOME_COMPLETO_QTDE_CARACTERES);
        validarTexto(nomeCompleto, MSG_NOME_COMPLETO_CARACTERES_INVALIDO);
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return this.nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        validarNulo(nomeSocial, MSG_NOME_SOCIAL_NULO);
        validarEspacos(nomeSocial, MSG_NOME_SOCIAL_BRANCO);
        validarQuantidadeCaracteresString(nomeSocial, TAMANHO_NOME_SOCIAL_MAX, TAMANHO_NOME_SOCIAL_MIN, MSG_NOME_SOCIAL_QTDE_CARACTERES);
        validarTexto(nomeSocial, MSG_NOME_SOCIAL_CARACTERES_INVALIDO);
        this.nomeSocial = nomeSocial;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        validarNulo(sexo, MSG_SEXO_NULO);
        validarEspacos(sexo, MSG_SEXO_BRANCO);
        validarQuantidadeCaracteresString(sexo, TAMANHO_SEXO_MAX, TAMANHO_SEXO_MIN, MSG_SEXO_QTDE_CARACTERES);
        validarApenasAlfabeticos(sexo, MSG_SEXO_CARACTERES_INVALIDO);
        this.sexo = sexo;
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
        return Objects.hash(cpf, empresa);
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
        return Objects.equals(cpf, other.cpf) && Objects.equals(empresa, other.empresa);
    }

    @Override
    public String toString() {
        super.toString();
        return new StringBuilder()
                .append("Funcionario [nomeCompleto=").append(nomeCompleto)
                .append(", nomeSocial=").append(nomeSocial)
                .append(", dataNascimento=").append(dataNascimento)
                .append(", dataContratacao=").append(dataContratacao)
                .append(", dataDemissao=").append(dataDemissao)
                .append(", dataAposentadoria=").append(dataAposentadoria)
                .append(", sexo=").append(sexo)
                .append(", estadoCivil=").append(estadoCivil)
                .append(", escolaridade=").append(escolaridade)
                .append(", cpf=").append(cpf)
                .append(", rg=").append(rg)
                .append(", contato=").append(contato)
                .append(", endereco=").append(endereco)
                .append("]")
                .toString();
    }

}
