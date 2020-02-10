package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	void f2() {
		
		System.out.println(StaticMethod.m);
		// 같은 클래스 안에서는 클래스 이름을 생략해서 가능하다. 원래는 Static.m으로 접근하는 것이 맞다. 
		System.out.println(m);
	}
	
	
	void f3() {
		f2(); 
	}
	
	void f4() {
		
		StaticMethod.s1();
		// 같은 클래스의 클래스 메소드에 접근에서는 클래스 이름을 생략이 가능하다 
		s1();
	}
	static void s1() {
		// static method 에서 인스턴스 변수 접근은 안된다. 
		//System.out.println(n);  오류 소스이다. 
		
		
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스 안에서는 클래스 이름을 생략해서 가능하다. 원래는 Static.m으로 접근하는 것이 맞다. 
		System.out.println(m);
	}
	
	static void s3() {
		// static 메소드 안에서 인스턴스 메소드의 접근은  불가능하다 
		//f1();
		
		StaticMethod s= new StaticMethod(); // 객체로 선언하면 가능 
		s.f1(); 
		
	}
	
	static void s4() {
		StaticMethod.s1();
		s1();
	}
	
}
