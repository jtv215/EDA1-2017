package org.eda1.ejercicio03;

public class Alumno implements Comparable<Object>{

	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;

	public Alumno(String dni, String nombre, String apellido1, String apellido2) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	public int compareTo(Object o) {
		//TODO

		Alumno b=(Alumno) o;

		return this.dni.compareTo(b.getDni());



	}


	@Override
	public boolean equals(Object obj) {
		//solo me pide igualar a dni
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;

		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		//"11111111A -> Juan Garcia Lopez";
		return  dni + " -> " + nombre +" "+apellido1+" "+ apellido2;
	}





}
