package day02.gradecalculator;
import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of subjects: ");
		int n = sc.nextInt();
		
		double[] marks = new double[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("Enter marks for subject " + (i + 1) + ": ");
			marks[i] = sc.nextDouble();
			
			if (marks[i] < 0 || marks[i] > 100) {
				System.out.println("Invalid marks! Please enter marks between 0 and 100.");
				i--;
			}
		}
		double total = calculateTotal(marks);
		double percentage = calculatePercentage(total, n);
		char grade = calculateGrade(percentage);
		
		System.out.println("\n--------- Result ----------");
		System.out.println("Total Marks: " + total);
		System.out.println("Percentage: " + percentage + "%");
		System.out.println("Grade: " + grade);
		
		sc.close();
	}
	public static double calculateTotal(double[] marks) {
		double total = 0;
		
		for (double mark : marks) {
			total += mark;
		}
		return total;
	}
	public static double calculatePercentage(double total, int numberOfSubjects) {
		return total / numberOfSubjects;
	}
	public static char calculateGrade(double percentage) {
		if(percentage >= 90) {
			return 'A';
		} else if(percentage >= 80) {
			return 'B';
		} else if(percentage >= 70) {
			return 'C';
		} else if(percentage >= 60) {
			return 'D';
		} else if(percentage >= 50) {
			return 'E';
		} else {
			return 'F';
		}
	}

}
