package maxdiversityproblem.daa;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.ArrayList;

import structure.problemsolvingmethods.daa.SolutionMethod;

public class BranchAndBound extends SolutionMethod{
	private LowerBoundingStrategy lowerBoundingStrategy;				// Estrategia de calculo de cota inferior.
	private BranchingStrategy branchingStrategy;						// Estrategia de ramificacion.
	private ArrayList<TreeNode> tree;									// Arbol.
	private UpperBoundingStrategy upperBoundStrategy;					// Estrategia de calculo cota superior.
	private Double lowerBound;											// Cota inferior.
	/**
	 * 
	 * @param problem Problema a resolver.
	 */
	public BranchAndBound(MaxDiversityProblem problem) {
		setProblem(problem);
		setTree(new ArrayList<TreeNode>());
		setUpperBoundStrategy(new UpperBoundingStrategy((MaxDiversityProblem)getProblem()));
	}	
	/**
	 * 
	 * @param problem Problema a resolver.
	 * @param strategy Estrategia de calculo cota inferior.
	 * @param branch Estrategia de ramificacion.
	 */
	public BranchAndBound(MaxDiversityProblem problem, LowerBoundingStrategy strategy, BranchingStrategy branch) {
		this(problem);
		setBranchingStrategy(branch);
		setLowerBoundingStrategy(strategy);
	}
	@Override
	public void runSearch() {
		long time = System.currentTimeMillis();
		int iteration = 0;
		setBestSolution(getLowerBoundingStrategy().generateBound());
		setLowerBound(getBestSolution().getScore());
		MaxDiversitySolution emptySol = new MaxDiversitySolution(((MaxDiversitySolution)getBestSolution()).getSize(), ((MaxDiversityProblem)getProblem()).getTargetSize());
		getTree().add(getUpperBoundStrategy().setUpperBound(new TreeNode(emptySol)));
		
		while (getTree().size() != 0) {
			iteration += tree.size();
			branch(getBranchingStrategy().nodeToBranch(getTree()));
		}
		
		setElapsedTime(System.currentTimeMillis() - time);
		setElapsedTimeOfBestSolution(getElapsedTime());
		setIteration(iteration);
		setIterationOfBestSolution(iteration);
	}
	/**
	 * Ramifica el nodo pasado por parametro.
	 * @param node Nodo a ramificar.
	 */
	public void branch(TreeNode node) {
		int nHijos = ((MaxDiversityProblem)getProblem()).getNnodes() - (node.getSolution().getTargetSize() - node.getK()) - node.getIndex();
		int nodeToAdd = 0;
		TreeNode newNode = null;
		MaxDiversitySolution newSol;
		
		for (int i = 0; i < nHijos; i++) {
			nodeToAdd = node.getIndex() + i + 1;
			newSol = node.getSolution().clone();
			newSol.addElement(nodeToAdd);
			newNode = new TreeNode(newSol);
			newNode.setIndex(nodeToAdd);
			newNode.setK(node.getK() + 1);
			getUpperBoundStrategy().setUpperBound(newNode);
			
			
			if (newNode.getUpperBound() > getLowerBound()) {
				getTree().add(newNode);
				if ((newNode.getK() == newNode.getSolution().getTargetSize())) {
					if ((getProblem().firstSolutionIsBetter(newNode.getSolution(), getBestSolution()))) {
						setBestSolution(newNode.getSolution());
						setLowerBound(getBestSolution().getScore());
					}
					getTree().remove(newNode);
				}
			}
		}
		getTree().remove(node);
	}
	/**
	 * Getters y Setters.
	 */
	public LowerBoundingStrategy getLowerBoundingStrategy() {
		return lowerBoundingStrategy;
	}
	public void setLowerBoundingStrategy(LowerBoundingStrategy lowerBoundingStrategy) {
		this.lowerBoundingStrategy = lowerBoundingStrategy;
	}
	public BranchingStrategy getBranchingStrategy() {
		return branchingStrategy;
	}
	public void setBranchingStrategy(BranchingStrategy branchingStrategy) {
		this.branchingStrategy = branchingStrategy;
	}

	public ArrayList<TreeNode> getTree() {
		return tree;
	}

	public void setTree(ArrayList<TreeNode> tree) {
		this.tree = tree;
	}

	public UpperBoundingStrategy getUpperBoundStrategy() {
		return upperBoundStrategy;
	}

	public void setUpperBoundStrategy(UpperBoundingStrategy upperBoundStrategy) {
		this.upperBoundStrategy = upperBoundStrategy;
	}

	public Double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	
}
