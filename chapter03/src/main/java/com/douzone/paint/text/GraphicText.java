package com.douzone.paint.text;

import com.douzone.paint.i.Drawable;

public class GraphicText implements Drawable {

	private String text; 
	
	public GraphicText(String text){
		this.text=text;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("v텍스트를"+text+"를 그렸습니다");
	}

}
