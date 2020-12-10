package org.eda1.actividad04.ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * The Class SpellChecker.
 */
public class SpellChecker {

	/** The dictionary. */
	private TreeSet<String> dictionary;

	/** The document. */
	private TreeSet<String> document;

	/**
	 * Initializes this SpellChecker object.
	 *
	 */
	public SpellChecker() {
		this.dictionary = new TreeSet<String>();
		this.document = new TreeSet<String>();
	}


	/**
	 * Load dictionary.
	 *
	 * @param file the file
	 */
	public void loadDictionary(String file) {
		//TODO
		Scanner sc;
		try {
			sc = new Scanner( new File(file));
			while(sc.hasNextLine()){
				dictionary.add(sc.nextLine());
			}

			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Load document.
	 *
	 * @param file the file
	 */
	public void loadDocument(String file){
		//TODO

		Scanner sc;
		try {
			sc = new Scanner( new File(file));
			while(sc.hasNextLine()){
				addToDocument(sc.nextLine());
			}

			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 *  separamos un split.
	 *
	 * @param line the line
	 *
	 */
	public void addToDocument(String line) {
		//TODO
//		String [] x = line.split("[^a-zA-ZñÑ]+");//que sea lo contrario
		String [] x = line.split("[ ,.?;!]+");
		for (String s : x) {//recorremos la linea y si hay un array vacio no lo añado
				if(!s.isEmpty()){
				document.add(s.toLowerCase());
			}
		}

	}

	/**
	 * Adds the to dictionary.
	 *
	 * @param words the words
	 */
	public void addToDictionary(LinkedList<String> words){
		this.dictionary.addAll(words);
	}



	/**
	 * Compare.
	 *
	 * @return the linked list
	 */
	public LinkedList<String> compare() {
		//TODO
		//voy a coger las palabras que no tenga el documentos que esten el diccionario
		LinkedList< String> list= new LinkedList<String>();
//		dictionary.retainAll(null);
		//el retainAll aguanta lo que este en el diccionario.
		for (String s : document) {
			if( !contains(s)){
				list.add(s);
			}
		}
		return list;
		}


	/**
	 * Contains.
	 *
	 * @param word the word
	 * @return true, if successful
	 */
	public boolean contains(String word) {
		return this.dictionary.contains(word);
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return this.dictionary.size();
	}
}
