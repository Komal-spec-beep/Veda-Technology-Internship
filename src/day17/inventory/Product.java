package day17.inventory;

public class Product {

	int productID;
	String productName;
	double price;
		
	Product(int productID, String productName, double price) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}
	

	
	void displayProduct() {
		System.out.println("Product ID: " + productID);
		System.out.println("Product Name: " + productName);
		System.out.println("Price: " + price);
		System.out.println();
		System.out.println();
	}
}
