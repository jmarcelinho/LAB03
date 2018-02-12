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
	
	/**
	 * Inicia o controller de cenario.
	 * O controller possui uma lista de cenarios cadastrados
	 * que inicialmente eh vazia.
	 */
	public ControllerCenario() {
		this.cenarios = new ArrayList<>();
	}

	
	/**
	 * Verifica se a numeracao do cenario eh valida.
	 * Um cenario valido eh o que sua numeracao esta 
	 * lista dos cenarios cadastrados.
	 * @param cenario numeracao de um cenario.
	 */
	public int isValidCenario(int cenario) {
		if(cenario-1 < 0) 
			return 0;
		else if(cenario-1 >=cenarios.size()){
			return 1;
		}
		return -1;
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
		if(numeracao-1 < 0) 
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		else if(numeracao-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		String res = numeracao + " - ";
		res +=cenarios.get(numeracao-1).toString();
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
	 * @return valor inteiro que deve ser adicionado ao caixa
	 * do sistema.
	 */
	public void fecharCenario(int cenario, boolean ocorreu, int somaPerdedoras) {
		if(cenario-1 < 0) 
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		else if(cenario-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if(ocorreu) {
			cenarios.get(cenario-1).fecharCenario(Estado.FINALIZADO_OCORREU);
			cenarios.get(cenario -1).setSomaPerdedoras(somaPerdedoras);
		}else {
			cenarios.get(cenario-1).fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
			cenarios.get(cenario -1).setSomaPerdedoras(somaPerdedoras);
		}
	}
	
	/**
	 * Retorna um inteiro representado o valor de um
	 * cenario finalizado, que sera
	 * adicionado ao caixa do sistema.
	 * @param cenario numeracao do cenario
	 * @return valor de um cenario que sera adicionado ao caixa do sistema.
	 */
	public int getCaixaCenario(int cenario) {
		if(cenario-1 < 0) 
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		else if(cenario-1 >= cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		int soma_perdedoras = (int)cenarios.get(cenario-1).getSomaPerdedoras();
		if(soma_perdedoras == -1)
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		return soma_perdedoras;
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
		if(cenario-1 < 0) 
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		else if(cenario-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		int rateio = (int)cenarios.get(cenario-1).getSomaPerdedoras();
		if(rateio==-1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return rateio;
	}
	
	
}

