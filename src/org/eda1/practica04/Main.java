package org.eda1.practica04;

import java.io.File;

import org.eda1.practica03.ejercicio02.ProcesarDatos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorioEntrada = System.getProperty("user.dir") + File.separator +
				"src" + File.separator +
				"org" + File.separator +
				"eda1" + File.separator +
				"practica04" + File.separator;

	RoadNetwork proceso = new RoadNetwork();
		proceso.loadRoadNetwork(directorioEntrada + "data.txt");
	System.out.println("¿Cuál es el camino más corto de una ciudad a otra?");
	System.out.println("El camino más corto entre Almeria-Sevilla: es "+proceso.Dijkstra("Almeria", "Sevilla"));
	System.out.println("¿Cuál es el camino más corto entre una ciudad y el resto de ciudades?");

	System.out.println("");
	System.out.println("¿Existen caminos mínimos entre todos los pares de ciudades?. En caso afirmativo, ¿cuáles?");
	System.out.println("");
	System.out.println("¿Cuál es la ciudad más lejana a una ciudad especificada por el usuario?");
	System.out.println("Desde Almeria: es "+proceso.toArrayBF("Almeria").get(proceso.toArrayBF("Almeria").size()-1));
	System.out.println("¿Cuál es la ciudad más céntrica?");

int max=0;
int ciudad=1;
	for( String s:proceso.toArrayBF("Almeria")){
		int contador=0;
		for(String s1: proceso.toArrayBF("Almeria")){
			if(proceso.isAdjacent(s1, s)==true){
				contador++;
			}else {
				continue;
			}
			System.out.println("La ciudad :"+s.toString()+" "+contador);
			ciudad++;
			if(contador>max){
				max=contador;
//				ciudad=s1.toString();

			}
		}
	}
	System.out.println("tt"+ciudad);





	}
}

