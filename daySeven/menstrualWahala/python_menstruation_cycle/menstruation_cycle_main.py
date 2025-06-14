# menstruation_cycle_main.py
import menstruation_cycle

def menstruation_cycle_main():
    while True:
        print("\n===========================================")
        print("      Welcome to Menstruation Cycle Tracker")
        print("===========================================")
        print("  1. Add User Details")
        print("  2. View Menstrual Summary")
        print("  3. Update Menstruation Cycle")
        print("  4. Exit")
        print("===========================================")
        choice = input("Please enter your choice (1-4): ").strip()

        if choice == "1":
            menstruation_cycle.add_user_details()
        elif choice == "2":
            menstruation_cycle.view_menstrual_summary()
        elif choice == "3":
            menstruation_cycle.update_menstruation_cycle()
        elif choice == "4":
            print("GoodBye!! Have a nice day!")
            break
        else:
            print("Invalid Option. Please try again.")

if __name__ == "__main__":
    menstruation_cycle_main()
