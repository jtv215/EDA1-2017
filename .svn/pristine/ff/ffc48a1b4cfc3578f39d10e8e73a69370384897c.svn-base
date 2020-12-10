package org.eda1.practica02.ejercicio01;

/**
 * The Class MaquinaContador.
 */
public class MaquinaContador implements Comparable<MaquinaContador> {

	/** The maquina. */
	private String maquina;

	/** The contador. */
	private int contador;

 	/**
	  * Instantiates a new maquina contador.
	  *
	  * @param maquina the maquina
	  */
	 public MaquinaContador(String maquina) {
		this.maquina = maquina;
		this.contador = 1;
	}

	/**
	 * Incrementar contador.
	 */
	public void incrementarContador() {
		this.contador++;
	}

	/**
	 * Gets the maquina.
	 *
	 * @return the maquina
	 */
	public String getMaquina(){
		return this.maquina;
	}

	/**
	 * Gets the contador.
	 *
	 * @return the contador
	 */
	public int getContador(){
		return this.contador;
	}

	@Override
	public int compareTo(MaquinaContador otra) {
		//TODO
		//Comparamos this.maquina con otra.maquina
			return this.maquina.compareTo(otra.maquina);
		}
	@Override
	public boolean equals(Object obj) {
		//Comparamos this.maquina con otra.maquina
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaquinaContador other = (MaquinaContador) obj;
		if (maquina == null) {
			if (other.maquina != null)
				return false;
		} else if (!maquina.equals(other.maquina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + maquina + ", " + contador + "]";
	}




}
