//Matthew Herzog William Harry

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	//Maps the actor to all of their connected actors and what movie connects them
	private HashMap<String, LinkedList<Edge>> adjList;
	
	//store all edges of graph-- no duplicate edges
	private HashSet<Edge> edges;
	
	
	//Graph takes in the input file, splits into a hash map that maps movies to the actors in each movie
	//Then it turns movies to actors into our adjLista and edges
	public Graph(String textFile) {
		
		//Linked List of all actors to movies
		HashMap<String,LinkedList<String>> mta = new HashMap<>();
		
		edges = new HashSet<Edge>();
		adjList = new HashMap<String, LinkedList<Edge>>();
		
		
		try {
		
			Scanner input = new Scanner(new FileReader(textFile));
			while(input.hasNext()) {
				String line = input.nextLine();
				
				String[] vals = line.split("\\|");
				String actor = vals[0];
				String movie = vals[1];
				
				//Initializing adjList with empty LinkedLists
				if(!adjList.containsKey(actor)) {
					adjList.put(actor, new LinkedList<Edge>());
				}
				
				
				LinkedList<String> temp;
				if(mta.containsKey(movie)) {
					temp = mta.get(movie);
				}
				else {
					temp = new LinkedList<String>();
				}
				temp.add(actor);
				mta.put(movie, temp);
				
				
				
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		//turning mta into edges
		for(String movie: mta.keySet()) {
		    LinkedList<String> actors = mta.get(movie);
		    for(String actor1: actors) {
		        for(String actor2: actors) {
		            if(!actor1.equals(actor2)) {
		                Edge e = new Edge(actor1, actor2, movie);
		                edges.add(e);

		                // Ensure both actors have an adjacency list
		                adjList.putIfAbsent(actor1, new LinkedList<>());
		                adjList.putIfAbsent(actor2, new LinkedList<>());

		                // Add edge to actor1's adjacency list
		                adjList.get(actor1).add(e);
		            }
		        }
		    }
		}
		
		
		
	}
	
	
	//Prints graph
	public void printGraph() {
		for(String s : adjList.keySet()) {
			System.out.println(s + ": " + adjList.get(s));
		}
	}
	
	
	//computes the average number of actors per movie for a given set of data
	public Double averageActors(String textFile) {
		Double num = 0.0;
		Double val = 0.0;
		HashMap<String,Integer> mtn = new HashMap<>();
		
		try {
			
			Scanner input = new Scanner(new FileReader(textFile));
			while(input.hasNext()) {
				String line = input.nextLine();
				
				String[] vals = line.split("\\|");
				String actor = vals[0];
				String movie = vals[1];
				
				
				if(!mtn.containsKey(movie)) {
					mtn.put(movie, 1);
				}
				else {
					mtn.put(movie, mtn.get(movie)+1);
				}
			}
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
		for(String s: mtn.keySet()) {
			num += 1;
			val += mtn.get(s);
		}
		
		return val/num;
				
	}
	
	//Returns edges
	public HashSet<Edge> getEdges(){
		return edges;
	}

	//returns all adjacent edges to a given vertex
	public LinkedList<Edge> getAdjEdges(String vertex){
		return adjList.get(vertex);
	}


	//returns the adjacency list
	public HashMap<String, LinkedList<Edge>> getAdjList() {
		// TODO Auto-generated method stub
		return adjList;
	}
}