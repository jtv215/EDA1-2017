package org.eda1.practica04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoadNetworkTestJUnit4 {

	private String directorioEntrada = System.getProperty("user.dir") +
										File.separator + "src" + 
										File.separator + "org" + 
										File.separator + "eda1"+ 
										File.separator + "practica04"
										+ File.separator;		
	private RoadNetwork net = null;

	@Before
	public void hola(){
		net = new RoadNetwork();
		net.loadRoadNetwork(directorioEntrada + "data.txt");
	}
	
	@After
	public void adios(){
		net.clear();
		net = null;
	}
	
	@Test
	public void testReadRoadNetwork(){
			
		assertTrue(net.numberOfVertices() == 21);
		assertTrue(net.numberOfEdges() == 58);
		
		String cadena = "{Albacete={Madrid=251.0, Murcia=150.0, Valencia=191.0}, " +
						 "Almeria={Granada=173.0, Murcia=224.0}, " +
						 "Badajoz={Caceres=90.0, Huelva=234.0, Madrid=403.0}, " + 
						 "Barcelona={Gerona=100.0, Valencia=349.0, Zaragoza=296.0}, " + 
						 "Bilbao={Madrid=395.0, Oviedo=304.0, Valladolid=280.0, Zaragoza=324.0}, " + 
						 "Caceres={Badajoz=90.0}, " + 
						 "Cadiz={Sevilla=125.0}, " + 
						 "Corunya={Valladolid=455.0, Vigo=171.0}, " +
						 "Gerona={Barcelona=100.0, Lerida=222.0}, " +
						 "Granada={Almeria=173.0, Jaen=99.0, Murcia=278.0, Sevilla=256.0}, " +
						 "Huelva={Badajoz=234.0, Sevilla=92.0}, " +
						 "Jaen={Granada=99.0, Madrid=335.0, Sevilla=242.0}, " +
						 "Lerida={Gerona=222.0}, " +
						 "Madrid={Albacete=251.0, Badajoz=403.0, Bilbao=395.0, Jaen=335.0, Valladolid=193.0, Zaragoza=325.0}, "+
						 "Murcia={Albacete=150.0, Almeria=224.0, Granada=278.0, Valencia=241.0}, " +
						 "Oviedo={Bilbao=304.0}, " +
						 "Sevilla={Cadiz=125.0, Granada=256.0, Huelva=92.0, Jaen=242.0}, " +
						 "Valencia={Albacete=191.0, Barcelona=349.0, Murcia=241.0}, " +
						 "Valladolid={Bilbao=280.0, Corunya=455.0, Madrid=193.0, Vigo=356.0}, " +
						 "Vigo={Corunya=171.0, Valladolid=356.0}, " +
						 "Zaragoza={Barcelona=296.0, Bilbao=324.0, Madrid=325.0}}";
		
		assertEquals(cadena, net.toString());
	}
	
	@Test
	public void testNetworkIteratorL_BFS_DFS() {
		
		String str = "";
		
		for (String v: net){ //Iteracion sobre el keySet() ... orden lexicografico
			str += v + " ";
		}
		assertEquals(str, "Albacete Almeria Badajoz Barcelona Bilbao Caceres Cadiz Corunya Gerona Granada Huelva Jaen Lerida Madrid Murcia Oviedo Sevilla Valencia Valladolid Vigo Zaragoza ");
		
		str = "";
		for (String v: net.breadthFirstIterator("Almeria")){ //Iteracion en anchura
			str += v + " ";
		}
		assertEquals(str, "Almeria Granada Murcia Jaen Sevilla Albacete Valencia Madrid Cadiz Huelva Barcelona Badajoz Bilbao Valladolid Zaragoza Gerona Caceres Oviedo Corunya Vigo Lerida ");
		
		str = ""; 
		for (String v: net.depthFirstIterator("Almeria")){ //Iteracion en profundidad
			str += v + " ";
		}
		assertEquals(str, "Almeria Murcia Valencia Barcelona Zaragoza Madrid Valladolid Vigo Corunya Jaen Sevilla Huelva Cadiz Badajoz Caceres Bilbao Oviedo Gerona Lerida Albacete Granada ");
	}
								
	@Test
	public void testToArray(){
		assertEquals(net.toArrayDF("Almeria").toString(), "[Almeria, Murcia, Valencia, Barcelona, Zaragoza, Madrid, Valladolid, Vigo, Corunya, Jaen, Sevilla, Huelva, Cadiz, Badajoz, Caceres, Bilbao, Oviedo, Gerona, Lerida, Albacete, Granada]");
		
		assertEquals(net.toArrayBF("Almeria").toString(), "[Almeria, Granada, Murcia, Jaen, Sevilla, Albacete, Valencia, Madrid, Cadiz, Huelva, Barcelona, Badajoz, Bilbao, Valladolid, Zaragoza, Gerona, Caceres, Oviedo, Corunya, Vigo, Lerida]");
	
		assertEquals(net.toArrayDF("Almeria").size(),net.toArrayDFRecursive("Almeria").size());
		assertEquals(net.toArrayDF("Granada").size(),net.toArrayDFRecursive("Granada").size());
	}
	
	@Test
	public void testDijkstra()  {
		ArrayList<String> shortestPath = null; 
		
		shortestPath = net.Dijkstra("Almeria", "Oviedo");
		
		assertEquals(shortestPath.toString(), "[Almeria, Granada, Jaen, Madrid, Bilbao, Oviedo]");
		assertTrue(net.computeDistanceFromPath(shortestPath) == 1306.0);

		shortestPath = net.Dijkstra("Almeria", "Caceres");
		
		assertEquals(shortestPath.toString(), "[Almeria, Granada, Sevilla, Huelva, Badajoz, Caceres]");
		assertTrue(net.computeDistanceFromPath(shortestPath) == 845.0);

	}
}
