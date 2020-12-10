package org.eda1.practica02.ejercicio01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ProcesarDireccionesTestJUnit4 {

	String directorioEntrada;
	ProcesarDirecciones proceso = null;
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
			    "src" + File.separator + 
			    "org" + File.separator +
			    "eda1" + File.separator + 
			    "practica02" + File.separator + 
			    "ejercicio01" + File.separator;
	}

	@Test
	public void testCargarArchivoSencillo() throws FileNotFoundException {
		
		String archivo = directorioEntrada + "auxiliar.txt";
		String texto = "";
		proceso = new ProcesarDirecciones();
		

		texto   = "192.146.1.234 pedro.ual.es" + "\n"
				+ "192.146.1.234 pedro.ual.es" + "\n"
				+ "192.146.1.234 pedro.ual.es" + "\n";
		

		generarArchivo(archivo, texto);

		proceso.cargarArchivo(archivo);
		
		assertTrue(proceso.size() == 1);
		assertTrue(proceso.getSumaContadores() == 3);
		assertTrue(proceso.getSumaContadores("192.146.1.234") == 3);
		assertTrue(proceso.getSumaContadores("192.146.1.235") == -1);
		
		texto = "{192.146.1.234, [pedro.ual.es, 3]}\n";
				
		assertEquals(proceso.toString(), texto);
	
		// Ahora probamos con tres entradas distinta
		
		texto   = "192.146.1.231 pedro.ual.es" + "\n"
				+ "192.146.1.232 pedro.ual.es" + "\n"
				+ "192.146.1.233 pedro.ual.es" + "\n";
		

		generarArchivo(archivo, texto);

		proceso.cargarArchivo(archivo);
		assertTrue(proceso.size() == 3);
		assertTrue(proceso.getSumaContadores() == 3);
		assertTrue(proceso.getSumaContadores("192.146.1.231") == 1);
		
	}

	@Test
	public void testCargarArchivoDireccionesMaquinaCasoEjemplo() throws FileNotFoundException {

		String archivo = directorioEntrada + "auxiliar.txt";
		String texto = "";
		proceso = new ProcesarDirecciones();
		
			
		texto = "192.146.1.234 pedro.ual.es" + "\n"
				+ "150.214.156.17 rosa.ual.es" + "\n"
				+ "192.146.1.234 voltaire.ual.es" + "\n"
				+ "192.146.1.233 pascal.ual.es" + "\n"
				+ "150.214.156.17 almirez.ual.es" + "\n"
				+ "192.113.2.4 jupiter.ual.es" + "\n"
				+ "150.214.20.25 nacho.ugr.es" + "\n"
				+ "192.146.1.234 leo.ual.es" + "\n"
				+ "113.213.12.1 epicuro.ual.es" + "\n"
				+ "192.146.1.234 voltaire.ual.es" + "\n"
				+ "150.214.156.17 antonio.ual.es" + "\n"
				+ "113.213.12.1 epi.ual.es" + "\n"
				+ "97.100.7.155 antonio.ual.es" + "\n"
				+ "150.214.156.17 almirez.ual.es" + "\n"
				+ "150.214.156.32 antonio.ual.es" + "\n"
				+ "192.146.1.244 ant.ual.es" + "\n"
				+ "150.214.194.195 nevada.ugr.es" + "\n"
				+ "92.140.12.255 rosa.ual.es" + "\n"
				+ "97.100.7.155 antonio.ual.es" + "\n"
				+ "92.140.12.255 rosa.ual.es" + "\n"
				+ "97.100.7.155 antonio.ual.es" + "\n"
				+ "192.146.1.234 voltaire.ual.es" + "\n"
				+ "150.214.156.2 calido.ual.es" + "\n"
				+ "97.100.7.155 antonio.ual.es" + "\n"
				+ "150.214.156.32 alboran.ual.es" + "\n"
				+ "192.146.1.234 leo.ual.es" + "\n"
				+ "192.146.1.233 pascal.ual.es" + "\n"
				+ "150.214.194.195 nevada.ugr.es" + "\n"
				+ "150.214.20.25 veleta.ugr.es" + "\n"
				+ "192.146.1.234 pedro.ual.es" + "\n"
				+ "192.146.1.244 antonio.ual.es" + "\n"
				+ "192.146.1.233 poisson.ual.es" + "\n"
				+ "150.214.156.2 filabres.ual.es" + "\n"
				+ "150.214.194.195 nevada.ugr.es" + "\n"
				+ "150.214.156.17 almirez.ual.es" + "\n"
				+ "150.214.156.32 alboran.ual.es" + "\n"
				+ "150.214.156.2 pedro.ual.es" + "\n";

		generarArchivo(archivo, texto);

		proceso.cargarArchivo(archivo);

		assertTrue(proceso.getSumaContadores() == 37);
		assertTrue(proceso.size() == 12);

		texto = "(150.214.156.32, alboran.ual.es)" + "\n"
				+ "(192.146.1.233, pascal.ual.es)" + "\n"
				+ "(192.146.1.234, leo.ual.es)" + "\n"
				+ "(192.146.1.234, pedro.ual.es)" + "\n"
				+ "(92.140.12.255, rosa.ual.es)" + "\n";
		
		assertEquals(texto, proceso.direccionMaquinasConContador(2));

		assertTrue(proceso.getContador("192.146.1.234", "voltaire.ual.es") == 3);
		assertTrue(proceso.getContador("150.214.156.17", "antonio.ual.es") == 1);
		assertTrue(proceso.getContador("97.100.7.155", "antonio.ual.es") == 4);
	}

	@Test
	public void testGuardarArchivoDireccionesMaquina() throws IOException {
		
		String archivoEntrada =  directorioEntrada + "entradas.txt";
		String archivoIncidencias = directorioEntrada + "incidencias.txt";
		Scanner scan = null;
		String linea;
		ArrayList<String> salidaEsperada = new ArrayList<String>();
		proceso = new ProcesarDirecciones();

		//El ejemplo del pdf de la practica
		String texto = "192.146.1.234 voltaire.ual.es" + "\n"
						+ "192.113.2.4 jupiter.ual.es" + "\n"
						+ "192.146.1.234 leo.ual.es" + "\n"
						+ "113.213.12.1 epicuro.ual.es" + "\n"
						+ "192.146.1.234 voltaire.ual.es" + "\n";
		
	    generarArchivo(archivoEntrada, texto);

	    proceso.cargarArchivo(archivoEntrada);
	    			
		proceso.guardarArbol(archivoIncidencias);
				
		salidaEsperada.add("{113.213.12.1, [epicuro.ual.es, 1]}");
		salidaEsperada.add("{192.113.2.4, [jupiter.ual.es, 1]}");
		salidaEsperada.add("{192.146.1.234, [leo.ual.es, 1][voltaire.ual.es, 2]}");
		
		scan = new Scanner (new File(archivoIncidencias));
		
		int i=0;
		while(scan.hasNextLine()){
			linea = scan.nextLine();
			assertEquals(salidaEsperada.get(i++), linea);
		}
		scan.close();
	}
	
	public void generarArchivo(String archivo, String texto){
		try{
			PrintWriter out = new PrintWriter(archivo);
			out.print(texto);
			out.close();
		}catch (Exception e){
			System.out.println(e.getMessage());
			System.exit(-1);
	}
}
	
}
