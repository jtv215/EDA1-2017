package org.eda1.ejercicio07;

import java.util.Comparator;

public class PersonaComparator implements Comparator<Persona> {

	private boolean greater;
	
	PersonaComparator(){
		this.greater = false;
	}
	
	PersonaComparator(String order){
		//TODO
		//order será igual a < o > ... en caso contrario lanzara excepcion
		if(!order.equals("<")&& !order.equals(">")){
			throw new RuntimeException("...orden no permitido...solo < o >");
		}
		greater =order.equals(">");
	}
	
	@Override
    public int compare(Persona p1, Persona p2) 
    //TODO
    { 
		//Ordenamos segun el valor de this.greater
		
	return greater?new Greater<Persona>().compare(p1, p2):new Less<Persona>().compare(p1, p2);
    } 
}
