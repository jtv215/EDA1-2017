package org.eda1.practica04.edaAuxiliar;

import java.util.*;
import java.util.Map.Entry;


/**
 * The Class Network.
 *
 * @param <Vertex> the generic type
 */
public class Network<Vertex extends Comparable<Vertex>> implements Graph<Vertex>, Iterable<Vertex> {

	/** The directed. */
	private boolean directed; 	// directed = false (unDirected)"no dirigido", directed = true (DiGraph)"dirigido"

	/** The adjacency map. */
	private TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;

	/**
	 * Instantiates a new network.
	 */
	public Network(){
		directed = true;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

   	/**
	    * Instantiates a new network.
	    *
	    * @param uDOrD the u d or d
	    */
	   public Network(boolean uDOrD) { //uDOrD == unDirected Or Directed
  		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

  	/**
	   * Sets the directed.
	   *
	   * @param uDOrD the new directed
	   */
	  public void setDirected(boolean uDOrD) {
  		directed = uDOrD;
  	}

  	/**
	   * Gets the directed.
	   *
	   * @return the directed
	   */
	  public boolean getDirected() {
  		return directed;
  	}

	  @Override
  	public boolean isEmpty() {
    	return adjacencyMap.isEmpty();
  	}

	  @Override
  	public void clear() {
		adjacencyMap.clear();
	}

	  @Override
  	public int numberOfVertices() {
    	return adjacencyMap.size();
  	}

	  @Override
  	public int numberOfEdges() {
  	//TODO
  	int cont=0;
  	for (Entry<Vertex, TreeMap<Vertex, Double>> it : adjacencyMap.entrySet()) {
		cont+=it.getValue().size();
	}
  		return cont;

  	}

	  @Override
  	public boolean containsVertex(Vertex vertex) {
    	return adjacencyMap.containsKey(vertex);
  	}

	  @Override
  	public boolean containsEdge(Vertex v1, Vertex v2) {
    	return adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2);
  	}

	  @Override
  	public double getWeight (Vertex v1, Vertex v2) {
  		if (!containsEdge(v1, v2)) return -1;
  		return adjacencyMap.get(v1).get(v2);
   	}

	  @Override
  	public double setWeight (Vertex v1, Vertex v2, double w) {
  		if (!containsEdge(v1, v2)) return -1;
		double oldWeight = adjacencyMap.get(v1).get(v2);
		adjacencyMap.get(v1).put(v2, w);
		return oldWeight;
	}

  	/**
	   * Checks if is adjacent.
	   *
	   * @param v1 the v1
	   * @param v2 the v2
	   * @return true, if is adjacent
	   */
	  public boolean isAdjacent (Vertex v1, Vertex v2) {
		return (adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2));

	}

	  public boolean addVertex(Vertex vertex) {
        if (adjacencyMap.containsKey(vertex))   return false;
        adjacencyMap.put(vertex, new TreeMap<Vertex, Double>());
        return true;
  	}

	  public boolean addEdge(Vertex v1, Vertex v2, double w) {
  		if (!containsVertex(v1) || !containsVertex(v2)) return false;
  		adjacencyMap.get(v1).put(v2, w);

    	if (!directed)
        	adjacencyMap.get(v2).put(v1, w);

    	return true;
  	}

	  public boolean removeVertex(Vertex vertex) {
        if (!containsVertex(vertex)) return false;

        for (Entry<Vertex, TreeMap<Vertex, Double>> entry: adjacencyMap.entrySet()) {
        	entry.getValue().remove(vertex);
        }
        adjacencyMap.remove(vertex);
        return true;
   	}

  	/* (non-Javadoc)
	   * @see org.eda1.practica04.edaAuxiliar.Graph#removeEdge(java.lang.Object, java.lang.Object)
	   */
	  public boolean removeEdge (Vertex v1, Vertex v2) {
    	if (!containsEdge(v1,v2)) return false;

    	adjacencyMap.get(v1).remove(v2);

    	if (!directed) {
        	adjacencyMap.get(v2).remove(v1);
    	}

    	return true;
  	}

