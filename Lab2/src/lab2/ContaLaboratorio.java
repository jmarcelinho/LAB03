/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 * Representa uma conta em um determinado laboratório.
 * É responsavél por manter o registro da quantidade de espaço utilizado
 * em determinado laboratório.
 * Toda conta precisa ter o nome do laboratório o espaco ocupado e qual é cota
 * limite de espaço que pode ser utilizado.
 * 
 * @author Joao Marcelo
 */
public class ContaLaboratorio {
    private String nomeLaboratorio;
    private int espacoOcupado;
    private int cota;
    
    /**
     * Constrói uma conta em um laboratório a partir
     * do nome do laboratório no qual será criada a conta.
     * Por padrão o espaco ocupado é iniciado como 0 e a cota limite 
     * de 2000 megabytes.
     * 
     * @param nomeLaboratorio nome do laboratorio da conta. 
     */
    public ContaLaboratorio(String nomeLaboratorio){
        this.nomeLaboratorio = nomeLaboratorio;
        this.espacoOcupado = 0;
        this.cota = 2000;
    }
    
    /**
     * Constrói uma conta em um laboratório a partir do nome do laboratório
     * e da cota máxima de espaço. O espaço é iniciado com valor 0.
     * 
     * @param nomeLaboratorio nome do laboratorio da conta
     * @param cota cota limite de espaço que pode ser utilizada.
     */
    public ContaLaboratorio(String nomeLaboratorio, int cota){
        this.nomeLaboratorio = nomeLaboratorio;
        this.espacoOcupado = 0;
        this.cota = cota;
    }
    
    /**
     * Consome determinada quantidade de memória do espaço livre na conta.
     * 
     * @param mBytes quantidade de memoria consumida.
     */
    public void consomeEspaco(int mBytes){
        this.espacoOcupado += mBytes;
    }
    
    /**
     * Libera determminada quantidade de memória do espaço ocupado na conta.
     * 
     * @param mBytes quantidade de memoria liberada.
     */
    public void liberaEspaco(int mBytes){
        this.espacoOcupado -= mBytes;
    }
    
    /**
     * Verifica se a cota limite de memoria já foi ultrapassada, ou seja,
     * ja foi antigida.
     * 
     * @return verdadeiro se já foi ultrapassada e falso caso contrario.
     */
    public boolean atingiuCota(){
        if (espacoOcupado >= cota){
            return true;
        }
        return false;
    }

    /**
     * Retorna uma string que representa a conta de um laboratório. 
     * A apresentação segue o formato 
     * nome do laboratório, espaco ocupado e a cota limite de memoria.
     * 
     * @return representação em string da conta 
     */
    public String toString() {
        return nomeLaboratorio + " " + espacoOcupado + "/" + cota;
    }
    
    
}
