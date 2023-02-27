package caixeiroviajante;
//import required classes and packages
//fonte; https://www.javatpoint.com/travelling-salesman-problem-in-java

import java.io.*;   
import java.util.Scanner;  

//create TSPExample class to implement TSP code in Java  
class TSPExample   
{  
 // create findHamiltonianCycle() method to get minimum weighted cycle   
 static int findHamiltonianCycle(int[][] distance, boolean[] visitCity, int currPos, int cities, int count, int cost, int hamiltonianCycle)   
 {  
 
     if (count == cities && distance[currPos][0] > 0)   
     {  
         hamiltonianCycle = Math.min(hamiltonianCycle, cost + distance[currPos][0]);  
         return hamiltonianCycle;  
     }  
 
     // BACKTRACKING STEP  
     for (int i = 0; i < cities; i++)   
     {  
         if (visitCity[i] == false && distance[currPos][i] > 0)   
         {  
        	 
             // Mark as visited  
             visitCity[i] = true;  
             System.out.println(i+1);
             hamiltonianCycle = findHamiltonianCycle(distance, visitCity, i, cities, count + 1, cost + distance[currPos][i], hamiltonianCycle);  
          
             // Mark ith node as unvisited  
             visitCity[i] = false;  
         }  
     }  
     return hamiltonianCycle;  
 }  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cities;  
        
        //create scanner class object to get input from user  
        Scanner sc = new Scanner(System.in);  
          
        // get total number of cities from the user  
        System.out.println("Enter total number of cities ");  
        cities = sc.nextInt();  
          
          
        //get distance of cities from the user  
        int distance[][] = new int[cities][cities];  
        for( int i = 0; i < cities; i++){  
            for( int j = 0; j < cities; j++){  
                System.out.println("Distance from city"+ (i+1) +" to city"+ (j+1) +": ");  
                distance[i][j] = sc.nextInt();  
            }  
        }  
    
        // create an array of type boolean to check if a node has been visited or not  
        boolean[] visitCity = new boolean[cities];  
    
        // by default, we make the first city visited  
        visitCity[0] = true;  
          
          
        int hamiltonianCycle = Integer.MAX_VALUE;  
        System.out.println("Caminho das cidades");
    
        // call findHamiltonianCycle() method that returns the minimum weight Hamiltonian Cycle  
        hamiltonianCycle = findHamiltonianCycle(distance, visitCity, 0, cities, 1, 0, hamiltonianCycle);  
        // print the minimum weighted Hamiltonian Cycle 
        System.out.println("Dit�ncia Total");
        System.out.println(hamiltonianCycle);
	}

}
