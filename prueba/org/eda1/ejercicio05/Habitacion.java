package org.eda1.ejercicio05;

import java.util.TreeSet;

public class Habitacion implements Comparable<Habitacion>{

	private int numero;
	private TreeSet<Huesped> huespedes;

	public Habitacion(int numero){
		//TODO
		this.numero=numero;
		huespedes= new TreeSet<Huesped>();
	}

	public Habitacion(int numero, TreeSet<Huesped> huespedes){
		//TODO
		this.numero=numero;
		this.huespedes=huespedes;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TreeSet<Huesped> getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(TreeSet<Huesped> huespedes) {
		this.huespedes = huespedes;
	}

	public int numeroHuespedes(){
		//TODO Retorna el numero de huespedes alojados en la habitacion
		return huespedes.size();
	}

	public boolean isHabitacionOcupada(){
		//TODO Comprueba si la habitacion tiene asignado algun huesped

		if(huespedes.size()>0){
			return true;
		}

		return false;
	}

	public void desalojarHabitacion(){
		//TODO Vacia la habitacion
		huespedes.clear();

	}

	public boolean isHuespedAlojado(Huesped h){
		//Verifica si un huesped está alojado en la habitacion
		if(huespedes.contains(h)){
			return true;
		}
		return false;
	}

	public boolean addHuesped(Huesped h){
		//TODO Agrega un huesped a la habitacion

		if(!huespedes.contains(h)){
			huespedes.add(h);
			return true;
		}
		return false;

	}

	public int size(){
		return numeroHuespedes();
	}

	public String toString(){
		return fillNumber(numero, 3)+" => "+huespedes.toString();
	}

	public String fillNumber(int number, int numberOfDigits){
		//TODO Agrega a un numero tantos dígitos como se indiquen por parametro
		//de forma que si se agrega un numero, por ejemplo, 5, y se indica que
		// se requieren 4 digitos, se retornará la cadena "0005"

		StringBuffer sb = new StringBuffer(  numberOfDigits );
		for ( int i=1;i < numberOfDigits;i++) {
		  sb.append("0");
		}
		String codigo = sb.toString()+number;
		return codigo;
	}

//	@Override
//	public boolean equals(Object obj) {
//		//TODO Se compara por el numero de habitacion
//		Huesped h=(Huesped)obj;
//
//
//		return false;
//	}



	@Override
	public int compareTo(Habitacion o) {
		//TODO Se compara por el numero de la habitacion

		if(numero>o.numero){
			return 1;
		}else if( numero<o.numero){
			return -1;
		}else{
			return 0;
		}
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		if (numero != other.numero)
			return false;
		return true;
	}



}
