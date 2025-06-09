const prompt = require('prompt-sync')(); 

class CreditCardValidator {
    static CreditCardValidation(cardNumbers) {
        if (!Array.isArray(cardNumbers)) {
            return { valid: false, reason: "Input must be an array" };
        }

        if (cardNumbers.length < 13 || cardNumbers.length > 16) {
            return { valid: false, reason: "Invalid length" };
        }

        if (!cardNumbers.every(n => typeof n === 'number')) {
            return { valid: false, reason: "Card number must contain digits only please" };
        }

        const firstDigit = cardNumbers[0];
        let issuer = null;

        if (firstDigit === 4) {
            issuer = "Visa";
        } else if (firstDigit === 5) {
            issuer = "MasterCard";
        } else if (firstDigit === 6) {
            issuer = "Discover";
        } else if (firstDigit === 3 && cardNumbers[1] === 7) {
            issuer = "American Express";
        }

        if (!issuer) {
            return  { valid: false, reason: "Invalid issuer or length" };
        }

        const validLuhnNumber = CreditCardValidator.luhnCheck(cardNumbers);
        return {
            valid: validLuhnNumber,
            issuer,
            reason: validLuhnNumber ? "Passed Luhn check" : "Failed Luhn check"
        };
    }

    static luhnCheck(numbers) {
        let sum = 0;
        let doubleNumbers = false;

        for (let i = numbers.length - 1; i >= 0; i--) {
            let digit = numbers[i];

            if (doubleNumbers) {
                digit = digit * 2;
                if (digit > 9) digit -= 9;
            }

            sum += digit;
            doubleNumbers = !doubleNumbers;
        }

        return sum % 10 === 0;
    }
}


function main() {
    const userInput = prompt("Hello, Kindly Enter Card details to verify (digits only, no spaces): ");

    if (!/^\d+$/.test(userInput)) {
        console.log("Invalid input. Please enter digits only.");
        return;
    }

    const cardNumberArray = userInput.split('').map(Number);
    const result = CreditCardValidator.CreditCardValidation(cardNumberArray);

    console.log("\n*************************************");
    console.log(`**Credit Card Type : ${result.issuer || "Unknown"}`);
    console.log(`**Credit Card Number : ${userInput}`);
    console.log(`**Credit Card Digit Length : ${cardNumberArray.length}`);
    console.log(`**Credit Card Validity Status : ${result.valid ? "Valid" : "Invalid"}`);
    if (result.reason && !result.valid) {
        console.log(`Reason : ${result.reason}`);
    }
    console.log("*************************************\n");    
}

main();
