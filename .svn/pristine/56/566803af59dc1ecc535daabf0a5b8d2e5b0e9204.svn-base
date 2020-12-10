package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;

import org.junit.internal.runners.model.EachTestNotifier;

public class ProyectoCiudades{
	private String proyecto;
	public  ArrayList<String> ciudades;

	/**
	 * Constructores de ProyectoCiudades
	 */
	public ProyectoCiudades() {
		this.proyecto = new String();
		this.ciudades = new ArrayList<String>();
	}

	public ProyectoCiudades(String proy) {
		this.proyecto = proy;
		this.ciudades = new ArrayList<String>();
	}

	/**
	 * Metodo setter del proyecto
	 */
	public void setProyecto(String proy) {
		this.proyecto = proy;
	}

	/**
	 * Metodo getter del proyecto
	 * @return proyecto
	 */
	public String getProyecto() {
		return proyecto;
	}

	/**
	 * Metodo add de las ciudades. Antes de insertar,
	 * comprobamos que la ciudad no existe (no queremos duplicados)
	 */
	public void addCiudad(String ciudad) {
		if(!ciudades.contains(ciudad)){
			ciudades.add(ciudad);
		}
	}

	/**
	 * Metodo getter de las ciudades
	 * @return ArrayList<String> cuidades
	 */
	public ArrayList<String> getCiudades() {
		return ciudades;
	}

	/**
	 * Metodo getter de la ciudades en la posici?n 'index'
	 * @return String ciudade
	 */
	public String getCiudad(int index) {
		return ciudades.get(index);
	}

	/**
	 * Metodo getter del tamano
	 * @return tamano
	 */
	public int size() {
		return ciudades.size();
	}
	/**
	 * toString devuelve todas las ciudades que que hay en ese proyecto
	 */
	@Override
	public String toString(){
		String s=this.proyecto+" <";
		for(int i=0;i<ciudades.size();i++){
			s+=ciudades.get(i);
			if(i<ciudades.size()-1){//condicion para ponerles una coma
				s+=", ";

			}
		}
		s+=">";
		return s;
	}



}
