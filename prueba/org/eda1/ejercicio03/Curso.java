package org.eda1.ejercicio03;

public class Curso implements Comparable<Object> {

	private String carrera;
	private int curso;
	private String asignatura;

	public Curso(String carrera, int curso, String asignatura) {
		this.carrera = carrera;
		this.curso = curso;
		this.asignatura = asignatura;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (carrera == null) {
			if (other.carrera != null)
				return false;
		} else if (!carrera.equals(other.carrera))
			return false;
		if (curso != other.curso)
			return false;
		return true;
	}

	// La comparativa se realizara por preferencia en
	// carrera, despues por curso y despues por nombre
	public int compareTo(Object o) {
		//TODO

//		Curso otro=(Curso) o;
//		int comp=this.carrera.compareTo(otro.carrera);
//		if(comp==0){
//			if(this.curso==otro.curso){
//				comp=0;
//			}else if(this.curso>otro.curso){
//				comp=1;
//			}else{
//				comp=-1;
//			}
//			if(comp==0){
//				comp=this.asignatura.compareTo(otro.asignatura);
//			}
//		}
//		return comp;
		Curso otro=(Curso) o;
		int comp=this.carrera.compareTo(otro.carrera);
		if(comp==0){
			comp=Integer.compare(this.curso, otro.curso);
			if(comp==0){
				comp=this.asignatura.compareTo(otro.asignatura);
			}
		}
		
		return comp;
		
		
}

	@Override
	public String toString() {
		//TODO "Matematicas 1º (Algebra Lineal)";
		return this.carrera+" "+this.curso+"º ("+this.asignatura+")";
	}

}
