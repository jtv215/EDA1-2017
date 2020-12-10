package org.eda1.ejercicio05;

public class Huesped implements Comparable<Huesped>{

	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;

	public Huesped(String dni){
		//TODO
		this.dni=dni;
	}

	public Huesped(String dni, String nombre, String apellido1, String apellido2){
		//TODO
		this.dni=dni;
		this.nombre=nombre==null?"-":nombre;
		this.apellido1=apellido1==null?"-":apellido1;
		this.apellido2=apellido2==null?"-":apellido2;

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

	@Override
	public String toString() {
		//TODO 12345678A: - -  "12345678A: Juan Alvarez Becerra"
		String s="";
		s= this.dni+": ";
		if(this.nombre==null&& this.apellido1==null && this.apellido2==null){
			s+="- -";
		
		}else if (this.nombre!=null && this.apellido1==null && this.apellido2==null) {
			s+=this.nombre+" -";
		}else if (this.nombre!=null && this.apellido1!=null && this.apellido2==null) {
			s+=this.nombre+ " "+this.apellido1;
		}else{
			s+=this.nombre+" "+this.apellido1+" "+this.apellido2;
		}
	
		return s;
	}


	@Override
	public int compareTo(Huesped o) {
		//TODO Se comparan por dni
		return this.dni.compareTo(o.dni);
	}



	@Override
	public boolean equals(Object obj) {
		//TODO Se comparan por dni
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Huesped other = (Huesped) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}




}
