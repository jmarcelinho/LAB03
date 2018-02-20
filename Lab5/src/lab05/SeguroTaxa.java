package lab05;

public class SeguroTaxa extends Tipo{
	private double taxa;
	private int id;
	public double valor;
	public SeguroTaxa(int id, double taxa, double valorAposta) {
		this.id = id;
		this.taxa = taxa;
		this.valor = (taxa * valorAposta);
	}
	
	/**
	 * Retorna uma representacao em string do tipo de seguro.
	 * @return representacao em string do tipo do seguro.
	 */
	public String toString() {
		return " - ASSEGURADA(TAXA) - " + (this.taxa*100) + "%";
	}
	
	/**
	 * Retorna o valor do seguro.
	 * @return valor do seguro
	 */
	public double getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna id do seguro
	 * @return id do seguro
	 */
	public int getId() {
		return this.id;
	}
}
