package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in =null;
		FileInputStream is= null;
		
			
				try {
					in =new FileReader("1234.txt");
					
					int count = 0;
					int data= -1; // byte 단위로 읽지만 자료형은 int로 
					while((data= in.read())!= -1) {
						System.out.print((char)data);
						count ++;
					}
					System.out.println("");
					System.out.println("count"+ count);
					System.out.println("=============");
					count= 0;
					data= -1; 
					is = new FileInputStream("1234.txt");
					
					while((data= is.read())!= -1) {
						System.out.print((char)data);
						count ++;
					}
					System.out.println("");
					System.out.println("count"+ count);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(IOException e) {
					
				}finally {
						try {	
							if(in != null) {
							in.close();}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

	}


