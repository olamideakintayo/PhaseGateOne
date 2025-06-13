// StudentGrade.java

import java.util.Scanner;

public class StudentGrade {

	public static void addingStudents() {
	Scanner input = new Scanner(System.in);
	
	System.out.println("How many Students do you have ? ");
	int studentSize = input.nextInt();
	
	System.out.println("How many Subjects do they offer? ");
	int subjectSize = input.nextInt();
	
	int[][] studentsInfo = new int [studentSize] [subjectSize];
	
	System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println("Saved Successfully");
}

	public static void main(String[] args) {
	addingStudents();
	}
}