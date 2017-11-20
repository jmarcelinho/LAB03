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
    private Agenda agenda2;
    
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
        String expResult = "Joao Marcelo - 12345";
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo listarContatos da classe Agenda.
     */
    @Test
    public void testListarContatos() {
        agenda = new Agenda();
        agenda.cadastrarContatos(1, "Joao", "Marcelo", "123123");
        agenda.cadastrarContatos(2, "Jose", "Fernandes", "123456");
        agenda.cadastrarContatos(3, "Fernando", "Silva", "123666");
        String expResult = "1 - Joao Marcelo - 123123\n" 
                            + "2 - Jose Fernandes - 123456\n"
                            + "3 - Fernando Silva - 123666\n";
        assertEquals(expResult, agenda.listarContatos());
    }
    
    @Test
    public void testEqualsAgendasIguais(){
        agenda = new Agenda();
        agenda.cadastrarContatos(1, "Joao", "Marcelo", "123123");
        agenda.cadastrarContatos(2, "Jose", "Fernandes", "123123");
        agenda2 = new Agenda();
        agenda2.cadastrarContatos(1, "Joao", "Marcelo", "123123");
        agenda2.cadastrarContatos(2, "Jose", "Fernandes", "123123");
        if(!agenda.equals(agenda2)){
            fail("Considerando duas agendas iguais como sendo diferentes");
        }
    }
    
    @Test
    public void testEqualsAgendasDiferentes(){
        agenda = new Agenda();
        agenda.cadastrarContatos(1, "Joao", "Marcelo", "123123");
        agenda.cadastrarContatos(2, "Jose", "Fernandes", "123123");
        agenda2 = new Agenda();
        agenda2.cadastrarContatos(1, "Joao", "Brito", "123123");
        agenda2.cadastrarContatos(3, "Jose", "Fernandes", "123123");
        if(agenda.equals(agenda2)){
            fail("Considerando duas agendas diferentes como sendo iguais");
        }
    }
    
    public void testEqualsAgendasNull(){
        agenda = new Agenda();
        agenda.cadastrarContatos(1, "Joao", "Marcelo", "123123");
        agenda.cadastrarContatos(2, "Jose", "Fernandes", "123123");
        agenda2 = new Agenda();
        if(agenda.equals(agenda2)){
            fail("Considerando que uma agenda preenchida é igual a uma agenda null");
        }
    }
}
