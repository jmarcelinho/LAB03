package lab04;

import java.util.HashSet;
import java.util.Iterator;

public class Grupo {
	private String nome;
	private HashSet <Aluno> alunos;
	
	public Grupo(String nome) {
		if(nome==null) throw new NullPointerException("NOME NULO");
		if(nome.trim().equals("")) throw new IllegalArgumentException("NOME INVALIDO");
		this.nome = nome;
		this.alunos = new HashSet <>();
	}
	
	public boolean adicionarAluno(Aluno aluno) {
		return alunos.add(aluno);
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (!(obj instanceof Grupo)) {
			return false;
		}
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equalsIgnoreCase(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String ret  = "Alunos do grupo " + this.nome + " :\n";
		Iterator <Aluno> it = alunos.iterator();
		while(it.hasNext()){
			ret+= "* " + it.next().toString();
		}
		return ret;
		
	}
	
}
