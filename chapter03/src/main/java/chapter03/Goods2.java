package chapter03;

public class Goods2 {
	private String name;
	private int price ;
	private int countSold;
	private int countStock;
	
	
	public Goods2() {
		
	}
	
	public Goods2(String name, int price , int countSold, int countStock) {
		this.name = name;
		this.price= price;
		this.countSold= countSold;
		this.countStock=countStock;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	
	public void showInfo() {
		System.out.println(name + ":" + price + ":" + countStock + ":" + countSold);
		
	}
	
	//TDD
	public int calcDiscountPrice(double d) {
		
		return (int)(price -price*d); // 큰 자료에서 작은자료로 갈때 타입변환을 해줘야 한다. 
	}
	
}
