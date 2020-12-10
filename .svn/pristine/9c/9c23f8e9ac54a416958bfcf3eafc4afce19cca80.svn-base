/*
 * 
 */
package org.eda1.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeSet;

import javax.print.DocFlavor.STRING;

// TODO: Auto-generated Javadoc
/**
 * The Class BebidaGraduacion.
 */
public class BebidaGraduacion {

	//TreeMap<TIPO, TreeMap<NOMBRE, GRADUACION>>

	//	ESTO ES UN EJEMPLO DE ESTRUCTURA
	//	-----------------------------------------
	//	| 			| nombre1 -> graduacion1	|
	//	|	tipo1	| nombre2 -> graduacion2	|
	//	| 			| nombre3 -> graduacion3	|
	//	|---------------------------------------|
	//	|			| nombre4 -> graduacion4	|
	//	|	tipo2	| nombre5 -> graduacion5	|
	//	|---------------------------------------|
	//	| 	tipo3	| nombre6 -> graduacion6	|
	/** The tm. */
	//	-----------------------------------------
	private TreeMap<String, TreeMap<String, Double>> tm;

	/**
	 * Gets the tm.
	 *
	 * @return the tm
	 */
	public TreeMap<String, TreeMap<String, Double>> getTm() {
		return tm;
	}

	/**
	 * Instantiates a new bebida graduacion.
	 *
	 * @param archivo the archivo
	 * @throws FileNotFoundException the file not found exception
	 */
	public BebidaGraduacion(String archivo) throws FileNotFoundException{
		cargarDatos(archivo);
	}

