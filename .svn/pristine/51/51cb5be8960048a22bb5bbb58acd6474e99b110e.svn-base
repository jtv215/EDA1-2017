package org.eda1.practica03.ejercicio02;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.print.DocFlavor.STRING;

import java.io.File;
import java.io.IOException;

/**
 * The Class ProcesarDatos.
 */
public class ProcesarDatos {

	/** The mapa. */
	private TreeMap<String, TreeMap<String, TreeSet<String>>> mapa;

	/**
	 * Instantiates a new procesar datos.
	 */
	public ProcesarDatos() {
		this.mapa = new TreeMap<String, TreeMap<String, TreeSet<String>>>();
	}

	/**
	 * Cargar archivo.
	 *
	 * @param archivo the archivo
	 */
	public void cargarArchivo(String archivo) {

		Scanner scan = null;
		;

		String[] linea;
		String empresa = "", proyecto = "", ciudad = "";
		try {
			scan = new Scanner(new File(archivo));
			while (scan.hasNextLine()) {
				linea = scan.nextLine().split(" ");
				empresa = linea[0];
				proyecto = linea[1];
				ciudad = linea[2];

				// Estos if es para asegurarme de que esten las clave.ssiempre
				// igual si no contiene la clave
				if (!mapa.containsKey(empresa)) {
					mapa.put(empresa, new TreeMap<String, TreeSet<String>>());

				}

				if (!mapa.get(empresa).containsKey(proyecto)) {
					mapa.get(empresa).put(proyecto, new TreeSet<String>());
				}
				mapa.get(empresa).get(proyecto).add(ciudad);
			}

			scan.close();
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
			System.exit(-1);
		}

	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return mapa.size();
	}

	/**
	 * Devolver ciudades.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> devolverCiudades() {
		// TODO
		TreeSet<String> ciudadesDiferentes = new TreeSet<String>();

		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()) {
				ciudadesDiferentes.addAll(it2.getValue());
			}
		}
		return ciudadesDiferentes;

	}

	/**
	 * Devolver proyectos.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> devolverProyectos() {
		// TODO
		TreeSet<String> proyectosDiferentes = new TreeSet<String>();
		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			proyectosDiferentes.addAll(it.getValue().keySet());
		}
		return proyectosDiferentes;

	}

	/**
	 * Devolver empresas.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> devolverEmpresas() {
		// TODO
		TreeSet<String> empresaDiferentes = new TreeSet<String>();
		empresaDiferentes.addAll(mapa.keySet()); // al treeset le puedo coger un
													// conjunto de clave
		return empresaDiferentes;
	}

	/**
	 * Numero proyectos empresa.
	 *
	 * @param empresa the empresa
	 * @return the int
	 */
	public int numeroProyectosEmpresa(String empresa) {
		// TODO
		if (!mapa.containsKey(empresa))
			return 0;
		return mapa.get(empresa).size();
	}

