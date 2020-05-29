package cz.spsejecna.kuzma;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Employees {
	static Scanner s = new Scanner(System.in);

	public static void start() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		System.out.println("Employee System");
		Thread.sleep(1000);
		System.out.println("MENU");
		Thread.sleep(1000);
		System.out.println("1. Add New Employee");
		Thread.sleep(200);
		System.out.println("2. Show All Employees");
		Thread.sleep(200);
		System.out.println("3. Show Employee By");
		Thread.sleep(200);
		System.out.println("4. Modify Employee salary");
		Thread.sleep(200);
		System.out.println("5. Remove Employee");
		Thread.sleep(200);
		System.out.println("6. Exit");
		System.out.println("Choose one option -> ");
		switch(s.nextInt()){
		case 1:
			addEmployee();
			break;
			
		case 2:
			employeeList();
			break;
			
		case 3:
			employeeByParameter();
			break;
			
		case 4:
			modifyEmployee();
			break;
			
		case 5:
			removeEmployee();
			break;
			
		case 6:
			System.exit(0);
			
		default:
			System.out.println("Choose from 1 - 6.");
			
			menu();
		}

	}

	private static void removeEmployee() throws ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Enter employee's last name: ");
		EmployeeList.removeEmployee(s.next());
		Thread.sleep(500);
		System.out.println("Removed");
		System.out.println("Press any key. ");
		s.next();
		menu();
	}

	private static void modifyEmployee() throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Enter employee's last name: ");
		EmployeeList.modifyEmployee(s.next());
		Thread.sleep(500);
		System.out.println("Modified");
		System.out.println("Press any key. ");
		s.next();
		menu();
	}

	private static void employeeByParameter() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Choose a parameter:\nSalary\tOldest\nLast Name\tYoungest");
		EmployeeList.returnEmployeeByParameter(s.next());
		System.out.println("Press any key. ");
		s.next();
		menu();
	}

	private static void employeeList() throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(EmployeeList.returnEmployeeList());
		System.out.println("Press any key. ");
		s.next();
		menu();
	}

	private static void addEmployee() throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setName();
		e.setLastName();
		e.setAge();
		e.setSalary();
		EmployeeList.addToList(e);
		System.out.print("\t\t\t\t Saving");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("\t\t\t\t Employee added");
		menu();
	}

}
