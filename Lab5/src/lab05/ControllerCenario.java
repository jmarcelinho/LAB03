package lab05;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
	private List<Cenario> cenarios;
	
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
		if(cenario <= 0) 
			return 0;
		else if(cenario >cenarios.size()){
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
		int id = cenarios.size()+1;
		cenarios.add(new Cenario(id, descricao));
		return cenarios.size();
	}
	
	/**
	 * Cadastra um cenario com bonus no sistema.
	 * O cadastro eh feito a partir 
	 * de uma descricao e um valor bonus.
	 * E depois retorna a numeracao
	 * dada pelo sistema ao cenario.
	 * 
	 * @param descricao descricao do sistema.
	 * @return numeracao do sistema cadastrado.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		int id = cenarios.size()+1;
		cenarios.add(new CenarioBonus(id, descricao, bonus));
		return cenarios.size();
	}
	
	private Cenario buscaCenario(int numeracao) {
		Cenario cen = null;
		for(Cenario cenario: cenarios) {
			System.out.println(cenario.getNumeracao());
			if(cenario.getNumeracao() == numeracao) {
				cen =  cenario;
			}
		}
		return cen;
	}
	
	/**
	 * Retorna uma string representando um cenario
	 * pesquisado a partir da sua numeracao.
	 * 
	 * @param numeracao numeracao do cenario a ser exibido.
	 * @return representacao em string do cenario buscado.
	 */
	public String exibirCenario(int numeracao) {
		if(numeracao <= 0) 
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		else if(numeracao >cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return buscaCenario(numeracao).toString();
	}
	
	public String exibirCenarioOrdenado(int numeracao) {
		if(numeracao - 1 < 0)
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		else if(numeracao -1 >= cenarios.size())
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		return cenarios.get(numeracao - 1).toString();
			
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
		while(it.hasNext()){
			res+= it.next().toString() + "\n";
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
		if(cenario <= 0) 
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		else if(cenario >cenarios.size()){
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		Cenario cen = buscaCenario(cenario);
		if(ocorreu) {
			cen.fecharCenario(Estado.FINALIZADO_OCORREU);
			cen.setSomaPerdedoras(somaPerdedoras);
		}else {
			cen.fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
			cen.setSomaPerdedoras(somaPerdedoras);
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
		if(cenario <= 0) 
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		else if(cenario > cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		Cenario cen = buscaCenario(cenario);
		int soma_perdedoras = (int)cen.getSomaPerdedoras();
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
		if(cenario <= 0) 
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		else if(cenario >cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		Cenario cen = buscaCenario(cenario);
		int rateio = (int)cen.getSomaPerdedorasRateio();
		if(rateio==-1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return rateio;
	}
	
	/**
	 * Incrementa o numero de apostas no cenario
	 * @param cenario cenario que vai ser incrementado
	 */
	public void setNumeroAposta(int cenario) {
		Cenario cen = buscaCenario(cenario);
		cen.upNumeroAposta();
	}
	
	/**
	 * Altera a ordem no qual os cenarios sao ordenados.
	 * @param ordem informa em qual ordem os cenarios serao ordenados
	 */
	public void alterarOrdem(String ordem) {
		if(ordem == null || ordem.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		if(ordem.equals("nome")) {
			Collections.sort(cenarios, new OrdenaPorNome());
		}else if(ordem.equals("apostas")) {
			Collections.sort(cenarios, new OrdenaPorAposta());
		}else if(ordem.equals("cadastro")) {
			Collections.sort(cenarios);
		}else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}
}

