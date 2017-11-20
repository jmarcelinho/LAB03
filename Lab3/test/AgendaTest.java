/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab03.Agenda;
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
        assertEquals(0, agenda.getNumeroContatos());
    }
    /**
     * Teste do metodo cadastrarContatos da classe Agenda.
     */
    @Test
    public void testCadastrarContatos() {
        //Cadastrar em uma posição válida
        int posicao = 1;
        String nome = "Joao";
        String sobrenome = "Marcelo";
        String telefone = "12345";
        boolean expResult = true;
        boolean result = agenda.cadastrarContatos(posicao, nome, sobrenome, telefone);
        assertEquals(expResult, result);
        //Cadastrar em uma posição inválida
        posicao = 0;
        expResult = false;
        result = agenda.cadastrarContatos(posicao, nome, sobrenome, telefone);
        assertEquals(expResult, result);
        
    }

    /**
     * Teste do metodo pesquisarContato da classe Agenda.
     */
    @Test
    public void testPesquisarContato() {
        int posicao = 1;
        agenda.cadastrarContatos(posicao, "Joao", "Marcelo", "12345");
        String result = agenda.pesquisarContato(posicao);
        String expResult = "Joao Marcelo 12345";
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo listarContatos da classe Agenda.
     */
    @Test
    public void testListarContatos() {
        
    }
    
}
