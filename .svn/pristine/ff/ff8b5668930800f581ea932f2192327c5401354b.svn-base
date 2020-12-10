package org.eda1.prueba00.caso01;

public class Palabra implements Comparable<Palabra>{
	private String palabra;
	private int frecuencia;
	
	Palabra(){
		this.palabra = "";
		this.frecuencia = -1;
	}
	
	Palabra(String palabra){
		this.palabra = palabra.toLowerCase();
		this.frecuencia = 1;
	}
	
	Palabra(Palabra pal){
		this.palabra = pal.palabra;
		this.frecuencia = pal.frecuencia;
	}
	
	public int getFrecuencia(){
		return this.frecuencia;
	}
	
	public void incrementaFrecuencia(){
		this.frecuencia++;
	}
	
	public int getLongitud(){
		return this.palabra.length();
	}

	@Override
	public int compareTo(Palabra other) {
		return this.palabra.compareTo(other.palabra);
	}

	@Override
	public String toString(){
		if (frecuencia == -1) return "[?]";
		return palabra + " <" + palabra.length() + "," + frecuencia + ">";
	}
}
