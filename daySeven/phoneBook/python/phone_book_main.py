import phone_book

def main_menu():
    while True:
        print("\n===================================================")
        print("\n Welcome to PhoneBook")
        print("1. Add Contact")
        print("2. Remove Contact")
        print("3. Find contact by phone number")
        print("4. Find contact by first name")
        print("5. Find contact by last name")
        print("6. Edit contact")
        print("7. Exit")
        print("===================================================")

        try:
            user_input = int(input("Enter your choice: ").strip())
        except ValueError:
            print("Invalid input. Please enter a number between 1-7.")
            continue

        if user_input == 1:
            phone_book.add_contact()
        elif user_input == 2:
            phone_book.remove_contact()
        elif user_input == 3:
            phone_book.find_contact_by_phone_number()
        elif user_input == 4:
            phone_book.find_contact_by_first_name()
        elif user_input == 5:
            phone_book.find_contact_by_last_name()
        elif user_input == 6:
            phone_book.edit_contact()
        elif user_input == 7:
            print("GoodBye!! Have a nice day!")
            break
        else:
            print("Invalid Option. Please try again.")

if __name__ == "__main__":
    main_menu()
