package cz.spsejecna.kuzma;

import java.io.Serializable;
import java.util.Scanner;

public class Song implements Serializable {
	static Scanner s = new Scanner(System.in);
	private int tempID = 0;
	int ID;
	String category;
	String type;
	String name;
	String artist;
	int price;
	int quantity;

	public void setCategory() {
		System.out.print("Enter song category: ");
		category = s.nextLine();
	}

	public void setType() {
		System.out.print("Enter song type: ");
		type = s.nextLine();
	}

	public void setName() {
		System.out.print("Enter song name: ");
		name = s.nextLine();
	}

	public void setArtist() {
		System.out.print("Enter song artist: ");
		artist = s.nextLine();
	}

	public void setPrice() {
		System.out.print("Enter song price: ");
		price = s.nextInt();
	}

	public void setQuantity() {
		System.out.print("Enter song quantity: ");
		quantity = s.nextInt();
	}

	public Song() {
		super();
		ID = tempID++;
		quantity = 1;
	}

	public String toString() {
		return "\nCategory:" + category + "\nType:" + type + "\nName:" + name + "\nArtist:" + artist + "\nPrice:"
				+ price + "\nQuantity:" + quantity;
	}
}
