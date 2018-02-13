package lab05;

import easyaccept.EasyAccept;

public class Facade {
	private SistemaApostas sistema;
	
	public Facade() {
		//sistema = new SistemaApostas(100000, 0.01);
	}
	
	public static void main(String[] args) {
		args = new String[] {"lab05.Facade", "acceptance_test/us1_test.txt", 
				"acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt",
				"acceptance_test/us4_test.txt",
				"acceptance_test/us5_test.txt"};
		EasyAccept.main(args);
	}
	public void inicializa(int caixa, double porcentagem) {
		this.sistema = new SistemaApostas(caixa, porcentagem);
	}
	
	public int getCaixa() {
		return this.sistema.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.sistema.cadastrarCenario(descricao);
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		return this.sistema.cadastrarCenario(descricao, bonus);
	}
	
	public String exibirCenario(int numeracao) {
		return this.sistema.exibirCenario(numeracao);
	}
	
	public String exibirCenarios() {
		return this.sistema.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateio(cenario);
	}
}
