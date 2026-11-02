package day33.studentgrademanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Results");
            System.out.println("7. Performance Summary");
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
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }

    // Add Student
    public static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        int id = readInt("Enter Student ID: ");

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        String name = readText("Enter Student Name: ");

        Student student = new Student(id, name);

        int count = readInt("Enter number of subjects: ");

        if (count <= 0) {
            System.out.println("At least one subject is required!");
            return;
        }

        for (int i = 1; i <= count; i++) {

            System.out.println("\nSubject " + i);

            String subjectName = readText("Enter Subject Name: ");
            double marks = readMarks("Enter Marks: ");

            student.addSubject(new Subject(subjectName, marks));
        }

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Display Students
    public static void displayStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student student : students) {
            System.out.println("\n" + student);
            System.out.println("----------------------------");
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.println("\n===== SEARCH STUDENT =====");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student != null) {
            System.out.println("\nStudent Found!");
            System.out.println(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    // Update Student
    public static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n1. Update Name");
        System.out.println("2. Add Subject");
        System.out.println("3. Update Subject Marks");

        int choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1:
                String newName = readText("Enter New Name: ");
                student.setName(newName);
                System.out.println("Name updated successfully!");
                break;

            case 2:
                String subjectName = readText("Enter Subject Name: ");
                double marks = readMarks("Enter Marks: ");

                student.addSubject(new Subject(subjectName, marks));

                System.out.println("Subject added successfully!");
                break;

            case 3:
                updateSubjectMarks(student);
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\nUpdated Student Record:");
        System.out.println(student);
    }

    // Update Subject Marks
    public static void updateSubjectMarks(Student student) {

        if (student.getSubjects().isEmpty()) {
            System.out.println("No subjects available!");
            return;
        }

        System.out.println("\nAvailable Subjects:");

        for (int i = 0; i < student.getSubjects().size(); i++) {
            System.out.println((i + 1) + ". "
                    + student.getSubjects().get(i));
        }

        int index = readInt("Enter Subject Number: ");

        if (index < 1 || index > student.getSubjects().size()) {
            System.out.println("Invalid subject number!");
            return;
        }

        double newMarks = readMarks("Enter New Marks: ");

        student.getSubjects().get(index - 1).setMarks(newMarks);

        System.out.println("Subject marks updated successfully!");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        int id = readInt("Enter Student ID: ");

        Student student = findStudent(id);

        if (student != null) {

            students.remove(student);

            System.out.println("Student deleted successfully!");

        } else {
            System.out.println("Student not found!");
        }
    }

    // Calculate Results
    public static void calculateResults() {

        System.out.println("\n===== STUDENT RESULTS =====");

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student student : students) {

            System.out.println("\nStudent: " + student.getName());
            System.out.println("Total Marks: "
                    + student.calculateTotalMarks());

            System.out.printf("Percentage: %.2f%%%n",
                    student.calculatePercentage());

            System.out.println("Grade: " + student.getGrade());
        }
    }

    // Performance Summary
    public static void performanceSummary() {

        System.out.println("\n===== PERFORMANCE SUMMARY =====");

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        double totalPercentage = 0;
        double highest = -1;
        double lowest = 101;

        int passed = 0;
        int failed = 0;

        for (Student student : students) {

            double percentage = student.calculatePercentage();

            totalPercentage += percentage;

            if (percentage > highest) {
                highest = percentage;
            }

            if (percentage < lowest) {
                lowest = percentage;
            }

            if (percentage >= 40) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = totalPercentage / students.size();

        System.out.println("Total Students: " + students.size());

        System.out.printf("Average Percentage: %.2f%%%n", average);

        System.out.printf("Highest Percentage: %.2f%%%n", highest);

        System.out.printf("Lowest Percentage: %.2f%%%n", lowest);

        System.out.println("Passed Students: " + passed);

        System.out.println("Failed Students: " + failed);
    }

    // Find Student
    public static Student findStudent(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {
                return student;
            }
        }

        return null;
    }

    // Integer Input
    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    // Text Input
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

    // Marks Input
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