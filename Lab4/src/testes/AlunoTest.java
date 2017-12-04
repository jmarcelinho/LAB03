/**
 * 
 */
package testes;

import lab04.Aluno;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Joao Marcelo
 *
 */
public class AlunoTest {
	
	private Aluno aluno;
	
	@Before
	public void setUp() {
		aluno = new Aluno("250", "Joao", "CC");
	}

	/**
	 * Cria uma aluno com nome null.
	 */
	@Test(expected = NullPointerException.class)
	public void nomeAlunoNull() {
		Aluno aluno = new Aluno("251", null, "Ed. fisica");
	}
	
	/**
	 * Cria uma aluno com matricula null.
	 */
	@Test(expected = NullPointerException.class)
	public void matriculaAlunoNull() {
		Aluno aluno = new Aluno(null, "Carlos", "Ed. fisica");
	}
	
	/**
	 * Cria uma aluno com curso null.
	 */
	@Test(expected = NullPointerException.class)
	public void cursoAlunoNull() {
		Aluno aluno = new Aluno("251", "Carlos", null);
	}
	
	@Test
	public void toStringAluno(){
		String expected = "250 - Joao - CC";
		assertEquals(expected, aluno.toString());
	}

}
