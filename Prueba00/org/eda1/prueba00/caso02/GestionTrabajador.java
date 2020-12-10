package org.eda1.prueba00.caso02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.eda1.practica02.edaAuxiliar.AVLTree;

public class GestionTrabajador {
	private  AVLTree<Trabajador> arbolPalabra = new AVLTree<Trabajador>();


	/**
	 * Versión con dos bucles WHILE anidados
	 * Como lo quiere el profesor
	 */
	public void cargarArchivo(String nombreArchivo){
		Scanner sc = null;
		String s = "",nombre;
		String [] x = null;
		ArrayList<Double> horas=new ArrayList<Double>();

		this.arbolPalabra.clear();

		try {
			sc = new Scanner(new File(nombreArchivo));
			while (sc.hasNextLine()){
				horas.clear();
				s = sc.nextLine();
				if (s.isEmpty()) continue;
				x = s.split("[ +-.,( )[ ]¡?!¿^]+");


				if(x[0].contains("@"))
					continue;

				nombre = x[0]+" "+x[1]+" "+x[2];
				do{
					s = sc.nextLine();
				}while((s.contains("@") || s.isEmpty()) && sc.hasNextLine());

				x = s.split(" ");
				/**
				for(int j = 0; j < x.length; j++){
					if(x[j].equals("-"))
						horas.add(null);
					else{
						horas.add(Double.parseDouble(x[j]));
					}
				}**/
				//el codigo de arriba lo optimizo
				for(String j: x){
					horas.add(j.equals("-")?null:Double.parseDouble(j));
				}

				this.arbolPalabra.add(new Trabajador(nombre, horas));
			}
	}catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		System.exit(-1);
	}
	sc.close();
}

//	public void cargarArchivo(String nombreArchivo){
//		Scanner sc = null;
//		String s = "",nombre="";
//		String [] x = null;
//		int cont = 2;
//		ArrayList<Double> horas;
//		this.arbolPalabra.clear();
//
//		try {
//			sc = new Scanner(new File(nombreArchivo));
//			while (sc.hasNextLine()){
//				s = sc.nextLine();
//				if (s.isEmpty()) continue;
//				x = s.split(" ");
//
//				if(x[0].contains("@"))
//					continue;
//
//				if(cont%2==0){
//					nombre = x[0]+" "+x[1]+" "+x[2];
//					cont++;
//				}else{
//					horas=new ArrayList<Double>();
//					for (String j : x) {
//						horas.add(j.equals("-")?null:Double.parseDouble(j));
//					}
//					this.arbolPalabra.add(new Trabajador(nombre, horas));
//					cont++;
//				}
//			}
//		}catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//			System.exit(-1);
//		}
//		sc.close();
//	}


//	public void cargarArchivo(String nombreArchivo){
//		Scanner sc = null;
//		String linea = "",nombre;
//		String [] x = null;
//
//
//		this.arbolPalabra.clear();
//
//		try {
//			sc = new Scanner(new File(nombreArchivo));
//			while (sc.hasNextLine()){
//				linea = sc.nextLine();
//				if (linea.isEmpty()) continue;
////				x = linea.split("[ +-.,( )[ ]¡?!¿^]+");
//				x = linea.split(" ");//
//
//				if(x[0].contains("@"))
//					continue;
//
//				nombre = x[0]+" "+x[1]+" "+x[2];
//				while(sc.hasNextLine()){
//					linea = sc.nextLine();
//					if (linea.isEmpty()) continue;
//					else{
//						x = linea.split(" ");
//
//						if(x[0].contains("@"))
//							continue;
//
//						ArrayList<Double> horas=new ArrayList<Double>();
//						for (String j : x) {
//							horas.add(j.equals("-")?null:Double.parseDouble(j));
//						}
//						this.arbolPalabra.add(new Trabajador(nombre, horas));
//						break;
//					}
//				}
//			}
//		}catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//			System.exit(-1);
//		}
//		sc.close();
//	}


	public int size() {
		return this.arbolPalabra.size();
	}

	public boolean add(Trabajador trab) {
		return this.arbolPalabra.add(trab);
	}

	public Trabajador find(String nombre) {
		return this.arbolPalabra.find(new Trabajador(nombre, null));
	}

	public ArrayList<Trabajador> toArray() {
		ArrayList<Trabajador> al = new ArrayList<Trabajador>();
		for (Trabajador trabajador : arbolPalabra) {
			al.add(trabajador);
		}
		return al;
	}

	public ArrayList<Trabajador> toArrayWithOrder(Comparator<Trabajador> comp) {
		ArrayList<Trabajador> al = toArray();
		Collections.sort(al, comp);
		return al;
	}

	@Override
	public String toString() {
		return this.arbolPalabra.toString();
	}
}
