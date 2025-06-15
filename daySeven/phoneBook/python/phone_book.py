# phone_book.py

numbers = []

def add_contact():
    while True:
        first_name = input("Please Enter First Name: ").strip()

        duplicate_first_name = any(user['first_name'].lower() == first_name.lower() for user in numbers)
        if duplicate_first_name:
            print(f"Error: User with the first name '{first_name}' already exists. Please enter a different name.")
        else:
            break

    while True:
        last_name = input("Please Enter Last Name: ").strip()

        duplicate_last_name = any(user['last_name'].lower() == last_name.lower() for user in numbers)
        if duplicate_last_name:
            print(f"Error: User with the last name '{last_name}' already exists. Please enter a different name.")
        else:
            break

    while True:
        phone_number = input("Enter Phone Number: ").strip()

        duplicate_phone_number = any(user['phone_number'] == phone_number for user in numbers)
        if duplicate_phone_number:
            print(f"Error: Phone number '{phone_number}' already exists. Please enter a different phone number.")
        else:
            break

    contact = {
        'first_name': first_name,
        'last_name': last_name,
        'phone_number': phone_number
    }
    numbers.append(contact)
    print("Contact has been added successfully!\n")


def remove_contact():
    if not numbers:
        print("No contacts found.\n")
        return

    remove_phone_number = input("Enter the phone number you want to remove: ").strip()

    for i, contact in enumerate(numbers):
        if contact['phone_number'] == remove_phone_number:
            del numbers[i]
            print("Contact has been removed successfully.")
            return

    print("Contact not found!!")


def find_contact_by_phone_number():
    if not numbers:
        print("No contacts found.\n")
        return

    find_phone_number = input("Enter Phone Number: ").strip()

    for contact in numbers:
        if contact['phone_number'] == find_phone_number:
            print("\n===================================================")
            print("Contact found:")
            print(f"Name: {contact['first_name']} {contact['last_name']}")
            print(f"Phone Number: {contact['phone_number']}")
            print("===================================================")
            return

    print(f"No contact found with phone number: {find_phone_number}")


def find_contact_by_first_name():
    if not numbers:
        print("No contacts found.\n")
        return

    find_first_name = input("Enter First Name: ").strip()

    for contact in numbers:
        if contact['first_name'].lower() == find_first_name.lower():
            print("\n===================================================")
            print("Contact found:")
            print(f"Name: {contact['first_name']} {contact['last_name']}")
            print(f"Phone Number: {contact['phone_number']}")
            print("===================================================")
            return

    print(f"No contact found with first name: {find_first_name}")


def find_contact_by_last_name():
    if not numbers:
        print("No contacts found.\n")
        return

    find_last_name = input("Enter Last Name: ").strip()

    for contact in numbers:
        if contact['last_name'].lower() == find_last_name.lower():
            print("\n===================================================")
            print("Contact found:")
            print(f"Name: {contact['first_name']} {contact['last_name']}")
            print(f"Phone Number: {contact['phone_number']}")
            print("===================================================")
            return

    print(f"No contact found with last name: {find_last_name}")


def edit_contact():
    if not numbers:
        print("No contacts found.\n")
        return

    index_name = input("Please Enter the contact first name to update contact details: ").strip()

    for contact in numbers:
        if contact['first_name'].lower() == index_name.lower():
            contact['first_name'] = input("Enter the new contact first name: ").strip()
            contact['last_name'] = input("Enter the new contact last name: ").strip()
            contact['phone_number'] = input("Enter the new contact phone number: ").strip()
            print("The Contact has been updated successfully!!")
            return

    print("Contact not found")
