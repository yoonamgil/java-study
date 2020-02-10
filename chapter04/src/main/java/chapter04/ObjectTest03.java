package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= new String("ABC");
		String s2= new String("ABC");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()+ ":" + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
		
		System.out.println("=============================");
		
		String s3= "ABC";
		String s4= "ABC"; // 재사용 포인터가 ABC를 가르킴 
		
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode()+ ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
	}

}
