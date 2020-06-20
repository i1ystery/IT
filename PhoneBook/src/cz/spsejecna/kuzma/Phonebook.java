package cz.spsejecna.kuzma;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Phonebook {
	static Scanner s = new Scanner(System.in);

	public static void start() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
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

	public static void back() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		start();
	}

	private static void menu() throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("\t\t**********WELCOME TO PHONEBOOK*************");
		Thread.sleep(1000);
		System.out.println("\t\t\t\t MENU\t\t");
		Thread.sleep(1000);
		System.out.println("\t\t 1.Add New   \t 2.List   \t 3.Exit  \n\t\t 4.Modify \t 5.Search\t 6.Delete\n");
		switch (s.next()) {
		
		case "1":
			addRecord();
			break;
			
		case "2":
			listRecord();
			break;
			
		case "3":
			System.exit(0);
			break;
			
		case "4":
			modifyRecord();
			break;
			
		case "5":
			searchRecord();
			break;
			
		case "6":
			deleteRecord();
			break;
			
		default:
			System.out.println("\t\t\t Enter 1 to 6 only\nEnter any key\n");
			s.next();

			menu();
		}
	}

	private static void deleteRecord()
			throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		System.out.println("\t\t Enter name of person to delete");
		SavedList.delete(s.next());
		System.out.print("\t\t\t\t Deleting");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("\t\t\t Successfully deleted");
		System.out.println("\t\t Enter any key to go back.");
		s.next();
		back();
	}

	private static void modifyRecord()
			throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.println("\t\t Enter name of person to modify");
		SavedList.modify(s.next());
		System.out.print("\t\t\t\t Saving");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("\t\t\t\t Record saved");
		System.out.println("\t\t Enter any key to go back.");
		s.next();
		back();
	}

	private static void searchRecord()
			throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		System.out.println("\t\t Enter name of person to search");
		Record r = SavedList.findRecord(s.next());
		System.out.print("\t\t\t\t Searching");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(r);
		System.out.println("\t\t Enter any key to go back.");
		s.next();
		back();
	}

	private static void listRecord()
			throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		System.out.print("\t\t\t\t Loading");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(SavedList.returnList());
		System.out.println("\t\t Enter any key to go back.");
		s.next();
		back();
	}

	private static void addRecord()
			throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {
		Record r = new Record();
		r.setRecordName();
		r.setAddress();
		r.setFatherName();
		r.setMotherName();
		r.setPhoneNo();
		r.setSex();
		r.setEmail();
		r.setCitizenNo();
		SavedList.saveToList(r);
		System.out.print("\t\t\t\t Saving");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("\t\t\t\t Record saved");
		menu();
	}

}
