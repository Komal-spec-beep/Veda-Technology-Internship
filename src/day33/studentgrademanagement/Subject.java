package day33.studentgrademanagement;

public class Subject {

    private String subjectName;
    private double marks;

    public Subject(String subjectName, double marks) {
        this.subjectName = subjectName;
        setMarks(marks);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getMarks() {
        return marks;
    }

    public void setSubjectName(String subjectName) {
        if (subjectName != null && !subjectName.trim().isEmpty()) {
            this.subjectName = subjectName;
        }
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Enter marks between 0 and 100.");
        }
    }

    @Override
    public String toString() {
        return subjectName + " : " + marks;
    }
}