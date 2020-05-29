package cz.spsejecna.kuzma;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable{
	static Scanner s = new Scanner(System.in);
	String name;
	String lastName;
	int age;
	int salary;
	public Employee(){
		super();
	}
	public void setName(){
		System.out.println("Enter employee's first name");
		String temp = s.next();
		if (temp.matches(".{2,}|.{2,} .{2,}")) {
			this.name = temp;
		} else {
			System.out.println("Wrong input. First name must have 2 or more letters.");
			setName();
		}
	}
	public void setLastName(){
		System.out.println("Enter employee's last name");
		String temp = s.next();
		if (temp.matches(".{2,}|.{2,} .{2,}")) {
			this.lastName = temp;
		} else {
			System.out.println("Wrong input. Last name must have 2 or more letters.");
			setLastName();
		}
	}
	public void setAge(){
		System.out.println("Enter employee's age");
		int temp = s.nextInt();
		if (temp>0) {
			this.age = temp;
		} else {
			System.out.println("Wrong input. Age must be > 0.");
			setAge();
		}
	}
	public void setSalary(){
		System.out.println("Enter employee's salary");
		int temp = s.nextInt();
		if (temp>1000) {
			this.salary = temp;
		} else {
			System.out.println("Wrong input. Salary must be > 1000.");
			setSalary();
		}
	}
	public String toString(){
		return "Name: "+name+"\tLast Name: "+lastName+"\nAge: "+age+"\tSalary: "+salary; 
	}
}
