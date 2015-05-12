package maxdiversityproblem.daa;

/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Diseño y analisis de algoritmos.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import structure.problemsolvingmethods.daa.Problem;
import structure.problemsolvingmethods.daa.Solution;
/**
 * Clase que representa el problema del la maxima dispersion.
 * @author sabato
 *
 */
public class MaxDiversityProblem extends Problem {
	private ArrayList<ArrayList<Double>> distances;				// Grafo de distancias.
	private ArrayList<Node> nodes;								// Lista de nodos.
	private int targetSize;
	private int Nnodes;
	
	/**
	 * 
	 * @param max True si es un problemas de maximizar.
	 * @param filename Nombre del archivo donde se encuentra el grafo
	 * @throws FileNotFoundException
	 */
	public MaxDiversityProblem(boolean max, String filename) throws FileNotFoundException {
		super(max);
		setDistances(new ArrayList<ArrayList<Double>>());
		setNodes(new ArrayList<Node>());
		try {
			read(filename);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new FileNotFoundException();
		}
	}

	public MaxDiversityProblem(boolean max, String filename, int m) throws FileNotFoundException {
		this(max, filename);
		setTargetSize(m);
	}
	@Override
	public void evaluate(Solution solution) {
		MaxDiversitySolution sol = (MaxDiversitySolution) solution;
		int solutionNodes[] = sol.getSolutionIndexesArray();
		Double totalAffinity = 0.0;

		for (int i = 0; i < solutionNodes.length; i++) {
			for (int j = i + 1; j < solutionNodes.length; j++) {
				totalAffinity += getDistance(solutionNodes[i], solutionNodes[j]);
			}
		}

		sol.setScore(totalAffinity);
	}

	public ArrayList<ArrayList<Double>> getDistances() {
		return distances;
	}

	public void setDistances(ArrayList<ArrayList<Double>> costs) {
		this.distances = costs;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Obtiene la distancia del nodo p con el nodo q
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public Double getDistance(int p, int q) {
		int min = Math.min(p, q);
		int max = Math.max(p, q);

		try {
			return getDistances().get(min).get(max - min - 1); // Testear
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Lee de fichero el grafo
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void read(String filename) throws FileNotFoundException {
		Scanner scanner = null;
		Integer nNodes = -1;
		Double[] coord = null;
		String aux = null;
		int node;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			throw new FileNotFoundException(e.getMessage());
		}
		nNodes = new Integer(scanner.nextLine());
		setNnodes(nNodes);
		Node.setDimension(Integer.parseInt(scanner.nextLine()));
		coord = new Double[Node.getDimension()];
		
		try {
			for (int i = 0; i < nNodes; i++) {
				aux = scanner.nextLine();
				for (int j = 0; j < Node.getDimension(); j++) 				
					coord[j] = Double.parseDouble(aux.split("\\t")[j].trim().replace(",", "."));
				
				getNodes().add(new Node(coord));
				
			}
		} catch (Exception e) {
			System.err.println("Fichero mal escrito");
			throw new RuntimeException();
		} finally {
			scanner.close();
		}
		
		for (int i = 0; i < getNnodes(); i++) {
			node = getDistances().size();
			getDistances().add(new ArrayList<Double>());
			for (int j = node + 1; j < getNnodes(); j++) 
				getDistances().get(node).add(Node.distance(getNodes().get(node), getNodes().get(j)));			
		}
	}

	public int getNnodes() {
		return Nnodes;
	}

	public void setNnodes(int nnodes) {
		Nnodes = nnodes;
	}

	public int getTargetSize() {
		return targetSize;
	}

	public void setTargetSize(int targetSize) {
		this.targetSize = targetSize;
	}
	
}
