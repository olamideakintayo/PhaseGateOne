// CreditCardValidatorMain.java
import java.util.Scanner;

public class CreditCardValidatorMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter card number (digits only): ");
        String userInput = input.nextLine();

        if (!userInput.matches("\\d+")) {
            System.out.println("Invalid input. Please enter digits only.");
            scanner.close();
            return;
        }

        String result = CreditCardValidator.validateCard(input);

        System.out.println("\n*************************************");
        System.out.println(result);
        System.out.println("*************************************\n");

        scanner.close();
    }
}
