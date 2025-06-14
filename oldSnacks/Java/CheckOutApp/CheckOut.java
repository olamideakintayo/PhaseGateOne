// CheckOutApp.java

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

class CheckOut {
    static Scanner input = new Scanner(System.in);
    static ArrayList<CheckOut> shoppingCart = new ArrayList<>();
    
    String customerName;
    String userBuy;
    int itemPieces;
    double pricePerUnit;
    String cashierName;
    double discountRate;
    double amountPaid;
    
    
    public CheckOut(String customerName, String userBuy, int itemPieces, double pricePerUnit, String cashierName, double discountRate) {
        this.customerName = customerName;
        this.userBuy = userBuy;
        this.itemPieces = itemPieces;
        this.pricePerUnit = pricePerUnit;
        this.cashierName = cashierName;
        this.discountRate = discountRate;
    }
    
        
    public void showInvoice() {
        double totalAmount = itemPieces * pricePerUnit;
        double discountedAmount = totalAmount * (discountRate / 100);
        double newAmount = totalAmount - discountedAmount;
        double vat = newAmount * 0.075;
        double finalAmount = newAmount + vat;

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 03293823243");

        System.out.println("Date: " + LocalDate.now());  
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("\n======================================================================================");
        System.out.printf("%-10s %-8s %-10s %-10s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.printf("%-10s %-8d %-10.2f %-10.2f%n", userBuy, itemPieces, pricePerUnit, totalAmount);
        System.out.println("======================================================================================");
        System.out.printf("Sub Total: %.2f%n", totalAmount);
        System.out.printf("Discount: %.2f%n", discountedAmount);
        System.out.printf("VAT @ 7.5%%: %.2f%n", vat);
        System.out.println("======================================================================================");
        System.out.printf("Bill Total: %.2f%n", finalAmount);
        System.out.println("THIS IS NOT A RECEIPT KINDLY PAY " + finalAmount);
        System.out.println("======================================================================================");
        
        System.out.print("How much did the customer give to you? ");
        amountPaid = input.nextDouble();
        input.nextLine();
    }
    
    
     public void showReceipt() {
        double totalAmount = itemPieces * pricePerUnit;
        double discountedAmount = totalAmount * (discountRate / 100);
        double newAmount = totalAmount - discountedAmount;
        double vat = newAmount * 0.075;
        double finalAmount = newAmount + vat;
	  double balance = amountPaid - finalAmount;
	    
        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 03293823243");

        System.out.println("Date: " + LocalDate.now());  
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("\n======================================================================================");
        System.out.printf("%-10s %-8s %-10s %-10s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.printf("%-10s %-8d %-10.2f %-10.2f%n", userBuy, itemPieces, pricePerUnit, totalAmount);
        System.out.println("======================================================================================");
        System.out.printf("Sub Total: %.2f%n", totalAmount);
        System.out.printf("Discount: %.2f%n", discountedAmount);
        System.out.printf("VAT @ 7.5%%: %.2f%n", vat);
        System.out.println("======================================================================================");
        System.out.printf("Bill Total: %.2f%n", finalAmount);
        System.out.printf("Amount Paid: %.2f%n", amountPaid);
       System.out.printf("Balance: %.2f%n", balance);
        System.out.println("======================================================================================");
        System.out.println("THANK YOU FOR YOUR PATRONAGE");
        System.out.println("======================================================================================");
    } 
    
    
   public static void addToCart() {
    String customerName;

    System.out.println("What is the customer's name: ");
    customerName = input.nextLine().trim();

	ArrayList<CheckOut> cartPerItems = new ArrayList<>();
	String cashierName = "";
    double discountRate = 0;
    
    while (true) {
        String userBuy;
        System.out.println("What did the user buy ?");
        userBuy = input.nextLine().trim();

        int itemPieces;
        while (true) {
            System.out.println("How many pieces ?");
            itemPieces = input.nextInt();
            if (itemPieces >= 1) {
                break;
            } else {
                System.out.println("Error!! Item pieces must be greater than 0.");
            }
        }

        int pricePerUnit;
        while (true) {
            System.out.println("How much per unit ?");
            pricePerUnit = input.nextInt();

            if (pricePerUnit >= 100) {
                break;
            } else {
                System.out.println("Error!! Price must be must equal to or greater than 100 naira");
            }
        }

        input.nextLine(); 
        
         System.out.println("Add more items ?");
        String addMoreItems = input.nextLine().toLowerCase();

	cartPerItems.add(new CheckOut(customerName, userBuy, itemPieces, pricePerUnit, "", 0));
	
	if (addMoreItems.equals("yes")) {
	 continue;
	 }
	 
	 else if( addMoreItems.equals("no")) {
        System.out.println("What is your name ?");
        cashierName = input.nextLine().trim();

   
        while (true) {
            System.out.println("How much discount will he get?");
            discountRate = input.nextDouble();

            if (discountRate >= 1) {
                break;
            } else {
                System.out.println("Error!! Discount must be at least 1% or more");
            }
        }

        shoppingCart.add(new CheckOut(customerName, userBuy, itemPieces, pricePerUnit, cashierName, discountRate));
		break;
		}
		else {
		System.out.println("Error!! Please enter either Yes or No to continue");
	    }
}
  for (CheckOut item : cartPerItems) {
        item.cashierName = cashierName;
        item.discountRate = discountRate;
        shoppingCart.add(item);
        } 
}
}
