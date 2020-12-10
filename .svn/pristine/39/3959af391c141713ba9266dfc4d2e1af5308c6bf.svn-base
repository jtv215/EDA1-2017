/*
 * @(#)BSTree.java
 */

package org.eda1.actividad03.edaAuxiliar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;

import org.eda1.actividad03.edaAuxiliar.*;

/**
 * This class implements the Collection interface using a binary search tree as
 * the underlying storage structure.
 */

public class BSTree<T extends Comparable<T>> implements Collection<T>, Iterable<T>, Cloneable {
	// reference to tree root
	// transient
	private BSTNode<T> root;

	// number of elements in the tree
	private int treeSize;

	// increases whenever the tree changes. used by an iterator
	// to verify that it is in a consistent state
	transient private int modCount;

	public BSTree(T[] arr) {
		for (T v : arr)
			this.add(v);
	}

	// private method used by remove() and the iterator
	// remove() to delete a node
	private void removeNode(BSTNode<T> dNode) {
		if (dNode == null)
			return;

		// dNode = reference to node D that is deleted
		// pNode = reference to parent P of node D
		// rNode = reference to node R that replaces D
		BSTNode<T> pNode, rNode;

		// assign pNode as a reference to P
		pNode = dNode.parent;

		// if D has a null child, the
		// replacement node is the other child
		if (dNode.left == null || dNode.right == null) {
			if (dNode.right == null)
				rNode = dNode.left;
			else
				rNode = dNode.right;

			if (rNode != null)
				// the parent of R is now the parent of D
				rNode.parent = pNode;

			// complete the link to the parent node.

			// deleting the root node. assign new root
			if (pNode == null)
				root = rNode;
			// attach R to the correct branch of P
			else if (((Comparable<T>) dNode.nodeValue).compareTo(pNode.nodeValue) < 0)
				pNode.left = rNode;
			else
				pNode.right = rNode;
		}
		// both children of dNode are non-null.
		else {
			// find and unlink replacement node for D.
			// starting at the right child of node D,
			// find the node whose value is the smallest of all
			// nodes whose values are greater than the value in D.
			// unlink the node from the tree.

			// pOfRNode is reference to parent of replacement node
			BSTNode<T> pOfRNode = dNode;

			// first possible replacement is right child of D
			rNode = dNode.right;

			// descend down left subtree of the right child of D,
			// keeping a record of current node and its parent.
			// when we stop, we have found the replacement
			while (rNode.left != null) {
				pOfRNode = rNode;
				rNode = rNode.left;
			}

			// copy the value in R to D
			dNode.nodeValue = rNode.nodeValue;

			if (pOfRNode == dNode)
				dNode.right = rNode.right;
			else
				pOfRNode.left = rNode.right;

			// the parent of the right child of R is the
			// parent of R
			if (rNode.right != null)
				rNode.right.parent = pOfRNode;

			// we want to dispose of rNode
			dNode = rNode;
		}

		// make the reference to the deleted node null
		dNode = null;
	}

	// iteratively traverse a path from the root to the node
	// whose value is item; return a reference to the node
	// containing item or null if the search fails
	private BSTNode<T> findNode(T item) {
		// t is current node in traversal
		BSTNode<T> t = root;
		int orderValue;

		// terminate on on empty subtree
		while (t != null) {
			// compare item and the current node value
			orderValue = ((Comparable<T>) item).compareTo(t.nodeValue);

			// if a match occurs, return true; otherwise, go left
			// or go right following search tree order
			if (orderValue == 0)
				return t;
			else if (orderValue < 0)
				t = t.left;
			else
				t = t.right;
		}

		return null;
	}

	// delete all the nodes in the tree with root t
	private void deleteTree(BSTNode<T> t) {
		// if current root node is not NIL, removeNode its left subtree,
		// its right subtree and then the node itself
		if (t != null) {
			deleteTree(t.left);
			deleteTree(t.right);
			t = null;
		}
	}

	/**
	 * Creates an empty binary search tree. All elements inserted into the tree
	 * must implement the <tt>Comparable</tt> interface.
	 */
	public BSTree() {
		root = null;
		modCount = 0;
		treeSize = 0;
	}

