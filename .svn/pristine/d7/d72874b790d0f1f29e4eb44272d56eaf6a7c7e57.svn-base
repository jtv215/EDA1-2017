package org.eda1.prueba00.caso04;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Test;

public class GestionPersonaTestJUnit4 {

	String graphFile = System.getProperty("user.dir") + File.separator +
		    		   "src" + File.separator +
		    		   "org" + File.separator +
		    		   "eda1" + File.separator +
		    		   "prueba00" + File.separator +
		    		   "caso04" + File.separator +
		    		   "red";

	@Test
	public void testPersona(){
		Persona p1 = null, p2 = null, p3 = null, p4 = null;;

		TreeSet<String> amigos1 = new TreeSet<String>();
		TreeSet<String> amigos2 = new TreeSet<String>();
		amigos1.add("Juan");
		amigos1.add("Mario");
		amigos1.add("Adela");
		amigos2.addAll(amigos1);

		p1 = new Persona("Juan", amigos1);
		p2 = new Persona("Mario", amigos2);
		p3 = new Persona("Adela", null);
		p4 = new Persona("Adela");

		//metodo toString()
		assertEquals(p1.toString(), "Juan");
		assertEquals(p2.getAmigos().toString(), "[Adela, Juan, Mario]");
		assertTrue(p3.getAmigos() == null);
		assertTrue(p4.getAmigos() == null);
		assertTrue(p4.toString().equals("Adela"));

		//metodo interseccion()

		assertTrue(p1.interseccion(p2) == 3);

		try{
			p1.interseccion(null);
		}catch (Exception e){
			assertEquals(e.getMessage(), "...intersecando con nulo...");
		}

		try{
			p1.interseccion(p3);
		}catch(Exception e){
			assertEquals(e.getMessage(), "...intersecando con lista de amigos null...");
		}

		amigos2.remove("Juan");
		assertEquals(p2.getAmigos().toString(), "[Adela, Juan, Mario]"); //hacemos uso del constructor copia

		p2 = new Persona("mario", amigos2);
		assertEquals(p2.getAmigos().toString(), "[Adela, Mario]");


		assertTrue(p1.interseccion(p2) == 2);

		//metodo compareTo

		assertTrue(p1.compareTo(p1) == 0);
		assertTrue(p1.compareTo(p3) > 0);

		try{
			p1.compareTo(null);
		}catch (Exception e){
			assertEquals(e.getMessage(), "...comparando con nulo...");
		}

		//metodo equals
		assertEquals(p1,p1);
		assertFalse(p1.equals(p2));
		assertEquals(p4,p3);

		try{
			p1.equals(null);
		}catch (Exception e){
			assertEquals(e.getMessage(), "...comparando con nulo...");
		}
	}

	@Test
	public void testLoad() throws FileNotFoundException{

		NetworkPersona net = new NetworkPersona();
		Persona p1 = null, p2 = null;
		String cad = "";
		try{
			net.loadNetwork(graphFile + "...");
		}catch (Exception e){
			assertTrue(e.getMessage().equals("...ERROR AL CARGAR ARCHIVO..."));
		}
		net.loadNetwork(graphFile);

		assertTrue(net.numberOfEdges() == 12);
		assertTrue(net.numberOfVertices() == 6);

		cad = "{Antonio43={Juan32=2.0, Kina45=2.0, Sabina60=1.0}, "
		 	 + "Antonio48={Juan32=1.0}, "
		 	 + "Eusebio98={Kina45=2.0}, "
		 	 + "Juan32={Antonio43=2.0, Antonio48=1.0}, "
		 	 + "Kina45={Antonio43=2.0, Eusebio98=2.0, Sabina60=1.0}, "
		 	 + "Sabina60={Antonio43=1.0, Kina45=1.0}}";

		assertTrue(net.toString().equals(cad));

		p1 = new Persona("Sabina60");
		p2 = new Persona("Antonio43", null);

		assertTrue(net.containsEdge(p1, p2));
		assertTrue(net.containsVertex(p1));
		assertTrue(net.isAdjacent(p2, p1));

		cad = "{Antonio43=1, Antonio48=5, Eusebio98=0, Juan32=3, Kina45=2, Sabina60=4}";
		assertTrue(net.getVertexToIndex().toString().equals(cad));
	}

	@Test
	public void testDijkstra() throws FileNotFoundException{
		NetworkPersona net = new NetworkPersona();
		net.loadNetwork(graphFile);
		Persona source = null, destination = null;
		ArrayList<Persona> caminoMasCorto = null;

		source = new Persona("Eusebio98");
		destination = new Persona("Antonio48");
		caminoMasCorto = net.Dijkstra(source, destination);
		assertEquals(caminoMasCorto.toString(), "[Eusebio98, Kina45, Antonio43, Juan32, Antonio48]");
		assertTrue(net.computeDistanceFromPath(caminoMasCorto) == 7.0);

		net.removeEdge(new Persona("Eusebio98"), new Persona("Kina45"));

		try{
			caminoMasCorto = net.Dijkstra(source, destination);
		}catch (Exception e){
			assertEquals(e.getMessage(), "The vertex Antonio48 is not reachable from Eusebio98");
		}
	}

	@Test
	public void testFollowers() throws FileNotFoundException{
		NetworkPersona net = new NetworkPersona();
		net.loadNetwork(graphFile);
		assertEquals(net.getFollowers(new Persona("Eusebio98"), null),"[Kina45]");
		assertEquals(net.getFollowers(new Persona("Sabina60"), null), "[Antonio43, Kina45]");
		assertEquals(net.getFollowers(new Persona("Antonio43"), new PersonaComparator("<")), "[Juan32, Kina45, Sabina60]");
		assertEquals(net.getFollowers(new Persona("Antonio43"), new PersonaComparator()), "[Juan32, Kina45, Sabina60]");
		assertEquals(net.getFollowers(new Persona("Antonio43"), new PersonaComparator(">")), "[Sabina60, Kina45, Juan32]");

		try{
			new PersonaComparator(">>");
		}catch (Exception e){
			assertTrue(e.getMessage().equals("...orden no permitido...solo < o >"));
		}
	}
}