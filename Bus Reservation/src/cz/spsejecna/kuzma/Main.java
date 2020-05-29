package cz.spsejecna.kuzma;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BusReservation b = new BusReservation();
		try {
			b.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
