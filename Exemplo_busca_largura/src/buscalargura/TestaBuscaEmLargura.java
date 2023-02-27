package buscalargura;

import java.io.*;

public class TestaBuscaEmLargura {
  static BufferedReader in = new BufferedReader (
                             new InputStreamReader (System.in));
  public static Grafo.Aresta lerAresta () throws Exception {
    System.out.println ("Aresta:");
    System.out.print ("  V1:");
    int v1 = Integer.parseInt (in.readLine());
    System.out.print ("  V2:");
    int v2 = Integer.parseInt (in.readLine());
    System.out.print ("  Peso:");
    int peso = Integer.parseInt (in.readLine());
    return new Grafo.Aresta (v1, v2, peso);
  }
  public static void main (String[] args) throws Exception {
    System.out.print ("No. vertices:"); 
    int nVertices = Integer.parseInt (in.readLine());
    System.out.print ("No. arestas:"); 
    int nArestas = Integer.parseInt (in.readLine());
    Grafo grafo = new Grafo (nVertices);
    for (int i = 0; i < nArestas; i++) {
      Grafo.Aresta a = lerAresta ();
      // @{\it Duas chamadas porque o grafo \'e n\~ao direcionado}@
      grafo.insereAresta (a.v1 (), a.v2 (), a.peso ());     
      grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
    }
    System.out.println ();
    grafo.imprime ();
    System.out.println ();
    BuscaEmLargura bfs = new BuscaEmLargura (grafo);
    bfs.buscaEmLargura ();
    for (int v = 0; v < grafo.numVertices(); v++) {
      System.out.println ("d["+v+"]:" + bfs.d (v) + " -- antecessor["+v+"]:" + bfs.antecessor (v));      
    }
    System.out.println ();
    bfs.imprimeCaminho (0, 3);
  }
}
