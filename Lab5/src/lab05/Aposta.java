package lab05;

public class Aposta {
	
	private String nomeApostador;
	private double valorAposta;
	private String previsao;
	
	public Aposta(String nomeApostador, double valorAposta, String previsao) {
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}
	
	public double getValor() {
		return this.valorAposta;
	}
	
	public String toString() {
		return this.nomeApostador + " - R$" + this.valorAposta + " - " + this.previsao;
	}
}
