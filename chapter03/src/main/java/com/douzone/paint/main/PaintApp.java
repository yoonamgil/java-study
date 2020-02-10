package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PaintApp {
	public static void main (String[] args) {
		Point point2= new Point(10,50);
		
		
		//point1.setX(2);
		//point1.setY(5);
		//drawPoint(point1);
		//point2.disappear();
		//draw(point1);
		
		Point point3= new ColorPoint(50,100,"red");
		//drawPoint(point3);
		draw(point3);
		
		Rect rect = new Rect();
		//drawRect(rect); 
		//drawShape(rect);
		draw(rect);
		Triangle triangle = new Triangle(); 
		//drawShape(triangle);
		//drawTriangle(triangle);
		draw(triangle);
		Circle circle= new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("hello"));
		
		//instanceof test
		
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류: class 는 hierachy 의 상위와 하위만 instanceof 연산자를 사용할 수 있다. 
		//System.out.println(circle instanceof Rect); 오류가 난다.  
		
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect); // shape의 부모클래스 객체에서 circle로 준것이기 때문에 가능하다. 위의 오류코드와는 다르다. 
		
		//Interface 는 hierachy 상관없이 instanceof 연산자를 사용할수 있다. 
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);// 
		
	}
	public static void draw(Drawable d) {
			d.draw();
	}
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
	
//	private static void drawTriangle(Triangle triangle) {
//		// TODO Auto-generated method stub
//		triangle.draw();
//		
//	}
//
//	private static void drawRect(Rect rect) {
//		rect.draw();
//		
	//}
	
	
	public static void drawPoint(Point point) {
		point.show();
		
	}
	
	
}
