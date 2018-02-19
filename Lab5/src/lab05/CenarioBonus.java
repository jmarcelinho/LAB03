package lab05;

public class CenarioBonus extends Cenario{
	private double bonus;
	
	public CenarioBonus(int id, String descricao, int bonus) {
		super(id, descricao);
		if(bonus<=0)
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		this.bonus = bonus;
	}
	
	@Override
	public double getSomaPerdedorasRateio() {
		if(this.somaPerdedoras!=-1) {
			return this.somaPerdedoras + this.bonus;
		}
		return this.somaPerdedoras;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " - R$ " + String.format("%.2f", this.bonus/100);
	}
}
