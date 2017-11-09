/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab03.Agenda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaomfsj
 */
public class AgendaTest {
    
    public AgendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrarContatos method, of class Agenda.
     */
    @Test
    public void testCadastrarContatos() {
        System.out.println("cadastrarContatos");
        int posicao = 0;
        String nome = "";
        String telefone = "";
        Agenda instance = new Agenda();
        boolean expResult = false;
        boolean result = instance.cadastrarContatos(posicao, nome, telefone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarContato method, of class Agenda.
     */
    @Test
    public void testPesquisarContato() {
        System.out.println("pesquisarContato");
        int posicao = 0;
        Agenda instance = new Agenda();
        String expResult = "";
        String result = instance.pesquisarContato(posicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarContatos method, of class Agenda.
     */
    @Test
    public void testListarContatos() {
        System.out.println("listarContatos");
        Agenda instance = new Agenda();
        String expResult = "";
        String result = instance.listarContatos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
