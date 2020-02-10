package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Date now = new Date();// 현재날짜가 저장됨. util import 해야함 
			Date now1= new Date(2019,12,12); //날짜를 세팅해주는 소스지만 가능하면 쓰지 않는게 좋다. 
			
			System.out.println(now);
			
			printDate1(now);
			pirntDate2(now);
			
	}
	private static void pirntDate2(Date d) {
		// 년도(+1900)
		int year = d.getYear();
		
		// 월 (0~11)까지라 +1을 해줘야함 
		int month = d.getMonth();
		
		//일
		int date = d.getDate();
		
		//시 
		int hours = d.getHours();
		
		// 분
		int minutes=d.getMinutes();
		
		//초 
		
		int seconds = d.getSeconds();
		
		System.out.println((year+1900) + "-"+ (month+1)+"-"+date+" "+hours+":"+minutes+":"+seconds);
	}
	public static void printDate1(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String date= sdf.format(d);
		System.out.println(date);
	}
}
