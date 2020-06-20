package cz.spsejecna.kuzma;

public class Main {

	public static void main(String[] args) {
		
		BusReservation b = new BusReservation();
		
		try {
			b.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
