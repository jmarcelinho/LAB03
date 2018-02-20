package lab05;

import java.util.Comparator;
public class OrdenaPorNome implements Comparator<Cenario>{
	
	public int compare(Cenario c1, Cenario c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}
