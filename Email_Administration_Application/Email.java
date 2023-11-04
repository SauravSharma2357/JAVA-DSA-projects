package Email_Administration_Application;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private int defaultpasswordLength = 10;
	private String department;
	private String email;
	private String alternateemail;
	private int mailboxCapacity = 500;
	private String companySuffix = "companyname.com";
	
	// constructor to receive the first name and last name
	public Email(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		//System.out.println("EMAIL CREATED: " + this.firstname +" "+ this.lastname);
		
		//Call a method asking for the department - return the department
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		//Call a method that returns a random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your password is:" + this.password);
		
		//Combine elements to generate email
		email = firstname.toLowerCase() +""+ lastname.toLowerCase() + "@" + department+"."+ companySuffix;
		//System.out.println("Your email is: " + email);
	}
	// Ask for the department
	private String setDepartment() {
		System.out.print("New worker: " + firstname + "\nENTER Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for Other\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) { return "sales"; }
		else if(depChoice == 2) { return "dev";}
		else if(depChoice == 3) { return "acct";}
		else { return "";}
	}
	
	// generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// set the alternate email
	public void setAltrenateEmail(String altEmail) {
		this.alternateemail = altEmail;
	}
	
	// change the password
	public void changePassord(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateemail; }
	public String getPassword() { return password; }
	
	public String showinfo() {
		return "DISPLAY NAME: " + firstname +""+ lastname +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
