package org.eda1.prueba00.caso02;

import java.util.ArrayList;
import java.util.Locale;

public class Trabajador implements Comparable<Trabajador>{
	private String nombre;
	private ArrayList<Double> horasDia;

	private String format(double num){
		return String.format(Locale.US, "%.2f", num);
	}

	public Trabajador (String nombre, ArrayList<Double> horasDia){
		this.nombre = nombre.toUpperCase();
		this.horasDia = horasDia == null ? new ArrayList<Double>() : new ArrayList<Double>(horasDia);
	}

	public double horasMes(){

		double suma=0;
			for(Double d:horasDia){
				if(d!=null){
				suma+=d;

			}
		}

		return suma;
	}

	public double mediaHorasMes(){
		return this.horasMes() / 30;
	}

	@Override
	public String toString(){
		return this.nombre + " <" + format(this.horasMes()) + ", " + format(this.mediaHorasMes()) + ">";
	}

	public String toStringExtend(){
		return this.nombre + " --> " + this.horasDia.toString();
	}

	@Override
	public int compareTo(Trabajador otro){
		String []a= this.nombre.split(" ");
		String []b=otro.nombre.split(" ");

		int comp=a[1].compareTo(b[1]);
		if(comp==0){
			comp=a[2].compareTo(b[2]);
			if(comp==0){
				comp=a[0].compareTo(b[0]);
			}
		}
		return comp;

	}
}