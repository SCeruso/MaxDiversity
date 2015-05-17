package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.ArrayList;

public class DFSBranching implements BranchingStrategy{

	@Override
	public TreeNode nodeToBranch(ArrayList<TreeNode> tree) {
		
		return tree.get(tree.size() - 1);
	}

}
