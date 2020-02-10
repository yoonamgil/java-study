package chapter04;

public class WapperClassTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s = "12345";
			int i=Integer.parseInt(s); // String-> int
			
			String s2 = String.valueOf(i); //int -> String
			
			System.out.println(s+":"+ s2);
			
			int a =Character.getNumericValue('A');
			System.out.println(a);
			
			//2진수
			String s3 = Integer.toBinaryString(15);
			System.out.println(s3);
			
			//16진수 
			String s4=Integer.toHexString(255);
	}

}
