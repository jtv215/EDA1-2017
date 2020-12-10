package org.eda1.actividad05;

import java.io.File;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.eda1.actividad05.edaAuxiliar.Network;

/**
 * The Class ManageFloyd.
 */
public class ManageFloyd extends Network<String> {

	/**
	 * The Enum Secciones.
	 */
	private enum Secciones{

		/** The tipo. */
		TIPO,

		/** The vertex. */
		VERTEX,

		/** The edges. */
		EDGES;

		/**
		 * Insertar.
		 *
		 * @param mF the m f
		 * @param line the line
		 */
		void insertar (ManageFloyd mF, String line){
			switch(this){
			case TIPO:
					mF.setDirected(line.toLowerCase().equals("directed") ? true : false);
					break;
			case VERTEX:
					mF.addVertex(line);
					mF.vertexToIndex.put(line, mF.vertexToIndex.size());
					break;
			case EDGES:
					String[] words = line.split(" ");
					mF.addEdge(words[0], words[1], Double.parseDouble(words[2]));
					break;
			}
		}
	}

	/**
	 * Instantiates a new manage floyd.
	 *
	 * @param filename the filename
	 */
	public ManageFloyd(String filename){
		super();
		loadNetwork(filename);
		floyd();
	}

	/**
	 * Load network.
	 *
	 * @param filename the filename
	 */
	private void loadNetwork(String filename){
		//Observad la declaracion del enumerado Secciones...interesante
		String line = "";
		Scanner scan = null;
		Secciones seccion = null;

		this.adjacencyMap.clear();
		this.vertexToIndex.clear();

		try{
		scan= new Scanner(new File(filename));
		while(scan.hasNextLine()){
			line=scan.nextLine();
			if(line.startsWith("%")||line.trim().isEmpty())continue;
			if(line.startsWith("@")){
				if(line.startsWith("@T")){
					seccion=Secciones.TIPO;
				}else if(line.startsWith("@V")){
					seccion=Secciones.VERTEX;
				}else if(line.startsWith("@E")){
					seccion= Secciones.EDGES;
				}
				continue;
			}
			seccion.insertar(this, line);


		}
		scan.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Gets the vertex to index.
	 *
	 * @return the vertex to index
	 */
	public TreeMap<String, Integer> getVertexToIndex(){
		return this.vertexToIndex;
	}

	/**
	 * Gets the vertex from index.
	 *
	 * @param index the index
	 * @return the vertex from index
	 */
	public String getVertexFromIndex(int index) {
		//TODO
		for(java.util.Map.Entry<String, Integer> it: vertexToIndex.entrySet()){
			if(index==it.getValue()){
				return it.getKey();
			}
		}

		return null;
	}

	/**
	 * Gets the matrix a.
	 *
	 * @return the matrix a
	 */
	public int[][] getMatrixA(){
		return matrixA;
	}

	/**
	 * Gets the matrix d.
	 *
	 * @return the matrix d
	 */
	public double[][] getMatrixD(){
		return matrixD;
	}

	/**
	 * Gets the paths.
	 *
	 * @return the paths
	 */
	public ArrayList<String> getPaths() {
	//me devuelve todos los canimo
//		ArrayList<String> resultado = new ArrayList<String>();
//		int numPaths = 1;
//		for (int i = 0; i < this.vertexToIndex.size(); i++) {
//			for (int j = 0; j < this.vertexToIndex.size(); j++) {
//				if (i == j)
//					continue;
//				if (matrixD[i][j] == Double.MAX_VALUE)
//					continue;
//				resultado.add("Camino #" + (numPaths++) + ": " + findPath(i, j) + " (" + matrixD[i][j] + ")");
//			}
//		}
//
//		return resultado;
		return filterPathsByDistance(0, Double.MAX_VALUE);
	}

	/**
	 * Find path.
	 *
	 * @param vertexI the vertex i
	 * @param vertexJ the vertex j
	 * @return the string
	 */
	public String findPath(String vertexI, String vertexJ) {
		int vI, vJ;
		if (!vertexToIndex.containsKey(vertexI) || !vertexToIndex.containsKey(vertexJ))
			return null;
		if (vertexI.equals(vertexJ))
			return "Just the same vertex...";
		vI = vertexToIndex.get(vertexI);
		vJ = vertexToIndex.get(vertexJ);
		if (matrixD[vI][vJ] == Double.MAX_VALUE)
			return null;
		return findPath(vI, vJ) + " (" + matrixD[vI][vJ] + ")";
	}

	/**
	 * Find path.
	 *
	 * @param vertexI the vertex i
	 * @param vertexJ the vertex j
	 * @return the string
	 */
	private String findPath(int vertexI, int vertexJ) {
		//TODO LLAMA al metodo de abajo cuando lo necesite cuando sea distindo de -1
		//devuelve el camnio de un vertice i a un vertice j
		String s=getVertexFromIndex(vertexI)+" --> ";
		if(matrixA[vertexI][vertexJ]!=-1){
			ArrayList<String> camino= new ArrayList<String>();
			findPathAux(vertexI, vertexJ, camino);
			for(String v:camino){
				s+=v+" --> ";
			}
		}
		s+=getVertexFromIndex(vertexJ);

		return s;

	}

	/**
	 * Find path aux.
	 *
	 * @param vertexI the vertex i
	 * @param vertexJ the vertex j
	 * @param camino the camino
	 */
	private void findPathAux(int vertexI, int vertexJ, ArrayList<String> camino) {
		//Este metodo solo agrega los nodos intermedio
		if(matrixA[vertexI][vertexJ]!=-1){//si no hay camino directo
			findPathAux(vertexI, matrixA[vertexI][vertexJ], camino);//izque
				// matrixA[vertexI][vertexJ] SON Los nodos intermedios
			camino.add(getVertexFromIndex(matrixA[vertexI][vertexJ]));//aqui agrega el vertice intermedio
			findPathAux( matrixA[vertexI][vertexJ],vertexJ, camino);//derech
		}

	}

	/**
	 * Filter paths by distance.
	 *
	 * @param distanceMin the distance min
	 * @param distanceMax the distance max
	 * @return the array list
	 */
	public ArrayList<String> filterPathsByDistance(double distanceMin, double distanceMax) {

		ArrayList<String> resultado = new ArrayList<String>();
		int numPaths = 1;
		for (int i = 0; i < this.vertexToIndex.size(); i++) {
			for (int j = 0; j < this.vertexToIndex.size(); j++) {
				if (i == j)
					continue;
				if (matrixD[i][j] == Double.MAX_VALUE)
					continue;
				if(matrixD[i][j]>=distanceMin && matrixD[i][j]<=distanceMax){
				resultado.add("Camino #" + (numPaths++) + ": " + findPath(i, j) + " (" + matrixD[i][j] + ")");
				}
			}
		}

		return resultado;


	}

	/**
	 * Find the largest path.
	 *
	 * @return the string
	 */
	public String findTheLargestPath() {
	//encontrar el camino mas largo
		double max=0;
		int fila=0;
		int columna=0;

		for(int i=0;i<matrixA.length;i++){
			for(int j=0;j<matrixD.length;j++){
				if(i!=j&&matrixD[i][j]>max && matrixD[i][j]!= Double.MAX_VALUE){
					max=matrixD[i][j];
					fila=i;
					columna=j;
				}
			}
		}

	return findPath(getVertexFromIndex(fila), getVertexFromIndex(columna));



	}

	/**
	 * Find the shortest path.
	 *
	 * @return the string
	 */
	public String findTheShortestPath() {

		double min=Double.MAX_VALUE;
		int fila=0;
		int columna=0;

		for(int i=0;i<matrixA.length;i++){
			for(int j=0;j<matrixD.length;j++){
				if(i!=j &&matrixD[i][j]<min ){
					min=matrixD[i][j];
					fila=i;
					columna=j;
				}
			}
		}

	return findPath(getVertexFromIndex(fila), getVertexFromIndex(columna));


	}

}
