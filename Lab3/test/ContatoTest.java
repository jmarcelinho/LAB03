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
 * @author Joao Marcelo
 */
public class ContatoTest {
    
    private Contato contato;
    private Contato contato2;
    
    @Before
    public void setUp() {
        contato = new Contato("Joao", "Marcelo", "86661543");
        
    }
    
    @Test(expected = NullPointerException.class)
    public void testNomeNull(){
        contato = new Contato(null, "Marcelo", "125484");
        fail("Cadastrou contato com nome null");
    }
    
    @Test(expected = NullPointerException.class)
    public void testSobrenomeNull(){
        contato = new Contato("Marcelo", null, "125484");
        fail("Cadastrou contato com sobrenome null");
    }
    
    @Test(expected = NullPointerException.class)
    public void testTelefoneNull(){
        contato = new Contato("Marcelo", "Fernandes", null);
        fail("Cadastrou contato com telefone null");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNomeEspacos(){
        contato = new Contato("   ", "Fernandes", "12548");
        fail("Cadastrou contato com nome apenas com espaço");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSobrenomeEspacos(){
        contato = new Contato("Marcelo", "   ", "12548");
        fail("Cadastrou contato com sobrenome apenas com espaço");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTelefoneEspacos(){
        contato = new Contato("Marcelo", "Fernandes", "    ");
        fail("Cadastrou contato com telefone apenas com espaço");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNomeVazio(){
        contato = new Contato("", "Fernandes", "12548");
        fail("Cadastrou contato com nome vazio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSobrenomeVazio(){
        contato = new Contato("Marcelo", "", "12548");
        fail("Cadastrou contato com sobrenome vazio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTelefoneVazio(){
        contato = new Contato("Marcelo", "Fernandes", "");
        fail("Cadastrou contato com telefone vazio");
    }
    
    @Test
    public void testEqualsNome(){
        //testa dois contatos diferentes
        contato = new Contato("Marcelo", "Silva", "21597");
        contato2 = new Contato("Joao", "Silva", "21597");
        if(contato.equals(contato2)){
            fail("Considerou dois contatos, com nomes diferentes, como iguais");
        }
        
        //testa dois contatos iguais
        contato = new Contato("Joao", "Silva", "21597");
        contato2 = new Contato("Joao", "Silva", "21597");
        if(!contato.equals(contato2)){
            fail("Considerou dois contatos, com nomes iguais, como diferentes");
        }
    }
    
    @Test
    public void testEqualsSobrenome(){
        //testa dois contatos diferentes
        contato = new Contato("Marcelo", "Silva", "21597");
        contato2 = new Contato("Marcelo", "Fernandes", "21597");
        if(contato.equals(contato2)){
            fail("Considerou dois contatos, com sobrenomes diferentes, como iguais");
        }
        
        //testa dois contatos iguais
        contato = new Contato("Marcelo", "Silva", "21597");
        contato2 = new Contato("Marcelo", "Silva", "21597");
        if(!contato.equals(contato2)){
            fail("Considerou dois contatos, com sobrenomes iguais, como diferentes");
        }
    }
    /**
     * Teste do metodo toString da classe Contato.
     */
    @Test
    public void testToString() {
        String result = contato.toString();
        String expResult = "Joao Marcelo - 86661543";
        assertEquals(expResult, result);
    }
    
}
