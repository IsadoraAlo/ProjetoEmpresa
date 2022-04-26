package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_CODIGO_BARRA_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_CODIGO_BARRA_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_CODIGO_BARRA_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_CODIGO_BARRA_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_DESCRICAO_BRANCO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_DESCRICAO_CARACTERES_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_DESCRICAO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_DESCRICAO_QTDE_CARACTERES;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_PRECO_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_PRECO_VALOR_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_QUANTIDADE_NULO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.MSG_QUANTIDADE_VALOR_INVALIDO;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_CODIGO_BARRA_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_CODIGO_BARRA_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_DESCRICAO_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_DESCRICAO_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_PRECO_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_PRECO_MIN;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_QUANTIDADE_MAX;
import static br.com.contmatic.model.utils.constantes.empresa.ProdutoConstantes.TAMANHO_QUANTIDADE_MIN;
import static br.com.contmatic.model.utils.validacao.Util.validarApenasAlfanumericos;
import static br.com.contmatic.model.utils.validacao.Util.validarEspacos;
import static br.com.contmatic.model.utils.validacao.Util.validarNulo;
import static br.com.contmatic.model.utils.validacao.Util.validarQuantidadeCaracteresString;
import static br.com.contmatic.model.utils.validacao.Util.limitarQuantidadeNumericaMaximaMinima;
import static br.com.contmatic.model.utils.validacao.Util.validarTexto;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;

public class Produto extends Auditoria {

    BigDecimal preco;

    String codigoBarra;

    Integer quantidade;

    String descricao;

    public Produto(String codigoBarra) {
        setCodigoBarra(codigoBarra);
    }

    public Produto(String codigoBarra, BigDecimal preco, Integer quantidade, String descricao) {
        super();
        setPreco(preco);
        setCodigoBarra(codigoBarra);
        setQuantidade(quantidade);
        setDescricao(descricao);
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        validarNulo(preco, MSG_PRECO_NULO);
        limitarQuantidadeNumericaMaximaMinima(preco, TAMANHO_PRECO_MAX, TAMANHO_PRECO_MIN, MSG_PRECO_VALOR_INVALIDO);
        this.preco = preco;
    }

    public String getCodigoBarra() {
        return this.codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        validarNulo(codigoBarra, MSG_CODIGO_BARRA_NULO);
        validarEspacos(codigoBarra, MSG_CODIGO_BARRA_BRANCO);
        validarQuantidadeCaracteresString(codigoBarra, TAMANHO_CODIGO_BARRA_MAX, TAMANHO_CODIGO_BARRA_MIN, MSG_CODIGO_BARRA_QTDE_CARACTERES);
        validarApenasAlfanumericos(codigoBarra, MSG_CODIGO_BARRA_CARACTERES_INVALIDO);
        this.codigoBarra = codigoBarra;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        validarNulo(quantidade, MSG_QUANTIDADE_NULO);
        limitarQuantidadeNumericaMaximaMinima(quantidade, TAMANHO_QUANTIDADE_MAX, TAMANHO_QUANTIDADE_MIN, MSG_QUANTIDADE_VALOR_INVALIDO);
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        validarNulo(descricao, MSG_DESCRICAO_NULO);
        validarEspacos(descricao, MSG_DESCRICAO_BRANCO);
        validarQuantidadeCaracteresString(descricao, TAMANHO_DESCRICAO_MAX, TAMANHO_DESCRICAO_MIN, MSG_DESCRICAO_QTDE_CARACTERES);
        validarTexto(descricao, MSG_DESCRICAO_CARACTERES_INVALIDO);
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarra);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        return Objects.equals(codigoBarra, other.codigoBarra);
    }

    @Override
    public String toString() {
        super.toString();
        return new StringBuilder()
                .append("Produto [preco=").append(preco)
                .append(", codigoBarra=").append(codigoBarra)
                .append(", quantidade=").append(quantidade)
                .append(", descricao=").append(descricao)
                .append("]")
                .toString();                
    }

}
