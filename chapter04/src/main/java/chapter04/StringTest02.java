package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2; 
		
		s2 =s1.toUpperCase(); // 대문자로 바꾸는 함수 
		
		String s4= s2.concat("??");
		String s5= "!".concat(s2).concat("@");
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalHello("hello"));
		System.out.println(equalHello(null));
		
	}
		
	public static boolean equalHello(String s) {
			return ("hello").equals(s);
	}
}
