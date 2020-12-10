//package org.eda1.prueba00.caso04;
//
//import java.util.TreeSet;
//
//public class Persona implements Comparable<Persona> {
//
//	private String nombre;
//	private TreeSet<String> amigos;
//
//	public Persona (String nombre){
////		if (nombre == null) throw new RuntimeException ("...nombre nulo...");
//
//		this.nombre=nombre;
////		this.amigos=null;
//	}
//
//	public Persona (String nombre, TreeSet<String> amigos){
////		if (nombre == null) throw new RuntimeException ("...nombre nulo...");
//
//		this.nombre=nombre;
//		this.amigos=amigos==null?null:new TreeSet<String>(amigos);
//	}
//
//	public int interseccion(Persona otra){
//		if(otra == null) throw new RuntimeException("...intersecando con nulo...");
//		if(otra.amigos==null) throw new RuntimeException("...intersecando con lista de amigos null...");
//
//		TreeSet<String> aux= new TreeSet<>(amigos);
//		aux.retainAll(otra.amigos);
//		return aux.size();
//	}
//
//	public TreeSet<String> getAmigos(){
//		return this.amigos;
//	}
//
//	@Override
//	public int compareTo(Persona otra){
//		if (otra == null) throw new RuntimeException ("...comparando con nulo...");
//		return this.nombre.compareTo(otra.nombre);
//	}
//
//	@Override
//	public String toString(){
//		return this.nombre;
//	}
//
//	public boolean equals(Object p){
//		Persona p1 = (Persona) p;
//		if(p1==null)throw new RuntimeException ("...comparando con nulo...");
//		if(p1.nombre.equals(this.nombre)){
//			if(p1.amigos==this.amigos)
//				return true;
//			return false;
//		}
//		return false;
//	}
//}
