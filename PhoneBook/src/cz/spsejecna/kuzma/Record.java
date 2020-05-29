package cz.spsejecna.kuzma;

import java.io.Serializable;
import java.util.Scanner;

public class Record implements Serializable {
	String recordName;
	String address;
	String fatherName;
	String motherName;
	String phoneNo;
	char sex;
	String email;
	Integer citizenNo;
	transient Scanner s = new Scanner(System.in);

	public Record() {
		super();
	}

	@Override
	public String toString() {
		return "\nName:" + recordName + "\naddress:" + address + "\nFather name:" + fatherName + "\nMother name:"
				+ motherName + "\nMobile no:" + phoneNo + "\nsex:" + sex + "\nE-mail:" + email + "\nCitision no:"
				+ citizenNo;
	}

	public void setRecordName() {
		// TODO Auto-generated method stub
		System.out.println("Enter record name");
		String temp = s.next();
		if (temp.matches(".{2,}|.{2,} .{2,}")) {
			this.recordName = temp;
		} else {
			System.out.println("Wrong input. Name must have 2 or more letters.");
			setRecordName();
		}
	}

	public void setAddress() {
		// TODO Auto-generated method stub
		System.out.println("Enter address");
		String temp = s.next();
		if (temp.matches(".{4,}")) {
			this.address = temp;
		} else {
			System.out.println("Wrong input. Address should contain 4 or more characters.");
			setAddress();
		}
	}

	public void setFatherName() {
		// TODO Auto-generated method stub
		System.out.println("Enter father name");
		String temp = s.next();
		if (temp.matches(".{2,}|.{2,} .{2,}")) {
			this.fatherName = temp;
		} else {
			if (temp.matches("1")) {
				this.fatherName = "Undefined";
			} else {
				System.out.println("Wrong input. Name must have 2 or more letters. If there's no father enter 1.");
				setFatherName();
			}
		}
	}

	public void setMotherName() {
		// TODO Auto-generated method stub
		System.out.println("Enter mother name");
		String temp = s.next();
		if (temp.matches(".{2,}|.{2,} .{2,}")) {
			this.motherName = temp;
		} else {
			if (temp.matches("1")) {
				this.motherName = "Undefined";
			} else {
				System.out.println("Wrong input. Name must have 2 or more letters. If there's no mother enter 1.");
				setMotherName();
			}
		}
	}

	public void setPhoneNo() {
		// TODO Auto-generated method stub
		System.out.println("Enter phone no.(only numbers!)");
		String temp = s.next();
		if (temp.matches("(\\+{0,1}[0-9]{3}[0-9]{9})|([0-9]{9})")) {
			this.phoneNo = temp;
		} else {
			System.out.println("Wrong input. Phone no. should be in these formats\n+xxxxxxxxxxxx\nxxxxxxxxx");
			setPhoneNo();
		}
	}

	public void setSex() {
		// TODO Auto-generated method stub
		System.out.println("Enter sex");
		char temp = s.next().charAt(0);
		if (Character.toString(temp).matches("[M,m,F,f]")) {
			this.sex = Character.toUpperCase(temp);
		} else {
			System.out.println("Wrong input. Sex should contain 1 character. M or F");
			setSex();
		}
	}

	public void setEmail() {
		// TODO Auto-generated method stub
		System.out.println("Enter email");
		String temp = s.next();
		if (temp.matches(".*@.*")) {
			this.email = temp;
		} else {
			System.out.println("Wrong input. Email should contain @");
			setEmail();
		}
	}

	public void setCitizenNo() {
		// TODO Auto-generated method stub
		System.out.println("Enter citizen no.(only numbers!)");
		String temp = s.next();
		if (temp.matches("[0-9]{7,}")) {
			this.citizenNo = Integer.parseInt(temp);
		} else {
			System.out.println("Wrong input. Citizen no. must contain 7 or more numbers.");
			setCitizenNo();
		}
	}

}
