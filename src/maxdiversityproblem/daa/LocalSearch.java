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
 * Clase que realiza una busqueda local a partir de una solucion.
 * @author sabato
 *
 */
public class LocalSearch extends SolutionMethod{
	private MaxDiversitySolution actualSolution;
	private Enviroment enviroment;
	/**
	 * 
	 * @param problem Problema a resolver.
	 * @param solution Solucion de partida.
	 */
	public LocalSearch(MaxDiversityProblem problem, MaxDiversitySolution solution){
		setActualSolution(solution);
		setProblem(problem);
		setBestSolution(getActualSolution());
		setEnviroment(new Enviroment(getActualSolution()));
	}
	@Override
	public void runSearch() {
		MaxDiversitySolution aux;
		int iteration = 0;
		while (getEnviroment().hasMoreSolutions()) {
			iteration++;
			aux = getEnviroment().getNextSolutionFromEnviroment();
			if (getProblem().firstSolutionIsBetter(aux, getActualSolution())) {
				setActualSolution(aux);
				setBestSolution(getActualSolution());
				setIterationOfBestSolution(iteration);
				setEnviroment(new Enviroment(aux));
			}
		}
		setIteration(iteration);
	}
	public MaxDiversitySolution getActualSolution() {
		return actualSolution;
	}
	public void setActualSolution(MaxDiversitySolution actualSolution) {
		this.actualSolution = actualSolution;
	}
	public Enviroment getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(Enviroment enviroment) {
		this.enviroment = enviroment;
	}
	
}
