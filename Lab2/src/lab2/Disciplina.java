/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 * Representação de disciplina do curso de 
 * ciência da computação da UFCG. Toda disciplina precisa ter um nome
 * que identifica essa discplina. Toda discplina contém 4 notas referente
 *´às avaliações realizadas e também as suas horas de estudo.
 * 
 * @author João Marcelo 
 */

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double notas[];
    private double media;
    private int numeroNotas;
    private int pesoNotas[];
    
    /**
     * Constrói um objeto disciplina a partir do seu nome.
     * Toda disciplina é iniciada sem nenhuma hora de estudo
     * e sem notas cadastradas.
     * Por padrão o número de notas é igual a 4.
     * 
     * @param nomeDiscplina nome da disciplina cadastrada. 
     */
    public Disciplina(String nomeDiscplina){
        this.nomeDisciplina = nomeDiscplina;
        this.horasEstudo = 0;
        this.numeroNotas = 4;
        this.notas = new double[numeroNotas];
        this.pesoNotas = new int[numeroNotas];
        Arrays.fill(pesoNotas, 1);
    }
    
    /**
     * Constrói um objeto disciplina a partir do seu nome e número de notas.
     * Toda disciplina é iniciada sem nenhuma hora de estudo
     * e sem notas cadastradas. A discplina vai ter exatamente
     * o numero de notas passado por parametro.
     * 
     * @param nomeDiscplina nome da disciplina.
     * @param numeroNotas numero de notas da disciplina
     */
    public Disciplina(String nomeDiscplina, int numeroNotas){
        this.nomeDisciplina = nomeDiscplina;
        this.horasEstudo = 0;
        this.numeroNotas = numeroNotas;
        this.notas = new double[numeroNotas];
        this.pesoNotas = new int[numeroNotas];
        Arrays.fill(pesoNotas, 1);
    }
    
    /**
     * Constrói um objeto disciplina a partir do seu nome, numero de notas
     * e peso das notas.
     * Toda disciplina é iniciada sem nenhuma hora de estudo
     * e sem notas cadastradas. A discplina vai ter exatamente
     * o numero de notas passado por parametro e cada nota com o seu peso.
     * 
     * @param nomeDiscplina nome da disciplina
     * @param numeroNotas numero de notas da disciplina
     * @param pesoNotas pesoa das notas da disciplina
     */
    public Disciplina(String nomeDiscplina, int numeroNotas, int pesoNotas[]){
        this.nomeDisciplina = nomeDiscplina;
        this.horasEstudo = 0;
        this.numeroNotas = numeroNotas;
        this.notas = new double[numeroNotas];
        this.pesoNotas = pesoNotas;
    }
    
    /**
     * Cadastra a quantidade de horas de estudo da disciplina.
     * 
     * @param horas horas de estudo a ser cadastrada.
     */
    public void cadastraHoras(int horas){
        this.horasEstudo = horas;
    }
    
    /**
     * Cadastra uma determinada nota na disciplina.
     * Caso alguma nota não seja cadastrada ela é considerada como zero.
     * Se a mesma nota for cadastrada mais de uma vez,
     * fica a última nota cadastrada.
     * 
     * @param nota qual a nota a ser cadastrada 1, 2, 3, 4.
     * @param valorNota valor da nota a ser cadastrada 0.0 a 10.0
     */
    public void cadastraNota(int nota, double valorNota){
        this.notas[--nota] = valorNota;
    }
    
    /**
     * Calcula a media aritmetica das notas da disciplina.
     * 
     * @return media aritmetica das notas cadastradas;
     */
    public Double calcularMedia(){
        double soma = 0;
        int peso = 0;
        for(int i = 0; i < this.numeroNotas; i++){
            soma += notas[i]*pesoNotas[i];
            peso += pesoNotas[i];
        }
        this.media = (soma/peso);
        
        return media;
    }

    /**
     * Verifica se o aluno foi ou não aprovado na discplina.
     * O aluno é considerado aprovado se possuir media maior 
     * ou igual a 7.0.
     * 
     * @return true se for aprovado ou false caso contrário;
     */
    public boolean aprovado(){
        if(calcularMedia()>= 7.0){
            return true;
        }
        return false;
    }

    /**
     * Retorna uma string que representa a disciplina. 
     * A apresentação segue o formato 
     * nome da disciplina, horas de estudo, media e notas.
     * 
     * @return representação em string da disciplina.
     */
    public String toString() {
        String notasSaida = Arrays.toString(notas);
        return nomeDisciplina + " " + horasEstudo + " " + media + " " + notasSaida;
    }
    
}
