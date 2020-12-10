package org.eda1.practica02.ejercicio03;

import java.util.Comparator;

/**
 * The Class DistanceComparator.
 */
public class DistanceComparator implements Comparator<PalabraDistancia> {
	// @Override
	// public int compare(PalabraDistancia x, PalabraDistancia y)
	// {
	// //Comparamos distancias. A igual distancia, el orden lo establecería
	// x.getPalabra() e y.getPalabra()
	//
	// if(x.getDistancia()>y.getDistancia()){
	// return -1;
	// }else if(x.getDistancia()>y.getDistancia()){
	// return 1;
	// }else{
	// return x.getPalabra().compareTo(y.getPalabra());
	// }
	// }

	public int compare(PalabraDistancia x, PalabraDistancia y) {
		int d = x.getDistancia() - y.getDistancia();
		if (d == 0) {
			return x.compareTo(y);
		}
		return d;
	}
}
