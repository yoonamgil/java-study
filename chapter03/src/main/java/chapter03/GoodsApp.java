package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		
		Goods goods = new Goods();
		
		goods.name= "nikon";
		goods.countSold=100;
		goods.countStock=50;
		goods.price= 100000; 
		
		System.out.println(goods.name + ":"+ goods.price+ ":" + goods.countSold+":"
				+goods.countStock);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
	}

}
