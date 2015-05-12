package maxdiversityproblem.daa;

import java.io.FileNotFoundException;

public class Main {
	public static void main (String[] args) {
		MaxDiversityProblem problem = null; 
		ConstructiveGRASP grasp = null;
		try {
			problem = new MaxDiversityProblem(true, "res/problems/maxdiversity/max_div_15_2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		problem.setTargetSize(4);
		grasp = new ReverseConstructiveGRASP(problem, 1);
		
		grasp.runSearch();
		
		System.out.println(grasp.getBestSolution());
	
		grasp = new DirectConstructiveGRASP(problem, 1);
		grasp.runSearch();
		
		System.out.println(grasp.getBestSolution());
	}
}




/**
* Probar el enviroment.
* Testear el LocalSearch
*
*
*
*/