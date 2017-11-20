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
    private Contato contato2;
    private String nome;
    private String sobrenome;
    private String telefone;
    @Before
    public void setUp() {
        contato = new Contato("Amandio", "Jose", "86661543");
        
    }
    
    @Test(expected = NullPointerException.class)
    public void testNomeNull(){
        nome = null;
        sobrenome = "Marcelo";
        telefone = "125484";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com nome null");
    }
    
    @Test(expected = NullPointerException.class)
    public void testSobrenomeNull(){
        nome = "Marcelo";
        sobrenome = null;
        telefone = "125484";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com sobrenome null");
    }
    
    @Test(expected = NullPointerException.class)
    public void testTelefoneNull(){
        nome = "Marcelo";
        sobrenome = "Fernandes";
        telefone = null;
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com telefone null");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNomeEspacos(){
        nome = "   ";
        sobrenome = "Fernandes";
        telefone = "12548";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com nome apenas com espaço");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSobrenomeEspacos(){
        nome = "Marcelo";
        sobrenome = "   ";
        telefone = "12548";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com sobrenome apenas com espaço");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTelefoneEspacos(){
        nome = "Marcelo";
        sobrenome = "Fernandes";
        telefone = "    ";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com telefone apenas com espaço");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNomeVazio(){
        nome = "";
        sobrenome = "Fernandes";
        telefone = "12548";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com nome vazio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSobrenomeVazio(){
        nome = "Marcelo";
        sobrenome = "";
        telefone = "12548";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com sobrenome vazio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTelefoneVazio(){
        nome = "Marcelo";
        sobrenome = "Fernandes";
        telefone = "";
        contato = new Contato(nome, sobrenome, telefone);
        fail("Cadastrou contato com telefone vazio");
    }
    
    @Test
    public void testEqualsNome(){
        contato = new Contato("Marcelo", "Silva", "21597");
        contato2 = new Contato("Joao", "Silva", "21597");
        if(contato.equals(contato2)){
            fail("Considerou dois contatos, com nomes diferentes, como iguais");
        }
    }
    
    @Test
    public void testEqualsSobrenome(){
        contato = new Contato("Marcelo", "Silva", "21597");
        contato2 = new Contato("Marcelo", "Fernandes", "21597");
        if(contato.equals(contato2)){
            fail("Considerou dois contatos, com sobrenomes diferentes, como iguais");
        }
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
