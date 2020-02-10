package prob6;

public class Rectangle extends Shape implements Resizable{
	
	private double width;
	private double height;
	
	public Rectangle(double w, double h) {
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
		
		return this.width * this.height;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (this.width+ this.height)* 2;
	}


	@Override
	public void resize(double re) {
		this.height*= re;
		this.width*= re;
	}
}
