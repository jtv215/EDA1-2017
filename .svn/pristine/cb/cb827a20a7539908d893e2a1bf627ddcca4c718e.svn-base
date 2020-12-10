package org.eda1.practica02.ejercicio01;

import org.eda1.practica02.edaAuxiliar.BSTree;
import org.eda1.practica02.edaAuxiliar.Iterator;

/**
 * The Class DireccionMaquinas.
 */
public class DireccionMaquinas implements Comparable<DireccionMaquinas> {

	/** The direccion. */
	private String direccion;

	/** The maquinas. */
	private BSTree<MaquinaContador> maquinas = new BSTree<MaquinaContador>();

	/**
	 * Instantiates a new direccion maquinas.
	 *
	 * @param direccion the direccion
	 */
	public DireccionMaquinas(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Instantiates a new direccion maquinas.
	 *
	 * @param direccion the direccion
	 * @param maquina the maquina
	 */
	public DireccionMaquinas(String direccion, String maquina) {
		this.direccion = direccion;
		this.maquinas.add(new MaquinaContador(maquina));
	}

	/**
	 * Adds the.
	 *
	 * @param mc the mc
	 * @return true, if successful
	 */
	public boolean add(MaquinaContador mc) {
		// TODO
		// Devolvemos true si mc no existia en la estructura; false en caso
		// contrario

		return this.maquinas.add(mc);
	}

	/**
	 * Gets the suma contadores.
	 *
	 * @return the suma contadores
	 */
	public int getSumaContadores() {
		// TODO;

		int contador = 0;
		Iterator<MaquinaContador> it = maquinas.iterator();
		while (it.hasNext()) {
			contador += it.next().getContador();
		}
		return contador;

	}

	/**
	 * Find.
	 *
	 * @param maquina the maquina
	 * @return the maquina contador
	 */
	public MaquinaContador find(String maquina) {
		return this.maquinas.find(new MaquinaContador(maquina));
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Gets the maquinas.
	 *
	 * @return the maquinas
	 */
	public BSTree<MaquinaContador> getMaquinas() {
		return this.maquinas;
	}


	@Override
	public int compareTo(DireccionMaquinas otra) {
		// TODO
		// Comparamos this.direccion con otra.direccion
		return this.direccion.compareTo(otra.direccion);
	}



	/**El toString de dirección maquina
	*Ejemplo de Ejemplo"{192.113.2.4, [jupiter.ual.es, 1]}"
	*/

	@Override
	public String toString() {
		String salida = "{" + this.direccion + ", ";
		Iterator<MaquinaContador> it = maquinas.iterator();
//		// for(MaquinaContador mc:maquinas){
//		// salida+=mc.toString();
//		// }
//
		while (it.hasNext()) {
			salida += it.next().toString();
		}
		salida += "}\n";
		return salida;
	}

	/**
	*Comparamos this.direccoin con otra.direccion
	*/
	@Override
	public boolean equals(Object obj) {
		DireccionMaquinas other = (DireccionMaquinas) obj;
		return this.direccion.equals(other.direccion);
	}
}