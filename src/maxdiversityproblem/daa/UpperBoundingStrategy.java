package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.Arrays;

public class UpperBoundingStrategy {
	private MaxDiversityProblem problem;				// Estrategia de acotacion superior.
	
	/**
	 * 
	 * @param problem Problema a resolver.
	 */
	public UpperBoundingStrategy(MaxDiversityProblem problem) {
		setProblem(problem);
	}
	/**
	 * Calcula la cota superior del nodo.
	 * @param node
	 * @return
	 */
	public TreeNode setUpperBound(TreeNode node) { // TODO
		Double z1, z2, z3;
		
		getProblem().evaluate(node.getSolution());
		z1 = node.getSolution().getScore();
		z2 = calculateZ2(node);
		z3 = calculateZ3(node);
		
		
		node.setUpperBound(z1 + z2 + z3);
		return node;
	}
	/**
	 * Calcula z2.
	 * @param node
	 * @return
	 */
	private Double calculateZ2(TreeNode node) {
		int selected[] =  node.getSolution().getSolutionIndexesArray();
		int nonSelected[] = node.getSolution().getNonSolutionIndexesArray();
		Double acc = 0.0;
		Distance_NodePair distanceNodes[] = new Distance_NodePair[nonSelected.length];
		Double z2 = 0.0;
		
		for (int i = 0; i < nonSelected.length; i++) {
			acc = 0.0;
			for (int j = 0; j < selected.length; j++) {
				acc += getProblem().getDistance(nonSelected[i], selected[j]);
			}
			distanceNodes[i] = new Distance_NodePair(acc, i);
		}
		
		Arrays.sort(distanceNodes);
		
		for (int i = 0; i < getProblem().getTargetSize() - selected.length; i++) {
			z2 += distanceNodes[distanceNodes.length - i - 1].distance;
		}
		
		return z2;
	}
	/**
	 * Calcula z3.
	 */
	private Double calculateZ3(TreeNode node) {
		int selected[] =  node.getSolution().getSolutionIndexesArray();
		int nonSelected[] = node.getSolution().getNonSolutionIndexesArray();
		int nArcs = getProblem().getTargetSize() - selected.length - 1;
		Double acc = 0.0;
		int k = 0;
		if (nArcs <= 0)
			return 0.0;
		
		Double z3 = 0.0;
		Double dist[][] = new Double[nonSelected.length][nonSelected.length - 1];
		Distance_NodePair maxDist[] = new Distance_NodePair[nonSelected.length];
		
		for (int i = 0; i < nonSelected.length; i++) {
			k = 0;
			for (int j = 0; j < nonSelected.length; j++) {
				if (j != i) {
					dist[i][k] = new Double(getProblem().getDistance(nonSelected[i], nonSelected[j]));
					k++;
				}
			}
			Arrays.sort(dist[i]);
		}
		
		for (int i = 0; i < dist.length; i++) {
			acc = 0.0;
			for (int j = 0; j < nArcs; j++) {
				acc += dist[i][dist[i].length - j - 1];
			}
			maxDist[i] = new Distance_NodePair(acc, i);
		}
	
		Arrays.sort(maxDist);
		
		for (int i = 0; i < getProblem().getTargetSize() - selected.length; i++)
			z3 += maxDist[maxDist.length - i - 1].distance;
		
		return z3;
	}
	/**
	 * Getters y Setters.
	 * @return
	 */
	public MaxDiversityProblem getProblem() {
		return problem;
	}
	public void setProblem(MaxDiversityProblem problem) {
		this.problem = problem;
	}
	
}
