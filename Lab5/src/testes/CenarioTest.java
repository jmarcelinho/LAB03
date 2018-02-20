package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.Cenario;
import lab05.Estado;

public class CenarioTest {
	
	private Cenario cenario;
	@Before
	public void setUp() {
		cenario = new Cenario(1,"Todos os alunos vao ser aprovados");
	}

	@Test(expected = NullPointerException.class)
	public void cenarioComDescricaoNulaTest() {
		cenario = new Cenario(1,null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cenarioComDescricaoVaziaTest() {
		cenario = new Cenario(1,"        ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fecharCenarioFinalizadoTest() {
		cenario.fecharCenario(Estado.FINALIZADO_OCORREU);
		cenario.fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
	}
	
	
	@Test
	public void getDescricaoTest() {
		String expected = "Todos os alunos vao ser aprovados";
		assertEquals(expected, cenario.getDescricao());
	}
	
	@Test
	public void toStringCenarioNaoFinalizadoTest() {
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado";
		assertEquals(expected, cenario.toString());
	}
	
	@Test
	public void toStringCenarioFinalizadoOcorreuTest() {
		cenario.fecharCenario(Estado.FINALIZADO_OCORREU);
		String expected = "1 - Todos os alunos vao ser aprovados - Finalizado (ocorreu)";
		assertEquals(expected, cenario.toString());
	}
	
	public void toStringCenarioFinalizadoNaoOcorreuTest() {
		cenario.fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
		String expected = "1 - Todos os alunos vao ser aprovados - Finalizado ( n ocorreu)";
		assertEquals(expected, cenario.toString());
	}
	
}
