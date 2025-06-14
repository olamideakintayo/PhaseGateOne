// CheckOutMain.java

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        CheckOut.addToCart();

         for (CheckOut item : CheckOut.shoppingCart) {
            item.showInvoice();
            item.showReceipt();
        }

       }
}









