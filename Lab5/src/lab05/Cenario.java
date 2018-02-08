package lab05;

import java.util.ArrayList;
import java.util.Iterator;

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
	protected String descricao;
	protected Estado estado;
	protected double soma_ocorre;
	protected double soma_nao_ocorre;
	protected ArrayList <Aposta> apostas;
	
	/**
	 * Cria o cenario a partir de uma descricao.
	 * Inicialmente o cenario nao possui nenhuma aposta.
	 * 
	 * @param descricao descricao de um cenario.
	 */
	public Cenario(String descricao) {
		if(descricao==null) throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		if(descricao.trim().equals("")) throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		apostas = new ArrayList<>();
		this.soma_ocorre = 0;
		this.soma_nao_ocorre = 0;
	}
	
	/**
	 * Cadastra apostas no cenario.
	 * Uma aposta eh cadastrada a partir do nome de um 
	 * apostador, o valor da aposta e a previsao para aposta.
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor da aposta.
	 * @param previsao previsao da aposta.
	 */
	public void cadastrarAposta(String nomeApostador, int valorAposta, String previsao) {
		apostas.add(new Aposta(nomeApostador, valorAposta, previsao));
		if(previsao.equals("VAI ACONTECER")) {
			soma_ocorre += valorAposta;
		}else {
			soma_nao_ocorre += valorAposta;
		}
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
	 * Retorna a soma de todas as apostas perdedoras.
	 * @return soma das apostas perdedoras.
	 */
	public int getSomaPerdedoras() {
		if(this.estado.equals(Estado.NAO_FINALIZADO))
			return -1;
		if(this.estado.equals(Estado.FINALIZADO_OCORREU)) {
			return (int)soma_nao_ocorre;
		}
		return (int)soma_ocorre;
	}
	
	/**
	 * Retorna as representacoes em string das 
	 * apostas cadastradas no cenario.
	 * 
	 * @return representacoes em string das apostas no cenario.
	 */
	public String listarApostas() {
		Iterator <Aposta> it = apostas.iterator();
		String res = "";
		while(it.hasNext()){
			res+=it.next().toString() + "\n";
		}
		return res;
	}
	
	public int numeroApostas() {
		return apostas.size();
	}
	
	public int valorApostas() {
		return (int) (soma_ocorre + soma_nao_ocorre); 
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
		return descricao + " - " + estado.getEstado();
	}
}
