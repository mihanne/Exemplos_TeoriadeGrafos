/**
 * File name:Solucao.java
 * Package name: br.fumec.caixeiro.viajante.algoritmo
 * Project name: CaixeiroViajante
 */
package br.fumec.caixeiro.viajante.algoritmo;

import java.util.ArrayList;

public class Solucao{
	/** 
	 * Atributes
	 */
	private int distanciaMinima;
	private ArrayList<Integer> caminho;
	
	/**
	 * Constructor: Solucao
	 */
	public Solucao() {
		setDistanciaMinima(0);
		setCaminho(new ArrayList<Integer>());
	}
	/**
	 * Constructor: Solution
	 */
	public Solucao(ArrayList<Integer> caminho, int distanciaMinima) {
		setDistanciaMinima(distanciaMinima);
		setCaminho(caminho);
	}
	/**
	 * toS
	 */
	public String toS() {
		String toS = "";
		toS += "Distância Mínima: " + distanciaMinima;
		toS += "\nCaminho: ";
		for(int i = 0; i < caminho.size(); i++) {
			if(i < caminho.size()-1)
				toS += (caminho.get(i) + 1) + " -> "; 
			else
				toS += (caminho.get(i) + 1);
		}
		return toS;
	}
	/**
	 * @param distanciaMinima setar distancia minima
	 */
	public void setDistanciaMinima(int distanciaMinima) {
		this.distanciaMinima = distanciaMinima;
	}
	/**
	 * incrementarDistancia
	 */
	public void incrementarDistancia(int distancia) {
		distanciaMinima += distancia;
	}
	/**
	 * @param caminho setar o caminho
	 */
	public void setCaminho(ArrayList<Integer> caminho) {
		this.caminho = caminho;
	}
	/**
	 * getTamanhoCaminho
	 */
	public int getTamanhoCaminho() {
		return caminho.size();
	}
	/**
	 * getUltimaCidade
	 */
	public int getUltimaCidade() {
		return caminho.get(caminho.size()-1);
	}
	/**
	 * addCidadeNoCaminho
	 */
	public void addCidadeNoCaminho(int cidade) {
		caminho.add(cidade);
	}
	/**
	 * getCaminho
	 */
	public ArrayList<Integer> getCaminho(){
		return (ArrayList<Integer>) caminho.clone();
	}
	/**
	 * getDistanciaMinima
	 */
	public int getDistanciaMinima() {
		int aux = distanciaMinima;
		return aux;
	}
}