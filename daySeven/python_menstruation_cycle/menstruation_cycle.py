# menstruation_cycle.py

from datetime import datetime, timedelta

cycle_details = []

def parse_date(prompt_text):
    while True:
        try:
            return datetime.strptime(input(prompt_text).strip(), "%Y-%m-%d").date()
        except ValueError:
            print("Invalid date format. Please use YYYY-MM-DD.")

def add_user_details():
    while True:
        name = input("Please Enter your Name: ").strip()
        if any(user["name"].lower() == name.lower() for user in cycle_details):
            print(f"Error: User with the name '{name}' already exists. Please enter a different name.")
        else:
            break

    previous_period_date = parse_date("Enter your previous period date (YYYY-MM-DD): ")
    
    while True:
        current_period_date = parse_date("Enter your current period date (YYYY-MM-DD): ")
        if current_period_date < previous_period_date:
            print("Error: Current date must be after the previous date.")
        else:
            break

    while True:
        try:
            period_duration_days = int(input("Enter your typical period duration (in days): ").strip())
            break
        except ValueError:
            print("Invalid input for period duration. Please enter a valid number.")

    cycle_details.append({
        "name": name,
        "previous": previous_period_date,
        "current": current_period_date,
        "duration": period_duration_days
    })

    print("Your details are currently being analyzed!! Please check on the View Menstruation Summary Section to view the summary of your Cycle.")

def show_menstrual_cycle(user):
    name = user["name"]
    previous = user["previous"]
    current = user["current"]
    duration = user["duration"]

    period_cycle_length = (current - previous).days

    ovulation_date = current + timedelta(days=period_cycle_length - 14)
    fertile_window_start = ovulation_date - timedelta(days=5)
    fertile_window_end = ovulation_date + timedelta(days=1)
    peak_fertile_start = ovulation_date - timedelta(days=2)
    peak_fertile_end = ovulation_date + timedelta(days=2)
    safe_period1_start = current
    safe_period1_end = fertile_window_start - timedelta(days=1)
    safe_period2_start = fertile_window_end + timedelta(days=1)
    safe_period2_end = current + timedelta(days=period_cycle_length - 1)
    pms_start = current + timedelta(days=period_cycle_length - 10)
    pms_end = current + timedelta(days=period_cycle_length - 1)
    period_end = current + timedelta(days=duration - 1)

    print(f"\n=== User Name ===: {name}")
    print("Here's a breakdown of your Menstrual Cycle")
    print(f"Your Cycle length is: {period_cycle_length} days")

    if 21 <= period_cycle_length <= 35:
        print("Your Period Cycle is within the normal range (21-35 days).")
        print("Here is your next 5 predicted period dates for the next 5 months:")
        next_period = current
        for i in range(1, 6):
            print(f"Period {i}: {next_period}")
            next_period += timedelta(days=period_cycle_length)
    else:
        print("Your Cycle is outside the normal range.")

    print(f"Your Ovulation date is: {ovulation_date}")
    print(f"Your Fertility Window (full): {fertile_window_start} to {fertile_window_end}")
    print(f"Peak Fertility Days (most fertile): {peak_fertile_start} to {peak_fertile_end}")
    print(f"Your Safe period before the start of your Fertile Window is: {safe_period1_start} to {safe_period1_end}")
    print(f"Your Safe period after the end of your Fertile Window is: {safe_period2_start} to {safe_period2_end}")
    print(f"PMS days are likely to begin between: {pms_start} to {pms_end}")
    print(f"Your period will likely last: {current} to {period_end}")
    print(f"Your Estimated period duration is: {duration} days")

def view_menstrual_summary():
    if not cycle_details:
        print("There are no Menstrual Records available.")
        return
    for i, user in enumerate(cycle_details, start=1):
        print(f"\nUser {i}")
        show_menstrual_cycle(user)

def update_menstruation_cycle():
    if not cycle_details:
        print("There are no user records to update.")
        return

    index_name = input("Please Enter the user name to update Menstrual Summary: ").strip().lower()

    found_user = None
    for user in cycle_details:
        if user["name"].lower() == index_name:
            found_user = user
            break

    if not found_user:
        print("User not found")
        return

    found_user["previous"] = parse_date("Enter the new previous period date (YYYY-MM-DD): ")

    while True:
        new_current = parse_date("Enter the new current period date (YYYY-MM-DD): ")
        if new_current < found_user["previous"]:
            print("Error: Current date must be after the previous date.")
        else:
            found_user["current"] = new_current
            break

    while True:
        try:
            found_user["duration"] = int(input("Enter the new typical period duration (in days): ").strip())
            break
        except ValueError:
            print("Invalid input for period duration. Please enter a valid number.")

    print("The User Menstrual Summary has been updated!!")
