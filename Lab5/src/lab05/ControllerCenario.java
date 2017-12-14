package lab05;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerCenario {
	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double porcentagemRetirada;
	
	public ControllerCenario(int valorCaixa, double porcentagem) {
		this.cenarios = new ArrayList<>();
		this.caixa = valorCaixa;
		this.porcentagemRetirada = porcentagem;
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	private void IsValid(int cenario) {
		if(cenario < 0 || cenario>=cenarios.size()) 
			throw new IllegalArgumentException("Cenario Invalido");
	}
	
	public int cadastrarCenario(String descricao) {
		cenarios.add(new Cenario(descricao));
		return cenarios.size();
	}
	
	public String exibirCenario(int numeracao) {
		--numeracao;
		IsValid(numeracao);
		String res = numeracao+1 + " - ";
		res +=cenarios.get(numeracao).toString();
		return res;
	}
	
	public String exibirCenarios() {
		Iterator <Cenario> it = cenarios.iterator();
		String res = "";
		int index = 1;
		while(it.hasNext()){
			res+= index + " - " + it.next().toString();
		}
		
		return res;
	}
	
	public void fecharCenario(int cenario, boolean ocorreu) {
		IsValid(cenario);
		if(ocorreu) {
			cenarios.get(cenario).fecharCenario(Estado.FINALIZADO_OCORREU);
			
			
		}
	}
	
}
