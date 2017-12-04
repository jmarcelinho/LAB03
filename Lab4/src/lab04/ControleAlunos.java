package lab04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Representacao de um sistema para controle de alunos.
 * O controle de alunos contem diversos alunos.
 * Nao eh permtido o cadastro de alunos com a mesma matricula.
 * Possui tambem uma lista que armazena quais
 * desses alunos respondem atividades no quadro.
 * @author Joao Marcelo
 *
 */
public class ControleAlunos {
	
	private HashMap <String, Aluno> alunos;
	private ArrayList <Aluno> alunosQuadro;	
	
	/**
	 * Constroi um sistema para controle os alunos.
	 */
	public ControleAlunos() {
		this.alunos = new HashMap<>();
		this.alunosQuadro = new ArrayList<>();
	}
	
	/**
	 * Cadastra um aluno no sistema a partir da sua matricula, nome e curso.
	 * Retorna True se o aluno foi cadastrado com sucesso. Caso contrario
	 * o retorno eh False.
	 * @param matricula matricula do aluno 
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 * @return True se o cadastro for realizado com sucesso e False caso
	 * contrario.
	 */
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if(contemAluno(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));
		return true;
	}
	
	/**
	 * Pesquisa um aluno no sistema partir da sua matricula
	 * e retorna uma representacao em string desse aluno.
	 * Caso a matricula nao esteja cadastrada uma excecao
	 * eh lancada informando o problema.
	 * @param matricula matricula do aluno pesquisado.
	 * @return Representacao em string do aluno pesquisado.
	 */
	public String consultarAluno(String matricula) {
		if(!contemAluno(matricula)) {
			throw new IllegalArgumentException("Aluno nao cadastrado.");
		}
		return "Aluno: " + alunos.get(matricula).toString();
	}
	
	/**
	 * Cadastra um aluno presente no sistema na lista dos 
	 * que respondem atividades no quadro.
	 * O aluno eh adicionado informando a sua matricula ao sistema.
	 * @param matricula matricula do aluno a ser adicionado.
	 * @return True se o cadastro foi realizado e False 
	 * caso contrario.
	 */
	public boolean cadastrarAlunoQuadro(String matricula) {
		if(!contemAluno(matricula)) {
			throw new IllegalArgumentException("Aluno nao cadastrado.");
		}
		return alunosQuadro.add(alunos.get(matricula));
	}
	
	/**
	 * Verifica se um aluno esta cadastrado no sistema.
	 * @param matricula matricula do aluno.
	 * @return True se o aluno esta cadastrado e False caso contrario.
	 */
	private boolean contemAluno(String matricula){
		return alunos.containsKey(matricula);
	}
	
	/**
	 * Retorna um aluno pesquisado a partir da sua matricula.
	 * @param matricula matricula do aluno buscado.
	 * @return Um objeto que representa o aluno buscado.
	 */
	public Aluno getAluno(String matricula){
		if(!contemAluno(matricula)){
			throw new IllegalArgumentException("Aluno nao cadastrado");
		}
		return alunos.get(matricula);
	}
	
	/**
	 * Retorna uma lista em string dos alunos que 
	 * respondem atividades no quadro.
	 * @return Lista no formato string dos alunos que respodem atividades no quadro.
	 */
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
