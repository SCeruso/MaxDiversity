package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class Node {
	private Integer dimension;
	private Double coordinates[];
	
	public Node (Integer dimension, Double coordinates[]) {
		setDimension(dimension);
		setCoordinates(new Double[dimension]);
		
		for (int i = 0; i < coordinates.length; i++) {
			getCoordinates()[i] = coordinates[i];
		}
	}
	/**
	 * Distancia entre dos nodos.
	 * @param node1	 
	 * @param node2
	 * @return Distancia entre nodo 1 y nodo 2.
	 */
	public static Double distance (Node node1, Node node2) {
		Double result = 0.0;
		
		for (int i = 0; i < node1.getDimension(); i++) 
			result += Math.pow(node1.getCoordinates()[i] - node1.getCoordinates()[i], 2);
		
		return Math.sqrt(result);
	}
	/**
	 * Getters y Setters
	 * 
	 */
	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}

	public Double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Double[] coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
