package br.com.contmatic.model.utils.constantes.endereco;

public final class MunicipioConstantes {
	
	// NOME
		
	public static final String MSG_NOME_NULO = "Estado é obrigatório!";
		
	public static final String MSG_NOME_BRANCO = "Estado não pode estar em branco.";
		
	public static final String MSG_NOME_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Estado.";
		
	public static final String MSG_NOME_CARACTERES_INVALIDO = "Estado apenas aceita caracteres alfabéticos.";
		
	public static final Integer TAMANHO_NOME_MAX = 70;
		
	public static final Integer TAMANHO_NOME_MIN = 6;
		
	// CÓDIGO IBGE
		
	public static final String MSG_COD_IBGE_NULO = "Código Ibge é obrigatório!";
		
	public static final String MSG_COD_IBGE_BRANCO = "Código Ibge não pode estar em branco.";
		
	public static final String MSG_COD_IBGE_QTDE_CARACTERES = "A quantidade máxima de caracteres foi excedida em Código Ibge.";
		
	public static final String MSG_COD_IBGE_CARACTERES_INVALIDO = "Código Ibge apenas aceita caracteres numéricos.";
		
	public static final Integer TAMANHO_COD_IBGE_MAX = 7;
		
	public static final Integer TAMANHO_COD_IBGE_MIN = 7;
	
	// UF
	
	public static final String MSG_UF_NULO = "UF é obrigatório!";	

	private MunicipioConstantes() { } 
	
}
