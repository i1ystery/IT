package cz.spsejecna.kuzma;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Halda h = new Halda();
		h.insert(5);
		h.insert(-1);
		h.insert(3);
		h.insert(7);
		h.insert(-1);
		h.insert(4);
		h.insert(4);
		h.heapPrint();
		System.out.println("Extracted " + h.ExtractMin());
		System.out.println("Min " + h.min());
		System.out.println("Size " + h.size());
		h.heapPrint();
	}

}
