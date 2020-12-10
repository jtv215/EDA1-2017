package org.eda1.actividad02.ejercicio02;


import java.util.Comparator;

public class Less<T extends Comparable<T>> implements Comparator<T> {
	/**
	 * Compara dos elementos dados según Comparable o un objeto Comparator.
	 *
	 * @param element1            - uno de los elementos a comparar.
	 * @param element2            - el otro elemento a comparar.
	 * @return un entero negativo, 0, o un entero positivo, dependiendo de si
	 *         element1 es menor que, igual a o mayor que element2.
	 */
	@Override
	public int compare(T element1, T element2){
		//Orden natural

		return element1.compareTo(element2);
		}
}
