package lab05;

import java.util.Comparator;

public class OrdenaPorAposta implements Comparator<Cenario>{
	
	public int compare(Cenario c1, Cenario c2) {
		if(c1.getNumeroAposta() < c2.getNumeroAposta()) {
			return -1;
		}else if(c1.getNumeroAposta() > c2.getNumeroAposta()) {
			return 1;
		}else {
			return c1.compareTo(c2);
		}
	}

}
