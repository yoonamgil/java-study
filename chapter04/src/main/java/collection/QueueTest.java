package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> q = new LinkedList<>();
		
		
		q.offer("둘리"); // add와 같은 역할
		q.offer("마이콜");
		q.offer("또치");
		
		while(!q.isEmpty()) {
			String s= q.poll(); // pop과 같은 역할
			System.out.println(s);
		}
			// null을 리턴한다. 
			System.out.println(q.poll());
			
			q.offer("둘리"); // add와 같은 역할
			q.offer("마이콜");
			q.offer("또치");
			
			System.out.println(q.poll());
			System.out.println(q.peek());// 지금 현재 가르키고 있는 값 
			System.out.println(q.poll());
	}

}
