package lab04;


/**
 * Representacaoo de um aluno.
 * Cada aluno e representado por uma matricula, 
 * nome e curso. 
 * 
 * @author Joao Marcelo
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constroi um aluno a partir de sua matricula, nome
	 * e curso.
	 */
	public Aluno(String matricula, String nome, String curso) {
		testaNomes(matricula, nome, curso);
		this.matricula = matricula.trim();
		this.nome = nome.trim();
		this.curso = curso.trim();
	}
	
	private void testaNomes(String matricula, String nome, String curso) {
		if(nome==null) throw new NullPointerException("NOME NULO");
		if(nome.trim().equals("")) throw new IllegalArgumentException("NOME INVALIDO");
		
		if(matricula==null) throw new NullPointerException("MATRICULA NULA");
		if(matricula.trim().equals("")) throw new IllegalArgumentException("MATRICULA INVALIDA");
		
		if(curso==null) throw new NullPointerException("CURSO NULO");
		if(curso.trim().equals("")) throw new IllegalArgumentException("CURSO INVALIDO");
	}
	
	/**
	 * Retorna uma String representando a matricula do aluno.
	 * @return Representacao e String da matricula do aluno.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Retorna uma String representando o nome do aluno.
	 * @return Representacao em String do do aluno.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna uma String representando o curso do aluno.
	 * @return Representacao em String do curso do aluno.
	 */
	public String getCurso() {
		return curso;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Verifica se outro objeto eh igual a este objeto aluno.
	 * Dois alunos sao comparados iguais se
	 * possuirem a mesma matricula.
	 * 
	 * @return True se forem iguais e False
	 * caso contrario.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Aluno)) {
			return false;
		}
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Retorna uma representacao em String do aluno.
	 * A representacao eh no formato
	 * MATRICULA - NOME - CURSO
	 * 
	 * @return String representando um aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
}
