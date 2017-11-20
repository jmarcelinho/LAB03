package lab03;

import java.util.Objects;


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
        testaNome(nome, sobrenome);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    
    /**
     * Verifica se um nome e sobrenome são válidos.
     * Um nome e sobrenome são válidos se não forem strings vazias ou 
     * compostas apenas por espaços em branco.
     * 
     * @param nome nome do um contato
     * @param sobrenome sobrenome de um contato
     */
    private void testaNome(String nome, String sobrenome){
        if(nome == null || sobrenome == null) throw new NullPointerException();
        if(nome.trim().equals("") || sobrenome.trim().equals("")) throw new IllegalArgumentException();
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
     * Verifica se dois contatos são iguais.
     * 
     * Dois contatos são considerados iguais se 
     * possuirem o mesmo nome.
     * 
     * A função retorna true se forem iguais e falso
     * caso contrario.
     * 
     * @param obj Objeto a ser comparado
     * @return true ou false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        return true;
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
