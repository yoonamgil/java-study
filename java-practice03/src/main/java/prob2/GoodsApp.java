package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		for(int i=0;i<goods.length;i++) {
			goods[i] = new Goods();
			System.out.println("이름을 입력하세요: "); 
			String str= scanner.next();
			goods[i].setName(str);
			System.out.println("금액을 입력하세요: ");
			int price =scanner.nextInt();
			goods[i].setPrice(price);
			System.out.println("입고 숫자를 입력하세요: "); 
			int count=scanner.nextInt();
			goods[i].setCount(count);
			
		}
		
		
		for(int j=0; j<goods.length;j++) {
			System.out.println(goods[j].getName()+"(가격 : "+ goods[j].getPrice()+"원)이 "+ goods[j].getCount()+"개 입고 되었습니다");
		}
		
		scanner.close();
	}
}
