package org.eda1.actividad03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.eda1.actividad03.edaAuxiliar.AVLTree;
import org.eda1.actividad03.edaAuxiliar.BSTree;
import org.eda1.actividad03.edaAuxiliar.RBTree;
import org.junit.Test;

public class TreeTestJUnit4 {

	Integer[] arr = {120, 87, 43, 65, 140, 99, 17, 130, 22, 150, 56, 100, 125, 145, 135};

	@Test
	public void testHeight() {
		BSTree<Integer> tree = new BSTree<Integer>(arr);
		assertTrue(tree.size() == 15);
		assertTrue(tree.contains(140));
		assertFalse(tree.contains(1));
		assertTrue(tree.find(140).equals(new Integer(140)));
		assertNull(tree.find(1));
		assertTrue(tree.height()==4);
		tree.clear();
		assertTrue(tree.height()==-1);
	}
	
	@Test
	public void testNumberOfLeaves(){
		BSTree<Integer> tree = new BSTree<Integer>(arr);
		assertTrue(tree.numberOfLeaves()==6);
		tree.add(200);
		tree.add(10);
		assertTrue(tree.numberOfLeaves()==8);
		tree.clear();
		assertTrue(tree.numberOfLeaves()==0);
	}
	
	@Test
	public void testFindMinMaxIR(){
		BSTree<Integer> tree = new BSTree<Integer>(arr);
		assertTrue(tree.findMin() == 17);
		assertEquals(tree.findMin(),tree.findMinIterative());
		assertTrue(tree.findMax() == 150);
		assertEquals(tree.findMax(), tree.findMaxIterative());
		tree.clear();
		assertTrue(tree.findMin()==null);
		assertTrue(tree.findMinIterative() == tree.findMaxIterative());
	}
	
	@Test
	public void toStringLevel(){
		BSTree<Integer> tree = new BSTree<Integer>(arr);
		assertEquals(tree.toStringLevel(0), "120  ");
		assertEquals(tree.toStringInorder(),"17  22  43  56  65  87  99  100  120  125  130  135  140  145  150  ");
		assertEquals(tree.toStringLevel(3), "17  65  100  125  135  145  ");
		tree.clear();
		assertEquals(tree.toStringLevel(3), "");
	}
	
	@Test
	public void testPathHeight(){
		BSTree<Integer> tree = new BSTree<Integer>(arr);
		assertTrue(tree.pathHeight(0)==-1);
		assertTrue(tree.pathHeight(100)==3);
		tree.clear();
		assertTrue(tree.pathHeight(100) == -1);
	}


	@Test
	public void testpathHeightAllTrees() {

		BSTree<Integer> treeBST = new BSTree<Integer>();
		AVLTree<Integer> treeAVL = new AVLTree<Integer>();
		RBTree<Integer> treeRB = new RBTree<Integer>();
		
		ArrayList<Integer> datosE = new ArrayList<Integer>();
		final int size = 100000;
		int contHeightsBST = 0;
		int contHeightsAVL = 0;
		int contHeightsRB = 0;
		

  		// Construimos la estructura de datos inicial...array con size elementos 
		
		for (int i = 0; i < size; i++)
 			datosE.add(i*2);
		
		// Barajamos la estructura de datos con el único objetivo de conseguir mayor aleatoriedad en el conjunto de datos de entrada
		
		Collections.shuffle(datosE);
		
		// Insertamos los elementos en las estructuras de datos arborescentes
		for (Integer x : datosE){
			treeBST.add(x);
			treeAVL.add(x);
			treeRB.add(x);
		}
		
		//calculamos la altura de cada uno de los elementos del array en cada tipo de arbol. Idea --> calcular la altura media de sus elementos y comparar
		
		for (int i=0; i<size; i++){
			contHeightsBST += treeBST.pathHeight(datosE.get(i));
			contHeightsAVL += treeAVL.pathHeight(datosE.get(i));
			contHeightsRB  += treeRB.pathHeight(datosE.get(i));
		}
		
		System.out.println(treeBST.height());
		System.out.println(treeAVL.height());
		System.out.println(treeRB.height());
		System.out.println((float)contHeightsBST/size);
		System.out.println((float)contHeightsAVL/size);
		System.out.println((float)contHeightsRB/size);

		treeBST.clear();
		treeAVL.clear();
		treeRB.clear();
	}
}
