//package org.eda1.actividad05.edaAuxiliar;
//
//import java.util.*;
//import java.util.Map.Entry;
//
//
//public class Network<Vertex extends Comparable<Vertex>> implements Graph<Vertex>, Iterable<Vertex> {
//
//	protected boolean directed; 	// directed = false (unDirected), directed = true (DiGraph)
//
//	protected TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;
//	protected TreeMap<Vertex, Integer> vertexToIndex;
//	protected double[][] matrixD;
//	protected int[][] matrixA;
//
//	public Network(){
//		this.directed = true;
//		this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
//		this.vertexToIndex = new TreeMap<Vertex, Integer>();
//		this.matrixA = null;
//		this.matrixD = null;
//	}
//
//   	public Network(boolean uDOrD) { //uDOrD == unDirected Or Directed
//  		this.directed = uDOrD;
//		this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
//		this.vertexToIndex = new TreeMap<Vertex, Integer>();
//		this.matrixA = null;
//		this.matrixD = null;
//	}
//
//  	public void setDirected(boolean uDOrD) {
//  		this.directed = uDOrD;
//  	}
//
//  	public boolean getDirected() {
//  		return this.directed;
//  	}
//
//  	@Override
//  	public boolean isEmpty() {
//    	return this.adjacencyMap.isEmpty();
//  	}
//
//  	@Override
//  	public void clear() {
//		this.adjacencyMap.clear();
//	}
//
//  	@Override
//  	public int numberOfVertices() {
//    	return this.adjacencyMap.size();
//  	}
//
//  	@Override
//  	public int numberOfEdges() {
//  		int count = 0;
//  		for (Entry<Vertex, TreeMap<Vertex, Double>> entry : this.adjacencyMap.entrySet())
//  			count += entry.getValue().size();
//  		return count;
//  	}
//
//  	@Override
//  	public boolean containsVertex(Vertex vertex) {
//    	return this.adjacencyMap.containsKey(vertex);
//  	}
//
//  	@Override
//  	public boolean containsEdge(Vertex v1, Vertex v2) {
//    	return this.adjacencyMap.containsKey(v1) && this.adjacencyMap.get(v1).containsKey(v2);
//  	}
//
//  	@Override
//  	public double getWeight (Vertex v1, Vertex v2) {
//  		if (!containsEdge(v1, v2)) return -1;
//  		return this.adjacencyMap.get(v1).get(v2);
//   	}
//
//  	@Override
//  	public double setWeight (Vertex v1, Vertex v2, double w) {
//  		if (!containsEdge(v1, v2)) return -1;
//		double oldWeight = this.adjacencyMap.get(v1).get(v2);
//		this.adjacencyMap.get(v1).put(v2, w);
//		return oldWeight;
//	}
//
//  	public boolean isAdjacent (Vertex v1, Vertex v2) {
//		return (this.adjacencyMap.containsKey(v1) && this.adjacencyMap.get(v1).containsKey(v2));
//
//	}
//
//  	public boolean addVertex(Vertex vertex) {
//        if (this.adjacencyMap.containsKey(vertex))   return false;
//        this.adjacencyMap.put(vertex, new TreeMap<Vertex, Double>());
//        return true;
//  	}
//
//  	public boolean addEdge(Vertex v1, Vertex v2, double w) {
//  		if (!containsVertex(v1) || !containsVertex(v2)) return false;
//  		this.adjacencyMap.get(v1).put(v2, w);
//
//    	if (!this.directed)
//        	this.adjacencyMap.get(v2).put(v1, w);
//
//    	return true;
//  	}
//
//  	public boolean removeVertex(Vertex vertex) {
//        if (!containsVertex(vertex)) return false;
//
//        for (Entry<Vertex, TreeMap<Vertex, Double>> entry: this.adjacencyMap.entrySet()) {
//        	entry.getValue().remove(vertex);
//        }
//        this.adjacencyMap.remove(vertex);
//        return true;
//   	}
//
//  	public boolean removeEdge (Vertex v1, Vertex v2) {
//    	if (!containsEdge(v1,v2)) return false;
//
//    	this.adjacencyMap.get(v1).remove(v2);
//
//    	if (!directed) {
//        	this.adjacencyMap.get(v2).remove(v1);
//    	}
//
//    	return true;
//  	}
//
//  	public Set<Vertex> vertexSet() {
//    	return this.adjacencyMap.keySet();
//  	}
//
//
//  	public TreeSet<Vertex> getNeighbors(Vertex v) {
//    	if (this.adjacencyMap.containsKey(v)) return null;
//    	return new TreeSet<Vertex>(this.adjacencyMap.get(v).keySet());
//  	}
//
//  	@Override
//  	public String toString() {
//    	return this.adjacencyMap.toString();
//  	}
//
//
//	/////////Dijkstra
//
//	public ArrayList<Vertex> Dijkstra(Vertex source, Vertex destination) {
//  		final double INFINITY = Double.MAX_VALUE;
//
//  		Double weight = .0, minWeight = INFINITY;
//    	TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
//    	TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
//    	TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
//
//    	ArrayList<Vertex> path = new ArrayList<Vertex>();
//    	//ALStack<Vertex> st = new ALStack<Vertex>();
//		Deque<Vertex> st = new ArrayDeque<Vertex>();
//    	Vertex from = null;
//
//    	if (source == null || destination == null) return null;
//
//    	if (source.equals(destination))	return null;
//
//    	if (!(this.adjacencyMap.containsKey(source) && this.adjacencyMap.containsKey(destination))) return null;
//
//    	for (Vertex e : this.adjacencyMap.keySet()) {
//    		if (source.equals(e)) continue;
//    		V_minus_S.add(e);
//    	}
//
//    	for (Vertex v : V_minus_S){
//    		if (isAdjacent(source,v)){
//    			S.put(v, source);
//    			D.put(v, getWeight(source,v));
//    		}
//    		else{
//    			S.put(v, null);
//    			D.put(v, INFINITY);
//    		}
//    	}
//
//		S.put(source, source);
//		D.put(source, 0.0);
//
//		while (!V_minus_S.isEmpty()) {
//		    minWeight = INFINITY;
//		    from = null;
//		    for (Vertex v : V_minus_S){
//		    	if (D.get(v) < minWeight){
//		    		minWeight = D.get(v);
//		    		from = v;
//		    	}
//		    }
//	    	if (from == null) break;
//
//			V_minus_S.remove(from);
//
//		    for (Vertex v : V_minus_S){
//		    	if (isAdjacent(from,v)){
//		    		weight = getWeight(from,v);
//		    		if (D.get(from) + weight < D.get(v)){
//		    			D.put(v, D.get(from) + weight);
//		    			S.put(v, from);
//		    		}
//		    	}
//		    }
//		}
//
//
//		if (S.get(destination) == null) {
//			throw new RuntimeException("The vertex " + destination + " is not reachable from " + source);
//		}
//
//		st.push(destination);
//		while (!st.peek().equals(source)) {
//			st.push(S.get(st.peek()));
//		}
//		while (!st.isEmpty()) {
//			path.add(st.peek());
//			st.pop();
//		}
//		return path;
//	}
//
//
//	public double computeDistanceFromPath(ArrayList<Vertex> path){
//		double result=.0;
//		for (int i=1; i<path.size(); i++){
//			result += this.getWeight(path.get(i-1), path.get(i));
//		}
//		return result;
//	}
//
//	///Floyd
//	public void floyd() {
//		Vertex from, to;
//		double weight;
//		int n = numberOfVertices();
//
//		matrixD = new double[n][n];
//		matrixA = new int[n][n];
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				matrixA[i][j] = -1;
//				matrixD[i][j] = (i == j) ? 0 : Double.MAX_VALUE;
//			}
//		}
//
//		for (Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap.entrySet()) {
//			for (Entry<Vertex, Double> e2 : e1.getValue().entrySet()) {
//				from = e1.getKey();
//				to = e2.getKey();
//				weight = e2.getValue();
//				matrixD[vertexToIndex.get(from)][vertexToIndex.get(to)] = weight;
//			}
//		}
//		for (int k = 0; k < n; k++) {
//			for (int i = 0; i < n; i++) {
//				if (i == k)	continue;
//				for (int j = 0; j < n; j++) {
//					if (j == k || i == j) continue;
//					if (matrixD[i][k] == Double.MAX_VALUE || matrixD[k][j] == Double.MAX_VALUE)
//						continue;
//					if ((matrixD[i][k] + matrixD[k][j]) < matrixD[i][j]) {
//						matrixD[i][j] = matrixD[i][k] + matrixD[k][j];
//						matrixA[i][j] = k;
//					}
//				}
//			}
//		}
//	}
//
//  	////Iterators
//
//	@Override
//	public Iterator<Vertex> iterator() { //Iterador sobre el conjunto de claves --> orden lexicografico
//        return this.adjacencyMap.keySet().iterator();
//  	}
//
//
//  	public BreadthFirstIterator breadthFirstIterator (Vertex v) { //Iterador en anchura a partir de v
//    	if (!this.adjacencyMap.containsKey(v)) return null;
//    	return new BreadthFirstIterator(v);
//  	}
//
//
//  	public DepthFirstIterator depthFirstIterator (Vertex v) { //Iterador en profundidad a partir de v
//    	if (!this.adjacencyMap.containsKey (v)) return null;
//    	return new DepthFirstIterator(v);
//  	}
//
//  	//toArray() methods
//
//	public ArrayList<Vertex> toArrayDFRecursive(Vertex start) {
//		ArrayList<Vertex> result = new ArrayList<Vertex>();
//
//		TreeMap<Vertex,Boolean> visited = new TreeMap<Vertex, Boolean>();
//
//		for (Vertex v : this.adjacencyMap.keySet()){
//			visited.put(v,false);
//		}
//
//		toArrayDFAux(start, result, visited);
//
//		return result;
//	}
//
//	private void toArrayDFAux(Vertex current, ArrayList<Vertex> result, TreeMap<Vertex,Boolean> visited) {
//		result.add(current);
//		visited.put(current, true);
//		for (Vertex to : this.adjacencyMap.get(current).keySet()) {
//			if (!visited.get(to))
//				toArrayDFAux(to,result,visited);
//		}
//	}
//
//	public ArrayList<Vertex> toArrayDF(Vertex start) {
//		ArrayList<Vertex> result = new ArrayList<Vertex>();
//		for (Vertex v: this.depthFirstIterator(start)){
//			result.add(v);
//		}
//		return result;
//	}
//
//	public ArrayList<Vertex> toArrayBF(Vertex start) {
//		ArrayList<Vertex> result = new ArrayList<Vertex>();
//		for (Vertex v : this.breadthFirstIterator(start)){
//			result.add(v);
//		}
//		return result;
//	}
//
//  	protected class BreadthFirstIterator implements Iterator<Vertex>, Iterable<Vertex> {
//    		protected Queue<Vertex> queue;
//
//    		protected TreeMap<Vertex, Boolean> visited;
//
//    		protected Vertex current;
//
//    		public BreadthFirstIterator (Vertex start)
//    		{
//      			queue = new LinkedList<Vertex>();
//
//      			visited = new TreeMap<Vertex, Boolean>();
//
//      			for (Vertex v : adjacencyMap.keySet()){
//      				visited.put(v,false);
//      			}
//
//      			queue.add(start);
//      			visited.put (start, true);
//    		} // one-parameter constructor
//
//
//    		public boolean hasNext()
//    		{
//      			return !(queue.isEmpty());
//    		} // method hasNext
//
//
//    		public Vertex next()
//    		{
//      			current = queue.poll();
//
//            	for (Vertex to : adjacencyMap.get(current).keySet()) {
//        			if (!visited.get(to))
//        			{
//          				visited.put (to, true);
//          				queue.add(to);
//        			}
//      			}
//      			return current;
//    		} // method next
//
//
//    		public void remove()
//    		{
//      			removeVertex (current);
//    		} // method remove
//
//
//			@Override
//			public Iterator<Vertex> iterator() {
//				return this;
//			}
//
//  	} // class BreadthFirstIterator
//
//
//  	protected class DepthFirstIterator implements Iterator<Vertex>, Iterable<Vertex>{
//
//    		Deque<Vertex> stack;
//
//    		TreeMap<Vertex, Boolean> visited;
//
//    		Vertex current;
//
//
//    		public DepthFirstIterator (Vertex start)
//    		{
//      			stack = new ArrayDeque<Vertex>();
//
//      			visited = new TreeMap<Vertex, Boolean>();
//
//      			for (Vertex v : adjacencyMap.keySet()){
//      				visited.put(v, false);
//      			}
//
//      			stack.push (start);
//      			visited.put (start, true);
//    		} // one-parameter constructor
//
//
//    		public boolean hasNext()
//    		{
//      			return !(stack.isEmpty());
//    		} // method hasNext
//
//
//    		public Vertex next()
//    		{
//      			current = stack.pop();
//
//                for (Vertex to: adjacencyMap.get(current).keySet()) {
//        			if (!visited.get (to))
//        			{
//          				visited.put (to, true);
//          				stack.push (to);
//        			}
//      			}
//      			return current;
//    		}
//
//    		public void remove()
//    		{
//      			removeVertex (current);
//    		}
//
//			@Override
//			public Iterator<Vertex> iterator() {
//				return this;
//			}
//
//  	} // class DepthFirstIterator
//
//} // class Network
