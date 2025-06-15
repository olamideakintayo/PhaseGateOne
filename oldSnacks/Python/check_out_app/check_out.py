from datetime import date

shopping_cart = []

def show_invoice(customer_name, cashier_name, discount_rate):
    sub_total = 0

    print("\nSEMICOLON STORES")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
    print("TEL: 03293823243")
    print("Date:", date.today())
    print("Cashier:", cashier_name)
    print("Customer Name:", customer_name)
    print("\n" + "="*90)
    print(f"{'ITEM':<10} {'QTY':<8} {'PRICE':<10} {'TOTAL(NGN)':<10}")

    for item in shopping_cart:
        total_amount = item['item_pieces'] * item['price_per_unit']
        sub_total += total_amount
        print(f"{item['user_buy']:<10} {item['item_pieces']:<8} {item['price_per_unit']:<10.2f} {total_amount:<10.2f}")

    discounted_amount = sub_total * (discount_rate / 100)
    new_amount = sub_total - discounted_amount
    vat = new_amount * 0.075
    final_amount = new_amount + vat

    print("="*90)
    print("Sub Total: {:.2f}".format(sub_total))
    print("Discount: {:.2f}".format(discounted_amount))
    print("VAT @ 7.5%: {:.2f}".format(vat))
    print("="*90)
    print("Bill Total: {:.2f}".format(final_amount))
    print("THIS IS NOT A RECEIPT KINDLY PAY {:.2f}".format(final_amount))
    print("="*90)
    
    while True:
        amount_paid = float(input("How much did the customer give to you? "))
        if amount_paid >= final_amount:
            break
        else:
            print("Invalid amount!! Amount paid can't be lesser than final amount.")
    
    return amount_paid, final_amount


def show_receipt(customer_name, cashier_name, discount_rate, amount_paid, final_amount):
    sub_total = 0

    print("\nSEMICOLON STORES")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.")
    print("TEL: 03293823243")
    print("Date:", date.today())
    print("Cashier:", cashier_name)
    print("Customer Name:", customer_name)
    print("\n" + "="*90)
    print(f"{'ITEM':<10} {'QTY':<8} {'PRICE':<10} {'TOTAL(NGN)':<10}")

    for item in shopping_cart:
        total_amount = item['item_pieces'] * item['price_per_unit']
        sub_total += total_amount
        print(f"{item['user_buy']:<10} {item['item_pieces']:<8} {item['price_per_unit']:<10.2f} {total_amount:<10.2f}")

    discounted_amount = sub_total * (discount_rate / 100)
    new_amount = sub_total - discounted_amount
    vat = new_amount * 0.075
    final_amount = new_amount + vat
    balance = amount_paid - final_amount

    print("="*90)
    print("Sub Total: {:.2f}".format(sub_total))
    print("Discount: {:.2f}".format(discounted_amount))
    print("VAT @ 7.5%: {:.2f}".format(vat))
    print("="*90)
    print("Bill Total: {:.2f}".format(final_amount))
    print("Amount Paid: {:.2f}".format(amount_paid))
    print("Balance: {:.2f}".format(balance))
    print("="*90)
    print("THANK YOU FOR YOUR PATRONAGE")
    print("="*90)

    exit()


def add_to_cart():
    customer_name = input("What is the customer's name: ").strip()

    cart_per_items = []
    cashier_name = ""
    discount_rate = 0

    while True:
        user_buy = input("What did the user buy? ").strip()

        while True:
            item_pieces = int(input("How many pieces? "))
            if item_pieces >= 1:
                break
            print("Error!! Item pieces must be greater than 0.")

        while True:
            price_per_unit = int(input("How much per unit? "))
            if price_per_unit >= 100:
                break
            print("Error!! Price must be equal to or greater than 100 naira")

        cart_per_items.append({
            'customer_name': customer_name,
            'user_buy': user_buy,
            'item_pieces': item_pieces,
            'price_per_unit': price_per_unit
        })

        add_more_items = input("Add more items? ").strip().lower()

        if add_more_items == "yes":
            continue
        elif add_more_items == "no":
            cashier_name = input("What is your name? ").strip()

            while True:
                discount_rate = float(input("How much discount will he get? "))
                if discount_rate >= 1:
                    break
                print("Error!! Discount must be at least 1% or more")
            break
        else:
            print("Error!! Please enter either Yes or No to continue")

    for item in cart_per_items:
        item['cashier_name'] = cashier_name
        item['discount_rate'] = discount_rate
        shopping_cart.append(item)

    return customer_name, cashier_name, discount_rate
