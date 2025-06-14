// StudentGrade.java

import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentGrade {

    public static void addingStudentsDetails() {
        Scanner input = new Scanner(System.in);

        System.out.println("How many Students do you have?");
        int studentsSize = 0;
        while (true) {
            try {
                studentsSize = input.nextInt();
                if (studentsSize <= 0) {
                    System.out.println("Please enter a positive number of students.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer value.");
                input.next();
            }
        }

        System.out.println("How many Subjects do they offer?");
        int subjectsSize = 0;
        while (true) {
            try {
                subjectsSize = input.nextInt();
                if (subjectsSize <= 0) {
                    System.out.println("Please enter a positive number of subjects.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer value.");
                input.next();
            }
        }

        int[][] studentsInfo = new int[studentsSize][subjectsSize];
        int[] totalScores = new int[studentsSize];
        double[] averageScores = new double[studentsSize];
		int[] position = new int[studentsSize];
		
        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved Successfully");

        for (int i = 0; i < studentsSize; i++) {
            System.out.println("\nEntering Scores for Student " + (i + 1) + ": ");
            int total = 0;
            for (int j = 0; j < subjectsSize; j++) {
                while (true) {
                    try {
                        System.out.print("Enter score for Subject " + (j + 1) + ": ");
                        int score = input.nextInt();
                        if (score < 0 || score > 100) {
                            System.out.println("Invalid score! Please enter a score between 0 and 100.");
                            continue;
                        }
                        studentsInfo[i][j] = score;
                        total += score;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a score between 0 and 100.");
                        
                    }
                }
            }
            totalScores[i] = total;
            averageScores[i] = (double) total / subjectsSize;
            for ( int pos = 0; pos < position.length; pos++) {
            	System.out.printf("%d", position[pos]);
            }
        }

        System.out.println("\n======================================================================================");
        System.out.printf("%-10s", "STUDENT");
        for (int j = 0; j < subjectsSize; j++) {
            System.out.printf("%7s", "SUB" + (j + 1));
        }
        System.out.printf("%7s%7s%n", "TOT", "AVE", "POS");
        System.out.println("======================================================================================");

        for (int i = 0; i < studentsSize; i++) {
            System.out.printf("%-10s", "Student " + (i + 1));
            for (int j = 0; j < subjectsSize; j++) {
                System.out.printf("%7d", studentsInfo[i][j]);
            }
            System.out.printf("%7d%7.2f%n", totalScores[i], averageScores[i], position[i]);
        }
        System.out.println("======================================================================================");
        System.out.println("======================================================================================");
	
	
	 System.out.println("SUBJECT SUMMARY");
    }

    public static void main(String[] args) {
        addingStudentsDetails();
    }
}
