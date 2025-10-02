//Matthew Herzog William Harry

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class mst {

	//Uses kruskals algorythm to return the edges need to connect every node in the minimum hops
	public void kruskalsAlgorithm(Graph graph) {
		
		HashSet<Edge> mst = new HashSet<Edge>();
		HashMap<String, Integer> ccm= new HashMap<>();
		
		int l = 1;
		for(String s : graph.getAdjList().keySet()) {
			ccm.put(s, l);
			l++;
		}
		
		
		
		PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
		for(Edge edge: graph.getEdges()) {
			edgeQueue.add(edge);
		}
		
		
		
		while(!edgeQueue.isEmpty()) {
			Edge check = edgeQueue.poll();
			
			if(ccm.get(check.getVertices()[0]) != ccm.get(check.getVertices()[1])) {
				
				
				mst.add(check);
			
				int newMarker = ccm.get(check.getVertices()[0]);
				int oldMarker = ccm.get(check.getVertices()[1]);
				
				for(String s : graph.getAdjList().keySet()) {
					if(ccm.get(s).equals(oldMarker)) {
						ccm.put(s, newMarker);
					}
				}
			}
		}
		
		System.out.println("Edges in MST:");
		System.out.println("---------------------");
		
		int num = 1;
		for(Edge edge: mst) {
			System.out.println(num + ": " + edge);
			num++;
		}
		
		System.out.println("");
		System.out.println("List of movies for all actors:");
		System.out.println("---------------------");
		
		int num2 = 1;
		LinkedList<String> movies = new LinkedList<>();
		for(Edge edge: mst) {
			if(!movies.contains(edge.getMovie())) {
				System.out.println(num2 + ": " + edge.getMovie());
				movies.add(edge.getMovie());
				num2++;
			}
			
		}
		
		System.out.println("");
		
	}
	
	
}