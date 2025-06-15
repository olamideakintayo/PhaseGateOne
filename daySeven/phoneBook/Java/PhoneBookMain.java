// PhoneBookMain.java

import java.util.Scanner;
public class PhoneBookMain {
     static Scanner input = new Scanner(System.in);
    
public static void main(String[] args) {
int userInput;

	do {
		System.out.println("\n Welcome to PhoneBook");
		System.out.println("1. Add Contact");
		System.out.println("2. Remove Contact");
		System.out.println("3. Find contact by phone number");
		System.out.println("4. Find contact by first name");
		System.out.println("5. Find contact by last name");
		System.out.println("6. Edit contact");
		System.out.println("7. Exit");
		userInput = input.nextInt();
		input.nextLine();
		
		switch(userInput) {
		case 1 -> PhoneBook.addContact();
		case 2 -> PhoneBook.removeContact();
           case 3 -> PhoneBook.findContactByPhoneNumber();
           case 4 -> PhoneBook.findContactByFirstName();
           case 5 -> PhoneBook.findContactByLastName();
           case 6 -> PhoneBook.editContact();
           case 7 -> System.out.println("GoodBye!! Have a nice day!");
           default -> System.out.println("Invalid Option. Please try again "); 
           }
           } 
           while (userInput != 7); 
           }
		
		
}		
