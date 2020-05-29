package cz.spsejecna.kuzma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus implements Serializable {
	static Scanner s = new Scanner(System.in);
	int no;
	String drName;
	String arrTime;
	String depTime;
	String from;
	String to;
	int emptySeatsCount = 6;
	ArrayList<String> seats = new ArrayList<String>();

	public Bus() {
		for (int i = 0; i < 6; i++) {
			seats.add("Empty");
		}
	}

	public void newBus() throws InterruptedException {
		System.out.print("\t\tEnter bus no: ");
		this.no = s.nextInt();
		Thread.sleep(300);
		System.out.print("\t\tEnter Driver's name: ");
		this.drName = s.next();
		Thread.sleep(300);
		System.out.print("\t\tArrival Time: ");
		this.arrTime = s.next();
		Thread.sleep(300);
		System.out.print("\t\tDeparture: ");
		this.depTime = s.next();
		Thread.sleep(300);
		System.out.print("\t\tFrom: ");
		this.from = s.nextLine();
		Thread.sleep(300);
		System.out.print("\t\tTo: ");
		this.to = s.next();
		Thread.sleep(300);
	}

	public void returnSeats() {
		System.out.println("\t\tSeats: ");
		System.out.print("\t\t");
		int a = 0;
		for (String s : seats) {
			System.out.print(++a + ". " + s + "\t");
		}
		System.out.println();
	}

	public void chooseSeat() throws InterruptedException {
		returnSeats();
		System.out.print("\t\tChoose seat: ");
		String name;
		switch (s.nextInt()) {
		case 1:
			System.out.print("\t\tEnter your name:");
			name = s.next();
			if (seats.get(0).equalsIgnoreCase("Empty")) {
				seats.set(0, name);
				emptySeatsCount--;
			}
			break;
		case 2:
			System.out.print("\t\tEnter your name:");
			name = s.next();
			if (seats.get(1).equalsIgnoreCase("Empty")) {
				seats.set(1, name);
				emptySeatsCount--;
			}
			break;
		case 3:
			System.out.print("\t\tEnter your name:");
			name = s.next();
			if (seats.get(2).equalsIgnoreCase("Empty")) {
				seats.set(2, name);
				emptySeatsCount--;
			}
			break;
		case 4:
			System.out.print("\t\tEnter your name:");
			name = s.next();
			if (seats.get(3).equalsIgnoreCase("Empty")) {
				seats.set(3, name);
				emptySeatsCount--;
			}
			break;
		case 5:
			System.out.print("\t\tEnter your name:");
			name = s.next();
			if (seats.get(4).equalsIgnoreCase("Empty")) {
				seats.set(4, name);
				emptySeatsCount--;
			}
			break;
		case 6:
			System.out.print("\t\tEnter your name:");
			name = s.next();
			if (seats.get(5).equalsIgnoreCase("Empty")) {
				seats.set(5, name);
				emptySeatsCount--;
			}
			break;
		default:
			System.out.println("\t\tYou should choose empty seat.");
			Thread.sleep(350);
		}
	}

	public String toString() {
		return "\n\t\tBus no.: " + no + "\tDriver's name: " + drName + "\n\t\tArrival time: " + arrTime
				+ "\tDeparture time: " + depTime + "\n\t\tFrom: " + from + "\tTo: " + to;
	}

}