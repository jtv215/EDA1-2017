package org.eda1.ejercicio08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;


public class NetworkStartUp<Vertex> implements Graph<Vertex>, Iterable<Vertex> {
	
	private enum Secciones{
		TIPO, 
		VERTEX, 
		EDGES;
		
		void insertar (NetworkStartUp<StartUp> nS, String line){
      //Recibe una linea y dependiendo del caso se manejará de una u otra forma
			switch(this){
			case TIPO:
					nS.setDirected(line.toLowerCase().equals("undirected") ? false : true);
					break;
			case VERTEX:
					String[] x = null;
					StartUp s = null;
					x=line.split("#");
					s=new StartUp(x[0], x[1], x.length<6?"":x[5], x[3], x[2], Integer.parseInt(x[4]));
					nS.addVertex(s);
					nS.vertexToIndex.put(s, nS.vertexToIndex.size());
					break;
			case EDGES:
					String[] y = line.split(" ");
          //El primer elemento es el link del StartUp (from) y el resto de elementos son
          //los links de sus adyacentes (to)
					StartUp from = null, to = null;
					for (StartUp st : nS.adjacencyMap.keySet()) {
						if(st.getLink().equals(y[0])){
							from = st;
						}
					}
					if(from == null) return;
					
					for (int i = 1; i < y.length; i++) {
						for (StartUp st : nS.adjacencyMap.keySet()) {
							if(st.getLink().equals(y[i])){
								to = st;
							}
						}
						if(to == null) return;
						nS.addEdge(from, to, from.diferenciaVotos(to));
					}
          //FROM: Hay que buscar el elemento que disponga del link y si se encuentra, asignarlo al from
					//....

          //TO: Si el from no es null, se buscará aquel elemento que disponga del siguiente link y asignarlo al to
          //Una vez se haya encontrado, se agregará con el método addEdge
					//.....
					break;
			}
		}
	}

	private boolean directed; 	// directed = false (unDirected), directed = true (DiGraph)
	
	private TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;
	private TreeMap<Vertex, Integer> vertexToIndex;
	protected double[][] matrixD;
	protected int[][] matrixA;
	
  	/**
   	 *  Initialized this Network object to be empty.
   	 */
  	public NetworkStartUp() {
  		directed = true;
    	adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
    	vertexToIndex = new TreeMap<Vertex, Integer>();
    	this.matrixA = null;
		  this.matrixD = null;
  	} // default constructor

  	public NetworkStartUp(boolean uDOrD) { //uDOrD == unDirected Or Directed
  		directed = uDOrD;
  		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
  		vertexToIndex = new TreeMap<Vertex, Integer>();
  		this.matrixA = null;
  		this.matrixD = null;
	} // default constructor


  	/**
   	 *  Initializes this Network object to a shallow copy of a specified Network
   	 *  object.
   	 *  The averageTime(V, E) is O(V + E).
   	 *
   	 *  @param network - the Network object that this Network object is
	 *                                 initialized to a shallow copy of.
  	 *
  	 */
  	@SuppressWarnings("unchecked")
	public NetworkStartUp (NetworkStartUp<Vertex> network) {
  		this.directed = network.directed;
    	this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(network.adjacencyMap);
    	this.vertexToIndex = (TreeMap<Vertex, Integer>) network.vertexToIndex.clone();
    	this.matrixA = network.matrixA.clone();
		this.matrixD = network.matrixD.clone();
  	} // copy constructor

  	public void setDirected(boolean uDOrD) {
  		directed = uDOrD;
  	}

  	
  	public boolean getDirected() {
  		return directed;
  	}

  	/**
 	 *  Determines if this Network object contains no vertices.
  	 *
  	 *  @return true - if this Network object contains no vertices.
  	 *
  	 */
  	@Override
  	public boolean isEmpty() {
    	return adjacencyMap.isEmpty();
  	} // method isEmpty

  	
  	/**
  	 *  Determines the number of vertices in this Network object.
  	 *
  	 *  @return the number of vertices in this Network object.
  	 *
  	 */
  	@Override
  	public int numberOfVertices() {
    	return adjacencyMap.size();
  	} // method size


