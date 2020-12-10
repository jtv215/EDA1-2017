package org.eda1.ejercicio03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Universidad {

	private String nombre;
	private TreeMap<Curso, TreeSet<Alumno>> tm;

	public Universidad(File archivo) throws FileNotFoundException {
		cargarDatos(archivo);
	}

	private void cargarDatos(File archivo) throws FileNotFoundException {
		tm = new TreeMap<Curso, TreeSet<Alumno>>();
		Scanner sc = new Scanner(archivo);
		this.nombre = sc.nextLine();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			StringTokenizer st = new StringTokenizer(s, ";");
			String dni = st.nextToken();
			String nombre = st.nextToken();
			String apellido1 = st.nextToken();
			String apellido2 = st.nextToken();
			String carrera = st.nextToken();
			int curso = Integer.parseInt(st.nextToken());
			String asignatura = st.nextToken();
			Alumno a = new Alumno(dni, nombre, apellido1, apellido2);
			Curso c = new Curso(carrera, curso, asignatura);
			if (!tm.containsKey(c)) {
				tm.put(c, new TreeSet<Alumno>());
			}
			tm.get(c).add(a);
		}
		sc.close();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void clear() {
		// TODO
		tm.clear();
	}

	public void remove(Curso c) {
		// TODO

		tm.remove(c);
	}

	public boolean addCurso(Curso c) {
		// TODO
		if (!tm.containsKey(c)) {
			tm.put(c, new TreeSet<Alumno>());
			return true;
		}
		return false;
	}

	public boolean addCurso(String carrera, int curso, String asignatura) {
		// TODO
		Curso c = new Curso(carrera, curso, asignatura);
		return addCurso(c);
	}

	public boolean addAlumno(Curso c, Alumno a) {
		// TODO
		addCurso(c);
		return tm.get(c).add(a);
	}

	public boolean addAlumno(Curso c, String dni, String nombre, String apellido1, String apellido2) {
		// TODO
		Alumno a = new Alumno(dni, nombre, apellido1, apellido2);
		return addAlumno(c, a);
	}

	public int numeroAsignaturas() {
		// TODO curso(carrera,curso,asignatura)alumno(dni,nombre,apell1,apell2)

		TreeSet<Curso> aux = new TreeSet<Curso>();
		aux.addAll(tm.keySet());
		return aux.size();
	}

	public int numeroAlumnos() {
		// TODO
		TreeSet<Alumno> aux = new TreeSet<Alumno>();

		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				aux.addAll(it.getValue());
			}

		return aux.size();

	}

	public int numeroMatriculas() {
		// TODO curso(carrera,curso,asignatura)alumno(dni,nombre,apell1,apell2)
		int cont=0;
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
			cont+=it.getValue().size();
		}
		return cont;
	}

	public int numeroAlumnosDeCarrera(String carrera) {
		// TODO
		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				if(it.getKey().getCarrera().equals(carrera)){
				aux.addAll(it.getValue());
				}
		}
		return aux.size();
	}

	public int numeroMatrículasDeCarrera(String carrera) {
		// TODO  curso(carrera,curso,asignatura)alumno(dni,nombre,apell1,apell2)
		//por parametro me pasan una carrera y tengo devolver el numero de alumnos matriculados
		int cont=0;
		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				if(it.getKey().getCarrera().equals(carrera)){
				cont+=it.getValue().size();
				}
		}
		return cont;
	}

	public int numeroAlumnosDeAsignatura(String asignatura) {
		// TODO
		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				if(it.getKey().getAsignatura().equals(asignatura)){
				aux.addAll(it.getValue());
				}
		}
		return aux.size();
	}

	public int numeroMatriculasDeAsignatura(String asignatura) {
		// TODO curso(carrera,curso,asignatura)alumno(dni,nombre,apell1,apell2)
		//devuelve el numero de alumnos matriculados de la asignatura que me pasan por
		//parametro
		
		int cont=0;
		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				if(it.getKey().getAsignatura().equals(asignatura)){
				cont+=it.getValue().size();
				}
		}
		return cont;
	}

	public String listadoCursoAlumnos() {
		// TODO "ADE 1º (Estadística):\n"+
		//"\t48654797E -> Francisco Lorente Estevez\n"+
		String s="";
		for(Entry<Curso, TreeSet<Alumno>> it:tm.entrySet()){
			s+=(s.length()==0?"":"\n")+it.getKey()+":";

			for(Alumno it2:it.getValue()){
				s+="\n\t"+it2.toString();
			}
		}
		return s;
	}

	public String listadoAlumnosCarreraOrdenados(String carrera) {
		// TODO mirar el test

		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				if(it.getKey().getCarrera().equals(carrera)){
				aux.addAll(it.getValue());
				}
		}
		return aux.toString().replace("[", "").replace("]", "");

	}

	public String listadoAlumnosCursoOrdenados(int curso) {
		// TODO
		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
				if(it.getKey().getCurso()==curso){
				aux.addAll(it.getValue());
				}
		}
		return aux.toString().replace("[", "").replace("]", "");

	}

	public String listadoAlumnosCarreraCursoAsignatura(String carrera, int curso, String asignatura) {
		// TODO "37606876J -> Juan Perez Lopez, 56764319C -> Enrique Mata Galan";

		Curso a= new Curso(carrera, curso, asignatura);
		TreeSet<Alumno> aux = new TreeSet<Alumno>();
		for (Entry<Curso, TreeSet<Alumno>> it : tm.entrySet()) {
			if(it.getKey().equals(a)){
				aux.addAll(it.getValue());
			}
		}
		return aux.toString().replace("[", "").replace("]", "");
	}

	public String listadoCursosConMasDeKAlumnosMatriculados(int k) {
		// TODO
		//una lista de curso que en ese curso haya mas alumnos que pase por parametro
		TreeSet<Curso> ts= new TreeSet<Curso>();
		for(Entry<Curso, TreeSet<Alumno>> it:tm.entrySet()){
			if(it.getValue().size()>k){
				ts.add(it.getKey());
			}
		}
		return ts.toString().replace("[", "").replace("]", "");
	}

	public String listadoAlumnosAsignaturasMatriculado() {
		// TODO"37606876J -> Juan Perez Lopez:\n"+
		//"\tADE 3º (Economía Mundial)\n"+
		//"\tInformatica 1º (Introducción a la Programación)\n"+

		TreeMap<Alumno, TreeSet<Curso>> aux= new TreeMap<Alumno,TreeSet<Curso>>();
		for(Entry<Curso, TreeSet<Alumno>> it:tm.entrySet()){
			for(Alumno a:it.getValue()){
				if(!aux.containsKey(a)){
					aux.put(a,new TreeSet<Curso>());
				}
				aux.get(a).add(it.getKey());
			}
		}

		String s="";
		for(Entry<Alumno,TreeSet<Curso>> it:aux.entrySet()){
			s+=it.getKey().toString()+":\n";//llamo al toString de alumno
			for(Curso c:it.getValue()){
			s+="\t"+c.toString()+"\n";//llamo al to String de curso
			}
		}
		return s;
	}

	public String alumnosConMasMatriculas() {
		// TODO

		TreeMap<Alumno, TreeSet<Curso>> aux= new TreeMap<Alumno,TreeSet<Curso>>();
		for(Entry<Curso, TreeSet<Alumno>> it:tm.entrySet()){
			for(Alumno a:it.getValue()){
				if(!aux.containsKey(a)){
					aux.put(a,new TreeSet<Curso>());
				}
				aux.get(a).add(it.getKey());
			}

		}

		String s="";
		for(Entry<Alumno,TreeSet<Curso>> it:aux.entrySet()){
			s+=it.getKey().toString()+":\n";
			for(Curso c:it.getValue()){
			s+="\t"+c.toString()+"\n";
		}
		}

		int max=0;
		TreeSet<Alumno> ts= new TreeSet<Alumno>();
		for(Entry<Alumno, TreeSet<Curso>>it:aux.entrySet()){
			if(it.getValue().size()>max){
				max=it.getValue().size();
				ts.clear();
				ts.add(it.getKey());
			}else if(it.getValue().size()==max){
				ts.add(it.getKey());
			}
		}
		return max+" asignaturas: "+ts.toString().replace("[", "").replace("]", "");


	}

}
