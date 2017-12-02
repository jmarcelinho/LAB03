package lab04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class ControleAlunos {
	
	private HashMap <String, Aluno> alunos;
	private ArrayList <Aluno> alunosQuadro;
	
	public ControleAlunos() {
		this.alunos = new HashMap<>();
		this.alunosQuadro = new ArrayList<>();
	}
	
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if(contemAluno(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));
		return true;
	}
	
	public String consultarAluno(String matricula) {
		if(!contemAluno(matricula)) {
			throw new IllegalArgumentException("Aluno nao cadastrado.");
		}
		return "Aluno: " + alunos.get(matricula).toString();
	}
	
	public boolean cadastrarAlunoQuadro(String matricula) {
		if(!contemAluno(matricula)) {
			throw new IllegalArgumentException("Aluno nao cadastrado.");
		}
		return alunosQuadro.add(alunos.get(matricula));
	}
	
	public boolean contemAluno(String matricula){
		return alunos.containsKey(matricula);
	}
	
	public Aluno getAluno(String matricula){
		if(!contemAluno(matricula)){
			throw new IllegalArgumentException("Aluno nao cadastrado");
		}
		return alunos.get(matricula);
	}
	
	public String alunosRespodemQuadro(){
		Iterator <Aluno> it = alunosQuadro.iterator();
		int i = 1;
		String res = "Alunos:\n";
		while(it.hasNext()){
			res+= i++ + ". " + it.next().toString();
		}
		return res;
	}
	
}
