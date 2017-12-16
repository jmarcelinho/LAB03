package lab05;

import easyaccept.EasyAccept;

public class Facade {
	private ControllerCenario controleCenarios;
	
	public Facade() {
	}
	
	public static void main(String[] args) {
		args = new String[] {"Facade", "accptance_test/us1_test.txt"};
		EasyAccept.main(args);
	}
	public void inicializaSistema(int caixa, double porcentagem) {
		this.controleCenarios = new ControllerCenario(caixa, porcentagem);
	}
	
	public int getCaixa() {
		return this.controleCenarios.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.controleCenarios.cadastrarCenario(descricao);
	}
	
	public String exibirCenario(int numeracao) {
		return this.controleCenarios.exibirCenario(numeracao);
	}
	
	public String exibirCenarios() {
		return this.controleCenarios.exibirCenarios();
	}
	
	public void cadastrarApostas(int cenario, String apostador, int valor, String previsao) {
		this.controleCenarios.cadastrarAposta(cenario, apostador, valor, Previsao.valueOf(previsao));
	}
	
	public int valorTotalDeApostas(int cenario) {
		return controleCenarios.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return controleCenarios.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return controleCenarios.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		controleCenarios.fecharCenario(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return controleCenarios.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return controleCenarios.getTotalRateio(cenario);
	}
}
