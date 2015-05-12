package maxdiversityproblem.daa;

public class Distance_NodePair  implements Comparable<Distance_NodePair>{
	public Double distance;
	public int node;
	
	public Distance_NodePair(Double distance, int node) {
		this.distance = distance;
		this.node = node;
	}

	@Override
	public int compareTo(Distance_NodePair o) {
		if (this.distance < o.distance)
			return -1;
		else if (this.distance > o.distance)
			return 1;
		else 
			return 0;
	} 
}
