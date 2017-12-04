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

	@Before
	public void setUp() {
	}

	@Test(expected = NullPointerException.class)
	public void cadastraAluno() {
		Aluno aluno = new Aluno("Carlos", null, "Soneca");
	}

}
