package org.eda1.actividad04.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.TreeSet;

import org.eda1.actividad04.ejercicio02.Thesaurus;
import org.junit.Test;

public class ThesaurusTestJUnit4 {

	String inputDirectory = System.getProperty("user.dir") + File.separator + 
							"src" + File.separator + 
							"org" + File.separator + 
							"eda1"+ File.separator +
							"actividad04" + File.separator + 
							"ejercicio02" + File.separator;
	
	
	@Test
	public void testThesaurus()  {
	
		TreeSet<String> synonyms = null;
		String[] nuevaLinea = {"acabado", "logrado", "terminado", "conseguido", "rematado"};
		Thesaurus thesaurus = new Thesaurus();
		
		thesaurus.loadThesaurus(inputDirectory + "thesaurus.txt");
				
		assertTrue(thesaurus.size() == 12);

    	assertTrue(thesaurus.isSynonymousOf("limpio", "aseado"));
    	
    	assertFalse(thesaurus.isSynonymous("aseados"));

    	assertTrue(thesaurus.hasSynonymous("verdadero"));
    	assertEquals(thesaurus.getSynonymous("verdadero").toString(), "[autentico, exacto, fiable, probado, real, serio, veraz, veridico]");

    	assertTrue(thesaurus.size("trabajador") == 7);
    	
    	assertEquals(thesaurus.getSynonymous("limpio").toString(), "[acicalado, arreglado, aseado, atildado, compuesto, engalanado, pulcro]"); 
    	

    	thesaurus.add(nuevaLinea);
    	assertTrue(thesaurus.size() == 13);
    	assertFalse(thesaurus.isSynonymousOf("acabado", "remartado"));
    	assertTrue(thesaurus.size("acabado") == 4);
    	
    	thesaurus.add(nuevaLinea);
		assertTrue(thesaurus.size() == 13);
    	
    	
    	thesaurus.add("acabado", "completado");
    	assertTrue(thesaurus.size("acabado") == 5);
		

    	thesaurus.remove("acabado", "complertado");
    	assertTrue(thesaurus.size("acabado") == 5);
   
     	thesaurus.remove("acabado", "completado");
    	assertTrue(thesaurus.size("acabado") == 4);
    	
    	thesaurus.remove("ganador", "triunfador");
    	assertTrue(thesaurus.size("ganador") == 6);
    	
    	thesaurus.remove("acabado");
		assertTrue(thesaurus.size() == 12);
		
    	assertTrue(thesaurus.isSynonymousOf("falso", "embustero"));
    	assertTrue(thesaurus.size("falso") == 4);
    	
    	synonyms = new TreeSet<String>();
    	synonyms.add("erroneo");
    	synonyms.add("inexacto");
    	synonyms.add("infundado");

		
    	thesaurus.update("falso", synonyms);

		assertFalse(thesaurus.isSynonymousOf("falso", "embustero"));
    	assertTrue(thesaurus.size("falso") == 3);
	}
}
