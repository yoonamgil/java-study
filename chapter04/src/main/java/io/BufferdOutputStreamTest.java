package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos= null;
		try {
			FileOutputStream fis = new FileOutputStream("test.txt");
			// 보조 스트림(기반 스트림 또는 보조스트림에 연결)
			bos= new BufferedOutputStream(fis); 
			
			
			for(int i = 'a'; i<='z';i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열수 없습니다."+e);
		}catch(IOException e){
			
		}
		finally {
			try {
			if(bos !=null) {
				bos.close();
				}
			}
			catch(IOException e) {
				
			}
		}
		

	}

}
