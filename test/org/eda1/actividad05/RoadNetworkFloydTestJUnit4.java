package org.eda1.actividad05;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;


public class RoadNetworkFloydTestJUnit4 {

	String directorioEntrada = System.getProperty("user.dir")  
								+ File.separator + "src" 
								+ File.separator + "org" 
								+ File.separator + "eda1"
								+ File.separator + "actividad05"
								+ File.separator;		
	
	@Test
	public void testReadNetwork() throws FileNotFoundException {
		ManageFloyd net =  new ManageFloyd(directorioEntrada + "ejemploClase.txt");
		
		assertTrue(net.numberOfEdges() == 9);
		assertTrue(net.numberOfVertices() == 5);
		String cadena = "{v1={v2=1.0}, " +
						 "v2={v4=4.0, v5=7.0}, " +
						 "v3={v1=3.0, v2=2.0, v5=4.0}, " + 
						 "v4={v1=6.0, v5=2.0}, " + 
						 "v5={v4=3.0}}";
		assertEquals(cadena, net.toString());
		assertEquals(net.getVertexToIndex().toString(),"{v1=0, v2=1, v3=2, v4=3, v5=4}");
		assertTrue(net.getVertexToIndex().size()==net.numberOfVertices());
	}
	
	
	@Test
	public void testFloyd() throws FileNotFoundException {
		
		double[][] matrixD = null;
		int[][] matrixA = null;
		ArrayList<String> paths;
		
		ManageFloyd net =  new ManageFloyd(directorioEntrada + "ejemploClase.txt");

		matrixD = net.getMatrixD();
		matrixA = net.getMatrixA();
		assertTrue(matrixD[1][0] == 10.0);
		assertTrue(matrixD[3][4] == 2.0);
		assertTrue(matrixA[0][0] == -1);
		assertTrue(matrixA[4][1] == 3);
			
		paths = net.getPaths();
		assertTrue(paths.size() == 16);
		assertEquals(paths.get(14), "Camino #15: v5 --> v4 --> v1 --> v2 (10.0)");
		assertEquals(paths.get(3), "Camino #4: v2 --> v4 --> v1 (10.0)");
		assertTrue(net.findPath("v1", "v4").equals("v1 --> v2 --> v4 (5.0)"));
	}
	
	@Test
	public void testSimmetric() throws FileNotFoundException {
		double[][] matrixD = null;
		int[][] matrixA = null;

		ManageFloyd net =  new ManageFloyd(directorioEntrada + "data.txt");

		matrixD = (double[][]) net.getMatrixD();
		matrixA = (int[][]) net.getMatrixA();
		
		for (int i=0; i<net.getVertexToIndex().size(); i++){
			assertTrue(matrixD[i][i] == 0);
			assertTrue(matrixA[i][i] == -1);
			for (int j=i+1; j<net.getVertexToIndex().size(); j++){
				assertTrue(matrixD[i][j] == matrixD[j][i]);
				assertTrue(matrixA[i][j] == matrixA[j][i]);
			}
		}
	}
	
	@Test
	public void testFloydRoad() throws FileNotFoundException {
		
		ArrayList<String> paths = null;
	
		ManageFloyd net =  new ManageFloyd(directorioEntrada + "data.txt");
		
		String cadena = "{Albacete=9, Almeria=0, Badajoz=8, Barcelona=12, "
				      + "Bilbao=16, Caceres=7, Cadiz=2, Corunya=20, Gerona=13, "
				      + "Granada=1, Huelva=3, Jaen=5, Lerida=14, Madrid=11, Murcia=6, "
				      + "Oviedo=17, Sevilla=4, Valencia=10, Valladolid=18, Vigo=19, Zaragoza=15}";

		assertEquals(net.getVertexToIndex().toString(), cadena);	
		
		paths = net.getPaths();

		assertTrue(paths.size() == 420);
		assertEquals(paths.get(0),"Camino #1: Almeria --> Granada (173.0)");
		assertEquals(paths.get(1), "Camino #2: Almeria --> Granada --> Sevilla --> Cadiz (554.0)");
		assertEquals(paths.get(27), "Camino #28: Granada --> Sevilla --> Huelva --> Badajoz (582.0)");
		assertEquals(paths.get(419), "Camino #420: Corunya --> Vigo (171.0)");
		assertEquals(net.findPath("Almeria", "Caceres"),"Almeria --> Granada --> Sevilla --> Huelva --> Badajoz --> Caceres (845.0)");
		assertEquals(net.findPath("Caceres", "Almeria"), "Caceres --> Badajoz --> Huelva --> Sevilla --> Granada --> Almeria (845.0)");
		assertEquals(net.findPath("Almeria", "Almeria"), "Just the same vertex...");
		assertEquals(net.findPath("Almeria", "Sinsinati"), null);
		assertEquals(net.findPath("Sinsinati", "Almeria"), null);
		assertEquals(net.findTheLargestPath(), "Lerida --> Gerona --> Barcelona --> Zaragoza --> Madrid --> Valladolid --> Corunya (1591.0)");
		assertEquals(net.findTheShortestPath(), "Caceres --> Badajoz (90.0)");
	}
}