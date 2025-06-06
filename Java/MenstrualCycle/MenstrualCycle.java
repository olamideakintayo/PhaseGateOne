import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Menstruation {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Menstruation> cycleDetails = new ArrayList<>();

    String name;
    LocalDate previousPeriodDate;
    LocalDate currentPeriodDate;
    int periodDurationDays;

    public Menstruation(String name, LocalDate previousPeriodDate, LocalDate currentPeriodDate, int periodDurationDays) {
        this.name = name;
        this.previousPeriodDate = previousPeriodDate;
        this.currentPeriodDate = currentPeriodDate;
        this.periodDurationDays = periodDurationDays;
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
            for (Menstruation user : cycleDetails) {
                if (user.name.equalsIgnoreCase(name)) {
                    System.out.println("Error: User with the name '" + name + "' already exists. Please enter a different name.");
                    duplicateName = true;
                    break;
                }
            }

            if (!duplicateName) break;
        }

        try {
            System.out.print("Enter your previous period date (YYYY-MM-DD): ");
            LocalDate previousPeriodDate = LocalDate.parse(input.nextLine());

            System.out.print("Enter your current period date (YYYY-MM-DD): ");
            LocalDate currentPeriodDate = LocalDate.parse(input.nextLine());

            if (currentPeriodDate.isBefore(previousPeriodDate)) {
                System.out.println("Error: Current date must be after the previous date.");
                return;
            }

            System.out.print("Enter your typical period duration (in days): ");
            int periodDurationDays = Integer.parseInt(input.nextLine());

            cycleDetails.add(new Menstruation(name, previousPeriodDate, currentPeriodDate, periodDurationDays));
            System.out.println("Your details are currently being analyzed!! Please check on the View Menstruation Summary Section to view the summary of your Cycle.");

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for period duration. Please enter a valid number.");
        }
    }

 }
