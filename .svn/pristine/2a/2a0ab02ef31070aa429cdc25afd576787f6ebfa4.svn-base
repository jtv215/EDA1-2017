package org.eda1.actividad02.ejercicio02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;


public class HeapSortTestJUnit4{


	@Test
	public void testHeapSort() {
		Integer[] intArray = {59,  32,  46,  87, 44,  95,  17,  75,  40,  50};
		Comparator<Integer> comp = new Less<Integer>();
		
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		ArrayList<Integer> scores2 = new ArrayList<Integer>();
		ArrayList<Integer> scores3 = new ArrayList<Integer>();
		
		for (Integer v: intArray){
			scores1.add(v);
			scores2.add(v);
			scores3.add(v);
		}
		
		assertTrue(intArray.length == scores1.size());
		assertTrue(intArray.length == scores2.size());
		assertTrue(intArray.length == scores3.size());
		
		Collections.sort(scores3, comp);

		Sort.sortHeap(scores1, comp);

		Sort.heapSort(scores2, comp);

		assertEquals(scores1, scores2);
		assertEquals(scores1, scores3);
		assertEquals(scores2, scores3);
	}

	@Test
	public void testStabilitygHeapSort() {

		Entero[] array = new Entero[100];
		Comparator<Entero> comp = new Less<Entero>();
		Random rnd = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new Entero(rnd.nextInt(20), i);
		}

		ArrayList<Entero> scores1 = new ArrayList<Entero>();
		ArrayList<Entero> scores2 = new ArrayList<Entero>();
		
		for (Entero e: array){
			scores1.add(e);
			scores2.add(e);
		}
			
		Sort.heapSort(scores1, comp);

		Collections.sort(scores2, comp);
		
		assertFalse(scores1.equals(scores2));
	}
}