	  public Set<Vertex> vertexSet() {
    	return adjacencyMap.keySet();
  	}

  	/**
  	 *  Returns a treset object of the neighbors of a specified Vertex object.
  	 *
  	 *  @param v - the Vertex object whose neighbors are returned.
  	 *
  	 *  @return a LinkedList of the vertices that are neighbors of v.
   	 */

  	public TreeSet<Vertex> getNeighbors(Vertex v) {
  		//TODO
  		TreeSet<Vertex> ts= new TreeSet<Vertex> ();
  		if(!adjacencyMap.containsKey(v)){
  			return ts;

  		}
  		 ts.addAll(adjacencyMap.get(v).keySet());
  		return ts;
  	}
	  @Override
  	public String toString() {
    	return adjacencyMap.toString();
  	}


	/////////Dijkstra

	/**
	 * Dijkstra.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @return the array list
	 */
	public ArrayList<Vertex> Dijkstra(Vertex source, Vertex destination) {
  		final double INFINITY = Double.MAX_VALUE;

  		Double weight = .0, minWeight = INFINITY;
    	TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
    	TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
    	TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();

    	ArrayList<Vertex> path = new ArrayList<Vertex>();
    	//ALStack<Vertex> st = new ALStack<Vertex>();
		Deque<Vertex> st = new ArrayDeque<Vertex>();
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
		while (!st.peek().equals(source)) {
			st.push(S.get(st.peek()));
		}
		while (!st.isEmpty()) {
			path.add(st.peek());
			st.pop();
		}
		return path;
	}

/**
 * Compute distance from path.
 *
 * @param path the path
 * @return the double
 */
//de examen
	public double computeDistanceFromPath(ArrayList<Vertex> path){
		//TODO

		double cont=0.0;

		for (int i = 0; i < path.size()-1; i++) {
			Vertex f= path.get(i);
			Vertex d= path.get(i+1);
			cont+=adjacencyMap.get(f).get(d);

		}
		return cont;

	}

  	////Iterators

	/* (non-Javadoc)
	   * @see java.lang.Iterable#iterator()
	   */
	  @Override
	public Iterator<Vertex> iterator() { //Iterador sobre el conjunto de claves --> orden lexicografico
        return adjacencyMap.keySet().iterator();
  	}


  	/**
	   * Breadth first iterator.
	   *
	   * @param v the v
	   * @return the breadth first iterator
	   */
	  public BreadthFirstIterator breadthFirstIterator (Vertex v) { //Iterador en anchura a partir de v
    	if (!adjacencyMap.containsKey(v)) return null;
    	return new BreadthFirstIterator(v);
  	}


  	/**
	   * Depth first iterator.
	   *
	   * @param v the v
	   * @return the depth first iterator
	   */
	  public DepthFirstIterator depthFirstIterator (Vertex v) { //Iterador en profundidad a partir de v
    	if (!adjacencyMap.containsKey (v)) return null;
    	return new DepthFirstIterator(v);
  	}

  	//toArray() methods

  	//dos recorrido en anchura-se guarda en una cola y profundidad-en una pila
  	/**
	   * To array df recursive.
	   *
	   * @param start the start
	   * @return the array list
	   */
	  //puede entrar examen
	public ArrayList<Vertex> toArrayDFRecursive(Vertex start) {
		//TODO


		ArrayList<Vertex> result = new ArrayList<Vertex>();
		TreeMap<Vertex, Boolean> visited = new TreeMap<Vertex, Boolean>();

		for (Vertex v : adjacencyMap.keySet()) {
			visited.put(v, false);
		}

//		Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
//		while (itr.hasNext())
//			visited.put(itr.next(), false);
		toArrayDFAux(start, result, visited);
		return result;
	}


