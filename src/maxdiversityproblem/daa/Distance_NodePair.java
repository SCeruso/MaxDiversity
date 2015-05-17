package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class Distance_NodePair  implements Comparable<Distance_NodePair>{
	public Double distance;					// Distancia a guardar.
	public int node;						// Nodo relacionado con la distancia.
	/**
	 * Crea un par nodo-distancia con los parametros dados.
	 * @param distance
	 * @param node
	 */
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
