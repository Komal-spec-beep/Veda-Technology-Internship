package day23.filerecord;

import java.io.*;
import java.util.Scanner;

public class StudentRecordSystem {

    private static final String FILE_NAME = "students.txt";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Record System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println();
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent();
                    break;

                case "2":
                    readStudents();
                    break;

                case "3":
                    searchStudent();
                    break;

                case "4":
                    updateStudent();
                    break;

                case "5":
                    System.out.println("Exiting Student Record System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add a new student
    static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty() || id.contains("|")) {
            System.out.println("Invalid student ID!");
            return;
        }

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter student marks: ");
        String marksInput = sc.nextLine().trim();

        double marks;

        try {
            marks = Double.parseDouble(marksInput);

            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid marks!");
            return;
        }

        if (name.isEmpty() || name.contains("|")) {
            System.out.println("Invalid student name!");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_NAME, true))) {

            bw.write(id + "|" + name + "|" + marks);
            bw.newLine();

            System.out.println("Student added successfully!");

        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    // Read all student records
    static void readStudents() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n----- All Student Records -----");

        boolean found = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 3) {
                    System.out.println(
                            "ID: " + data[0]
                            + " | Name: " + data[1]
                            + " | Marks: " + data[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading records: " + e.getMessage());
        }
    }

    // Search for a student by ID
    static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine().trim();

        String record = findStudent(id);

        if (record == null) {
            System.out.println("Student not found!");
        } else {
            displayRecord(record);
        }
    }

    // Find a student record in the file
    static String findStudent(String id) {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 3 && data[0].equals(id)) {
                    return line;
                }
            }

        } catch (IOException e) {
            System.out.println("Error searching records: " + e.getMessage());
        }

        return null;
    }

    // Update an existing student record
    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String id = sc.nextLine().trim();

        String existingRecord = findStudent(id);

        if (existingRecord == null) {
            System.out.println("Student not found!");
            return;
        }

        String[] oldData = existingRecord.split("\\|", -1);

        System.out.println("Current Name: " + oldData[1]);
        System.out.println("Current Marks: " + oldData[2]);

        System.out.print("Enter new name: ");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty() || newName.contains("|")) {
            System.out.println("Invalid student name!");
            return;
        }

        System.out.print("Enter new marks: ");
        String marksInput = sc.nextLine().trim();

        double newMarks;

        try {
            newMarks = Double.parseDouble(marksInput);

            if (newMarks < 0 || newMarks > 100) {
                System.out.println("Marks must be between 0 and 100!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid marks!");
            return;
        }

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("students_temp.txt");

        boolean updated = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(
                new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 3 && data[0].equals(id)) {
                    bw.write(id + "|" + newName + "|" + newMarks);
                    updated = true;
                } else {
                    bw.write(line);
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error updating record: " + e.getMessage());
            return;
        }

        if (updated) {
            try {
                if (inputFile.delete()) {
                    if (tempFile.renameTo(inputFile)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println(
                                "Update saved to students_temp.txt, "
                                + "but could not replace the original file.");
                    }
                } else {
                    System.out.println(
                            "Could not replace the original file. "
                            + "Updated data is in students_temp.txt.");
                }
            } catch (SecurityException e) {
                System.out.println("File access error: " + e.getMessage());
            }
        } else {
            tempFile.delete();
            System.out.println("Student not found!");
        }
    }

    // Display one student record
    static void displayRecord(String record) {
        String[] data = record.split("\\|", -1);

        System.out.println("\n----- Student Details -----");
        System.out.println("ID: " + data[0]);
        System.out.println("Name: " + data[1]);
        System.out.println("Marks: " + data[2]);
    }
}
