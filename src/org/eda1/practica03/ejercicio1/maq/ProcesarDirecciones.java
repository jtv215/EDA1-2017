//package org.eda1.practica03.ejercicio1.maq;
//
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Scanner;
//import java.util.TreeMap;
//import java.util.TreeSet;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.reflect.Array;
//
//public class ProcesarDirecciones {
//
//	private TreeMap<String, TreeSet<MaquinaContador>> mapa;
//
//	public ProcesarDirecciones() {
//	//Clave clave valor
//	//
//		this.mapa = new TreeMap<String, TreeSet<MaquinaContador>>();
//	}
//
//	public void cargarArchivo(String archivo) {
//
//		try {
//			Scanner sc = new Scanner(new File(archivo));
//			while (sc.hasNextLine()) {
//				String s = sc.nextLine();
//				if (s.trim().isEmpty())
//					continue;
//				String x[] = s.split("[^a-zA-Z0-9.]");// lo que sea distinto y
//														// otr[ ,+(]
//				String ip = x[0];
//				String maq = x[x.length - 1];
//				MaquinaContador mc=new MaquinaContador(maq);
//				// tengo que asegurarme que la clave exista put(k,v),luego
//				// devuelve get(k)
//
//				if (!mapa.containsKey(ip)) {
//
//					mapa.put(ip, new TreeSet<MaquinaContador>());
//				}
//				if (!mapa.get(ip).contains(mc)) {
//					mapa.get(ip).add(mc);
//				}else{
//					mapa.get(ip).floor(mc).incrementarContador();
//				}
//
//			}
//			sc.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public int size() {
//		return mapa.size();
//	}
//
//	// tiene que generar un archivo
//	public void generarDirecciones(String archivo) {
//		// TODO
//		// IP =>MAq =contador,
//		// "113.213.12.1 ==> {epi.ual.es=1, epicuro.ual.es=2} "
//		// entryset devuelve un conjunto para que sea iterable
//		String aux = "";
//
//		for (Entry<String, TreeSet<MaquinaContador>> it : mapa.entrySet()) {
//			aux += it.getKey() + " ==> " + it.getValue().toString().replace('[', '{').replace(']', '}') + "\n";
//		}
//		try {
//			PrintWriter pw = new PrintWriter(new File(archivo));
//			pw.print(aux);
//			pw.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public void generarIncidencias(String archivo) {
//		// TODO
//		String aux = "";
//		for (Entry<String, TreeSet<MaquinaContador>> it : mapa.entrySet()) {
//			if (it.getValue().size() > 1) {
//				aux += it.getKey() + " ==> " + it.getValue().toString() + "\n";
//			}
//		}
//		try {
//			PrintWriter pw = new PrintWriter(new File(archivo));
//			pw.print(aux);
//			pw.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public ArrayList<String> maquinasConContadorMayorQue(int contador) {
//		ArrayList<String> al = new ArrayList<String>();
//		for (Entry<String, TreeSet<MaquinaContador>> it : mapa.entrySet()) {
//			for (MaquinaContador m : it.getValue()) {
//				// String ip = it.getKey();
//				// String maq=it2.getKey();
//				// Integer cont= it2.getValue();
//				if (m.getContador() > contador) {
//					al.add(it2.getKey());
//
//				}
//
//			}
//		}
//		return al;
//
//	}
//
//	public int maquinasConContadorIgualA(int contador) {
//		// Creamos un treeset para no repetir el nombre de las maquinas
//		// ya que tiene que devolver un cantador
//
//		TreeSet<String> maqs = new TreeSet<String>();
//		for (Entry<String, TreeMap<String, Integer>> it : mapa.entrySet()) {
//			for (MaquinaContador m : it.getValue()) {
//				// String ip = it.getKey();
//				// String maq=it2.getKey();
//				// Integer cont= it2.getValue();
//				if (m.getContador()) == contador) {
//					maqs.add(it2.getKey());
//
//				}
//
//			}
//		}
//		return maqs.size();
//	}
//
//	public int getContador(String direccion, String maquina) {
//		// TODO
//		// cuidado cuando cambio la segunda primisa en la premisa me devuel un
//		// nullpointer
//		if (!mapa.containsKey(direccion) || !mapa.get(direccion).containsKey(maquina)) {
//			return 0;
//		}
//		return mapa.get(direccion).get(maquina);
//
//	}
//
//	public ArrayList<String> incidenciasGeneradasPorIP(String direccion) {
//		// TODO
//		// hay incidencia cuando una direccion hay en varias maquinas.
//
//		if(!mapa.containsKey(direccion))return null;
//		ArrayList<String> al= new ArrayList<String>();
//		//el kesyset devuelve de tipo String(es mas especifico
//
//		for (String it : mapa.get(direccion).keySet()) {
//			al.add(it);
//		}
//		return al;
//	}
//
//	public int numeroDeIncidenciasGeneradasPorIP(String direccion) {
//		ArrayList<String> al= incidenciasGeneradasPorIP(direccion);
//		return al==null?0:al.size();
//	}
//}
