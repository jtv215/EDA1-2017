
package org.eda1.practica03.ejercicio01;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

/**
 * The Class ProcesarDirecciones.
 */
public class ProcesarDirecciones {

	/** The mapa. */
	private TreeMap<String, TreeMap<String, Integer>> mapa;

	/**
	 * Instantiates a new procesar direcciones.
	 */
	public ProcesarDirecciones() {
		this.mapa = new TreeMap<String, TreeMap<String, Integer>>();
	}

	/**
	 * Cargar archivo.
	 *
	 * @param archivo the archivo
	 */
	public void cargarArchivo(String archivo) {

		try {
			Scanner sc = new Scanner(new File(archivo));
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				if (s.trim().isEmpty())
					continue;
				String x[] = s.split("[^a-zA-Z0-9.]");// lo que sea distinto y
														// otr[ ,+(]
				String ip = x[0];
				String maq = x[x.length - 1];

				// tengo que asegurarme que la clave exista put(k,v),luego
				// devuelve get(k)

				if (!mapa.containsKey(ip)) {
					mapa.put(ip, new TreeMap<String, Integer>());
				}
				if (!mapa.get(ip).containsKey(maq)) {
					mapa.get(ip).put(maq, 0);
				}
				mapa.get(ip).put(maq, mapa.get(ip).get(maq) + 1);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 *Generar direcciones.
	 *Tiene que generar un archivo ej:
	 *IP =>MAq =contador,
	 *"113.213.12.1 ==> {epi.ual.es=1, epicuro.ual.es=2} "
	 *entryset devuelve un conjunto para que sea iterable
	 * @param archivo the archivo
	 */
	public void generarDirecciones(String archivo) {
		// TODO
		String aux = "";
		for (Entry<String, TreeMap<String, Integer>> it : mapa.entrySet()) {
			aux += it.getKey() + " ==> " + it.getValue().toString() + "\n";
		}
		try {
			PrintWriter pw = new PrintWriter(new File(archivo));
			pw.print(aux);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Generar incidencias.
	 * generar un archivo
	 *
	 * @param archivo the archivo
	 */
	public void generarIncidencias(String archivo) {
		// TODO
		String aux = "";
		for (Entry<String, TreeMap<String, Integer>> it : mapa.entrySet()) {
			if (it.getValue().size() > 1) {
				aux += it.getKey() + " ==> " + it.getValue().toString() + "\n";
			}
		}
		try {
			PrintWriter pw = new PrintWriter(new File(archivo));
			pw.print(aux);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Maquinas con contador mayor que.
	 *
	 * @param contador the contador
	 * @return the array list
	 */
	public ArrayList<String> maquinasConContadorMayorQue(int contador) {
	ArrayList<String> al = new ArrayList<String>();
	for (Entry<String, TreeMap<String, Integer>> it : mapa.entrySet()) {
		for (Entry<String, Integer> it2 : it.getValue().entrySet()) {
				// String ip = it.getKey();
				// String maq=it2.getKey();
				// Integer cont= it2.getValue();
				if (it2.getValue() > contador) {
					al.add(it2.getKey());
				}
			}
		}
		return al;
	}

	/**
	 * Maquinas con contador igual a.
	 * Creamos un treeset para no repetir el nombre de las maquinas
	 * ya que tiene que devolver un cantador
	 * @param contador the contador
	 * @return the int
	 */
	public int maquinasConContadorIgualA(int contador) {
		TreeSet<String> maqs = new TreeSet<String>();
		for (Entry<String, TreeMap<String, Integer>> it : mapa.entrySet()) {
			for (Entry<String, Integer> it2 : it.getValue().entrySet()) {
				// String ip = it.getKey();
				// String maq=it2.getKey();
				// Integer cont= it2.getValue();
				if (it2.getValue() == contador) {
					maqs.add(it2.getKey());
				}
			}
		}
		return maqs.size();
	}

	/**
	 * Gets the contador.
	 * Cuidado cuando cambio la segunda premisa en la premisa me devuel un
	 * nullpointer.
	 * @param direccion the direccion
	 * @param maquina the maquina
	 * @return the contador
	 */
	public int getContador(String direccion, String maquina) {
		// TODO
		if (!mapa.containsKey(direccion) || !mapa.get(direccion).containsKey(maquina)) {
			return 0;
		}
		return mapa.get(direccion).get(maquina);
	}

	/**
	 * Incidencias generadas por ip.
	 * Hay incidencia cuando una direccion hay en varias maquinas.
	 * @param direccion the direccion
	 * @return the array list
	 */
	public ArrayList<String> incidenciasGeneradasPorIP(String direccion) {
		// TODO
		if(!mapa.containsKey(direccion))return null;
		ArrayList<String> al= new ArrayList<String>();
		//el kesyset devuelve de tipo String(es mas especifico

		for (String it : mapa.get(direccion).keySet()) {
			al.add(it);
		}
		return al;
	}

	/**
	 * Numero de incidencias generadas por ip.
	 *
	 * @param direccion the direccion
	 * @return the int
	 */
	public int numeroDeIncidenciasGeneradasPorIP(String direccion) {
		ArrayList<String> al= incidenciasGeneradasPorIP(direccion);
		return al==null?0:al.size();
	}
}
