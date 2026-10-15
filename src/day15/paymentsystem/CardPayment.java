package day15.paymentsystem;

public class CardPayment implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Payment via card: " + amount);
	}
}
