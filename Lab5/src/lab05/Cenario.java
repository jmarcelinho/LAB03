package lab05;



/**
 * Representa um cenario para uma aposta.
 * Um cenario eh algo que pode acontecer ou nao.
 * 
 * Cada cenario possui uma descricao e um estado
 * que informa se o cenario foi finalizado ou nao
 * e se finalizado se ocorreu ou nao ocorreu.
 * 
 * O cenario tambem possui uma lista de apostas
 * que foram feitas para tal cenario.
 * 
 * @author Joao Marcelo
 *
 */
public class Cenario {
	protected int numeracao;
	protected String descricao;
	protected Estado estado;
	protected double somaPerdedoras;
	
	/**
	 * Cria o cenario a partir de uma descricao.
	 * Inicialmente o cenario nao possui nenhuma aposta.
	 * 
	 * @param descricao descricao de um cenario.
	 */
	public Cenario(int id, String descricao) {
		if(descricao==null) throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		if(descricao.trim().equals("")) throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		this.numeracao = id;
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		this.somaPerdedoras = -1;
	}
	
	/**
	 * Fecha o cenario a partir da informacao se o mesmo
	 * ocorreu ou nao ocorreu.
	 * @param estado que informa se ocorreu ou nao ocorreu.
	 */
	public void fecharCenario(Estado e) {
		if(this.estado.equals(Estado.NAO_FINALIZADO)){
			this.estado = e;
		}else {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
	}
	
	/**
	 * Altera o valor das somas consideradas 
	 * perdedoras no cenário.
	 * @param soma soma das apostas perdedoras do cenario.
	 */
	public void setSomaPerdedoras(int soma) {
		this.somaPerdedoras = soma;
	}
	
	/**
	 * Retorna a soma dos valores das 
	 * apostas perdedoras do cenário.
	 * @return soma das apostas perdedoras do
	 * cenario.
	 */
	public double getSomaPerdedoras() {
		return this.somaPerdedoras;
	}
	
	/**
	 * Retorna o valor das apostas perdedoras para
	 * o calculo do rateio do cenário.
	 * @return soma das apostas perdedoras do cenario.
	 */
	public double getSomaPerdedorasRateio() {
		return this.somaPerdedoras;
	}
	
	/**
	 * Retorna o valor do estado do cenario.
	 * Se foi finalizado (ocorreu), nao finalizado
	 * e finalizado (nao ocorreu).
	 * @return estado do cenario.
	 */
	public Estado getEstadoCenario() {
		return this.estado;
	}
	
	/**
	 * Retorna a numeracao do cenario.
	 * @return numeracao do cenario.
	 */
	public int getNumeracao() {
		return this.numeracao;
	}
	
	/**
	 * Retorna uma string com 
	 * a descricao do cenario.
	 * @return descricao do cenario.
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Retorna uma representacao do cenario.
	 * A representacao do cenario eh no formato 
	 * descricao - estado (finalizado ou nao finalizado).
	 * 
	 * @return representacao em string do cenario.
	 */
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + estado.getEstado();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeracao;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cenario))
			return false;
		Cenario other = (Cenario) obj;
		if (numeracao != other.numeracao)
			return false;
		return true;
	}
	
	
}
