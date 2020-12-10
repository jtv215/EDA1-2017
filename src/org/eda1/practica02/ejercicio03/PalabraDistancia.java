package org.eda1.practica02.ejercicio03;

/**
 * The Class PalabraDistancia.
 */
public class PalabraDistancia implements Comparable<PalabraDistancia> {

	/** The palabra. */
	private String palabra;

	/** The distancia. */
	private int distancia;


	/**
	 * Instantiates a new palabra distancia.
	 *
	 * @param pal the pal
	 * @param dis the dis
	 */
	public PalabraDistancia(String pal, int dis) {
		this.palabra = pal;
		this.distancia = dis;
	}

	/**
	 * Instantiates a new palabra distancia.
	 *
	 * @param pal the pal
	 */
	public PalabraDistancia(String pal) {
		this.palabra = pal;
		this.distancia = Integer.MAX_VALUE;
	}

	/**
	 * Gets the distancia.
	 *
	 * @return the distancia
	 */
	public int getDistancia(){
		return this.distancia;
	}

	/**
	 * Gets the palabra.
	 *
	 * @return the palabra
	 */
	public String getPalabra(){
		return this.palabra;
	}

	@Override
	public int compareTo(PalabraDistancia otra) {
		//Comparamos this.palabra con otra.palabra
		return this.palabra.compareTo(otra.palabra);
	}

//	@Override
//	public boolean equals(Object obj) {
//		//Comparamos this.palabra con otra.palabra
//
//		PalabraDistancia aux = (PalabraDistancia) obj;
//		return getPalabra().equals(aux.getPalabra());
//	}

@Override
	public String toString() {
		return "[" + palabra + " - " + distancia + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabraDistancia other = (PalabraDistancia) obj;
		if (palabra == null) {
			if (other.palabra != null)
				return false;
		} else if (!palabra.equals(other.palabra))
			return false;
		return true;
	}
}
