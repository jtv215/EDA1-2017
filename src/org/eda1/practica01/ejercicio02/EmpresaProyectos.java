package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;


/**
 * The Class EmpresaProyectos.
 */
public class EmpresaProyectos{

	/** The empresa. */
	private String empresa;

	/** The proyectos ciudades. */
	private ArrayList<ProyectoCiudades> proyectosCiudades;

	/**
	 * Constructor de EmpresaProyectos.
	 */

	public EmpresaProyectos() {
		this.empresa = new String();
		this.proyectosCiudades = new ArrayList<ProyectoCiudades>();
	}

	/**
	 * Instantiates a new empresa proyectos.
	 *
	 * @param empr the empr
	 */
	public EmpresaProyectos(String empr) {
		this.empresa = empr;
		this.proyectosCiudades = new ArrayList<ProyectoCiudades>();
	}

	/**
	 * Metodo addProyectoCiudad .
	 *
	 * @param proyecto the proyecto
	 * @param ciudad the ciudad
	 */
	public void addProyectoCiudad(String proyecto, String ciudad) {

		// Procesar la lista para ver si exite el proyecto
		// Si el proyecto esta, comprobar si esta ya esa ciudad
		// Si esta la ciudad, NO hacer nada
		// Si no esta la ciudad aÃ±adirla a la lista de proyecto de la empresa
		//(Comprobad funcionalidad de addCiudad() --> ProyectoCiudades)
		// Si el proyecto no esta
		// AÃ±adir el par (proyecto, ciudad) y aÃ±adir a la lista de dias el dia

		//el de la izque es el tipo; ojo aqui compruebo si el proyecto se repite que agrega ciudad y ya ciudad se encargar de si esta repetido
		for (ProyectoCiudades pc : proyectosCiudades) {
			if(pc.getProyecto().equals(proyecto)){
				pc.addCiudad(ciudad);//el metodo  de la clase proyectoCiudades ya se encarga si ya esta añadido
				return;//para que no pare el for.

			}
		}
		//creo un tipo proyectoCiudad donde me van a pasar el proyecto
		ProyectoCiudades pc=new ProyectoCiudades(proyecto);
		pc.addCiudad(ciudad);
		proyectosCiudades.add(pc);//añadimos a la la lista proyectoCiudad ,


	}

	/**
	 * Metodo setter del empresa.
	 *
	 * @param empr the new empresa
	 */
	public void setEmpresa(String empr) {
		this.empresa = empr;
	}

	/**
	 * Metodo getter del empresa.
	 *
	 * @return empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Metodo geproyectosCiudades
	 *
	 * @return ArrayList<ProyectoCiudades> proyectosCiudades
	 */
	public ArrayList<ProyectoCiudades> getProyectosCiudades() {
		return proyectosCiudades;
	}

	/**
	 * Metodo getProyectoCiudades.
	 *
	 * @param i the i
	 * @return ProyectoCiudades proyectosCiudades[i]
	 */
	public ProyectoCiudades getProyectoCiudades(int i) {
		return proyectosCiudades.get(i);
	}

	/**
	 * Metodo getter del tamano.
	 *
	 * @return tamaño
	 */
	public int size() {
		return proyectosCiudades.size();
	}

	/**String devuelve el nombre de la empresa seguido del toString del proyetoCiudad
	 *
	 */
	@Override
	public String toString(){
		String s= this.empresa+": ";
		for(int i=0 ; i<proyectosCiudades.size();i++){
			s+=proyectosCiudades.get(i).toString();
			if(i<proyectosCiudades.size()-1){
				s+="; ";
			}
		}
		s+="\n";
		return s;
	}

}
