package org.eda1.actividad04.ejercicio01;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import org.eda1.actividad04.ejercicio01.SpellChecker;
import org.junit.Test;

public class SpellCheckerTestJUnit4 {

	String inputDirectory = System.getProperty("user.dir") + File.separator + 
							"src" + File.separator + 
							"org" + File.separator + 
							"eda1" + File.separator + 
							"actividad04" + File.separator + 
							"ejercicio01" + File.separator;
	
	@Test
	public void testSpellChecker() {

		LinkedList<String> compareResult= null;
		SpellChecker spellChecker = new SpellChecker();
		
	
		spellChecker.loadDictionary(inputDirectory + "dictionary.txt");
		spellChecker.loadDocument(inputDirectory + "document.txt");
		
		assertTrue(spellChecker.size() == 58109);
		assertTrue(spellChecker.contains("structure"));
		assertFalse(spellChecker.contains("organization"));	
		assertFalse(spellChecker.contains("a"));
		assertFalse(spellChecker.contains("organizing"));

		compareResult = spellChecker.compare();

		assertTrue(compareResult.size() == 3);

		assertEquals(compareResult.toString(), "[a, organization, organizing]");

		assertFalse(spellChecker.contains("organization"));
		
		
		spellChecker.addToDictionary(compareResult);

		assertTrue(spellChecker.contains("organization"));

		assertTrue(spellChecker.size() == 58112);
		
		assertEquals(spellChecker.compare().toString(), "[]");

		spellChecker.addToDocument("?????.....,organization,,,,;");
		assertEquals(spellChecker.compare().toString(), "[]");

		spellChecker.addToDocument("Go confidently...in the directionar of your dreams!!!!");
		assertEquals(spellChecker.compare().toString(), "[directionar]");

	}

}