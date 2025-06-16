import java.util.ArrayList;
import java.util.List;

public class AtmBankApp {
    private static class Account {
        String firstName;
        String lastName;
        String phone;
        String pin;
        double balance;

        Account(String firstName, String lastName, String phone, String pin, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.pin = pin;
            this.balance = balance;
        }
    }

    private static List<Account> accounts = new ArrayList<>();

    public static String createAccount(String firstName, String lastName, String phone, String pin) {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name and last name cannot be empty.");
        }
        if (!phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must contain digits only.");
        }
        if (pin.length() != 4 || !pin.matches("\\d+")) {
            throw new IllegalArgumentException("Pin must be 4 digits.");
        }

        for (Account acc : accounts) {
            if (acc.phone.equals(phone)) {
                throw new IllegalArgumentException("Account with this phone number already exists.");
            }
        }

        Account account = new Account(firstName, lastName, phone, pin, 0.0);
        accounts.add(account);
        return "Account created successfully.";
    }

    public static String closeAccount(String phone, String pin) {
        for (Account account : accounts) {
            if (account.phone.equals(phone)) {
                if (!account.pin.equals(pin)) {
                    throw new IllegalArgumentException("Invalid pin.");
                }
                accounts.remove(account);
                return "Account closed successfully.";
            }
        }
        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static double deposit(String phone, String amountStr) {
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Deposit amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }

        for (Account account : accounts) {
            if (account.phone.equals(phone)) {
                account.balance += amount;
                return account.balance;
            }
        }

        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static double withdraw(String phone, String pin, String amountStr) {
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Withdrawal amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        for (Account account : accounts) {
            if (account.phone.equals(phone)) {
                if (!account.pin.equals(pin)) {
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

    public static double checkBalance(String phone, String pin) {
        for (Account account : accounts) {
            if (account.phone.equals(phone)) {
                if (!account.pin.equals(pin)) {
                    throw new IllegalArgumentException("Invalid pin.");
                }
                return account.balance;
            }
        }
        throw new IllegalArgumentException("Account with this phone number not found.");
    }

    public static String transfer(String fromPhone, String fromPin, String toPhone, String amountStr) {
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Transfer amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }

        Account fromAccount = null;
        Account toAccount = null;

        for (Account account : accounts) {
            if (account.phone.equals(fromPhone)) {
                fromAccount = account;
            }
            if (account.phone.equals(toPhone)) {
                toAccount = account;
            }
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

    public static String changePin(String phone, String oldPin, String newPin) {
        for (Account account : accounts) {
            if (account.phone.equals(phone)) {
                if (!account.pin.equals(oldPin)) {
                    throw new IllegalArgumentException("Old pin is incorrect.");
                }
                if (newPin.length() != 4 || !newPin.matches("\\d+")) {
                    throw new IllegalArgumentException("New pin must be 4 digits.");
                }
                account.pin = newPin;
                return "Pin changed successfully.";
            }
        }
        throw new IllegalArgumentException("Account with this phone number not found.");
    }
}
