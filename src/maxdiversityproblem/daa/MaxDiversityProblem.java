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
	private ArrayList<ArrayList<Integer>> distances;			// Grafo de distancias.
	
	private int Nnodes;
	
	/**
	 * 
	 * @param max True si es un problemas de maximizar.
	 * @param filename Nombre del archivo donde se encuentra el grafo
	 * @throws FileNotFoundException
	 */
	public MaxDiversityProblem(boolean max, String filename) throws FileNotFoundException {
		super(max);
		setDistances(new ArrayList<ArrayList<Integer>>());
		
		try {
			read(filename);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new FileNotFoundException();
		}
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

		sol.setScore(totalAffinity / (double) solutionNodes.length);
	}

	public ArrayList<ArrayList<Integer>> getDistances() {
		return distances;
	}

	public void setDistances(ArrayList<ArrayList<Integer>> costs) {
		this.distances = costs;
	}

	/**
	 * Obtiene la distancia del nodo p con el nodo q
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public Integer getDistance(int p, int q) {
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
		int j;
		int node;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			throw new FileNotFoundException(e.getMessage());
		}
		nNodes = new Integer(scanner.nextLine());
		setNnodes(nNodes);
		j = nNodes - 1;

		try {
			while (scanner.hasNext()) {
				node = getDistances().size();
				getDistances().add(new ArrayList<Integer>());
				for (int i = 0; i < j; i++) {
					getDistances().get(node).add(
							new Integer(scanner.nextLine()));
				}
				j--;
			}
		} catch (Exception e) {
			System.err.println("Fichero mal escrito");
			throw new RuntimeException();
		} finally {
			scanner.close();
		}
	}

	public int getNnodes() {
		return Nnodes;
	}

	public void setNnodes(int nnodes) {
		Nnodes = nnodes;
	}

}
