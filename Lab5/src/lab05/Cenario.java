package lab05;

import java.util.ArrayList;
import java.util.Iterator;


public class Cenario {
	private String descricao;
	private Estado estado;
	private ArrayList <Aposta> apostas;
	
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		apostas = new ArrayList<>();
	}
	
	public void cadastrarApostas(Aposta aposta) {
		apostas.add(aposta);
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
