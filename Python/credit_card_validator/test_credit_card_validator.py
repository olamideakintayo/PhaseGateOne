# test_credit_card_validator.py

import unittest
from unittest import TestCase

from credit_card_validator import luhn_check, credit_card_validation

class TestCreditCardValidator(TestCase):
		
	def test_that_checks_for_a_valid_visa_card(self):
		credit_card_number = "4539148803436467"
		result = credit_card_validation(credit_card_number)
		
		
		self.assertTrue(result["valid"])