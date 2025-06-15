# test_check_out.py

import unittest

shopping_cart = []

class TestCheckOut(unittest.TestCase):

    def setUp(self):
        global shopping_cart
        shopping_cart = []

    def test_that_checks_for_single_item_with_no_discount(self):
        shopping_cart.append({
            'customer_name': 'Olamide',
            'user_buy': 'Bread',
            'item_pieces': 1,
            'price_per_unit': 100
        })

        sub_total = 100
        discount = 0
        vat = (sub_total - discount) * 0.075
        total = sub_total - discount + vat

        self.assertAlmostEqual(total, 107.5, places=2)

    def test_that_checks_for_multiple_items_with_no_discount(self):
        shopping_cart.append({'customer_name': 'BOJ', 'user_buy': 'Milk', 'item_pieces': 2, 'price_per_unit': 150})
        shopping_cart.append({'customer_name': 'BOJ', 'user_buy': 'Eggs', 'item_pieces': 1, 'price_per_unit': 200})

        sub_total = (2 * 150) + (1 * 200)
        vat = sub_total * 0.075
        total = sub_total + vat

        self.assertAlmostEqual(total, 537.5, places=2)

    def test_that_checks_for_multiple_items_with_different_quantities(self):
        shopping_cart.append({'customer_name': 'Marvy', 'user_buy': 'Shoes', 'item_pieces': 3, 'price_per_unit': 1500})
        shopping_cart.append({'customer_name': 'Marvy', 'user_buy': 'Beans', 'item_pieces': 5, 'price_per_unit': 500})

        sub_total = (3 * 1500) + (5 * 500)
        discount = sub_total * 0.20
        vat = (sub_total - discount) * 0.075
        total = sub_total - discount + vat

        self.assertAlmostEqual(total, 6020.00, places=2)

    def test_that_checks_if_no_item_is_added(self):
        sub_total = 0
        discount = 0
        vat = 0
        total = 0

        self.assertAlmostEqual(total, 0, places=2)

    def test_that_checks_for_the_minimum_allowed_price(self):
        shopping_cart.append({'customer_name': 'Rose', 'user_buy': 'Pen', 'item_pieces': 1, 'price_per_unit': 100})

        sub_total = 100
        vat = sub_total * 0.075
        total = sub_total + vat

        self.assertAlmostEqual(total, 107.5, places=2)

    def test_that_check_if_the_amount_paid_is_lower_than_the_total_price(self):
        shopping_cart.append({'customer_name': 'David', 'user_buy': 'Laptop', 'item_pieces': 1, 'price_per_unit': 2000})
        sub_total = 2000
        discount = sub_total * 0.10
        new_amount = sub_total - discount
        vat = new_amount * 0.075
        final_amount = new_amount + vat

        amount_paid = final_amount - 1000
        self.assertTrue(amount_paid < final_amount)


