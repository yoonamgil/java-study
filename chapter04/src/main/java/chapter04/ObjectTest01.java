package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point p = new Point(10,20);
		
		System.out.println(p.getClass());// 클래스 정보 - 클래스 객체를 리턴  
		System.out.println(p.hashCode());// reference value x
										 // address
										 // address 기반의 해싱값(int)   해싱이란? 
		System.out.println(p);			 // 자동으로 toString 한다. 
		System.out.println(p.toString());// 그렇기 때문에 14~15번 줄의 결과가 같다.  getClass()+ "@" + hashCode();
	}

}
