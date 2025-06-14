# check_out_main.py

import check_out

def main():
    customer_name, cashier_name, discount_rate = check_out.add_to_cart()
    amount_paid, final_amount = check_out.show_invoice(customer_name, cashier_name, discount_rate)
    check_out.show_receipt(customer_name, cashier_name, discount_rate, amount_paid, final_amount)

if __name__ == "__main__":
    main()
