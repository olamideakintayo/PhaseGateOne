// MenstruationCycleMain.java

import java.util.Scanner;
public class MenstruationCycleMain {
     static Scanner input = new Scanner(System.in);
    
public static void main(String[] args) {
int userInput;
do {
    System.out.println("\n===========================================");
System.out.println("      Welcome to Menstruation Cycle Tracker");
System.out.println("===========================================");
System.out.println("  1. Add User Details");
System.out.println("  2. View Menstrual Summary");
System.out.println("  3. Update Menstruation Cycle");
System.out.println("  4. Exit");
System.out.println("===========================================");
System.out.print("Please enter your choice (1-4): ");
    userInput = input.nextInt();
    input.nextLine();

    switch(userInput) {
        case 1 -> MenstruationCycle.addUserDetails();
        case 2 -> MenstruationCycle.viewMenstrualSummary();
        case 3 -> MenstruationCycle.updateMenstruationCycle();
        case 4 -> System.out.println("GoodBye!! Have a nice day!");
        default -> System.out.println("Invalid Option. Please try again ");
    }
} 
while (userInput != 4);
}
}