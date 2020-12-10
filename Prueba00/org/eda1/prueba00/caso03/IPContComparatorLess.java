package org.eda1.prueba00.caso03;

import java.util.Comparator;

public class IPContComparatorLess implements Comparator<Maquina> {

	@Override
	public int compare(Maquina m1, Maquina m2) {

		if (m1.getNumIps() == m2.getNumIps()) {
			return 0;
		} else if (m1.getNumIps() < m2.getNumIps()) {
			return -1;
		}
		return 1;
	}
}
