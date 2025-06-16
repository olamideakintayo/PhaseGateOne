import unittest
import phone_book

class TestPhoneBook(unittest.TestCase):

    def setUp(self):
        phone_book.numbers = []

    def test_that_adds_a_single_contact(self):
        contact = {
            'first_name': 'Olamide',
            'last_name': 'Akintayo',
            'phone_number': '09032592825'
        }
        phone_book.numbers.append(contact)
        self.assertEqual(len(phone_book.numbers), 1)

    def test_that_adds_multiple_contacts(self):
        contact1 = {
            'first_name': 'Olamide',
            'last_name': 'Akintayo',
            'phone_number': '09032592825'
        }
        contact2 = {
            'first_name': 'Dominion',
            'last_name': 'Akintayo',
            'phone_number': '08033149859'
        }
        phone_book.numbers.append(contact1)
        phone_book.numbers.append(contact2)
        self.assertEqual(len(phone_book.numbers), 2)

    def test_that_checks_if_first_name_exists(self):
        contact = {
            'first_name': 'Ella',
            'last_name': 'Akintayo',
            'phone_number': '08141511541'
        }
        phone_book.numbers.append(contact)
        found = False
        for contact_item in phone_book.numbers:
            if contact_item['first_name'].lower() == 'ella':
                found = True
                break
        self.assertTrue(found)

    def test_that_checks_if_last_name_exists(self):
        contact = {
            'first_name': 'Dominion',
            'last_name': 'Akintayo',
            'phone_number': '08033149859'
        }
        phone_book.numbers.append(contact)
        found = False
        for contact_item in phone_book.numbers:
            if contact_item['last_name'].lower() == 'akintayo':
                found = True
                break
        self.assertTrue(found)

    def test_that_checks_if_phone_number_exists(self):
        contact = {
            'first_name': 'Olamide',
            'last_name': 'Akintayo',
            'phone_number': '09032592825'
        }
        phone_book.numbers.append(contact)
        found = False
        for contact_item in phone_book.numbers:
            if contact_item['phone_number'] == '09032592825':
                found = True
                break
        self.assertTrue(found)

    def test_that_removes_contact_by_phone_number(self):
        contact = {
            'first_name': 'Dominion',
            'last_name': 'Akintayo',
            'phone_number': '08033149859'
        }
        phone_book.numbers.append(contact)

        for i, contact_item in enumerate(phone_book.numbers):
            if contact_item['phone_number'] == '08033149859':
                del phone_book.numbers[i]
                break

        self.assertEqual(len(phone_book.numbers), 0)

    def test_that_removes_non_existing_contact(self):
        contact = {
            'first_name': 'Ella',
            'last_name': 'Akintayo',
            'phone_number': '08141511541'
        }
        phone_book.numbers.append(contact)

        for i, contact_item in enumerate(phone_book.numbers):
            if contact_item['phone_number'] == '00000000000':
                del phone_book.numbers[i]
                break

        self.assertEqual(len(phone_book.numbers), 1)

    def test_that_finds_a_contact_by_first_name(self):
        contact = {
            'first_name': 'Ella',
            'last_name': 'Akintayo',
            'phone_number': '08141511541'
        }
        phone_book.numbers.append(contact)

        found_contact = None
        for contact_item in phone_book.numbers:
            if contact_item['first_name'].lower() == 'ella':
                found_contact = contact_item
                break

        self.assertIsNotNone(found_contact)
        self.assertEqual(found_contact['last_name'], 'Akintayo')

    def test_that_finds_a_contact_by_phone_number(self):
        contact = {
            'first_name': 'Olamide',
            'last_name': 'Akintayo',
            'phone_number': '09032592825'
        }
        phone_book.numbers.append(contact)

        found_contact = None
        for contact_item in phone_book.numbers:
            if contact_item['phone_number'] == '09032592825':
                found_contact = contact_item
                break

        self.assertIsNotNone(found_contact)
        self.assertEqual(found_contact['first_name'], 'Olamide')

    def test_that_check_if_the_list_is_empty_initially(self):
        self.assertTrue(len(phone_book.numbers) == 0)

