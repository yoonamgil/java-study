package chapter04;

import java.util.Calendar;

public class calendarTest {

	public static void main(String[] args) {
		
	
		
		Calendar cal1=Calendar.getInstance(); // 팩토리 메소드 -> 인스턴스를 찍어서 만들어준다. 
		printDate(cal1);
		// final 은 변수에 붇으면 상수이고 메소드에 붙으면 오버라이드 금지이다.
		
		
		cal1.set(Calendar.YEAR,2020);
		cal1.set(Calendar.MONTH,11);
		cal1.set(Calendar.DATE,25);
		cal1.set(Calendar.HOUR,20);
		cal1.set(Calendar.MONTH,11);
		
		cal1.set(2017,9,28);
		cal1.add(Calendar.DATE,1);
		printDate(cal1);
		
		
	}

	private static void printDate(Calendar cal) {
		String[] days= {"일","월","화","수","목","금","토"};
		
		//년도 
		int year = cal.get(Calendar.YEAR);
		// 월
		int month = cal.get(Calendar.MONTH);
		//일
		int date= cal.get(Calendar.DATE);
		
		// 요일 
		int day= cal.get(Calendar.DAY_OF_WEEK);//1~7까지 나옴 1이 일요일임 
		
		//시간
		int hours=cal.get(Calendar.HOUR);
		
		//분
		int minutes= cal.get(Calendar.MINUTE);
		
		//초
		int second = cal.get(Calendar.SECOND);
		
		
		System.out.println(
				year+"년"+
				(month)+"월"+
				date+"일"+
				days[day-1]+"요일"+
				hours+"시"+
				minutes+"분"+
				second+"초");
	}

}
