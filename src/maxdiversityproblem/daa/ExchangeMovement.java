package maxdiversityproblem.daa;


/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
/**
 * Clase que representa el movimiento de insertar un nodo en la solucion si no lo esta,
 * o quitarlo si ya lo esta.
 * @author sabato
 *
 */
public class ExchangeMovement implements Movement{

	@Override
	public MaxDiversitySolution makeMove(MaxDiversitySolution solution, int index) {
		solution.flipElement(index);
		return solution;
	}

}
