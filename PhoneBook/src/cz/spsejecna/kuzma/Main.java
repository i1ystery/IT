package cz.spsejecna.kuzma;

public class Main {

	public static void main(String[] args) {
		try {
			Phonebook.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
