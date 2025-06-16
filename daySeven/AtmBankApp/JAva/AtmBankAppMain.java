import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selectedOption;

        do {
            System.out.println("\n=== ATM BANK APP ===");
            System.out.println("1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Transfer");
            System.out.println("7. Change Pin");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            selectedOption = scanner.nextLine();

            try {
                switch (selectedOption) {
                    case "1":
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();

                        System.out.print("Enter 4-digit PIN: ");
                        String pin = scanner.nextLine();

                        System.out.println(AtmBankApp.createAccount(firstName, lastName, phoneNumber, pin));
                        break;

                    case "2":
                        System.out.print("Enter Phone Number: ");
                        String closePhoneNumber = scanner.nextLine();

                        System.out.print("Enter PIN: ");
                        String closePin = scanner.nextLine();

                        System.out.println(AtmBankApp.closeAccount(closePhoneNumber, closePin));
                        break;

                    case "3":
                        System.out.print("Enter Phone Number: ");
                        String depositPhoneNumber = scanner.nextLine();

                        System.out.print("Enter Amount to Deposit: ");
                        String depositAmount = scanner.nextLine();

                        double updatedBalance = AtmBankApp.deposit(depositPhoneNumber, depositAmount);
                        System.out.println("Deposit successful. New Balance: " + updatedBalance);
                        break;

                    case "4":
                        System.out.print("Enter Phone Number: ");
                        String withdrawPhoneNumber = scanner.nextLine();

                        System.out.print("Enter PIN: ");
                        String withdrawPin = scanner.nextLine();

                        System.out.print("Enter Amount to Withdraw: ");
                        String withdrawAmount = scanner.nextLine();

                        double remainingBalance = AtmBankApp.withdraw(withdrawPhoneNumber, withdrawPin, withdrawAmount);
                        System.out.println("Withdrawal successful. Remaining Balance: " + remainingBalance);
                        break;

                    case "5":
                        System.out.print("Enter Phone Number: ");
                        String balancePhoneNumber = scanner.nextLine();

                        System.out.print("Enter PIN: ");
                        String balancePin = scanner.nextLine();

                        double accountBalance = AtmBankApp.checkBalance(balancePhoneNumber, balancePin);
                        System.out.println("Current Balance: " + accountBalance);
                        break;

                    case "6":
                        System.out.print("Enter Sender Phone Number: ");
                        String senderPhoneNumber = scanner.nextLine();

                        System.out.print("Enter Sender PIN: ");
                        String senderPin = scanner.nextLine();

                        System.out.print("Enter Receiver Phone Number: ");
                        String receiverPhoneNumber = scanner.nextLine();

                        System.out.print("Enter Amount to Transfer: ");
                        String transferAmount = scanner.nextLine();

                        System.out.println(AtmBankApp.transfer(senderPhoneNumber, senderPin, receiverPhoneNumber, transferAmount));
                        break;

                    case "7":
                        System.out.print("Enter Phone Number: ");
                        String changePinPhoneNumber = scanner.nextLine();

                        System.out.print("Enter Old PIN: ");
                        String oldPin = scanner.nextLine();

                        System.out.print("Enter New PIN: ");
                        String newPin = scanner.nextLine();

                        System.out.println(AtmBankApp.changePin(changePinPhoneNumber, oldPin, newPin));
                        break;

                    case "8":
                        System.out.println("Exiting application... Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option selected. Please try again.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (!selectedOption.equals("8"));

    }
}
