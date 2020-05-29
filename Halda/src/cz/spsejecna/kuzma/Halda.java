package cz.spsejecna.kuzma;

import java.util.ArrayList;
import java.util.Iterator;

public class Halda{
	ArrayList<Integer> heap;

	public Halda() {
		super();
		this.heap = new ArrayList<>();
	}

	// used to print heap
	public void heapPrint() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.println(heap.get(i) + " ");
		}
	}

	// used to insert new value(node) to the heap
	public void insert(int insertvalue) {
		heap.add(insertvalue); // insert the element at end of heap
		sortInsert(heap.size(), heap.size() - 1);
	}

	// method that sorts position of node i
	// n is heap size
	private void sortInsert(int n, int i) {
		int parent = (i - 1) / 2; // find parent
		if (heap.get(parent) > 0) { // if parent and inserted element is smaller than parent --> swap them
			if (heap.get(i) < heap.get(parent)) {
				swap(i, parent);
				sortInsert(n, parent); // use recursion to sort parent position
			}
		}
	}

	// used to swap 2 elements
	private void swap(int i1, int i2) {
		int temp = heap.get(i1);
		heap.set(i1, heap.get(i2));
		heap.set(i2, temp);
	}

	// returns heap's min element
	public Integer min() {
		return heap.get(0);
	}

	// returns heap size
	public Integer size() {
		return heap.size();
	}

	// extracts min element from heap and returns it
	public Integer ExtractMin() {
		int smallestTemp = heap.get(0); // used to return extracted element
		int lastElementIndex = heap.size() - 1;
		heap.set(0, heap.get(lastElementIndex));
		heap.remove(lastElementIndex);
		sortDeletion(0);
		return smallestTemp;
	}

	// sort heap after extracting min element
	// index is root index of "sub-tree"
	private void sortDeletion(int index) {
		int smallestElementIndex = index;
		int rightNodeIndex = 2 * index + 2; // right node index of smallest element
		int leftNodeIndex = 2 * index + 1; // left node index of smallest element

		if (leftNodeIndex < heap.size() && heap.get(leftNodeIndex) < heap.get(smallestElementIndex)) {
			smallestElementIndex = leftNodeIndex;
		} // set smallestElement to leftNode if leftNode is smaller than smallestElement

		if (rightNodeIndex < heap.size() && heap.get(rightNodeIndex) < heap.get(smallestElementIndex)) {
			smallestElementIndex = rightNodeIndex;
		} // set smallestElement to rightNode if rightNode is smaller than smallestElement

		if (smallestElementIndex != index) { // if smallestElement isn't root of "sub-tree" swap them
			swap(index, smallestElementIndex);
			sortDeletion(smallestElementIndex); // Use recursion on next "sub-tree" with root smallestElement
		}
	}


}
