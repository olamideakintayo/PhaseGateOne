# test_credit_card_validator.py

import unittest
from unittest import TestCase

from credit_card_validator import luhn_check, credit_card_validation

class TestCreditCardValidator(TestCase):
		
	def test_that_checks_for_a_valid_visa_card(self):
		credit_card_number = "4539148803436467"
		result = credit_card_validation(credit_card_number)
		
		
		self.assertTrue(result["valid"])
		self.assertEqual(result["issuer"], "Visa")
		self.assertEqual(result["reason"], "Passed Luhn check")
		
		
	def test_that_checks_for_invalid_credit_card_number(self):
		credit_card_number = "1234567890123456"
		result = credit_card_validation(credit_card_number)
		
		self.assertFalse(result["valid"])
		self.assertEqual(result["reason"], "Invalid issuer or length")
		
	def test_that_checks_if_the_credit_card_number_passes_the_luhn_check(self):
		self.assertTrue(luhn_check("4539148803436467"))
		
	def test_that_checks_if_the_credit_card_fails_the_luhn_check(self):
		self.assertFalse(luhn_check("4539144803436461"))
		
	def test_that_checks_for_a_valid_mastercard_card(self):
		credit_card_number = "5555555555554444" 
		result = credit_card_validation(credit_card_number)
		
		self.assertTrue(result["valid"])
		self.assertEqual(result["issuer"], "MasterCard")
		self.assertEqual(result["reason"], "Passed Luhn check")
		
	def test_that_checks_for_a_valid_discovery_card(self):
		credit_card_number = "378282246310005"
		result = credit_card_validation(credit_card_number)
		
		self.assertTrue(result["valid"])
		self.assertEqual(result["issuer"], "American Express")
		self.assertEqual(result["reason"], "Passed Luhn check")
