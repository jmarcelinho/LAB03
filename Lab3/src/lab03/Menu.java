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

import java.util.Scanner;
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        String opcao;
        do{
            exibirMenu();
            opcao = sc.nextLine();
            switch(opcao){
                case "C":
                    cadastraContato(agenda,sc);
                    break;
                case "L":
                    listaContatos(agenda);
                    break;
                case "E":
                    exibeContato(agenda, sc);
                    break;
                case "S":
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!\n");
            }
        }while(!opcao.equals("S"));
    }
    
    public static void exibirMenu(){
        System.out.println("(C)adastrar contatos");
        System.out.println("(L)istar contatos");
        System.out.println("(E)xibir contato");
        System.out.println("(S)air");
        System.out.printf("\nOpção> ");
    }
    
    public static void cadastraContato(Agenda agenda, Scanner sc){
        System.out.printf("Posicao: ");
        int pos = sc.nextInt();
        System.out.printf("Nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.printf("Sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.printf("Telefone: ");
        String telefone = sc.nextLine();
        boolean cadastrado = agenda.cadastrarContatos(pos, nome, sobrenome, telefone);
        if(cadastrado){
            System.out.println("CADASTRO REALIZADO!\n");
        }else{
            System.out.println("POSIÇÃO INVÁLIDA!\n");
        }
        
    }
    
    public static void listaContatos(Agenda agenda){
        System.out.println(agenda.listarContatos());
    }
    
    public static void exibeContato(Agenda agenda, Scanner sc){
        int posicao;
        System.out.printf("Contato> ");
        posicao = sc.nextInt();
        sc.nextLine();
        System.out.println("\n" + agenda.pesquisarContato(posicao)+ "\n");
    }
}