	/**
	 * Numero ciudades proyecto.
	 *
	 * @param proyecto the proyecto
	 * @return the int
	 */
	public int numeroCiudadesProyecto(String proyecto) {
		// TODO
		// numero de ciudades que tiene un proyecto
		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			if (it.getValue().containsKey(proyecto)) {
				return it.getValue().get(proyecto).size();
			}
		}
		return 0;

	}

	/**
	 * Numero ciudades empresa.
	 *
	 * @param empresa the empresa
	 * @return the int
	 */
	public int numeroCiudadesEmpresa(String empresa) {
		TreeSet<String> ts = devolverCiudadesEmpresa(empresa);
		return ts == null ? 0 : ts.size();

		// if(!mapa.containsKey(empresa))return 0;
		// TreeSet<String> ciudades=new TreeSet<String>();
		//
		// for(Entry<String, TreeSet<String>> it: mapa.get(empresa).entrySet()){
		// ciudades.addAll(it.getValue());
		// }
		// return ciudades.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO
		// "Adobe: Flash <Boston, Charleston, Washington>; Illustrator <Miami,
		// New_Orleans, Sacramento>; Photoshop <Houston, San_Antonio, Seattle>"
		// + "\n"
		String s = "";
		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			String empresa = it.getKey();
			s += empresa + ": ";
			for (Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()) {
				String proyecto = it2.getKey();
				String ciudades = it2.getValue().toString().replace('[', '<').replace(']', '>');
				s += proyecto + " " + ciudades;
				if (!proyecto.equals((it.getValue().lastKey()))) {
					s += "; ";

				}
			}
			s += "\n";
		}

		return s;
	}

	/**
	 * Devolver empresas ciudad.
	 *
	 * @param ciudad the ciudad
	 * @return the tree set
	 */
	public TreeSet<String> devolverEmpresasCiudad(String ciudad) {
		// TODO
		TreeSet<String> empresas = new TreeSet<String>();

		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()) {
				if (it2.getValue().contains(ciudad)) {
					empresas.add(it.getKey());
				}
			}
		}
		return empresas;
	}

	/**
	 * Devolver proyectos ciudad.
	 *
	 * @param ciudad the ciudad
	 * @return the tree set
	 */
	public TreeSet<String> devolverProyectosCiudad(String ciudad) {
		TreeSet<String> proyectos = new TreeSet<String>();

		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()) {
				if (it2.getValue().contains(ciudad)) {
					proyectos.add(it2.getKey());
				}
			}
		}

		return proyectos;
	}

	// if(!mapa.containsKey(empresa))return null;
	// TreeSet<String> ciudades=new TreeSet<String>();
	//
	// for(Entry<String, TreeSet<String>> it: mapa.get(empresa).entrySet()){
	// ciudades.addAll(it.getValue());
	// }
	/**
	 * Devolver ciudades empresa.
	 *
	 * @param empresa the empresa
	 * @return the tree set
	 */
	// return ciudades;
	public TreeSet<String> devolverCiudadesEmpresa(String empresa) {
		// ojo con el for
		if(!mapa.containsKey(empresa))return null;
		TreeSet<String> ciudades= new TreeSet<String>();
		for(Entry<String, TreeSet<String>> it: mapa.get(empresa).entrySet()){
			ciudades.addAll(it.getValue());
		}

		return ciudades;
	}

	/**
	 * Devolver proyecto con mayor numero de ciudades.
	 *
	 * @return the string
	 */
	public String devolverProyectoConMayorNumeroDeCiudades() {
		// TODO
		int max = 0;
		String proyecto = null;
		for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
			for (Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()) {
				if (it2.getValue().size() > max) {
					max = it2.getValue().size();
					proyecto = it2.getKey();
				}
			}
		}

		return proyecto;

	}


	/**
	 * Devolver empresa con mayor numero de proyectos.
	 *
	 * @return the string
	 */
	public String devolverEmpresaConMayorNumeroDeProyectos() {
		// TODO
		String empresas= null;
		int max=0;

		for(Entry<String, TreeMap<String, TreeSet<String>>> it:mapa.entrySet()){
				if(it.getValue().size()>max){
					max=it.getValue().size();
					empresas=it.getKey();
			}
		}
		return empresas;
	}

	/**
	 * Devolver ciudad con mayor numero de proyectos.
	 *
	 * @return the string
	 */
	public String devolverCiudadConMayorNumeroDeProyectos() {
		// TODO
	TreeMap<String, TreeSet<String>> aux = new TreeMap<String, TreeSet<String>>();

	for (Entry<String, TreeMap<String, TreeSet<String>>> it : mapa.entrySet()) {
		for (Entry<String, TreeSet<String>> it2 : it.getValue().entrySet()) {
			for (String ciudad : it2.getValue()) {
				String proyecto = it2.getKey();
				if (!aux.containsKey(ciudad)) {
					aux.put(ciudad, new TreeSet<String>());

				}
				aux.get(ciudad).add(proyecto);
			}
		}
	}
	int max = 0;
	String ciudad = null;
	for (Entry<String, TreeSet<String>> it : aux.entrySet()) {
		if (it.getValue().size() > max) {
			max = it.getValue().size();
			ciudad = it.getKey();
		}
	}
	return ciudad;
	}

}