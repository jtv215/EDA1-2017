package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Clase que contiene los metodos necesarios para procesar el archivo y generar
 * la ED ...
 *
 * @author Antonio Corral Liria
 * @author Francisco Guil
 */


//Empresa_Software ej : adobe, microsof
//Proyecto_Software ej: word, excel flash
//Ciudad_Donde_Se_Desarrolla, ej hoston..
//almacenando en una estructura de datos basada en ArrayList de la JCF.

public class ProcesarDatos {

	/**
	 * Metodo que lee las lineas del archivo correspondiente y las devuelve en
	 * un ED de array de array de String.
	 *
	 * @return un array de String con las notas
	 */
	private ArrayList<EmpresaProyectos> listaEmpresas = new ArrayList<EmpresaProyectos>();


	/**
	 *  cargar archivos.
	 *
	 * @param file the file
	 */
	public void cargarArchivo(String file) {
		Scanner fileScanner = null;
		EmpresaProyectos eP = null;
		int idEmpresa = -1;
		String[] empProCiu = null;
		try {
			fileScanner = new Scanner(new File(file));
			while (fileScanner.hasNextLine()) {//mientras el fichero tenga linea
				idEmpresa = -1;//si la empresa no esta, por eso ponemos menos uno
				empProCiu = fileScanner.nextLine().split(" ");

				for (EmpresaProyectos ep : listaEmpresas) {
					if (ep.getEmpresa().equals(empProCiu[0])) {
						ep.addProyectoCiudad(empProCiu[1], empProCiu[2]);
						idEmpresa = 0;
						break;
					}
				}
				// si no encontramos el nombre de la empresa creamos una empresa
				// proyecto
				if (idEmpresa == -1) {
					eP = new EmpresaProyectos(empProCiu[0]);
					eP.addProyectoCiudad(empProCiu[1], empProCiu[2]);
					listaEmpresas.add(eP);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	/**
	 * tamaño de la listaEmpresa en un arrayList.
	 *
	 * @return the int
	 */
	public int size() {
		return this.listaEmpresas.size();
	}

/**
 * devuelve el nombre de la Empresa.
 *
 * @param i the i
 * @return the empresa proyectos
 */
	public EmpresaProyectos getEmpresaProyectos(int i) {
		return this.listaEmpresas.get(i);
		//contiene el nombre de la empresa y un arrayList de proyectoCiudades
	}

	/**
	 * toString devuelve el todo los nombre de empresaProyecto seguido de proyectoCiudad
	 */
	@Override
	public String toString(){
		String s= "";
		for(EmpresaProyectos ep:listaEmpresas){
			s+=ep.toString();
		}
		return s;
	}

/**
 *  Enumera la empresa ciudad,.
 *
 * @param ciudad the ciudad
 * @return the array list
 */
	public ArrayList<String> enumerarEmpresasCiudad(String ciudad) {
		ArrayList<String> lista= new ArrayList<String>();//creo una nueva lista
		for (EmpresaProyectos ep : listaEmpresas) {	//Recorro la empresa proyecto
			for (ProyectoCiudades pc : ep.getProyectosCiudades()) {//dentro  empresa proyecto, voy a recoorer proyecto ciudad.
				if(pc.getCiudades().contains(ciudad)&& !lista.contains(ep.getEmpresa())){//si proyecto contiene ciudades y es distinta...
					lista.add(ep.getEmpresa());//agrega a la lista
				}
			}
		}
		return lista;

	}

/**
 *  EnumerarProyectoCiudad
 * devuelve  una lista con todos los proyectos,
 * si contiene la ciudad que me pasan por parametro añade a la listaAux
 * y si la listaAux no contiene el proyecto, añade(esto es para que no se repita).
 *
 * @param ciudad the ciudad
 * @return the array list
 */
	public ArrayList<String> enumerarProyectosCiudad(String ciudad) {

		ArrayList<String> listaAux= new ArrayList<String>();
		for (EmpresaProyectos ep : listaEmpresas) {//recorro la lista empresa
			for (ProyectoCiudades pc : ep.getProyectosCiudades()) {//recorro y llamo a proyectoCiudades
				if(pc.getCiudades().contains(ciudad)&& !listaAux.contains(pc.getProyecto())){
					//
					listaAux.add(pc.getProyecto());
				}
			}
		}
		return listaAux;
	}


	/**
	 * ContarCiudadEmpresa
	 * devuelve  el tamaño de las ciudades, donde por parametro me pasan el
	 * nombre de la empresa voy recorriendo esa empresa donde esas ciudad
	 * las agrego en un arraylist.
	 *
	 * @param empresa the empresa
	 * @return the int
	 */

	public int contarCiudadesEmpresa(String empresa) {
		ArrayList<String> lista= new ArrayList<String>();

		for (EmpresaProyectos ep : listaEmpresas) {
				if(ep.getEmpresa().equals(empresa)){
					for(ProyectoCiudades pc: ep.getProyectosCiudades()){
						for(String c:pc.getCiudades()){
							if(!lista.contains(c)){
							lista.add(c);
						}
					}
				}
				break;//si hemos encontrado la empresa , no necesitmaos seguir buscando en listaEmpresa
		}
	}
		return lista.size();
	}

}