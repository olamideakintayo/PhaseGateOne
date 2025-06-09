// CreditCardValidatorTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreditCardValidatorTest {

    @Test
    void testThatChecksForAValidVisaCard() {
        String creditCardNumber = "4539148803436467";  
        String result = CreditCardValidator.creditCardValidation(creditCardNumber);

        assertTrue(result.contains("Visa"));
        assertTrue(result.contains("Valid"));
        assertTrue(result.contains(creditCardNumber));
        assertTrue(result.contains("Digit Length : " + creditCardNumber.length()));
    }
}
