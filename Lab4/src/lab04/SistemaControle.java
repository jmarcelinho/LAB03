package lab04;

/**
 * Representacao de um sistema para interacao
 * entre controle de alunos e controle de grupos.
 * @author Joao Marcelo
 */
public class SistemaControle {
	
	private ControleGrupos controleGrupo;
	private ControleAlunos controleAluno;
	
	/**
	 * Constroi um sistema de interacao entre 
	 * controle de alunos e controle de grupos.
	 */
	public SistemaControle() {
		this.controleGrupo = new ControleGrupos();
		this.controleAluno = new ControleAlunos();
	}
	
	/**
	 * Cadastra um aluno no sistema de controle de alunos.
	 * Para cadastro do aluno eh necessario a matricula, nome e curso.
	 * Eh retornado True se o cadastro for feito com sucesso e
	 * False caso contrario.
	 * @param matricula matricula do aluno 
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 * @return True para cadastro realizado com sucesso e False caso contrario.
	 */
	public boolean cadastrarAluno(String matricula, String nome, String curso){
		return controleAluno.cadastrarAluno(matricula, nome, curso);
	}
	
	/**
	 * Pesquisa um aluno no sistema de controle de alunos
	 * a partir da sua matricula e retorna uma 
	 * representacao em string desse aluno.
	 * Caso a matricula nao esteja cadastrada uma excecao
	 * eh lancada informando o problema.
	 * 
	 * @param matricula matricula do aluno pesquisado.
	 * @return Representação em String do aluno pesquisado.
	 */
	public String consultarAluno(String matricula){
		return controleAluno.consultarAluno(matricula);
	}
	
	/**
	 * Cadastra um novo grupo no sistema de controle
	 * de grupos.
	 * Um grupo eh cadastrado a partir de um nome.
	 * O grupo eh cadastrado com sucesso se no sistema
	 * de controle de grupos 
	 * nao existir um grupo com o mesmo nome.
	 * 
	 * @param nomeGrupo nome do grupo a ser cadastrado.
	 * @return True se o aluno for adicionado e False caso
	 * contrario.
	 */
	public boolean cadastrarGrupo(String nomeGrupo){
		return controleGrupo.cadastrarGrupo(nomeGrupo);
	}
	
	/**
	 * Aloca um aluno a um determinado grupo pelo sistema de controle
	 * de grupos.
	 * Para essa acao eh necessaria informar o nome de um grupo 
	 * valido e matricula de um aluno a ser adicionado.
	 * Retorna True se o grupo for valido e a matricula do aluno estiver
	 * cadastrada no sistema de controle de alunos. Caso contrario o retorno
	 * e falso.
	 * @param nomeGrupo nome do grupo para alocao do aluno.
	 * @param matricula matricula do aluno a ser alocado.
	 * @return True se o cadastro for realizado com sucesso e False caso contrario.
	 */
	public boolean alocarAlunoGrupo(String nomeGrupo, String matricula){
		return controleGrupo.alocarAluno(nomeGrupo, controleAluno.getAluno(matricula));
	}
	
	/**
	 * Retorna uma string com informacoes de um determinado
	 * grupo.
	 * O grupo eh pesquisado a partir do seu nome.
	 * Se o nome nao estiver cadastrado no sistema de
	 * controle de grupos ocorre um erro de grupo invalido.
	 * @param nomeGrupo nome do grupo. 
	 * @return Representacao em string do grupo pesquisado.
	 */
	public String imprimirGrupo(String nomeGrupo){
		return controleGrupo.imprimirGrupo(nomeGrupo);
	}
	
	/**
	 * Cadastra um aluno presente no sistema de controles
	 * de aluno na lista dos que respondem atividades no quadro.
	 * O aluno eh adicionado informando a sua matricula ao sistema.
	 * @param matricula matricula do aluno a ser cadastrado
	 * @return True se o cadastro ocorrer com sucesso e False
	 * caso contrario.
	 */
	public boolean cadastraAlunosQuadro(String matricula){
		return controleAluno.cadastrarAlunoQuadro(matricula);
	}
	
	/**
	 * Retorna uma representacao em string de uma lista de 
	 * alunos que respondem atividades no quadro.
	 * @return Lista de alunos que respondem atividades no quadro.
	 */
	public String AlunosRespondem(){
		return controleAluno.alunosRespodemQuadro();
	}
}
