package br.fumec.caixeiro.viajante.algoritmo;

/**
 * File name:AlgoritmoGuloso.java
 * Package name: br.fumec.caixeiro.viajante.algoritmo
 * Project name: CaixeiroViajante
 */

import java.util.ArrayList;

import br.fumec.caixeiro.viajante.global.Globals;

public class AlgoritmoGuloso {
	/**
	 * Constructor: AlgoritmoGuloso
	 */
	public AlgoritmoGuloso() {
		
	}
	/**
	 * Solucao
	 */
	public Solucao solucao(Problema problema) {
		Solucao solucao = new Solucao();
		ArrayList<Integer> caminho = new ArrayList<>();
		int distanciaTotal = 0;
		int cidadeAtual = Globals.INICIAR_CIDADE;
		caminho.add(cidadeAtual);//coloca no caminho a primeira cidade
		int cidadeMaisProxima = cidadeAtual;
		int distanciaMinima = Integer.MAX_VALUE;
		//build the final path
		while(caminho.size() < problema.getNumeroDeCidades()) {
			for(int i = 0; i < problema.getNumeroDeCidades(); i++) {
				if(i != cidadeAtual && !caminho.contains(i)) {//se nao e a cidade atual, nao adiciona no caminho
					if(problema.getDistancia(cidadeAtual, i) < distanciaMinima) {//pega a cidade mais proxima
						distanciaMinima = problema.getDistancia(cidadeAtual, i);
						cidadeMaisProxima = i;
					}
				}
			}
			//atualiza os valores
			caminho.add(cidadeMaisProxima);
			distanciaTotal += distanciaMinima;
			cidadeAtual = cidadeMaisProxima;
			distanciaMinima = Integer.MAX_VALUE;
		}
		//fecha o caminho
		distanciaTotal += problema.getDistancia(caminho.get(caminho.size() - 1), 0);
		caminho.add(caminho.get(0));
		//constroi a solucao
		solucao.setCaminho(caminho);
		solucao.setDistanciaMinima(distanciaTotal);
		return solucao;
	}
}
