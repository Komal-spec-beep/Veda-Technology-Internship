package day13.runtimepolymorphism;

public class Manager extends Employee{
	
	@Override
	public void work() {
		System.out.println("Manager is managing the team.");
	}
}
