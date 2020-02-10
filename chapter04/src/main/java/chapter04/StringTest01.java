package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// C:\Temp 
		System.out.println("C:\\temp");// \ 컨트롤제어문자이기 때문에 \\를 사용해줘야한다. 
		// Hello 
		System.out.println("\"Hello\"");
	
		
		// 제어문자
		// \t -> tab
		// \n -> New Line(개행) 
		// \r -> Carriage Return; 
		System.out.println("Hello\tworld\r\n");
		System.out.println("Hello\tworld\n");
		
		
		char c='\'' ;
		System.out.println(c);
		
	}
	
	
}
