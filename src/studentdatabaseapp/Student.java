package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = null;
	private int tuitionBalance = 0;
	private int costOfCourse = 600;
	private static int id = 1000;
	
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the student's first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter the student's last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - for Freshmen\n2- for Sophmore\n3 - for Junior\n4 - for Senior\nEnter student class level:  ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
		
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
		
	}
	
	private void setStudentID() {
		// Grade Level + The Static Variable var
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	public void enroll() {
		// Get inside a loop, user hits 0 when they are done enrolling
		do {
			System.out.print("Enter a course to enrol (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else { break; }
		} while (1 != 0);
		System.out.println("ENROLLED IN: " + this.courses);
		System.out.println("TUITION BALANCE: " + this.tuitionBalance);
		
	}
	
	public void viewBalance() {
		System.out.println("Your balance is: " + this.tuitionBalance);
	}
	
	public void payTuition() {
		viewBalance();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter amount of payment: $");
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of " + payment);
		viewBalance();
	}
	
	public String toString() {
		return this.lastName + " " + this.studentID;
	}

}
