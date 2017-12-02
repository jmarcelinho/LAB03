package lab04;

import java.util.Scanner;


public class Menu {
	private static Scanner entrada = new Scanner(System.in);
	private static SistemaControle sistema= new SistemaControle();
	
	public static void main(String[] args) {
        String opcao;
        do{
            exibirMenu();
            opcao = entrada.nextLine();
            switch(opcao){
                case "C":
                    cadastrarAluno();
                    break;
                case "E":
                    exibirAluno();
                    break;
                case "N":
                	cadastrarGrupo();
                    break;
                case "A":
                	alocarAluno();
                    break;
                case "R":
                	registrarAlunoResponde();
                    break;
                case "I":
                	imprimirAlunoResponde();
                    break;
                default:
                    System.out.println("Opcao invalida!\n");
            }
        }while(!opcao.equals("O"));
    }
	
	public static void exibirMenu(){
        System.out.println("(C)adastrar Aluno\n" + 
        		"(E)xibir Aluno\n" + 
        		"(N)ovo Grupo\n" + 
        		"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
        		"(R)egistrar Resposta de Aluno\n" + 
        		"(I)mprimir Alunos que Responderam\n" + 
        		"(O)ra, vamos fechar o programa!\n" + 
        		"\n" +
        		"Opcao>");
    }
	public static void cadastrarAluno(){
		try{
			System.out.printf("Matricula: ");
			String matricula = entrada.nextLine();
			System.out.printf("Nome: ");
			String nome = entrada.nextLine();
			System.out.printf("Curso: ");
			String curso = entrada.nextLine();
			if(sistema.cadastrarAluno(matricula, nome, curso)){
				System.out.println("\nCADASTRO REALIZADO!");
			}else{
				System.out.println("\nMATRICULA JA CADASTRADA!");
			}
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\n");
		}catch(NullPointerException e){
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	public static void exibirAluno(){
		try{
			System.out.printf("Matricula: ");
			String matricula = entrada.nextLine();
			System.out.println("\n" + sistema.consultarAluno(matricula) + "\n");
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	public static void cadastrarGrupo(){
		try{
			System.out.printf("Grupo: ");
			String nome = entrada.nextLine();
			if(sistema.cadastrarGrupo(nome)){
				System.out.println("CADASTRO REALIZADO!");
			}else{
				System.out.println("GRUPO JA CADASTRADO!");
			}
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\n");
		}catch(NullPointerException e){
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	public static void alocarAluno(){
		try{
			System.out.println("(A)locar Aluno ou (I)mprimir Grupo?\n");
			String opcao;
			String nomeGrupo;
			String matricula;
			opcao = entrada.nextLine();
			switch(opcao){
		        case "A":
		        	System.out.printf("Matricula: ");
					matricula = entrada.nextLine();
					System.out.printf("\nGrupo: ");
					nomeGrupo = entrada.nextLine();
		            sistema.alocarAlunoGrupo(nomeGrupo, matricula);
		            break;
		        case "I":
		        	System.out.printf("Grupo: \n");
					nomeGrupo = entrada.nextLine();
					System.out.println(sistema.imprimirGrupo(nomeGrupo));
		            break;
		        default:
		            System.out.println("Opcao invalida!\n");
			}
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\n");
		}
    }
	
	public static void registrarAlunoResponde(){
		try{
			System.out.printf("Matricula: ");
			String matricula = entrada.nextLine();
			if(sistema.cadastraAlunosQuadro(matricula)){
				System.out.println("\nALUNO REGISTRADO!");
			}else{
				System.out.println("\nAluno nao cadastrado!");
			}
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	public static void imprimirAlunoResponde(){
		System.out.println(sistema.AlunosRespondem());
	}
}
