package prob01;

public class Printer{

	public void println(int a) {
		System.out.println(a);
	}
	public void println(boolean a) {
		System.out.println(a);
	}
	public void println(double a) {
		System.out.println(a);
	}
	public void println(int a, int i, int j, int k, int l, String string, StringBuffer stringBuffer) {
		
		System.out.format("%d %d %d %d %d %s %s",a,i,j,k,l,string,stringBuffer);
	}
	public void println(String a) {
		System.out.println(a);
	}
	
	public<T> void println(T t) {
		System.out.println(t);
	}
	
	//가변변수 
	
	public int sum(int ...nums) {
		int sum=0;
		for(int n: nums) {
			sum += n;
		}
		return sum;
	}
	
	public <T> void println(T...ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
}
