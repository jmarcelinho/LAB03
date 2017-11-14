/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab03.Agenda;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaomfsj
 */
public class AgendaTest {
    
    private Agenda agenda;
    
    @Before
    public void setUp(){
        agenda = new Agenda();
    }
    
    @Test
    public void testAgenda(){
        Agenda a2 = new Agenda();
        a2.cadastrarContatos(1, "j", "m", "555");
        a2.listarContatos();
        Object c[] = new Object[100]; 
        Assert.assertArrayEquals(c, agenda.getContatos());
    }
    /**
     * Teste do metodo cadastrarContatos da classe Agenda.
     */
    @Test
    public void testCadastrarContatos() {
        System.out.println("cadastrarContatos");
        int posicao = 1;
        String nome = "Joao";
        String sobrenome = "Marcelo";
        String telefone = "12345";
        agenda.cadastrarContatos(posicao, nome, sobrenome, telefone);
        boolean expResult = true;
        boolean result = agenda.cadastrarContatos(posicao, nome, sobrenome, telefone);
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo pesquisarContato da classe Agenda.
     */
    @Test
    public void testPesquisarContato() {
        
    }

    /**
     * Teste do metodo listarContatos da classe Agenda.
     */
    @Test
    public void testListarContatos() {
        
    }
    
}
