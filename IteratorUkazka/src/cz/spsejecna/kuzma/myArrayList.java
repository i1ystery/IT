package cz.spsejecna.kuzma;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myArrayList<T> implements Iterable<T> {
	
	ArrayList<T> myArray = new ArrayList<>();
	public void add(T value){
		myArray.add(value);
	}
	
	public Iterator<T> iterator() {
		return new myIterator<T>(myArray);
	}
	/* tato trida reprezentuje iterator, 
	* ktery se pouziva v tride myArrayList pri implementovani Iterable */
	public class myIterator<E> implements Iterator<E> { 
		
		int position = 0; 
		List<E> tempList;
		
		public myIterator(List<E> myList) {
			this.tempList = myList;
		}

		/*metoda, ktera kontroluje, zda v poli je nasledujici prvek */
		public boolean hasNext() {
			if(tempList.size()>=position+1){
				return true;
			}
			return false;
		}

		/*metoda, ktera vypisuje nasledujici prvek v poli myArray. 
		 * Da se menit aby se tam treba vypisoval ne dalsi prvek, 
		 * ale bude preskakovat 1 a vypisovat ten nasledujici */
		public E next() { 	
			E value = tempList.get(position);
			position+=2;
			return value;
		}
		
	}
}
