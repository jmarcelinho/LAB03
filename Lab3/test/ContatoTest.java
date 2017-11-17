/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab03.Contato;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaomfsj
 */
public class ContatoTest {
    
    private Contato contato;
    
    @Before
    public void setUpClass() {
        contato = new Contato("Amandio", "Jose", "86661543");
    }
    
    @Test
    public void testContatoString(){
        Contato c2 = new Contato("Dorime", "Ameno", "6545666");
        assertEquals("Dorime", c2.getNome());
        assertEquals("Ameno", c2.getSobrenome());
        assertEquals("6545666", c2.getTelefone());
    }
    /**
     * Teste do metodo toString da classe Contato.
     */
    @Test
    public void testToString() {
        String result = contato.toString();
        String expResult = "Amandio Jose - 86661543";
        assertEquals(expResult, result);
    }
    
}
