public class CreditCardValidator {

    public static String validateCard(String numbers) {
        int length = numbers.length();

        if (length < 13 || length > 16) {
            return "Invalid length";
        }

        if (!numbers.matches("\\d+")) {
            return "Card number must contain digits only please";
        }

        char firstDigit = numbers.charAt(0);
        String issuer = null;

        if (firstDigit == '4') {
            issuer = "Visa";
        } else if (firstDigit == '5') {
            issuer = "MasterCard";
        } else if (firstDigit == '6') {
            issuer = "Discover";
        } else if (firstDigit == '3' && length > 1 && numbers.charAt(1) == '7') {
            issuer = "American Express";
        }

        if (issuer == null) {
            return "Invalid issuer or length";
        }

        if (!luhnCheck(numbers)) {
            return "Failed Luhn check";
        }

        return String.format(
            "Credit Card Type : %s\nCredit Card Number : %s\nCredit Card Digit Length : %d\nCredit Card Validity Status : Valid",
            issuer, numbers, length
        );
    }

    private static boolean luhnCheck(String numbers) {
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = numbers.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(numbers.charAt(i));
            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}
