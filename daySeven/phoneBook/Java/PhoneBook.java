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
    String firstName;
    String lastName;
    int phoneNumber;

    
    while (true) {
        System.out.print("Please Enter First Name: ");
        firstName = input.nextLine().trim();

        boolean duplicateFirstName = false;
        for (PhoneBook user : numbers) {
            if (user.firstName.equalsIgnoreCase(firstName)) {
                System.out.println("Error: User with the first name '" + firstName + "' already exists. Please enter a different name.");
                duplicateFirstName = true;
                break;
            }
        }
        if (!duplicateFirstName) break;
    }


    while (true) {
        System.out.print("Please Enter Last Name: ");
        lastName = input.nextLine().trim();

        boolean duplicateLastName = false;
        for (PhoneBook user : numbers) {
            if (user.lastName.equalsIgnoreCase(lastName)) {
                System.out.println("Error: User with the last name '" + lastName + "' already exists. Please enter a different name.");
                duplicateLastName = true;
                break;
            }
        }
        if (!duplicateLastName) break;
    }


    while (true) {
        System.out.print("Enter Phone Number: ");
        phoneNumber = input.nextInt();
        input.nextLine(); 
        
        boolean duplicatePhoneNumber = false;
        for (PhoneBook user : numbers) {
            if (user.phoneNumber == phoneNumber) {
                System.out.println("Error: Phone number '" + phoneNumber + "' already exists. Please enter a different phone number.");
                duplicatePhoneNumber = true;
                break;
            }
        }
        if (!duplicatePhoneNumber) break;
    }

  
    PhoneBook contact = new PhoneBook(firstName, lastName, phoneNumber);
    numbers.add(contact);
    System.out.println("Contact has been added successfully!\n");
}

	public static void removeContact() {
	while (true) {
	System.out.print("Enter the phone number you want to remove: ");
	int removePhoneNumber = input.nextInt();
	
	input.nextLine();
	
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
	break;
	}
	}

	public static void findContactByPhoneNumber() {
	while (true) {
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
break;
}
}

	public static void findContactByFirstName() {
	while (true) {
	System.out.println("Enter First Name: ");
	String findFirstName = input.nextLine();
	
	if (numbers.isEmpty()) {
        System.out.println("No contacts found.\n");
        return;
    }
	
	boolean seenFirstNameContact = false; 
	
	for (PhoneBook contact : numbers) {
		if (contact.firstName == findFirstName) {
		System.out.println("Contact found:");
		System.out.println("Name: " + contact.firstName + " " + contact.lastName);
		System.out.println("Phone Number: " + contact.phoneNumber);
		seenFirstNameContact = true;
		System.out.println();
		break;
	}
	}
	if (!seenFirstNameContact) {
		System.out.println("No contact found with first name: " + findFirstName);
	}
	break;
	}
}

public static void findContactByLastName() {
	System.out.println("Enter Last Name: ");
	String findLastName = input.nextLine();
	
	if (numbers.isEmpty()) {
        System.out.println("No contacts found.\n");
        return;
    }
	
	boolean seenLastNameContact = false; 
	
	for (PhoneBook contact : numbers) {
		if (contact.lastName == findLastName) {
		System.out.println("Contact found:");
		System.out.println("Name: " + contact.firstName + " " + contact.lastName);
		System.out.println("Phone Number: " + contact.phoneNumber);
		seenLastNameContact = true;
		System.out.println();
		break;
	} 
	}
	if (!seenLastNameContact) {
		System.out.println("No contact found with first name: " + findLastName);
	}
	
}















































}