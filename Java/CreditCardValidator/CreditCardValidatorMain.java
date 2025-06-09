// CreditCardValidatorMain.java
import java.util.Scanner;

public class CreditCardValidatorMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hello, Kindly Enter Card details to verify (digits only, no spaces): ");
        String userInput = input.nextLine();

        if (!userInput.matches("\\d+")) {
            System.out.println("Invalid input. Please enter digits only.");
            return;
        }

        String result = CreditCardValidator.creditCardValidation(userInput);

        System.out.println("\n*************************************");
        System.out.println(result);
        System.out.println("*************************************\n");

        input.close();
    }
}
