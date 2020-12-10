package org.eda1.actividad02.ejercicio01;

import java.util.*;

/**
 * The Class Heap.
 *
 * @param <T> the generic type
 */
public class Heap<T extends Comparable<T>> {

	/** The Constant DEFAULT_INITIAL_CAPACITY. */
	protected static final int DEFAULT_INITIAL_CAPACITY = 7;

	/** The heap. */
	private ArrayList<T> theHeap;

	/** The comparator. */
	private Comparator<T> comparator;

	/**
	 * Inicializa el Heap a una capacidad inicial especificada por
	 * initialCapacity, y con elementos que estan ordenados por un objeto
	 * Comparator dado.
	 *
	 * @param initialCapacity
	 *            - Capacidad inicial para el Heap.
	 * @param comp
	 *            - el objeto Comparator.
	 *
	 */
	public Heap(int initialCapacity, Comparator<T> comp) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		this.theHeap = new ArrayList<T>(initialCapacity);
		this.comparator = comp;
	} // constructor con una capacidad inicial y un Comparator

	/**
	 * Inicializa el Heap con una capacidad inicial por defecto
	 * DEFAULT_INITIAL_CAPACITY y con elementos en una clase que implemente la
	 * interfaz Comparable.
	 */
	public Heap() {
		this.theHeap = new ArrayList<T>(DEFAULT_INITIAL_CAPACITY);
		this.comparator = null;
	} // constructor por defecto

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos en una clase que implementa la interface Comparable.
	 *
	 * @param initialCapacity            - la capacidad inicial del Heap.
	 */
	public Heap(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		this.theHeap = new ArrayList<T>(initialCapacity);
		this.comparator = null;
	} // constructor con una capacidad inicial

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos comparados segun el objeto Comparator comp.
	 *
	 * @param comp
	 *            - el objeto Comparator utilizado para comparar elementos en el
	 *            Heap
	 *
	 */
	public Heap(Comparator<T> comp) {
		this.theHeap = new ArrayList<T>(DEFAULT_INITIAL_CAPACITY);
		this.comparator = comp;
	} // constructor con parametro Comparator

	/**
	 * Inicializa este Heap con un objeto Heap pasado por parametro Los
	 * elementos en este Heap se compararan como se especifiquen en el objeto
	 * Heap que se pasa como parametro The worstTime(n) is O(n), donde n es el
	 * numero de elementos en el Heap pasado como parametro.
	 *
	 * @param otherHeap
	 *            - el Heap que se va a copiar en en objeto heap actual
	 *
	 */
	public Heap(Heap<T> otherHeap) {
		theHeap = new ArrayList<T>(otherHeap.theHeap);
		comparator = otherHeap.comparator;
	} // constructor copia

	/**
	 * Inicializa este Heap con un objeto array pasado por parametro.
	 *
	 * @param array the array
	 * @param comp            - el objeto Comparator utilizado para comparar elementos en el
	 *            Heap
	 */
	public Heap(T[] array, Comparator<T> comp) {
		theHeap = new ArrayList<T>();
		for (T v : array)
			theHeap.add(v);
		comparator = comp;
	} // constructor copia

	/**
	 * Devuelve el numero de elementos en el Heap.
	 *
	 * @return numero de elementos que hay en este Heap.
	 */
	public int size() {
		return theHeap.size();
	} // metodo size

	/**
	 * Determina si el Heap no tiene elementos (est��� vacio).
	 *
	 * @return true - si el heap no tiene elementos, en otro caso false;
	 *
	 */
	public boolean isEmpty() {
		return theHeap.isEmpty();
	} // metodo isEmpty

	/**
	 * Inserta un elemento en el Heap. The worstTime(n) is O(n) and
	 * averageTime(n) is constant.
	 *
	 * @param element
	 *            - el elemento que va a ser insertado en el Heap
	 *
	 */
	public void add(T element) {
		theHeap.add(element);
		siftUp();
	} // metodo add

	/**
	 * Restaura las propiedades del Heap, empezando desde el final hasta la raiz
	 *
	 * The worstTime(n) is O(log n), and averageTime(n) is constant.
	 *
	 */
	protected void siftUp() {
		int child = theHeap.size() - 1, parent = 0;

		while (child > 0) {
			parent = (child - 1) >> 1; // >> 1 is slightly faster than / 2 =>
										// (child - 1) / 2
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			child = parent;
		}
	} // metodo siftUp

	/**
	 * Compara dos elementos dados segun Comparable (si el comparator es null) o
	 * un objeto Comparator.
	 *
	 * @param element1            - uno de los elementos a comparar.
	 * @param element2            - el otro elemento a comparar.
	 * @return un entero negativo, 0, o un entero positivo, dependiendo de si
	 *         element1 es menor que, igual a o mayor que element2.
	 */
	protected int compare(T element1, T element2) {
		return (comparator == null ? ((Comparable<T>) element1).compareTo(element2)
				: comparator.compare(element1, element2));
	}

	/**
	 * Intercambia dos elementos del Heap (parent y child).
	 *
	 * @param parent
	 *            - el indice del elemento padre (parent).
	 * @param child
	 *            - el indice del elemento hijo (child).
	 *
	 */
	protected void swap(int parent, int child) {
		T temp = theHeap.get(parent);
		theHeap.set(parent, theHeap.get(child));
		theHeap.set(child, temp);
	} // metodo swap

	/**
	 * Devuelve el elemento con el menor valor del Heap.
	 *
	 * @return el elemento con el menor valor del Heap.
	 *
	 * @throws NoSuchElementException
	 *             - si el Heap est��� vac���o.
	 *
	 */
	public T getMin() {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Empty heap");
		return theHeap.get(0);
	} // metodo getMin

	/**
	 * Gets the value.
	 *
	 * @param i the i
	 * @return the value
	 */
	public T getValue(int i) {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Empty heap");
		if ((i < 0) || (i >= theHeap.size()))
			return null;
		return theHeap.get(i);
	} // metodo getValue

	/**
	 * Elimina el elemento con el menor valor del Heap. The worstTime(n) is
	 * O(log n).
	 *
	 * @return el elemento eliminado.
	 *
	 * @throws NoSuchElementException
	 *             - si el Heap est��� vac���o.
	 *
	 */
	public T removeMin() {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Empty heap");

		T minElem = theHeap.get(0);
		theHeap.set(0, theHeap.get(theHeap.size() - 1));
		theHeap.remove(theHeap.size() - 1);
		siftDown(0);
		return minElem;
	} // metodo removeMin

	/**
	 * Restaura las propiedades del Heap (hundir) The worstTime(n) is O(log n).
	 *
	 * @param start
	 *            - el indice del Heap donde va a empezar la restauracion de la
	 *            propiedad.
	 *
	 */
	protected void siftDown(int start) {
		int parent = start, child = (parent << 1) + 1; // parent << 1 is
														// slightly faster than
														// parent * 2 => (2 *
														// parent) + 1

		while (child < theHeap.size()) {
			if (child < theHeap.size() - 1 && compare(theHeap.get(child), theHeap.get(child + 1)) > 0)
				child++; // child es el indice derecho (child = (2 * parent) +
							// 2)
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	} // metodo siftDown

	public String toString() {
		return theHeap.toString();
	}

	// **********************************
	// ***** NEW ADDITIONAL METHODS *****
	// **********************************

	/**
	 * Sift down.
	 *
	 * @param start the start
	 * @param end the end
	 */
	protected void siftDown(int start, int end) {
		int parent = start, child = (parent << 1) + 1; // parent << 1 is
														// slightly faster than
														// parent * 2 => (2 *
														// parent) + 1

		while (child < end) {
			if (child < end - 1 && compare(theHeap.get(child), theHeap.get(child + 1)) > 0)
				child++; // child es el indice derecho (child = (2 * parent) +
							// 2)
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	}

	/**
	 * Assign.
	 *
	 * @param index the index
	 * @param value the value
	 */
	public void assign(int index, T value) {
		theHeap.add(index, value);
	}

	/**
	 * Make heap.
	 */
	public void makeHeap() {
		int n = theHeap.size();
		for (int i = (n / 2) - 1; i >= 0; i--) {
			siftDown(i);

		}

	}
//TODO puede ser de examen
	/**
 * Checks if is heap top down.
 *
 * @return true, if is heap top down
 */
// Top_Down
	public boolean isHeapTopDown() {
		int n = theHeap.size();
		for (int i = 0; i <= n / 2; i++) {// recoremos los nodos
											// intermedios(incluido la raiz)
			if (compare(theHeap.get(i), theHeap.get(2 * i + 1)) > 0) {
				return false;
			}
			//si tiene hijo derecho tiene que ser menor de su arrya
			if (2 * i + 2 < n && compare(theHeap.get(i), theHeap.get(2 * i +2 )) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if is heap.
	 *
	 * @return true, if is heap
	 */
	// Botton_Up
	public boolean isHeap() {

		int n= theHeap.size();
		for(int i= n-1; i>0;i--){
			if(compare(theHeap.get((i-1)/2), theHeap.get(i))>0){
				return false;
			}
		}
		return true;
	}

	/**
	 * Branch min sum.
	 *
	 * @return the string
	 */
	public String branchMinSum() {
		int total=Integer.MAX_VALUE;
		int suma=0;
		String camino="";
		String temp="";
		int n=theHeap.size();
		for(int i=n/2;i<n;i++){
			suma=(int) theHeap.get(i);
			temp=theHeap.get(i).toString()+" ";
			int parent=i;
		while (parent!=0){
			parent=(parent-1)/2;
			suma+=(int) theHeap.get(parent);
			temp+=theHeap.get(parent).toString()+" ";
		}
		if(suma<total){
			total=suma;
			camino=temp;
		}
		}
return "<"+total+"> --- "+camino;
	}

	/**
	 * Sift up.
	 *
	 * @param start the start
	 */
	protected void siftUp(int start) {

		int child = start, parent = 0;

		while (child > 0) {
			parent = (child - 1) >> 1; // >> 1 is slightly faster than / 2 =>
										// (child - 1) / 2
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			child = parent;

		} // metodo siftUp(start)
	}

	/**
	 * Replace key.
	 *
	 * @param i the i
	 * @param x the x
	 * @return true, if successful
	 */
	public boolean replaceKey(int i, T x) {
		if(i<0|| i>=theHeap.size()){
			return false;
		}
		T aux= theHeap.get(i);
		theHeap.set(i, x);
		if(compare(aux,x)>0){
			siftUp(i);
		}else{
			siftDown(i);
		}

return true;

} // class Heap
}
