package maxdiversityproblem.daa;

import java.util.ArrayList;

/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

/**
 * Clase que realiza el algoritmo GRASP a a partir de una solucion con todos los nodos y los va 
 * eliminando.
 * @author sabato
 *
 */
public class ReverseConstructiveGRASP extends ConstructiveGRASP {

	/**
	 * 
	 * @param problem Problema a resolver.
	 * @param lrc Tamaño de la lista restringida de candidatos.
	 */
	public ReverseConstructiveGRASP(MaxDiversityProblem problem, int lrc) {
		super(problem, lrc, ConstructiveGRASP.REVERSE);
	}

	@Override
	protected void initialize() {
		MaxDiversityProblem problem = (MaxDiversityProblem)getProblem();
		MaxDiversitySolution sol = getActualSolution();
		
		for (int i = 0; i < problem.getNnodes(); i++) 
			sol.addElement(i);
		
		setBestSolution(sol);
		setActualSolution(sol);
	}

	@Override
	protected void makeLrc() {
		int InsertedNodes[];
		MaxDiversitySolution aux = getActualSolution().clone();
		setLrc(new ArrayList<MaxDiversitySolution>(getLrcSize()));
		int j = 0;

		InsertedNodes= getActualSolution().getSolutionIndexesArray();
		
		for (int i = 0; i < InsertedNodes.length; i++) {
			getMove().makeMove(aux, InsertedNodes[i]);
			getProblem().evaluate(aux);
			insertLrc(aux);
			aux = getActualSolution().clone();
		}	
	}

}
