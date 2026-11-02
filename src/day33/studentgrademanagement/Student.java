package day33.studentgrademanagement;

import java.util.ArrayList;

public class Student {

    private int studentId;
    private String name;

    private ArrayList<Subject> subjects;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double calculateTotalMarks() {

        double total = 0;

        for (Subject subject : subjects) {
            total += subject.getMarks();
        }

        return total;
    }

    public double calculatePercentage() {

        if (subjects.isEmpty()) {
            return 0;
        }

        double total = calculateTotalMarks();

        return total / (subjects.size() * 100) * 100;
    }

    public String getGrade() {
        return Grade.calculateGrade(calculatePercentage());
    }

    @Override
    public String toString() {

        return "Student ID: " + studentId
                + "\nName: " + name
                + "\nSubjects: " + subjects
                + "\nTotal Marks: " + calculateTotalMarks()
                + "\nPercentage: " + String.format("%.2f", calculatePercentage())
                + "%\nGrade: " + getGrade();
    }
}