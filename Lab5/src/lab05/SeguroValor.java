package lab05;

public class SeguroValor extends Tipo{
	public double valor;	
	private int id;
	public SeguroValor(int id, int valor) {
		this.id = id;
		this.valor = valor;
	}
	
	/**
	 * Retorna o tipo do seguro e o valor do seguro
	 * @return representacao do tipo do seguro e o valor do seguro
	 */
	public String toString() {
		return " - ASSEGURADA(VALOR) - R$ " + this.valor;
	}
	
	/**
	 * Retorna o valor do seguro.
	 * @return valor do seguro.
	 */
	public double getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna id do seguro.
	 * @return id do seguro
	 */
	public int getId() {
		return this.id;
	}
}
