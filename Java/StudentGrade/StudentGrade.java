// StudentGrade.java

import java.util.Scanner;

public class StudentGrade {

    public static void addingStudentsDetails() {
        Scanner input = new Scanner(System.in);

        System.out.println("How many Students do you have?");
        int studentsSize = input.nextInt();

        System.out.println("How many Subjects do they offer?");
        int subjectsSize = input.nextInt();

        int[][] studentsInfo = new int[studentsSize][subjectsSize];
        int[] totalScores = new int[studentsSize];
        double[] averageScores = new double[studentsSize];

        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved Successfully");

        for (int i = 0; i < studentsSize; i++) {
            System.out.println("Entering Scores for Student " + (i + 1) + ": ");
            int total = 0;
            for (int j = 0; j < subjectsSize; j++) {
                System.out.print("Enter score for Subject " + (j + 1) + ": ");
                studentsInfo[i][j] = input.nextInt();
                total += studentsInfo[i][j];
            }
            totalScores[i] = total;
            averageScores[i] = (double) total / subjectsSize;
        }
		System.out.println("\n======================================================================================");
        System.out.printf("%-10s", "STUDENT");
        for (int j = 0; j < subjectsSize; j++) {
            System.out.printf("%7s", "SUB" + (j + 1));
        }
        System.out.printf("%7s%7s%n", "TOT", "AVE");
        System.out.println("======================================================================================");
        
        for (int i = 0; i < studentsSize; i++) {
            System.out.printf("%-10s", "Student " + (i + 1));
            for (int j = 0; j < subjectsSize; j++) {
                System.out.printf("%7d", studentsInfo[i][j]);
            }
            System.out.printf("%7d%7.2f%n", totalScores[i], averageScores[i]);
           
        }
          System.out.println("\n======================================================================================");
            System.out.println("======================================================================================");


    }

    public static void main(String[] args) {
        addingStudentsDetails();
    }
}
