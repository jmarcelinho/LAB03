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
	
	/**
	 * Constroi um sistema de controle de grupos.
	 * No sistem nao podem ser cadastrados grupos
	 * com nomes iguais.
	 */
	public ControleGrupos() {
		this.grupos = new HashMap<>();
	}
	
	/**
	 * Cadastra um novo grupo no sistema.
	 * Um grupo eh cadastrado a partir de um nome.
	 * O grupo eh cadastrado com sucesso se no sistema 
	 * nao existir um grupo com o mesmo nome.
	 * @param nome nome do grupo a ser adicionado.
	 * @return True se o cadastro for realizado com sucesso
	 * e False caso contrario.
	 */
	public boolean cadastrarGrupo(String nome) {
		if(contemGrupo(nome)) {
			return false;
		}
		grupos.put(nome, new Grupo(nome));
		return true;
	}
	
	/**
	 * Aloca um aluno a um determinado grupo.
	 * Para essa acao eh necessaria informar o nome de um grupo 
	 * valido e informacoes de um aluno a ser adicionado.
	 * Retorna True se o grupo for valido e o cadastro ocorrer com sucesso
	 * e False caso contrario.
	 * @param nomeGrupo nome do grupo para alocao.
	 * @param aluno aluno que deve ser alocado no grupo.
	 * @return True se o cadastro for realizado com sucesso
	 * e False caso contrario.
	 */
	public boolean alocarAluno(String nomeGrupo, Aluno aluno){
		if(!contemGrupo(nomeGrupo)){
			throw new IllegalArgumentException("Grupo nao cadastrado");
		}
		return grupos.get(nomeGrupo).adicionarAluno(aluno);
	}
	
	/**
	 * Retorna uma String com informacoes de um determinado grupo.
	 * O grupo eh pesquisado a partir do seu nome.
	 * @param nomeGrupo nome do grupo que se deseja obter informacoes.
	 * @return String com as informacoes do grupo pesquisado.
	 */
	public String imprimirGrupo(String nomeGrupo){
		if(!contemGrupo(nomeGrupo)){
			throw new IllegalArgumentException("Grupo nao cadastrado");
		}
		return grupos.get(nomeGrupo).toString();
	}
	
	private boolean contemGrupo(String nome){
		return grupos.containsKey(nome);
	}
	
}
