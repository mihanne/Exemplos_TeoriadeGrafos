package br.fumec.caixeiro.viajante.global;
import java.util.Scanner;

import br.fumec.caixeiro.viajante.algoritmo.ForcaBruta;
import br.fumec.caixeiro.viajante.algoritmo.Heuristica;
import br.fumec.caixeiro.viajante.algoritmo.AlgoritmoGuloso;
import br.fumec.caixeiro.viajante.algoritmo.Problema;
import br.fumec.caixeiro.viajante.algoritmo.Solucao;


public class Main {

	public static void main(String[] args) {
			boolean stop = true;
			System.out.println("\tProblema do Caixeiro Viajante (PCV)\n");
			System.out.println("Informe o caminho completo do arquivo de entrada:");
			
			Scanner userInput = new Scanner(System.in);
			String inputFile = userInput.nextLine().replace("\\", "\\\\");
			Arquivo arquivo = new Arquivo(inputFile);
			
			Problema problema = new Problema(arquivo.getNumeroDeCidades(), arquivo.getDistancias());
			System.out.println("\nInforma��o:\n" + problema.toS());
			
			AlgoritmoGuloso algoritmoGuloso = new AlgoritmoGuloso();
			ForcaBruta forcaBruta = new ForcaBruta();
			Heuristica heuristica = new Heuristica();
			Solucao solucao = new Solucao();
			
			while (stop) {
				System.out.println("\nOp��es:\n1. For�a Bruta.\n2. Algoritmo Guloso.\n3. Heur�stica.\n4. Executar Todos.\n0. Sair");
				switch (userInput.nextInt()) {
				case 1:
					System.out.println("\nFor�a Bruta: ");
					solucao = algoritmoGuloso.solucao(problema);
					solucao = forcaBruta.solucao(problema, solucao);
					System.out.println(solucao.toS());
					break;
				case 2:
					System.out.println("\nAlgoritmo Guloso: ");
					solucao = algoritmoGuloso.solucao(problema);
					System.out.println(solucao.toS());
					break;
				case 3:
					System.out.println("\nHeur�stica: ");
					solucao = heuristica.solucao(problema);
					System.out.println(solucao.toS());
					break;
				case 4:
					System.out.println("\nFor�a Bruta: ");
					solucao = forcaBruta.solucao(problema, solucao);
					System.out.println(solucao.toS());
					System.out.println("\nAlgoritmo Guloso: ");
					solucao = algoritmoGuloso.solucao(problema);
					System.out.println(solucao.toS());
					System.out.println("\nHeur�stica: ");
					solucao = heuristica.solucao(problema);
					System.out.println(solucao.toS());
					break;
				case 0:
					stop = false;
					break;
				default:
					System.out.println("Erro!Escolha uma op��o v�lida.");
					break;
				}
			}
			userInput.close();
		}
}
