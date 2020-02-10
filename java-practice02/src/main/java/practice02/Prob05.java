package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {


	public static void main(String[] args) {

		Random r = new Random();
		int k= r.nextInt(100)+1;
		int num;
		Scanner scanner= new Scanner(System.in);
		int max=100; 
		int min= 1; 
		int cnt=1;
		System.out.println("수를 결정하였습니다 맞춰보세요");
		while(true) {
			
			System.out.println(min+"-"+max);
			System.out.println(cnt +">>");
			cnt++;
			num=scanner.nextInt();
			if(num== k) {
				System.out.println("맞았습니다 ");
				System.out.println("다시하시겠습니까(y/n)>> ");
				String answer=scanner.next();
				
				if(answer.equals("y")) {
					
					k= r.nextInt(100)+1;
					cnt=1; 
					max=100;
					min=1;
				}
				else {
					break; 
				}
					
			}
			else if(num>k){
				System.out.println("더낮게");
				max=num;
			}
			else{
				System.out.println("더 높게");
				min=num;
			}
			
			
		}
		scanner.close();
	}
}
