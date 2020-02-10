package chapter04;

public class ObjectTest02 {
	public static void main(String[] args) {
		Point point1 = new Point(10,20);
		Point point2 = new Point(10,20);
		Point point3=point2;
		
		// == 객체의 동일성 비교 
		System.out.println(point1==point2);
		System.out.println(point2==point3);
		
		// equals 두 객체의 동시성 (내용) 비교 
		
		System.out.println(point1.equals(point2));
		System.out.println(point2.equals(point3));
	}
}
