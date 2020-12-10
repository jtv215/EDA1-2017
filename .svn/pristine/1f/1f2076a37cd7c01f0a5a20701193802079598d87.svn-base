package org.eda1.practica02.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

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
			    "practica02" + File.separator + 
			    "ejercicio02" + File.separator;
	}

	@Test
	public void testProcesarDatos() throws FileNotFoundException {
		
		String stringArchivoEntrada = directorioEntrada + "nuevasEmpresasProyectosCiudades.txt";
		String salida = "";
		proceso = new ProcesarDatos();
		
		proceso.cargarArchivo(stringArchivoEntrada);

		assertTrue(proceso.size() == 6);
	

		assertTrue(proceso.numeroProyectosEmpresa("Oracle") == 3);
		assertTrue(proceso.numeroCiudadesProyecto("iWork") == 7);
		assertTrue(proceso.numeroCiudadesEmpresa("Microsoft") == 18);

		assertTrue(proceso.numeroProyectosEmpresa("Oracles") == -1);
		assertTrue(proceso.numeroCiudadesProyecto("jWork") == -1);
		assertTrue(proceso.numeroCiudadesEmpresa("Macrosoft") == -1);
	
		//Comprobamos toString()
		
		salida = "Adobe: Flash<Boston, Charleston, Washington>, Illustrator<Miami, New_Orleans, Sacramento>, Photoshop<Houston, San_Antonio, Seattle>" + "\n"
			   + "Apple: IOS<Dallas, Los_Angeles, New_York, Washington>, Xcode<Atlanta, Berkeley, Detroit, Houston, Miami, Stanford, Washington>, iWork<Atlanta, Chicago, Los_Angeles, Miami, New_Orleans, New_York, Stanford>" + "\n"
			   + "Borland: C++Builder<Berkeley, Ohio, Portland, Washington, Wisconsin>, Delphi<Chicago, Detroit, Jackson, Miami, Milwaukee>, JBuilder<Denver, Miami, Santa_Fe, Tucson>" + "\n"		
			   + "Microsoft: Excel<Las_Vegas, Los_Angeles, Phoenix, Sacramento, San_Francisco>, OutLook<Atlanta, Miami, New_Jersey, New_York, Washington>, PowerPoint<Augusta, Dallas, Helena, Miami, Washington>, VisualC++<Miami, New_York, Philadelphia, Stanford, Washington>, Word<Maryland, Memphis, Miami, New_York, Orlando, Washington>" + "\n"
			   + "Oracle: Database_11g<Augusta, Denver, Los_Angeles, Miami, Redwood_City>, Java<Dallas, Miami, New_York, Sacramento, Washington>, Solaris<Atlanta, Berkeley, New_York, Washington>" + "\n"
		       + "Ramsoft: EZJava<New_York, Stanford, Washington>" + "\n";		
		assertEquals(proceso.toString(), salida);
		
	
		String listaEmpresas = proceso.devolverEmpresasCiudad("Miami");
		
		salida = "[Adobe, Apple, Borland, Microsoft, Oracle]";	
		
		assertEquals(listaEmpresas, salida);
	
		
		String listaProyectos = proceso.devolverProyectosCiudad("Washington");
		
		salida = "[Flash, IOS, Xcode, C++Builder, OutLook, PowerPoint, VisualC++, Word, Java, Solaris, EZJava]";
		
		assertEquals(listaProyectos, salida);

		String ciudades = proceso.devolverCiudadesEmpresa("Apple");
		
		salida  = "[Dallas, Los_Angeles, New_York, Washington, Atlanta, Berkeley, Detroit, Houston, Miami, Stanford, Chicago, New_Orleans]";
		assertEquals(ciudades, salida);
		
	
		ciudades = proceso.devolverCiudadesEmpresa("Aple");
		assertEquals(ciudades, "[]");

		listaEmpresas = proceso.devolverEmpresasCiudad("Miamis");
		assertEquals(listaEmpresas, "[]");

		listaProyectos = proceso.devolverProyectosCiudad("Sinsinati");
		assertEquals(listaProyectos, "[]");

	}
}
