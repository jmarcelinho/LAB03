package lab04;

import java.util.HashMap;

/**
 * Representação de um sistema para controle
 * de grupos de estudo.
 * No sistem nao podem ser cadastrados grupos com o mesmo
 * nome.
 * @author Joao Marcelo
 *
 */
public class ControleGrupos {
	private HashMap <String, Grupo> grupos;
	
	
	public ControleGrupos() {
		this.grupos = new HashMap<>();
	}
	
	public boolean cadastrarGrupo(String nome) {
		if(contemGrupo(nome)) {
			return false;
		}
		grupos.put(nome, new Grupo(nome));
		return true;
	}
	
	public boolean alocarAluno(String nomeGrupo, Aluno aluno){
		if(!contemGrupo(nomeGrupo)){
			throw new IllegalArgumentException("Grupo nao cadastrado");
		}
		return grupos.get(nomeGrupo).adicionarAluno(aluno);
	}
	
	public String imprimirGrupo(String nomeGrupo){
		if(!contemGrupo(nomeGrupo)){
			throw new IllegalArgumentException("Grupo nao cadastrado");
		}
		return grupos.get(nomeGrupo).toString();
	}
	
	public boolean contemGrupo(String nome){
		return grupos.containsKey(nome);
	}
	
}
