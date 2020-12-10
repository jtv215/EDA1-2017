package org.eda1.cargararchivo.ejemplo04;

import java.util.ArrayList;
import java.util.Locale;

import javax.management.RuntimeErrorException;

public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private ArrayList<Double> notas;

	public Alumno (String nombre, String apellido1, String apellido2){
		this.nombre=nombre.toUpperCase();
		this.apellido1=apellido1.toUpperCase();
		this.apellido2=apellido2.equals("-")?null:apellido2.toUpperCase();
		this.notas=new ArrayList<Double>();
	}

	public Alumno (String nombre, String apellido1, String apellido2, ArrayList<Double> notas){
		this.nombre=nombre.toUpperCase();
		this.apellido1=apellido1.toUpperCase();
		this.apellido2=apellido2.equals("-")?null:apellido2.toUpperCase();
		this.notas=notas==null?new ArrayList<Double>():(ArrayList<Double>) notas.clone();
	}

	public double calcularNotaMedia(){
		if (notas.size()==0) {
			return 0;
		}
		double suma=0;
		for (Double d : notas) {
			suma+=d==null?0:d;
		}
		return suma/notas.size();
	}

	@Override
	public String toString(){
		return this.apellido1+" "+(this.apellido2==null?"":this.apellido2)+" "+this.nombre+" "
				+ "("+String.format(Locale.US, "%.2f", calcularNotaMedia())+")";
	}

	public String nombreCompleto(){
		return this.nombre+" "+this.apellido1+""+(this.apellido2==null?"":" "+this.apellido2);
	}

	public String consultarExpediente(){
		return nombreCompleto()+" --> "+notas.toString().replaceAll("null", "No presentado");
	}

	public int compareTo(Alumno otro){
		if(otro==null) throw new RuntimeException("...comparando con nulo...");
		int comp = (this.apellido1+this.apellido2+this.nombre).compareTo(otro.apellido1+otro.apellido2+otro.nombre);
		if(comp>0) return 1;
		if(comp<0) return -1;
		return 0;
	}
}