	/**
	 * Adds the specified item to this tree if it is not already present.
	 *
	 * @param item
	 *            element to be added to this tree.
	 * @return <tt>true</tt> if the tree did not already contain the specified
	 *         element.
	 */
	public boolean add(T item) {
		// t is current node in traversal, parent the previous node
		BSTNode<T> t = root, parent = null, newNode;
		int orderValue = 0;

		// terminate on on empty subtree
		while (t != null) {
			// update the parent reference.
			parent = t;

			// compare item and the current node value
			orderValue = ((Comparable<T>) item).compareTo(t.nodeValue);

			// if a match occurs, return false; otherwise, go left
			// or go right following search tree order
			if (orderValue == 0)
				return false;
			else if (orderValue < 0)
				t = t.left;
			else
				t = t.right;
		}

		// create the new node
		newNode = new BSTNode<T>(item, parent);

		if (parent == null)
			// this is the first node added. make it root
			root = newNode;
		else if (orderValue < 0)
			// attach newNode as the left child of parent
			parent.left = newNode;
		else
			// attach newNode as the right child of parent
			parent.right = newNode;

		// increment the tree size and modCount
		treeSize++;
		modCount++;

		// we added a node to the tree
		return true;
	}

	/**
	 * Removes all of the elements from this tree. The resulting tree is empty
	 * after the method executes.
	 */
	public void clear() {
		modCount++;
		treeSize = 0;
		deleteTree(root);
		root = null;
	}

	/**
	 * Returns <tt>true</tt> if this tree contains the specified element.
	 *
	 * @param item
	 *            the object to be checked for containment in this tree.
	 * @return <tt>true</tt> if this tree contains the specified element.
	 */
	public boolean contains(T item) {
		BSTNode<T> t = findNode(item);
		return (t == null) ? false : true;
	}

	/**
	 * Returns <tt>true</tt> if this tree contains no elements.
	 *
	 * @return <tt>true</tt> if this tree contains no elements.
	 */
	public boolean isEmpty() {
		return treeSize == 0;
	}

	/**
	 * Returns an iterator over the elements in this tree. The elements are
	 * returned in ascending order.
	 *
	 * @return an iterator over the elements in this tree.
	 */
	public Iterator<T> iterator() {
		return new TreeIterator();
	}

	/**
	 * Removes the specified item from this tree if it is present.
	 *
	 * @param item
	 *            object to be removed from this tree, if present.
	 * @return <tt>true</tt> if the tree contained the specified element.
	 */
	public boolean remove(T item) {
		// search tree for item
		BSTNode<T> dNode = findNode(item);

		if (dNode == null)
			return false;

		removeNode(dNode);

		treeSize--;
		modCount++;

		return true;
	}

	/**
	 * Returns the number of elements in this tree.
	 *
	 * @return the number of elements in this tree.
	 */
	public int size() {
		return treeSize;
	}

	/**
	 * Returns an array containing all of the elements in this tree. The order
	 * of elements in the array is the iterator order of elements in the tree.
	 *
	 * @return an array containing all of the elements in this tree.
	 */
	public Object[] toArray() {
		Object[] arr = new Object[treeSize];
		Iterator<T> iter = iterator();
		int i = 0;

		while (iter.hasNext()) {
			arr[i] = iter.next();
			i++;
		}

		return arr;
	}

	/**
	 * Returns a string representation of this tree. The representation is a
	 * comma separated list in iterator order enclosed in square brackets.
	 */
	public String toString() {
		int i;

		// create the return string object
		String returnStr = "[";
		Iterator<T> iter = this.iterator();

		// output values separated by commas
		for (i = 0; i < treeSize; i++) {
			returnStr += iter.next();
			if (i < treeSize - 1)
				// returnStr += ", ";
				returnStr += "\n"; // *** MIO ***
		}
		returnStr += "]";

		// return the string
		return returnStr;
	}

	/**
	 * Searches for the specified item in the tree and returns the value of the
	 * node that matches item as a key.
	 *
	 * @param item
	 *            serves as a key to locate an element in the tree..
	 * @return the value of the node that corresponds to item as a key or
	 *         <tt>null</tt> if the element is not found.
	 */
	public T find(T item) {
		BSTNode<T> t = findNode(item);
		T value = null;

		if (t != null)
			value = t.nodeValue;

		return value;
	}

	private class TreeIterator implements Iterator<T> {
		// set expectedModCount to the number of list changes
		// at the time of iterator creation
		private int expectedModCount = modCount;
		// node of the last value returned by next() if that
		// value was deleted by the iterator method remove()
		private BSTNode<T> lastReturned = null;
		// node whose value is returned a subsequent call to next()
		private BSTNode<T> nextNode = null;

