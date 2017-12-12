package lab05;

import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private String estado;
	private ArrayList <Aposta> apostas;
	
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		apostas = new ArrayList<>();
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	public String toString() {
		return descricao + " - " + estado;
	}
}
