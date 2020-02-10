package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EchoServer {
	private static final int PORT=5005;
	static ConcurrentHashMap<String,PrintWriter> writerArray=new ConcurrentHashMap<>();
	static List<String> nameList= new ArrayList<>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		
		try {
		 // 1. 서버 소켓 생성	
		 serverSocket= new ServerSocket();
		 // 2. 바인딩(Socket Address(IP Address+ port) Binding)
		 serverSocket.bind(new InetSocketAddress("127.0.0.1",PORT));
		 log("Server Start...[port:"+ PORT + "]");
		 
		
				//1. 서버소켓 생성
				
				//3. accept
				while(true) {
					Socket socket = serverSocket.accept();
					//socketArray.add(socket);
//					InputStream is = socket.getInputStream();
//					InputStreamReader isr = new InputStreamReader(is,"utf-8"); // byte -> char 
					//BufferedReader nickNameCheck = new BufferedReader(isr); 
//					PrintWriter	pw = new PrintWriter(
//							new OutputStreamWriter(
//									socket.getOutputStream(), StandardCharsets.UTF_8), true);
//				
//					int size= nameList.size();
//					pw.println(Integer.toString(size));
//					for(int i=0;i<size;i++) {
//						pw.println(nameList.get(i));
//					}
					
//					String name=nickNameCheck.readLine();
//					nameList.add(name.trim());
					
					
					new EchoServerReceiveThread(socket,writerArray,nameList).start();
				
					
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(serverSocket != null && !serverSocket.isClosed()) {
						serverSocket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		

	}
	
	public static void log(String log) {
		System.out.println("[Server#+"+Thread.currentThread().getId()+"]"+log);
	}

}
