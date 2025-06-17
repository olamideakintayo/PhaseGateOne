import java.util.ArrayList;
import java.util.List;

public class AtmBankApp {
    private static class Account {
        String firstName;
        String lastName;
        String phoneNumber;
        String pin;
        double balance;

        Account(String firstName, String lastName, String phoneNumber, String pin, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.pin = pin;
            this.balance = balance;
        }
    }

    private static List<Account> accounts = new ArrayList<>();

    public static String createAccount(String firstName, String lastName, String phoneNumber, String pin) {
        if (firstName == null || firstName.trim().isEmpty() ||
            lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name and last name cannot be empty.");
        }
        if (phoneNumber == null || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must contain digits only.");
        }
        if (pin == null || pin.length() != 4 || !pin.matches("\\d+")) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits.");
        }

        for (Account acc : accounts) {
            if (phoneNumber.equals(acc.phoneNumber)) {
                throw new IllegalArgumentException("Account with this phone number already exists.");
            }
        }

        Account account = new Account(firstName.trim(), lastName.trim(), phoneNumber.trim(), pin.trim(), 0.0);
        accounts.add(account);
        return "Account created successfully.";
    }

    public static String closeAccount(String phoneNumber, String pin) {
        for (Account account : accounts) {
            if (phoneNumber != null && phoneNumber.equals(account.phoneNumber)) {
                if (!pin.equals(account.pin)) {
                    throw new IllegalArgumentException("Invalid pin.");
                }
                accounts.remove(account);
                return "Account closed successfully.";
            }
        }
        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static double deposit(String phoneNumber, String depositAmount) {
        double amount;
        try {
            amount = Double.parseDouble(depositAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Deposit amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }

        for (Account account : accounts) {
            if (phoneNumber != null && phoneNumber.equals(account.phoneNumber)) {
                account.balance += amount;
                return account.balance;
            }
        }

        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static double withdraw(String phoneNumber, String pin, String withdrawAmount) {
        double amount;
        try {
            amount = Double.parseDouble(withdrawAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Withdrawal amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        for (Account account : accounts) {
            if (phoneNumber != null && phoneNumber.equals(account.phoneNumber)) {
                if (!pin.equals(account.pin)) {
                    throw new IllegalArgumentException("Invalid pin.");
                }
                if (account.balance < amount) {
                    throw new IllegalArgumentException("Insufficient funds.");
                }
                account.balance -= amount;
                return account.balance;
            }
        }

        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static double checkBalance(String phoneNumber, String pin) {
        for (Account account : accounts) {
            if (phoneNumber != null && phoneNumber.equals(account.phoneNumber)) {
                if (!pin.equals(account.pin)) {
                    throw new IllegalArgumentException("Invalid pin.");
                }
                return account.balance;
            }
        }
        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static String transfer(String fromPhoneNumber, String fromPin, String toPhoneNumber, String transferAmount) {
    double amount;
    try {
        amount = Double.parseDouble(transferAmount);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Transfer amount must be a valid number.");
    }
    if (amount <= 0) {
        throw new IllegalArgumentException("Transfer amount must be positive.");
    }

    fromPhoneNumber = fromPhoneNumber.trim();
    toPhoneNumber = toPhoneNumber.trim();

    Account fromAccount = null;
    Account toAccount = null;


    System.out.println("Accounts in system:");
    for (Account account : accounts) {
        System.out.println(" - Phone: '" + account.phoneNumber + "'");
    }

    for (Account account : accounts) {
        if (account.phoneNumber != null && account.phoneNumber.trim().equals(fromPhoneNumber)) {
            fromAccount = account;
        }
        if (account.phoneNumber != null && account.phoneNumber.trim().equals(toPhoneNumber)) {
            toAccount = account;
        }
    }

    if (fromAccount == null) {
        System.out.println("Sender account not found for phone number: " + fromPhoneNumber);
    }
    if (toAccount == null) {
        System.out.println("Receiver account not found for phone number: " + toPhoneNumber);
    }

    if (fromAccount == null || toAccount == null) {
        throw new IllegalArgumentException("One or both accounts not found.");
    }

    if (!fromAccount.pin.equals(fromPin)) {
        throw new IllegalArgumentException("Invalid pin for sender.");
    }
    if (fromAccount.balance < amount) {
        throw new IllegalArgumentException("Insufficient funds for transfer.");
    }

    fromAccount.balance -= amount;
    toAccount.balance += amount;

    return "Transfer successful.";
}

    public static String changePin(String phoneNumber, String oldPin, String newPin) {
        if (newPin == null || newPin.length() != 4 || !newPin.matches("\\d+")) {
            throw new IllegalArgumentException("New PIN must be exactly 4 digits.");
        }

        for (Account account : accounts) {
            if (phoneNumber != null && phoneNumber.equals(account.phoneNumber)) {
                if (!oldPin.equals(account.pin)) {
                    throw new IllegalArgumentException("Old pin is incorrect.");
                }
                account.pin = newPin;
                return "Pin changed successfully.";
            }
        }

        throw new IllegalArgumentException("Account with this phone number not found.");
    }
}
