package chapter03;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int a,b;
		int result;
		int[] array= new int[9];
		int answer;
		Scanner s= new Scanner(System.in);
		a=r.nextInt(9)+1;
		b=r.nextInt(9)+1;
		
		result= a*b;
		
		System.out.println(a+" X "+ b+"= ?");
		
		setArray(array);
		
		array[r.nextInt(9)]= result;
		
		for(int i=0;i<array.length;i+=3) {
			
				System.out.println(array[i]+"  "+ array[i+1]+"   "+array[i+2]);
			}
			boolean e=true;
			while(true) {
			
				System.out.println("answer :");
				answer=s.nextInt();
				
				for(int i=0; i<array.length;i++) {
					if(array[i]==answer) {
						e=false;
					}

				}
				if(!e)
					break;
			
				System.out.println("보기에 있는 답만 입력해주세요");
			}
			
		

		System.out.println((answer==result)?"정답":"오답");
	}

	static void setArray(int[] array) {
		Random r = new Random();
		
		for(int i=0; i<array.length;i++) {
			
			array[i]=r.nextInt(81)+1;
		
		}
		
		
	}
}
	



