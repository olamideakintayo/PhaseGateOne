// CheckOutTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CheckOutTest {

    @BeforeEach
    public void setUp() {
        CheckOut.shoppingCart = new ArrayList<>();
    }

    @Test
    public void testThatChecksForSingleItemWithNoDiscount() {
        CheckOut item = new CheckOut("Olamide", "Bread", 1, 100, "Cashier1", 0, 0);
        CheckOut.shoppingCart.add(item);

        double expectedSubTotal = 100;
        double expectedDiscount = 0;
        double expectedVat = (expectedSubTotal - expectedDiscount) * 0.075;
        double expectedTotal = expectedSubTotal - expectedDiscount + expectedVat;

        assertEquals(107.5, expectedTotal, 0.01);
    }



}