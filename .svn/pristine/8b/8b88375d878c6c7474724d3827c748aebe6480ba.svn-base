package org.eda1.cargararchivo.ejemplo04;

import java.util.Comparator;


public class NotasComparatorGreater implements Comparator<Alumno>
{
    public int compare(Alumno al1, Alumno al2)
    {
    	if (al1.calcularNotaMedia()<al2.calcularNotaMedia()) {
			return 1;
		}else if (al1.calcularNotaMedia()>al2.calcularNotaMedia()) {
			return -1;
		}
    	return 0;
    }
}