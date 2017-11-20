package lab03;

import java.util.Arrays;

/**
 * Representação de uma agenda de contatos.
 * A agenda tem uma capacidade máxima de 100 contatos,
 * porém é possível sobreescrever um contato antigo.
 * A agenda permite cadastrar novos contatos, pesquisar
 * e listar todos os contatos salvos.
 * 
 * @author Joao Marcelo
 */
public class Agenda {
    
    private Contato contatos[];
    private int numeroContatos;
    
    /**
     * Constrói uma agenda sem nenhum contato salvo.
     */
    public Agenda(){
        this.contatos = new Contato[100];
        this.numeroContatos = 0;
    }
    
    /**
     * Retorna o numero de contatos salvos na agenda.
     * @return numero de contatos
     */
    public int getNumeroContatos() {
        return this.numeroContatos;
    }
    
    /**
     * Cadastra um contato na agenda.
     * O cadastro é realizado em uma posição da agenda e para
     * o cadastro é necessário um nome, sobrenome e um numero de telefone.
     * A posição de um contato na agenda precisa tá no intervalo entre 1 e 100.
     * O nome e sobrenome não pode ser strings vazias.
     * 
     * Retorna True se o cadastro foi realizado e falso
     * caso contrário.
     * 
     * @param posicao posicao do contato na agenda
     * @param nome nome do contato
     * @param sobrenome sobrenome do contato
     * @param telefone telefone do contato
     * @return true ou false
     */
    public boolean cadastrarContatos(int posicao, String nome, String sobrenome, String telefone){
        if(posicao < 1 || posicao > 100) return false;
        this.contatos[--posicao] = new Contato(nome, sobrenome, telefone);
        return true;
    }
    
    /**
     * Pesquisa retorna a representação de um contato na agenda.
     * A pesquisa é realizada pela posição do contato na agenda
     * @param posicao posicao do contato na agenda
     * @return representação em string do contato pesquisado
     */
    public String pesquisarContato(int posicao){
        if(posicao < 1 || posicao > 100) return "POSIÇÃO INVÁLIDA";
        if(contatos[posicao - 1] == null){
            return "POSIÇÃO INVÁLIDA";
        }
        return contatos[posicao-1].toString();
    }
        
    /**
     * Lista todos os contatos salvos na agenda.
     * Retorna como string a lista de contatos.
     * @return string representando uma lista de contatos
     */
    public String listarContatos(){
        String retorno = "";
        for(int i = 0; i < 100; i++){
            if(contatos[i] != null){
                retorno += i+1 + " - " + contatos[i].toString() + "\n";
            }
        }
        return retorno;
    }
    
    /**
     * Verifica se dois objetos do tipo agenda são iguais.
     * Duas Agendas são consideradas iguais se tiverem os mesmos contatos
     * nas mesmas posições.
     * 
     * Retorna true caso forem iguais e false caso contrário.
     * 
     * @param obj objeto a ser comparado
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
        final Agenda other = (Agenda) obj;
        
        //metódo deepEquals retorna verdadeiro se um par de elemento
        //nos dois arrays são profundamentes iguais.
        if (!Arrays.deepEquals(this.contatos, other.contatos)) {
            return false;
        }
        return true;
    }
}


