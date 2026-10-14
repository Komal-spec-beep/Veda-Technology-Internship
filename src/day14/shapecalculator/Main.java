package day14.shapecalculator;

public class Main {

	void main(String[] args) {
		Circle circle = new Circle(5.0);
		System.out.println("Area of circle is " + circle.calculateArea());
		System.out.println("Perimeter of circle is " + circle.calculatePerimeter());
		
		Rectangle rect = new Rectangle(10.0, 5.0);
		System.out.println("Area of rectangle is " + rect.calculateArea());
		System.out.println("Perimeter of rectangle is " + rect.calculatePerimeter());
		
		Triangle tri = new Triangle(6.0, 4.0, 5.0, 5.0, 6.0);
		System.out.println("Area of triangle is " + tri.calculateArea());
		System.out.println("Perimeter of triangle is " + tri.calculatePerimeter());
	}
}
