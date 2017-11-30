package lab04;

import java.util.Scanner;


public class Menu {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
        String opcao;
        do{
            exibirMenu();
            
            opcao = sc.nextLine();
            switch(opcao){
                case "C":
                    //cadastraContato(agenda,sc);
                    break;
                case "E":
                    //exibeContato(agenda, sc);
                    break;
                case "N":
                	//adicionaGrupo()
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!\n");
            }
        }while(!opcao.equals("S"));
    }
	public static void exibirMenu(){
        System.out.println("(C)adastrar Aluno\n" + 
        		"\n" + 
        		"(E)xibir Aluno\n" + 
        		"\n" + 
        		"(N)ovo Grupo\n" + 
        		"\n" + 
        		"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
        		"\n" + 
        		"(R)egistrar Resposta de Aluno\n" + 
        		"\n" + 
        		"(I)mprimir Alunos que Responderam\n" + 
        		"(O)ra, vamos fechar o programa!\n" + 
        		"\n" + 
        		"Opção>");
    }
}
