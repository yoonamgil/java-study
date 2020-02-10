package practice01;

public class Prob5 {

	public static void main(String[] args) {
		int t;
		int o; 
		
		
		for( int i = 1; i <100; i++ ) {
			
			t= i/10;
			o= i%10;
			
			if((t==3 ||
				t==6||
				t==9 ) 
					&& 
					(o==3 ||
					o==6||
					o==9 )) {
				
				System.out.println(i+"짝짝");
				
			}
			else if((t==3 ||
					t==6||
					t==9 ) 
						|| 
						(o==3 ||
						o==6||
						o==9 )){
				System.out.println(i+"짝");
			}
			else {
				
			}
			
			
		}
	}
}
