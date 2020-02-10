package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		//final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		//Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");

		Scanner s1= new Scanner(System.in);
		
		int money; 
		int sw=2;
		int mok; 
		int[] num =new int[10];
		int k=50000;
		System.out.println("금액: ");
		money=s1.nextInt();
		
		
		for(int i=0;i<10; i++) {
			
			mok=money / k; 
			num[i]=mok;
			
			money= money-(mok*k);
			
			
			System.out.print(k+"원:");
			System.out.println(num[i]+"개 ");
			if(sw==5) {
				
				sw=2;
			}
			else{
				sw=5; 
			}
			
			k= k/sw;
			
		}
		
		
		s1.close();
	}

}
