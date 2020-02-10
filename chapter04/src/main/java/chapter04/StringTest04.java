package chapter04;

public class StringTest04 {

	public static void main(String[] args) {
		
		String s = "aBcABCabcAbc";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc")); //문자열의 첫번째가 어디로 나오는지 
		System.out.println(s.indexOf("abc",3)); // 3번째 이후 부터 찾아라라는 메소드 
		System.out.println(s.indexOf("ABc")); // 문자열이 존재하지 않는 경우 -1을 리턴한다. 
		System.out.println(s.indexOf("abc",7));// 문자열이 존재하지 않는 경우 -1을 리턴한다. 
		System.out.println(s.substring(3)); //3번째부터 시작
		System.out.println(s.substring(3,5));// 3번째부터 4번째 까지 출력 
		
		String s2 = "       ab cd    ";
		
		String s3= "dfg,hijk,lmno,pq";
		
		String s4=s2.concat(s3);
		System.out.println(s4);
		System.out.println("----"+s2.trim()+"-------"); // 양옆의 공백을 삭제시키는 메소드 예를 들어 회원가입할때 양옆의 공백을 미연에 방지한다. 
		System.out.println("-----"+s2.replaceAll(" ", "")+"-------");// " " -> ""로 바꾼다. 
		
		String[] token = s3.split(",");// ","문자를 기준으로 문자열을 잘라서 배열로! 저장시킨다.  쪼갤문자가 일치하지 않더라면 통문자가 첫번째 배열에 저장된다.
		for(String str : token) {
			System.out.println(str);
		}
		
		//String str = "Hello"+"World"+"java"+ 1000; 
		
		String str = new StringBuffer("Hello").append("World").append("java").append(10000).toString(); // 위의 소스를 풀어서 알려준다.
		System.out.println(""); 
		
		// 주의 : + 문자열 연산 
		String str2="";
		StringBuffer sb = new StringBuffer("");
		for(int i = 0 ; i<100000000; i++) {
			///str2+=i; // new를 만번시킨다. cpu과부화의 원인 좋지 않은 소스 
			sb.append('c');
		}
			System.out.println(sb.length());
		
			
			String name = "둘리";
			int score = 100;
			
			System.out.println(name + "님의 점수는 "+ score+"점 입니다.");
			
			
			String str3 = String.format("둘리님의 점수는 %d 점입니다.",score);
			System.out.format(str3);
			
			
			
			
	}
	
	

}
