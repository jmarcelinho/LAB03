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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.cadastrarContatos(1, "Marcelo", "68154844135");
        agenda.cadastrarContatos(2, "pigmeu", "6666689451");
        agenda.cadastrarContatos(6, "Doug", "5456454987");
        System.out.println(agenda.pesquisarContato(5));
        System.out.println(agenda.pesquisarContato(1));
        System.out.println(agenda.listarContatos());
        
    }
    
}
