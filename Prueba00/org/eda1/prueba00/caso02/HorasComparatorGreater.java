package org.eda1.prueba00.caso02;

import java.util.Comparator;

public class HorasComparatorGreater implements Comparator<Trabajador> {

	@Override
    public int compare(Trabajador t1, Trabajador t2) 
    { 
		return - (new HorasComparatorLess()).compare(t1, t2);
    } 
}
