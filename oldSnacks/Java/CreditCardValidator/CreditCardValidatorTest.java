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
    
    @Test
    void testThatCheckForInvalidCreditCardNumber() {
    String creditCardNumber = "1234567890123456";
    String result = CreditCardValidator.creditCardValidation(creditCardNumber);
    }
    
    @Test
    void testThatChecksIfTheCreditCardEnteredPassesTheLuhnCheck() {
    String creditCardNumber  = "4539148803436467";
    boolean result = CreditCardValidator.luhnCheck(creditCardNumber);
    
    assertTrue(result);
    }
    
    @Test
    void testThatChecksIfTheCreditCardEnteredFailsTheLuhnCheckIfItIsIncorrect() {
    String creditCardNumber = "4539144803436461";
    boolean result = CreditCardValidator.luhnCheck(creditCardNumber);
    
    assertFalse(result);
    }
    
    @Test
    void testThatChecksForAValidMasterCard() {
        String creditCardNumber = "5555555555554444";  
        String result = CreditCardValidator.creditCardValidation(creditCardNumber);

        assertTrue(result.contains("MasterCard"));
        assertTrue(result.contains("Valid"));
        assertTrue(result.contains(creditCardNumber));
        assertTrue(result.contains("Digit Length : " + creditCardNumber.length()));
    }
    
    @Test
    void testThatChecksForAValidAmericanExpressCard() {
        String creditCardNumber = "378282246310005";  
        String result = CreditCardValidator.creditCardValidation(creditCardNumber);

        assertTrue(result.contains("American Express"));
        assertTrue(result.contains("Valid"));
        assertTrue(result.contains(creditCardNumber));
        assertTrue(result.contains("Digit Length : " + creditCardNumber.length()));
    }
 	
 	@Test
    void testThatChecksForAValidDiscoverCard() {
        String creditCardNumber = "6011111111111117";  
        String result = CreditCardValidator.creditCardValidation(creditCardNumber);

        assertTrue(result.contains("Discover"));
        assertTrue(result.contains("Valid"));
        assertTrue(result.contains(creditCardNumber));
        assertTrue(result.contains("Digit Length : " + creditCardNumber.length()));
    }
}
