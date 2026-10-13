package day13.runtimepolymorphism;

public class Main {
	
	void main(String[] args) {
		
		Employee developer = new Developer();
		developer.work();
		
		Employee manager = new Manager();
		manager.work();
		
		Employee intern = new Intern();
		intern.work();
	}
}
