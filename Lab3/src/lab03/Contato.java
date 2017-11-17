package lab03;


/**
 * Classe que representa um contato.
 * Um contato é composto de um nome, sobrenome e numero de telefone.
 * @author Joao Marcelo
 */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    
    /**
     * Constrói um contato a partir do nome, sobrenome e numero 
     * de telefone.
     * 
     * @param nome o nome do contato
     * @param sobrenome o sobrenome do contato
     * @param telefone numero de telefone
     */
    public Contato(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    
    /**
     * Retorna o nome do contato.
     * @return nome do contato
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o sobrenome do contato.
     * @return sobrenome do contato.
     */
    public String getSobrenome() {
        return sobrenome;
    }
    
    /**
     * Retorna o numero telefone do conato
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }
    
    /**
     * Retorna um string que representa um contato.
     * A representação segue o formato
     * nome sobrenome - telefone
     * @return representação em string do contato
     */
    public String toString(){
        return nome + " " + sobrenome + " - " + telefone;
    }
}
