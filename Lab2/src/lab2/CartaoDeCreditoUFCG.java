/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author joaomfsj
 */
public class CartaoDeCreditoUFCG {
   public double limiteDeCredito;

   public double saldoDevedor;

   public double saldoDisponível;

    public CartaoDeCreditoUFCG(double limiteDeCredito) {

       this.limiteDeCredito = limiteDeCredito;

       saldoDevedor = 0;

       saldoDisponível = limiteDeCredito;

    }

    @Override

    public String toString() {

        return "Limite de credito: " + limiteDeCredito + " saldo devedor: " + saldoDevedor;

    }
}
