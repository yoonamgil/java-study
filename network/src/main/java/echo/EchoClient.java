package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=5005;
	
	
	public static void main(String[] args) {
		Scanner scanner = null; 
		Socket socket=null;
		
		try {
			//1. 스캐너 
			scanner = new Scanner(System.in);
			
			
			//2. 소켓 생성 
			
			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			log("[client] connected");
			
			//3. IOstream 
			
			  InputStream is = socket.getInputStream();
			  InputStreamReader isr = new InputStreamReader(is,"utf-8"); // byte -> char 
			  BufferedReader br = new BufferedReader(isr); // char- > 체인 보조 스트림으로 만들어 성능을 향상시킨다. 
			  
			 // OutputStream os= socket.getOutputStream();
			   PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);// true 를 안하면 버퍼가 완전히 차지 않으면 바로 가지 않는다. 
			
			//4. 쓰기 
			
			
			
			while(true) {
				System.out.print(">>");
				String line =scanner.nextLine();
				
				if("quit".equals(line)){
					break;
				}	
				// 6. 데이터쓰기
				pw.println(line);
				
				//7. 데이터 읽기 
				
				String data = br.readLine();
				
				if(data ==null) {
					log("closed by Server");
					break;
				}
				System.out.println("<<"+data);
			}
			
		}catch(IOException e){
			

	      }finally {
				try {
					if(scanner != null){
						scanner.close();
					}
					
					if(socket != null && !socket.isClosed()){ 
						socket.close();
					}
						
			    }catch(IOException e) {
						e.printStackTrace();
		
				}
			}	
	
	}	
	
	
			public static void log(String log) {
				System.out.println("[Client]"+log);
			}
			
}
