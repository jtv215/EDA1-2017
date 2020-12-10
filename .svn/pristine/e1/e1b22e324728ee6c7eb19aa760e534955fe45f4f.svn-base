package org.eda1.practica02.ejercicio02;

import org.eda1.practica02.edaAuxiliar.AVLTree;

/**
 * The Class ProyectoCiudades.
 */
public class ProyectoCiudades implements Comparable<ProyectoCiudades> {

	/** The proyecto. */
	private String proyecto;

	/** The ciudades. */
	private AVLTree<String> ciudades;

	/**
	 * Constructores de ProyectoCiudades.
	 *
	 * @param proyecto the proyecto
	 * @param ciudad the ciudad
	 */

	public ProyectoCiudades(String proyecto, String ciudad){
		this.proyecto = proyecto;
		this.ciudades = new AVLTree<String>();
		this.ciudades.add(ciudad);
	}

	/**
	 * Adds the ciudad a ciudades
	 *
	 * @param ciudad the ciudad
	 * @return true, if successful
	 */
	public boolean add(String ciudad) {

			return ciudades.add(ciudad);
	}

	/**
	 * Gets the proyecto.
	 *
	 * @return the proyecto
	 */
	public String getProyecto(){
		return this.proyecto;
	}

	/**
	 * Gets the ciudades.
	 *
	 * @return the ciudades
	 */
	public AVLTree<String> getCiudades(){
		return this.ciudades;
	}


	@Override
	public int compareTo(ProyectoCiudades otro) {
		//Comparamos this.proyecto con otro.proyecto
		return this.proyecto.compareTo(otro.getProyecto());
	}


	@Override
	public String toString(){
		String s= this.proyecto+ciudades.toString().replace("[", "<").replace("]", ">");

		return s;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return ciudades.size();
	}



}
