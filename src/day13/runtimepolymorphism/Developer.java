package day13.runtimepolymorphism;

public class Developer extends Employee{
	
	@Override 
	public void work() {
		
		System.out.println("Developer is writing code.");
	}
}
