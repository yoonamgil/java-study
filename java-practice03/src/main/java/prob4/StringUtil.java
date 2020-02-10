package prob4;

public class StringUtil {
	
	
	public static String concatenate(String[] str) {
		String strsum = new String(); 
		
		
		for(int i=0; i<str.length;i++) {
			strsum = strsum + str[i];
			
		}
		
		return strsum;
	}
}
