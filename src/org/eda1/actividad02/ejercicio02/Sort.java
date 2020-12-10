package org.eda1.actividad02.ejercicio02;

import java.util.*;

import org.eda1.actividad02.ejercicio01.Heap;

/**
 * The Class Sort.
 */
public class Sort {

	/**
	 * Método sortHeap que recorre el array y lo inserta en un heap para después ir retirando los valores minimos
	 * y ordenarlos por minimos.
	 *
	 * @param <T> the generic type
	 * @param aList ArrayList a ordenar.
	 * @param comp Comparador que se utilizará para ordenar.
	 */
	public static <T extends Comparable<T>> void sortHeap(ArrayList<T> aList, Comparator<T> comp) {
		// shorheap en memoria ocupa mas que heapsort
		Heap<T> heap = new Heap<>(comp);// estrucutura auxiliar
		for (T t : aList) {// recorremos la lista y vamos agregando los elemntos
							// al heap
			heap.add(t);

		}
		aList.clear();// vaciamos la lista
		while (!heap.isEmpty()) {// vamos agregando a la lista el elemento
									// menor(raiz)
			aList.add(heap.removeMin());

		}

	} // method sortHeap

	/**
	 * The generic heapSort orders an array of elements of type <T> into
	 * ascending order using the Comparator<T> comp to provide the natural
	 * ordering of elements. If comp is an instance of Greater<T>, the array is
	 * sorted in ascending order. If comp is an instance of Less<T> the array is
	 * sorted in descending order.
	 *
	 * The sorting algorithm is has runtime efficiency O(n*log(n)) for the
	 * average case..
	 *
	 * @param <T> the generic type
	 * @param aList the a list
	 * @param comp            a <tt>Comparator</tt> that provides order for the sort; An
	 *            instance of <tt>Greater</tt> sorts in ascending order; an
	 *            instance of <tt>Less</tt>sorts in descending order.
	 */
	public static <T extends Comparable<T>> void heapSort(ArrayList<T> aList, Comparator<T> comp) {
		int n=aList.size();
		//makeHeap
		for (int i = n/2-1; i >=0; i--) {
			siftDown(aList, i, n, comp);

		}
		//KERNEL
		for (int i = n; i > 1; i--) {
			T aux = aList.get(0);
			aList.set(0, aList.get(i-1));
			aList.set(i-1, aux);
			siftDown(aList, 0, i-1, comp);


		}
		//invetir
		for (int i = 0; i < n/2; i++) {
			T aux = aList.get(i);
			aList.set(i, aList.get(n-i-1));
			aList.set(n-i-1, aux);
		}

	}

	/**
	 * Método que hunde (utilizando el sistema Heap) un elemento hasta una determinada posición del ArrayList.
	 *
	 * @param <T> the generic type
	 * @param aList Array a manejar.
	 * @param first Posición extrema desde la cual empezamos a hundir.
	 * @param last Posición extrema final hasta la cual terminamos de hundir.
	 * @param comp Tipo de comparador para determinar si se hunde o no.
	 */
	private static <T> void siftDown(ArrayList<T> aList, int first, int last, Comparator<T> comp) {
		int parent = first, child = (parent << 1) + 1; // parent << 1 is
		// slightly faster than
		// parent * 2 => (2 *
		// parent) + 1

		while (child < last) {
			if (child < last - 1 && comp.compare(aList.get(child), aList.get(child + 1)) > 0)
				child++; // child es el indice derecho (child = (2 * parent) +
			// 2)
			if (comp.compare(aList.get(child), aList.get(parent)) >= 0)
				break;
			T aux = aList.get(parent);
			aList.set(parent, aList.get(child));
			aList.set(child, aux);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	}

} // class HeapSort
