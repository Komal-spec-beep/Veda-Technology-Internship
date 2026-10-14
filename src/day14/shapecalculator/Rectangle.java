package day14.shapecalculator;

public class Rectangle extends Shape{

	double length;
	double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double calculateArea() {
		return length * width;
	}
	
	@Override
	public double calculatePerimeter() {
		return 2 * (length + width);
	}
}
