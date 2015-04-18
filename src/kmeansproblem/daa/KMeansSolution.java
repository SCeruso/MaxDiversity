package kmeansproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.BitSet;

import structure.problemsolvingmethods.daa.Solution;
/**
 * Clase para representar una solucion al problema de la max k media.
 * @author sabato
 *
 */
public class KMeansSolution extends Solution{
	private BitSet solutionSet;					// Conjunto para representar la solucion.
	private int size;							// Numero total de nodos.
	
	/**
	 * 
	 * @param set Conjunto solucion
	 * @param n Numero total de nodos.
	 */
	public KMeansSolution(BitSet set, int n) {
		setSolutionSet(set);
		setSize(n);
	}
	/**
	 * 
	 * @param n Numero total de nodos.
	 */
	public KMeansSolution(int n) {
		setSize(n);
		setSolutionSet(new BitSet());
	}

	@Override
	public boolean equals(Solution solution) {
		KMeansSolution sol = (KMeansSolution) solution;
		return getSolutionSet().equals(sol.getSolutionSet()) && getScore() == solution.getScore();
	}
	/**
	 * Devuelve un array con los nodos que forman parte de esta solucion.
	 * @return Array de indices de nodos que forman parte de la solucion.
	 */
	public int[] getSolutionIndexesArray() {
		int j = 0;
		int solutionNodes[] = new int[getSolutionSet().cardinality()];
		
		for (int i = getSolutionSet().nextSetBit(0); i >= 0; i = getSolutionSet().nextSetBit(i+1)) {
		     solutionNodes[j++] = i;	
		     if (i == Integer.MAX_VALUE) {
		         break; // or (i+1) would overflow
		     }
		 }
		
		return solutionNodes;
	}
	/**
	 * Devuelve un array de los nodos que no forman parte de esta solucion.
	 * @return Array de inidices de los nodos que no forman parte de esta solucion.
	 */
	public int[] getNonSolutionIndexesArray() {
		int j = 0;
		int solutionNodes[] = new int[getSize() - getSolutionSet().cardinality()];
		
		for (int i = getSolutionSet().nextClearBit(0); i < getSize(); i = getSolutionSet().nextClearBit(i+1)) {
		     solutionNodes[j++] = i;	
		     if (i == Integer.MAX_VALUE) {
		         break; // or (i+1) would overflow
		     }
		 }
		
		return solutionNodes;
	}
	/**
	 * Devuelve una copia.
	 */
	public KMeansSolution clone() {
		BitSet aux = (BitSet)getSolutionSet().clone();
		return new KMeansSolution(aux, getSize());
	}
	public boolean containsElement(int n) {
		return getSolutionSet().get(n);
	}
	/**
	 * Añade el nodo a la solucion.
	 * @param n Nodo añadir
	 */
	public void addElement(int n) {
		getSolutionSet().set(n);
	}
	/**
	 * Quita el nodo de la solucion.
	 * @param n Nodo a quitar.
	 */
	public void removeElement(int n) {
		getSolutionSet().clear(n);
	}
	/**
	 * Quita el nodo si ya pertenece o lo inserta si no.
	 * @param n Nodo a intercambiar.
	 */
	public void flipElement(int n) {
		getSolutionSet().flip(n);
	}
	public BitSet getSolutionSet() {
		return solutionSet;
	}

	public void setSolutionSet(BitSet solutionSet) {
		this.solutionSet = solutionSet;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		return getSolutionSet().toString() + ", " + getScore();
	}
	
}
