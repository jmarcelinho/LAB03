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
	private int cenario;
	private Tipo tipo;
	
	/**
	 * Constroi uma aposta utilizando o nome do apostador,
	 * o valor que foi apostado e a previsao (vai ou nao ocorrer).
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor apostado.
	 * @param previsao previsao da aposta.
	 */
	public Aposta(int cenario, String nomeApostador, double valorAposta, String previsao) {
		isValid(nomeApostador,valorAposta, previsao);
		if(previsao.equals("N VAI ACONTECER")) {
			this.previsao = Previsao.NAO_VAI_ACONTECER;
		}else if(previsao.equals("VAI ACONTECER")){
			this.previsao = Previsao.VAI_ACONTECER;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.cenario = cenario;
		this.tipo = null;
	}
	
	/**
	 * Constroi uma aposta assegurada por valor utilizando o nome do apostador,
	 * o valor que foi apostado e a previsao (vai ou nao ocorrer), valor do seguro
	 * e id dado pelo sistema a aposta.
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor apostado.
	 * @param previsao previsao da aposta.
	 * @param valor valor da aposta assegurada.
	 * @param id id dado pelo sistema a aposta assegurada.
	 */
	public Aposta(int cenario, String nomeApostador, double valorAposta, String previsao, int valor, int id) {
		isValidValor(nomeApostador,valorAposta, previsao);
		if(previsao.equals("N VAI ACONTECER")) {
			this.previsao = Previsao.NAO_VAI_ACONTECER;
		}else if(previsao.equals("VAI ACONTECER")){
			this.previsao = Previsao.VAI_ACONTECER;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.cenario = cenario;
		this.tipo = new SeguroValor(id, valor);
	}
	
	/**
	 * Constroi uma aposta assegurada por taxa utilizando o nome do apostador,
	 * o valor que foi apostado e a previsao (vai ou nao ocorrer), taxa do seguro
	 * e id dado pelo sistema a aposta.
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor apostado.
	 * @param previsao previsao da aposta.
	 * @param taxa taxa da aposta assegurada.
	 * @param id id dado pelo sistema a aposta assegurada.
	 */
	public Aposta(int cenario, String nomeApostador, double valorAposta, String previsao, double taxa, int id) {
		isValidTaxa(nomeApostador,valorAposta, previsao);
		if(previsao.equals("N VAI ACONTECER")) {
			this.previsao = Previsao.NAO_VAI_ACONTECER;
		}else if(previsao.equals("VAI ACONTECER")){
			this.previsao = Previsao.VAI_ACONTECER;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.cenario = cenario;
		this.tipo = new SeguroTaxa(id, taxa, valorAposta);
	}
	
	private void isValid(String nomeApostador, double valorAposta, String previsao) {
		if(nomeApostador==null) 
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		if(nomeApostador.trim().equals("")) 
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		if(valorAposta<=0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		if(previsao.trim().equals(""))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
	}
	
	private void isValidValor(String nomeApostador, double valorAposta, String previsao) {
		if(nomeApostador==null) 
			throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		if(nomeApostador.trim().equals("")) 
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		if(valorAposta<=0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		if(previsao.trim().equals(""))
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
	}
	
	private void isValidTaxa(String nomeApostador, double valorAposta, String previsao) {
		if(nomeApostador==null) 
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		if(nomeApostador.trim().equals("")) 
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		if(valorAposta<=0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		if(previsao.trim().equals(""))
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
	}
	

	/**
	 * Retorna um double representando o  valor da aposta.
	 * @return valor da aposta.
	 */
	public double getValor() {
		if(this.tipo==null) {
			return this.valorAposta;
		}
		return this.valorAposta;
	}
	
	public double getValorTipo() {
		if(tipo==null) return 0;
		return tipo.getValor();
	}
	
	/**
	 * Retorna um booleano que informa se a previsao
	 * da aposta vai acontecer ou nao vai acontecer.
	 * 
	 * @return true se for acontecer e nao caso contrario.
	 */
	public boolean getPrevisaoAposta() {
		if(this.previsao.getPrevisao().equals("N VAI ACONTECER"))
			return false;
		return true;
	}
	
	/**
	 * Retorna id do cenario em que a aposta est� cadastrada.
	 * @return id do cenario em que a aposta est� cadastrada.
	 */
	public int getCenario() {
		return this.cenario;
	}
	
	/**
	 * Retorna o id da aposta assegurada.
	 * @return id da aposta assegurada.
	 */
	public int getIdTipo() {
		if(tipo==null)
			return -1;
		return tipo.getId();
	}
	
	/**
	 * Altera uma aposta assegurada por taxa
	 * para uma aposta assegurada por valor
	 * @param valor valor a ser colocado na aposta.
	 * @return id da aposta assegurada.
	 */
	public int alteraTipoValor(int valor) {
		if(tipo==null)
			throw new IllegalArgumentException("tipo eh nulo");
		tipo = new SeguroValor(tipo.getId(), valor);
		return tipo.getId();
	}
	
	/**
	 * Altera uma aposta assegurada por valor
	 * para uma aposta assegurada por taxa
	 * @param taxa taxa a ser colocado na aposta.
	 * @return id da aposta assegurada.
	 */
	public int alteraTipoTaxa(double taxa) {
		if(tipo==null)
			throw new IllegalArgumentException("tipo eh nulo");
		tipo = new SeguroTaxa(tipo.getId(), taxa, this.valorAposta);
		return tipo.getId();
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
		if(tipo!=null)
			return this.nomeApostador + " - R$" + this.valorAposta + " - " + this.previsao.getPrevisao() + tipo.toString();
		return this.nomeApostador + " - R$" + this.valorAposta + " - " + this.previsao.getPrevisao();
	}
	
}
