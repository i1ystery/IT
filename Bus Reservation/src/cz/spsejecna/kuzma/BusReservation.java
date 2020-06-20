package cz.spsejecna.kuzma;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusReservation extends Bus {
	Scanner s = new Scanner(System.in);

	public BusReservation() {
	}

	public void start() throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.print("Loading");
		Thread.sleep(300);
		System.out.print(".");
		Thread.sleep(300);
		System.out.print(".");
		Thread.sleep(300);
		System.out.print(".");
		Thread.sleep(300);
		System.out.print("\b\b\b\b\b\b\b\b\b\b");
		menu();
	}

	private void menu() throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t\t**********Bus Reservation*************");
		Thread.sleep(1000);
		System.out.println(
				"\t\t 1.Install   \t 2.Reservation    3.Show reservation info  \n\t\t 4.Available Buses \t5.Exit\n");
		System.out.print("\t\tEnter your choice -> ");
		switch (s.next()) {
		
		case "1":
			install();
			break;
			
		case "2":
			reservation();
			break;
			
		case "3":
			showreserve();
			break;
			
		case "4":
			availableBuses();
			break;
			
		case "5":
			System.exit(0);
		default:
			System.out.println("\t\t\t Enter 1 to 5 only\nEnter any key\n");
			s.next();

			menu();
		}
	}

	private void availableBuses()
			throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.println(BusesList.returnBusList());
		System.out.print("\t\tEnter any key -> ");
		s.next();
		menu();
	}

	private void showreserve() throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.println(BusesList.returnBusList());
		ArrayList<Bus> temp = BusesList.returnList();
		System.out.println("\t\tChoose the bus if available.");
		System.out.print("\t\tEnter bus no. -> ");
		int choice = s.nextInt();
		
		for (Bus b : temp) {
			if (choice == b.no) {
				b.returnSeats();
			}
		}
		System.out.print("\t\tEnter any key -> ");
		s.next();
		menu();

	}

	private void reservation() throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.println(BusesList.returnBusList());
		ArrayList<Bus> temp = BusesList.returnList();
		System.out.println("\t\tChoose the bus if available.");
		System.out.print("\t\tEnter bus no. -> ");
		int choice = s.nextInt();
		
		for (Bus b : temp) {
			if (choice == b.no) {
				b.chooseSeat();
				BusesList.saveToList(b);
			} else {
				System.out.println("\t\tBus with this no. not found.");
			}
		}
		System.out.print("\t\tEnter any key -> ");
		s.next();
		menu();
	}

	private void install() throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		Bus b = new Bus();
		b.newBus();
		Thread.sleep(300);
		BusesList.saveToList(b);
		System.out.print("\t\tSaving");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("\t\tSaved");
		menu();
	}

}
