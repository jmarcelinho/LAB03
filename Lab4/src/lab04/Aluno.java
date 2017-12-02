package lab04;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	public Aluno(String matricula, String nome, String curso) {
		testaNomes(matricula, nome, curso);
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	private void testaNomes(String matricula, String nome, String curso) {
		if(nome==null) throw new NullPointerException("NOME NULO");
		if(nome.trim()=="") throw new IllegalArgumentException("NOME INVALIDO");
		
		if(matricula==null) throw new NullPointerException("MATRICULA NULA");
		if(matricula.trim()=="") throw new IllegalArgumentException("MATRICULA INVALIDA");
		
		if(curso==null) throw new NullPointerException("CURSO NULO");
		if(curso.trim()=="") throw new IllegalArgumentException("CURSO INVALIDO");
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
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

	@Override
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

	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
}
