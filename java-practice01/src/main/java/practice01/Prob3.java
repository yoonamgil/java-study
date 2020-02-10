package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num,i;
		int sum=0;
		while (true) {
			System.out.print("숫자를 입력하세요: ");
			num=scanner.nextInt();
			
			if(num%2==0) {
				for(i=0;i<=num;i++) {
					if(i%2==0) {
						sum= sum+i;
					}
				}
				
			}
			else {
				for(i=0;i<=num;i++) {
					if(i%2==1) {
						sum= sum+i;
					}
				}
			}
			
			System.out.println("결과값:"+sum);
			sum=0;
			
		}
		
	}
}
