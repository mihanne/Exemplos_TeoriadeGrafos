/**
 * File name:Heuristica.java
 * Package name: br.fumec.caixeiro.viajante.algoritmo
 * Project name: CaixeiroViajante
 */
package br.fumec.caixeiro.viajante.algoritmo;

//import javax.tools.Diagnostic;

import br.fumec.caixeiro.viajante.global.Globals;

public class Heuristica {
	/** 
	 * Atributos
	 */
	private int numeroDeCidades;
	private int numeroDeCidadesPow;
	/**
	 * Constructor: Heuristica
	 */
	public Heuristica() {
		
	}
	/**
	 * Solucao
	 */
	public Solucao solucao(Problema problema) {
		Solucao solucao = new Solucao();
		setNumeroDeCidades(problema.getNumeroDeCidades());
		setNumeroDeCidadesPow((int)Math.pow(2, getNumeroDeCidades()));
		int matrizDP[][] = new int [getNumeroDeCidades()][getNumeroDeCidadesPow()]; 
		int matrizCaminho[][] = new int [getNumeroDeCidades()][getNumeroDeCidadesPow()];
		
		for (int i = 0; i < getNumeroDeCidades(); i++) {
			for (int j = 0; j < getNumeroDeCidadesPow(); j++) {
				matrizDP[i][j] = -1;
				matrizCaminho[i][j] = -1;
			}
		}
		
		for (int i = 0; i < getNumeroDeCidades(); i++) {
			matrizDP[i][0] = problema.getDistancia(i, 0);
		}
		
		solucao.addCidadeNoCaminho(Globals.INICIAR_CIDADE);
		solucao.setDistanciaMinima(algoritmoHeuristica(0, getNumeroDeCidadesPow() - 2, matrizDP, matrizCaminho, problema));
		getCaminho(0, getNumeroDeCidadesPow() - 2, matrizCaminho, solucao);
		solucao.addCidadeNoCaminho(Globals.INICIAR_CIDADE);
		return solucao;
	}
	/**
	 * algoritmoHeuristica
	 */
	public int algoritmoHeuristica(int inicio, int set, int[][]matrizDP, int[][]matrizCaminho, Problema problema) {
		int mascara, marcado, resultado = -1, temp;
		if(matrizDP[inicio][set] != -1)
			return matrizDP[inicio][set];
		else {
			for (int i = 0; i < getNumeroDeCidades(); i++) {
				mascara = getNumeroDeCidadesPow() - 1 - (int) Math.pow(2, i);
				marcado = set & mascara;
				if(marcado != set) {
					temp = problema.getDistancia(inicio, i) + algoritmoHeuristica(i, marcado, matrizDP, matrizCaminho, problema);
					if(resultado == -1 || resultado > temp) {
						resultado = temp;
						matrizCaminho[inicio][set] = i;
					}
				}
			}
			matrizDP[inicio][set] = resultado;
			return resultado;
		}
	}
	/**
	 * getPath
	 */
	public void getCaminho(int start, int set, int[][]matrizCaminho, Solucao solucao) {
		if(matrizCaminho[start][set] == -1)
			return;
		int x = matrizCaminho[start][set];
		int mascara = getNumeroDeCidadesPow() -1 - (int)Math.pow(2, x);
		int marcado = set & mascara;
		
		solucao.addCidadeNoCaminho(x);
		getCaminho(x, marcado, matrizCaminho, solucao);
	}
	/**
	 * @return numeroDeCidades
	 */
	public int getNumeroDeCidades() {
		int aux = numeroDeCidades;
		return aux;
	}
	/**
	 * @param numeroDeCidades setar numeroDeCidades
	 */
	public void setNumeroDeCidades(int numeroDeCidades) {
		this.numeroDeCidades = numeroDeCidades;
	}
	/**
	 * @return numeroDeCidadesPow
	 */
	public int getNumeroDeCidadesPow() {
		int aux = numeroDeCidadesPow;
		return aux;
	}
	/**
	 * @param numeroDeCidadesPow setar numeroDeCidadesPow
	 */
	public void setNumeroDeCidadesPow(int numeroDeCidadesPow) {
		this.numeroDeCidadesPow = numeroDeCidadesPow;
	}
}
