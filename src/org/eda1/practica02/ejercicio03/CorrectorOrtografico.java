package org.eda1.practica02.ejercicio03;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import org.eda1.practica02.edaAuxiliar.*;

/**
 * The Class CorrectorOrtografico.
 */
public class CorrectorOrtografico {

	/** The tree palabras. */
	private AVLTree<String> treePalabras;

	/**
	 * Instantiates a new corrector ortografico.
	 */
	public CorrectorOrtografico() {
		this.treePalabras = new AVLTree<String>();
	}

	/**
	 * Load file.
	 *
	 * @param archivo the archivo
	 */
	public void loadFile(String archivo) {
		Scanner scan = null;
		String linea;
		try {
			// ...
			scan = new Scanner(new File(archivo));
			while (scan.hasNextLine()) {
				linea = scan.nextLine().toLowerCase();
				treePalabras.add(linea);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		scan.close();
	}

	/**
	 * Lista sugerencias.
	 *
	 * @param n the n
	 * @param s the s
	 * @return the array list
	 */
	public ArrayList<String> listaSugerencias(int n, String s) {
		ArrayList<String> sugerencias = new ArrayList<String>();
		PriorityQueue<PalabraDistancia> pQueue = new PriorityQueue<PalabraDistancia>(new DistanceComparator());
		// ...

		for (String p : treePalabras) {
			PalabraDistancia pd = new PalabraDistancia(p, ComputoDistancia.computeLevenshteinDistance(s, p));
			pQueue.add(pd);
		}

		for (int i = 0; i < n && i < pQueue.size(); i++) {
			sugerencias.add(pQueue.poll().getPalabra());// poll->saca las
														// mejores

		}
		return sugerencias;

	}

	/**
	 * Adds the.
	 *
	 * @param palabra the palabra
	 * @return true, if successful
	 */
	public boolean add(String palabra) {
		return this.treePalabras.add(palabra);
	}

	/**
	 * Contains palabra.
	 *
	 * @param palabra the palabra
	 * @return true, if successful
	 */
	public boolean containsPalabra(String palabra) {
		return treePalabras.contains(palabra);
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return treePalabras.size();
	}

	/**
	 * Find.
	 *
	 * @param palabra the palabra
	 * @return the string
	 */
	public String find(String palabra) {
		return treePalabras.find(palabra);
	}
}