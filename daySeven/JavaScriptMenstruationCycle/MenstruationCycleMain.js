// MenstruationCycleMain.js
const prompt = require('prompt-sync')({ sigint: true });
const MenstruationCycle = require('./menstruationCycle');

function menstruationCycleMain() {
    let userInput;

    do {
        console.log("\n===========================================");
        console.log("      Welcome to Menstruation Cycle Tracker");
        console.log("===========================================");
        console.log("  1. Add User Details");
        console.log("  2. View Menstrual Summary");
        console.log("  3. Update Menstruation Cycle");
        console.log("  4. Exit");
        console.log("===========================================");
        userInput = parseInt(prompt("Please enter your choice (1-4): ").trim());

        switch (userInput) {
            case 1:
                MenstruationCycle.addUserDetails();
                break;
            case 2:
                MenstruationCycle.viewMenstrualSummary();
                break;
            case 3:
                MenstruationCycle.updateMenstruationCycle();
                break;
            case 4:
                console.log("GoodBye!! Have a nice day!");
                break;
            default:
                console.log("Invalid Option. Please try again.");
                break;
        }

    } while (userInput !== 4);
}

menstruationCycleMain();
