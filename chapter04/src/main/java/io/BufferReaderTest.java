package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {

	public static void main(String[] args) {
		// 기반스트림 
		BufferedReader br = null; 
		try {
			FileReader fr =new FileReader("./src/io/BufferReaderTest.java");
			// 보조 스트림 
			br = new BufferedReader(fr);
			String line = null;
			int index= 0;
			while((line = br.readLine()) != null) {
					System.out.println(line);
					index++;
					System.out.println(index+":"+line);
					
			}
			
		} 
			
		catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}catch(IOException e) {
			
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				
			}
		}

	}

}
