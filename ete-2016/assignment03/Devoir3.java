/**
 * 
 * @author Teodora DAN
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Devoir3 {
	
	private static int n;				//number of nodes in the graphs
	private static int e;				//number of edges in the graph
	private static int Neighbors[][];	//graph representation: Neighbors[i] holds i's neighbors in no particular order
	private static double Weighs[][];	/*graph representation: Weighs[i][j] holds the weigh of 
										the edge (i,Neighbors[i][j])*/
	private static int noOfNeighbors[];	//number of neighbors of each node in the graph
	
	private static TableElement T[];	//table used by Prim 
	
	
	
	public static void main(String args[]){
		
		//readData("data.in");
		readData("data2.in");
		//get the time in miliseconds
		long ns1 = System.nanoTime();
		Prim();
		long ns2 = System.nanoTime();
		System.out.println("Number of miliseconds " + ((double)(ns2 - ns1)/1000000.0));
		
		//print the tree
		double cost = 0;
		for (int i = 0; i < n; i++) {
			if (T[i].getParent()!=-1){
				cost += T[i].getDistance();
				System.out.println(T[i].getParent() + " " +i);
			}
		}		
		System.out.println("Total cost " + cost);
		
	
		
		//get the time in miliseconds
		ns1 = System.nanoTime();
		HeapPrim();
		ns2 = System.nanoTime();
		System.out.println("Number of miliseconds " + ((double)(ns2 - ns1)/1000000.0));
		
		//print the tree
		cost = 0;
		for (int i = 0; i < n; i++) {
			if (T[i].getParent()!=-1){
				cost += T[i].getDistance();
				System.out.println(T[i].getParent() + " " +i);
			}
		}		
		System.out.println("Total cost " + cost);
		
	}
	
	
	
	
	
	/**
	 * implement Prim's Algorithm without a heap
	 */
	private static void Prim(){
		int v;

		//initialize T; initially, all nodes are at infinite distance, and have no parent(-1) 
		T = new TableElement[n];
		for (int i = 0; i<n; i++){
			T[i] = new TableElement(0, Double.MAX_VALUE/2, -1);
		}
		//choose any node as root, and set its distance to 0
		T[0].setDistance(0);
		
		for (int step = 0; step<n; step++){
			/**
			 * INSERT YOUR CODE HERE
			 * 	find the node v, non-visited that has the minimum distance in T
			 *  visit node v
			 *  update the distance for its neighbors
			 */
				
		}
		
	}
	
	
	/**
	 * implement Prim's Algorithm using a heap
	 */
	private static void HeapPrim(){
		Heap heap;
		int v;
		
		//create a heap of size equal to the number of edges
		heap = new Heap(e);
		//initialize T; initially, all nodes are at infinite distance, and have no parent(-1) 
		T = new TableElement[n];
		for (int i = 0; i<n; i++){
			T[i] = new TableElement(0, Double.MAX_VALUE/2, -1);
		}
		//choose any node as root, and set its distance to 0, then add it to the heap
		T[0].setDistance(0);
		heap.insert(new HeapElement(0,0));
		
		
		for (int step = 0; step<n; step++){
			/**
			 * INSERT YOUR CODE HERE
			 * 	find the node v,having the highest priority in the heap
			 *  - if v is already visited, simply discard it 
			 *  - otherwise - visit node v
			 *  			- update the distance for its neighbors
			 *  			- add the updated neighbors to the heap
			 *  			
			 */
			
		}
		
	}
	
	
	
	
	
	
	
	/**
	 * read the data from the input file and populate the graph
	 */
	public static void readData(String filename ){
		String line;
		
		BufferedReader br;
		try {
			//read the number of nodes
			br = new BufferedReader(new FileReader(filename));
			if ((line = br.readLine()) != null){
				n = Integer.parseInt(line);
			}
			//initialize the graph
			Neighbors = new int[n][n];
			Weighs = new double[n][n];
			noOfNeighbors = new int[n];
			
			while ((line = br.readLine()) != null) {
				String[] v = line.split(" ");
				int node1 = Integer.parseInt(v[0]);
				int node2 = Integer.parseInt(v[1]);
				double weigh = Double.parseDouble(v[2]);
				e++;
				//add node2 to the list of neighbours of node1
				Neighbors[node1][noOfNeighbors[node1]] = node2;
				Weighs[node1][noOfNeighbors[node1]] = weigh;
				noOfNeighbors[node1]++;
				
				//do the same for node2
				Neighbors[node2][noOfNeighbors[node2]] = node1;
				Weighs[node2][noOfNeighbors[node2]] = weigh;
				noOfNeighbors[node2]++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
