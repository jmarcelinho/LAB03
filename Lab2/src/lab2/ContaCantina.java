/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 * Representação de conta em uma determinada cantina.
 * Toda conta precisa do nome da cantina na qual foi feita a conta, 
 * a quantidade de itens comprados e o valor devido.
 * 
 * @author João Marcelo
 */
public class ContaCantina {
    private String nomeDaCantina;
    private int debitoConta;
    private int qtdItens;
    
    /**
     * Cadastra uma conta em uma cantina.
     * Para cadastro da conta é informado o nome da cantina.
     * A quantidade de itens comprados e o debito da conta iniciam
     * com valor zero.
     * 
     * @param nomeDaCantina nome da cantina. 
     */
    public ContaCantina(String nomeDaCantina){
        this.nomeDaCantina = nomeDaCantina;
        this.debitoConta = 0;
        this.qtdItens = 0;
    }
    
    /**
     * Adiciona hum ou mais itens na conta e também o valor total dos itens.
     * O valor dos itens em centavos é adicionado ao debito da conta. 
     * @param qtdItens quantidade de itens comprados
     * @param valorCentavos valor total dos itens comprados
     */
    public void cadastraLanche(int qtdItens, int valorCentavos){
        this.qtdItens += qtdItens;
        this.debitoConta +=valorCentavos;
    }
    
    /**
     * Retira do debito total o valor pago da conta.
     * Para pagar a conta é necessário informar o valor pago.
     * 
     * @param valorCentavos valor pago em centavos.
     */
    public void pagaConta(int valorCentavos){
        this.debitoConta -= valorCentavos;
    }
    
    public void pagaConta(int valorCentavos, CartaoDeCreditoUFCG meuCartao){
        this.debitoConta -= valorCentavos;
        meuCartao.saldoDevedor += valorCentavos + (0.05*valorCentavos);
        meuCartao.saldoDisponível -= valorCentavos;
    }
    /**
     * Retorna uma string representando o estado da conta.
     * A string segue o formato nome da cantina, quantidade de itens comprados e
     * o debito total da conta.
     * @return estado da conta.
     */
    public String toString(){
        return nomeDaCantina + " " + qtdItens + " " + debitoConta;
    }
        
}
