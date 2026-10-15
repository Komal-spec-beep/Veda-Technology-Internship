package day15.paymentsystem;

public class Main {

	public static void main(String[] args) {
		
		CardPayment payment = new CardPayment();
		payment.pay(500.0);
		
		WalletPayment wallpay = new WalletPayment();
		wallpay.pay(800.0);
		
		UpiPayment upipay = new UpiPayment();
		upipay.pay(1000.0);

	}

}
