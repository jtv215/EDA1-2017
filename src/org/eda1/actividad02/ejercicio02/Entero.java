package org.eda1.actividad02.ejercicio02;

/**
 * The Class Entero.
 */
public class Entero implements Comparable<Entero> {

	/** The entero. */
	Integer entero;

	/** The posicion. */
	int posicion;

	/**
	 * Instantiates a new entero.
	 *
	 * @param entero the entero
	 * @param posicion the posicion
	 */
	public Entero(Integer entero, int posicion) {
		this.entero = entero;
		this.posicion = posicion;
	}


	@Override
	public int compareTo(Entero o) {
		return this.entero.compareTo(o.entero);
	}

	@Override
	public boolean equals(Object otro) {
		Entero o = (Entero) otro;
		return this.entero == o.entero && this.posicion == o.posicion;
	}

	public String toString() {
		return "[" + this.entero + "," + this.posicion + "]";
	}

}
