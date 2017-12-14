package lab05;

public class Aposta {
	
	private String nomeApostador;
	private double valorAposta;
	private Previsao previsao;
	
	public Aposta(String nomeApostador, double valorAposta, Previsao previsao) {
		if(nomeApostador==null) throw new NullPointerException("NOME NULO");
		if(nomeApostador.trim().equals("")) throw new IllegalArgumentException("NOME INVALIDO");
		
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