		// constructor
		TreeIterator() {
			nextNode = root;

			// if the tree is not empty, the first node inorder is the farthest
			// node left from root
			if (nextNode != null)
				while (nextNode.left != null)
					nextNode = nextNode.left;
		}

		// returns true if the tree has more
		// unvisited elements
		public boolean hasNext() {
			// elements remain if nextNode is not null
			return nextNode != null;
		}

		public T current() {
			return lastReturned.nodeValue;
		}

		// returns the next element in the iteration.
		// throws NoSuchElementException if the iteration
		// has no more elements
		// public T next()
		public T next() {
			// check that the iterator is in a consistent state.
			// throws ConcurrentModificationException if it
			// it is not
			checkIteratorState();

			// check if the iteration has an another element
			// if not, throw NoSuchElementException
			if (nextNode == null)
				throw new NoSuchElementException("Iteration has no more elements");

			// save current value of next in lastReturned.
			lastReturned = nextNode;

			// set nextNode to the next node in order
			BSTNode<T> p;

			if (nextNode.right != null) {
				// successor is the furthest left node of
				// right subtree
				nextNode = nextNode.right;

				while (nextNode.left != null)
					nextNode = nextNode.left;
			} else {
				// have already processed the left subtree, and
				// there is no right subtree. move up the tree,
				// looking for a parent for which nextNode is a left child,
				// stopping if the parent becomes null. a non-null parent
				// is the successor. if parent is null, the original node
				// was the last node inorder
				p = nextNode.parent;

				while (p != null && nextNode == p.right) {
					nextNode = p;
					p = p.parent;
				}

				// if we were previously at the right-most node in
				// the tree, nextNode = null
				nextNode = p;
			}

			return lastReturned.nodeValue;
		}

		// removes the last element returned by next() from the
		// underlying collection. this method can be called only
		// once per call to next(). it is an error to modify
		// the underlying collection while the iteration is in
		// progress in any way other than by calling this method.
		// throws IllegalStateException if next() has not yet been
		// called,or remove() has already been called after the last
		// call to next()
		public void remove() {
			// check for a missing call to next() or previous()
			if (lastReturned == null)
				throw new IllegalStateException("Iterator call to next() " + "required before calling remove()");

			// make sure our state is good
			checkIteratorState();

			// if lastReturned has two children, the replacement node
			// during deletion is nextNode. the value in nextNode
			// is copied to lastReturned. nextNode must be
			// lastReturned
			if (lastReturned.left != null && lastReturned.right != null)
				nextNode = lastReturned;
			removeNode(lastReturned);

			// list has been modified
			modCount++;
			expectedModCount = modCount;

			// we did a deletion. indicate this by setting lastReturned
			// to null and decrementing treeSize
			lastReturned = null;
			treeSize--;
		}

		private void checkIteratorState() {
			if (expectedModCount != modCount)
				throw new ConcurrentModificationException("Inconsistent iterator");
		}
	}

	/**
	 * Return a copy of this <tt>STree</tt> instance.
	 */
	@SuppressWarnings("unchecked")
	public Object clone() {
		BSTree<T> copy = null;

		try {
			copy = (BSTree<T>) super.clone();
		} catch (CloneNotSupportedException cnse) {
			throw new InternalError();
		}

		copy.root = copyTree(root);
		// return the cloned object
		return copy;
	}

	/*
	 * Uses the static method copyTree() in the class BinaryTree as a model to
	 * create a duplicate of the tree with root <tt>t</tt> and returns a
	 * reference to the root of the copied tree. In this case, the elements are
	 * STNode<T> objects
	 */
	private static <T extends Comparable<T>> BSTNode<T> copyTree(BSTNode<T> t) {
		// newNode points at a new node that the algorithm
		// creates. newLptr. and newRptr point to the subtrees
		// of newNode
		BSTNode<T> newLeft, newRight, newNode;

		// stop the recursive scan when we arrive at empty tree
		if (t == null)
			return null;

		// build the new tree from the bottom up by building the two
		// subtrees and then building the parent. at node t, make
		// a copy of the left subtree and assign its root node reference
		// to newLeft. make a copy of the right subtree and assign its
		// root node reference to newRight
		newLeft = copyTree(t.left);
		newRight = copyTree(t.right);

		// create a new node whose value is the same as the value in t
		// and whose children are the copied subtrees
		newNode = new BSTNode<T>(t.nodeValue, null);
		newNode.left = newLeft;
		newNode.right = newRight;
		if (newLeft != null)
			newLeft.parent = newNode;
		if (newRight != null)
			newRight.parent = newNode;

		// return a reference to the root of the newly copied tree
		return newNode;
	}

