package cz.spsejecna.kuzma;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeList {
	static HashSet<Employee> EmployeeList;
	static Path path = Paths.get("EmployeeList.dat");
	public static void addToList(Employee e) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			EmployeeList = deserialize(path);
			EmployeeList.add(e);
			serialize(EmployeeList);
		} catch (FileNotFoundException d) {
			serialize(new HashSet<Employee>());
			addToList(e);
		}
	}

	public static String returnEmployeeList() throws FileNotFoundException, ClassNotFoundException, IOException {
		String a = "";
		try {
			EmployeeList = deserialize(path);
			for (Employee e : EmployeeList) {
				a += e + "\n";
			}
		} catch (FileNotFoundException e) {
			return "Employee list is empty";
		}
		return a;
	}

	private static void serialize(HashSet<Employee> list) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()));
		oos.writeObject(list);
		oos.close();
	}

	private static HashSet<Employee> deserialize(Path path)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()));
		HashSet<Employee> tempList = (HashSet<Employee>) ois.readObject();
		ois.close();
		return tempList;
	}

	public static void removeEmployee(String next) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		try {
			EmployeeList = deserialize(path);
			for (Employee e : EmployeeList) {
				if (next.equalsIgnoreCase(e.name)) {
					EmployeeList.remove(e);
					serialize(EmployeeList);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Employee list is empty");
		}
	}

	public static void modifyEmployee(String employeeName)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		EmployeeList = deserialize(path);
		for (Employee e : EmployeeList) {
			if (employeeName.equalsIgnoreCase(e.name)) {
				e.setName();
				e.setLastName();
				e.setAge();
				e.setSalary();
				serialize(EmployeeList);
			}
		}
	}

	public static void returnEmployeeByParameter(String parameter){
		Scanner s = new Scanner(System.in);
		switch(parameter){
		case "Salary":
			System.out.println("Employee with highest salary: ");
			for(Employee e : EmployeeList){
				if(e.salary==findSalary(0)){
					System.out.println(e);
				}
			}
			break;
			
		case "Oldest":
			System.out.println("Oldest employee is: ");
			for(Employee e : EmployeeList){
				if(e.age==findOldest(0)){
					System.out.println(e);
				}
			}
			break;
			
		case "Youngest":
			System.out.println("Youngest employee is: ");
			for(Employee e : EmployeeList){
				if(e.age==findYoungest(99999999)){
					System.out.println(e);
				}
			}
			break;

		case "LastName":
			System.out.println("Enter last name: ");
			findByLastName(s.next());
			break;
		}
	}
	private static Integer findSalary(int a){
		for(Employee e : EmployeeList){
			if(e.salary>a){
				a=e.salary;
			}
		}
		return a;
	}
	private static Integer findOldest(int a){
		for(Employee e : EmployeeList){
			if(e.age>a){
				a=e.age;
			}
		}
		return a;
	}
	private static Integer findYoungest(int a){
		for(Employee e : EmployeeList){
			if(e.age<a){
				a=e.age;
			}
		}
		return a;
	}
	private static void findByLastName(String lastName){
		for(Employee e : EmployeeList){
			if(e.lastName.equalsIgnoreCase(lastName)){
				System.out.println(e);
			}
		}
	}
}
