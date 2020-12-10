package org.eda1.ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Empresa {
	private static final int MAX_VALUE = 0;
	//NombreEmpleado, Año, Mes, [Horas]
	//TreeMap<NombreEmpleado, TreeMap<Año, TreeMap<Mes, ArrayList<Horas>>>>
	private TreeMap<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> mapa;

	public Empresa(){
		this.mapa = new TreeMap<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>>();
	}


	public void loadFile(String archivo) throws FileNotFoundException{

		Scanner sc = new Scanner(new File(archivo));
		String linea = null;
		String[] x = null;
		boolean tipoDato=false;

		while (sc.hasNextLine()) {
			linea=sc.nextLine();
			if(linea.startsWith("%")|| linea.trim().isEmpty())continue;
			if(linea.startsWith("@empleados")){
				tipoDato=true;
				continue;
			}else if(linea.startsWith("@datos")){
				tipoDato=false;
				continue;
			}
			if(tipoDato){
				//agrego solo el nombre con el TreeMap vacío.
					mapa.put(linea, new TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>());
			}else{
				x=linea.split("#");

				String nombre=x[0];
				//buscamos el nombre 
				if(!mapa.containsKey(nombre)) continue;
				
				int anno=Integer.parseInt(x[1]);
				int mes=Integer.parseInt(x[2]);

				ArrayList<Double> alhoras = new ArrayList<Double>();
				String[] arrayHoras = x[3].split(" ");
				for (String s : arrayHoras) {
					alhoras.add(s.equals("-")?null:Double.parseDouble(s));
				}

				if(!mapa.get(nombre).containsKey(anno)){
					mapa.get(nombre).put(anno, new TreeMap<Integer, ArrayList<Double>>());
				}
				if(!mapa.get(nombre).get(anno).containsKey(mes)){
					mapa.get(nombre).get(anno).put(mes, alhoras);
				}

			}
			//TODO
		}
		sc.close();


	}

	public int size(){
		return mapa.size();
	}

	public String toString(){
		//TODO
		//"Alberto Istoia Cruz:"+
		//"\n\t1/2014 => 68.0"+ "\nTOTAL HORAS = 1093.0";

		String s = "";
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			s+=it.getKey()+":\n";
			double totalHoras=0;
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					totalHoras+=totalHoras(it3.getValue());
					s+="\t"+it3.getKey()+"/"+it2.getKey()+" => "+totalHoras(it3.getValue())+"\n";
				}
			}
			s+="TOTAL HORAS = "+totalHoras+"\n\n";
		}
		return s;
	}

	public TreeSet<String> listadoEmpleados(){
		//TODO
		TreeSet<String> ts = new TreeSet<String>();
		ts.addAll(mapa.keySet());
		return ts;

//		TreeSet<String> ts = new TreeSet<String>();
//		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
//			ts.add(it.getKey());
//		}
//
//		return ts;
	}

	public String empleadoMasTrabajador(){
		double max =0;
		String empleado = null;
		//TODO

		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			double numHoras=0;
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					numHoras+=totalHoras(it3.getValue());
				}
			}
			if(numHoras>max){
				max=numHoras;
				empleado=it.getKey();
			}
		}
		return empleado;
	}

	public String empleadoMenosTrabajador(){
		//TODO
		double min = Double.MAX_VALUE;
		String empleado = null;
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			double numHoras=0;
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					numHoras+=totalHoras(it3.getValue());
				}
			}
			if(numHoras<min){
				min=numHoras;
				empleado=it.getKey();
			}
		}
		return empleado;
	}

	public TreeSet<String> empleadosQueHanTrabajadoEnAnno(int anno){
		TreeSet<String> ts = new TreeSet<String>();
		//TODO
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
					for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
						if(it2.getKey().equals(anno)){
							ts.add(it.getKey());
						}
					}
			}
		}
		return ts;
	}

	public TreeSet<String> empleadosQueHanTrabajadoEnMes(int mes){
		//TODO
		TreeSet<String> ts = new TreeSet<String>();
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				if(it2.getValue().keySet().contains(mes)){
					ts.add(it.getKey());
//					 break;
				}
			}
		}
		return ts;
	}

	public ArrayList<String> listadoAscendenteEmpleadosOrdenadoPorTotalDeHoras(){
		//TODO mirarmelo
		ArrayList<String> al = new ArrayList<String>();
		TreeMap<Double, TreeSet<String>> aux = new TreeMap<Double, TreeSet<String>>();

	for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
		double numHoras=0;
		for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
			for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					numHoras+=totalHoras(it3.getValue());
				}
			}
			if(!aux.containsKey(numHoras)){
				aux.put(numHoras, new TreeSet<String>());
			}
			aux.get(numHoras).add(it.getKey());
		}

		for (Entry<Double, TreeSet<String>> it : aux.entrySet()) {
			for (String s : it.getValue()) {
				al.add(s);
			}
		}
		return al;
	}

	public String mesMasTrabajado(){
		//TODO mirarmelo
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		TreeMap<Integer, Double> aux = new TreeMap<Integer, Double>();
		int mes = -1;
		double max = 0;
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					if(!aux.containsKey(it3.getKey())){
						aux.put(it3.getKey(), 0.0);
					}
					aux.put(it3.getKey(), aux.get(it3.getKey())+totalHoras(it3.getValue()));
					//lo que tenga para mes de enero le pones el total de horas
				}
			}
		}
		for (Entry<Integer, Double> it : aux.entrySet()) {
			if(it.getValue() > max){
				max = it.getValue();
				mes = it.getKey();
			}
		}

		return meses[mes-1];


	}

	public int annoMasTrabajado(){
		//TODO mirarmelo


		TreeMap<Integer, Double> aux = new TreeMap<Integer, Double>();
		int anno = -1;
		double max = 0;
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					if(!aux.containsKey(it2.getKey())){
						aux.put(it2.getKey(), 0.0);
					}
					aux.put(it2.getKey(), aux.get(it2.getKey())+totalHoras(it3.getValue()));
				}
			}
		}
		for (Entry<Integer, Double> it : aux.entrySet()) {
			if(it.getValue() > max){
				max = it.getValue();
				anno = it.getKey();
			}
		}

		return anno;

	}
	public String listadoHorasPorAnno(){
		//TODO mirarmelo
		String s = "";
		TreeMap<Integer, Double> aux = new TreeMap<Integer, Double>();
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					if(!aux.containsKey(it2.getKey())){
						aux.put(it2.getKey(), 0.0);
					}
					aux.put(it2.getKey(), aux.get(it2.getKey())+totalHoras(it3.getValue()));
				}
			}
		}
		for (Entry<Integer, Double> it : aux.entrySet()) {
			s+=it.getKey()+" = "+it.getValue();
			if(!it.getKey().equals(aux.lastKey())){
				s+="\n";
			}
		}
		return s;
	}

	public String listadoHorasPorMes(){
		//TODO mirarmelo
		String s = "";
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		TreeMap<Integer, Double> aux = new TreeMap<Integer, Double>();
		for (Entry<String, TreeMap<Integer, TreeMap<Integer, ArrayList<Double>>>> it : mapa.entrySet()) {
			for (Entry<Integer, TreeMap<Integer, ArrayList<Double>>> it2 : it.getValue().entrySet()) {
				for (Entry<Integer, ArrayList<Double>> it3 : it2.getValue().entrySet()) {
					if(!aux.containsKey(it3.getKey())){
						aux.put(it3.getKey(), 0.0);
					}
					aux.put(it3.getKey(), aux.get(it3.getKey())+totalHoras(it3.getValue()));
				}
			}
		}
		for (Entry<Integer, Double> it : aux.entrySet()) {
			s+=meses[it.getKey()-1]+" = "+it.getValue();
			if(!it.getKey().equals(aux.lastKey())){
				s+="\n";
			}
		}
		return s;
	}

	private double totalHoras(ArrayList<Double> horas){
		double suma = 0;
		for (Double d : horas) {
			suma+=d!=null?d:0;
		}
		return suma;
	}

}
