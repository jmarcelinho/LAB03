package lab05;

import java.util.ArrayList;
import java.util.Iterator;


public class Cenario {
	private String descricao;
	private Estado estado;
	private double soma_ocorre;
	private double soma_nao_ocorre;
	private ArrayList <Aposta> apostas;
	
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		apostas = new ArrayList<>();
		this.soma_ocorre = 0;
		this.soma_nao_ocorre = 0;
	}
	
	public void cadastrarApostas(String nomeApostador, double valorAposta, Previsao previsao) {
		apostas.add(new Aposta(nomeApostador, valorAposta, previsao));
		if(previsao.equals(Previsao.VAI_ACONTECER)) {
			soma_ocorre+=valorAposta;
		}else {
			soma_nao_ocorre+=valorAposta;
		}
	}
	
	public double fecharCenario(Estado e) {
		this.estado = e;
		if(e.equals(Estado.FINALIZADO_OCORREU)) {
			return soma_nao_ocorre;
		}
		return soma_ocorre;
	}
	
	public String listarApostas() {
		Iterator <Aposta> it = apostas.iterator();
		String res = "";
		while(it.hasNext()){
			res+=it.next().toString();
		}
		return res;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String toString() {
		return descricao + " - " + estado;
	}
}
