package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.Aposta;
import lab05.Previsao;

public class ApostaTest {
	
	private Aposta aposta;
	@Before
	public void setUp(){
		aposta = new Aposta("Joao", 200, Previsao.VAI_ACONTECER);
	}

	@Test(expected = NullPointerException.class)
	public void apostaNomeNullTest() {
		aposta = new Aposta(null, 200, Previsao.NAO_VAI_ACONTECER);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void apostaNomeVazioTest() {
		aposta = new Aposta("        ", 200, Previsao.NAO_VAI_ACONTECER);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void apostaValorNegativoTest() {
		aposta = new Aposta("Marcelo", -30, Previsao.NAO_VAI_ACONTECER);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void apostaValorZeroTest() {
		aposta = new Aposta("Marcelo", 0, Previsao.NAO_VAI_ACONTECER);
	}
	
	@Test
	public void toStringTest() {
		String expected = "Joao - R$200.0 - Vai acontecer";
		assertEquals(expected, aposta.toString());
	}
	
	@Test
	public void valorApostaTest() {
		int expected = 200;
		assertEquals(expected, (int)aposta.getValor());
	}

}