	/**
	 * Returns a string that displays the elements in the binary tree using the
	 * preorder (NLR) scan. The description is a listing of elements separated
	 * by two blanks.
	 *
	 * @param t
	 *            a <tt>TNode</tt> that designates the root of the tree.
	 * @return string that contains the list of elements in the array.
	 */
	private static <T extends Comparable<T>> String toStringPreorder(BSTNode<T> t) {
		// return value
		String s = "";

		// the recursive scan terminates on a empty subtree
		if (t != null) {
			s += t.nodeValue + "  "; // display the node
			s += toStringPreorder(t.left); // descend left
			s += toStringPreorder(t.right); // descend right
		}

		return s;
	}

	public String toStringPreorder() {
		// return value
		String s = toStringPreorder(root);

		return s;
	}

	private static <T extends Comparable<T>> String toStringInorder(BSTNode<T> t) {
		// return value
		String s = "";

		// the recursive scan terminates on a empty subtree
		if (t != null) {
			s += toStringInorder(t.left); // descend left
			s += t.nodeValue + "  "; // display the node
			s += toStringInorder(t.right); // descend right
		}

		return s;
	}

	public String toStringInorder() {
		// return value
		String s = toStringInorder(root);

		return s;
	}

	private static <T extends Comparable<T>> String toStringPostorder(BSTNode<T> t) {
		// return value
		String s = "";

		// the recursive scan terminates on a empty subtree
		if (t != null) {
			s += toStringPostorder(t.left); // descend left
			s += toStringPostorder(t.right); // descend right
			s += t.nodeValue + "  "; // display the node
		}

		return s;
	}

	public String toStringPostorder() {
		String s = toStringPostorder(root);

		return s;
	}

	public String toStringLevel(int level) {
		return toStringLevel(root, 0, level);
	}

	private String toStringLevel(BSTNode<T> t, int currentLevel, int level) {

		if (t == null) {
			return "";

		}
		if (currentLevel == level) {
			return t.nodeValue + "  ";

		}
		return toStringLevel(t.left, currentLevel + 1, level) + toStringLevel(t.right, currentLevel + 1, level);
	}

	public static <T extends Comparable<T>> String toStringBreadthFirstTraversal(BSTNode<T> t) {
		// store siblings of each node in a queue so that they are
		// visited in order at the next level of the tree
		LinkedQueue<BSTNode<T>> q = new LinkedQueue<BSTNode<T>>();
		BSTNode<T> p;
		// return value
		String s = "";

		// initialize the queue by inserting the root in the queue
		q.push(t);

		// continue the iterative process until the queue is empty
		while (!q.isEmpty()) {
			// delete a node from queue and output the node value
			p = q.pop();
			s += p.nodeValue + "  ";

			// if a left child exists, insert it in the queue
			if (p.left != null)
				q.push(p.left);
			// if a right child exists, insert next to its sibling
			if (p.right != null)
				q.push(p.right);
		}

		return s;
	}

	public String toStringBreadthFirstTraversal() {
		// return value
		String s = toStringBreadthFirstTraversal(root);

		return s;
	}

