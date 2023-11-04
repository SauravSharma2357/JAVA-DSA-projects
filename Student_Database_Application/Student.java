package Student_Database_Application;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	//Constructo: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("Enter student graduation year: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
		
		//System.out.println(firstName+" "+ lastName+" "+ gradeYear+" "+ studentID);
		
	}
	
	//Generate an ID
	private void setStudentID() {
		//Grade Level + ID
		id++;
		this.studentID = gradeYear + ""+ id;
	}
	
	//Enroll in courses
	public void enroll() {
		//GEt inside a loop, user hits 0
		do {
			System.out.print("Enter course to enroll (Q to qquit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n  " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else {break;}
		}while(1 != 0);
		//System.out.println("ENROLLED IN: " + courses);
		//System.out.println("TUITION BALANCE: " + tuitionBalance);
	}
	
	//view balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	//pay tuition
	public void payTution() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		System.out.println();
		//viewBalance();
	}
	
	//Show status
	public String showInfo() {
		return "Name: " + firstName+" "+ lastName +
				"\nGraduation Year: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
}
