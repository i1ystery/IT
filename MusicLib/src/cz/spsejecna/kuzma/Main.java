package cz.spsejecna.kuzma;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		try {
			MusicLib.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
