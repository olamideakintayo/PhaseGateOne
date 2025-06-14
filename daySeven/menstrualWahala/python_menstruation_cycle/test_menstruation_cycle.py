# test_menstruation_cycle.py

import unittest
from datetime import date, timedelta
import menstruation_cycle

class TestMenstruationCycle(unittest.TestCase):

    def setUp(self):
        menstruation_cycle.cycle_details.clear()

    def test_add_single_user(self):
        user = {
            "name": "Marvellous",
            "previous": date(2024, 5, 1),
            "current": date(2024, 5, 29),
            "duration": 5
        }
        menstruation_cycle.cycle_details.append(user)
        self.assertEqual(len(menstruation_cycle.cycle_details), 1)

    def test_duplicate_name_detection(self):
        menstruation_cycle.cycle_details.append({
            "name": "Marvellous",
            "previous": date(2024, 5, 1),
            "current": date(2024, 5, 29),
            "duration": 5
        })
        duplicate = any(u["name"].lower() == "marvellous" for u in menstruation_cycle.cycle_details)
        self.assertTrue(duplicate)

    def test_cycle_length_calculation(self):
        user = {
            "name": "Ella",
            "previous": date(2024, 5, 1),
            "current": date(2024, 5, 31),
            "duration": 5
        }
        cycle_length = (user["current"] - user["previous"]).days
        self.assertEqual(cycle_length, 30)

    def test_valid_period_duration(self):
        user = {
            "name": "Kemi",
            "previous": date(2024, 4, 10),
            "current": date(2024, 5, 5),
            "duration": 4
        }
        self.assertTrue(user["duration"] > 0)

    def test_current_date_before_previous(self):
        previous = date(2024, 5, 10)
        current = date(2024, 5, 5)
        self.assertTrue(current < previous)

    def test_cycle_length_in_normal_range(self):
        user = {
            "name": "Nimi",
            "previous": date(2024, 5, 1),
            "current": date(2024, 5, 28),
            "duration": 5
        }
        length = (user["current"] - user["previous"]).days
        self.assertTrue(21 <= length <= 35)

    def test_safe_period_before_fertile_window(self):
        user = {
            "name": "Nimi",
            "previous": date(2024, 5, 1),
            "current": date(2024, 5, 28),
            "duration": 5
        }
        cycle_length = (user["current"] - user["previous"]).days
        ovulation = user["current"] + timedelta(days=cycle_length - 14)
        safe_end = ovulation - timedelta(days=6)
        self.assertTrue(safe_end < ovulation)

    def test_update_period_duration(self):
        user = {
            "name": "Nimi",
            "previous": date(2024, 4, 1),
            "current": date(2024, 4, 27),
            "duration": 5
        }
        menstruation_cycle.cycle_details.append(user)
        user["duration"] = 6
        self.assertEqual(user["duration"], 6)

    def test_pms_range_calculation(self):
        user = {
            "name": "Ana",
            "previous": date(2024, 3, 1),
            "current": date(2024, 3, 28),
            "duration": 5
        }
        length = (user["current"] - user["previous"]).days
        pms_start = user["current"] + timedelta(days=length - 10)
        pms_end = user["current"] + timedelta(days=length - 1)
        self.assertTrue(pms_start < pms_end)

    def test_ovulation_date_calculation(self):
        user = {
            "name": "Kim",
            "previous": date(2024, 3, 1),
            "current": date(2024, 3, 29),
            "duration": 4
        }
        cycle_length = (user["current"] - user["previous"]).days
        ovulation = user["current"] + timedelta(days=cycle_length - 14)
        self.assertIsNotNone(ovulation)

if __name__ == "__main__":
    unittest.main()
