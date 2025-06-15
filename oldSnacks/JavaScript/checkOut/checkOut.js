// checkOut.js

const prompt = require('prompt-sync')({sigint: true});

class CheckOut {
    static shoppingCart = [];

    constructor(customerName, userBuy, itemPieces, pricePerUnit, cashierName, discountRate) {
        this.customerName = customerName;
        this.userBuy = userBuy;
        this.itemPieces = itemPieces;
        this.pricePerUnit = pricePerUnit;
        this.cashierName = cashierName;
        this.discountRate = discountRate;
        this.amountPaid = 0;
    }

   showInvoice() {
    let subTotal = 0;

    console.log("\nSEMICOLON STORES");
    console.log("MAIN BRANCH");
    console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
    console.log("TEL: 03293823243");
    console.log("Date:", new Date().toLocaleDateString());
    console.log("Cashier:", this.cashierName);
    console.log("Customer Name:", this.customerName);
    console.log("\n" + "=".repeat(90));
    console.log("ITEM       QTY     PRICE      TOTAL(NGN)");

    for (const item of CheckOut.shoppingCart) {
        const totalAmount = item.itemPieces * item.pricePerUnit;
        subTotal += totalAmount;
        console.log(`${item.userBuy.padEnd(10)} ${item.itemPieces.toString().padEnd(8)} ${item.pricePerUnit.toFixed(2).padEnd(10)} ${totalAmount.toFixed(2)}`);
    }

    const discountedAmount = subTotal * (this.discountRate / 100);
    const newAmount = subTotal - discountedAmount;
    const vat = newAmount * 0.075;
    const finalAmount = newAmount + vat;

    console.log("=".repeat(90));
    console.log(`Sub Total: ${subTotal.toFixed(2)}`);
    console.log(`Discount: ${discountedAmount.toFixed(2)}`);
    console.log(`VAT @ 7.5%: ${vat.toFixed(2)}`);
    console.log("=".repeat(90));
    console.log(`Bill Total: ${finalAmount.toFixed(2)}`);
    console.log(`THIS IS NOT A RECEIPT KINDLY PAY ${finalAmount.toFixed(2)}`);
    console.log("=".repeat(90));

    while (true) {
        const amount = parseFloat(prompt("How much did the customer give to you? "));
        if (amount >= finalAmount) {
            this.amountPaid = amount;
            break;
        } else {
            console.log("Invalid amount!! Amount paid can't be lesser than final amount.");
        }
    }
}

    showReceipt() {
        let subTotal = 0;

        console.log("\nSEMICOLON STORES");
        console.log("MAIN BRANCH");
        console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        console.log("TEL: 03293823243");
        console.log("Date:", new Date().toLocaleDateString());
        console.log("Cashier:", this.cashierName);
        console.log("Customer Name:", this.customerName);
        console.log("\n" + "=".repeat(90));
        console.log("ITEM       QTY     PRICE      TOTAL(NGN)");

        for (const item of CheckOut.shoppingCart) {
            const totalAmount = item.itemPieces * item.pricePerUnit;
            subTotal += totalAmount;
            console.log(`${item.userBuy.padEnd(10)} ${item.itemPieces.toString().padEnd(8)} ${item.pricePerUnit.toFixed(2).padEnd(10)} ${totalAmount.toFixed(2)}`);
        }

        const discountedAmount = subTotal * (this.discountRate / 100);
        const newAmount = subTotal - discountedAmount;
        const vat = newAmount * 0.075;
        const finalAmount = newAmount + vat;
        const balance = this.amountPaid - finalAmount;

        console.log("=".repeat(90));
        console.log(`Sub Total: ${subTotal.toFixed(2)}`);
        console.log(`Discount: ${discountedAmount.toFixed(2)}`);
        console.log(`VAT @ 7.5%: ${vat.toFixed(2)}`);
        console.log("=".repeat(90));
        console.log(`Bill Total: ${finalAmount.toFixed(2)}`);
        console.log(`Amount Paid: ${this.amountPaid.toFixed(2)}`);
        console.log(`Balance: ${balance.toFixed(2)}`);
        console.log("=".repeat(90));
        console.log("THANK YOU FOR YOUR PATRONAGE");
        console.log("=".repeat(90));

        process.exit(0);
    }

    static addToCart() {
        const customerName = prompt("What is the customer's name: ").trim();
        const cartPerItems = [];
        let cashierName = "";
        let discountRate = 0;

        while (true) {
            const userBuy = prompt("What did the user buy? ").trim();

            let itemPieces;
            while (true) {
                itemPieces = parseInt(prompt("How many pieces? "));
                if (itemPieces >= 1) break;
                console.log("Error!! Item pieces must be greater than 0.");
            }

            let pricePerUnit;
            while (true) {
                pricePerUnit = parseFloat(prompt("How much per unit? "));
                if (pricePerUnit >= 100) break;
                console.log("Error!! Price must be equal to or greater than 100 naira");
            }

            cartPerItems.push(new CheckOut(customerName, userBuy, itemPieces, pricePerUnit, "", 0));

            const addMoreItems = prompt("Add more items? ").trim().toLowerCase();
            if (addMoreItems === "yes") {
                continue;
            } else if (addMoreItems === "no") {
                cashierName = prompt("What is your name? ").trim();
                while (true) {
                    discountRate = parseFloat(prompt("How much discount will he get? "));
                    if (discountRate >= 1) break;
                    console.log("Error!! Discount must be at least 1% or more");
                }
                break;
            } else {
                console.log("Error!! Please enter either Yes or No to continue");
            }
        }

        for (const item of cartPerItems) {
            item.cashierName = cashierName;
            item.discountRate = discountRate;
            CheckOut.shoppingCart.push(item);
        }
    }
}


CheckOut.addToCart();
const anyItem = CheckOut.shoppingCart[0];
anyItem.showInvoice();
anyItem.showReceipt();
