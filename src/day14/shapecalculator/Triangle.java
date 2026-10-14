package day14.shapecalculator;

public class Triangle extends Shape{

	double base, height, sideA, sideB, sideC;
	
	public Triangle(double base, double height, double sideA, double sideB, double sideC) {
		this.base = base;
		this.height = height;
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	@Override
	public double calculateArea() {
		return 1.0/2 * base * height;
	}
	
	@Override 
	public double calculatePerimeter() {
		return sideA + sideB + sideC;
	}
}
