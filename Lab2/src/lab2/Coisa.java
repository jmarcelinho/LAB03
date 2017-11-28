/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Joao Marcelo
 */
public class Coisa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

            /*ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");

            contaLCC2.consomeEspaco(1999);

            System.out.println(contaLCC2.atingiuCota());

            contaLCC2.consomeEspaco(2);

            System.out.println(contaLCC2.atingiuCota());

            contaLCC2.liberaEspaco(1);

            System.out.println(contaLCC2.atingiuCota());

            contaLCC2.liberaEspaco(1);

            System.out.println(contaLCC2.atingiuCota());

            System.out.println(contaLCC2.toString());

            
            Disciplina prog2 = new Disciplina("PROGRAMACAO 2");

            prog2.cadastraHoras(4);

            prog2.cadastraNota(1, 5.0);

            prog2.cadastraNota(2, 6.0);

            prog2.cadastraNota(3, 7.0);

            System.out.println(prog2.aprovado());

            prog2.cadastraNota(4, 10.0);

            System.out.println(prog2.aprovado());

            System.out.println(prog2.toString());
            
            /*
            testes parte extra
            int pesos[] = new int[2];
            pesos[0] = 6;
            pesos[1] = 4;
            
            Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 2, pesos);

            prog2.cadastraHoras(4);

            prog2.cadastraNota(1, 5.0);
            System.out.println(prog2.aprovado());
            prog2.cadastraNota(2, 5.0);

            prog2.cadastraNota(3, 7.0);
            

            System.out.println(prog2.aprovado());

            System.out.println(prog2.toString());*/

            

            /*Saude saude = new Saude();

            System.out.println(saude.geral());

            saude.defineSaudeMental("boa");

            saude.defineSaudeFisica("boa");

            System.out.println(saude.geral());

            saude.defineSaudeMental("fraca");

            saude.defineSaudeFisica("fraca");

            System.out.println(saude.geral());

            saude.defineSaudeMental("boa");

            saude.defineSaudeFisica("fraca");

            System.out.println(saude.geral());*/
            CartaoDeCreditoUFCG meuCartao = new CartaoDeCreditoUFCG(5000);
            

            ContaCantina mulherDoBolo = new ContaCantina("Mulher do Bolo");            

            //mulherDoBolo.cadastraLanche(2, 500);

            mulherDoBolo.cadastraLanche(1, 5000);
            
            System.out.println(meuCartao.saldoDisponível);
            mulherDoBolo.pagaConta(1000, meuCartao);
            System.out.println(meuCartao.saldoDisponível);
            System.out.println(meuCartao.saldoDevedor);
            System.out.println(mulherDoBolo.toString());
    }
    
}
