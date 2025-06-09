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