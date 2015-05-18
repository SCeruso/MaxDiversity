package maxdiversityproblem.daa;

import java.util.ArrayList;

public class MinBranching implements BranchingStrategy{

	@Override
	public TreeNode nodeToBranch(ArrayList<TreeNode> tree) {
		TreeNode min = tree.get(0);
		
		for (int i = 0; i< tree.size(); i++) {
			if (min.getUpperBound() > tree.get(i).getUpperBound())
				min = tree.get(i);
		}
		return min;
	}

}
