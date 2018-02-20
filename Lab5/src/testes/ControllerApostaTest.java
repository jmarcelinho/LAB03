package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.ControllerAposta;
import lab05.ControllerCenario;

public class ControllerApostaTest {
	private ControllerAposta controleAposta;
	private ControllerCenario controleCenario;
	
	@Before
	public void setUp() {
		controleAposta = new ControllerAposta();
		controleCenario = new ControllerCenario();
	}

	@Test
	public void exibeApostasTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleAposta.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleAposta.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		String expected = "Francisco Cisco - R$200.0 - VAI ACONTECER\n"
				+ "Brito - R$200.0 - N VAI ACONTECER\n";
		assertEquals(expected, controleAposta.exibeApostas(1));
	}
	
	@Test
	public void exibeApostasNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleAposta.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleAposta.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		String expected = "";
		assertEquals(expected, controleAposta.exibeApostas(2));
	}
	
	@Test
	public void numeroApostasTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleAposta.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleAposta.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		int expected = 2;
		assertEquals(expected, controleAposta.numeroApostas(1));
	}
	
	@Test
	public void valorApostasTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleAposta.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleAposta.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		int expected = 400;
		assertEquals(expected, controleAposta.valorApostas(1));
	}
}
