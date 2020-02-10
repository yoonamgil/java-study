package chapter03;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		
		int[] a1={10,20,30,40,50};
		int[] b1={11,21,31,41,51};
		int[] c1; 
		//ArrayUtils au= new ArrayUtils();
		
		c1=ArrayUtils.concat(a1, b1);
		
		System.out.println(c1[1]); 
		
		
		double[] d1 = ArrayUtils.intToDouble(a1);
		c1= ArrayUtils.concat(a1, b1);
		for(int i=0; i<c1.length;i++) {
			System.out.print(c1[i]+" ");
		}
		
	
		
	}
}
