package maxdiversityproblem.daa;

import java.io.FileNotFoundException;


public class Main {
	public static void main (String[] args) {
		MaxDiversityProblem problem = null; 
		GRASPandLocalSearch greedy = null;
		try {
			problem = new MaxDiversityProblem(true, "res/problems/maxdiversity/max_div_30_3.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		problem.setTargetSize(2);
		greedy = new GRASPandLocalSearch(problem, 2,ConstructiveGreedy.REVERSE);
		BranchAndBound branch = new BranchAndBound(problem, greedy, new DFSBranching());
		branch.runSearch();
		System.out.println(branch.getBestSolution());
		System.out.println(branch.getElapsedTime() + " " + branch.getIteration());

		
		problem.setTargetSize(3);
		greedy = new GRASPandLocalSearch(problem, 2,ConstructiveGreedy.REVERSE);
		branch = new BranchAndBound(problem, greedy, new DFSBranching());
		branch.runSearch();
		System.out.println(branch.getBestSolution());
		System.out.println(branch.getElapsedTime() + " " + branch.getIteration());
		
		problem.setTargetSize(4);
		greedy = new GRASPandLocalSearch(problem, 2,ConstructiveGreedy.REVERSE);
		branch = new BranchAndBound(problem, greedy, new DFSBranching());
		branch.runSearch();
		System.out.println(branch.getBestSolution());
		System.out.println(branch.getElapsedTime() + " " + branch.getIteration());
		
		problem.setTargetSize(5);
		greedy = new GRASPandLocalSearch(problem, 2,ConstructiveGreedy.REVERSE);
		branch = new BranchAndBound(problem, greedy, new DFSBranching());
		branch.runSearch();
		System.out.println(branch.getBestSolution());
		System.out.println(branch.getElapsedTime() + " " + branch.getIteration());
	}
}
