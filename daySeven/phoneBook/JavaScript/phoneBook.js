// phoneBook.js

const prompt = require('prompt-sync')();

let contacts = [];

function addContact() {
    let firstName;
    let lastName;
    let phoneNumber;

    while (true) {
        firstName = prompt("Please Enter First Name: ").trim();

        const duplicateFirstName = contacts.some(contact => contact.firstName.toLowerCase() === firstName.toLowerCase());
        if (duplicateFirstName) {
            console.log(`Error: User with the first name '${firstName}' already exists. Please enter a different name.`);
        } else {
            break;
        }
    }

    while (true) {
        lastName = prompt("Please Enter Last Name: ").trim();

        const duplicateLastName = contacts.some(contact => contact.lastName.toLowerCase() === lastName.toLowerCase());
        if (duplicateLastName) {
            console.log(`Error: User with the last name '${lastName}' already exists. Please enter a different name.`);
        } else {
            break;
        }
    }

    while (true) {
        phoneNumber = prompt("Enter Phone Number: ").trim();

        const duplicatePhoneNumber = contacts.some(contact => contact.phoneNumber === phoneNumber);
        if (duplicatePhoneNumber) {
            console.log(`Error: Phone number '${phoneNumber}' already exists. Please enter a different phone number.`);
        } else {
            break;
        }
    }

    const newContact = { firstName, lastName, phoneNumber };
    contacts.push(newContact);
    console.log("Contact has been added successfully!\n");
}

function removeContact() {
    if (contacts.length === 0) {
        console.log("No contacts found.\n");
        return;
    }

    const removePhoneNumber = prompt("Enter the phone number you want to remove: ").trim();
    const index = contacts.findIndex(contact => contact.phoneNumber === removePhoneNumber);

    if (index !== -1) {
        contacts.splice(index, 1);
        console.log("Contact has been removed successfully.");
    } else {
        console.log("Contact not found!!");
    }
}

function findContactByPhoneNumber() {
    if (contacts.length === 0) {
        console.log("No contacts found.\n");
        return;
    }

    const findPhoneNumber = prompt("Enter Phone Number: ").trim();
    const contact = contacts.find(contact => contact.phoneNumber === findPhoneNumber);

    if (contact) {
        console.log("\n===================================================");
        console.log(`Contact found:\nName: ${contact.firstName} ${contact.lastName}\nPhone Number: ${contact.phoneNumber}`);
        console.log("===================================================");
    } else {
        console.log(`No contact found with phone number: ${findPhoneNumber}`);
    }
}

function findContactByFirstName() {
    if (contacts.length === 0) {
        console.log("No contacts found.\n");
        return;
    }

    const findFirstName = prompt("Enter First Name: ").trim();
    const contact = contacts.find(contact => contact.firstName.toLowerCase() === findFirstName.toLowerCase());

    if (contact) {
        console.log("\n===================================================");
        console.log(`Contact found:\nName: ${contact.firstName} ${contact.lastName}\nPhone Number: ${contact.phoneNumber}`);
        console.log("===================================================");
    } else {
        console.log(`No contact found with first name: ${findFirstName}`);
    }
}

function findContactByLastName() {
    if (contacts.length === 0) {
        console.log("No contacts found.\n");
        return;
    }

    const findLastName = prompt("Enter Last Name: ").trim();
    const contact = contacts.find(contact => contact.lastName.toLowerCase() === findLastName.toLowerCase());

    if (contact) {
        console.log("\n===================================================");
        console.log(`Contact found:\nName: ${contact.firstName} ${contact.lastName}\nPhone Number: ${contact.phoneNumber}`);
        console.log("===================================================");
    } else {
        console.log(`No contact found with last name: ${findLastName}`);
    }
}

function editContact() {
    if (contacts.length === 0) {
        console.log("No contacts found.\n");
        return;
    }

    const indexName = prompt("Please Enter the contact first name to update contact details: ").trim();
    const contact = contacts.find(contact => contact.firstName.toLowerCase() === indexName.toLowerCase());

    if (!contact) {
        console.log("Contact not found");
        return;
    }

    contact.firstName = prompt("Enter the new contact first name: ").trim();
    contact.lastName = prompt("Enter the new contact last name: ").trim();
    contact.phoneNumber = prompt("Enter the new contact phone number: ").trim();

    console.log("The Contact has been updated successfully!!");
}

function mainMenu() {
    let userInput;
    do {
        console.log("\n===================================================");
        console.log("Welcome to PhoneBook");
        console.log("1. Add Contact");
        console.log("2. Remove Contact");
        console.log("3. Find contact by phone number");
        console.log("4. Find contact by first name");
        console.log("5. Find contact by last name");
        console.log("6. Edit contact");
        console.log("7. Exit");
        console.log("===================================================");

        userInput = parseInt(prompt("Choose an option: ").trim());

        switch (userInput) {
            case 1:
                addContact();
                break;
            case 2:
                removeContact();
                break;
            case 3:
                findContactByPhoneNumber();
                break;
            case 4:
                findContactByFirstName();
                break;
            case 5:
                findContactByLastName();
                break;
            case 6:
                editContact();
                break;
            case 7:
                console.log("Goodbye! Have a nice day!");
                break;
            default:
                console.log("Invalid Option. Please try again.");
        }
    } while (userInput !== 7);
}

mainMenu();
