package day15.paymentsystem;

public class UpiPayment implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Payment via UPI: " + amount);
	}
}