package lab05;

public enum Previsao {
	VAI_ACONTECER("Vai acontecer"), NAO_VAI_ACONTECER("Nao vai acontecer");
	
	private String previsao;
	
	Previsao(String previsao) {
		this.previsao = previsao;
	}
	
	public final  String getPrevisao() {
		return this.previsao;
	}
}
