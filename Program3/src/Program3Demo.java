//Matthew Herzog William Harry

import java.util.LinkedList;
import java.util.Scanner;

public class Program3Demo {

	public static void main(String[] args) {

		Graph g = new Graph("actors.txt");
		try (Scanner input = new Scanner(System.in)) {
			boolean exit = false;
			
			while(!exit) {
				
				
				System.out.println("Enter your choice:");
				System.out.println("1. Print out MST Information");
				System.out.println("2. Find Shortest Path from one Actor to another");
				System.out.println("3. Find the average number of actors listed in each movie");
				System.out.println("4. Exit");
				System.out.println();
				int i = input.nextInt();
				if(i==1) {
					mst min = new mst();
					min.kruskalsAlgorithm(g);
				}
				else if(i==2) {
					try (Scanner input2 = new Scanner(System.in)) {
						System.out.println("Enter first actor:");
						String a1 = input2.nextLine();
						System.out.println("Enter second actor:");
						String a2 = input2.nextLine();
						
						
						ShortestPath sp = new ShortestPath();
						sp.computeShortestPath(g, a1); // compute dystrachs algorithm
						LinkedList<Edge> shortestPath=  sp.getPathTo(a2);
						
						if(shortestPath!=null) {
							int count = 0;
							for(Edge e: shortestPath) {
								count++;
						    	System.out.println(e);
						    }
							System.out.println("Number of hops: " + count);
							System.out.println();
						}
						else {
							System.out.println("No Path Exists");
						}
					}
				}
				else if(i==3) {
					System.out.println("Average number of actors in all movies: " + g.averageActors("actors.txt"));
					System.out.println("");
				}
				else  {
					exit = true;
				}
				
				
				
			}
		}
	}

}
