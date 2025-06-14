# credit_card_validator.py
def luhn_check(numbers):
    sum_ = 0
    double_digit = False

    for i in range(len(numbers) - 1, -1, -1):
        digit = int(numbers[i])
        if double_digit:
            digit *= 2
            if digit > 9:
                digit -= 9
        sum_ += digit
        double_digit = not double_digit

    return sum_ % 10 == 0

def credit_card_validation(numbers):
    length = len(numbers)

    if length < 13 or length > 16:
        return {"valid": False, "reason": "Invalid length"}

    if not numbers.isdigit():
        return {"valid": False, "reason": "Card number must contain digits only please"}

    first_digit = numbers[0]
    issuer = None

    if first_digit == '4':
        issuer = "Visa"
    elif first_digit == '5':
        issuer = "MasterCard"
    elif first_digit == '6':
        issuer = "Discover"
    elif first_digit == '3' and length > 1 and numbers[1] == '7':
        issuer = "American Express"

    if not issuer:
        return {"valid": False, "reason": "Invalid issuer or length"}

    valid_luhn_number = luhn_check(numbers)

    return {
        "valid": valid_luhn_number,
        "issuer": issuer,
        "reason": "Passed Luhn check" if valid_luhn_number else "Failed Luhn check"
    }

def main():
    user_input = input("Hello, Kindly Enter Card details to verify (digits only, no spaces): ")

    if not user_input.isdigit():
        print("Invalid input. Please enter digits only.")
        return

    result = credit_card_validation(user_input)

    print("\n*************************************")
    print(f"**Credit Card Type : {result.get('issuer', 'Unknown')}")
    print(f"**Credit Card Number : {user_input}")
    print(f"**Credit Card Digit Length : {len(user_input)}")
    print(f"**Credit Card Validity Status : {'Valid' if result['valid'] else 'Invalid'}")
    if not result["valid"] and "reason" in result:
        print(f"Reason : {result['reason']}")
    print("*************************************\n")

if __name__ == "__main__":
    main()
