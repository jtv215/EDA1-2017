package org.eda1.practica01.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.eda1.practica01.ejercicio02.ProcesarDatos;
import org.junit.Before;
import org.junit.Test;

public class ProcesarDatosTestJUnit4 {
	String directorioEntrada = "";
	ProcesarDatos proceso = null;
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
						    "src" + File.separator + 
						    "org" + File.separator +
						    "eda1" + File.separator + 
						    "practica01" + File.separator + 
						    "ejercicio02" + File.separator;
	}
	

	@Test
	public void testProcesarDatos() throws FileNotFoundException {
		String salida = "";
		String salidaEsperada = "";
		proceso = new ProcesarDatos();
		proceso.cargarArchivo(directorioEntrada + "empresasProyectosCiudades.txt");

		assertTrue(proceso.size() == 4);
		assertTrue(proceso.getEmpresaProyectos(1).size() == 3);
		assertTrue(proceso.getEmpresaProyectos(1).getProyectoCiudades(1).size() == 5);
		
		salida = proceso.toString();
		salidaEsperada = "Adobe: Photoshop <San_Antonio, Houston, Seattle>; Flash <Charleston, Boston, Washington>; Illustrator <Miami, Sacramento, New_Orleans>" + "\n"
		+ "Microsoft: Word <Washington, New_York, Orlando, Miami, Memphis, Maryland>; VisualC++ <Stanford, Philadelphia, Miami, Washington, New_York>; Excel <Sacramento, Los_Angeles, Phoenix, San_Francisco, Las_Vegas>" + "\n"
		+ "Ramsoft: EZJava <New_York, Stanford, Washington>" + "\n"
		+ "Borland: Delphi <Jackson, Detroit, Chicago, Milwaukee, Miami>; C++Builder <Ohio, Portland, Berkeley, Wisconsin, Washington>; JBuilder <Miami, Tucson, Santa_Fe, Denver>" + "\n";		
		
		assertEquals(salida, salidaEsperada);

		ArrayList<String> empresas = proceso.enumerarEmpresasCiudad("Miami");
		
		assertTrue(empresas.size() == 3);
		
		salida = "";
		for (int i = 0; i < empresas.size(); i++)
			salida = salida + empresas.get(i) + "\n";
		
		salidaEsperada = "Adobe\nMicrosoft\nBorland\n";
		
		assertEquals(salida, salidaEsperada);
		
		ArrayList<String> proyectos = proceso.enumerarProyectosCiudad("Washington");

		assertTrue(proyectos.size() == 5);
		
		salida = "";
		for (int i = 0; i < proyectos.size(); i++)
			salida = salida + proyectos.get(i) + "\n";
		
		salidaEsperada = "Flash" + "\n"
						 + "Word" + "\n"
						 + "VisualC++" + "\n"
						 + "EZJava" + "\n"
						 + "C++Builder" + "\n";
		assertEquals(salida, salidaEsperada);

		assertTrue(proceso.contarCiudadesEmpresa("Microsoft") == 13);
		assertTrue(proceso.contarCiudadesEmpresa("Apple") == 0); 

	}
}
