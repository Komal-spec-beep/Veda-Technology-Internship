package day25.loganalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LogFileAnalyzer {

    public static void main(String[] args) {

        String inputFile = "application.log";
        String outputFile = "log_report.txt";

        Map<String, Integer> logCounts = new HashMap<>();
        ArrayList<String> errorMessages = new ArrayList<>();

        logCounts.put("INFO", 0);
        logCounts.put("WARNING", 0);
        logCounts.put("ERROR", 0);

        int totalLines = 0;
        int invalidLines = 0;

        System.out.println("===== Log File Analyzer =====");

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(inputFile))) {

            String line;

            while ((line = reader.readLine()) != null) {

                totalLines++;
                String trimmedLine = line.trim();

                if (trimmedLine.isEmpty()) {
                    invalidLines++;
                    continue;
                }

                String[] parts = trimmedLine.split("\\s+", 4);

                if (parts.length < 3) {
                    invalidLines++;
                    System.out.println(
                            "Invalid log line " + totalLines + ": " + line);
                    continue;
                }

                String logLevel = parts[2];

                if (logCounts.containsKey(logLevel)) {

                    logCounts.put(
                            logLevel,
                            logCounts.get(logLevel) + 1
                    );

                    if (logLevel.equals("ERROR")) {
                        errorMessages.add(line);
                    }

                } else {
                    invalidLines++;
                    System.out.println(
                            "Unknown log level at line "
                                    + totalLines + ": " + line);
                }
            }

            System.out.println("\n===== Analysis Summary =====");
            System.out.println("Total lines: " + totalLines);
            System.out.println("INFO messages: " + logCounts.get("INFO"));
            System.out.println("WARNING messages: " + logCounts.get("WARNING"));
            System.out.println("ERROR messages: " + logCounts.get("ERROR"));
            System.out.println("Invalid lines: " + invalidLines);

            System.out.println("\n===== Error Summary =====");

            if (errorMessages.isEmpty()) {
                System.out.println("No errors found.");
            } else {
                for (String error : errorMessages) {
                    System.out.println(error);
                }
            }

            generateReport(
                    outputFile, totalLines, invalidLines,
                    logCounts, errorMessages
            );

            System.out.println("\nReport saved to " + outputFile);

        } catch (IOException e) {
            System.out.println(
                    "File error: " + e.getMessage());
            System.out.println(
                    "Please check that application.log exists in the working directory.");
        }
    }

    public static void generateReport(
            String outputFile,
            int totalLines,
            int invalidLines,
            Map<String, Integer> logCounts,
            ArrayList<String> errorMessages) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("===== Log File Analysis Report =====");
            writer.newLine();

            writer.write("Total lines: " + totalLines);
            writer.newLine();

            writer.write("INFO messages: " + logCounts.get("INFO"));
            writer.newLine();

            writer.write("WARNING messages: " + logCounts.get("WARNING"));
            writer.newLine();

            writer.write("ERROR messages: " + logCounts.get("ERROR"));
            writer.newLine();

            writer.write("Invalid lines: " + invalidLines);
            writer.newLine();

            writer.newLine();
            writer.write("===== Error Details =====");
            writer.newLine();

            if (errorMessages.isEmpty()) {
                writer.write("No errors found.");
                writer.newLine();
            } else {
                for (String error : errorMessages) {
                    writer.write(error);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Unable to generate report: " + e.getMessage());
        }
    }
}