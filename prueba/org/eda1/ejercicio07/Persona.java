package org.eda1.ejercicio07;

import java.util.TreeSet;

public class Persona implements Comparable<Persona> {

	private String nombre;
	private TreeSet<String> amigos;

	public Persona (String nombre){
		if (nombre == null) throw new RuntimeException ("...nombre nulo...");
		//...

		this.nombre=nombre;
		this.amigos=null;
	}

	public Persona (String nombre, TreeSet<String> amigos){
		if (nombre == null) throw new RuntimeException ("...nombre nulo...");
		//...
		this.nombre=nombre;
		this.amigos=amigos==null?null:new TreeSet<String>(amigos);//cuidado porque hace referencia a amigo

	}

	public int interseccion(Persona otra){
		//Devolvera el cardinal de la interseccion de la lista de amigos de this y otra
		if (otra == null) throw new RuntimeException ("...intersecando con nulo...");
		if(otra.amigos==null)throw new RuntimeException ("...intersecando con lista de amigos null...");
//		int cont=0;
//		for(String s:amigos){
//			if(otra.amigos.contains(s)){
//				cont++;
//			}
//		}
//		return cont;

		TreeSet<String> aux= new TreeSet<>(amigos);//copia de amigos
		aux.retainAll(otra.amigos);
		return aux.size();

	}

	public TreeSet<String> getAmigos(){
		return this.amigos;
	}

	@Override
	public int compareTo(Persona otra){
		if (otra == null) throw new RuntimeException ("...comparando con nulo...");
		return this.nombre.compareTo(otra.nombre);
	}

//	@Override
//	public boolean equals(Object obj){
//		return false;
//	}


	@Override
	public String toString(){
		return this.nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	
}
