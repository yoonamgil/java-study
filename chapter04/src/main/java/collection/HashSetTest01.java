package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s = new HashSet<>();
		
		String s1= new String("또치");
		String s2= new String("또치");
		
		
		s.add("둘리");
		s.add("마이클");
		s.add("또치");
		//s.add(s1);
		for(String t: s) {
			System.out.println(t);
		}
		System.out.println(s.contains("또치")); // 객체의 동일성이 아니라 안의 내용으로 비교한다. 
		System.out.println(s.size());
		
		//순회 
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str= it.next();
			System.out.println(str);
		}
	}

}
