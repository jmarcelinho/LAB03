/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *  Representação do estado da saúde fisca e mental de um aluno.
 *  
 * @author João Marcelo
 */
public class Saude {
    private String saudeFisica;
    private String saudeMental;
    
    /**
     * Constrói um objeto do tipo saúde.
     * A saúde fisica e mental são inicialmente definidas como boa.
     * 
     */
    public Saude(){
        this.saudeFisica = "boa";
        this.saudeMental = "boa";
    }
    
    /**
     * Define ou altera o estado da saude mental do aluno.
     * 
     * @param valor estado da saúde mental "boa" ou "fraca".  
     */
    public void defineSaudeMental(String valor){
        this.saudeMental = valor;
    }
    
    /**
     * Define ou altera o estado da saude fisica do aluno.
     * 
     * @param valor estado da saúde fisica "boa" ou "fraca".  
     */
    public void defineSaudeFisica(String valor){
        this.saudeFisica = valor;
    }
    
    /**
     * Retorna uma string  que representa o estado geral da saúde do aluno.
     * Se tanto a saúde fisica como a mental forem fracas o estado geral é fraco.
     * Se ambas forem boas o estado geral é boa.
     * Se apenas uma estiver boa o estado geral é "ok"
     * @return estado geral da saúde.
     */
    public String geral(){
        if(this.saudeFisica.equals("fraca") && this.saudeMental.equals("fraca")){
            return "fraca";
        }else if(this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")){
            return "boa";
        }
        return "ok";
    }
}
