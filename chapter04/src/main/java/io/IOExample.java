package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOExample {

	public static void main(String[] args) throws IOException {
		
		byte[] src = {1,2,3,4};
		byte[] dest = null;
		InputStream is = new ByteArrayInputStream(src);

		OutputStream os = new ByteArrayOutputStream();
		
		int data= -1; // byte 단위로 읽지만 자료형은 int로 
		while((data= is.read())!= -1) {
			os.write(data);
		}
		
		dest =((ByteArrayOutputStream)os).toByteArray();
		
		System.out.println(src);
		System.out.println(dest);
	}

}
