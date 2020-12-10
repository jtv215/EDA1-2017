package org.eda1.ejercicio08;

import java.util.Comparator;

public class StartUpComparator implements Comparator<StartUp> {

	private boolean greater;
	
	StartUpComparator(){
		this.greater = false;
	}
	
	StartUpComparator(String order){
		//order será igual a < o > ... en caso contrario lanzara excepcion
		if(!order.equals("<") && !order.equals(">")){
			throw new RuntimeException("...orden no permitido...solo < o >");
		}
		greater = order.equals(">");
	}
	
	@Override
    public int compare(StartUp p1, StartUp p2){ 
		//Ordenamos segun el valor de this.greater
		return greater?new Greater<StartUp>().compare(p1, p2):new Less<StartUp>().compare(p1, p2);
    } 
}
