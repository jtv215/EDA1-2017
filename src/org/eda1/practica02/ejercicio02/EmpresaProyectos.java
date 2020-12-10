package org.eda1.practica02.ejercicio02;

import java.util.Iterator;

import org.eda1.practica02.edaAuxiliar.AVLTree;

/**
 * The Class EmpresaProyectos.
 */
public class EmpresaProyectos implements Comparable<EmpresaProyectos> {

	/** The empresa. */
	private String empresa;

	/** The proyectos ciudades. */
	private AVLTree<ProyectoCiudades> proyectosCiudades;

	/**
	 * Constructor de EmpresaProyectos.
	 *
	 * @param empresa the empresa
	 */
	public EmpresaProyectos(String empresa) {
		this.empresa = empresa;
		this.proyectosCiudades = new AVLTree<ProyectoCiudades>();
	}

	/**
	 * Metodo add de proyectoCiudades.
	 *
	 * @param proyecto the proyecto
	 * @param ciudad the ciudad
	 * @return true, if successful
	 */
	public boolean add(String proyecto, String ciudad) {

		ProyectoCiudades pc = new ProyectoCiudades(proyecto, ciudad);
		ProyectoCiudades aux = proyectosCiudades.find(pc);

		if (aux != null) {
			return aux.add(ciudad);
		}
		return proyectosCiudades.add(pc);
	}

	/**
	 * Gets the proyecto ciudades.
	 *
	 * @return the proyecto ciudades
	 */
	public AVLTree<ProyectoCiudades> getProyectoCiudades() {
		return this.proyectosCiudades;
	}

	@Override
	public int compareTo(EmpresaProyectos otra) {
		return this.empresa.compareTo(otra.empresa);
	}

	@Override
	public String toString() {
		String s = this.empresa + ": ";
		// int i=0;
		// for (ProyectoCiudades pc : proyectosCiudades) {
		// s+=pc.toString();
		// if(i<proyectosCiudades.size()-1){
		// s+="; ";
		//
		// }
		// i++;
		// }
		// s+="\n";
		//
		// return s;

		Iterator<ProyectoCiudades> it = proyectosCiudades.iterator();
		while (it.hasNext()) {
			s += it.next().toString();
			if (it.hasNext()) {
				s += ", ";
			}
		}

		return s;
	}

	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public String getEmpresa() {
		return this.empresa;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return proyectosCiudades.size();
	}
}
