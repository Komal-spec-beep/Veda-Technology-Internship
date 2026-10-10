package day10.constructoroverloading;

public class Student {
	
	String name;
	int age;
	String course;
	
	public Student(String name) {
		
		this.name = name;
	}
	
	public Student(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	public Student(String name, int age, String course) {
		
		this.name = name;
		this.age = age;
		this.course = course;
	}
	
	public static void main(String[] args) {
		
		Student student1 = new Student("Komal");
		Student student2 = new Student("Komal", 22);
		Student student3 = new Student("Komal", 22, "JAVA");
		student1.displayInfo();
		student2.displayInfo();
		student3.displayInfo();
	}
	
	public void displayInfo() {
		System.out.println("Name is " + name);
		System.out.println("Age is " + age);
		System.out.println("Course is " + course);
	}
}
