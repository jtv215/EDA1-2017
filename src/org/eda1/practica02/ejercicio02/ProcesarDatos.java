package org.eda1.practica02.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;
import org.eda1.practica02.edaAuxiliar.AVLTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Class ProcesarDatos.
 */
public class ProcesarDatos {

	/** The lista empresas. */
	private AVLTree<EmpresaProyectos> listaEmpresas = new AVLTree<EmpresaProyectos>();

	/**
	 * Cargar archivo.
	 *
	 * @param archivo
	 *            the archivo
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void cargarArchivo(String archivo) throws FileNotFoundException {
		Scanner sc = null;
		String s = null;
		String[] x = null;

		try {

			sc = new Scanner(new File(archivo));
			while (sc.hasNextLine()) {
				s = sc.nextLine();
				x = s.split(" ");
				this.add(x[0], x[1], x[2]);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds the.
	 *
	 * @param empresa
	 *            the empresa
	 * @param proyecto
	 *            the proyecto
	 * @param ciudad
	 *            the ciudad
	 * @return true, if successful
	 */
	public boolean add(String empresa, String proyecto, String ciudad) {
		EmpresaProyectos ep = new EmpresaProyectos(empresa);
		EmpresaProyectos aux = listaEmpresas.find(ep);

		if (aux != null) {
			return aux.add(proyecto, ciudad);
		} else {
			ep.add(proyecto, ciudad);
			return listaEmpresas.add(ep);
		}

	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return this.listaEmpresas.size();
	}

	/**
	 * Numero proyectos empresa.
	 *
	 * @param empresa
	 *            the empresa
	 * @return the int
	 */
	public int numeroProyectosEmpresa(String empresa) {
		EmpresaProyectos ep = this.listaEmpresas.find(new EmpresaProyectos(empresa));
		return (ep == null) ? -1 : ep.size();
	}

	/**
	 * Numero ciudades proyecto.
	 *
	 * @param proyecto
	 *            the proyecto
	 * @return the int
	 */
	public int numeroCiudadesProyecto(String proyecto) {
		AVLTree<String> avl = new AVLTree<String>();
		ProyectoCiudades pc = new ProyectoCiudades(proyecto, null);
		ProyectoCiudades pcAux = null;

		boolean enc = false;
		// podria encontrar un proyecto sin tener ciudades pero en este caso no
		// hay proyecto sin ciudades
		for (EmpresaProyectos ep : listaEmpresas) {
			pcAux = ep.getProyectoCiudades().find(pc);//el proyecto lo meto en pcAux
			if (pcAux != null) {//si hay ciudad lo recorro
				enc = true;
				for (String c : pcAux.getCiudades()) {
					avl.add(c);
				}
			}
		}
		return enc ? avl.size() : -1;

	}

//	public int numeroCiudadesProyecto(String proyecto) {
//		ProyectoCiudades aux = null;
//		for(EmpresaProyectos auxEmo: listaEmpresas){
//			aux = auxEmo.getProyectoCiudades().find(new ProyectoCiudades(proyecto,null));
//			if(aux!=null)
//				break;
//		}
//
//		return (aux!=null)?aux.getCiudades().size():-1;
//	}

	/**
	 * Numero ciudades empresa.
	 *
	 * @param empresa
	 *            the empresa
	 * @return the int
	 */
	public int numeroCiudadesEmpresa(String empresa) {

		AVLTree<String> avl = new AVLTree<String>();
		EmpresaProyectos ep = listaEmpresas.find(new EmpresaProyectos(empresa));
		if (ep == null) {
			return -1;

		}
		for (ProyectoCiudades pc : ep.getProyectoCiudades()) {
			for (String c : pc.getCiudades()) {
				avl.add(c);
			}
		}
		return avl.size();

	}

	@Override
	public String toString() {
		String cadena = "";
		for (EmpresaProyectos ep : this.listaEmpresas) {
			cadena += ep.toString() + "\n";
		}
		return cadena;
	}

	/**
	 * Devolver empresas ciudad. Ejemplo de saltida salida =
	 * "[Adobe, Apple, Borland, Microsoft, Oracle]";
	 *
	 * @param ciudad
	 *            the ciudad
	 * @return the string
	 */
	public String devolverEmpresasCiudad(String ciudad) {
		ArrayList<String> al = new ArrayList<String>();

		for (EmpresaProyectos ep : listaEmpresas) {
			for (ProyectoCiudades pc : ep.getProyectoCiudades()) {
				if (pc.getCiudades().contains(ciudad) && !al.contains(ep.getEmpresa())) {
					al.add(ep.getEmpresa());
				}
			}
		}

		return al.toString();

	}

	/**
	 * Devolver proyectos ciudad.
	 * salida = "[Flash, IOS, Xcode, C++Builder,...]
	 *
	 * @param ciudad
	 *            the ciudad
	 * @return the string
	 */
	public String devolverProyectosCiudad(String ciudad) {
		ArrayList<String> al = new ArrayList<String>();

		for (EmpresaProyectos ep : listaEmpresas) {
			for (ProyectoCiudades pc : ep.getProyectoCiudades()) {
				if (pc.getCiudades().contains(ciudad) && !al.contains(pc.getProyecto())) {
					al.add(pc.getProyecto());
				}
			}
		}

		return al.toString();

	}

	/**
	 * Devolver ciudades empresa.
	 *
	 * @param empresa
	 *            the empresa
	 * @return the string
	 */
	public String devolverCiudadesEmpresa(String empresa) {
		ArrayList<String> aux = new ArrayList<>();

		EmpresaProyectos ep = listaEmpresas.find(new EmpresaProyectos(empresa));
		if (ep != null)
			for (ProyectoCiudades pc : ep.getProyectoCiudades()) {
				for (String c : pc.getCiudades()) {
					if (!aux.contains(c)) {
						aux.add(c);
					}
				}
			}

		return aux.toString();
	}
}