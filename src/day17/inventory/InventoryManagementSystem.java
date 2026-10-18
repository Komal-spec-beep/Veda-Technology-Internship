package day17.inventory;
import java.util.Scanner;
import java.util.ArrayList;

public class InventoryManagementSystem {

	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<>();
		
		products.add(new Product(1, "Pencil", 5.00));
		products.add(new Product(2, "Pen", 3.00));
		products.add(new Product(3, "Eraser", 4.00));
		products.add(new Product(4, "Scale", 10.00));
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do {
		    System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
		    System.out.println("1. Add Product");
		    System.out.println("2. Search Product");
		    System.out.println("3. Update Product");
		    System.out.println("4. Delete Product");
		    System.out.println("5. Display All Products");
		    System.out.println("6. Exit");

		    System.out.print("Enter your choice: ");
		    choice = sc.nextInt();
		    
		    switch (choice) {
		    case 1:
		        System.out.print("Enter new product ID: ");
		        int id = sc.nextInt();

		        System.out.print("Enter new product name: ");
		        String name = sc.next();

		        System.out.print("Enter price of new product: ");
		        double price = sc.nextDouble();

		        Product newProduct = new Product(id, name, price);
		        products.add(newProduct);

		        System.out.println("Product added successfully!");
		        break;

		    case 2:
		        System.out.print("Enter Product ID to search: ");
		        int searchID = sc.nextInt();

		        boolean found = false;

		        for (Product p : products) {
		            if (p.productID == searchID) {
		                p.displayProduct();
		                found = true;
		                break;
		            }
		        }

		        if (found == false) {
		            System.out.println("Product not found!");
		        }
		        break;

		    case 3:
		        System.out.print("Enter Product ID to update: ");
		        int updateID = sc.nextInt();

		        boolean productFound = false;

		        for (Product p : products) {
		            if (p.productID == updateID) {
		                sc.nextLine();

		                System.out.print("Enter new product name: ");
		                p.productName = sc.nextLine();

		                System.out.print("Enter new price: ");
		                p.price = sc.nextDouble();

		                productFound = true;
		                System.out.println("Product updated successfully!");
		                break;
		            }
		        }

		        if (productFound == false) {
		            System.out.println("Product not found!");
		        }
		        break;

		    case 4:
		        System.out.print("Enter Product ID to delete: ");
		        int deleteID = sc.nextInt();

		        boolean deleted = false;

		        for (int i = 0; i < products.size(); i++) {
		            if (products.get(i).productID == deleteID) {
		                products.remove(i);
		                deleted = true;
		                System.out.println("Product deleted successfully!");
		                break;
		            }
		        }

		        if (deleted == false) {
		            System.out.println("Product not found!");
		        }
		        break;

		    case 5:
		        if (products.isEmpty()) {
		            System.out.println("Inventory is empty!");
		        } else {
		            System.out.println("\n===== ALL PRODUCTS =====");

		            for (Product p : products) {
		                p.displayProduct();
		            }
		        }
		        break;

		    case 6:
		        System.out.println("Exiting Inventory System...");
		        break;

		    default:
		        System.out.println("Invalid choice!");
		}

		} while (choice != 6);
		
	}
}
