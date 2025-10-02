//Matthew Herzog William Harry

public class PriorityVertex implements Comparable<PriorityVertex>{
	private String vertex;
	private int cost;
	
	public PriorityVertex(String v, int d) {
		vertex = v;
		cost = d;
	}
	
	public String getVertex() {
		return vertex;
	}
	
	public double getDistance() {
		return cost;
	}
	
	@Override
	public int compareTo(PriorityVertex other) {
		int num = Integer.valueOf(cost).compareTo(other.cost);
		return num;
	}

	
	
	public boolean equals(Object o) {
		if(!(o instanceof PriorityVertex)) {
			return false;
		}
		PriorityVertex other = (PriorityVertex) o;
		if(vertex == other.vertex) {
			return true;
		}
		else {
			return false;
		}
	}

	
}