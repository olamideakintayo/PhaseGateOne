import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class MenstruationCycle {
    static Scanner input = new Scanner(System.in);
    static ArrayList<MenstruationCycle> cycleDetails = new ArrayList<>();

    String name;
    LocalDate previousPeriodDate;
    LocalDate currentPeriodDate;
    int periodDurationDays;

    public MenstruationCycle(String name, LocalDate previousPeriodDate, LocalDate currentPeriodDate, int periodDurationDays) {
        this.name = name;
        this.previousPeriodDate = previousPeriodDate;
        this.currentPeriodDate = currentPeriodDate;
        this.periodDurationDays = periodDurationDays;
    }

    public String getName() {
        return name;
    }
    
    public void showMenstrualCycle() {
        long periodCycleLength = ChronoUnit.DAYS.between(previousPeriodDate, currentPeriodDate);

        LocalDate ovulationDate = currentPeriodDate.plusDays(periodCycleLength - 14);
        LocalDate fertileWindowStart = ovulationDate.minusDays(5);
        LocalDate fertileWindowEnd = ovulationDate.plusDays(1);

        LocalDate peakFertilePeriodStart = ovulationDate.minusDays(2);
        LocalDate peakFertilePeriodEnd = ovulationDate.plusDays(2);

        LocalDate safePeriodStart1 = currentPeriodDate;
        LocalDate safePeriodEnd1 = fertileWindowStart.minusDays(1);

        LocalDate safePeriodStart2 = fertileWindowEnd.plusDays(1);
        LocalDate safePeriodEnd2 = currentPeriodDate.plusDays(periodCycleLength - 1);

        LocalDate pmsStart = currentPeriodDate.plusDays(periodCycleLength - 10);
        LocalDate pmsEnd = currentPeriodDate.plusDays(periodCycleLength - 1);

        LocalDate periodEndDate = currentPeriodDate.plusDays(periodDurationDays - 1);

        System.out.println("\n=== User Name ===: " + name);
        System.out.println("Here's a breakdown of your Menstrual Cycle");
        System.out.println("Your Cycle length is: " + periodCycleLength + " days");

        if (periodCycleLength >= 21 && periodCycleLength <= 35) {
            System.out.println("Your Period Cycle is within the normal range (21-35 days).");
            System.out.println("Here is your next 5 predicted period dates for the next 5 months:");

            LocalDate nextPeriodDate = currentPeriodDate;
            for (int i = 1; i <= 5; i++) {
                System.out.println("Period " + i + ": " + nextPeriodDate);
                nextPeriodDate = nextPeriodDate.plusDays(periodCycleLength);
            }
        } else {
            System.out.println("Your Cycle is outside the normal range.");
        }

        System.out.println("Your Ovulation date is: " + ovulationDate);
        System.out.println("Your Fertility Window (full): " + fertileWindowStart + " to " + fertileWindowEnd);
        System.out.println("Peak Fertility Days (most fertile): " + peakFertilePeriodStart + " to " + peakFertilePeriodEnd);
        System.out.println("Your Safe period before the start of your Fertile Window is: " + safePeriodStart1 + " to " + safePeriodEnd1);
        System.out.println("Your Safe period after the end of your Fertile Window is: " + safePeriodStart2 + " to " + safePeriodEnd2);
        System.out.println("PMS days are likely to begin between: " + pmsStart + " to " + pmsEnd);
        System.out.println("Your period will likely last: " + currentPeriodDate + " to " + periodEndDate);
        System.out.println("Your Estimated period duration is: " + periodDurationDays + " days");
    }

    public static void addUserDetails() {
        String name;

        while (true) {
            System.out.print("Please Enter your Name: ");
            name = input.nextLine().trim();

            boolean duplicateName = false;
            for (MenstruationCycle user : cycleDetails) {
                if (user.name.equalsIgnoreCase(name)) {
                    System.out.println("Error: User with the name '" + name + "' already exists. Please enter a different name.");
                    duplicateName = true;
                    break;
                }
            }

            if (!duplicateName) break;
        }

        LocalDate previousPeriodDate = null;
        LocalDate currentPeriodDate = null;
        int periodDurationDays = 0;

        while (true) {
            try {
                System.out.print("Enter your previous period date (YYYY-MM-DD): ");
                previousPeriodDate = LocalDate.parse(input.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter your current period date (YYYY-MM-DD): ");
                currentPeriodDate = LocalDate.parse(input.nextLine());

                if (currentPeriodDate.isBefore(previousPeriodDate)) {
                    System.out.println("Error: Current date must be after the previous date.");
                    continue;
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter your typical period duration (in days): ");
                periodDurationDays = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for period duration. Please enter a valid number.");
            }
        }

        cycleDetails.add(new MenstruationCycle(name, previousPeriodDate, currentPeriodDate, periodDurationDays));
        System.out.println("Your details are currently being analyzed!! Please check on the View Menstruation Summary Section to view the summary of your Cycle.");
    }
    
    public static void viewMenstrualSummary() {
        if (cycleDetails.isEmpty()) {
            System.out.println("There are no Menstrual Records available.");
            return;
        }
        
        for (int i = 0; i < cycleDetails.size(); i++) {
            System.out.println("\nUser " + (i + 1));
            cycleDetails.get(i).showMenstrualCycle();
        }
    }
        
    public static void updateMenstruationCycle() {
        if (cycleDetails.isEmpty()) {
            System.out.println("There are no user records to update.");
            return;
        }
        
        System.out.print("Please Enter the user name to update Menstrual Summary: ");
        String indexName = input.nextLine().trim();
        
        MenstruationCycle foundUser = null;
        for(MenstruationCycle user : cycleDetails) {
            if(user.getName().equalsIgnoreCase(indexName)) {
                foundUser = user;
                break;
            }
        }
        
        if (foundUser == null) {
            System.out.println("User not found");
            return;
        }
        
        while (true) {
            try {
                System.out.print("Enter the new previous period date (YYYY-MM-DD): ");
                foundUser.previousPeriodDate = LocalDate.parse(input.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Enter the new current period date (YYYY-MM-DD): ");
                LocalDate newCurrentDate = LocalDate.parse(input.nextLine());
                if (newCurrentDate.isBefore(foundUser.previousPeriodDate)) {
                    System.out.println("Error: Current date must be after the previous date.");
                    continue;
                }
                foundUser.currentPeriodDate = newCurrentDate;
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Enter the new typical period duration (in days): ");
                foundUser.periodDurationDays = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for period duration. Please enter a valid number.");
            }
        }
        
        System.out.println("The User Menstrual Summary has been updated!!");
    }
}
