package day32.studentgrademanagement;

public class Student {

	private int studentId;
	private String name;
	private String subject;
	private double marks;
	
	public Student(int studentId, String name, String subject, double marks){
		this.studentId = studentId;
		this.name = name;
		this.subject = subject;
		setMarks(marks);
	}
	
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	public double getMarks() {
		return marks;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMarks(double marks) {
		if(marks >= 0 && marks <= 100) {
			this.marks = marks;
		}
		else {
			System.out.println("Invalid marks! marks must be between 0 and 100.");
		}
	}
	
	@Override
	public String toString() {
		return studentId + " | " + name + " | " + subject + " | " + marks;
	}
}
