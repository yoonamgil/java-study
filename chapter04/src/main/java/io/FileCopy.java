package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			InputStream is = null;
			OutputStream os = null;
		
		try {
			is= new FileInputStream("유남길.jpg");
			os= new FileOutputStream("유남길.copy.jpg");
			int data= -1; // byte 단위로 읽지만 자료형은 int로 
			while((data= is.read())!= -1) {
				os.write(data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다."+ e);
		}catch(IOException e) {
			System.out.println("에러 -"+ e);
		}
		finally {
			try {
				if(is !=null)
					is.close();
				if(is !=null)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
