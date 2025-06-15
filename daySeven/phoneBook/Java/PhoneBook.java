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

	public static void removeContact() {
	System.out.print("Enter the phone number you want to remove: ");
	int removePhoneNumber = input.nextInt();
	
	
	boolean seenContact = false;
	
	for (int i = 0; i < numbers.size(); i++) {
		if (numbers.get(i).phoneNumber == removePhoneNumber) {
		numbers.remove(i);
		System.out.println("Contact has been removed successfully.");
		seenContact = true;
		break;
		}
	}
	
	if(!seenContact) {
		System.out.println("Contact no Found!!");
	}	
	}

	public static void findContactByPhoneNumber() {
    System.out.println("Enter Phone Number: ");
    int findPhoneNumber = input.nextInt();
    
    if (numbers.isEmpty()) {
        System.out.println("No contacts found.\n");
        return;
    }
    
    boolean seenContact = false;
    
    for (PhoneBook contact : numbers) {
        if (contact.phoneNumber == findPhoneNumber) {
            System.out.println("Contact found:");
            System.out.println("Name: " + contact.firstName + " " + contact.lastName);
            System.out.println("Phone Number: " + contact.phoneNumber);
            seenContact = true;
            System.out.println();
            break;  
                    }
    }
    
    if (!seenContact) {
        System.out.println("No contact found with phone number: " + findPhoneNumber);
    }
}


















































}