  	/**
  	 *  Returns the number of edges in this Network object.
  	 *  The averageTime (V, E) is O (V).
  	 *
  	 *  @return the number of edges in this Network object.
  	 *
  	 */
  	public int numberOfEdges() {
  		int count = 0;
  		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap.entrySet())
  			count += entry.getValue().size();
  		return count;
  	} // method getEdgeCount

  	
	public void clear() {
		this.adjacencyMap.clear();
		this.vertexToIndex.clear();
	}


  	/**
  	 *  Determines the weight of an edge in this Network object.
  	 *  The averageTime (V, E) is O (E / V).
  	 *
  	 *  @param v1 - the beginning Vertex object of the edge whose weight is sought.
  	 *  @param v2 - the ending Vertex object of the edge whose weight is sought.
  	 *
  	 *  @return the weight of edge <v1, v2>, if <v1, v2> forms an edge; return -1.0 if
  	 *                <v1, v2> does not form an edge in this Network object.
  	 *
  	 */
  	//public double getEdgeWeight (Vertex v1, Vertex v2)
  	public double getWeight (Vertex v1, Vertex v2) {
    	if (! (adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2)))
      		return -1.0;

    	return adjacencyMap.get(v1).get(v2);
   	} // method getWeight

  	public double setWeight (Vertex v1, Vertex v2, double w) {
		if (!(adjacencyMap.containsKey (v1) && adjacencyMap.get(v1).containsKey(v2)))
  			return -1.0;
		
		double oldWeight = adjacencyMap.get(v1).get(v2);
		adjacencyMap.get(v1).put(v2, w);
		return oldWeight;
	}

  	public boolean isAdjacent (Vertex v1, Vertex v2) {
		return (adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2));
 
	}

  	/**
  	 *  Determines if this Network object contains a specified Vertex object.
  	 *
  	 *  @param vertex - the Vertex object whose presence is sought.
  	 *
  	 *  @return true - if vertex is an element of this Network object.
  	 */
  	public boolean containsVertex(Vertex vertex) {
    	return adjacencyMap.containsKey(vertex);
  	} // method containsVertex


  	/**
  	 *  Determines if this Network object contains an edge specified by two vertices.
  	 *  The averageTime (V, E) is O (E / V).
  	 *
  	 *  @param v1 - the beginning Vertex object of the edge sought.
  	 *  @param v2 - the ending Vertex object of the edge sought.
  	 *
  	 *  @return true - if this Network object contains the edge <v1, v2>.
  	 *
  	 */
  	public boolean containsEdge(Vertex v1, Vertex v2) {
    	return (adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2));
  	} // method containsEdge


  	/**
  	 *  Ensures that a specified Vertex object is an element of this Network object.
  	 *
  	 *  @param vertex - the Vertex object whose presence is ensured.
  	 *
  	 *  @return true - if vertex was added to this Network object by this call; returns
  	 *               false if vertex was already an element of this Network object when
  	 *               this call was made.
  	 */
  	public boolean addVertex(Vertex vertex) {
        if (adjacencyMap.containsKey(vertex)) return false;
        adjacencyMap.put(vertex, new TreeMap<Vertex, Double>());
        return true;
  	} // method addVertex


  	/**
  	 *  Ensures that an edge is in this Network object.
  	 *
  	 *  @param v1 - the beginning Vertex object of the edge whose presence
  	 *                         is ensured.
  	 *  @param v2 - the ending Vertex object of the edge whose presence is
  	 *                        ensured.
  	 *  @param weight - the weight of the edge whose presence is ensured.
  	 *
  	 *  @return true - if the given edge (and weight) were added to this Network
  	 *                         object by this call; return false, if the given edge (and weight)
  	 *                         were already in this Network object when this call was made.
  	 *
  	 */
  	public boolean addEdge(Vertex v1, Vertex v2, double w) {
    	addVertex(v1);
    	addVertex(v2);
    	adjacencyMap.get(v1).put(v2, w);
    	
    	if (!directed)
        	adjacencyMap.get(v2).put(v1, w);
    	
    	return true;
  	} // method addEdge


  	/**
  	 *  Ensures that a specified Vertex object is not an element of this Network object.
  	 *  The averageTime (V, E) is O (V + E).
  	 *
  	 *  @param vertex - the Vertex object whose absence is ensured.
  	 *
  	 *  @return true - if vertex was removed from this Network object by this call;
  	 *                returns false if vertex was not an element of this Network object
  	 *                when this call was made.
         *   
	 */
  	public boolean removeVertex(Vertex vertex) {
        if (!adjacencyMap.containsKey(vertex))
            return false;

        for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry: adjacencyMap.entrySet()) {
        	entry.getValue().remove(vertex);
        } // for each vertex in the network
        adjacencyMap.remove(vertex);
        return true;
   	} // removeVertex


  	/**
   	 *  Ensures that an edge specified by two vertices is absent from this Network
   	 *  object.
   	 *  The averageTime (V, E) is O (E / V).
   	 *
   	 *  @param v1 - the beginning Vertex object of the edge whose absence is
   	 *                          ensured.
   	 *  @param v2 - the ending Vertex object of the edge whose absence is
   	 *                        ensured.
   	 *
   	 *  @return true - if the edge <v1, v2> was removed from this Network object
   	 *                          by this call; return false if the edge <v1, v2> was not in this
   	 *                          Network object when this call was made.
    	 *
   	 */
  	public boolean removeEdge (Vertex v1, Vertex v2) {
    	if (!adjacencyMap.containsKey(v1) || !adjacencyMap.get(v1).containsKey(v2))
	      	return false;


    	adjacencyMap.get(v1).remove(v2);
    	
    	if (!directed) {
        	adjacencyMap.get(v2).remove(v1);    		
    	}
    	
    	return true;
  	} // method removeEdge
	

  	public Set<Vertex> vertexSet() {
    	return adjacencyMap.keySet();
  	}

  	/**
  	 *  Returns a LinkedList object of the neighbors of a specified Vertex object.
  	 *
  	 *  @param v - the Vertex object whose neighbors are returned.
  	 *
  	 *  @return a LinkedList of the vertices that are neighbors of v.
   	 */

  	public Set<Vertex> getNeighbors(Vertex v) {
    	if (adjacencyMap.containsKey(v)) return null;
    	return new TreeSet<Vertex>(adjacencyMap.get(v).keySet());
  	}

  	/**
  	 *  Returns a String representation of this Network object.
  	 *  The averageTime(V, E) is O(V + E).
  	 *
  	 *  @return a String representation of this Network object.
  	 *
  	 */
  	public String toString() {
    		return adjacencyMap.toString();
  	} // method toString

  	/**
  	 *  Returns the mapping between the Vertex objects and a set of integers representing them.
  	 *  
  	 *
  	 *  @return the map between Vertex and Integer --> matrix representation in  Floyd algorithm.
  	 *
  	 */
  	public TreeMap<Vertex, Integer> getVertexToIndex(){
  		return vertexToIndex;
  	}
 	
	/**
	 * Builds a graph whose vertices are strings by reading the
	 * vertices and edges from the textfile <tt>filename</tt>. The format
	 * of the file is <code>
	 *     nVertices
	 *     vertex_1 vertex_2 ...vertex_n
	 *     nEdges
	 *     vertex_i vertex_j weight
	 *     . . .  </code>         ...
	 * @param filename name of the text file with vertex and edge specifications.
	 * @return <tt>DiGraph</tt> object with generic type String.
	 */
  	
  	
	public String getEdges(boolean order){
		 Comparator<Double> comp = null;
		 comp = order ? new Less<Double>() : new Greater<Double>();
		 TreeMap<Double,TreeSet<String>> res = new TreeMap<Double,TreeSet<String>>(comp);
		 for (Map.Entry<Vertex,TreeMap<Vertex,Double>> source : adjacencyMap.entrySet()){
			 for (Map.Entry<Vertex,Double> destination : source.getValue().entrySet()){
				 if (!res.containsKey(destination.getValue())) 
					 res.put(destination.getValue(), new TreeSet<String>());
				 res.get(destination.getValue()).add(source.getKey().toString() + " --> " + destination.getKey().toString());
			 }
		 }
		 return res.toString();
		
	}

	public Vertex getVertexFromIndex(int index) {
		for (Entry<Vertex, Integer> it : vertexToIndex.entrySet()) {
			if(it.getValue()==index){
				return it.getKey();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void load(String filename) throws FileNotFoundException {
		Scanner sc = null;
		String linea = null;
		Secciones seccion = null;
		int id = 0;
		File f = null;
		f=new File(filename);
		if(!f.exists()){
			throw new RuntimeException("...ERROR AL CARGAR ARCHIVO...");
		}
		sc= new Scanner(f);
		while (sc.hasNextLine()) {
			linea=sc.nextLine();
			if(linea.startsWith("%") || linea.trim().isEmpty()) continue;
			if(linea.startsWith("@")){
				switch (linea.substring(1, 2)) {
				case "T":
					seccion = Secciones.TIPO;
					break;
				case "V":
					seccion = Secciones.VERTEX;
					break;
				case "E":
					seccion = Secciones.EDGES;
					break;
				default:
					break;
				}
				continue;
			}
			seccion.insertar((NetworkStartUp<StartUp>) this, linea);
		}
		//   ...
		//TODO

		// Y terminanmos construyendo el mapa vertexToIndex...
		for(Vertex v: this.vertexSet()){
			this.vertexToIndex.put(v,  id++);
		}
		sc.close();
	}
	
	public String getFollowers(StartUp s, Comparator<Vertex> comp){
		//Devolvemos la lista de seguirodres/adyacentes de una startUp en el orden determinado por el parametro comp
		if(!adjacencyMap.containsKey(s)){
			return "[]";
		}
		TreeSet<Vertex> ts = new TreeSet<Vertex>(comp);
		ts.addAll(adjacencyMap.get(s).keySet());
		return ts.toString();
		
	}
	
	public Iterator<Vertex> iterator() {
        return adjacencyMap.keySet().iterator();
  	} // method iterator

  	
  	public BreadthFirstIterator breadthFirstIterator (Vertex v) {
    	if (!adjacencyMap.containsKey(v))
      		return null;
    	return new BreadthFirstIterator(v);
  	} // method breadthFirstIterator


  	public DepthFirstIterator depthFirstIterator (Vertex v) {
    	if (!adjacencyMap.containsKey (v))
      		return null;
    	return new DepthFirstIterator(v);
  	} // method depthFirstIterator



	public ArrayList<Vertex> toArrayDFS(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();

		TreeMap<Vertex,Boolean> visited = new TreeMap<Vertex, Boolean>();
		
		for (Vertex v : adjacencyMap.keySet()){
			visited.put(v,false);
		}
		
		toArrayDFSAux(start, result, visited);

		return result;
	}
	
	private void toArrayDFSAux(Vertex current, ArrayList<Vertex> result, TreeMap<Vertex,Boolean> visited) {
		result.add(current);
		visited.put(current, true);
		for (Vertex to : adjacencyMap.get(current).keySet()) {
			if (!visited.get(to))
				toArrayDFSAux(to,result,visited);
		}
	}
	
	public ArrayList<Vertex> toArrayDFSIterative(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		TreeMap<Vertex,Boolean> visited = new TreeMap<Vertex, Boolean>();
		ALStack<Vertex> stack = new ALStack<Vertex>();
		Vertex current = null;
		

		for (Vertex v : adjacencyMap.keySet()){
			visited.put(v,false);
		}
		
		stack.push(start);
		visited.put(start, true);

		while (!stack.isEmpty()) {

			current = stack.peek();
			stack.pop();
			
			result.add(current);
		
			for (Vertex to : adjacencyMap.get(current).keySet()) {
				if (visited.get(to)) continue;
				visited.put(to, true);
				stack.push(to);
			}
		}

		return result;
	}

	public ArrayList<Vertex> toArrayBFS(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		TreeMap<Vertex,Boolean> visited = new TreeMap<Vertex, Boolean>();
		LinkedQueue<Vertex> q = new LinkedQueue<Vertex>();
		Vertex current;
		
		for (Vertex v : adjacencyMap.keySet()){
			visited.put(v,false);
		}
		q.push(start);
		visited.put(start, true);

		while (!q.isEmpty()) {

			current = q.peek();
			q.pop();
			result.add(current);

			for (Vertex to : adjacencyMap.get(current).keySet()) {
				if (visited.get(to)) continue;
				visited.put(to, true);
				q.push(to);
			}
		}

		return result;
	}

	
	/////////
	
	public ArrayList<Object> Dijkstra(Vertex source, Vertex destination) {
  		final double INFINITY = Double.MAX_VALUE;
  		
  		Double weight = .0, minWeight = INFINITY;
    	TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
    	TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
    	TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
    	
    	ArrayList<Object> path = new ArrayList<Object>();
    	ALStack<Vertex> st = new ALStack<Vertex>();
		
    	Vertex from = null;

    	if (source == null || destination == null) return null;
    	
    	if (source.equals(destination))	return null;

    	if (!(adjacencyMap.containsKey(source) && adjacencyMap.containsKey(destination))) return null;
    	
    	for (Vertex e : adjacencyMap.keySet()) {
    		if (source.equals(e)) continue;
    		V_minus_S.add(e);
    	}
    	
    	for (Vertex v : V_minus_S){
    		if (isAdjacent(source,v)){
    			S.put(v, source);
    			D.put(v, getWeight(source,v));
    		}
    		else{
    			S.put(v, null);
    			D.put(v, INFINITY);
    		}
    	}
    	
		S.put(source, source);
		D.put(source, 0.0);
    	
		while (!V_minus_S.isEmpty()) {
		    minWeight = INFINITY;
		    from = null;
		    for (Vertex v : V_minus_S){
		    	if (D.get(v) < minWeight){
		    		minWeight = D.get(v);
		    		from = v;
		    	}
		    }
	    	if (from == null) break;
	    	
			V_minus_S.remove(from);
				
		    for (Vertex v : V_minus_S){
		    	if (isAdjacent(from,v)){
		    		weight = getWeight(from,v);
		    		if (D.get(from) + weight < D.get(v)){
		    			D.put(v, D.get(from) + weight);
		    			S.put(v, from);
		    		}
		    	}
		    }
		}
		
		
		if (S.get(destination) == null) {
			throw new RuntimeException("The vertex " + destination + " is not reachable from " + source);
		}
		
		st.push(destination);
		while (!(st.peek().equals(source))) {
			st.push(S.get(st.peek()));
		}
		while (!(st.isEmpty())) {
			path.add(st.peek());
			st.pop();
		}
		return path;
	}
	

	@SuppressWarnings("unchecked")
	public double computeDistanceFromPath(ArrayList<Object> path){
		//TODO Calcula la distancia a partir de un array de vertices
		double suma = 0;
		for (int i = 0; i < path.size()-1; i++) {
			suma+=getWeight((Vertex)path.get(i), (Vertex) path.get(i+1));
		}
		return suma;
	}
	
	///Floyd
	public void floyd() {
		Vertex from, to;
		double weight;
		int n = numberOfVertices();

		matrixD = new double[n][n];
		matrixA = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrixA[i][j] = -1;
				matrixD[i][j] = (i == j) ? 0 : Double.MAX_VALUE;
			}
		}

		for (Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap.entrySet()) {
			for (Entry<Vertex, Double> e2 : e1.getValue().entrySet()) {
				from = e1.getKey();
				to = e2.getKey();
				weight = e2.getValue();
				matrixD[vertexToIndex.get(from)][vertexToIndex.get(to)] = weight;
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)	continue;
				for (int j = 0; j < n; j++) {
					if (j == k || i == j) continue;
					if (matrixD[i][k] == Double.MAX_VALUE || matrixD[k][j] == Double.MAX_VALUE)
						continue;
					if ((matrixD[i][k] + matrixD[k][j]) < matrixD[i][j]) {
						matrixD[i][j] = matrixD[i][k] + matrixD[k][j];
						matrixA[i][j] = k;
					}
				}
			}
		}
	}
  	  
 	
  	protected class BreadthFirstIterator implements Iterator<Vertex> {
    		protected LinkedQueue<Vertex> queue;

    		protected TreeMap<Vertex, Boolean> visited;

    		protected Vertex current;

    		public BreadthFirstIterator (Vertex start)
    		{
      			queue = new LinkedQueue<Vertex>();

      			visited = new TreeMap<Vertex, Boolean>();

      			for (Vertex v : adjacencyMap.keySet()){
      				visited.put(v,false);
      			}
      
      			queue.push(start);
      			visited.put (start, true);
    		} // one-parameter constructor


    		public boolean hasNext()
    		{
      			return !(queue.isEmpty());
    		} // method hasNext


    		public Vertex next()
    		{
      			current = queue.pop();

            	for (Vertex to : adjacencyMap.get(current).keySet()) {
        			if (!visited.get(to))
        			{
          				visited.put (to, true);
          				queue.push(to);
        			}
      			}
      			return current;
    		} // method next


    		public void remove()
    		{
      			removeVertex (current);
    		} // method remove

  	} // class BreadthFirstIterator


  	protected class DepthFirstIterator implements Iterator<Vertex>
  	{
    		ALStack<Vertex> stack;

    		TreeMap<Vertex, Boolean> visited;

    		Vertex current;


    		public DepthFirstIterator (Vertex start)
    		{
      			stack = new ALStack<Vertex>();

      			visited = new TreeMap<Vertex, Boolean>();

      			for (Vertex v : adjacencyMap.keySet()){
      				visited.put(v, false);
      			}
      			
      			stack.push (start);
      			visited.put (start, true);
    		} // one-parameter constructor


    		public boolean hasNext()
    		{
      			return !(stack.isEmpty());
    		} // method hasNext


    		public Vertex next()
    		{
      			current = stack.pop();

                for (Vertex to: adjacencyMap.get(current).keySet()) {
        			if (!visited.get (to))
        			{
          				visited.put (to, true);
          				stack.push (to);
        			}
      			}
      			return current;
    		}


    		public void remove()
    		{
      			removeVertex (current);
    		} 

  	} // class DepthFirstIterator
  	
  	public int[][] getMatrixA(){
		return matrixA;
	}
	
	public double[][] getMatrixD(){
		return matrixD;
	}
	
	public ArrayList<String> getPaths() {
		ArrayList<String> resultado = new ArrayList<String>();
		int numPaths = 1;
		for (int i = 0; i < this.vertexToIndex.size(); i++) {
			for (int j = 0; j < this.vertexToIndex.size(); j++) {
				if (i == j)
					continue;
				if (matrixD[i][j] == Double.MAX_VALUE)
					continue;
				resultado.add("Camino #" + (numPaths++) + ": " + findPath(i, j) + " (" + matrixD[i][j] + ")");
			}
		}

		return resultado;
	}

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

	private String findPath(int vertexI, int vertexJ) {
		String s = getVertexFromIndex(vertexI).toString()+" --> ";
		if(matrixA[vertexI][vertexJ]!=-1){
			ArrayList<Vertex> al = new ArrayList<Vertex>();
			findPathAux(vertexI, vertexJ, al);
			for (Vertex v : al) {
				s+=v.toString()+" --> ";
			}
		}
		//TODO Devuelve el camino a partir de dos indices de la matriz. Algoritmo recursivo que llama a findPathAux
	
		return s+getVertexFromIndex(vertexJ);
	}

	private void findPathAux(int vertexI, int vertexJ, ArrayList<Vertex> camino) {
		if(matrixA[vertexI][vertexJ]!=-1){
			findPathAux(vertexI, matrixA[vertexI][vertexJ], camino);
			camino.add(getVertexFromIndex(matrixA[vertexI][vertexJ]));
			findPathAux(matrixA[vertexI][vertexJ], vertexJ, camino);
		}
	}

	public ArrayList<String> filterPathsByDistance(double distanceMin, double distanceMax) {
		//TODO Devuelve todos los caminos comprendidos entre las distancia pasadas por parametro, sin incluirse estas mismas
		ArrayList<String> resultado = new ArrayList<String>();
		int numPaths = 1;
		for (int i = 0; i < this.vertexToIndex.size(); i++) {
			for (int j = 0; j < this.vertexToIndex.size(); j++) {
				if (i == j)
					continue;
				if (matrixD[i][j] == Double.MAX_VALUE)
					continue;
				if(matrixD[i][j]>distanceMin && matrixD[i][j]<distanceMax){
					resultado.add("Camino #" + (numPaths++) + ": " + findPath(i, j) + " (" + matrixD[i][j] + ")");
				}
			}
		}

		return resultado;
	}

	public String findTheLargestPath() {
		double max = Double.MIN_VALUE;
		//TODO Obtiene el camino más largo
		int vertexI=0;
		int vertexJ=0;
		//TODO Obtiene el camino mas corto
		for (int i = 0; i < matrixD.length; i++) {
			for (int j = 0; j < matrixD.length; j++) {
				if(i!=j && matrixD[i][j]>max && matrixD[i][j]!=Double.MAX_VALUE){
					max=matrixD[i][j];
					vertexI=i;
					vertexJ=j;
				}
			}
		}
		return findPath(vertexI, vertexJ) + " ("+max+")";
	}

	public String findTheShortestPath() {
		double min = Double.MAX_VALUE;
		int vertexI=0;
		int vertexJ=0;
		//TODO Obtiene el camino mas corto
		for (int i = 0; i < matrixD.length; i++) {
			for (int j = 0; j < matrixD.length; j++) {
				if(i!=j && matrixD[i][j]<min){
					min=matrixD[i][j];
					vertexI=i;
					vertexJ=j;
				}
			}
		}
		return findPath(vertexI, vertexJ) + " ("+min+")";
	}
	 	

} // class Network
