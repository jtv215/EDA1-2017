//package org.eda1.prueba00.caso04;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Map.Entry;
//import java.util.Scanner;
//import java.util.TreeMap;
//import java.util.TreeSet;
//
//import org.eda1.actividad05.edaAuxiliar.Network;
//
//public class NetworkPersona extends Network<Persona> {
//
//
//	public void loadNetwork(String filename) throws FileNotFoundException{
//
//		File file=new File(filename);
////		if(!file.exists())throw new RuntimeException("...ERROR AL CARGAR ARCHIVO...");
//		Scanner sc=new Scanner(file);
//
//		String linea = "";
//		String x[];
//		boolean vertices = false, relaciones = false;
//		Persona p1 = null;
//		Persona p2 = null;
//		String nombre;
//		TreeSet<String> amigos;
//		int id = 0;
//
//		while (sc.hasNextLine()){
//			linea = sc.nextLine();
//			if (linea.contains("%") || linea.isEmpty())
//				continue;
//			if(linea.contains("@nombre"))
//				continue;
//
//			else if(linea.contains("@tipo")){
//				//tipo de grafo (0 no dirigido; 1 dirigido)
//				x = linea.split(" ");
//				setDirected(x[1].equals("0")?false:true);
//				continue;
//			}else if (linea.startsWith("@vertices")) {
//				vertices = true;
//				relaciones = false;
//				continue;
//			}else if (linea.startsWith("@relaciones")) {
//				relaciones = true;
//				vertices = false;
//				continue;
//			}
//
//			if(vertices){
//				nombre = linea;
//				x = sc.nextLine().split(" ");
//				amigos = new TreeSet<String>();
//
//				for(int i = 0;i<x.length;i++){
//					if(!x[i].isEmpty())
//						amigos.add(x[i]);
//				}
//				p1 = new Persona(nombre,amigos);
//				addVertex(p1);//añadirVertice(.)
//
//				this.vertexToIndex.put(p1,id++);
//
//			}else if(relaciones){
//				x = linea.split(" <<-->> ");
//				p1 = new Persona(x[0].trim());
//				p2 = new Persona(x[1].trim());
//
//				for(Persona p3 :vertexSet()){
//					if (p3.compareTo(p1)==0)
//						p1=p3;
//					if (p3.compareTo(p2)==0)
//						p2=p3;
//				}
//				addEdge(p1, p2, p1.interseccion(p2));//añadirArista(....)
//				//(vertice1,vertice2,int"numero de elemntos")
//			}
//		}
//	}
//
//	public String getFollowers(Persona user, Comparator<Persona> comp){
////		if(!containsVertex((user))) return "[]";
//		TreeSet<Persona> ts=new TreeSet<Persona>(comp);
//		ts.addAll(adjacencyMap.get(user).keySet());
//
//		return ts.toString();
//
//	}
//
//	public TreeMap<Persona, Integer> getVertexToIndex(){
//		return this.vertexToIndex;
//	}
//
//}
