package lab04;

import java.util.HashMap;

public class ControleGrupos {
	private HashMap <String, Grupo> grupos;
	
	public ControleGrupos() {
		this.grupos = new HashMap<>();
	}
	
	public boolean cadastraGrupo(String nome) {
		if(grupos.containsKey(nome)) {
			return false;
		}
		grupos.put(nome, new Grupo(nome));
		return true;
	}
}
