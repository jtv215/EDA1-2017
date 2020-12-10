package org.eda1.ejercicio05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hotel {

	private String nombre;
	private String direccion;
	private TreeMap<Integer, TreeSet<Habitacion>> habitaciones;

	public Hotel(){
		//TODO
		this.nombre="Unknown";
		this.direccion="Undefined";
		habitaciones=new TreeMap<Integer,TreeSet<Habitacion>>();
	}

	public Hotel(String nombre, String direccion){
		//TODO
		this.nombre=nombre.toUpperCase();
		this.direccion=direccion;
	}

	public String getNombre() {
	return  Character.toUpperCase(nombre.charAt(0))+nombre.substring(1,nombre.length()).toLowerCase();
//		return n;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TreeMap<Integer, TreeSet<Habitacion>> getHabitaciones() {
			
		return habitaciones;
		
	}

	public void setHabitaciones(TreeMap<Integer, TreeSet<Habitacion>> habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public String toString() {
		//TODO Retorna el formato especificado en el test
		//"Hotel MELI�\nC/ Las Rodas, 36\n";
		String s="Hotel "+this.nombre+"\n"+this.direccion+"\n";

		return s;
	}

	public boolean add(Huesped huesped, Habitacion hab, int planta){
		//TODO Agrega un HUESPED a la HABITACION de la PLANTA pasados por parametro
		//Primero se deberá comprobar si el HUESPED pasado por parametro no está ya alojado
		//en el hotel, en cuyo caso se retornará false.
		//Sólo en caso de no estarlo, se agregará
		//se agregará la planta (si no está) y la habitación (si no lo está) junto al huesped

		if(!habitaciones.containsKey(huesped)){//1�
			return false;
		}else{
			if(! habitaciones.containsKey(planta)){//2�
			habitaciones.put(planta,new  TreeSet<Habitacion>());
			}
			if(!habitaciones.get(planta).contains(hab)){
			hab.addHuesped(huesped);
			habitaciones.get(planta).add(hab);
			}
			return true;
		}
	}

	public int size(){
		return habitaciones.size();
	}

	public void cargarDatos(String archivo){
		Scanner sc = null;
		int i = 0;
		try {
			sc = new Scanner(new File(archivo));
			habitaciones.clear();
			String linea = null;
			String[] x = null;
			while (sc.hasNextLine()) {
				linea=sc.nextLine();
				//TODO Prestad atención a ambos archivos (ejemplo.txt y datos.txt) para comprobar
				//los formatos que se nos presentan y planificad cuidadosamente la lectura y carga de datos.
				//Como consejo, se sugiere hacer uso del método "add(Huesped huesped, Habitacion hab, int planta)"
				//implementado anteriormente para facilitar la inserción así como reutilizar codigo
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public TreeSet<String> plantasConMasHuespedes(){
		TreeSet<String> ts = new TreeSet<String>();
		//TODO Debe retornar todas aquellas plantas que tengan el mayor numero de huespedes.
		//Si se encuentra más de una planta con el mismo valor maximo, deberán agregarse todas.
		//Si se encuentra alguna planta con mayor numero de huespedes que el máximo, deberán descartarse
		//las anteriormente almacenadas y agregar esta nueva planta.
		//En la estructura auxiliar TreeSet se almacenará el numero de la planta (en formato String)
		return ts;
	}

	public TreeSet<String> habitacionesConMasHuespedes(){
		TreeSet<String> ts = new TreeSet<String>();
		//TODO Debe retornar todas aquellas habitaciones que tengan el mayor numero de huespedes.
		//Si se encuentra mas de una habitación con el mismo valor maximo, deberán agregarse todas.
		//Si se encuentra alguna habitacion con mayor numero de huespedes que el máximo, deberán descartarse
		//las anteriormente almacenadas y agregar esa nueva habitacion.
		//En la estructura auxiliar TreeSet se almacenará el numero de planta junto con el numero de habitacion.
		//Por ejemplo, si la habitacion es la numero 5 de la planta 3, se devolverá 5003, correspondiendo el primer
		//dígito al numero de planta y los tres siguientes al numero de habitacion.
		return ts;
	}

	public String habitacionDelHuespedConDni(String dni){
		//TODO Retorna el numero de la habitación del huesped con DNI.
		//Si el huesped con DNI pasado por parámetro no se encuentra alojado en el hotel,
		//se devolverá un mensaje de la forma "El dni <DNI> no consta como huesped de este hotel".
		//EL formato de habitacion será de forma similar al método anterior. Por ejemplo,
		//si la habitacion es la numero 5 de la planta 3, se devolverá 5003, correspondiendo el primer
		//dígito al numero de planta y los tres siguientes al numero de habitacion.
		return null;
	}

	public TreeSet<String> listadoHabitacionesOcupadas(){
		TreeSet<String> ts = new TreeSet<String>();
		//TODO Retorna el conjunto de habitaciones que están ocupadas por algun huesped.
		//EL formato de habitacion será de forma similar al método anterior. Por ejemplo,
		//si la habitacion es la numero 5 de la planta 3, se devolverá 5003, correspondiendo el primer
		//dígito al numero de planta y los tres siguientes al numero de habitacion.
		return ts;
	}

	public TreeSet<Huesped> listadoHuespedes(){
		TreeSet<Huesped> ts = new TreeSet<Huesped>();
		//TODO Retorna un conjunto de todos los huespedes que estan alojados en el hotel
		return ts;
	}

	public TreeSet<String> habitacionesConHermanos(){
		TreeSet<String> ts = new TreeSet<String>();
		//TODO Devuelve un conjunto de los numeros de las habitaciones que tienen alojados al menos
		//a dos huespedes con los mismos dos apellidos, de forma que se puede considerar que en
		//dicha habitacion están alojados dos hermanos.
		//Por ejemplo, se considerará que una habitacion alberga dos hermanos si, por ejemplo,
		//Luis Lopez Albéniz y Mario Lopez Albeniz están alojados en dicha habitacion.
		//EL formato de habitacion será de forma similar al método anterior. Por ejemplo,
		//si la habitacion es la numero 5 de la planta 3, se devolverá 5003, correspondiendo el primer
		//dígito al numero de planta y los tres siguientes al numero de habitacion.
		return ts;
	}

	public TreeSet<String> habitacionesConPrimos(){
		TreeSet<String> ts = new TreeSet<String>();
		//TODO Devuelve un conjunto de los numeros de las habitaciones que tienen alojados al menos
		//a dos huespedes con uno de los dos apellidos (no los dos apellidos puesto que entonces se podrian considerar hermanos),
		//de forma que se puede considerar que en dicha habitacion están alojados dos primos.
		//Por ejemplo, se considerará que una habitacion alberga dos primos si, por ejemplo,
		//Luis Lopez Albéniz y Mario Gonzalez Albeniz están alojados en dicha habitacion.
		//EL formato de habitacion será de forma similar al método anterior. Por ejemplo,
		//si la habitacion es la numero 5 de la planta 3, se devolverá 5003, correspondiendo el primer
		//dígito al numero de planta y los tres siguientes al numero de habitacion.
		return ts;
	}

	public String porcentajeDeOcupacion(){
		//TODO Retorna el porcentaje de ocupacion del hotel. Dado que no conocemos el tamaño del hotel
		//habrá que considerar el numero total de plantas y el numero total de habitaciones maximo por planta.
		//NUMERO TOTAL DE PLANTAS: Para considerar el numero de plantas, habrá que tener el cuenta el rango de plantas
		//tal que NumeroTotalPlantas=[MayorNumero - MenorNumero + 1]
		//NUMERO TOTAL DE HABITACIONES POR PLANTA: Para considerar el numero de habitaciones por planta, habrá que considerar
		//el MAXIMO rango de todas las plantas, de forma que NumeroHabitacionesPorPlanta=MAX{MayorNumero(i) - MenorNumero(i) +1}
		//Se deberá devolver el porcentaje de ocupacion (numHuespedes / numTotalHabitacionesHotel) con un formato de numero decimal
		//con un sólo dígito decimal. Por ejemplo, 32.7%.
		return "%";
	}
}
