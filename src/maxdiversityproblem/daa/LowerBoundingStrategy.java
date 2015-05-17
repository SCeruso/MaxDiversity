package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public interface LowerBoundingStrategy {
	/**
	 * Genera una solucion que actuara de cota inferior.
	 * @return
	 */
	public MaxDiversitySolution generateBound();
}
