package lab03;

/**
 *
 * @author joaomfsj
 */
public class Agenda {
    private Contato contatos[];
    
    public Agenda(){
        this.contatos = new Contato[100];
    }
    
    public boolean cadastrarContatos(int posicao, String nome, String telefone){
        if(posicao < 1 || posicao > 100) return false;
        this.contatos[--posicao] = new Contato(nome, telefone);
        return true;
    }
    
    public String pesquisarContato(int posicao){
        if(contatos[posicao-1]==null) return "POSIÇÃO INVÁLIDA";
        return contatos[posicao-1].toString();
    }
    
    public String listarContatos(){
        String retorno = "";
        for(int i = 0; i < 100; i++){
            if(contatos[i]!=null){
                retorno+= i+1 + " - " + contatos[i].toString() + "\n";
            }
        }
        return retorno;
    }
}
