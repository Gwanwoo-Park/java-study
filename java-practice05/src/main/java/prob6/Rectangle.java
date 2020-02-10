package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		double result = width * height;
		
		return result;
	}

	@Override
	public double getPerimeter() {
		double result = (width + height) * 2;
		
		return result;
	}

	@Override
	public void resize(double s) {
		this.width *= s;
		this.height *= s;
	}

}
