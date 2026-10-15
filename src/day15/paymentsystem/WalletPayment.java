package day15.paymentsystem;

public class WalletPayment implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Payment via Wallet: " + amount);
	}
}
