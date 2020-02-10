package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;
	
	public RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	
	// Math.sqrt(밑변 제곱+ 높이 제곱하고 그걸 루트)
	
	
	@Override
	public double getArea() {
		double result = width * height * 0.5;
		
		return result;
	}

	@Override
	public double getPerimeter() {
		double result = width + height;
		result += Math.sqrt((width * width) + (height * height));
		
		return result;
	}

}
