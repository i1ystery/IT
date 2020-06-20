package cz.spsejecna.kuzma;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MusicLib {
	
	static Scanner s = new Scanner(System.in);

	public static void start() throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.print("\t\t\t\tLoading");
		Thread.sleep(700);
		System.out.print("\b\b\b\b\b\b\b");
		Thread.sleep(200);
		System.out.print("-");
		Thread.sleep(100);
		System.out.print("-");
		Thread.sleep(100);
		System.out.print("-");
		Thread.sleep(100);
		System.out.print("-");
		Thread.sleep(100);
		System.out.print("-");
		Thread.sleep(100);
		System.out.print("-");
		Thread.sleep(100);
		System.out.print("-");
		Thread.sleep(200);
		System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
		menu();
	}

	private static void menu() throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Music Store Management Program");
		System.out.println("Music Store Menu");
		System.out.println("1. Buy Music.");
		System.out.println("2. Find Music.");
		System.out.println("3. Sold Items.");
		System.out.println("4. Item in Stock.");
		System.out.println("5. All Items.");
		System.out.println("6. Add New Item.");
		System.out.println("7. Edit Item.");
		System.out.println("8. Remove Item.");
		System.out.println("9. Exit.");
		System.out.print("Choose One: ");
		switch (s.nextInt()) {
		
		case 1:
			BuySong();
			break;
			
		case 2:
			FindMusic();
			break;
			
		case 3:
			SoldItems();
			break;
			
		case 4:
			ItemsInStock();
			break;
			
		case 5:
			ShowAllItems();
			break;
			
		case 6:
			AddNewItemInDatabase();
			break;
			
		case 7:
			ModifySong();
			break;
			
		case 8:
			RemoveSong();
			break;
			
		case 9:
			System.exit(0);
		default:
			System.out.println("Choose between 1 - 7.");
			menu();
		}
	}

	private static void ItemsInStock()
			throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.print("Loading");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(List.ItemsInStock());
		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void SoldItems()
			throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.print("Loading");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(List.SoldItems());
		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void BuySong()
			throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Enter name of song you want to buy");
		if (List.buySong(s.next()) == 1) {
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println("Successfully bought");
		} else {
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println("There's no songs in stock");
		}

		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void RemoveSong()
			throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		System.out.println("Enter name of song to delete");
		List.delete(s.next());
		System.out.print("Deleting");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("Successfully deleted");
		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void ModifySong()
			throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.println("Enter name of song to modify");
		List.modify(s.next());
		System.out.print("Saving");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("Song saved");
		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void FindMusic()
			throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		System.out.println("Enter name of song to search");
		Song a = List.findSong(s.next());
		System.out.print("Searching");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(a);
		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void ShowAllItems()
			throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.print("Loading");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(List.returnList());
		System.out.println("Enter any key to go back.");
		s.next();
		start();
	}

	private static void AddNewItemInDatabase()
			throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		Song s = new Song();
		s.setCategory();
		s.setType();
		s.setName();
		s.setArtist();
		s.setPrice();
		List.addToList(s);
		System.out.print("Adding");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("Song added");
		menu();
	}

}
