package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class TreeNode {
	private Double upperBound;							// Cota superior del nodo.
	private MaxDiversitySolution solution;				// Solucion del nodo.
	private int k;										// Nivel en que se encuentra.
	private int index;									// Indice del ultimo elemento insertado.
	
	/**
	 * Crea un nodo con una solucion dada y una cota superior dada.
	 * @param sol
	 * @param bound
	 */
	public TreeNode(MaxDiversitySolution sol, Double bound) {
		this(sol);
		setUpperBound(bound);
		setK(0);
		setIndex(-1);
	}
	/**
	 * Crea un nodo con una solucion guardada.
	 * @param sol
	 */
	public TreeNode(MaxDiversitySolution sol) {
		setSolution(sol);
		setIndex(-1);
	}
	/**
	 * Getters y Setters.
	 * @return
	 */
	public Double getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}
	public MaxDiversitySolution getSolution() {
		return solution;
	}
	public void setSolution(MaxDiversitySolution solution) {
		this.solution = solution;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
