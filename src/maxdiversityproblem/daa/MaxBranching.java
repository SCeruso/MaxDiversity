package maxdiversityproblem.daa;

import java.util.ArrayList;

public class MaxBranching implements BranchingStrategy{

	@Override
	public TreeNode nodeToBranch(ArrayList<TreeNode> tree) {
		TreeNode max = tree.get(0);
		
		for (int i = 0; i< tree.size(); i++) {
			if (max.getUpperBound() < tree.get(i).getUpperBound())
				max = tree.get(i);
		}
		return max;
	}

}
