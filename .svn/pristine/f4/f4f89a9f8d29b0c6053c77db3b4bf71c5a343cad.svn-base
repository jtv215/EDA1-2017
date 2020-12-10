package org.eda1.actividad04.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Thesaurus {
	protected TreeMap<String, TreeSet<String>> thesaurus;

	/**
	 * Initializes this Thesaurus object.
	 *
	 */
	public Thesaurus() {
		this.thesaurus = new TreeMap<String, TreeSet<String>>();
	}

	public void loadThesaurus(String file) {
		// TODO
		try {
			Scanner sc = new Scanner(new File(file));
			String x[] = null;
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				if (s.startsWith("@") || s.trim().isEmpty())
					continue;
				x = s.split("[ :.,{}]+");
				// x=s.split("[^a-zA-ZñÑ]+");
				add(x);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void add(String[] words) {
		// String clave= words[0];//la clave en la posicion 0

		for (int i = 1; i < words.length; i++) {
			if (!words[i].isEmpty()) {
				add(words[0], words[i]);
			}
		}
	}

	// para esta clave meto el valor del sinonimo
	// si no contengo clave meto una excepcion
	public void add(String word, String synonym) {
		// siempre preguntar si existe la clave
		if (!thesaurus.containsKey(word)) {// si no esta la palabra creame una
											// palabra y un treeset
			thesaurus.put(word, new TreeSet<String>());
		}
		thesaurus.get(word).add(synonym);//ojo el tresset si tiene add

	}

	public TreeSet<String> remove(String word) {
		return thesaurus.remove(word);

	}

	// eliminamos solo el sinonimo no la clave
	public boolean remove(String word, String synonym) {
		// TODO
		if (!thesaurus.containsKey(word))
			return false;
		// return thesaurus.remove(word, synonym);
		return thesaurus.get(word).remove(synonym);
	}

	// lo unico que cambiamos son los sinonimos
	public TreeSet<String> update(String word, TreeSet<String> synonyms) {
		// TODO
		if (!thesaurus.containsKey(word))
			return null;
		TreeSet<String> aux = thesaurus.get(word);// EN EL treemap no existe el
													// find
		// cuidado con el put porque sobreescribe
		thesaurus.put(word, synonyms);
		return aux;
	}

	public TreeSet<String> getSynonymous(String word) {
		return thesaurus.get(word);
	}

	public int size() {
		return thesaurus.size();
	}

	// devuelve el tamaño de los sinonimos
	public int size(String word) {
		// TODO
		if (!thesaurus.containsKey(word))
			return 0;

		return thesaurus.get(word).size();
	}

	public boolean isSynonymousOf(String word, String synonym) {
		// TODO
		if (!thesaurus.containsKey(word))
			return false;// el contain devuelve un boolean

		return thesaurus.get(word).contains(synonym);

	}

	// recorro las claves y si lo contiene devuelve true
	public boolean isSynonymous(String synonym) {
		// TODO
		// ojo: para recorrer se hace con un entry set.
		for (Entry<String, TreeSet<String>> it : thesaurus.entrySet()) {// el
																		// tresaurus
																		// en un
																		// treemap
																		// no es
																		// un
																		// Entry
			// entryset es un conjunto de clave y su contenido para poder
			// recorrerlo
			// GetValue es un treeset
			if (it.getValue().contains(synonym)) {
				return true;
			}
		}
		return false;
	}

	// si el sinonimo tiene mayor que cero

	public boolean hasSynonymous(String word) {
		// TODO
		if (!thesaurus.containsKey(word))
			return false;
		return thesaurus.get(word).size() > 0;
	}

	public String toString() {
		String str = "";
		for (Entry<String, TreeSet<String>> it : thesaurus.entrySet()) {
			str += it.getKey() + ": " + it.getValue() + "\n";
		}
		return str;
	}
}
