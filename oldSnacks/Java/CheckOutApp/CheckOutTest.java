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

	 @Test
    public void testThatChecksForMultipleItemsWithNoDiscount() {
        CheckOut.shoppingCart.add(new CheckOut("BOJ", "Milk", 2, 150, "olamide", 0, 0));
        CheckOut.shoppingCart.add(new CheckOut("BOJ", "Eggs", 1, 200, "mide", 0, 0));

        double subTotal = (2 * 150) + (1 * 200); 
                double vat = subTotal * 0.075;
        double total = subTotal + vat;

        assertEquals(537.5, total, 0.01);
    }

 
}