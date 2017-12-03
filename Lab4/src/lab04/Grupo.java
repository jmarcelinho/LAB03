package lab04;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Representação de um grupo de estudos.
 * Um grupo eh representando por um nome
 * e eh formado por um conjunto de alunos.
 * @author Joao Marcelo
 *
 */
public class Grupo {
	private String nome;
	private HashSet <Aluno> alunos;
	
	/**
	 * Constrói um grupo a partir de um nome.
	 * Um grupo começa sem nenhum aluno.
	 * @param nome Nome do grupo a ser criado.
	 */
	public Grupo(String nome) {
		if(nome==null) throw new NullPointerException("NOME NULO.");
		if(nome.trim().equals("")) throw new IllegalArgumentException("NOME INVALIDO.");
		this.nome = nome;
		this.alunos = new HashSet <>();
	}
	
	/**
	 * Adiciona um aluno ao grupo.
	 * Retorna True se o aluno for adicionado com sucesso
	 * e False caso algum erro ocorra e o aluno não for adicionado.
	 * @param aluno Objeto aluno que representa um aluno.
	 * @return True se o aluno for adicionado e False caso
	 * contrário.
	 */
	public boolean adicionarAluno(Aluno aluno) {
		return alunos.add(aluno);
	}
	
	/**
	 * Retorna o nome do grupo.
	 * @return nome do grupo em string
	 */
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

	/**
	 * Compara um objeto eh igual a este Grupo.
	 * Dois grupos sao comparados iguais se possuirem o
	 * mesmo nome.
	 * Retorna True se objeto eh um grupo e se possuirem 
	 * o mesmo nome. De outra forma retorna False.
	 * @return True se os objetos forem iguais e False
	 * caso contrário.
	 */
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
	
	/**
	 * Retorna uma representação em String de um grupo.
	 * O grupo eh representado por seu nome e uma lista
	 * de alunos do grupo.
	 * @return Uma string representa um grupo.
	 */
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