	/**
	 * To array df aux.
	 *
	 * @param current the current
	 * @param result the result
	 * @param visited the visited
	 */
	//Examen
	private void toArrayDFAux(Vertex current, ArrayList<Vertex> result, TreeMap<Vertex,Boolean> visited) {
	//TODO
			result.add(current);
			visited.put(current, true);//el nodo actual lo pone a tru
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);//treemap aux de los vecinos, para decidir a quien puede ir
			for (Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				Vertex to = entry.getKey();//
				if (!visited.get(to))//si no esta  visitado  hago llamada recursiva
					toArrayDFAux(to, result, visited);
			}
		}

	/**
	 * To array df.
	 *
	 * @param start the start
	 * @return the array list
	 */
	//examen
	public ArrayList<Vertex> toArrayDF(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		for (Vertex v: this.depthFirstIterator(start)){
			result.add(v);
		}
		return result;
	}

	/**
	 * To array bf.
	 *
	 * @param start the start
	 * @return the array list
	 */
	public ArrayList<Vertex> toArrayBF(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		for (Vertex v : this.breadthFirstIterator(start)){
			result.add(v);
		}
		return result;
	}

  	/**
	   * The Class BreadthFirstIterator.
	   */
	  protected class BreadthFirstIterator implements Iterator<Vertex>, Iterable<Vertex> {

		    /** The queue. */
		    protected Queue<Vertex> queue;

    		/** The visited. */
		    protected TreeMap<Vertex, Boolean> visited;

    		/** The current. */
		    protected Vertex current;

    		/**
		     * Instantiates a new breadth first iterator.
		     *
		     * @param start the start
		     */
		    public BreadthFirstIterator (Vertex start)
    		{
      			queue = new LinkedList<Vertex>();

      			visited = new TreeMap<Vertex, Boolean>();

      			for (Vertex v : adjacencyMap.keySet()){
      				visited.put(v,false);
      			}

      			queue.add(start);
      			visited.put (start, true);
    		} // one-parameter constructor


		    public boolean hasNext()
    		{
      			return !(queue.isEmpty());
    		} // method hasNext


		    public Vertex next()
    		{
      			current = queue.poll();

            	for (Vertex to : adjacencyMap.get(current).keySet()) {
        			if (!visited.get(to))
        			{
          				visited.put (to, true);
          				queue.add(to);
        			}
      			}
      			return current;
    		} // method next


		    public void remove()
    		{
      			removeVertex (current);
    		} // method remove


			@Override
			public Iterator<Vertex> iterator() {
				return this;
			}

  	} // class BreadthFirstIterator


  	/**
	   * The Class DepthFirstIterator.
	   */
	  protected class DepthFirstIterator implements Iterator<Vertex>, Iterable<Vertex>{

    		/** The stack. */
		    Deque<Vertex> stack;

    		/** The visited. */
		    TreeMap<Vertex, Boolean> visited;

    		/** The current. */
		    Vertex current;


    		/**
		     * Instantiates a new depth first iterator.
		     *
		     * @param start the start
		     */
		    public DepthFirstIterator (Vertex start)
    		{
      			stack = new ArrayDeque<Vertex>();

      			visited = new TreeMap<Vertex, Boolean>();

      			for (Vertex v : adjacencyMap.keySet()){
      				visited.put(v, false);
      			}

      			stack.push (start);
      			visited.put (start, true);
    		} // one-parameter constructor


    		/* (non-Javadoc)
		     * @see java.util.Iterator#hasNext()
		     */
		    public boolean hasNext()
    		{
      			return !(stack.isEmpty());
    		} // method hasNext


    		/* (non-Javadoc)
		     * @see java.util.Iterator#next()
		     */
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

			@Override
			public Iterator<Vertex> iterator() {
				return this;
			}

  	} // class DepthFirstIterator

} // class Network
