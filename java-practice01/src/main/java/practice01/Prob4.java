package practice01;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		System.out.print("문자열을 입력하세요 : ");
		str=scanner.nextLine();
		int cnt=0;
		for(int i=0;i<=str.length();i++) {
			for(int j=0; j<cnt;j++) {
				System.out.print(str.charAt(j));
			}
			System.out.println();
			cnt++;
		}
		
		
		//str.charAt(arg0)
		/*
		 * 코드 작성합니다.
		 */
		
		scanner.close();
	}

}
