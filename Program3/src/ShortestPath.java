//Matthew Herzog William Harry

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPath{
	//should be hash maps for program 3
	private HashMap<String,Integer> distance; 
	private HashMap<String,Edge> previous;
	
	//computes the shortest path between 
	public Integer computeShortestPath(Graph graph, String start) {
		// TODO Auto-generated method stub
		
		distance = new HashMap<String,Integer>();
		for(String s: graph.getAdjList().keySet()) {
			distance.put(s, Integer.MAX_VALUE);
		}
		distance.put(start, 0);
		previous = new HashMap<String,Edge>();
		PriorityQueue<PriorityVertex> visitQueue = new PriorityQueue<>();
		visitQueue.add(new PriorityVertex(start, 0));
		
		while(!visitQueue.isEmpty()) {
			
			PriorityVertex vertex = visitQueue.poll();
			
			for(Edge edge: graph.getAdjEdges(vertex.getVertex())) {
				String neigbor = edge.getTo();
				if(distance.get(vertex.getVertex()) + 1 < distance.get(neigbor)) {
					// found new best estimant, need to update 
					distance.put(neigbor, distance.get(vertex.getVertex())+1);
					previous.put(neigbor, edge);
					
					visitQueue.remove(new PriorityVertex(neigbor, 0));
					visitQueue.add(new PriorityVertex(neigbor, distance.get(neigbor)));
				}
			}
		}
		return distance.get(visitQueue);
		
	}

	public LinkedList<Edge> getPathTo(String destination) {
		
		if(!hasPath(destination)) {
			System.out.println("No Path");
			return null;
		}
		else {
			LinkedList<Edge> solution = new LinkedList<Edge>();
			
			for(Edge edge = previous.get(destination); edge != null; edge = previous.get(edge.getFrom())) {
				solution.addFirst(edge);
			} 
			return solution;
		}
		
		


	}

	private boolean hasPath(String destination) {
			boolean x = distance.get(destination) < Integer.MAX_VALUE;
				
			return x;
		
	}

	
}

