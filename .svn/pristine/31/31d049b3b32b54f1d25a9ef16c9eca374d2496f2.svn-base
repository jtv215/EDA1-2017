package org.eda1.practica01.ejercicio01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.eda1.practica01.ejercicio01.Editor;
import org.junit.Before;
import org.junit.Test;

public class UseEditorTestJUnit4 {
	String directorioEntrada = "";
	Editor editor = null;
	
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
						    "src" + File.separator + 
						    "org" + File.separator +
						    "eda1" + File.separator + 
						    "practica01" + File.separator + 
						    "ejercicio01" + File.separator;
	}
	

	@Test
	public void testEditor(){
		editor = new Editor();
		try{
			editor.interpret("Insert");
		}catch(Exception e){
			assertEquals(e.getMessage(), Auxiliar.BAD_LINE_MESSAGE);
		}
		
		assertEquals(editor.interpret("$Last"),"0");
		
		editor.interpret("$Insert");
		editor.interpret("1");
		editor.interpret("2");
		editor.interpret("3");
		editor.interpret("4");
			
		editor.interpret("$Line 2");
		editor.interpret("$Insert");
		editor.interpret("2.5");
		
		assertEquals(editor.interpret("$GetLines 2 4"),"2\t2.5\n3\t3\n4\t4\n");
		
		assertEquals(editor.interpret("$Last"),"5");

		editor.interpret("$Delete 2 2");
		assertEquals(editor.interpret("$Done"), "1\n2\n3\n4\n");
		
		editor = null;
		
	}
	
	@Test
	public void testLoad() throws FileNotFoundException {
	    editor = new Editor();
		editor.loadFile(directorioEntrada + "text01");
	    Scanner fileOut = null;
	    String output = "";
	    String expected = "";
		try{
			fileOut = new Scanner(new File(directorioEntrada + "text01.Out"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		while (fileOut.hasNextLine())
			output += fileOut.nextLine() + "\n";
		
		expected ="$Insert\n"
				+ "a\n"
				+ "\n" 
				+ "b\n"
				+ "c\n"
				+ "d\n"
				+ "e\n"
				+ "f\n"
				+ "$li\n"
				+ "Error: not one of the given commands.\n"
				+ "\n"
				+ "$Delete 3 8\n"
				+ "Error: the second line number given is greater than the \n"
				+ "number of the last line in the text.\n"
				+ "\n"
				+ "$Insert\n"
				+ "h\n"
				+ "i\n"
				+ "$Line x\n"
				+ "Error: The command should be followed by a blank space, \n"
				+ "followed by an integer.\n"
				+ "\n"
				+ "$Line 2\n"
				+ "$Insert\n"
				+ "x\n"
				+ "y\n"
				+ "$Delete\n"
				+ "Error: The command should be followed by a blank space, \n"
				+ "followed by an integer, followed by a blank space, followed by an integer.\n"
				+ "\n"
				+ "$Delete 3 x\n"
				+ "Error: The command should be followed by a blank space, \n"
				+ "followed by an integer, followed by a blank space, followed by an integer.\n"
				+ "\n" 
				+ "$Delete 3 22\n"
				+ "Error: the second line number given is greater than the \n"
				+ "number of the last line in the text.\n"
				+ "\n"
				+ "$Delete 3 5\n"
				+ "$Insert\n"
				+ "u\n"
				+ "v\n"
				+ "$Last\n"
				+ "9\n"
				+ "$Done\n"
				+ "***********************\n"
				+ "Here is the final text:\n"
				+ "a\n"
				+ "b\n"
				+ "x\n"
				+ "u\n"
				+ "v\n"
				+ "e\n"
				+ "f\n"
				+ "h\n"
				+ "i\n\n"; 
				
		assertEquals(output,expected); 
	}
	@Test
	public void testLoadExtra() throws FileNotFoundException {
	    editor = new Editor();
		editor.loadFile(directorioEntrada + "text00");
	    Scanner fileOut = null;
	    String output = "";
	    String expected = "";
		try{
			fileOut = new Scanner(new File(directorioEntrada + "text00.Out"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		while (fileOut.hasNextLine())
			output += fileOut.nextLine() + "\n";
		
		System.out.println(output.length());
		
		expected = "$Done\n"
				+ "***********************\n"
				+ "Here is the final text:\n"
				+ "Lincoln once said that\n"
				+ "you can fool\n"
				+ "...\n"
				+ "You can fool\n"
				+ "all the people\n"
				+ "some of the time,\n"
				+ "and some of the people\n"
				+ "some of the people\n"
				+ "all the time,\n"
				+ "but you cannot fool\n"
				+ "all the people\n"
				+ "all the time.\n"
				+ "\n";
		 
		assertEquals(output.substring(output.lastIndexOf("$Done")), expected);
		
	}
}
