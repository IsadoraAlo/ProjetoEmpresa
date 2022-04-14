package br.com.contmatic.model.utils.constantes.empresa;

public final class ProdutoConstantes {
	
	// PREÇO

	public static final String MSG_PRECO_NULO = "Preço é obrigatório!";
	
	public static final String MSG_PRECO_VALOR_INVALIDO = "O valor inserido não é válido em Preço";
	
	public static final Float TAMANHO_PRECO_MAX = 9999.99f;
	
	public static final Float TAMANHO_PRECO_MIN = 0.01f;
	
	// CÓDIGO DE BARRA
	
	public static final String MSG_CODIGO_BARRA_NULO = "Código de barras é obrigatório!";
	
	public static final String MSG_CODIGO_BARRA_BRANCO = "Código de barras não pode estar em branco.";
	
	public static final String MSG_CODIGO_BARRA_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Código de barras.";
	
	public static final String MSG_CODIGO_BARRA_CARACTERES_INVALIDO = "Código de barras apenas aceita caracteres alfanuméricos.";
	
	public static final Integer TAMANHO_CODIGO_BARRA_MAX = 20;
	
	public static final Integer TAMANHO_CODIGO_BARRA_MIN = 10;
	
	// QUANTIDADE
	
	public static final String MSG_QUANTIDADE_NULO = "Quantidade é obrigatório!";
	
	public static final String MSG_QUANTIDADE_VALOR_INVALIDO = "O valor inserido não é válido em Quantidade.";
	
	public static final Integer TAMANHO_QUANTIDADE_MAX = 9999;
	
	public static final Integer TAMANHO_QUANTIDADE_MIN = 0;
	
	// DESCRIÇÃO
	
	public static final String MSG_DESCRICAO_NULO = "Descrição é obrigatório!";
		
	public static final String MSG_DESCRICAO_BRANCO = "Descrição não pode estar em branco.";
		
	public static final String MSG_DESCRICAO_QTDE_CARACTERES = "A quantidade de caracteres foi excedida em Descrição.";
		
	public static final String MSG_DESCRICAO_CARACTERES_INVALIDO = "Descrição possuí caracteres inválidos.";
		
	public static final Integer TAMANHO_DESCRICAO_MAX = 70;
		
	public static final Integer TAMANHO_DESCRICAO_MIN = 10;
	
	private ProdutoConstantes() {	}
	
}
