package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.Random;
/**
 * Clase que representa el entorno de una solucion.
 * El entorno viene definido por un movimiento y el numero de elementos a 
 * los que se le puede aplicar dicho movimiento. En otras palabras, el numero maximo de elementos
 * de diferencia entre la solucion y las soluciones vecinas.
 * @author sabato
 *
 */
public class Enviroment {
	private Movement additionMove;
	private Movement removalMove;
	private MaxDiversitySolution solution;
	private int addedIndex;
	private int removedIndex;
	/**
	 * 
	 * @param solution Solucion
	 * @param move Movimiento que define el entorno
	 * @param k Numero de movimientos que se le puede aplicar a la solucion para encontrar
	 * 		     una vecina
	 */
	public Enviroment(MaxDiversitySolution solution) {
		this();
		setSolution(solution);
	
	}
	public Enviroment() {
		setAdditionMove(new AdditionMovement());
		setRemovalMove(new RemovalMovement());
	}
	
	/**
	 * Obtiene la siguiente solucion del entorno o null si no hay mas soluciones.
	 * @return
	 */
	public MaxDiversitySolution getNextSolutionFromEnviroment() {
		int[] toAdd = getSolution().getNonSolutionIndexesArray();
		int[] toRemove = getSolution().getSolutionIndexesArray();
		MaxDiversitySolution sol = getSolution().clone();
		
		getAdditionMove().makeMove(sol, toAdd[getAddedIndex()]);
		getRemovalMove().makeMove(sol, getRemovedIndex());
		
		if (getRemovedIndex() > toRemove.length) {
			setRemovedIndex(0);
			setAddedIndex(getAddedIndex() + 1);
		}
		else 
			setRemovedIndex(getRemovedIndex() + 1); 
			
	
		return null;
	}
	/**
	 * Genera una solucion aleatoria del entorno.
	 * @return
	 */
	public MaxDiversitySolution generateRandom() {
		Random engine = new Random();
		MaxDiversitySolution aux = getSolution().clone();
		int[] toAdd = getSolution().getNonSolutionIndexesArray();
		int[] toRemove = getSolution().getSolutionIndexesArray();
		int choice;
	
		choice = engine.nextInt(toAdd.length);
		getAdditionMove().makeMove(aux, choice);
		choice = engine.nextInt(toRemove.length);
		getRemovalMove().makeMove(aux, choice);
		
		return aux;
	}
	/**
	 * 
	 * @return True si hay mas soluciones por explorar.
	 */
	public boolean hasMoreSolutions() {
		if (getAddedIndex() < getSolution().getNonSolutionIndexesArray().length)
				return true;
		else if (getRemovedIndex() < getSolution().getSolutionIndexesArray().length)
			return true;
		return false;
	}
	/**
	 * Getters y Setters.
	 * @return
	 */
	protected MaxDiversitySolution getSolution() {
		return solution;
	}
	protected void setSolution(MaxDiversitySolution solution) {
		this.solution = solution;
	}
	public Movement getAdditionMove() {
		return additionMove;
	}
	public void setAdditionMove(Movement additionMove) {
		this.additionMove = additionMove;
	}
	public Movement getRemovalMove() {
		return removalMove;
	}
	public void setRemovalMove(Movement removalMove) {
		this.removalMove = removalMove;
	}
	public int getAddedIndex() {
		return addedIndex;
	}
	public void setAddedIndex(int addedIndex) {
		this.addedIndex = addedIndex;
	}
	public int getRemovedIndex() {
		return removedIndex;
	}
	public void setRemovedIndex(int removedIndex) {
		this.removedIndex = removedIndex;
	}

	
}
