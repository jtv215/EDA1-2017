package org.eda1.practica03.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class ProcesarDatosTestJUnit4 {

	String directorioEntrada = System.getProperty("user.dir") + File.separator + 
								"src" + File.separator + 
								"org" + File.separator + 
								"eda1" + File.separator + 
								"practica03" + File.separator +
								"ejercicio02" + File.separator;

	ProcesarDatos proceso = null;;
	
	@Before
	public void setUp() throws Exception {
		proceso = new ProcesarDatos();
		proceso.cargarArchivo(directorioEntrada + "masNuevasEmpresasProyectosCiudades.txt");
	}

	@Test
	public void testProcesarDatos() {
			
		String salidaEsperada = "";
		TreeSet<String> resultado = null;
		assertTrue(proceso.size() == 7);
		assertTrue(proceso.numeroProyectosEmpresa("Google") == 6);
		assertTrue(proceso.numeroProyectosEmpresa("LaKika") == 0);
		assertTrue(proceso.numeroCiudadesProyecto("Earth") == 8);
		assertTrue(proceso.numeroCiudadesProyecto("EDAI") == 0);
		assertTrue(proceso.numeroCiudadesEmpresa("Google") == 20);
		assertTrue(proceso.numeroCiudadesEmpresa("Martinika") == 0);

	
		salidaEsperada = "Adobe: Flash <Boston, Charleston, Washington>; Illustrator <Miami, New_Orleans, Sacramento>; Photoshop <Houston, San_Antonio, Seattle>" + "\n" +
					      "Apple: IOS <Dallas, Los_Angeles, Miami, New_York, Washington>; Xcode <Atlanta, Berkeley, Detroit, Houston, Miami, Stanford, Washington>; iWork <Atlanta, Chicago, Los_Angeles, Miami, New_Orleans, New_York, Stanford>" + "\n" +
					      "Borland: C++Builder <Berkeley, Ohio, Portland, Washington, Wisconsin>; Delphi <Chicago, Detroit, Jackson, Miami, Milwaukee>; JBuilder <Denver, Miami, Santa_Fe, Tucson>" + "\n" +
						  "Google: Chrome <Berkeley, Denver, Houston, New_Jersey, New_York, Orlando>; Earth <Atlanta, Boston, Los_Angeles, Miami, New_Jersey, Ohio, Philadelphia, Washington>; Gmail <Miami, New_York, Phoenix, Portland, Wisconsin>; Maps <Detroit, Miami, New_York, Stanford, Washington>; Talk <Detroit, Los_Angeles, Miami, Washington>; Translate <Dallas, Miami, New_York, Sacramento>" + "\n" +
						  "Microsoft: Excel <Las_Vegas, Los_Angeles, Phoenix, Sacramento, San_Francisco>; OutLook <Atlanta, Miami, New_Jersey, New_York, Washington>; PowerPoint <Augusta, Dallas, Helena, Miami, Seattle, Washington>; VisualC++ <Miami, New_York, Philadelphia, Stanford, Washington>; Word <Maryland, Memphis, Miami, New_York, Orlando, Washington>" + "\n" +
						  "Oracle: Database_11g <Augusta, Denver, Los_Angeles, Miami, Redwood_City>; Java <Dallas, Miami, New_York, Sacramento, Washington>; Solaris <Atlanta, Berkeley, New_York, Washington>" + "\n" +
						  "Ramsoft: EZJava <New_York, Stanford, Washington>" + "\n";		
	
		
		assertEquals(proceso.toString(), salidaEsperada);
		assertTrue(proceso.devolverEmpresas().size() == 7);
		assertTrue(proceso.devolverProyectos().size() == 24);
		assertTrue(proceso.devolverCiudades().size() == 36);
		
		resultado = proceso.devolverEmpresasCiudad("Miami");
		assertTrue(resultado.size() == 6);
		assertEquals(resultado.toString(), "[Adobe, Apple, Borland, Google, Microsoft, Oracle]");
		
	
		resultado = proceso.devolverProyectosCiudad("Washington");
		assertTrue(resultado.size() == 14);
		assertEquals(resultado.toString(), "[C++Builder, EZJava, Earth, Flash, IOS, Java, Maps, OutLook, PowerPoint, Solaris, Talk, VisualC++, Word, Xcode]");
	
		assertEquals(proceso.devolverProyectosCiudad("Madrid").toString(),"[]");
		

		resultado= proceso.devolverCiudadesEmpresa("Google");
		assertTrue(resultado.size() == 20);
		assertEquals(resultado.toString(), "[Atlanta, Berkeley, Boston, Dallas, Denver, Detroit, Houston, Los_Angeles, Miami, New_Jersey, New_York, Ohio, Orlando, Philadelphia, Phoenix, Portland, Sacramento, Stanford, Washington, Wisconsin]");

		assertEquals(proceso.devolverCiudadesEmpresa("Toshiba"),null);

		assertEquals(proceso.devolverProyectoConMayorNumeroDeCiudades(), "Earth");
		assertEquals(proceso.devolverEmpresaConMayorNumeroDeProyectos(), "Google");
		assertEquals(proceso.devolverCiudadConMayorNumeroDeProyectos(), "Miami");
	}
}
