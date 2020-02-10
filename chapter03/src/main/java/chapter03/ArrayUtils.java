package chapter03;

public class ArrayUtils {
	public static double[] intToDouble(int[] src) {
		double[] result = null;
		
		if(src==null)
			return result;
		
		int length= src.length;
		result = new double[length];
		
		for(int i= 0; i< length ; i++) {
			result[i] = src[i];
		}
		
		return result;
	}
	
	public static int[] dobleToInt(double[] src) {
		int[] result = null;
		
		if(src==null)
			return result;
		
		int length= src.length;
		result = new int[length];
		
		for(int i= 0; i< length ; i++) {
			result[i] = (int)src[i];
		}
		
		return result;
	}
	
	
	public static int[] concat(int[] s1, int[] s2) {
		int[] result; 
		int sum= s1.length + s2.length;
		
		result= new int[sum];
		
		for(int i=0;i<s1.length+s2.length;i++) {
			result[i]= s1[i];
		}
		for(int j=0;j<s2.length;j++) {
			result[j+s1.length]=s2[j];
		}
		
		return result;
		
	}
	
	
}
