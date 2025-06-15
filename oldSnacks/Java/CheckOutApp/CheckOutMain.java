// CheckOutMain.java

import java.util.Scanner;

public class CheckOutMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        CheckOut.addToCart();

         CheckOut anyItem = CheckOut.shoppingCart.get(0);
         anyItem.showInvoice();
         
         anyItem.showReceipt();
       }
}