	/**
	 * Cargar datos.
	 *
	 * @param archivo the archivo
	 * @throws FileNotFoundException the file not found exception
	 */
	private void cargarDatos(String archivo) throws FileNotFoundException{
		tm=new TreeMap<String, TreeMap<String,Double>>();
		File f = new File(archivo);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			StringTokenizer st = new StringTokenizer(s, ";");
			String tipo=st.nextToken();
			String nombre=st.nextToken();
			double graduacion=Double.parseDouble(st.nextToken());
			addBebida(tipo, nombre, graduacion);
		}
		sc.close();

	}

	/**
	 * Adds the bebida.
	 *
	 * @param tipo the tipo
	 * @param nombre the nombre
	 * @param graduacion the graduacion
	 */
	public void addBebida(String tipo, String nombre, double graduacion){
		//TODO Agrega una bebida con nombre y graduación, atendiendo a su tipo
		//Este método es utilizado en el método "cargarDatos"

		if(!tm.containsKey(tipo)){
			tm.put(tipo, new TreeMap<String,Double>());
		}
		if(!tm.get(tipo).containsKey(nombre)){
			tm.get(tipo).put(nombre, 0.0);
		}
		tm.get(tipo).put(nombre, graduacion);

	}

	/**
	 * Listar bebidas por tipo.
	 *
	 * @return the string
	 */
	public String listarBebidasPorTipo(){
		//TODO Proporciona un listado de bebidas (tipo - nombre (graduacionº))
		//Ordenado por tipo de bebida
		String bebidas="";
		for(Entry<String,TreeMap<String, Double>> it:tm.entrySet()){
			for(Entry<String, Double> it2:it.getValue().entrySet()){
				bebidas+=it.getKey()+ " - "+it2.getKey().toString()+" ("+it2.getValue()+"º)"+"\n";
			}
		}
		return bebidas;
	}

	/**
	 * Listar bebidas con graduacion superior igual a.
	 *
	 * @param graduacion the graduacion
	 * @return the string
	 */
	public String listarBebidasConGraduacionSuperiorIgualA(double graduacion){
		//TODO Proporciona un listado de bebidas (tipo - nombre (graduacionº)) con graduacion superior a la pasada por parametro
		//Ordenado por tipo de bebida

		String bebidas = "";
		for(Entry<String, TreeMap<String, Double>>it:tm.entrySet()){
			for(Entry<String, Double> it2:it.getValue().entrySet()){
				Double grados=it2.getValue();
				if(grados>=graduacion){
					bebidas+=it.getKey()+" - "+it2.getKey().toString()+" ("+it2.getValue()+"º)"+"\n";
				}
			}
		}

		return bebidas;
	}

	/**
	 * Listar bebidas de tipo.
	 *
	 * @param tipo the tipo
	 * @return the string
	 */
	public String listarBebidasDeTipo(String tipo){
		//TODO Proporciona un listado de bebidas (tipo - nombre (graduacionº)) del tipo especificado por parámetro


		String bebidas="";
		for(Entry<String, TreeMap<String, Double>>it:tm.entrySet()){
			for(Entry<String,Double> it2:it.getValue().entrySet()){
				if(it.getKey().contains(tipo)){
					bebidas+=it.getKey()+" - "+it2.getKey().toString()+" ("+it2.getValue()+"º)"+"\n";
				}
			}
		}

		return bebidas;
	}

	/**
	 * Contar bebidas de tipo.
	 *
	 * @param tipo the tipo
	 * @return the int
	 */
	public int contarBebidasDeTipo(String tipo){
		//TODO Cuenta las bebidas del tipo especificado por parámetro

		TreeSet<String> contar=new TreeSet<String>();
		for(Entry<String, TreeMap<String, Double>> it: tm.entrySet()){
			for(Entry<String, Double> it2: it.getValue().entrySet()){
				if(it.getKey().contains(tipo)){
					contar.add(it2.getKey());
				}
			}
		}

		return contar.size();
	}

	/**
	 * Contar bebidas con graduacion superior a.
	 *
	 * @param graduacion the graduacion
	 * @return the int
	 */
	public int contarBebidasConGraduacionSuperiorA(double graduacion){
		//TODO Cuenta las bebidas con graduación superior a la especificada por parámetro

		TreeSet<String> contar=new TreeSet<String>();
		for(Entry<String, TreeMap<String, Double>> it: tm.entrySet()){
			for(Entry<String, Double> it2: it.getValue().entrySet()){
				if(it2.getValue()>graduacion){
					contar.add(it2.getKey());
				}
			}
		}

		return contar.size();
	}

	/**
	 * Listado bebidas por graduacion.
	 *
	 * @return the string
	 */
	public String listadoBebidasPorGraduacion(){
		//TODO Proporciona un listado de bebidas ordenado de forma ascendente segun su graduación (tipo - nombre (graduacionº))

		String cadena="";
		TreeMap<Double, TreeSet<String>> aux= new TreeMap<Double,TreeSet<String>>();

	for(Entry<String, TreeMap<String, Double>> it: tm.entrySet()){
		for(Entry<String, Double> it2: it.getValue().entrySet()){
			double grado=it2.getValue();
		if(!aux.containsKey(grado)){
			aux.put(grado, new TreeSet<String>());
			}
			aux.get(grado).add(it.getKey()+ " - "+it2.getKey());
			}
		}

		for(Entry<Double, TreeSet<String>> it: aux.entrySet()){
			for(String  s:it.getValue()){
				cadena+=s+" ("+it.getKey()+"º)\n";
			}
		}
		return cadena;
	}

	/**
	 * Listar tipos de bebida.
	 *
	 * @return the string
	 */
	public String listarTiposDeBebida(){
		//TODO Proporciona un listado de los tipos de bebida
		String bebidas="";
		for(Entry<String, TreeMap<String, Double>>it:tm.entrySet()){
			if(!it.getKey().equals(tm.lastKey())){
			bebidas+=it.getKey()+", ";
			}else{
				bebidas+=it.getKey()+"";
			}
		}
		return bebidas;
	}

	/**
	 * Listar nombres de bebida.
	 *
	 * @return the string
	 */
	public String listarNombresDeBebida(){
		//TODO Proporciona un listado de los nombres de las bebidas
		TreeSet<String> aux= new TreeSet<String>();
		String cadena="";
		for(Entry<String, TreeMap<String, Double>> it:tm.entrySet()){
			for(Entry<String, Double> it2:it.getValue().entrySet()){
				if(!aux.contains(it2.getKey())){
				aux.add(it2.getKey());
				}
			}
		}
		for(String s:aux){

			if(!s.equals(aux.last())){
				cadena+=s+", ";
			}else{
				cadena+=s+"";

			}
		}
		return cadena;
	}

	/**
	 * Media alcohol.
	 *
	 * @return the double
	 */
	public double mediaAlcohol(){
		//TODO Calcula la media de alcohol total por botella
		double media=0.0;
		int cont=0;
		for(Entry<String, TreeMap<String, Double>> it: tm.entrySet()){
			for(Entry<String, Double> it2: it.getValue().entrySet()){
				media+=it2.getValue();
			cont++;
			}
		}


		return media/cont;
	}

}
