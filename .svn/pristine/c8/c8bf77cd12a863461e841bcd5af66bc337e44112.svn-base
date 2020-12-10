package org.eda1.actividad03.edaAuxiliar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class Main {
public static void main(String[] args) {




	BSTree<Integer> treeBST = new BSTree<Integer>();
	AVLTree<Integer> treeAVL = new AVLTree<Integer>();
	RBTree<Integer> treeRB = new RBTree<Integer>();

	ArrayList<Integer> datosE = new ArrayList<Integer>();
	final int size = 100000;//10, 100,1000,100 000.
	int contHeightsBST = 0;
	int contHeightsAVL = 0;
	int contHeightsRB = 0;


		// Construimos la estructura de datos inicial...array con size elementos

	for (int i = 0; i < size; i++)
			datosE.add(i*2);

	// Barajamos la estructura de datos con el único objetivo de conseguir mayor aleatoriedad en el conjunto de datos de entrada
//primero con collection y luego sin collection
	
	//este colection hay  comentarlo
//	Collections.shuffle(datosE);

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
	System.out.println("altura media");
	System.out.println((float)contHeightsBST/size);
	System.out.println((float)contHeightsAVL/size);
	System.out.println((float)contHeightsRB/size);

	treeBST.clear();
	treeAVL.clear();
	treeRB.clear();
}
}


