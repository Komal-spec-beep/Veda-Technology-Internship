package day32.studentgrademanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // Sample Student Records
        students.add(new Student(1, "Astha", "Cloud Computing", 50));
        students.add(new Student(2, "Sahil", "Software Testing", 40));
        students.add(new Student(3, "Srishti", "Java", 55));

        int choice;

        do {
            System.out.println("\n====== STUDENT GRADE MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Total Marks and Percentage");
            System.out.println("7. Generate Performance Summary");
            System.out.println("8. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    calculateResults();
                    break;

                case 7:
                    performanceSummary();
                    break;

                case 8:
                    System.out.println("Thank you for using Student Grade Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }

    // Add Student
    public static void addStudent() {

        System.out.println("\n====== ADD STUDENT ======");

        int id = readInt("Enter Student ID: ");

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        String name = readText("Enter Student Name: ");
        String subject = readText("Enter Subject: ");
        double marks = readMarks("Enter Marks (0-100): ");

        Student student = new Student(id, name, subject, marks);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Display All Students
    public static void displayStudents() {

        System.out.println("\n====== STUDENT RECORDS ======");

        if (students.isEmpty()) {
            System.out.println("No student records available!");
            return;
        }

        for (Student student : students) {
            displayStudentDetails(student);
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.println("\n====== SEARCH STUDENT ======");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student != null) {
            System.out.println("Student Found!");
            displayStudentDetails(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    // Update Student
    public static void updateStudent() {

        System.out.println("\n====== UPDATE STUDENT ======");

        int id = readInt("Enter Student ID to update: ");

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n1. Update Name");
        System.out.println("2. Update Subject");
        System.out.println("3. Update Marks");
        System.out.println("4. Update All Details");

        int choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1:
                student.setName(readText("Enter New Name: "));
                break;

            case 2:
                student.setSubject(readText("Enter New Subject: "));
                break;

            case 3:
                student.setMarks(readMarks("Enter New Marks (0-100): "));
                break;

            case 4:
                student.setName(readText("Enter New Name: "));
                student.setSubject(readText("Enter New Subject: "));
                student.setMarks(readMarks("Enter New Marks (0-100): "));
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Student record updated successfully!");
        displayStudentDetails(student);
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.println("\n====== DELETE STUDENT ======");

        int id = readInt("Enter Student ID to delete: ");

        Student student = findStudent(id);

        if (student != null) {

            students.remove(student);

            System.out.println("Student record deleted successfully!");

        } else {
            System.out.println("Student not found!");
        }
    }

    // Calculate Total Marks and Percentage
    public static void calculateResults() {

        System.out.println("\n====== STUDENT RESULTS ======");

        if (students.isEmpty()) {
            System.out.println("No student records available!");
            return;
        }

        for (Student student : students) {

            double totalMarks = student.getMarks();
            double percentage = (totalMarks / 100) * 100;

            System.out.println("\nStudent Name: " + student.getName());
            System.out.println("Total Marks: " + totalMarks + "/100");
            System.out.printf("Percentage: %.2f%%\n", percentage);
            System.out.println("Grade: " + calculateGrade(percentage));
        }
    }

    // Grade Calculation
    public static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    // Performance Summary
    public static void performanceSummary() {

        System.out.println("\n====== PERFORMANCE SUMMARY ======");

        if (students.isEmpty()) {
            System.out.println("No student records available!");
            return;
        }

        double totalMarks = 0;
        double highestMarks = students.get(0).getMarks();
        double lowestMarks = students.get(0).getMarks();

        int passed = 0;
        int failed = 0;

        for (Student student : students) {

            double marks = student.getMarks();

            totalMarks += marks;

            if (marks > highestMarks) {
                highestMarks = marks;
            }

            if (marks < lowestMarks) {
                lowestMarks = marks;
            }

            if (marks >= 40) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = totalMarks / students.size();

        System.out.println("Total Students: " + students.size());
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Highest Marks: " + highestMarks);
        System.out.println("Lowest Marks: " + lowestMarks);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);
    }

    // Find Student by ID
    public static Student findStudent(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {
                return student;
            }
        }

        return null;
    }

    // Display Individual Student Details
    public static void displayStudentDetails(Student student) {

        System.out.println("------------------------------");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Subject: " + student.getSubject());
        System.out.println("Marks: " + student.getMarks());
        System.out.println("Grade: " + calculateGrade(student.getMarks()));
        System.out.println("------------------------------");
    }

    // Integer Input Validation
    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {
                int value = Integer.parseInt(sc.nextLine());

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Text Input Validation
    public static String readText(String message) {

        while (true) {

            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty!");
        }
    }

    // Marks Input Validation
    public static double readMarks(String message) {

        while (true) {

            System.out.print(message);

            try {
                double marks = Double.parseDouble(sc.nextLine());

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks must be between 0 and 100!");

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid marks!");
            }
        }
    }
}