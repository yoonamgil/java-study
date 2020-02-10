package prob6;

public class RectTriangle extends Shape  {
	private double height;
	private double width;
	
	public RectTriangle(double w, double h) {
		this.height=h;
		this.width= w;
		
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	
	@Override
	public double getArea() {
		
		return this.width * this.height* 0.5;
	}
	@Override
	public double getPerimeter() {
	
		return (this.width+this.height) + Math.sqrt((this.height*this.height)+(this.width*this.width));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
