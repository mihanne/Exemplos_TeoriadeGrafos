package br.fumec.caixeiro.viajante.global;

/**
 * File name:Arquivo.java
 * Package name: br.fumec.caixeiro.viajante.global
 * Project name: CaixeiroViajante
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
	/** 
	 * Atributes
	 */
	private int numeroDeCidades;
	private ArrayList<ArrayList<Integer>> distancias;
	
	/**
	 * Constructor: ReadInputFile
	 */
	public Arquivo(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = "";
			boolean correctFormat = true;
			parseNumeroDeCidades(br.readLine());
			distancias = new ArrayList<>();
			for(int i = 0; i < numeroDeCidades; i++) {
				distancias.add(new ArrayList<Integer>());
				for(int j = 0; j < numeroDeCidades; j++) {
					distancias.get(i).add(0);					
				}
			}
			while((line = br.readLine()) != null && correctFormat) {
				correctFormat = parseDistancias(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * parseNumeroDeCidades
	 */
	public boolean parseNumeroDeCidades(String primeiraLinha) {
		numeroDeCidades = Integer.parseInt(primeiraLinha);
		return true;
	}
	/**
	 * parseDistancias
	 */
	public boolean parseDistancias(String line) {
		String[] distanciaText = line.split(" ");
		int[] distancia = new int[distanciaText.length];		
		for(int i = 0; i < distancia.length; i++)
			distancia[i] = Integer.parseInt(distanciaText[i]);
		
		if(distancia.length != 3) {
			System.out.println("Erro nos dados de entrada.");
			return false;
		}else {
			distancias.get(distancia[0] - 1).set(distancia[1] - 1, distancia[2]);
			distancias.get(distancia[1] - 1).set(distancia[0] - 1, distancia[2]);
			return true;
		}
	}
	/**
	 * @return the getNumeroDeCidades
	 */
	public int getNumeroDeCidades() {
		return numeroDeCidades;
	}
	/**
	 * @return distancias
	 */
	public ArrayList<ArrayList<Integer>> getDistancias() {
		return distancias;
	}
}
