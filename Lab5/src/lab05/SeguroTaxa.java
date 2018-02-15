package lab05;

public class SeguroTaxa extends Tipo{
	private double taxa;
	private int id;
	public double valor;
	public SeguroTaxa(int id, double taxa, double valorAposta) {
		this.id = id;
		this.taxa = taxa;
		this.valor = valorAposta;
	}
	
	public String toString() {
		return " - ASSEGURADA(TAXA) - " + (this.taxa*100) + "%";
	}
	
	public double getValor() {
		return (this.taxa * this.valor);
	}
	public int getId() {
		return this.id;
	}
}
