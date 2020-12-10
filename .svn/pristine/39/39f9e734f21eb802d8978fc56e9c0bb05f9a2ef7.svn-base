package org.eda1.cargararchivo.ejemplo04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GestionAlumnos {

	private AVLTree<Alumno> arbolAlumnos;

	public GestionAlumnos() {
		arbolAlumnos=new AVLTree<Alumno>();
	}

	public int size(){
		return arbolAlumnos.size();
	}

	public String toString(){
		return arbolAlumnos.toString();
	}

	public void cargarDatos(String archivo) {
		Scanner sc = null;

		try {
			sc=new Scanner(new File(archivo));
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				String t = sc.nextLine();
				String[] arrayNombre = s.split(" ");
				String[] arrayNotas = t.split(" ");
				ArrayList<Double> notas = new ArrayList<Double>();
				for (String n : arrayNotas) {
					if (n.equals("")) {
						continue;
					}
					notas.add(n.equals("-")?null:Double.parseDouble(n));
				}
				Alumno a = new Alumno(arrayNombre[0], arrayNombre[1], arrayNombre[2], notas);
				arbolAlumnos.add(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String consultarExpediente(String apellido1, String apellido2, String nombre){
		Alumno aux = arbolAlumnos.find(new Alumno(nombre, apellido1, apellido2));
		if (aux==null) {
			return "Este alumno/a no existe";
		}
		return aux.consultarExpediente();
	}

	public String extraerListado(int size, Comparator<Alumno> comp){
		PriorityQueue<Alumno> pq  = new PriorityQueue<Alumno>(comp);
		for (Alumno a : arbolAlumnos) {
			pq.add(a);
		}
		String s = "[";
		for (int i = 0; i < size; i++) {
			s+=pq.poll().nombreCompleto();//Parecido al pol extrae el primero
			if (i<size-1) {
				s+=", ";
			}
		}
		return s + "]";
	}
}
