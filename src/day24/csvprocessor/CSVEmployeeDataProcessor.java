package day24.csvprocessor;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CSVEmployeeDataProcessor {

    private static final String INPUT_FILE = "employees.csv";
    private static final String OUTPUT_FILE = "processed_employees.csv";

    public static void main(String[] args) {

        int totalRecords = 0;
        int validRecords = 0;
        int invalidRecords = 0;
        double totalSalary = 0;

        Set<String> employeeIds = new HashSet<>();

        File inputFile = new File(INPUT_FILE);

        if (!inputFile.exists()) {
            System.out.println("Error: employees.csv not found!");
            System.out.println("Please place it in the project root folder.");
            return;
        }

        System.out.println("===== CSV Employee Data Processor =====");

        try (
            BufferedReader br = new BufferedReader(
                new FileReader(INPUT_FILE)
            );

            BufferedWriter bw = new BufferedWriter(
                new FileWriter(OUTPUT_FILE)
            )
        ) {
            String header = br.readLine();

            if (header == null ||
                !header.trim().equalsIgnoreCase(
                    "ID,Name,Department,Salary")) {

                System.out.println("Error: Invalid or missing CSV header!");
                return;
            }

            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {

                lineNumber++;
                totalRecords++;

                String[] data = line.split(",", -1);

                // Check the number of columns
                if (data.length != 4) {
                    System.out.println(
                        "Invalid row " + lineNumber
                        + ": Incorrect number of columns."
                    );
                    invalidRecords++;
                    continue;
                }

                String id = data[0].trim();
                String name = data[1].trim();
                String department = data[2].trim();
                String salaryText = data[3].trim();

                // Check missing fields
                if (id.isEmpty() || name.isEmpty()
                        || department.isEmpty()
                        || salaryText.isEmpty()) {

                    System.out.println(
                        "Invalid row " + lineNumber
                        + ": Missing field."
                    );
                    invalidRecords++;
                    continue;
                }

                // Check duplicate employee IDs
                if (employeeIds.contains(id)) {
                    System.out.println(
                        "Invalid row " + lineNumber
                        + ": Duplicate employee ID."
                    );
                    invalidRecords++;
                    continue;
                }

                double salary;

                // Validate salary
                try {
                    salary = Double.parseDouble(salaryText);

                    if (!Double.isFinite(salary) || salary < 0) {
                        System.out.println(
                            "Invalid row " + lineNumber
                            + ": Salary must be a valid non-negative number."
                        );
                        invalidRecords++;
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println(
                        "Invalid row " + lineNumber
                        + ": Salary must be numeric."
                    );
                    invalidRecords++;
                    continue;
                }

                // Write valid employee record
                bw.write(id + "," + name + ","
                        + department + "," + salary);
                bw.newLine();

                employeeIds.add(id);
                totalSalary += salary;
                validRecords++;

                System.out.println(
                    "Processed employee: " + name
                );
            }

            System.out.println("\n===== Processing Summary =====");
            System.out.println("Total records: " + totalRecords);
            System.out.println("Valid employees: " + validRecords);
            System.out.println("Invalid records: " + invalidRecords);

            if (validRecords > 0) {
                double averageSalary = totalSalary / validRecords;

                System.out.printf(
                    "Total salary: %.2f%n", totalSalary
                );

                System.out.printf(
                    "Average salary: %.2f%n", averageSalary
                );
            } else {
                System.out.println("No valid employees to calculate salary statistics.");
            }

            System.out.println(
                "\nProcessed data saved to " + OUTPUT_FILE
            );

        } catch (IOException e) {
            System.out.println(
                "File processing error: " + e.getMessage()
            );
        }
    }
}
