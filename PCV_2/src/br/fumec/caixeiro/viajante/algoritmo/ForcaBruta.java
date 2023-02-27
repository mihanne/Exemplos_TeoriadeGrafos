/**
 * File name:ForcaBruta.java
 * Package name: br.fumec.caixeiro.viajante.algoritmo
 * Project name: CaixeiroViajante
 */
package br.fumec.caixeiro.viajante.algoritmo;

import java.util.ArrayList;

import br.fumec.caixeiro.viajante.global.Globals;

public class ForcaBruta {
	/** 
	 * Atributos
	 */
	private Solucao solucaoAtual;
	/**
	 * Constructor: ForcaBruta
	 */
	public ForcaBruta() {
		
	}
	/**
	 * Solucao
	 */
	public Solucao solucao(Problema problema, Solucao solucaoInicial) {
		setSolucaoAtual(solucaoInicial);
		ArrayList<Integer> caminhoInicial = new ArrayList<>();
		caminhoInicial.add(Globals.INICIAR_CIDADE);
		Solucao subSolucao = new Solucao(caminhoInicial, 0);
		algoritmoForcaBruta(problema, subSolucao);
		return solucaoAtual;
	}
	/**
	 * algoritmoForcaBruta
	 */
	public void algoritmoForcaBruta(Problema problema, Solucao subSolucao) {
		if(subSolucao.getTamanhoCaminho() == problema.getNumeroDeCidades()) {
			subSolucao.incrementarDistancia(problema.getDistancia(subSolucao.getUltimaCidade(), 0));
			if(subSolucao.getDistanciaMinima() < solucaoAtual.getDistanciaMinima()) {
				subSolucao.addCidadeNoCaminho(0);
				setSolucaoAtual(subSolucao);
			}
		}else {
			for(int i = 0; i < problema.getNumeroDeCidades(); i++) {
				if(!subSolucao.getCaminho().contains(i)) {
					int increasedDistance = subSolucao.getDistanciaMinima() + problema.getDistancia(subSolucao.getUltimaCidade(), i);
					ArrayList<Integer> incrementarCaminho = (ArrayList<Integer>) subSolucao.getCaminho().clone();
					incrementarCaminho.add(i);
					Solucao incrementarSolucao = new Solucao(incrementarCaminho, increasedDistance);
					algoritmoForcaBruta(problema, incrementarSolucao);
				}
			}
		}
	}
	/**
	 * @param solucaoAtual the solucaoAtual to set
	 */
	public void setSolucaoAtual(Solucao solucaoAtual) {
		this.solucaoAtual = solucaoAtual;
	}
	
}
