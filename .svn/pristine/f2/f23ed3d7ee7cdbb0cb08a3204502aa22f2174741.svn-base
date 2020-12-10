package org.eda1.practica02.ejercicio03;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CorrectorOrtograficoTestJUnit4 {
	String directorioEntrada;
	CorrectorOrtografico corrector = null;
	ArrayList<String> listaSugerencias = null;
	
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
				"src" + File.separator + 
				"org" + File.separator +
				"eda1" + File.separator + 
				"practica02" + File.separator +
				"ejercicio03" + File.separator;
	}

	@Test
	public void testLevenshteinDistance()  {
		assertTrue(ComputoDistancia.computeLevenshteinDistance("", "") == 0);
		assertTrue(ComputoDistancia.computeLevenshteinDistance(" ", " ") == 0);
		assertTrue(ComputoDistancia.computeLevenshteinDistance("calle", "calle") == 0);
		assertTrue(ComputoDistancia.computeLevenshteinDistance("calle", "calle ") == 1);
		assertTrue(ComputoDistancia.computeLevenshteinDistance("calle", "calla") == 1);		
		assertTrue(ComputoDistancia.computeLevenshteinDistance("calle", "casa") == 3);
	}
	
	@Test
	public void testListaSugerencias()  {
		
		corrector = new CorrectorOrtografico();
		
		corrector.loadFile(directorioEntrada + "diccionario.txt");
		
		//...Qué pasa si volvemos a cargar el archivo?
		corrector.loadFile(directorioEntrada + "diccionario.txt");
				
	
		listaSugerencias = corrector.listaSugerencias(5, "abracadabra");
		
		assertFalse(listaSugerencias.contains("abracadabra"));
		
		listaSugerencias = corrector.listaSugerencias(5, "abrazar");
		
		assertTrue(listaSugerencias.contains("abrazar"));
	}

	@Test	
	public void testAddPalabra()  {
		
		corrector = new CorrectorOrtografico();
			
		corrector.loadFile(directorioEntrada + "diccionario.txt");
		
	
		listaSugerencias = corrector.listaSugerencias(5, "abracadabra");
		assertFalse(listaSugerencias.contains("abracadabra"));
		
		assertTrue(corrector.size() == 7988);
		corrector.add("abracadabra");
		corrector.add("abracadabra");
		corrector.add("abracadabra");
		assertTrue(corrector.size() == 7989);
		
		assertTrue(corrector.containsPalabra("abracadabra"));
		
		
		listaSugerencias = corrector.listaSugerencias(5, "abracadabra");
		
		assertTrue(listaSugerencias.contains("abracadabra"));
		assertTrue(listaSugerencias.get(0).equals("abracadabra"));
	}

	@Test
	public void testDiccionarioIngles()  {
		
		corrector = new CorrectorOrtografico();
		
		corrector.loadFile(directorioEntrada + "dictionary.txt");
		
		assertTrue(corrector.find("neighbour")!=null);
		assertFalse(corrector.find("neighbor")!=null);
		
		assertTrue(ComputoDistancia.computeLevenshteinDistance("neighbour", "neighbor") == 1);

		listaSugerencias = corrector.listaSugerencias(5, "abracadabra");
		
		assertFalse(listaSugerencias.contains("zugzwang"));
		
		assertTrue(corrector.size() == 58109);
		
		assertTrue(corrector.add("zugzwang"));
		
		listaSugerencias = corrector.listaSugerencias(5, "zugzwang");
		
		assertTrue(listaSugerencias.contains("zugzwang"));
		
		assertTrue(corrector.size() == 58110);
	}
}
