package lab05;

/**
 * Representacao de uma aposta que pode ou nao ocorrer.
 * Uma aposta armazena o nome do apostador,
 * o valor apostado e a previsao (ocorre ou nao ocorre).
 * 
 * @author Joao Marcelo
 */
public class Aposta {
	
	private String nomeApostador;
	private double valorAposta;
	private Previsao previsao;
	
	/**
	 * Constroi uma aposta utilizando o nome do apostador,
	 * o valor que foi apostado e a previsao (vai ou nao ocorrer).
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor apostado.
	 * @param previsao previsao da aposta.
	 */
	public Aposta(String nomeApostador, double valorAposta, Previsao previsao) {
		if(nomeApostador==null) throw new NullPointerException("NOME NULO");
		if(nomeApostador.trim().equals("")) throw new IllegalArgumentException("NOME INVALIDO");
		
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}
	
	/**
	 * Retorna um double representando o  valor da aposta.
	 * @return valor da aposta.
	 */
	public double getValor() {
		return this.valorAposta;
	}
	
	/**
	 * Retorna a representacao em string 
	 * de uma aposta.
	 * A representacao segue o formato 
	 * nome do apostador - R$ valor da aposta - previsao(vai ocorrer ou nao vai ocorrer)
	 * 
	 * @return representacao em string da aposta.
	 */
	public String toString() {
		return this.nomeApostador + " - R$" + this.valorAposta + " - " + this.previsao;
	}
}
