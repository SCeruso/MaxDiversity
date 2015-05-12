package maxdiversityproblem.daa;


/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
/**
 * Clase que representa el movimiento de eliminar un elemento.
 * @author sabato
 *
 */
public class RemovalMovement implements Movement{
	@Override
	public MaxDiversitySolution makeMove(MaxDiversitySolution solution, int index) {
		solution.removeElement(index);
		return solution;
	}

}
