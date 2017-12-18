package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.ControllerCenario;

public class ControllerCenarioTest {
	ControllerCenario controleCenario;
	@Before
	public void setUp(){
		controleCenario = new ControllerCenario(100, 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasCaixaNegativoTest() {
		controleCenario = new ControllerCenario(-100, 0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasCaixaZeroTest() {
		controleCenario = new ControllerCenario(0, 0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasPorcentagemZeroTest() {
		controleCenario = new ControllerCenario(100, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasPorcentagemNegativoTest() {
		controleCenario = new ControllerCenario(100, -1);
	}
	
	@Test
	public void cadastrarCenarioTest() {
		int expected = 1;
		assertEquals(expected, controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados"));
	}
	
	@Test
	public void exibirCenarioTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado";
		assertEquals(expected, controleCenario.exibirCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exibirCenarioNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado";
		assertEquals(expected, controleCenario.exibirCenario(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exibirCenariosTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarCenario("Todos os alunos vao ser reprovados");
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado\n"
				+"2 - Todos os alunos vao ser reprovados - Nao finalizado\n" ;
		assertEquals(expected, controleCenario.exibirCenarios());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fecharCenarioNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.fecharCenario(0, false);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fecharCenarioFinalizadoTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		//fechando cenario
		controleCenario.fecharCenario(1, false); 
		//tentando fechar o mesmo cenario
		controleCenario.fecharCenario(1, true); 
	}
}