	public static <T extends Comparable<T>> String toStringIterativePreorder(BSTNode<T> t) {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p;
		// return value
		String s = "";
		if (t != null) {
			st.push(t);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				s += p.nodeValue + "  ";
				if (p.right != null)
					st.push(p.right);
				if (p.left != null)
					st.push(p.left);
			}
		}
		return s;
	}

	public String toStringIterativePreorder() {
		// return value
		String s = toStringIterativePreorder(root);

		return s;
	}

	public static <T extends Comparable<T>> String toStringIterativeInorder(BSTNode<T> t) {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = t;
		String s = "";

		while (p != null) {
			while (p != null) {
				if (p.right != null)
					st.push(p.right);
				st.push(p);
				p = p.left;
			}
			p = st.peek();
			st.pop();

			while (!st.isEmpty() && p.right == null) {
				s += p.nodeValue + "  ";
				p = st.peek();
				st.pop();
			}
			s += p.nodeValue + "  ";
			if (!st.isEmpty()) {
				p = st.peek();
				st.pop();
			} else
				p = null;
		}
		return s;
	}

	public String toStringIterativeInorder() {
		String s = toStringIterativeInorder(root);

		return s;
	}

	public static <T extends Comparable<T>> String toStringIterativePostorder(BSTNode<T> t) {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = t;
		BSTNode<T> q = t;
		String s = "";

		while (p != null) {
			for (; (p.left != null); p = p.left)
				st.push(p);
			while ((p != null) && ((p.right == null) || (p.right == q))) {
				s += p.nodeValue + "  ";
				q = p;
				if (st.isEmpty())
					return s;
				p = st.peek();
				st.pop();
			}
			st.push(p);
			p = p.right;
		}
		return s;
	}

	public String toStringIterativePostorder() {
		String s = toStringIterativePostorder(root);

		return s;
	}

	public static <T extends Comparable<T>> String toStringIterativePreorderEasy(BSTNode<T> t) {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = t;
		String s = "";

		if (p != null) {
			st.push(p);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				if ((p.left == null) && (p.right == null))
					s += p.nodeValue + "  ";
				else {
					if (p.right != null)
						st.push(p.right);
					if (p.left != null)
						st.push(p.left);
					BSTNode<T> aux = new BSTNode<T>(p.nodeValue, null);
					st.push(aux);
				}
			}
		}
		return s;
	}

	public String toStringIterativePreorderEasy() {
		String s = toStringIterativePreorderEasy(root);

		return s;
	}

	public static <T extends Comparable<T>> String toStringIterativeInorderEasy(BSTNode<T> t) {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = t;
		String s = "";

		if (p != null) {
			st.push(p);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				if ((p.left == null) && (p.right == null))
					s += p.nodeValue + "  ";
				else {
					if (p.right != null)
						st.push(p.right);
					BSTNode<T> aux = new BSTNode<T>(p.nodeValue, null);
					st.push(aux);
					if (p.left != null)
						st.push(p.left);
				}
			}
		}
		return s;
	}

	public String toStringIterativeInorderEasy() {
		String s = toStringIterativeInorderEasy(root);

		return s;
	}

	public static <T extends Comparable<T>> String toStringIterativePostorderEasy(BSTNode<T> t) {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = t;
		String s = "";

		if (p != null) {
			st.push(p);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				if ((p.left == null) && (p.right == null))
					s += p.nodeValue + "  ";
				else {
					BSTNode<T> aux = new BSTNode<T>(p.nodeValue, null);
					st.push(aux);
					if (p.right != null)
						st.push(p.right);
					if (p.left != null)
						st.push(p.left);
				}
			}
		}
		return s;
	}

	public String toStringIterativePostorderEasy() {
		String s = toStringIterativePostorderEasy(root);

		return s;
	}

	public void addBalanced(ArrayList<T> aL) {
		Comparator<T> comp = new Less<T>();
		Collections.sort(aL, comp);
		addBalanced(aL, 0, aL.size() - 1);
	}

	private void addBalanced(ArrayList<T> aL, int left, int right) {
		if (left <= right) {
			int med = (left + right) / 2;
			add(aL.get(med));
			addBalanced(aL, left, med - 1);
			addBalanced(aL, med + 1, right);
		}
	}

	private int height(BSTNode<T> t) {
		//TODO
		if(t==null){
			return -1;
		}
		int iz=height(t.left);
		int der=height(t.right);
		int max=Math.max(iz, der);

		return 1+max;
	}

	public int height() {
		return height(root);
	}

	public int numberOfLeaves() {
		return numberOfLeaves(root);
	}

	//si no tienes hijo a la izq ni a la derecha soy noda hoja
	//devuelve el numero de hojas que tiene el arbol
	private int numberOfLeaves(BSTNode<T> t) {
		//TODO
		if(t==null){
			return 0;
		}
		if(t.left==null&& t.right==null){
		return 1;
		}

		return numberOfLeaves(t.left)+numberOfLeaves(t.right);

	}

	public T findMin() {
		if (this.root == null)
			return null;
		return findMin(root).nodeValue;
	}

	//me tengo que ir a la izquierda que es el más pequeño
	private BSTNode<T> findMin(BSTNode<T> t) {
		//TODO;
		if(t.left==null){
			return t;

		}

		return findMin(t.left);

	}

	public T findMinIterative() {
		if (this.root == null)
			return null;
		return findMinIterative(root).nodeValue;
	}

	//iterativo es que no se llama asi mismo
	//
	private BSTNode<T> findMinIterative(BSTNode<T> t) {
		//TODO
		BSTNode<T> aux=t;
		//cuando mi izquierdo sea null se para el bucle.
		while(aux.left!=null){
			aux=aux.left;
		}
		return aux;

	}

	public T findMax() {
		if (this.root == null)
			return null;
		return findMax(root).nodeValue;
	}

	private BSTNode<T> findMax(BSTNode<T> t) {
		//TODO;
				if(t.right==null){
					return t;
				}
				return findMax(t.right);
	}

	public T findMaxIterative() {
		if (this.root == null)
			return null;
		return findMaxIterative(root).nodeValue;
	}

	private BSTNode<T> findMaxIterative(BSTNode<T> t) {
		BSTNode<T> aux=t;
		//cuando mi derecho sea null se para el bucle.
		while(aux.right!=null){
			aux=aux.right;
		}
		return aux;


	}

	public T removeMin() {
		// search tree for item
		BSTNode<T> dNode = findMin(root);

		if (dNode == null)
			return null;

		T value = dNode.nodeValue;

		removeNode(dNode);

		treeSize--;
		modCount++;

		return value;
	}

	public T removeMax() {
		// search tree for item
		BSTNode<T> dNode = findMax(root);

		if (dNode == null)
			return null;

		T value = dNode.nodeValue;

		removeNode(dNode);

		treeSize--;
		modCount++;

		return value;
	}

	public T successor(T x) {
		BSTNode<T> suc = successor(x, root, null);
		if (suc == null) {
			System.out.println("Elemento " + x + " no encontrado");
			return null;
		} else
			return suc.nodeValue;
	}

	private BSTNode<T> successor(T x, BSTNode<T> curr, BSTNode<T> ascRight) {
		if (curr == null)
			return null;
		int comp = ((Comparable<T>) curr.nodeValue).compareTo(x);
		if (comp == 0) {
			if (curr.right != null)
				return findMin(curr.right);
			else
				return ascRight;
		} else if (comp < 0)
			return successor(x, curr.right, ascRight);
		else
			return successor(x, curr.left, curr);
	}

	public T predecessor(T x) {
		BSTNode<T> pre = predecessor(x, root, null);
		if (pre == null) {
			System.out.println("Elemento " + x + " no encontrado");
			return null;
		} else
			return pre.nodeValue;
	}

	private BSTNode<T> predecessor(T x, BSTNode<T> curr, BSTNode<T> ascLeft) {
		if (curr == null)
			return null;
		int comp = ((Comparable<T>) curr.nodeValue).compareTo(x);
		if (comp == 0) {
			if (curr.left != null)
				return findMax(curr.left);
			else
				return ascLeft;
		} else if (comp < 0)
			return predecessor(x, curr.right, ascLeft);
		else
			return predecessor(x, curr.left, curr);
	}

	//Si pasas un elemento el tamaño del camino.
	//si no esta el elemento devuelveme un -1.
	public int pathHeight(T item) {
		//TODO pathHeight
		BSTNode<T>aux = root;
		int level =0;
		while (aux!=null) {
			if(aux.nodeValue.equals(item)){
				return level;
			}if(item.compareTo(aux.nodeValue)>0){
				aux=aux.right;
			}else{
				aux= aux.left;
			}
			level++;
		}
		return -1;
	}

	private static <T extends Comparable<T>> String displayTree(BSTNode<T> t, int level) {
		String s = "";

		// the recursive scan terminates on a empty subtree
		if (t != null) {
			if (t.right != null)
				s += displayTree(t.right, level + 1);
			for (int i = 0; i < level; i++)
				s += "     ";
			s += "(" + t.nodeValue.toString() + ")[" + level + "]\n";
			if (t.left != null)
				s += displayTree(t.left, level + 1);
		}

		return s;
	}

	public String displayTree() {

		String s = displayTree(root, 0);

		return s;
	}

	// declares a binary search tree node object
	private static class BSTNode<T extends Comparable<T>> implements Comparable<BSTNode<T>> {
		// STNode is used to implement the binary search tree class
		// making the data public simplifies building the class functions

		// node data
		T nodeValue;

		// child links and link to the node's parent
		BSTNode<T> left, right, parent;

		// constructor that initializes the value and parent fields and sets
		// the link fields left and right to null
		public BSTNode(T item, BSTNode<T> parentNode) {
			nodeValue = item;
			left = null;
			right = null;
			parent = parentNode;
		}

		@Override
		public int compareTo(BSTNode<T> o) {
			return this.nodeValue.compareTo(o.nodeValue);
		}

	}

}
