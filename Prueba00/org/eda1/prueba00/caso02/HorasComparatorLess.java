package org.eda1.prueba00.caso02;

import java.util.Comparator;

public class HorasComparatorLess implements Comparator<Trabajador> {

	@Override
    public int compare(Trabajador t1, Trabajador t2) 
    { 
		double horas1 = t1.horasMes();
		double horas2 = t2.horasMes();
		if (horas1 < horas2) return -1;
		if (horas1 > horas2) return 1;
		return t1.compareTo(t2);
    } 
}
