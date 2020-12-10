package org.eda1.actividad01.serializacionED;

import java.io.Serializable;

import org.eda1.actividad01.edaAuxiliar.LinkedList;

/**
 * The Class CiudadBarrios.
 */
public class CiudadBarrios implements Serializable {

	/** Los atributos de la clase ciudad Barrios. */
	private static final long serialVersionUID = 1L;

	/** The ciudad. */
	public String ciudad;

	/** The latitud. */
	public Double latitud;

	/** The longitud. */
	public Double longitud;

	/** The barrios. */
	LinkedList<String> barrios;

	/**
	 *  Constructor por defecto.
	 */
	public CiudadBarrios() {
		this.ciudad = "";
		this.latitud = .0;
		this.longitud = .0;
		this.barrios = new LinkedList<String>();
	}

	/**
	 * Instantiates a new ciudad barrios.
	 *
	 * @param ciudad the ciudad
	 * @param latitud the latitud
	 * @param longitud the longitud
	 */
	public CiudadBarrios(String ciudad, Double latitud, Double longitud) {
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.barrios = new LinkedList<String>();
	}

	/**
	 * Adds the barrio.
	 *
	 * @param barrio the barrio
	 * @return true, if successful
	 */
	public boolean addBarrio(String barrio) {
		// TODO
		// si no tiene el metodo string habria que hacerlo con equals
		if (this.barrios.contains(barrio)) {
			return false;

		}
		return this.barrios.add(barrio);
	}


	@Override
	/**El toString de la ciudadBarrios devuelve
	 * un string con Ciudad, latitud, longitud y entre corchetes los barrios de esa ciudad.
	 */
	public String toString() {
		String s = "[" + ciudad + ", " + latitud + ", " + longitud + ", {";
		for (int i = 0; i < this.barrios.size(); i++) {
			s += barrios.get(i);
			if (i < barrios.size() - 1) {
				s += ", ";
			}
		}

		s += "}]";
		return s;

	}
}
