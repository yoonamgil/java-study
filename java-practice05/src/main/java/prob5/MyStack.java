package prob5;

import java.io.IOException;

public class MyStack {
	private int top=-1;
	private int a;
	public String[] getBuffer() {
		return buffer;
	}


	public void setBuffer(String[] buffer) {
		this.buffer = buffer;
	}

	private String[] buffer;

	
	public MyStack(int a) {
		this.buffer = new String[this.a=a];
	}

	
	public void push(String str) {
		
		if(top==(buffer.length-1)) {
			String[] buffer1= new String[buffer.length*2];
			for(int i=0;i<this.buffer.length;i++) {
				buffer1[i]= this.buffer[i];
			}
			
			buffer=buffer1;
			
			this.buffer[++top]= str;
		}
		else {	
			this.buffer[++top]= str;
		}
		
		
	}
	public boolean isEmpty() {
		if(top==-1)
			return true;
			
		return false;
	}
	
	public String pop() throws MyException{
		if(isEmpty()) {
			throw new MyException();
		}
		
		
		String str=buffer[top--];
		buffer[top+1]=null;
	
		return str;
	}
}