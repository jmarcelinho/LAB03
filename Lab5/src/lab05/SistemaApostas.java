package lab05;

public class SistemaApostas {
	private int caixa;
	private double porcentagemRetirada;
	private ControllerCenario controleCenario;
	private ControllerAposta controleAposta;
	
	
	/**
	 * O sistema eh iniciado com um valor inicial em caixa
	 * e a porcentagem que deve ser retirada das apostas para o
	 * caixa.
	 * @param valorCaixa valor inicial do caixa.
	 * @param porcentagem porcentagem de retirada para o caixa.
	 */
	public SistemaApostas(int valorCaixa, double porcentagem) {
		if(valorCaixa<0) throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		if(porcentagem<0) throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		this.caixa = valorCaixa;
		this.porcentagemRetirada = porcentagem;
		this.controleCenario = new ControllerCenario();
		this.controleAposta = new ControllerAposta();
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
	 * Cadastra cenario no sistema a partir
	 * de uma descricao e retorna a numeracao
	 * dada pelo sistema ao cenario.
	 * @param descricao descricao do sistema.
	 * @return numeracao do sistema cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		return controleCenario.cadastrarCenario(descricao);
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
		int numero;
		numero = controleCenario.cadastrarCenario(descricao, bonus);
		this.caixa -= bonus;
		return numero;
	}
	
	/**
	 * Retorna uma string representando um cenario
	 * pesquisado a partir da sua numeracao.
	 * 
	 * @param numeracao numeracao do cenario a ser exibido.
	 * @return representacao em string do cenario buscado.
	 */
	public String exibirCenario(int numeracao) {
		return controleCenario.exibirCenario(numeracao);
	}
	
	/**
	 * Retorna uma string representando uma lista
	 * com a representacao de todos os cenarios 
	 * cadastrados no sistema.
	 * @return representacao em string de todos os cenarios
	 * cadastrados no sistema.
	 */
	public String exibirCenarios() {
		return controleCenario.exibirCenarios();
	}
	
	/**
	 * Cadastra apostas no cenario.
	 * Uma aposta eh cadastrada a partir do nome de um 
	 * apostador, o valor da aposta, previsao para aposta
	 *  e o numero do cenario.
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor da aposta.
	 * @param previsao previsao da aposta.
	 * @param cenario cenario qual vai ser cadastrada a aposta.
	 */
	public void cadastrarAposta(int cenario, String nomeApostador, double valorAposta, String previsao) {
		if(controleCenario.isValidCenario(cenario)==0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		else if(controleCenario.isValidCenario(cenario)==1)
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		controleAposta.cadastrarAposta(cenario, nomeApostador, valorAposta, previsao);
	}
	
	public int cadastrarAposta(int cenario, String nomeApostador, double valorAposta, String previsao, int valor, int custo) {
		if(controleCenario.isValidCenario(cenario)==0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		else if(controleCenario.isValidCenario(cenario)==1)
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		int ret = controleAposta.cadastrarAposta(cenario, nomeApostador, valorAposta, previsao, valor);
		this.caixa += custo;
		return ret;
	}
	
	public int cadastrarAposta(int cenario, String nomeApostador, double valorAposta, String previsao, double taxa, int custo) {
		if(controleCenario.isValidCenario(cenario)==0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		else if(controleCenario.isValidCenario(cenario)==1)
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		int ret = controleAposta.cadastrarAposta(cenario, nomeApostador, valorAposta, previsao, taxa);
		this.caixa += custo;
		return ret;
	}
	
	/**
	 * Retorna o valor total de apostas cadastradas
	 * em um cenario.
	 * @param cenario numero do cenario a ser consultado.
	 * @return valor inteiro de apostas cadastradas no cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		if(controleCenario.isValidCenario(cenario)==0) 
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		else if(controleCenario.isValidCenario(cenario)==1)
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		return controleAposta.valorApostas(cenario);
	}
	
	/**
	 * Retorna o numero total de apostas cadastradas
	 * em um cenario.
	 * @param cenario numero do cenario a ser consultado.
	 * @return numero de apostas cadastradas em um cenario.
	 */
	public int totalDeApostas(int cenario) {
		if(controleCenario.isValidCenario(cenario)==0) 
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		else if(controleCenario.isValidCenario(cenario)==1)
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		return this.controleAposta.numeroApostas(cenario);
	}
	
	/**
	 * Retorna as representacoes em string das 
	 * apostas cadastradas em um cenario.
	 * 
	 * @param cenario numero do cenario a ser consultado.
	 * @return representacoes em string das apostas no cenario.
	 */
	public String exibeApostas(int cenario) {
		return this.controleAposta.exibeApostas(cenario);
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
	public void fecharAposta(int cenario, boolean ocorreu) {
		int somaPerdedoras = controleAposta.getSomaPerdedoras(cenario, ocorreu);
		controleCenario.fecharCenario(cenario, ocorreu, somaPerdedoras);
		this.caixa += getCaixaCenario(cenario);
	}
	
	/**
	 * Retorna um inteiro representado o valor de um
	 * cenario finalizado, que sera
	 * adicionado ao caixa do sistema.
	 * @param cenario numeracao do cenario
	 * @return valor de um cenario que sera adicionado ao caixa do sistema.
	 */
	public int getCaixaCenario(int cenario) {
		int caixaCenario = this.controleCenario.getCaixaCenario(cenario);
		caixaCenario = (int) (caixaCenario * this.porcentagemRetirada);
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
		int rateio = this.controleCenario.getTotalRateio(cenario);
		return rateio - getCaixaCenario(cenario);
	}
	
	public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		this.controleAposta.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		this.controleAposta.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
}
