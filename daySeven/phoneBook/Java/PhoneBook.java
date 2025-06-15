// PhoneBook.java

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
static Scanner input = new Scanner(System.in);
    static ArrayList<PhoneBook> numbers = new ArrayList<>();

	String firstName;
	String lastName;
	int phoneNumber;
	
	public PhoneBook(String firstName, String lastName, int phoneNumber) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	}



		
	public static void addContact() {
	System.out.println("Please Enter First Name: ");
	String firstName = input.nextLine();
	
	System.out.println("Please Enter Last Name: ");
	String lastName = input.nextLine();
	
	System.out.println("Enter Phone Number: ");
	int phoneNumber = input.nextInt();
	
	input.nextLine();
	
	PhoneBook contact = new PhoneBook(firstName, lastName, phoneNumber);
	numbers.add(contact);
	
	System.out.println("Contact has been added successfully!\n");
}


























































}