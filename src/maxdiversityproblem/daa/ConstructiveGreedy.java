package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import structure.problemsolvingmethods.daa.SolutionMethod;
/**
 * Algoritmo greedy para resolver el problema de las k medias.
 * @author sabato
 *
 */
public class ConstructiveGreedy extends SolutionMethod{
	private ConstructiveGRASP solutionMethod;
	public static final int DIRECT = 0;
	public static final int REVERSE = 1;
	/**
	 * Crea un GRASP con una lista restringida de tamaño 1.
	 * 
	 * @param problem Problema a resolver.
	 * @param type Tipo de greedy, si va añadiendo o quitando nodos.
	 */
	public ConstructiveGreedy(MaxDiversityProblem problem, int type) {
		if (type == DIRECT)
			setSolutionMethod(new DirectConstructiveGRASP(problem, 1));
		else
			setSolutionMethod(new ReverseConstructiveGRASP(problem, 1));
	}
	
	public void runSearch() {
		getSolutionMethod().runSearch();
		setBestSolution(getSolutionMethod().getBestSolution());
		setIterationOfBestSolution(getSolutionMethod().getIterationOfBestSolution());
		setIteration(getSolutionMethod().getIteration());
		setElapsedTime(getSolutionMethod().getElapsedTime());
		setElapsedTimeOfBestSolution(getSolutionMethod().getElapsedTimeOfBestSolution());
	}
	private ConstructiveGRASP getSolutionMethod() {
		return solutionMethod;
	}

	private void setSolutionMethod(ConstructiveGRASP solutionMethod) {
		this.solutionMethod = solutionMethod;
	}
	
	
}
