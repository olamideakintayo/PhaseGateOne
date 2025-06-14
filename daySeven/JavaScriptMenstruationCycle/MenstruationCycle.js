// MenstruationCycle.js

const { parseISO, format, addDays, subDays, differenceInDays, isBefore } = require('date-fns');
const prompt = require('prompt-sync')({ sigint: true });

class MenstruationCycle {
    static cycleDetails = [];

    constructor(name, previousPeriodDate, currentPeriodDate, periodDurationDays) {
        this.name = name;
        this.previousPeriodDate = previousPeriodDate;
        this.currentPeriodDate = currentPeriodDate;
        this.periodDurationDays = periodDurationDays;
    }

    getName() {
        return this.name;
    }

    showMenstrualCycle() {
        const periodCycleLength = differenceInDays(this.currentPeriodDate, this.previousPeriodDate);
        const ovulationDate = addDays(this.currentPeriodDate, periodCycleLength - 14);
        const fertileWindowStart = subDays(ovulationDate, 5);
        const fertileWindowEnd = addDays(ovulationDate, 1);
        const peakFertilePeriodStart = subDays(ovulationDate, 2);
        const peakFertilePeriodEnd = addDays(ovulationDate, 2);
        const safePeriodStart1 = this.currentPeriodDate;
        const safePeriodEnd1 = subDays(fertileWindowStart, 1);
        const safePeriodStart2 = addDays(fertileWindowEnd, 1);
        const safePeriodEnd2 = addDays(this.currentPeriodDate, periodCycleLength - 1);
        const pmsStart = addDays(this.currentPeriodDate, periodCycleLength - 10);
        const pmsEnd = addDays(this.currentPeriodDate, periodCycleLength - 1);
        const periodEndDate = addDays(this.currentPeriodDate, this.periodDurationDays - 1);

        console.log(`\n=== User Name ===: ${this.name}`);
        console.log("Here's a breakdown of your Menstrual Cycle");
        console.log(`Your Cycle length is: ${periodCycleLength} days`);

        if (periodCycleLength >= 21 && periodCycleLength <= 35) {
            console.log("Your Period Cycle is within the normal range (21-35 days).");
            console.log("Here is your next 5 predicted period dates for the next 5 months:");

            let nextPeriodDate = this.currentPeriodDate;
            for (let i = 1; i <= 5; i++) {
                console.log(`Period ${i}: ${format(nextPeriodDate, 'yyyy-MM-dd')}`);
                nextPeriodDate = addDays(nextPeriodDate, periodCycleLength);
            }
        } else {
            console.log("Your Cycle is outside the normal range.");
        }

        console.log(`Your Ovulation date is: ${format(ovulationDate, 'yyyy-MM-dd')}`);
        console.log(`Your Fertility Window (full): ${format(fertileWindowStart, 'yyyy-MM-dd')} to ${format(fertileWindowEnd, 'yyyy-MM-dd')}`);
        console.log(`Peak Fertility Days (most fertile): ${format(peakFertilePeriodStart, 'yyyy-MM-dd')} to ${format(peakFertilePeriodEnd, 'yyyy-MM-dd')}`);
        console.log(`Your Safe period before the start of your Fertile Window is: ${format(safePeriodStart1, 'yyyy-MM-dd')} to ${format(safePeriodEnd1, 'yyyy-MM-dd')}`);
        console.log(`Your Safe period after the end of your Fertile Window is: ${format(safePeriodStart2, 'yyyy-MM-dd')} to ${format(safePeriodEnd2, 'yyyy-MM-dd')}`);
        console.log(`PMS days are likely to begin between: ${format(pmsStart, 'yyyy-MM-dd')} to ${format(pmsEnd, 'yyyy-MM-dd')}`);
        console.log(`Your period will likely last: ${format(this.currentPeriodDate, 'yyyy-MM-dd')} to ${format(periodEndDate, 'yyyy-MM-dd')}`);
        console.log(`Your Estimated period duration is: ${this.periodDurationDays} days`);
    }

    static addUserDetails() {
        let name;

        while (true) {
            name = prompt("Please Enter your Name: ").trim();

            const duplicate = this.cycleDetails.find(u => u.name.toLowerCase() === name.toLowerCase());
            if (!duplicate) break;
            console.log(`Error: User with the name '${name}' already exists. Please enter a different name.`);
        }

        let previousPeriodDate, currentPeriodDate, periodDurationDays;

        while (true) {
            try {
                previousPeriodDate = parseISO(prompt("Enter your previous period date (YYYY-MM-DD): ").trim());
                if (isNaN(previousPeriodDate)) throw new Error();
                break;
            } catch {
                console.log("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (true) {
            try {
                currentPeriodDate = parseISO(prompt("Enter your current period date (YYYY-MM-DD): ").trim());
                if (isNaN(currentPeriodDate)) throw new Error();
                if (isBefore(currentPeriodDate, previousPeriodDate)) {
                    console.log("Error: Current date must be after the previous date.");
                    continue;
                }
                break;
            } catch {
                console.log("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (true) {
            try {
                periodDurationDays = parseInt(prompt("Enter your typical period duration (in days): ").trim());
                if (isNaN(periodDurationDays)) throw new Error();
                break;
            } catch {
                console.log("Invalid input for period duration. Please enter a valid number.");
            }
        }

        this.cycleDetails.push(new MenstruationCycle(name, previousPeriodDate, currentPeriodDate, periodDurationDays));
        console.log("Your details are currently being analyzed!! Please check on the View Menstruation Summary Section to view the summary of your Cycle.");
    }

    static viewMenstrualSummary() {
        if (this.cycleDetails.length === 0) {
            console.log("There are no Menstrual Records available.");
            return;
        }

        this.cycleDetails.forEach((user, index) => {
            console.log(`\nUser ${index + 1}`);
            user.showMenstrualCycle();
        });
    }

    static updateMenstruationCycle() {
        if (this.cycleDetails.length === 0) {
            console.log("There are no user records to update.");
            return;
        }

        const indexName = prompt("Please Enter the user name to update Menstrual Summary: ").trim();
        const foundUser = this.cycleDetails.find(user => user.getName().toLowerCase() === indexName.toLowerCase());

        if (!foundUser) {
            console.log("User not found");
            return;
        }

        while (true) {
            try {
                foundUser.previousPeriodDate = parseISO(prompt("Enter the new previous period date (YYYY-MM-DD): ").trim());
                if (isNaN(foundUser.previousPeriodDate)) throw new Error();
                break;
            } catch {
                console.log("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (true) {
            try {
                const newCurrentDate = parseISO(prompt("Enter the new current period date (YYYY-MM-DD): ").trim());
                if (isNaN(newCurrentDate)) throw new Error();
                if (isBefore(newCurrentDate, foundUser.previousPeriodDate)) {
                    console.log("Error: Current date must be after the previous date.");
                    continue;
                }
                foundUser.currentPeriodDate = newCurrentDate;
                break;
            } catch {
                console.log("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (true) {
            try {
                foundUser.periodDurationDays = parseInt(prompt("Enter the new typical period duration (in days): ").trim());
                if (isNaN(foundUser.periodDurationDays)) throw new Error();
                break;
            } catch {
                console.log("Invalid input for period duration. Please enter a valid number.");
            }
        }

        console.log("The User Menstrual Summary has been updated!!");
    }
}

module.exports = MenstruationCycle;
