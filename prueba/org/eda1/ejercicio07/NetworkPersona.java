package org.eda1.ejercicio07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

import org.omg.CORBA.TRANSACTION_MODE;

public class NetworkPersona<Vertex> implements Graph<Vertex>, Iterable<Vertex> {

	private boolean directed; 	// directed = false (unDirected), directed = true (DiGraph)

	private TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;
	private TreeMap<Vertex, Integer> vertexToIndex;

  	/**
   	 *  Initialized this Network object to be empty.
   	 */
  	public NetworkPersona() {
  		directed = true;
    	adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
    	vertexToIndex = new TreeMap<Vertex, Integer>();
  	} // default constructor

  	public NetworkPersona(boolean uDOrD) { //uDOrD == unDirected Or Directed
  		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
		vertexToIndex = new TreeMap<Vertex, Integer>();
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
	public NetworkPersona (NetworkPersona<Vertex> network) {
  		this.directed = network.directed;
    	this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(network.adjacencyMap);
    	this.vertexToIndex = (TreeMap<Vertex, Integer>) network.vertexToIndex.clone();
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

	@SuppressWarnings("unchecked")
	//TODO Cargar archivo
	public void load(String filename) throws FileNotFoundException {
		//   ...
		File f=new File(filename);
		if(!f.exists())throw new RuntimeException("...ERROR AL CARGAR ARCHIVO...");
		Scanner sc=new Scanner(new File (filename));
		String linea=null;
		boolean seccion=false;
		int id=0;

		while(sc.hasNextLine()){
			linea=sc.nextLine();
			if(linea.startsWith("%")|| linea.trim().isEmpty())continue;
			if(linea.startsWith("@")){
				if(linea.startsWith("@n"))continue;
				if(linea.startsWith("@t")){
					setDirected(!linea.split(" ")[1].equals("0"));
					//(0 no dirigido; 1 dirigido)
				}else if(linea.startsWith("@v")){
					seccion=true;
				}else if(linea.startsWith("@r")){
					seccion=false;
				}continue;
			}
			if(seccion){//Vertices
				String nombre=linea;
				linea=sc.nextLine();
				String[]x= linea.split(" ");
				TreeSet<String> amigos=new TreeSet<String>();
				for(String a: x){
					if(a.isEmpty())continue;//si hubiese espacio  extra, apareceria una cadena vacia
					amigos.add(a);
				}
				Persona p=new Persona(nombre,amigos);
				addVertex((Vertex)p);

			}else{//Relaciones
				String[]x=linea.split(" <<-->> ");
				Persona p1=new Persona(x[0].trim());
				Persona p2 =new Persona(x[1].trim());
//				TreeSet<Persona> key=(TreeSet<Persona>) adjacencyMap.keySet();
				if(adjacencyMap.keySet().contains(p1)){
					p1=(Persona) adjacencyMap.ceilingKey((Vertex )p1);//obtiene el siguiente por arriba

				}else{
					//p1=null;
					continue;
				}
				if(adjacencyMap.keySet().contains(p2)){
					p2=(Persona) adjacencyMap.ceilingKey((Vertex )p2);//obtiene el siguiente por arriba

				}else{
					//p2=null;
					continue;
			}
				addEdge((Vertex)p1, (Vertex)p2, p1.interseccion(p2));
		}
		}
		// Y terminanmos construyendo el mapa vertexToIndex...
		for(Vertex v: this.vertexSet()){
			
			this.vertexToIndex.put(v,  id++);
		}
		sc.close();

	}


	public String getFollowers(Persona user, Comparator<Vertex> comp){
		//Devolvemos la lista de seguirodres de user en el orden determinado por el parametro comp
		if(!containsVertex((Vertex) user)) return "[]";
		TreeSet<Vertex> ts=new TreeSet<Vertex>(comp);
		ts.addAll(adjacencyMap.get(user).keySet());
		
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
		double result=.0;
		for (int i=1; i<path.size(); i++){
			result += getWeight((Vertex)path.get(i-1), (Vertex)path.get(i));
		}
		return result;
	}

  	public Object[] floyd() {
  		final double INFINITY = Double.MAX_VALUE;

		Object [] resultFloyd = null;

  		double [][] matrixD;   // adjacency matrix
  		int [][] matrixA;   // ***


  		Vertex from, to;
  		double weight;
  		int n = numberOfVertices();

  		resultFloyd = new Object[2];

  		matrixD = new double [n][n];
  		matrixA = new int [n][n];

  		for (int i = 0; i < n; i++) {
  			for (int j = 0; j < n; j++) {
  				matrixA[i][j] = -1;
  				matrixD[i][j] = (i==j) ? 0 : INFINITY;
  			}
  		}

  		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap.entrySet()) {
  			for (Map.Entry<Vertex, Double> e2 : e1.getValue().entrySet()) {
  				from = e1.getKey();
  				to = e2.getKey();
  				weight = e2.getValue();
  				matrixD[vertexToIndex.get(from)][vertexToIndex.get(to)] = weight;
  			}
  		}
  		for (int k = 0; k < n; k++) {
  			for (int i = 0; i < n; i++) {
  				if (i==k) continue;
  				for (int j = 0; j < n; j++) {
  					if (j==k || i==j) continue;
  					if (matrixD[i][k] == INFINITY || matrixD[k][j] == INFINITY) continue;
  					if ((matrixD[i][k] + matrixD[k][j]) < matrixD[i][j]) {
  						matrixD[i][j] = matrixD[i][k] + matrixD[k][j];
  						matrixA[i][j] = k;
  					}
    	   		}
    	   	}

  		}
  		resultFloyd[0] = matrixD;
  		resultFloyd[1] = matrixA;
  		return resultFloyd;
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

  	public static void main(String[]args) throws FileNotFoundException{
  		String directorioEntrada = System.getProperty("user.dir") + File.separator +
			    "src" + File.separator +
			    "org" + File.separator +
			    "eda1" + File.separator +
			    "ejercicio07" + File.separator + "red";
  		NetworkPersona<Persona> grafo = new NetworkPersona<Persona>();
  		grafo.load(directorioEntrada);

  	}
} // class Network
