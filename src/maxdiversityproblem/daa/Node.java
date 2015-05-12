package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class Node {
	private static Integer dimension;
	private Double coordinates[];
	
	public Node (Double coordinates[]) {
		setCoordinates(new Double[coordinates.length]);
		
		for (int i = 0; i < coordinates.length; i++) {
			getCoordinates()[i] = coordinates[i];
		}
	}
	public Node (Integer dimension, Double coordinates[]) {
		this(coordinates);
		setDimension(dimension);
	}
	/**
	 * Distancia entre dos nodos.
	 * @param node1	 
	 * @param node2
	 * @return Distancia entre nodo 1 y nodo 2.
	 */
	public static Double distance (Node node1, Node node2) {
		Double result = 0.0;
		
		for (int i = 0; i < Node.getDimension(); i++) 
			result += Math.pow(node1.getCoordinates()[i] - node2.getCoordinates()[i], 2);
		
		return Math.sqrt(result);
	}
	/**
	 * Getters y Setters
	 * 
	 */
	public static Integer getDimension() {
		return dimension;
	}

	public static void setDimension(Integer dimension) {
		Node.dimension = dimension;
	}

	public Double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Double[] coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
