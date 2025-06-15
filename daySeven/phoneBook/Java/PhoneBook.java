// PhoneBook.java

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    static Scanner input = new Scanner(System.in);
    static ArrayList<PhoneBook> numbers = new ArrayList<>();

    String firstName;
    String lastName;
    String phoneNumber;

    public PhoneBook(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public static void addContact() {
        String firstName;
        String lastName;
        String phoneNumber;

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
            phoneNumber = input.nextLine().trim();

            boolean duplicatePhoneNumber = false;
            for (PhoneBook user : numbers) {
                if (user.phoneNumber.equals(phoneNumber)) {
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
        if (numbers.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        System.out.print("Enter the phone number you want to remove: ");
        String removePhoneNumber = input.nextLine().trim();

        boolean seenContact = false;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).phoneNumber.equals(removePhoneNumber)) {
                numbers.remove(i);
                System.out.println("Contact has been removed successfully.");
                seenContact = true;
                break;
            }
        }

        if (!seenContact) {
            System.out.println("Contact not found!!");
        }
    }

    public static void findContactByPhoneNumber() {
        if (numbers.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        System.out.println("Enter Phone Number: ");
        String findPhoneNumber = input.nextLine().trim();

        boolean seenContact = false;

        for (PhoneBook contact : numbers) {
            if (contact.phoneNumber.equals(findPhoneNumber)) {
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

    public static void findContactByFirstName() {
        if (numbers.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        System.out.println("Enter First Name: ");
        String findFirstName = input.nextLine().trim();

        boolean seenFirstNameContact = false;

        for (PhoneBook contact : numbers) {
            if (contact.firstName.equalsIgnoreCase(findFirstName)) {
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
    }

    public static void findContactByLastName() {
        if (numbers.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        System.out.println("Enter Last Name: ");
        String findLastName = input.nextLine().trim();

        boolean seenLastNameContact = false;

        for (PhoneBook contact : numbers) {
            if (contact.lastName.equalsIgnoreCase(findLastName)) {
                System.out.println("Contact found:");
                System.out.println("Name: " + contact.firstName + " " + contact.lastName);
                System.out.println("Phone Number: " + contact.phoneNumber);
                seenLastNameContact = true;
                System.out.println();
                break;
            }
        }

        if (!seenLastNameContact) {
            System.out.println("No contact found with last name: " + findLastName);
        }
    }

    public static void editContact() {
        if (numbers.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        System.out.println("Please Enter the contact first name to update contact details: ");
        String indexName = input.nextLine().trim();

        PhoneBook foundContact = null;
        for (PhoneBook user : numbers) {
            if (user.firstName.equalsIgnoreCase(indexName)) {
                foundContact = user;
                break;
            }
        }

        if (foundContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter the new contact first name: ");
        foundContact.firstName = input.nextLine().trim();

        System.out.println("Enter the new contact last name: ");
        foundContact.lastName = input.nextLine().trim();

        System.out.println("Enter the new contact phone number: ");
        foundContact.phoneNumber = input.nextLine().trim();

        System.out.println("The Contact has been updated successfully!!");
    }
}
