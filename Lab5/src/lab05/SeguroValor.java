package lab05;

public class SeguroValor extends Tipo{
	public double valor;	
	private int id;
	public SeguroValor(int id, int valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public String toString() {
		return " - ASSEGURADA(VALOR) - R$ " + this.valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public int getId() {
		return this.id;
	}
}
