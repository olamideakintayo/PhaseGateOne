// CheckOutApp.java

import java.util.ArrayList;
import java.util.Scanner;

class CheckOut {
	static Scanner input = new Scanner(System.in);
	static ArrayList<CheckOut> shoppingCart = new ArrayList<>();
	
	String customerName;
	String userBuy;
	int itemPieces;
	double pricePerUnit;
	String cashierName;
	double discountRate;
	
	public CheckOut(String customerName, String userBuy, int itemPieces, double pricePerUnit, String cashierName, double discountRate) {
	this.customerName = customerName;
	this.userBuy = userBuy;
	this.itemPieces = itemPieces;
	this.pricePerUnit= pricePerUnit;
	this.cashierName = cashierName;
	this.discountRate = discountRate;
	}