package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<>();
		
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		while(!s.isEmpty()) {
			String str =  s.pop();
			System.out.println(str);
		}
		
		//비어 있는 경우 stackException이 발생한다. 
		//s.pop();
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		
	}

}
