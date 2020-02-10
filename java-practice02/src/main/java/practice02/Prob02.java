package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		int num;
		double sum= 0; 
		double avr;
		System.out.println("5개의 숫자를 입력하세요.");

		for(int i=0; i<intArray.length;i++) {
			num= scanner.nextInt();
			sum= sum+ num;
		}
		
		avr= sum/intArray.length;
		
		System.out.println("평균은"+avr+"입니다");	
		
	}

}
