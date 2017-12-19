package lab05;

import easyaccept.EasyAccept;

public class Facade {
	private ControllerCenario controleCenarios;
	
	public Facade() {
		controleCenarios = new ControllerCenario(0, 0.1);
	}
	
	public static void main(String[] args) {
		String [] args1 = new String[] {"lab05.Facade", "acceptance_test/us1_test.txt"};
		String [] args2 = new String[] {"lab05.Facade", "acceptance_test/us2_test.txt"};
		String [] args3 = new String[] {"lab05.Facade", "acceptance_test/us3_test.txt"};
		//EasyAccept.main(args1);
		EasyAccept.main(args3);
	}
	public void inicializa(int caixa, double porcentagem) {
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
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		Previsao previsao2;
		if(previsao.equals("N VAI ACONTECER")) previsao2 = Previsao.NAO_VAI_ACONTECER;
		else previsao2 = Previsao.VAI_ACONTECER;
		this.controleCenarios.cadastrarAposta(cenario, apostador, valor, previsao2);
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
