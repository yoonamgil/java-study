package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		
		String ks = "one"; 
		map.put("one",1); //auto boxing
		map.put("two",2); //auto boxing 
		map.put("three",3); //auto boxing 
		map.put("one", 4); // 같은 키와 다른 값을 넣으면 덮어진다. 
		
		int i = map.get(ks); // auto unboxing 
		int j = map.get(new String("one"));
		System.out.println(i+ ":" + j);
		
		//순회
		
		Set<String> s = map.keySet();
		for(String key : s) {
			int value = map.get(key);// key과 동일한 스트링값의 인트값을 리턴 
			System.out.println(value);
		}
		
	}

}
