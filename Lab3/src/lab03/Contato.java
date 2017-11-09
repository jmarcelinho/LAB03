/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 *
 * @author joao
 */
public class Contato {
    private String nome;

    private String telefone;
    
    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String toString(){
        return nome + " " + telefone;
    }
}
