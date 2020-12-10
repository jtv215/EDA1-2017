package org.eda1.actividad02.ejercicio01;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class HeapTestJUnit4 {
	private Integer [] array = {17, 30, 15, 12, 9, 2, 8, 20, 7, 6, 5, 3}; 
	@Test
	public void testComparator() {
		LessComparator<Integer> less = new LessComparator<Integer>();
		GreaterComparator<Integer> greater = new GreaterComparator<Integer>();
	
		Integer[] arrayL = array.clone();
		Integer[] arrayG = array.clone();
		
		Arrays.sort(arrayL, less);
		Arrays.sort(arrayG, greater);

		assertEquals(Arrays.toString(arrayL), "[2, 3, 5, 6, 7, 8, 9, 12, 15, 17, 20, 30]");
		assertEquals(Arrays.toString(arrayG), "[30, 20, 17, 15, 12, 9, 8, 7, 6, 5, 3, 2]");
	}
	
	@Test
	public void testMakeHeapL(){
		LessComparator<Integer> less = new LessComparator<Integer>();
	
		Heap<Integer> heapLess = new Heap<Integer>(array, less);
    	
    	assertTrue(heapLess.isHeap() == false);
    	
    	
	 	heapLess.makeHeap();
    	assertTrue(heapLess.isHeap() == true);

    
    	heapLess.add(21);
    	heapLess.add(1);
    	heapLess.add(45);
    	heapLess.add(4);

    	assertTrue(heapLess.isHeap());
    	
    	assertEquals(heapLess.toString(), "[1, 4, 2, 5, 6, 15, 3, 7, 12, 30, 9, 17, 21, 8, 45, 20]");
	}
	
	@Test
	public void testMakeHeapG(){
		GreaterComparator<Integer> greater = new GreaterComparator<Integer>();
	
		Heap<Integer> heapGreater = new Heap<Integer>(array, greater);
    	
    	assertTrue(heapGreater.isHeap() == false);
    	
    	
	 	heapGreater.makeHeap();
    	assertTrue(heapGreater.isHeap() == true);

    	assertEquals(heapGreater.toString(), "[30, 20, 15, 17, 9, 3, 8, 12, 7, 6, 5, 2]");
	}
	
	@Test 
	public void textExtra(){ 
		Heap<Integer> heap = new Heap<Integer>(array, null);
		heap.makeHeap();
		
    	assertTrue(heap.getMin() == 2);
    	
    	String heapStr = heap.toString();
    	heap.add(heap.removeMin());
    
    	assertFalse(heapStr.equals(heap.toString()));
  
    	heap.replaceKey(1, new Integer(22));
    	assertTrue(heap.isHeap() == true);
    	
    	heap.removeMin();
    	heap.removeMin();
    	assertTrue(heap.isHeap() == true);
    	assertTrue(heap.size() == 10);
    	
    	heap.replaceKey(0, new Integer(11));
    	assertTrue(heap.isHeap() == true);
    	assertTrue(heap.getMin() == 7);
    	
    	System.out.println(heap.branchMinSum());
    	assertEquals(heap.branchMinSum(), "<30> --- 15 8 7 ");
	}

}
