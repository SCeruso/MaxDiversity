package maxdiversityproblem.daa;

import java.util.ArrayList;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public interface BranchingStrategy {
	/**
	 * Selecciona un nodo del arbol a ramificar.
	 * @param tree Arbol de nodos.
	 * @return
	 */
	public TreeNode nodeToBranch(ArrayList<TreeNode> tree);
}
