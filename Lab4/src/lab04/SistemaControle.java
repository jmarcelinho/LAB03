package lab04;

public class SistemaControle {
	
	private ControleGrupos controleGrupo;
	private ControleAlunos controleAluno;
	
	public SistemaControle() {
		this.controleGrupo = new ControleGrupos();
		this.controleAluno = new ControleAlunos();
	}
	
	public boolean cadastrarAluno(String matricula, String nome, String curso){
		return controleAluno.cadastrarAluno(matricula, nome, curso);
	}
	
	public String consultarAluno(String matricula){
		return controleAluno.consultarAluno(matricula);
	}
	
	public boolean cadastrarGrupo(String nomeGrupo){
		return controleGrupo.cadastrarGrupo(nomeGrupo);
	}
	
	public boolean alocarAlunoGrupo(String nomeGrupo, String matricula){
		return controleGrupo.alocarAluno(nomeGrupo, controleAluno.getAluno(matricula));
	}
	
	public String imprimirGrupo(String nomeGrupo){
		return controleGrupo.imprimirGrupo(nomeGrupo);
	}
	
	public boolean cadastraAlunosQuadro(String matricula){
		return controleAluno.cadastrarAlunoQuadro(matricula);
	}
	
	public String AlunosRespondem(){
		return controleAluno.alunosRespodemQuadro();
	}
}
