package lab05;

import java.util.ArrayList;

public class ControllerAposta {
	private ArrayList <Aposta> apostas;
	private int idSeguro;
	
	public ControllerAposta() {
		this.apostas = new ArrayList<>();
		this.idSeguro = 0;
	}
	
	/**
	 * Cadastra apostas no cenario.
	 * Uma aposta eh cadastrada a partir do nome de um 
	 * apostador, o valor da aposta, previsao para aposta
	 *  e o numero do cenario.
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor da aposta.
	 * @param previsao previsao da aposta.
	 * @param cenario cenario qual vai ser cadastrada a aposta.
	 */
	public void cadastrarAposta(int cenario, String nomeApostador, double valorAposta, String previsao) {
		apostas.add(new Aposta(cenario, nomeApostador, valorAposta, previsao));
	}
	
	public int cadastrarAposta(int cenario, String nomeApostador, double valorAposta, String previsao, int valor) {
		apostas.add(new Aposta(cenario, nomeApostador, valorAposta, previsao, valor, ++idSeguro));
		return this.idSeguro;
	}
	
	public int cadastrarAposta(int cenario, String nomeApostador, double valorAposta, String previsao, double taxa) {
		apostas.add(new Aposta(cenario, nomeApostador, valorAposta, previsao, taxa, ++idSeguro));
		return this.idSeguro;
	}
	
	/**
	 * Retorna as representacoes em string das 
	 * apostas cadastradas em um cenario.
	 * 
	 * @param numero do cenario a ser consultado.
	 * @return representacoes em string das apostas no cenario.
	 */
	public String exibeApostas(int cenario) {
		String res = "";
		for(Aposta aposta: apostas) {
			if(aposta.getCenario() == cenario) {
				res += aposta.toString() + "\n"; 
			}
		}
		return res;
	}
	
	/**
	 * Retorna o numero total de apostas cadastradas
	 * em um cenario.
	 * @param cenario numero do cenario a ser consultado.
	 * @return numero de apostas cadastradas em um cenario.
	 */
	public int numeroApostas(int cenario) {
		int cont = 0;
		for(Aposta aposta: apostas) {
			if(aposta.getCenario() == cenario) {
				cont++;
			}
		}
		return cont;
	}
	
	/**
	 * Retorna o valor total de apostas cadastradas
	 * em um cenario.
	 * @param cenario numero do cenario a ser consultado.
	 * @return valor inteiro de apostas cadastradas no cenario.
	 */
	public int valorApostas(int cenario) {
		int valor = 0;
		for(Aposta aposta: apostas) {
			if(aposta.getCenario() == cenario) {
				valor += aposta.getValor();
			}
		}
		return valor; 
	}
	
	/**
	 * Retorna a soma de todas as apostas perdedoras.
	 * 
	 * @param cenario cenario no qual estão cadastradas as apostas.
	 * @param ocorreu booleano que informa se o cenario ocorreu ou nao.
	 * @return soma das apostas perdedoras.
	 */
	public int getSomaPerdedoras(int cenario, boolean ocorreu) {
		int soma = 0;
		if(ocorreu) {
			for(Aposta aposta: apostas) { 
				if(aposta.getCenario() == cenario) { //aposta perdedoras sao as que nao ocorreram
					if(!aposta.getPrevisaoAposta())
						soma += aposta.getValor();
				}
			}
		}else{
			for(Aposta aposta: apostas) { 
				if(aposta.getCenario()==cenario) { //aposta perdedoras sao as que nao ocorreram
					if(aposta.getPrevisaoAposta()) {
						soma += aposta.getValor();
					}
				}
			}
		}
		return soma;
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		for(Aposta aposta: apostas) {
			if(aposta.getCenario() == cenario) {
				if(aposta.getIdTipo() == apostaAssegurada) {
					return aposta.alteraTipoValor(valor);
					//return aposta.getIdTipo();
				}
			}
		}
		return 0;
	}
	
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		for(Aposta aposta: apostas) {
			if(aposta.getCenario() == cenario) {
				if(aposta.getIdTipo() == apostaAssegurada) {
					return aposta.alteraTipoTaxa(taxa);
				}
			}
		}
		return 0;
	}
	
}
