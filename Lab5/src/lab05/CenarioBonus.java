package lab05;

public class CenarioBonus extends Cenario{
	private int bonus;
	
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		this.bonus = bonus;
	}
	
	/**
	 * Retorna a soma de todas as apostas perdedoras.
	 * @return soma das apostas perdedoras.
	 */
	@Override
	public int getSomaPerdedoras() {
		if(this.estado.equals(Estado.NAO_FINALIZADO))
			return -1;
		if(this.estado.equals(Estado.FINALIZADO_OCORREU)) {
			return (int)soma_nao_ocorre + bonus;
		}
		return (int)soma_ocorre + bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.bonus;
	}
}
