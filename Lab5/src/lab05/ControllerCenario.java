package lab05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Controle de cenarios em um sistema de aposta.
 * O controle possui uma lista de cenarios no sistema,
 * o valor em caixa e uma porcentagem de quanto deve 
 * ser retirado para o caixa. 
 * @author Joao Marcelo
 *
 */
public class ControllerCenario {
	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double porcentagemRetirada;
	
	/**
	 * O sistema eh iniciado com um valor inicial em caixa
	 * e a porcentagem que deve ser retirada das apostas para o
	 * caixa.
	 * @param valorCaixa valor inicial do caixa.
	 * @param porcentagem porcentagem de retirada para o caixa.
	 */
	public ControllerCenario(int valorCaixa, double porcentagem) {
		if(valorCaixa<=0) throw new IllegalArgumentException("Valor de caixa invalido");
		if(porcentagem<=0) throw new IllegalArgumentException("Porcentagem invalida");
		this.cenarios = new ArrayList<>();
		this.caixa = valorCaixa;
		this.porcentagemRetirada = porcentagem;
	}
	
	/**
	 * Retorna um inteiro representando 
	 * o valor em caixa do sistema.
	 * @return o valor em caixa do sistema.
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Verifica se a numeracao do cenario eh valida.
	 * Um cenario valido eh o que sua numeracao esta 
	 * lista dos cenarios cadastrados.
	 * @param cenario numeracao de um cenario.
	 */
	private void isValid(int cenario) {
		if(cenario < 0 || cenario>=cenarios.size()) 
			throw new IllegalArgumentException("Cenario Invalido");
	}
	
	/**
	 * Cadastra cenario no sistema a partir
	 * de uma descricao e retorna a numeracao
	 * dada pelo sistema ao cenario.
	 * @param descricao descricao do sistema.
	 * @return numeracao do sistema cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		cenarios.add(new Cenario(descricao));
		return cenarios.size();
	}
	
	/**
	 * Retorna uma string representando um cenario
	 * pesquisado a partir da sua numeracao.
	 * 
	 * @param numeracao numeracao do cenario a ser exibido.
	 * @return representacao em string do cenario buscado.
	 */
	public String exibirCenario(int numeracao) {
		isValid(--numeracao);
		String res = numeracao+1 + " - ";
		res +=cenarios.get(numeracao).toString();
		return res;
	}
	
	/**
	 * Retorna uma string representando uma lista
	 * com a representacao de todos os cenarios 
	 * cadastrados no sistema.
	 * @return representacao em string de todos os cenarios
	 * cadastrados no sistema.
	 */
	public String exibirCenarios() {
		Iterator <Cenario> it = cenarios.iterator();
		String res = "";
		int index = 1;
		while(it.hasNext()){
			res+= index++ + " - " + it.next().toString() + "\n";
		}
		return res;
	}
	
	/**
	 * Fecha um cenario a partir da sua numeracao e 
	 * a informacao se ele ocorreu ou nao.
	 * A informacao se ocorreu ou nao ocorreu eh dada
	 * a partir de um boolean que eh True se ocorreu
	 * e False caso contrario.
	 * 
	 * @param cenario inteiro que representa a
	 * numeracao do cenario a ser fechado.
	 * 
	 * @param ocorreu informacao se o cenario ocorreu ou nao.
	 */
	public void fecharCenario(int cenario, boolean ocorreu) {
		isValid(--cenario);
		if(ocorreu) {
			cenarios.get(cenario).fecharCenario(Estado.FINALIZADO_OCORREU);
		}else {
			cenarios.get(cenario).fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
		}
		this.caixa += getCaixaCenario(cenario+1)*100;
	}
	
	/**
	 * Retorna um inteiro representado o valor de um
	 * cenario finalizado, que sera
	 * adicionado ao caixa do sistema.
	 * @param cenario numeracao do cenario
	 * @return valor de um cenario que sera adicionado ao caixa do sistema.
	 */
	public int getCaixaCenario(int cenario) {
		isValid(--cenario);
		double soma_perdedoras;
		soma_perdedoras = cenarios.get(cenario).getSomaPerdedoras();
		int caixaCenario = (int) (soma_perdedoras * this.porcentagemRetirada);
		//caixaCenario*=100;
		return caixaCenario;
	}
	
	/**
	 * Retorna o valor total das apostas do cenario que sera 
	 * rateado entre as apostas vencedoras do cenario.
	 * 
	 * @param cenario numeracao do cenario. 
	 * 
	 * @return inteiro representado o valor a ser rateado 
	 * entre as apostas vencedoras.
	 * 
	 */
	public int getTotalRateio(int cenario) {
		isValid(--cenario);
		int rateio = (int) cenarios.get(cenario).getSomaPerdedoras();
		rateio -= getCaixaCenario(cenario+1);
		return rateio;
	}
	/**
	 * Retorna representacao em string de todas 
	 * as apostas cadastradas em um cenario.
	 * Para exibir as apostas eh necessario passar
	 * um inteiro que representa um cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return representacao em string das apostas cadastradas
	 * em um cenario.
	 */
	public String exibeApostas(int cenario) {
		isValid(--cenario);
		return cenarios.get(cenario).listarApostas();
	}
	
	/**
	 * Cadastra apostas em um determinado cenario.
	 * Eh necessario que seja informado um inteiro 
	 * que representa o cenario no qual a aposta deve ser
	 * cadastrada.
	 * @param cenario inteiro que representa um cenario.
	 * @param apostador nome do apostador.
	 * @param valor valor da aposta.
	 * @param previsao previsao para aposta(ocorre ou nao ocorre).
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, Previsao previsao) {
		isValid(--cenario);
		cenarios.get(cenario).cadastrarApostas(apostador, valor, previsao);
	}
	
	/**
	 * Retorna o numero de apostas de um determinado cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return numero de apostas em um cenario.
	 */
	public int totalDeApostas(int cenario) {
		isValid(--cenario);
		return cenarios.get(cenario).numeroApostas();
	}
	
	/**
	 * Retorna o valor total de apostas de um
	 * determinado cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return valor total de apostas em um cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		isValid(--cenario);
		return cenarios.get(cenario).valorApostas();
	}
}








