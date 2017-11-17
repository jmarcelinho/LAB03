package lab03;

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
     * Verifica se um nome e sobrenome são válidos.
     * Um nome e sobrenome são válidos se não forem strings vazias ou 
     * compostas apenas por espaços em branco.
     * 
     * @param nome nome do um contato
     * @param sobrenome sobrenome de um contato
     */
    private void testaNome(String nome, String sobrenome){
        if(nome == null || sobrenome == null) throw new NullPointerException();
        if(nome.equals("") || sobrenome.equals("")) throw new IllegalArgumentException();
        int cont = 0;
        for(int i = 0; i < nome.length(); i++){
            if(nome.charAt(i) == ' ') cont++;
        }
        if(cont == nome.length()) throw new IllegalArgumentException();
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
        testaNome(nome, sobrenome);
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
}
