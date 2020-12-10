package org.eda1.prueba00.caso01;

import java.util.Comparator;

public class MediaComparatorGreater implements Comparator<Palabra> {

	@Override
    public int compare(Palabra p1, Palabra p2)
    {
		double media= (double)(p1.getFrecuencia()+p1.getLongitud())/2;
		double media2= (double)(p2.getFrecuencia()+p2.getLongitud())/2;
		if(media==media2){
			return 0;

		}else if(media<media2){
			return 1;

		}else{
			return -1;
		}
    }
}
