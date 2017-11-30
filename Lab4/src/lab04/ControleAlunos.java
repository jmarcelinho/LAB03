package lab04;

import java.util.HashMap;

public class ControleAlunos {
	private HashMap <String, Aluno> alunos;
	
	public ControleAlunos() {
		this.alunos = new HashMap<>();
	}
	
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if(alunos.containsKey(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));
		return true;
	}
	
	public String consultaAluno(String matricula) {
		if(alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		return "Aluno nao cadastrado.";
	}
	
}
