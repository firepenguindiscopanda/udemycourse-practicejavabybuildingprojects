package emailapp;

import java.util.Scanner;

public class Email {
	
	// We will encapsulate employee data by making class/object variables private 
	// Hiding things/data within an object (encapsulation) is best practice in SWE
	
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "eycompany.com";
	
	// Constructor to receive first and last name from user
	public Email (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking employee/user for their department - return the department
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is : " + this.password);
		
		// Combine elements to generate a new email for the given employee
		email = firstName.toLowerCase() + "."+ lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1) { return "sales"; } 
		else if (deptChoice == 2) { return "dev"; } 
		else if (deptChoice == 3) { return "acct";}
		else { return ""; }
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set mailbox custom new mailbox capacity
	public void setMailboxCapacity(int newCapacity) {
		this.mailBoxCapacity = newCapacity;
	}
	
	// Set an alternate email
	public void setAlternateEmail(String newEmail) {
		this.alternateEmail = newEmail;
	}
	
	// Change the password
	public void changePassword(String newPass) {
		this.password = newPass;
	}
	
	public int getMailboxCapacity() { return this.mailBoxCapacity; }
	public String getAlternateEmail() { return this.alternateEmail; }
	public String getPassword() { return this.password; }
	
	public String showInfo() {
		return "DISPLAY NAME : " + this.firstName + " " + this.lastName + 
				"\nCOMPANY EMAIL : " + this.email +
				"\nMAILBOX CAPACITY : " + this.mailBoxCapacity + "mb";
	}
	
	
}
