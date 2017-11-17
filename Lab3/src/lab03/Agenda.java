package lab03;

/**
 *
 * @author joaomfsj
 */
public class Agenda {
    private Contato contatos[];
    private int numeroContatos;
    public Agenda(){
        this.contatos = new Contato[100];
        this.numeroContatos = 0;
    }

    public int getNumeroContatos() {
        return this.numeroContatos;
    }
    
    
    private void testaNome(String nome, String sobrenome){
        if(nome == null || sobrenome == null) throw new NullPointerException();
        if(nome == "" || sobrenome == "") throw new IllegalArgumentException();
        int cont = 0;
        for(int i = 0; i < nome.length(); i++){
            if(nome.charAt(i) == ' ') cont++;
        }
        if(cont == nome.length()) throw new IllegalArgumentException();
    }
    public boolean cadastrarContatos(int posicao, String nome, String sobrenome, String telefone){
        testaNome(nome, sobrenome);
        if(posicao < 1 || posicao > 100) return false;
        this.contatos[--posicao] = new Contato(nome, sobrenome, telefone);
        return true;
    }
    
    public String pesquisarContato(int posicao){
        if(contatos[posicao - 1] == null){
            return "POSIÇÃO INVÁLIDA";
        }
        return contatos[posicao-1].toString();
    }
    
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
