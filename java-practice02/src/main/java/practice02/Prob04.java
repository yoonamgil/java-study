package practice02;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		int k=str.length();
		char[] result = new char[k];

		int a;
		
		for(int i=0;i<k;i++) {
			a=k-i-1;
			result[i]= str.charAt(a);
		}
		
		
		return result;
	}

	public static void printCharArray(char[] array){
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
			
		}
		System.out.println();
	}
}
