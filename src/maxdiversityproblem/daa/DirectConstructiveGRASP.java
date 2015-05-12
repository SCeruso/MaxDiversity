package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Grasp que construye la solucion añadiendo nodos.
 * @author sabato
 *
 */
public class DirectConstructiveGRASP extends ConstructiveGRASP {

	public DirectConstructiveGRASP(MaxDiversityProblem problem, int lrc) {
		super(problem, lrc, ConstructiveGRASP.DIRECT);
	}
	
	/**
	 * Calcula el centroide de los nodos que se le pasa por parametro.
	 * 
	 */
	private Node getCentroid(int[] nodes) {
		MaxDiversityProblem problem = (MaxDiversityProblem) getProblem();
		Node centroid = null;
		Double coord[] = new Double[Node.getDimension()];
		
		for (int i = 0; i < coord.length; i++)
			coord[i] = 0.0;
		
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < Node.getDimension(); j++)
				coord[j] += problem.getNodes().get(nodes[i]).getCoordinates()[j];				//******************************* Probar esto.
		}
		for (int i = 0; i < coord.length; i++)
			coord[i] = coord[i] / nodes.length;
		
		centroid = new Node(coord);
		
		return centroid;
	}
	
	@Override
	protected void makeLrc() {	
		MaxDiversityProblem problem = (MaxDiversityProblem) getProblem();
		int nonInsertedNodes[];
		Node centroid = null;
		Distance_NodePair[] ordered = null;
		ArrayList<Distance_NodePair> distances = new ArrayList<Distance_NodePair>();
		MaxDiversitySolution aux = getActualSolution().clone();
		setLrc(new ArrayList<MaxDiversitySolution>());
		int j = 0;
		
		nonInsertedNodes= getActualSolution().getNonSolutionIndexesArray();
		centroid = getCentroid(nonInsertedNodes);
		
		for (int i = 0; i < nonInsertedNodes.length; i++) 
			distances.add(new Distance_NodePair(Node.distance(centroid, problem.getNodes().get(nonInsertedNodes[i])), nonInsertedNodes[i]));
		ordered = new Distance_NodePair[distances.size()];
		
		for (int i = 0; i < distances.size(); i++)
			ordered[i] = distances.get(i);
		Arrays.sort(ordered);
		
		for (int i = 0; i < getLrcSize(); i++) {
			getMove().makeMove(aux, ordered[ordered.length - i - 1].node);
			getLrc().add(aux);
			aux = getActualSolution().clone();
		}
		while (getLrc().size() > 0 && j < getLrc().size())
			if (getProblem().firstSolutionIsBetter(getActualSolution(), getLrc().get(j)))
				getLrc().remove(j);
			else
				j++;
	}
	/**
	 * Encuentra los dos nodos con mayor afinidad.
	 */
	@Override
	protected void initialize() {				
		MaxDiversitySolution sol = getActualSolution();	
		setBestSolution(sol);
	}
}
